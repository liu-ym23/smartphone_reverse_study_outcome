package ev1;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends SettingKey<fv1.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f474226a = null;

    static {
        f474226a = new p();
    }

    public p() {
        super("live_online_user_ui_opt", "在线人数榜框架优化", new fv1.d(), new fv1.d());
    }

    @JvmStatic
    public static final int a(DataCenter r100) {
        p r101 = f474226a;
        r101.getClass();
        if (d(r100) == true) goto L7;
        return 0;
    L7:
        return r101.getValue().a();
    }

    @JvmStatic
    public static final boolean b(DataCenter r100) {
        p r101 = f474226a;
        r101.getClass();
        if (d(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.getValue().b() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean c(DataCenter r100) {
        f474226a.getClass();
        if (d(r100) == false) goto L14;
        int r101 = a(r100);
        if (r101 != 1) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r101 == 2) goto L10;
        r102 = false;
        goto L11
    L14:
        return false;
    }

    public static boolean d(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (a0.d(r100, false) == false) goto L7;
        return false;
    L7:
        if (a0.l(r100, true) == true) goto L9;
        return false;
    L9:
        if (a0.c(r100) == true) goto L15;
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final boolean e(DataCenter r100) {
        f474226a.getClass();
        if (d(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r100) != 1) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean f(DataCenter r100) {
        f474226a.getClass();
        if (d(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r100) != 2) goto L7;
        return true;
    }
}
