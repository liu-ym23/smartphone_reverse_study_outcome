package jrb;

import android.text.TextUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLogLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends OPMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fyb.e f500160a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f500161a = null;

        static {
            int[] r100 = new int[OPMonitorLogLevel.values().length];
            f500161a = r100;
            r100[OPMonitorLogLevel.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f500161a[OPMonitorLogLevel.FATAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f500161a[OPMonitorLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f500161a[OPMonitorLogLevel.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f500161a[OPMonitorLogLevel.DEBUG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f500160a = new fyb.e(new dyb.a(new jrb.a(), new b()));
    }

    public c(OPMonitorCode r100) {
        super(f500160a, "op_messagecard", r100);
        addCategoryValue("tenant_id", e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId()));
        addCategoryValue("user_id", e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
    }

    public static OPMonitor a(d r100) {
        return new c(r100).addCategoryValue("tenant_id", e.b(com.ss.android.lark.message.card.b.a().getLoginTenantId())).addCategoryValue("user_id", e.b(com.ss.android.lark.message.card.b.a().getLoginUserId()));
    }

    public c(d r100) {
        super(f500160a, r100);
    }

    public static void d(d r100, int r101, String r102, long r103, String r104, String r105) {
        c r106 = new c(r100);
        r106.addCategoryValue("result_type", "success");
        if (r100.code != 10022) goto L9;
        r106.addCategoryValue(MusicAppletPage.KEY_MESSAGE_ID, r105).addCategoryValue("action_type", Integer.valueOf(r101)).setDuration(System.currentTimeMillis() - r103).addCategoryValue("action_id", r104);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r106.tracing(r102);
        goto L9
    L8:
        Log.w("CardOPMonitor", "action success traceId is null");
    L9:
        r106.flush();
    }

    public static void b(OPMonitorCode r100, int r101, int r102, String r103, String r104, String r110, String r111) {
        c r105 = new c(r100);
        r105.addCategoryValue("result_type", "fail");
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r105.tracing(r103);
    L6:
        int r106 = r100.code;
        if (r106 != 10014) goto L9;
    L18:
        r105.addCategoryValue(MusicAppletPage.KEY_MESSAGE_ID, r110).addCategoryValue("action_type", Integer.valueOf(r102)).addCategoryValue("error_msg", r111).addCategoryValue("action_id", r104);
    L19:
        r105.flush();
        return;
    L9:
        if (r106 == 10020) goto L18;
        if (r106 != 10021) goto L13;
        r105.addCategoryValue(MusicAppletPage.KEY_MESSAGE_ID, r110).addCategoryValue("action_type", Integer.valueOf(r102)).addCategoryValue("error_msg", r111).addCategoryValue("action_id", r104);
        r105.addCategoryValue("CODE", Integer.valueOf(r101));
        goto L19
    L13:
        if (r106 == 10028) goto L18;
        if (r106 == 10029) goto L18;
    L5:
        Log.w("CardOPMonitor", "action fail traceId is null");
        goto L6
    }

    public static void c(d r100, int r101, String r102, String r103, String r104, int r105, int r106, String r107, String r110) {
        c r108 = new c(r100);
        r108.addCategoryValue("result_type", "fail").addCategoryValue(MusicAppletPage.KEY_MESSAGE_ID, r104).addCategoryValue("action_type", Integer.valueOf(r101)).addCategoryValue("error_msg", r107).addCategoryValue("action_id", r103).addCategoryValue("status", Integer.valueOf(r105)).addCategoryValue("error_code", Integer.valueOf(r106)).addCategoryValue("log_id", r110);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r108.tracing(r102);
    L6:
        r108.flush();
        return;
    L5:
        Log.w("CardOPMonitor", "action fail traceId is null");
        goto L6
    }
}
