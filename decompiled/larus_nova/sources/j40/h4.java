package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: classes45.dex */
public final class h4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h4 f497235a = null;

    static {
        f497235a = new h4();
    }

    public h4() {
        Boolean r100 = Boolean.FALSE;
        super(EComABUtils.AB_KEY_LIVE_TOOLBAR_ICON_OPT, "toolbar视觉降级，icon替换", r100, r100);
    }
}
