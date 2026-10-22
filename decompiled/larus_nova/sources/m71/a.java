package m71;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f512323a = null;

    static {
        f512323a = new a();
    }

    public a() {
        Boolean r100 = Boolean.FALSE;
        super("enable_live_common_card_mock", "开启右下角通用卡片mock", r100, r100);
    }
}
