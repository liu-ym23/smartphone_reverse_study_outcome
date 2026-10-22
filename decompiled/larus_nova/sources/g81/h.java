package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f480375a = null;

    static {
        f480375a = new h();
    }

    public h() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_card_show_debounce", "修复卡片重复展示时被隐藏的bug", r100, r100);
    }
}
