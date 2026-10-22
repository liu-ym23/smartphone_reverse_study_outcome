package ud7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.batchEvents")
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f549747d;

    public d() {
        this.f549747d = "invalid Parameter";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.b r102 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
    L39:
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, null, null, 6, null);
        return;
    L4:
        if (r102.getActionList().isEmpty() == false) goto L7;
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, null, null, 6, null);     // Catch: Exception -> L39
        return;
    L7:
        String r103 = r102.getActionType();
        List<a.d> r104 = r102.getActionList();
        List<a.d> r105 = r104;
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L38;
        List<a.d> r107 = r104;
        Iterator<T> r108 = r107.iterator();
    L17:
        if (r108.hasNext() == false) goto L24;
        if (((a.d) r108.next()).getMethodName().length() != 0) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L17;
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, this.f549747d, null, 4, null);
        return;
    L21:
        r109 = false;
        goto L22
    L24:
        m16.b r111 = (m16.b) r100.getService(m16.b.class);
        if (r111 == null) goto L37;
        h16.e r112 = (h16.e) r111.c(h16.e.class);
        if (r112 == null) goto L37;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r114 = r107.iterator();
    L30:
        if (r114.hasNext() == false) goto L32;
        r113.add(((a.d) r114.next()).getMethodName());
        goto L30
    L32:
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r116 = r107.iterator();
    L34:
        if (r116.hasNext() == false) goto L36;
        r115.add(new JSONObject(((a.d) r116.next()).getParams()));
        goto L34
    L36:
        r112.qq(r103, r113, r115);
    L37:
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L38:
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, this.f549747d, null, 4, null);
        return;
    L10:
        if (r105.isEmpty() == true) goto L13;
        r106 = false;
        goto L14
    }
}
