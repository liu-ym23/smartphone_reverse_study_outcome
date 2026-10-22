package j43;

import androidx.fragment.app.Fragment;
import cf.l;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497355a = 0;

    public c() {
    }

    static {
    }

    public static void a(boolean r100, Fragment r101) {
        LiveClearScreenMode r102 = LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
        LiveScreenMoveMode r103 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
        Intrinsics.checkNotNullParameter(r102, "clearScreenMode");
        Intrinsics.checkNotNullParameter(r103, "screenMoveMode");
        if (r101 == null) goto L8;
        boolean r104 = ECServiceManager.f42805a;
        l r105 = (l) ECServiceManager.c(l.class);
        if (r105 == null) goto L9;
        r105.Fa(r100, r101, r102, r103);
        return;
    L9:
        return;
    }
}
