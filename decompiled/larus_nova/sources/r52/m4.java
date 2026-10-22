package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class m4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m4 f536222a = null;

    static {
        f536222a = new m4();
    }

    public m4() {
        Boolean r100 = Boolean.TRUE;
        super("local_gift_intercept", "礼物消息拦截控制", r100, r100);
    }
}
