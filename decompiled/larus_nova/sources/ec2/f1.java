package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class f1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f472017a = null;

    static {
        f472017a = new f1();
    }

    public f1() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_full_screen_judge_opt", "公屏判断满屏条件优化开关", r100, r100);
    }
}
