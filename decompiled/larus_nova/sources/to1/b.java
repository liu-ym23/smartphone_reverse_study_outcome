package to1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f546893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f546894b = null;

    static {
        int[] r100 = new int[ActivityTopBannerViewIntent.LifeCycle.values().length];
        f546893a = r100;
        r100[ActivityTopBannerViewIntent.LifeCycle.ON_PAUSE.ordinal()] = 1;
        r100[ActivityTopBannerViewIntent.LifeCycle.ON_RESUME.ordinal()] = 2;
        int[] r101 = new int[IBaseUser.Status.values().length];
        f546894b = r101;
        r101[IBaseUser.Status.Login.ordinal()] = 1;
        r101[IBaseUser.Status.Logout.ordinal()] = 2;
        r101[IBaseUser.Status.Update.ordinal()] = 3;
    }
}
