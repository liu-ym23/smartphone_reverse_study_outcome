package ef7;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f472528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ df7.c.b f472529b;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        HashMap r101 = new HashMap();
        df7.c.b r102 = this.f472529b;
        r101.put("status", "failed");
        r101.put("message", r100);
        String r103 = r102.getSocketTaskID();
        if (r103 == null) goto L5;
        r101.put("socketTaskID", r103);
    L5:
        this.f472528a.sendEvent("x.socketStatusChanged", r101);
    }

    public e(IBDXBridgeContext r100, df7.c.b r101) {
        this.f472528a = r100;
        this.f472529b = r101;
    }
}
