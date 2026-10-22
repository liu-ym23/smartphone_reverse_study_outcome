package d80;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f467385a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f467386b = null;

    static {
        f467385a = LiveInfraSettingKeys.LIVE_TETRIS_OPT.getValue().intValue();
        f467386b = LiveInfraSettingKeys.LIVE_FIX_ASYNC_INFLATER_LEAK.getValue();
    }

    public static boolean a() {
        if ((f467385a & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
