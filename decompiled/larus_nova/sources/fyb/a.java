package fyb;

import android.text.TextUtils;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a implements byb.e {
    public static final String COMMA = ",";
    public static final C5968a Companion = null;
    public static final String KEY_DATA = "data:";
    public static final String KEY_MONITOR_EVENT = "monitor_event:";

    /* JADX INFO: renamed from: fyb.a$a, reason: collision with other inner class name */
    public static final class C5968a {
        public C5968a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f479331a = null;

        static {
            int[] r100 = new int[OPMonitorLevel.values().length];
            r100[OPMonitorLevel.TRACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[OPMonitorLevel.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[OPMonitorLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[OPMonitorLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[OPMonitorLevel.FATAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f479331a = r100;
        }
    }

    static {
        Companion = new C5968a();
    }

    public a() {
    }

    public final String getEventName(OPMonitor r100, dyb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        Intrinsics.checkNotNullParameter(r101, "config");
        String r102 = r100.getName();
        if (TextUtils.isEmpty(r102) == true) goto L5;
    L9:
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        if (r100.getMonitorCode() == null) goto L7;
        r101.getClass();
    L8:
        r102 = "op_monitor_event";
        goto L9
    L7:
        r101.getClass();
        goto L8
    }

    public final void log(OPMonitor r100, dyb.a r110) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        if (r110 != null) goto L6;
        return;
    L6:
        if (r100.getLevel() != null) goto L9;
        OPMonitorLogLevel r101 = OPMonitorLogLevel.INFO;
    L8:
        OPMonitorLogLevel r102 = r101;
        String r103 = getEventName(r100, r110);
        if ((r100.getValue("monitor_file") instanceof String) == false) goto L31;
        Object r104 = r100.getValue("monitor_file");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        String r105 = (String) r104;
    L33:
        if ((r100.getValue("monitor_function") instanceof String) == false) goto L35;
        Object r106 = r100.getValue("monitor_function");
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.String");
        String r107 = (String) r106;
    L37:
        if ((r100.getValue("monitor_line") instanceof Integer) == false) goto L39;
        Object r108 = r100.getValue("monitor_line");
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Int");
        int r109 = ((Integer) r108).intValue();
    L40:
        r110.f470559b.a(r102, r105, r107, r109, KEY_MONITOR_EVENT + r103 + ",data:" + new JSONObject(r100.getData()));
        return;
    L39:
        r109 = -1;
        goto L40
    L35:
        r107 = null;
        goto L37
    L31:
        r105 = null;
        goto L33
    L9:
        OPMonitorLevel r111 = r100.getLevel();
        if (r111 != null) goto L12;
        int r112 = -1;
    L14:
        if (r112 != 1) goto L16;
    L27:
        r101 = OPMonitorLogLevel.INFO;
        goto L8
    L16:
        if (r112 == 2) goto L27;
        if (r112 != 3) goto L20;
        r101 = OPMonitorLogLevel.WARN;
        goto L8
    L20:
        if (r112 != 4) goto L22;
        r101 = OPMonitorLogLevel.ERROR;
        goto L8
    L22:
        if (r112 == 5) goto L24;
        r101 = OPMonitorLogLevel.INFO;
        goto L8
    L24:
        r101 = OPMonitorLogLevel.FATAL;
        goto L8
    L12:
        r112 = b.f479331a[r111.ordinal()];
        goto L14
    }
}
