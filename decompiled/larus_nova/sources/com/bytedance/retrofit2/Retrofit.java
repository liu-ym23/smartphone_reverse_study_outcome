package com.bytedance.retrofit2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Retrofit {

    @Nullable
    private static volatile CopyOnWriteArrayList<Interceptor> sCommonInterceptors;

    @Nullable
    private final ICacheServer cacheServer;
    private final List<CallAdapter.Factory> callAdapterFactories;
    private final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    private final List<Converter.Factory> converterFactories;
    private final Executor httpExecutor;
    private final List<Interceptor> interceptors;
    private final Endpoint server;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache;
    private final ConcurrentHashMap<Method, Object> serviceMethodCacheNew;
    private final boolean validateEagerly;

    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Nullable
        private ICacheServer cacheServer;
        private final List<CallAdapter.Factory> callAdapterFactories;

        @Nullable
        private Executor callbackExecutor;

        @Nullable
        private Client.Provider clientProvider;
        private final List<Converter.Factory> converterFactories;

        @Nullable
        private Endpoint endpoint;

        @Nullable
        private Executor httpExecutor;
        private final List<Interceptor> interceptors;
        private final Platform platform;
        private boolean validateEagerly;

        public Retrofit build() {
            if (this.endpoint == null) goto L26;
            if (this.clientProvider == null) goto L24;
            if (this.httpExecutor == null) goto L22;
            Executor r100 = this.callbackExecutor;
            if (r100 != null) goto L11;
            r100 = this.platform.defaultCallbackExecutor();
        L11:
            Executor r101 = r100;
            ArrayList r102 = new ArrayList(this.callAdapterFactories);
            r102.addAll(this.platform.defaultCallAdapterFactories(r101));
            ArrayList r103 = new ArrayList((this.converterFactories.size() + 1) + this.platform.defaultConverterFactoriesSize());
            r103.add(new BuiltInConverters());
            r103.addAll(this.converterFactories);
            r103.addAll(this.platform.defaultConverterFactories());
            if (Retrofit.access$900() == null) goto L20;
            Iterator r104 = Retrofit.access$900().iterator();
        L15:
            if (r104.hasNext() == false) goto L20;
            Interceptor r105 = (Interceptor) r104.next();
            if (this.interceptors.contains(r105) == true) goto L15;
            this.interceptors.add(r105);
        L20:
            return new Retrofit(this.endpoint, this.clientProvider, this.interceptors, r103, r102, this.httpExecutor, r101, this.validateEagerly, this.cacheServer);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public Builder() {
            this(Platform.get());
        }

        static {
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder(Retrofit r100) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = Platform.get();
            this.clientProvider = Retrofit.access$000(r100);
            this.endpoint = Retrofit.access$100(r100);
            int r101 = 1;
            int r102 = 1;
        L4:
            if (r102 >= (Retrofit.access$200(r100).size() - this.platform.defaultConverterFactoriesSize())) goto L6;
            this.interceptors.add((Interceptor) ListProtector.get(Retrofit.access$200(r100), r102));
            r102 = r102 + 1;
            goto L4
        L6:
            int r103 = Retrofit.access$300(r100).size() - this.platform.defaultConverterFactoriesSize();
        L7:
            if (r101 >= r103) goto L9;
            this.converterFactories.add((Converter.Factory) ListProtector.get(Retrofit.access$300(r100), r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r104 = Retrofit.access$400(r100).size() - this.platform.defaultCallAdapterFactoriesSize();
            int r105 = 0;
        L10:
            if (r105 >= r104) goto L12;
            this.callAdapterFactories.add((CallAdapter.Factory) ListProtector.get(Retrofit.access$400(r100), r105));
            r105 = r105 + 1;
            goto L10
        L12:
            this.httpExecutor = Retrofit.access$500(r100);
            this.callbackExecutor = Retrofit.access$600(r100);
            this.validateEagerly = Retrofit.access$700(r100);
            this.cacheServer = Retrofit.access$800(r100);
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r100) {
            this.callAdapterFactories.add((CallAdapter.Factory) Utils.checkNotNull(r100, "factory == null"));
            return this;
        }

        public Builder addConverterFactory(Converter.Factory r100) {
            this.converterFactories.add((Converter.Factory) Utils.checkNotNull(r100, "factory == null"));
            return this;
        }

        public Builder addInterceptor(Interceptor r100) {
            Interceptor r101 = (Interceptor) Utils.checkNotNull(r100, "interceptor == null");
            this.interceptors.add(r101);
            return this;
        }

        public Builder cacheServer(ICacheServer r100) {
            this.cacheServer = r100;
            return this;
        }

        public Builder callbackExecutor(Executor r100) {
            this.callbackExecutor = (Executor) Utils.checkNotNull(r100, "executor == null");
            return this;
        }

        public Builder client(Client.Provider r100) {
            return provider((Client.Provider) Utils.checkNotNull(r100, "provider == null"));
        }

        public Builder httpExecutor(Executor r100) {
            this.httpExecutor = (Executor) Utils.checkNotNull(r100, "httpExecutor == null");
            return this;
        }

        public Builder provider(Client.Provider r100) {
            this.clientProvider = (Client.Provider) Utils.checkNotNull(r100, "provider == null");
            return this;
        }

        public Builder removeInterceptor(Interceptor r100) {
            Interceptor r101 = (Interceptor) Utils.checkNotNull(r100, "interceptor == null");
            this.interceptors.remove(r101);
            return this;
        }

        public Builder setEndpoint(String r100) {
            if (r100 == null) goto L8;
            if (r100.trim().length() == 0) goto L8;
            this.endpoint = Endpoints.newFixedEndpoint(r100);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }

        public Builder validateEagerly(boolean r100) {
            this.validateEagerly = r100;
            return this;
        }

        public Builder(Platform r100) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = r100;
        }

        public Builder setEndpoint(Endpoint r100) {
            if (r100 == null) goto L6;
            this.endpoint = r100;
            return this;
        L6:
            throw new NullPointerException("Endpoint may not be null.");
        }
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static /* synthetic */ CopyOnWriteArrayList access$900() {
        return sCommonInterceptors;
    }

    @Nullable
    public ICacheServer cacheServer() {
        return this.cacheServer;
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public Client.Provider clientProvider() {
        return this.clientProvider;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public Executor httpExecutor() {
        return this.httpExecutor;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public Endpoint server() {
        return this.server;
    }

    public static /* synthetic */ Client.Provider access$000(Retrofit r100) {
        return r100.clientProvider;
    }

    public static /* synthetic */ Endpoint access$100(Retrofit r100) {
        return r100.server;
    }

    public static /* synthetic */ List access$200(Retrofit r100) {
        return r100.interceptors;
    }

    public static /* synthetic */ List access$300(Retrofit r100) {
        return r100.converterFactories;
    }

    public static /* synthetic */ List access$400(Retrofit r100) {
        return r100.callAdapterFactories;
    }

    public static /* synthetic */ Executor access$500(Retrofit r100) {
        return r100.httpExecutor;
    }

    public static /* synthetic */ Executor access$600(Retrofit r100) {
        return r100.callbackExecutor;
    }

    public static /* synthetic */ boolean access$700(Retrofit r100) {
        return r100.validateEagerly;
    }

    public static /* synthetic */ ICacheServer access$800(Retrofit r100) {
        return r100.cacheServer;
    }

    private void eagerlyValidateMethods(Class<?> r100) {
        Platform r101 = Platform.get();
        Method[] r102 = r100.getDeclaredMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        Method r105 = r102[r104];
        if (r101.isDefaultMethod(r105) == true) goto L9;
        if (Modifier.isStatic(r105.getModifiers()) == true) goto L9;
        loadServiceMethod(r105);
    L9:
        r104 = r104 + 1;
        goto L3
    }

    public static void setCommonInterceptor(CopyOnWriteArrayList<Interceptor> r100) {
        sCommonInterceptors = r100;
    }

    public <T> T create(final Class<T> r100) {
        Utils.validateServiceInterface(r100);
        if (this.validateEagerly == false) goto L6;
        eagerlyValidateMethods(r100);
    L6:
        return (T) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new AnonymousClass1(this, r100));
    }

    public ServiceMethod<?> loadServiceMethod(Method r100) {
        if (RetrofitConfig.isLoadServiceMethodOptOpen() == true) goto L5;
        ServiceMethod<?> r101 = this.serviceMethodCache.get(r100);
        if (r101 != null) goto L9;
        Map<Method, ServiceMethod<?>> r102 = this.serviceMethodCache;
        monitor-enter(r102);
        ServiceMethod<?> r103 = this.serviceMethodCache.get(r100);     // Catch: Throwable -> L19
        if (r103 != null) goto L17;
        RetrofitMetrics r104 = new RetrofitMetrics();     // Catch: Throwable -> L19
        r104.bizInvokeRetrofitRequestInterfaceStart(false);     // Catch: Throwable -> L19
        r103 = ServiceMethod.parseAnnotations(this, r100, r104);     // Catch: Throwable -> L19
        this.serviceMethodCache.put(r100, r103);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r103;
    L19:
        th = move-exception;
        throw th;
    L9:
        if ((r101 instanceof HttpServiceMethod) == false) goto L11;
        RetrofitMetrics r105 = new RetrofitMetrics();
        r105.bizInvokeRetrofitRequestInterfaceStart(true);
        ((HttpServiceMethod) r101).requestFactory.setRetrofitMetrics(r105);
    L11:
        return r101;
    L5:
        return loadServiceMethodNew(r100);
    }

    public ServiceMethod<?> loadServiceMethodNew(Method r100) {
        Object r101 = this.serviceMethodCacheNew.get(r100);
        if ((r101 instanceof ServiceMethod) == true) goto L5;
        if (r101 != null) goto L22;
        Object r102 = new Object();
        monitor-enter(r102);
        r101 = this.serviceMethodCacheNew.putIfAbsent(r100, r102);     // Catch: Throwable -> L19
        if (r101 != null) goto L17;
        RetrofitMetrics r103 = new RetrofitMetrics();     // Catch: Throwable -> L19
        r103.bizInvokeRetrofitRequestInterfaceStart(false);     // Catch: Throwable -> L19
        ServiceMethod<?> r104 = ServiceMethod.parseAnnotations(this, r100, r103);     // Catch: Throwable -> L19
        this.serviceMethodCacheNew.put(r100, r104);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r104;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r101);
        ServiceMethod<?> r105 = (ServiceMethod) this.serviceMethodCacheNew.get(r100);     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        return r105;
    L26:
        th = move-exception;
        throw th;
    L5:
        if ((r101 instanceof HttpServiceMethod) == false) goto L8;
        RetrofitMetrics r106 = new RetrofitMetrics();
        r106.bizInvokeRetrofitRequestInterfaceStart(true);
        ((HttpServiceMethod) r101).requestFactory.setRetrofitMetrics(r106);
    L8:
        return (ServiceMethod) r101;
    }

    public CallAdapter<?, ?> callAdapter(Type r100, Annotation[] r101) {
        return nextCallAdapter(null, r100, r101);
    }

    public <T> Converter<T, Header> headerConverter(Type r100, Annotation[] r101) {
        Utils.checkNotNull(r100, "type == null");
        Utils.checkNotNull(r101, "annotations == null");
        int r102 = this.converterFactories.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Converter<T, Header> r104 = (Converter<T, Header>) ((Converter.Factory) ListProtector.get(this.converterFactories, r103)).headerConverter(r100, r101, this);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public <T> Converter<T, Object> objectConverter(Type r100, Annotation[] r101) {
        Utils.checkNotNull(r100, "type == null");
        Utils.checkNotNull(r101, "annotations == null");
        int r102 = this.converterFactories.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Converter<T, Object> r104 = (Converter<T, Object>) ((Converter.Factory) ListProtector.get(this.converterFactories, r103)).objectConverter(r100, r101, this);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> Converter<TypedInput, T> responseBodyConverter(Type r100, Annotation[] r101) {
        return nextResponseBodyConverter(null, r100, r101);
    }

    public <T> Converter<T, String> stringConverter(Type r100, Annotation[] r101) {
        Utils.checkNotNull(r100, "type == null");
        Utils.checkNotNull(r101, "annotations == null");
        int r102 = this.converterFactories.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Converter<T, String> r104 = (Converter<T, String>) ((Converter.Factory) ListProtector.get(this.converterFactories, r103)).stringConverter(r100, r101, this);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory r100, Type r101, Annotation[] r102) {
        Utils.checkNotNull(r101, "returnType == null");
        Utils.checkNotNull(r102, "annotations == null");
        int r103 = this.callAdapterFactories.indexOf(r100) + 1;
        int r104 = this.callAdapterFactories.size();
        int r105 = r103;
    L3:
        if (r105 >= r104) goto L8;
        CallAdapter<?, ?> r106 = ((CallAdapter.Factory) ListProtector.get(this.callAdapterFactories, r105)).get(r101, r102, this);
        if (r106 != null) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return r106;
    L8:
        StringBuilder r107 = new StringBuilder("Could not locate call adapter for ");
        r107.append(r101);
        r107.append(".\n");
        if (r100 == null) goto L14;
        r107.append("  Skipped:");
        int r108 = 0;
    L11:
        if (r108 >= r103) goto L13;
        r107.append("\n   * ");
        r107.append(((CallAdapter.Factory) ListProtector.get(this.callAdapterFactories, r108)).getClass().getName());
        r108 = r108 + 1;
        goto L11
    L13:
        r107.append('\n');
    L14:
        r107.append("  Tried:");
        int r109 = this.callAdapterFactories.size();
    L15:
        if (r103 >= r109) goto L18;
        r107.append("\n   * ");
        r107.append(((CallAdapter.Factory) ListProtector.get(this.callAdapterFactories, r103)).getClass().getName());
        r103 = r103 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r107.toString());
    }

    public <T> Converter<TypedInput, T> nextResponseBodyConverter(@Nullable Converter.Factory r100, Type r101, Annotation[] r102) {
        Utils.checkNotNull(r101, "type == null");
        Utils.checkNotNull(r102, "annotations == null");
        int r103 = this.converterFactories.indexOf(r100) + 1;
        int r104 = this.converterFactories.size();
        int r105 = r103;
    L3:
        if (r105 >= r104) goto L8;
        Converter<TypedInput, T> r106 = (Converter<TypedInput, T>) ((Converter.Factory) ListProtector.get(this.converterFactories, r105)).responseBodyConverter(r101, r102, this);
        if (r106 != null) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return r106;
    L8:
        StringBuilder r107 = new StringBuilder("Could not locate TypedInput converter for ");
        r107.append(r101);
        r107.append(".\n");
        if (r100 == null) goto L14;
        r107.append("  Skipped:");
        int r108 = 0;
    L11:
        if (r108 >= r103) goto L13;
        r107.append("\n   * ");
        r107.append(((Converter.Factory) ListProtector.get(this.converterFactories, r108)).getClass().getName());
        r108 = r108 + 1;
        goto L11
    L13:
        r107.append('\n');
    L14:
        r107.append("  Tried:");
        int r109 = this.converterFactories.size();
    L15:
        if (r103 >= r109) goto L18;
        r107.append("\n   * ");
        r107.append(((Converter.Factory) ListProtector.get(this.converterFactories, r103)).getClass().getName());
        r103 = r103 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r107.toString());
    }

    public <T> Converter<T, TypedOutput> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102) {
        return nextRequestBodyConverter(null, r100, r101, r102);
    }

    public <T> Converter<T, TypedOutput> nextRequestBodyConverter(@Nullable Converter.Factory r100, Type r101, Annotation[] r102, Annotation[] r103) {
        Utils.checkNotNull(r101, "type == null");
        Utils.checkNotNull(r102, "parameterAnnotations == null");
        Utils.checkNotNull(r103, "methodAnnotations == null");
        int r104 = this.converterFactories.indexOf(r100) + 1;
        int r105 = this.converterFactories.size();
        int r106 = r104;
    L3:
        if (r106 >= r105) goto L8;
        Converter<T, TypedOutput> r107 = (Converter<T, TypedOutput>) ((Converter.Factory) ListProtector.get(this.converterFactories, r106)).requestBodyConverter(r101, r102, r103, this);
        if (r107 != null) goto L6;
        r106 = r106 + 1;
        goto L3
    L6:
        return r107;
    L8:
        StringBuilder r108 = new StringBuilder("Could not locate RequestBody converter for ");
        r108.append(r101);
        r108.append(".\n");
        if (r100 == null) goto L14;
        r108.append("  Skipped:");
        int r109 = 0;
    L11:
        if (r109 >= r104) goto L13;
        r108.append("\n   * ");
        r108.append(((Converter.Factory) ListProtector.get(this.converterFactories, r109)).getClass().getName());
        r109 = r109 + 1;
        goto L11
    L13:
        r108.append('\n');
    L14:
        r108.append("  Tried:");
        int r110 = this.converterFactories.size();
    L15:
        if (r104 >= r110) goto L18;
        r108.append("\n   * ");
        r108.append(((Converter.Factory) ListProtector.get(this.converterFactories, r104)).getClass().getName());
        r104 = r104 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r108.toString());
    }

    public Retrofit(Endpoint r110, Client.Provider r111, List<Interceptor> r112, List<Converter.Factory> r113, List<CallAdapter.Factory> r114, Executor r115, Executor r116, boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, null);
    }

    public Retrofit(Endpoint r100, Client.Provider r101, List<Interceptor> r102, List<Converter.Factory> r103, List<CallAdapter.Factory> r104, Executor r105, Executor r106, boolean r107, @Nullable ICacheServer r110) {
        this.serviceMethodCache = new ConcurrentHashMap();
        this.serviceMethodCacheNew = new ConcurrentHashMap();
        this.server = r100;
        this.clientProvider = r101;
        this.interceptors = r102;
        this.converterFactories = Collections.unmodifiableList(r103);
        this.callAdapterFactories = Collections.unmodifiableList(r104);
        this.httpExecutor = r105;
        this.callbackExecutor = r106;
        this.validateEagerly = r107;
        this.cacheServer = r110;
    }
}
