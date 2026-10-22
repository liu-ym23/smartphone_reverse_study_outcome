package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: classes44.dex */
public final class w4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4 f561412a = null;

    static {
        f561412a = new w4();
    }

    public w4() {
        Boolean r100 = Boolean.FALSE;
        super(EComABUtils.AB_KEY_LIVE_TOOLBAR_ICON_OPT, "toolbar视觉降级，icon替换", r100, r100);
    }
}
