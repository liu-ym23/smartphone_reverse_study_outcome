package f22;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static int b() {
        Intrinsics.checkNotNullParameter("broadcast_long_press_tip_show_times", "key");
        return ((Number) new e("broadcast_long_press_tip_show_times" + ((IUserService) k.n(IUserService.class)).user().n(), 0).getValue()).intValue();
    }

    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Boolean) new e(r100 + ((IUserService) k.n(IUserService.class)).user().n(), Boolean.FALSE).getValue()).booleanValue();
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = r100 + ((IUserService) k.n(IUserService.class)).user().n();
        Boolean r102 = Boolean.TRUE;
        f.d(new e(r101, r102), r102);
    }

    public static void d(int r100) {
        Intrinsics.checkNotNullParameter("broadcast_long_press_tip_show_times", "key");
        f.d(new e("broadcast_long_press_tip_show_times" + ((IUserService) k.n(IUserService.class)).user().n(), Integer.valueOf(r100)), Integer.valueOf(r100));
    }
}
