package xu2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabSlardarMonitor;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTraceMonitor;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565087a = 0;

    static {
    }

    public static void b(HashMap r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L7:
        e = move-exception;
        ALogger.e("TabTraceMonitor", e);
        return;
    L4:
        if (r100.containsKey(r101) == true) goto L12;
        r100.put(r101, r102);     // Catch: Exception -> L7
        return;
    }

    public static void a(HashMap r100, int r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendCommonParams");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        b(r100, "status_code", String.valueOf(r101));
        b(r100, "status", r102);
        b(r100, "duration", String.valueOf(r103));
    }

    public static void c(TabSlardarMonitor.Event r100, int r101, String r102, long r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        a(r104, r101, r102, r103);
        String r105 = r100.getEventName();
        String r106 = String.valueOf(r104);
        Intrinsics.checkNotNullParameter(r105, "eventName");
        Intrinsics.checkNotNullParameter(r106, "extraInfo");
        ALogger.d("TabALoggerMonitor - " + r105, r106);
    }

    public static void d(TabTraceMonitor.Event r100, int r101, String r102, long r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        a(r104, r101, r102, r103);
        String r105 = r100.getEventType();
        String r106 = String.valueOf(r104);
        Intrinsics.checkNotNullParameter(r105, "eventName");
        Intrinsics.checkNotNullParameter(r106, "extraInfo");
        ALogger.d("TabALoggerMonitor - " + r105, r106);
    }
}
