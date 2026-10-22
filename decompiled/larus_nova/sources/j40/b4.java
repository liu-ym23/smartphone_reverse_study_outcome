package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class b4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b4 f497174a = null;

    static {
        f497174a = new b4();
    }

    public b4() {
        Boolean r100 = Boolean.TRUE;
        super("live_pad_adapt_multi_win", "pad分栏适配", r100, r100);
    }

    @JvmStatic
    public static final boolean a() {
        if (f497174a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        return true;
    }
}
