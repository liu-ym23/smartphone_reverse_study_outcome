package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class m0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f472037a = null;

    static {
        f472037a = new m0();
    }

    public m0() {
        Boolean r100 = Boolean.FALSE;
        super("live_interaction_msg_click_need_filter_room", "是否屏蔽部分直播间", r100, r100);
    }
}
