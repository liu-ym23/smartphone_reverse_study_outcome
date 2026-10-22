package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f480376a = null;

    static {
        f480376a = new i();
    }

    public i() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_ec_rank_card_keyboard_show", "修复带货榜键盘展示问题", r100, r100);
    }
}
