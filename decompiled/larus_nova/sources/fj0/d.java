package fj0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477462a = 0;

    static {
    }

    public static void b(long r100, long r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("time_remaining", Long.valueOf(r100));
        r102.put("expect_leave_time", Long.valueOf(r101));
        x.t0("paid_leave_from_timer", r102);
        ALogger.e("ttlive_link_paid", "leaveFromTimer, timeRemaining=" + r100 + " expectLeaveTime=" + r101 + ' ');
    }

    public static void a(long r100, long r101, Long r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("time_remaining", Long.valueOf(r100));
        r103.put("expect_leave_time", Long.valueOf(r101));
        r103.put("server_time", String.valueOf(r102));
        x.t0("paid_leave_from_list_change", r103);
        ALogger.e("ttlive_link_paid", "leaveFromListChange, timeRemaining=" + r100 + " expectLeaveTime=" + r101 + " serverCurrentTime= " + r102);
    }
}
