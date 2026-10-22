package l60;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f507588a = 0;

    public static boolean a() {
        SettingKey<b> r100 = LiveInfraSettingKeys.LIVE_LAYER_FRAMEWORK_OPT;
        if (r100.getValue().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValue().b() == false) goto L7;
        return true;
    }

    public static boolean b() {
        SettingKey<b> r100 = LiveInfraSettingKeys.LIVE_LAYER_FRAMEWORK_OPT;
        if (r100.getValue().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getValue().c() == false) goto L7;
        return true;
    }

    static {
    }
}
