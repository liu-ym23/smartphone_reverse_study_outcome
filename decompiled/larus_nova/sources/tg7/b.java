package tg7;

import org.json.JSONObject;
import tr3.f;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wg7.a f545909a;

    public b(com.bytedance.timon_monitor_impl.b r100) {
        this.f545909a = r100;
    }

    @Override // tr3.f
    public final void a(boolean r100, JSONObject r101) {
        if (r101 == null) goto L4;
        Object r102 = r101.opt("code");
    L5:
        String r103 = String.valueOf(r102);
        String r104 = String.valueOf(r101);
        this.f545909a.a(r100, r103, r104);
        return;
    L4:
        r102 = null;
        goto L5
    }
}
