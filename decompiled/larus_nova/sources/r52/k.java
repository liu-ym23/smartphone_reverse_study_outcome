package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f536205a = null;

    static {
        f536205a = new k();
    }

    public k() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_public_screen_exclude_pk", "主播公屏助手判断时是否排除pk", r100, r100);
    }
}
