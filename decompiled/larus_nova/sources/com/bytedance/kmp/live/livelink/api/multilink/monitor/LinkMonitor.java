package com.bytedance.kmp.live.livelink.api.multilink.monitor;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import java.util.List;
import java.util.Set;
import jy0.b;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import r27.a;
import vm2.i;

/* JADX INFO: loaded from: classes19.dex */
public final class LinkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f252227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f252228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f252229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f252230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f252231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f252232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f252233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f252234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f252235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static MultiLinkConfig.LinkSource f252236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f252237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f252238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f252239m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/multilink/monitor/LinkMonitor$LogLevel;", "", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LogLevel extends Enum<LogLevel> {
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel VERBOSE = null;
        public static final LogLevel WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogLevel[] f252240a = null;

        static {
            LogLevel r100 = new LogLevel("VERBOSE", 0);
            VERBOSE = r100;
            LogLevel r101 = new LogLevel("DEBUG", 1);
            DEBUG = r101;
            LogLevel r102 = new LogLevel("INFO", 2);
            INFO = r102;
            LogLevel r103 = new LogLevel("WARN", 3);
            WARN = r103;
            LogLevel r104 = new LogLevel("ERROR", 4);
            ERROR = r104;
            f252240a = new LogLevel[]{r100, r101, r102, r103, r104};
        }

        public static LogLevel valueOf(String r100) {
            return (LogLevel) a.a(LogLevel.class, r100);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) f252240a.clone();
        }

        public LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f252235i = "null";
        f252236j = MultiLinkConfig.LinkSource.NONE;
    }

    @JvmStatic
    public static final void b() {
        f252227a = 0;
        f252229c = 0;
        f252231e = 0;
        f252230d = 0;
        f252232f = 0;
        f252228b = 0;
        f252233g = 0;
        f252234h = false;
        f252235i = "null";
        f252236j = MultiLinkConfig.LinkSource.NONE;
        f252237k = 0;
        f252238l = 0;
        f252239m = 0;
    }

    public static void a(String r110, String r111, String r112, Throwable r113, LogLevel r210, boolean r211, int r212) {
        String r100 = "";
        if ((r212 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r212 & 4) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r212 & 8) == 0) goto L13;
        Throwable r103 = null;
    L15:
        if ((r212 & 16) == 0) goto L17;
        LogLevel r104 = LogLevel.INFO;
    L19:
        if ((r212 & 32) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r212 & 64) == 0) goto L25;
        boolean r114 = false;
    L26:
        Intrinsics.checkNotNullParameter(r101, "msgPrefix");
        Intrinsics.checkNotNullParameter(r111, "event");
        Intrinsics.checkNotNullParameter(r104, "logLevel");
        StringBuilder r115 = new StringBuilder();
        r115.append(r101);
        r115.append(':');
        if (r114 == false) goto L29;
        String r116 = "KeyEvent ";
    L30:
        r115.append(r116);
        r115.append(r111);
        r115.append(' ');
        r115.append(r102);
        r115.append(' ');
        if (r103 == null) goto L34;
        String r117 = ExceptionsKt.stackTraceToString(r103);
        if (r117 == null) goto L34;
    L35:
        r115.append(r117);
        String r118 = r115.toString();
        int r106 = zb6.a.f571150a[r104.ordinal()];
        if (r106 != 1) goto L38;
        b.c("multi_link_service", r118, null, 4);
    L47:
        if (r105 == false) goto L60;
        ReadOnlyProperty r107 = i.f556292b;
        KProperty<?>[] r108 = i.f556291a;
        if (((Boolean) r107.getValue(null, r108[0])).booleanValue() == true) goto L51;
        return;
    L51:
        if (((List) i.f556293c.getValue(null, r108[1])).contains(r101) == false) goto L62;
        Set<Long> r109 = InteractLinkFullLinkMonitor.f71446a;
        String r119 = r101 + ':' + r111;
        if (r103 == null) goto L58;
        String r120 = ExceptionsKt.stackTraceToString(r103);
        if (r120 == null) goto L58;
        r100 = r120;
    L58:
        String r121 = Intrinsics.stringPlus(r102, r100);
        Intrinsics.checkNotNullParameter(r119, "event");
        JSONObject r122 = new JSONObject();
        InteractLinkFullLinkMonitor.a(r122);
        int r123 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.LinkPipeline, r119, 0, r121, r122, 72);
        return;
    L62:
        return;
    L60:
        return;
    L38:
        if (r106 != 2) goto L40;
        b.d("multi_link_service", r118);
        goto L47
    L40:
        if (r106 == 3) goto L44;
        if (r106 != 4) goto L47;
        b.a("multi_link_service", r118);
        goto L47
    L44:
        b.f("multi_link_service", r118, null, 4);
    L34:
        r117 = "";
        goto L35
    L29:
        r116 = "";
        goto L30
    L25:
        r114 = r211;
        goto L26
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
