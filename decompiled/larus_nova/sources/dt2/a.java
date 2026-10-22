package dt2;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.setting.w;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f469995a = null;

    static {
        a r100 = new a();
        f469995a = r100;
        r100.setPreloadCache(w.a());
    }

    public a() {
        Float r100 = Float.valueOf(7.5f);
        super("live_device_model_overall_score", "针对观众端：观众当前机型的综合打分", r100, r100);
    }
}
