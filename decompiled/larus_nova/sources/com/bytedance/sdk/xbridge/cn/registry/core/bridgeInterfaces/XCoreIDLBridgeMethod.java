package com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces;

import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.XBridgeException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me7.f;
import me7.i;
import me7.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b5\u00106J/\u0010\f\u001a\u0004\u0018\u00018\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0002J\u0014\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\u001a\u0010\u0017\u001a\u00020\u00192\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0010\u0010\u0017\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cJ,\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\"\u001a\u00020\u0007J6\u0010&\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020\u00072\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J-\u0010+\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00028\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010*H&¢\u0006\u0004\b+\u0010,J.\u0010-\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020'2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010!\u001a\u00020 H\u0016J&\u00100\u001a\b\u0012\u0004\u0012\u00028\u00020*\"\b\b\u0002\u0010\u0004*\u00020\u00032\u0006\u0010/\u001a\u00020.2\u0006\u0010!\u001a\u00020 J\b\u00101\u001a\u00020\nH\u0016R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "INPUT", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "OUTPUT", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "", "", "", "dataSource", "", "enableProxyEnhancement", "createParamModelProxy", "(Ljava/util/Map;Z)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "Ljava/lang/reflect/Method;", e.f25671s, "getPropertyName", "isProperty", "Ljava/lang/Class;", "getParamsClazz", "", "list", "Lorg/json/JSONArray;", "toJSON", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "data", "Ljava/lang/Runnable;", "runnable", "", "runOnUIThread", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$a;", "callback", "msg", "onSuccess", "", "code", "onFailure", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeContext", "params", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "handle", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V", "realHandle", "Ljava/lang/ClassLoader;", "classLoader", "createCompletionBlockProxy", "canRunInBackground", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class XCoreIDLBridgeMethod<INPUT extends XBaseParamModel, OUTPUT extends XBaseResultModel> implements IDLXBridgeMethod {
    private final Handler handler;

    public static final class a implements CompletionBlock<OUTPUT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XCoreIDLBridgeMethod<INPUT, OUTPUT> f270085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f270086b;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
        public final void onRawSuccess(OUTPUT r100) {
            if (r100 == null) goto L5;
            Map<String, ? extends Object> r101 = r100.convert();
            if (r101 == null) goto L5;
        L6:
            this.f270086b.invoke(r101);
            return;
        L5:
            r101 = new LinkedHashMap();
            goto L6
        }

        public a(XCoreIDLBridgeMethod<INPUT, OUTPUT> r100, IDLXBridgeMethod.a r101) {
            this.f270085a = r100;
            this.f270086b = r101;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
        public final void onSuccess(OUTPUT r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            Map<String, ? extends Object> r102 = r100.convert();
            if (r102 != null) goto L5;
            r102 = new LinkedHashMap();
        L5:
            this.f270085a.onSuccess(this.f270086b, r102, r101);
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
        public final void onFailure(int r100, String r101, OUTPUT r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            if (r102 == null) goto L6;
            Map<String, ? extends Object> r103 = r102.convert();
            if (r103 == null) goto L6;
        L7:
            this.f270085a.onFailure(this.f270086b, r100, r101, r103);
            return;
        L6:
            r103 = new LinkedHashMap();
            goto L7
        }
    }

    public static final class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f270087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XCoreIDLBridgeMethod<INPUT, OUTPUT> f270088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f270089c;

        public b(boolean r100, XCoreIDLBridgeMethod<INPUT, OUTPUT> r101, Map<String, ? extends Object> r102) {
            this.f270087a = r100;
            this.f270088b = r101;
            this.f270089c = r102;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            Object r103 = null;
            if (r101.getName().equals("toJSON") == false) goto L49;
            Map<String, Object> r104 = this.f270089c;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L42
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L42
            LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));     // Catch: Throwable -> L42
            Iterator<T> r108 = r104.entrySet().iterator();     // Catch: Throwable -> L42
        L7:
            if (r108.hasNext() == false) goto L34;
            Object r109 = r108.next();     // Catch: Throwable -> L42
            Object r110 = ((Map.Entry) r109).getKey();     // Catch: Throwable -> L42
            Map.Entry r111 = (Map.Entry) r109;     // Catch: Throwable -> L42
            Object r112 = r111.getValue();     // Catch: Throwable -> L42
            boolean r113 = true;
            if ((r112 instanceof Long) == false) goto L11;
            boolean r114 = true;
        L12:
            if (r114 == false) goto L14;
            boolean r115 = true;
        L15:
            if (r115 == false) goto L17;
            boolean r116 = true;
        L18:
            if (r116 == true) goto L21;
            r113 = r112 instanceof Boolean;     // Catch: Throwable -> L42
        L21:
            if (r113 == false) goto L24;
            Object r117 = r111.getValue();     // Catch: Throwable -> L42
        L33:
            r107.put(r110, r117);     // Catch: Throwable -> L42
            goto L7
        L24:
            if ((r112 instanceof List) == false) goto L27;
            Object r118 = r111.getValue();     // Catch: Throwable -> L42
            Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.collections.List<*>");     // Catch: Throwable -> L42
            r117 = ne7.a.b((List) r118);     // Catch: Throwable -> L42
            goto L33
        L27:
            if ((r112 instanceof Map) == false) goto L30;
            Object r119 = r111.getValue();     // Catch: Throwable -> L42
            Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");     // Catch: Throwable -> L42
            r117 = ne7.a.c((Map) r119);     // Catch: Throwable -> L42
            goto L33
        L30:
            if ((r111.getValue() instanceof XBaseModel) == false) goto L32;
            Object r120 = r111.getValue();     // Catch: Throwable -> L42
            Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel");     // Catch: Throwable -> L42
            r117 = ((XBaseModel) r120).toJSON();     // Catch: Throwable -> L42
            goto L33
        L32:
            r117 = null;
            goto L33
        L17:
            r116 = r112 instanceof String;     // Catch: Throwable -> L42
            goto L18
        L14:
            r115 = r112 instanceof Double;     // Catch: Throwable -> L42
            goto L15
        L11:
            r114 = r112 instanceof Integer;     // Catch: Throwable -> L42
            goto L12
        L34:
            Iterator r121 = r107.entrySet().iterator();     // Catch: Throwable -> L42
        L36:
            if (r121.hasNext() == false) goto L40;
            Map.Entry r122 = (Map.Entry) r121.next();     // Catch: Throwable -> L42
            if (r122.getValue() == null) goto L36;
            r106.put((String) r122.getKey(), r122.getValue());     // Catch: Throwable -> L42
            goto L36
        L40:
            Object r123 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L42
        L44:
            JSONObject r124 = new JSONObject();
            if (Result.m9455isFailureimpl(r123) == true) goto L47;
            return r123;
        L47:
            return r124;
        L42:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L44
        L49:
            if (this.f270087a == false) goto L59;
            if (XCoreIDLBridgeMethod.access$isProperty(this.f270088b, r101) == true) goto L77;
            Map<String, Object> r126 = this.f270089c;     // Catch: Exception -> L60
            if (r102 != null) goto L56;
            r102 = new Object[0];     // Catch: Exception -> L60
        L56:
            r103 = r101.invoke(r126, Arrays.copyOf(r102, r102.length));     // Catch: Exception -> L60
        L78:
            return r103;
        L77:
            return this.f270089c.get(XCoreIDLBridgeMethod.access$getPropertyName(this.f270088b, r101));
        L59:
            return this.f270089c.get(XCoreIDLBridgeMethod.access$getPropertyName(this.f270088b, r101));
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    public abstract void handle(IBDXBridgeContext r100, INPUT r101, CompletionBlock<OUTPUT> r102);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    private final Class<?> getParamsClazz() {
        f r100 = o.f513548a.get(getClass());
        if (r100 == null) goto L5;
        Class<?> r101 = r100.f513524a;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r102 = id7.e.f489350a;
        if (id7.e.c(getClass()) != null) goto L11;
        Class<?>[] r103 = getClass().getDeclaredClasses();
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L13:
        boolean r107 = true;
        if (r106 >= r105) goto L22;
        Class<?> r108 = r103[r106];
        if (r108.getAnnotation(XBridgeParamModel.class) != null) goto L19;
        r107 = false;
    L19:
        if (r107 == false) goto L21;
        r104.add(r108);
    L21:
        r106 = r106 + 1;
        goto L13
    L22:
        boolean r109 = r104.isEmpty();
        ?? r110 = r104;
        if (r109 == false) goto L44;
        Class<? super Object> r111 = getClass().getSuperclass();
        if (r111 == null) goto L37;
        Class<?>[] r112 = r111.getDeclaredClasses();
        if (r112 == null) goto L37;
        ?? r113 = new ArrayList();
        int r114 = r112.length;
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L38;
        Class<?> r116 = r112[r115];
        if (r116.getAnnotation(XBridgeParamModel.class) == null) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L36;
        r113.add(r116);
    L36:
        r115 = r115 + 1;
        goto L29
    L33:
        r117 = false;
    L38:
        boolean r118 = r113.isEmpty();
        r110 = r113;
        if (r118 == false) goto L44;
        throw new IllegalStateException("Illegal class format, no param model is defined in class");
    L37:
        r113 = CollectionsKt.emptyList();
    L44:
        return (Class) CollectionsKt.first(r110);
    L11:
        return id7.e.c(getClass());
    L5:
        r101 = null;
        goto L6
    }

    public XCoreIDLBridgeMethod() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.InCompatible;
    }

    private final String getPropertyName(Method r100) {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r101 = o.f513548a;
        f r102 = o.f513548a.get(getClass());
        String r103 = null;
        if (r102 == null) goto L10;
        i r104 = r102.f513526c.f513529a.get(r100);
        if (r104 == null) goto L7;
        String r105 = r104.f513538b;
    L8:
        if (r105 == null) goto L10;
        return r105;
    L7:
        r105 = null;
    L10:
        XBridgeParamField r106 = (XBridgeParamField) r100.getAnnotation(XBridgeParamField.class);
        if (r106 == null) goto L13;
        r103 = r106.keyPath();
    L13:
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    }

    private final boolean isProperty(Method r100) {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r101 = o.f513548a;
        f r102 = o.f513548a.get(getClass());
        if (r102 == null) goto L7;
        return r102.f513526c.f513529a.containsKey(r100);
    L7:
        if (((XBridgeParamField) r100.getAnnotation(XBridgeParamField.class)) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final void runOnUIThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.handler.post(r100);
    }

    public final JSONArray toJSON(List<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        return ConvertUtils.listToJSON$default(ConvertUtils.INSTANCE, r100, 0, 2, null);
    }

    public final JSONObject toJSON(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        return ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r100, 0, 2, null);
    }

    public final JSONObject toJSON(XBaseModel r100) {
        if (r100 != null) goto L6;
        return new JSONObject();
    L6:
        return r100.toJSON();
    }

    public static final /* synthetic */ String access$getPropertyName(XCoreIDLBridgeMethod r100, Method r101) {
        return r100.getPropertyName(r101);
    }

    public static final /* synthetic */ boolean access$isProperty(XCoreIDLBridgeMethod r100, Method r101) {
        return r100.isProperty(r101);
    }

    private final INPUT createParamModelProxy(Map<String, ? extends Object> r100, boolean r101) throws IllegalStateException, XBridgeException {
        Class<?> r102 = getParamsClazz();
        if (r102 == null) goto L7;
        Object r103 = Proxy.newProxyInstance(r102.getClassLoader(), new Class[]{r102}, new b(r101, this, r100));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type INPUT of com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod");
        return (INPUT) r103;
    L7:
        throw new IllegalStateException("params class is null");
    }

    public final <OUTPUT extends XBaseResultModel> CompletionBlock<OUTPUT> createCompletionBlockProxy(ClassLoader r100, IDLXBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "classLoader");
        Intrinsics.checkNotNullParameter(r101, "callback");
        return new a(this, r101);
    }

    public final void onSuccess(IDLXBridgeMethod.a r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "msg");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", 1);
        r103.put("msg", r102);
        r103.put("data", r101);
        r100.invoke(r103);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Map<String, Object> r102 = r100.getBridgeCall().L;
        Lazy r103 = OptimizeConfigKt.f269934a;
        XBaseParamModel r104 = createParamModelProxy(r101, Intrinsics.areEqual(((LinkedHashMap) r102).get("xbridge_model_proxy_enhancement"), Boolean.TRUE));
        if (r104 != null) goto L6;
        onFailure$default(this, r110, -3, "", null, 8, null);
        return;
    L6:
        ClassLoader r105 = getClass().getClassLoader();
        Intrinsics.checkNotNull(r105);
        handle(r100, r104, createCompletionBlockProxy(r105, r110));
    }

    public final void onFailure(IDLXBridgeMethod.a r100, int r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r103, "data");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", Integer.valueOf(r101));
        r104.put("msg", r102);
        r104.put("data", r103);
        r100.invoke(r104);
    }

    public static /* synthetic */ void onSuccess$default(XCoreIDLBridgeMethod r100, IDLXBridgeMethod.a r101, Map r102, String r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = "";
    L6:
        r100.onSuccess(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onFailure$default(XCoreIDLBridgeMethod r100, IDLXBridgeMethod.a r101, int r102, String r103, Map r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = "";
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = new LinkedHashMap();
    L9:
        r100.onFailure(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
    }
}
