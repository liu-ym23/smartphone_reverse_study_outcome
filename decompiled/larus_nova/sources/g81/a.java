package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f480368a = null;

    static {
        f480368a = new a();
    }

    public a() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_close_live_button_opt", "主播侧关播按钮的优化（调整到右上角）", r100, r100);
    }
}
