package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class o0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f472043a = null;

    static {
        f472043a = new o0();
    }

    public o0() {
        Boolean r100 = Boolean.TRUE;
        super("live_interaction_msg_show_mob_enable", "公屏关注分享加入粉丝团是否上报独立show埋点", r100, r100);
    }
}
