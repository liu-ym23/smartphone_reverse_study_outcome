package ud7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.lang.reflect.Field;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.canIUse")
public final class e extends b {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b.InterfaceC7865b r113 = (b.InterfaceC7865b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getMethod();
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        return;
    L11:
        String r114 = r113.getMethod();
        ue7.a r103 = (ue7.a) r110.getService(ue7.a.class);
        if (r103 == null) goto L14;
        IDLXBridgeMethod r115 = r103.b(r110.getBridgeCall().f508946d, r114);
    L16:
        if (r115 == null) goto L35;
        XBaseModel r104 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r105 = (b.c) r104;
        r105.setAvailable(Boolean.TRUE);
        Class<? super Object> r116 = r115.getClass().newInstance().getClass().getSuperclass();     // Catch: Exception -> L37
        if (r116 == null) goto L43;
        Field[] r117 = r116.getDeclaredFields();     // Catch: Exception -> L37
        if (r117 == null) goto L44;
        int r106 = r117.length;     // Catch: Exception -> L37
    L23:
        if (r101 >= r106) goto L28;
        Field r107 = r117[r101];     // Catch: Exception -> L37
        if (r107.isAnnotationPresent(XBridgeMethodName.class) == true) goto L29;
        r101 = r101 + 1;     // Catch: Exception -> L37
    L29:
        if (r107 == null) goto L45;
        r107.setAccessible(true);     // Catch: Exception -> L37
        if (r107.isAnnotationPresent(XBridgeMethodName.class) == false) goto L34;
        XBridgeMethodName r118 = (XBridgeMethodName) r107.getAnnotation(XBridgeMethodName.class);     // Catch: Exception -> L37
        r105.setParams(ArraysKt.asList(r118.params()));     // Catch: Exception -> L37
        r105.setResults(ArraysKt.asList(r118.results()));     // Catch: Exception -> L37
        goto L34
    L45:
        return;
    L28:
        r107 = null;
        goto L29
    L44:
        return;
    L43:
        return;
    L34:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r104, null, 2, null);
        return;
    L35:
        XBaseModel r119 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r119).setAvailable(Boolean.FALSE);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r119, null, 2, null);
        return;
    L14:
        r115 = null;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
