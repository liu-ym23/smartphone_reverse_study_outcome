package ew;

import com.bytedance.android.gamecp.business.gamedetail.page.root.f0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements nv.b {
    public c() {
    }

    @Override // nv.b
    public final void Y(JSONObject r100, f0 r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // nv.b
    public final void g1(JSONObject r100, nv.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // nv.b
    public final void stopGamePredict() {
    }
}
