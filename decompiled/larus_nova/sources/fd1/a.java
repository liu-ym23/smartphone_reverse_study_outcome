package fd1;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476457a = 0;

    static {
    }

    public static void a(int r100, int r101, long r102, Map r103) {
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_pay_sequence", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_pay_sequence".concat("_all"), r101 + r100, r102, r103);
    }
}
