package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class s3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f561387a = null;

    static {
        f561387a = new s3();
    }

    public s3() {
        Boolean r100 = Boolean.FALSE;
        super("live_game_explain_card_load_postpone", "联运讲解卡延迟加载", r100, r100);
    }
}
