package u40;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.cq;
import com.bytedance.android.livesdk.config.dq;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f548644a = 0;

    @JvmStatic
    public static final boolean a() {
        return dq.f120056a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return cq.f119971a.getValue().booleanValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean c(boolean r100) {
        if (r100 == false) goto L6;
        return false;
    L6:
        return LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue().booleanValue();
    }
}
