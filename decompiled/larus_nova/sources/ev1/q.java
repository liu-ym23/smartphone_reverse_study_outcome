package ev1;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class q extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f474227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f474228b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f474229c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f474230d = null;

    static {
        f474230d = new q();
        f474227a = "https://p3-webcast.douyinpic.com/obj/webcast/";
        f474228b = "https://p6-webcast.douyinpic.com/obj/webcast/";
        f474229c = "https://p9-webcast.douyinpic.com/obj/webcast/";
    }

    public q() {
        Boolean r100 = Boolean.FALSE;
        super(EComABUtils.AB_KEY_LIVE_TOOLBAR_ICON_OPT, "toolbar视觉降级，icon替换", r100, r100);
    }
}
