package e0a;

import com.bytedance.keva.Keva;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f470654a = null;

    static {
        f470654a = Keva.getRepo("worldcup_lottery_state", 0);
    }

    public static boolean a() {
        boolean r100 = f470654a.getBoolean("lottery_state_".concat(o.f365780a.getDeviceId()), false);
        FLogger.f375446a.i("WorldCupLotteryManager", "getLotteryState state:" + r100);
        return r100;
    }
}
