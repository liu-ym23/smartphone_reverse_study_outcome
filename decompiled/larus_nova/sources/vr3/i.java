package vr3;

import android.app.Activity;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends ss3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f556863g;

    @Override // ss3.a
    public final long h() {
        return 300000;
    }

    @Override // ss3.a
    public final void e() {
        if (this.f556863g == true) goto L5;
        return;
    L5:
        if (this.f543333b == false) goto L8;
        return;
    L8:
        if (ds3.a.c(com.bytedance.apm.d.getContext()) == false) goto L10;
        return;
    L10:
        float r100 = ykc.c.c(com.bytedance.apm.d.getContext());
        if (r100 >= 10) goto L16;
        return;
    L16:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L15
        r101.put("timing_current", r100);     // Catch: JSONException -> L15
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L15
        r102.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        ss3.a.g(new js3.e(Scraps.BATTERY, "", r101, r102, null));     // Catch: JSONException -> L15
        return;
    }

    public i() {
        this.f543336e = Scraps.BATTERY;
    }

    @Override // ss3.a
    public final boolean c() {
        return this.f556863g;
    }

    @Override // ss3.a
    public final void a(JSONObject r100) {
        boolean r101 = false;
        if (r100.optInt("energy_enable", 0) != 1) goto L5;
        r101 = true;
    L5:
        this.f556863g = r101;
    }

    @Override // ss3.a, ff7.c
    public final void onBackground(Activity r100) {
        super.onBackground(r100);
        bt3.b.d.f20539a.i(this);
    }

    @Override // ss3.a, ff7.c
    public final void onFront(Activity r100) {
        super.onFront(r100);
        if (this.f556863g == false) goto L6;
        bt3.b.d.f20539a.a(this);
        return;
    }
}
