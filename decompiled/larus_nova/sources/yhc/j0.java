package yhc;

import android.content.SharedPreferences;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.update.IUpdateConfig;

/* JADX INFO: loaded from: classes40.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f567702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f567703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f567704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f567705d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j0 f567706a = null;

        static {
            f567706a = new j0();
        }
    }

    public final void a() {
        if (this.f567703b == false) goto L10;
        int r100 = this.f567704c.b("current_Strategy", 1);
        boolean r101 = this.f567704c.f567691a.getBoolean("click_update_cancel", false);
        if (r100 != 2) goto L7;
        this.f567704c.c("current_Strategy", 1);
    L7:
        if (r101 == false) goto L11;
        SharedPreferences.Editor r102 = this.f567704c.f567691a.edit();
        r102.putBoolean("click_update_cancel", false);
        r102.apply();
        return;
    L11:
        return;
    }

    public final void b() {
        if (this.f567703b == false) goto L13;
        int r100 = this.f567704c.b("version_code", 0);
        boolean r101 = this.f567704c.f567691a.getBoolean("click_update_cancel", false);
        if (r100 != this.f567702a) goto L8;
        if (r101 == true) goto L14;
        SharedPreferences.Editor r102 = this.f567704c.f567691a.edit();
        r102.putBoolean("click_update_cancel", true);
        r102.apply();
        return;
    L14:
        return;
    L8:
        if (r101 == false) goto L10;
        this.f567704c.c("current_Strategy", 2);
    L11:
        this.f567704c.c("version_code", this.f567702a);
        return;
    L10:
        SharedPreferences.Editor r103 = this.f567704c.f567691a.edit();
        r103.putBoolean("click_update_cancel", true);
        r103.apply();
        goto L11
    }

    public j0() {
        this.f567702a = -1;
        this.f567705d = 2;
        AppCommonContext r100 = f0.f567694c;
        this.f567704c = e0.a(r100.getContext().getApplicationContext());
        this.f567702a = r100.getVersionCode();
        IUpdateConfig r101 = f0.f567692a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUpdateConfig() != null) goto L7;
        return;
    L7:
        if (r101.getUpdateConfig().a() == null) goto L12;
        this.f567703b = r101.getUpdateConfig().a().f567700b;
        this.f567705d = r101.getUpdateConfig().a().f567701c;
        return;
    }
}
