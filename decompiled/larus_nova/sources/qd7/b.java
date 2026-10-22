package qd7;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sync.SyncSDK;
import h16.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.subscribeBytesyncMsg")
public final class b extends a {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.b r102 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (SyncSDK.hasInit() == true) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "bytesync has not init !!!", null, 4, null);
        return;
    L6:
        if (StringsKt.isBlank(r102.getBusinessId()) == false) goto L42;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "businessId is blank !!!", null, 4, null);
        return;
    L42:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Long.valueOf(CastLongProtector.parseLong(r102.getBusinessId())));     // Catch: Throwable -> L10
    L13:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L15;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "businessId type must be Long !!!", null, 4, null);
        return;
    L15:
        m16.b r105 = (m16.b) r100.getService(m16.b.class);
        Object r106 = null;
        if (r105 == null) goto L18;
        e r107 = (e) r105.c(e.class);
    L19:
        if (r107 != null) goto L21;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "bulletContainer is null !!!", null, 4, null);
        return;
    L21:
        ArrayList<Long> r108 = a16.a.f1375a;
        long r109 = CastLongProtector.parseLong(r102.getBusinessId());
        Intrinsics.checkNotNullParameter(r107, "bulletContainer");
        Map<Long, List<WeakReference<e>>> r111 = a16.a.f1376b;
        LinkedHashMap r112 = (LinkedHashMap) r111;
        if (r112.get(Long.valueOf(r109)) != null) goto L24;
        Long r113 = Long.valueOf(r109);
        ArrayList r114 = new ArrayList();
        r114.add(new WeakReference(r107));
        r111.put(r113, r114);
    L37:
        ArrayList<Long> r115 = a16.a.f1375a;
        if (r115.contains(Long.valueOf(r109)) == true) goto L40;
        com.bytedance.sync.a.C3779a r116 = new com.bytedance.sync.a.C3779a(r109);
        r116.a(new a16.b(r109));
        SyncSDK.registerBusiness(r116.b());
        r115.add(Long.valueOf(r109));
    L40:
        r110.onSuccess((XBaseResultModel) ne7.e.b(a.c.class), "subscribe bytesync msg success !!!");
        return;
    L24:
        List r117 = (List) r112.get(Long.valueOf(r109));
        if (r117 == null) goto L33;
        Iterator r118 = r117.iterator();
    L28:
        if (r118.hasNext() == false) goto L32;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((WeakReference) r119).get(), r107) == false) goto L28;
        r106 = r119;
    L32:
        r106 = (WeakReference) r106;
    L33:
        if (r106 != null) goto L37;
        List r120 = (List) ((LinkedHashMap) a16.a.f1376b).get(Long.valueOf(r109));
        if (r120 == null) goto L37;
        r120.add(new WeakReference(r107));
        goto L37
    L18:
        r107 = null;
    L10:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
