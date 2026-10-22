package retrofit2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes41.dex */
public final class Retrofit {
    final HttpUrl baseUrl;
    final List<CallAdapter.Factory> callAdapterFactories;
    final okhttp3.Call.a callFactory;

    @Nullable
    final Executor callbackExecutor;
    final List<g.a> converterFactories;
    private final Map<Method, t<?>> serviceMethodCache;
    final boolean validateEagerly;

    /* JADX INFO: loaded from: classes.dex */
    public static final class Builder {

        @Nullable
        private HttpUrl baseUrl;
        private final List<CallAdapter.Factory> callAdapterFactories;

        @Nullable
        private okhttp3.Call.a callFactory;

        @Nullable
        private Executor callbackExecutor;
        private final List<g.a> converterFactories;
        private final q platform;
        private boolean validateEagerly;

        public Builder() {
            this(q.f537548a);
        }

        public Retrofit build() {
            if (this.baseUrl == null) goto L13;
            okhttp3.Call.a r100 = this.callFactory;
            if (r100 != null) goto L7;
            r100 = new OkHttpClient();
        L7:
            okhttp3.Call.a r101 = r100;
            Executor r102 = this.callbackExecutor;
            if (r102 != null) goto L10;
            r102 = this.platform.d();
        L10:
            Executor r103 = r102;
            ArrayList r104 = new ArrayList(this.callAdapterFactories);
            r104.addAll(this.platform.b(r103));
            ArrayList r105 = new ArrayList((this.converterFactories.size() + 1) + this.platform.f());
            r105.add(new retrofit2.a());
            r105.addAll(this.converterFactories);
            r105.addAll(this.platform.e());
            return new Retrofit(r101, this.baseUrl, Collections.unmodifiableList(r105), Collections.unmodifiableList(r104), r103, this.validateEagerly);
        L13:
            throw new IllegalStateException("Base URL required.");
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<g.a> converterFactories() {
            return this.converterFactories;
        }

        public Builder(Retrofit r100) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            q r101 = q.f537548a;
            this.platform = r101;
            this.callFactory = r100.callFactory;
            this.baseUrl = r100.baseUrl;
            int r102 = r100.converterFactories.size() - r101.f();
            int r103 = 1;
        L3:
            if (r103 >= r102) goto L5;
            this.converterFactories.add((g.a) ListProtector.get(r100.converterFactories, r103));
            r103 = r103 + 1;
            goto L3
        L5:
            int r104 = r100.callAdapterFactories.size() - this.platform.c();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L8;
            this.callAdapterFactories.add((CallAdapter.Factory) ListProtector.get(r100.callAdapterFactories, r105));
            r105 = r105 + 1;
            goto L6
        L8:
            this.callbackExecutor = r100.callbackExecutor;
            this.validateEagerly = r100.validateEagerly;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r100) {
            List<CallAdapter.Factory> r101 = this.callAdapterFactories;
            u.a(r100, "factory == null");
            r101.add(r100);
            return this;
        }

        public Builder addConverterFactory(g.a r100) {
            List<g.a> r101 = this.converterFactories;
            u.a(r100, "factory == null");
            r101.add(r100);
            return this;
        }

        public Builder baseUrl(HttpUrl r100) {
            u.a(r100, "baseUrl == null");
            List<String> r101 = r100.pathSegments();
            if ("".equals(ListProtector.get(r101, r101.size() - 1)) == false) goto L7;
            this.baseUrl = r100;
            return this;
        L7:
            throw new IllegalArgumentException("baseUrl must end in /: " + r100);
        }

        public Builder callFactory(okhttp3.Call.a r100) {
            u.a(r100, "factory == null");
            this.callFactory = r100;
            return this;
        }

        public Builder callbackExecutor(Executor r100) {
            u.a(r100, "executor == null");
            this.callbackExecutor = r100;
            return this;
        }

        public Builder client(OkHttpClient r100) {
            u.a(r100, "client == null");
            return callFactory(r100);
        }

        public Builder validateEagerly(boolean r100) {
            this.validateEagerly = r100;
            return this;
        }

        public Builder(q r100) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = r100;
        }

        public Builder baseUrl(String r100) {
            u.a(r100, "baseUrl == null");
            return baseUrl(HttpUrl.get(r100));
        }
    }

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f537468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object[] f537469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Class f537470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Retrofit f537471d;

        public a(Retrofit r100, Class r101) {
            this.f537471d = r100;
            this.f537470c = r101;
            this.f537468a = q.f537548a;
            this.f537469b = new Object[0];
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, @Nullable Object[] r102) throws Throwable {
            if (r101.getDeclaringClass() != Object.class) goto L7;
            return r101.invoke(this, r102);
        L7:
            if (this.f537468a.h(r101) == true) goto L9;
            t<?> r103 = this.f537471d.loadServiceMethod(r101);
            if (r102 != null) goto L15;
            r102 = this.f537469b;
        L15:
            return r103.a(r102);
        L9:
            return this.f537468a.g(r101, this.f537470c, r100, r102);
        }
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public okhttp3.Call.a callFactory() {
        return this.callFactory;
    }

    @Nullable
    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<g.a> converterFactories() {
        return this.converterFactories;
    }

    private void eagerlyValidateMethods(Class<?> r100) {
        q r101 = q.f537548a;
        Method[] r102 = r100.getDeclaredMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Method r105 = r102[r104];
        if (r101.h(r105) == true) goto L7;
        loadServiceMethod(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    }

    public <T> T create(Class<T> r100) {
        if (r100.isInterface() == false) goto L14;
        if (r100.getInterfaces().length > 0) goto L12;
        if (this.validateEagerly == false) goto L10;
        eagerlyValidateMethods(r100);
    L10:
        return (T) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new a(this, r100));
    L12:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L14:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public t<?> loadServiceMethod(Method r100) {
        t<?> r101 = this.serviceMethodCache.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Map<Method, t<?>> r102 = this.serviceMethodCache;
        monitor-enter(r102);
        t<?> r103 = this.serviceMethodCache.get(r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L10;
        r103 = t.b(this, r100);     // Catch: Throwable -> L12
        this.serviceMethodCache.put(r100, r103);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public CallAdapter<?, ?> callAdapter(Type r100, Annotation[] r101) {
        return nextCallAdapter(null, r100, r101);
    }

    public <T> g<ResponseBody, T> responseBodyConverter(Type r100, Annotation[] r101) {
        return nextResponseBodyConverter(null, r100, r101);
    }

    public <T> g<T, String> stringConverter(Type r100, Annotation[] r101) {
        u.a(r100, "type == null");
        u.a(r101, "annotations == null");
        int r102 = this.converterFactories.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        g<T, String> r104 = (g<T, String>) ((g.a) ListProtector.get(this.converterFactories, r103)).stringConverter(r100, r101, this);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return retrofit2.a.d.f537476a;
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory r100, Type r101, Annotation[] r102) {
        u.a(r101, "returnType == null");
        u.a(r102, "annotations == null");
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

    public <T> g<ResponseBody, T> nextResponseBodyConverter(@Nullable g.a r100, Type r101, Annotation[] r102) {
        u.a(r101, "type == null");
        u.a(r102, "annotations == null");
        int r103 = this.converterFactories.indexOf(r100) + 1;
        int r104 = this.converterFactories.size();
        int r105 = r103;
    L3:
        if (r105 >= r104) goto L8;
        g<ResponseBody, T> r106 = (g<ResponseBody, T>) ((g.a) ListProtector.get(this.converterFactories, r105)).responseBodyConverter(r101, r102, this);
        if (r106 != null) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return r106;
    L8:
        StringBuilder r107 = new StringBuilder("Could not locate ResponseBody converter for ");
        r107.append(r101);
        r107.append(".\n");
        if (r100 == null) goto L14;
        r107.append("  Skipped:");
        int r108 = 0;
    L11:
        if (r108 >= r103) goto L13;
        r107.append("\n   * ");
        r107.append(((g.a) ListProtector.get(this.converterFactories, r108)).getClass().getName());
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
        r107.append(((g.a) ListProtector.get(this.converterFactories, r103)).getClass().getName());
        r103 = r103 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r107.toString());
    }

    public <T> g<T, RequestBody> requestBodyConverter(Type r100, Annotation[] r101, Annotation[] r102) {
        return nextRequestBodyConverter(null, r100, r101, r102);
    }

    public <T> g<T, RequestBody> nextRequestBodyConverter(@Nullable g.a r100, Type r101, Annotation[] r102, Annotation[] r103) {
        u.a(r101, "type == null");
        u.a(r102, "parameterAnnotations == null");
        u.a(r103, "methodAnnotations == null");
        int r104 = this.converterFactories.indexOf(r100) + 1;
        int r105 = this.converterFactories.size();
        int r106 = r104;
    L3:
        if (r106 >= r105) goto L8;
        g<T, RequestBody> r107 = (g<T, RequestBody>) ((g.a) ListProtector.get(this.converterFactories, r106)).requestBodyConverter(r101, r102, r103, this);
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
        r108.append(((g.a) ListProtector.get(this.converterFactories, r109)).getClass().getName());
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
        r108.append(((g.a) ListProtector.get(this.converterFactories, r104)).getClass().getName());
        r104 = r104 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r108.toString());
    }

    public Retrofit(okhttp3.Call.a r100, HttpUrl r101, List<g.a> r102, List<CallAdapter.Factory> r103, @Nullable Executor r104, boolean r105) {
        this.serviceMethodCache = new ConcurrentHashMap();
        this.callFactory = r100;
        this.baseUrl = r101;
        this.converterFactories = r102;
        this.callAdapterFactories = r103;
        this.callbackExecutor = r104;
        this.validateEagerly = r105;
    }
}
