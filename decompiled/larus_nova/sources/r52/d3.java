package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class d3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f536167a = null;

    static {
        f536167a = new d3();
    }

    public d3() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_gift_message_decouple", "公屏礼物消息分离开关", r100, r100);
    }
}
