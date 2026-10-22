package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f472006a = null;

    static {
        f472006a = new c();
    }

    public c() {
        Boolean r100 = Boolean.TRUE;
        super("ec_live_report_click_comment_message_hint", "上报评论区x 条新消息埋点", r100, r100);
    }
}
