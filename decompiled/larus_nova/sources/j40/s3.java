package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f497298a = null;

    static {
        f497298a = new s3();
    }

    public s3() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_new_fold_recognize_api_opt", "是否对齐抖音折叠屏判断耗时优化", r100, r100);
    }
}
