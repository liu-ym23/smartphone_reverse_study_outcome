package bg5;

import android.os.SystemClock;
import ax4.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.f;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Stage;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uf5.p;
import uf5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static long a;
    public static r b;
    public static p c;
    public static final AtomicBoolean d = null;
    public static final AtomicBoolean e = null;
    public static final AtomicBoolean f = null;
    public static final AtomicBoolean g = null;
    public static final AtomicBoolean h = null;
    public static final AtomicBoolean i = null;
    public static final AtomicBoolean j = null;
    public static final AtomicInteger k = null;
    public static final RunnableC0005a l = null;

    /* JADX INFO: renamed from: bg5.a$a, reason: collision with other inner class name */
    public static final class RunnableC0005a implements Runnable {
        public static final RunnableC0005a a = null;

        static {
            a = new RunnableC0005a();
        }

        public RunnableC0005a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.k(DocFeed$Value$Result.TIMEOUT, DocFeed$Value$ResultCode.RESULT_CODE_TIMEOUT);     // Catch: Throwable -> L4
            a.p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static void o() {
        b = null;
        c = null;
        a = 0;
        d.compareAndSet(true, false);
        e.compareAndSet(true, false);
        f.compareAndSet(true, false);
        g.compareAndSet(true, false);
        h.set(false);
        i.set(false);
        j.set(false);
        p();
    }

    static {
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
        g = new AtomicBoolean(false);
        h = new AtomicBoolean(false);
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        k = new AtomicInteger(0);
        l = RunnableC0005a.a;
    }

    public static void b() {
        i.set(true);     // Catch: Throwable -> L4
        ((d) org.koin.java.a.c(d.class, null, null, 6)).j("tag_doc_feedopen_feed_from_larkfeed", "key_open_feed_show_start", String.valueOf(SystemClock.uptimeMillis()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void c() {
        ((d) org.koin.java.a.c(d.class, null, null, 6)).j("tag_doc_feedopen_feed_from_larkfeed", "key_feed_handle_data_from_JS", String.valueOf(SystemClock.uptimeMillis()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void p() {
        m.e(l);
    }

    public static void a(@DocFeed$Value$Stage String r4) {
        Intrinsics.checkNotNullParameter(r4, "stage");
        d r0 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L5
        r0.h(r4);     // Catch: Throwable -> L5
        r0.j(r4, "key_doc_feed", String.valueOf(SystemClock.uptimeMillis()));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void d(Map r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        r r0 = b;
        boolean r1 = false;
        if (r0 == null) goto L7;
        int r2 = r0.g;
    L8:
        String r3 = null;
        if (r0 == null) goto L11;
        String r4 = r0.e;
    L12:
        String r5 = "";
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        if (r0 == null) goto L17;
        String r6 = r0.c;
    L18:
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r8.put("file_id", r6);
        r r7 = b;
        if (r7 == null) goto L23;
        String r9 = r7.b;
    L24:
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r8.put("file_type", r9);
        r8.put("file_length", 0);
        r8.put("file_lines", 0);
        r8.put("scm_version", ((a4) org.koin.java.a.c(a4.class, null, null, 6)).d());
        r8.put("is_doze", Boolean.valueOf(((f) org.koin.java.a.c(f.class, null, null, 6)).f()));
        r8.put("app_visible", Boolean.valueOf(((f) org.koin.java.a.c(f.class, null, null, 6)).a()));
        if (j.a.a.getNetworkState().a() == false) goto L29;
        String r10 = "online";
    L30:
        r8.put("network_state", r10);
        r8.put("feed_unread_badge_count", Integer.valueOf(r2));
        r r11 = b;
        if (r11 == null) goto L33;
        String r12 = r11.d;
    L34:
        if (r12 != null) goto L36;
        r12 = "";
    L36:
        r8.put("feed_id", r12);
        p r13 = c;
        if (r13 == null) goto L39;
        String r14 = r13.a;
    L40:
        if (r14 != null) goto L42;
        r14 = "";
    L42:
        r8.put("feed_data_source", r14);
        r r15 = b;
        if (r15 == null) goto L45;
        r3 = r15.f;
    L45:
        if (r3 == null) goto L48;
        r5 = r3;
    L48:
        r8.put("feed_open_from", r5);
        r r16 = b;
        if (r16 == null) goto L51;
        r1 = r16.k;
    L51:
        r8.put("feed_is_auto_show", Boolean.valueOf(r1));
        r8.put("feed_msg_type", r4);
        return;
    L39:
        r14 = null;
        goto L40
    L33:
        r12 = null;
        goto L34
    L29:
        r10 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        goto L30
    L23:
        r9 = null;
        goto L24
    L17:
        r6 = null;
        goto L18
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = 0;
        goto L8
    }

    public static String e(Throwable r3) {
        if (r3 != null) goto L6;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_NULL_THROWABLE, "null_throwable");
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_NULL_THROWABLE;
    L6:
        if (ax4.d.b(r3, 4) == false) goto L10;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_NO_PERMISSION, null);
        l(DocFeed$Value$Stage.CHECK_PERMISSION, DocFeed$Value$ResultCode.CHECK_PERMISSION_NO_PERMISSION);
        Intrinsics.checkNotNullParameter(DocFeed$Value$ResultCode.CHECK_PERMISSION_NO_PERMISSION, "resultCode");
        k(DocFeed$Value$Result.FAIL, DocFeed$Value$ResultCode.CHECK_PERMISSION_NO_PERMISSION);
        p();
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_NO_PERMISSION;
    L10:
        if ((r3 instanceof NetService.ParseException) == false) goto L13;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_PARSE_RESPONSE, null);
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_PARSE_RESPONSE;
    L13:
        int r0 = ax4.d.a(r3);
        if (r0 == (-1)) goto L17;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_SERVER_ERROR, r0 + "");
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_SERVER_ERROR;
    L17:
        int r1 = c.a(r3);
        if (r1 == (-3)) goto L22;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_NETWORK_ERROR, r1 + "");
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_NETWORK_ERROR;
    L22:
        if ((r3 instanceof NetService.HttpErrorException) == true) goto L25;
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_ERROR, r3.getMessage());
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_ERROR;
    L25:
        g(DocFeed$Value$ResultCode.CHECK_PERMISSION_HTTP_ERROR, ((NetService.HttpErrorException) r3).getCode() + "");
        return DocFeed$Value$ResultCode.CHECK_PERMISSION_HTTP_ERROR;
    }

    public static void f(boolean r5) {
        d r2 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L10
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L10
        if (r5 == false) goto L7;
        r3.put("forbidden_location", "global_comments");     // Catch: Throwable -> L10
    L8:
        r3.put("is_history", "false");     // Catch: Throwable -> L10
        r2.n("ccm_permission_copy_forbidden_toast_view", r3);     // Catch: Throwable -> L10
        tt5.a.h("Feed_FeedReportV2", "copy failed: " + r3);     // Catch: Throwable -> L10
        return;
    L7:
        r3.put("forbidden_location", "part_comments");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "click");
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L5
        r1.put("click", r3);     // Catch: Throwable -> L5
        d(r1);     // Catch: Throwable -> L5
        r1.put("target", "none");     // Catch: Throwable -> L5
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("ccm_notification_panel_click", r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void m(@DocFeed$Value$Stage String r2) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        j(r2, "success", DocFeed$Value$ResultCode.RESULT_CODE_SUCCESS);
    }

    public static void g(@DocFeed$Value$ResultCode String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "resultCode");
        if (d.get() == true) goto L26;
        r r2 = b;
        boolean r3 = true;
        if (r2 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L26;
        String r6 = null;
        d r5 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L23
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L23
        r7.put("result_key", DocFeed$Value$Result.FAIL);     // Catch: Throwable -> L23
        r7.put("result_code", r9);     // Catch: Throwable -> L23
        if (r10 != null) goto L15;
    L21:
        r7.put("http_errno", r6);     // Catch: Throwable -> L23
        d(r7);     // Catch: Throwable -> L23
        r5.v("dev_performance_feed_open_error", r7);     // Catch: Throwable -> L23
        tt5.a.d("Feed_FeedReportV2", "Error: " + r7);     // Catch: Throwable -> L23
        return;
    L15:
        if (r10.length() == 0) goto L18;
        r3 = false;
    L18:
        if (r3 == false) goto L20;
        r10 = "error_null";
    L20:
        r6 = r10;
    L23:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
        return;
    L7:
        if (r2.j != true) goto L9;
        r4 = true;
    L26:
        o();
    }

    public static void i(int r2, int r3) {
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L4
        r0.put("badge_count", String.valueOf(r2));     // Catch: Throwable -> L4
        r0.put("props_badge_count", Integer.valueOf(r3));     // Catch: Throwable -> L4
        d(r0);     // Catch: Throwable -> L4
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("feed_panel_ops", r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void k(@DocFeed$Value$Result String r22, @DocFeed$Value$ResultCode String r23) {
        if (d.getAndSet(true) == false) goto L95;
        tt5.a.h("Feed_FeedReportV2", "reportOpenFeedResult sHasReportOpenResult == true");
        return;
    L95:
        d r7 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L88
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L88
        r8.put("result_key", r22);     // Catch: Throwable -> L88
        r8.put("result_code", r23);     // Catch: Throwable -> L88
        String r9 = r7.e("tag_doc_feedopen_feed_from_larkfeed", "key_open_start_click_lark_feed");     // Catch: Throwable -> L88
        String r10 = r7.e("tag_doc_feedopen_feed_from_larkfeed", "key_open_start_vc_oncreate");     // Catch: Throwable -> L88
        String r11 = r7.e("tag_doc_feedopen_feed_from_larkfeed", "key_open_start_view_oncreated");     // Catch: Throwable -> L88
        String r12 = r7.e("tag_doc_feedopen_feed_from_larkfeed", "key_open_feed_show_start");     // Catch: Throwable -> L88
        String r13 = r7.e("tag_doc_feedopen_feed_from_larkfeed", "key_feed_handle_data_from_JS");     // Catch: Throwable -> L88
        if (r9 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L15;
        long r15 = SystemClock.uptimeMillis() - Long.parseLong(r9);     // Catch: Throwable -> L88
        r8.put("cost_time", Long.valueOf(r15));     // Catch: Throwable -> L88
        r8.put("cost_time_since_click_larkfeed", Long.valueOf(r15));     // Catch: Throwable -> L88
        long r16 = r15 - a;     // Catch: Throwable -> L88
    L18:
        if (j.get() == true) goto L20;
        r9 = "";
    L20:
        if (r10 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == true) goto L29;
        r8.put("cost_time_since_vc_oncreate", Long.valueOf(SystemClock.uptimeMillis() - Long.parseLong(r10)));     // Catch: Throwable -> L88
    L29:
        if (r11 != null) goto L31;
    L34:
        boolean r5 = true;
    L35:
        if (r5 == true) goto L37;
        r8.put("cost_time_since_fragment_view_oncreated", Long.valueOf(SystemClock.uptimeMillis() - Long.parseLong(r11)));     // Catch: Throwable -> L88
    L37:
        if (r9 != null) goto L39;
    L42:
        boolean r6 = true;
    L43:
        if (r6 == true) goto L52;
        if (r10 != null) goto L46;
    L49:
        boolean r17 = true;
    L50:
        if (r17 == true) goto L52;
        r8.put("cost_time_stage_createView", Long.valueOf(Long.parseLong(r10) - Long.parseLong(r9)));     // Catch: Throwable -> L88
        goto L52
    L46:
        if (StringsKt.isBlank(r10) == true) goto L49;
        r17 = false;
    L52:
        if (r13 != null) goto L54;
    L57:
        boolean r18 = true;
    L58:
        if (r18 == true) goto L67;
        if (r12 != null) goto L61;
    L64:
        boolean r19 = true;
    L65:
        if (r19 == true) goto L67;
        r8.put("cost_time_stage_handleDataFormJs", Long.valueOf(Long.parseLong(r13) - Long.parseLong(r12)));     // Catch: Throwable -> L88
        r8.put("cost_time_all_from_js", r8.get("cost_time_stage_handleDataFormJs"));     // Catch: Throwable -> L88
        goto L67
    L61:
        if (StringsKt.isBlank(r12) == true) goto L64;
        r19 = false;
    L67:
        if (r13 != null) goto L69;
    L72:
        boolean r0 = true;
    L73:
        if (r0 == true) goto L82;
        if (r9 != null) goto L76;
    L79:
        boolean r20 = true;
    L80:
        if (r20 == true) goto L82;
        r8.put("cost_time_all_from_feed", Long.valueOf(Long.parseLong(r13) - Long.parseLong(r9)));     // Catch: Throwable -> L88
        goto L82
    L76:
        if (StringsKt.isBlank(r9) == true) goto L79;
        r20 = false;
    L82:
        r7.c("tag_doc_feedopen_feed_from_larkfeed");     // Catch: Throwable -> L88
        d(r8);     // Catch: Throwable -> L88
        r7.v("dev_performance_feed_open_finish", r8);     // Catch: Throwable -> L88
        tt5.a.h("Feed_FeedReportV2", "OPEN_FINISH: " + r8);     // Catch: Throwable -> L88
        StringBuilder r1 = new StringBuilder("OPEN_FINISH: stage total: ");     // Catch: Throwable -> L88
        r1.append(a);     // Catch: Throwable -> L88
        r1.append(", deviation: ");     // Catch: Throwable -> L88
        if (r16 < 0) goto L85;
        String r21 = "+";
    L86:
        r1.append(r21);     // Catch: Throwable -> L88
        r1.append(r16);     // Catch: Throwable -> L88
        r1.append("  ");     // Catch: Throwable -> L88
        tt5.a.k("OPEN_FINISH_zxz_feed", r1.toString());     // Catch: Throwable -> L88
        a = 0;     // Catch: Throwable -> L88
        return;
    L85:
        r21 = "";
        goto L86
    L69:
        if (StringsKt.isBlank(r13) == true) goto L72;
        r0 = false;
        goto L73
    L54:
        if (StringsKt.isBlank(r13) == true) goto L57;
        r18 = false;
        goto L58
    L39:
        if (StringsKt.isBlank(r9) == true) goto L42;
        r6 = false;
        goto L43
    L31:
        if (StringsKt.isBlank(r11) == true) goto L34;
        r5 = false;
        goto L35
    L22:
        if (StringsKt.isBlank(r10) == true) goto L25;
        r4 = false;
        goto L26
    L15:
        r16 = -1;
        goto L18
    L9:
        if (StringsKt.isBlank(r9) == true) goto L12;
        r14 = false;
    L88:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);     // Catch: Throwable -> L92
        return;
    L92:
        th = move-exception;
        throw th;
    }

    public static void l(@DocFeed$Value$Stage String r1, @DocFeed$Value$ResultCode String r2) {
        Intrinsics.checkNotNullParameter(r1, "stage");
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        j(r1, DocFeed$Value$Result.FAIL, r2);
    }

    public static void n(String r3, Notice r4) {
        Intrinsics.checkNotNullParameter(r3, "actionStr");
        Intrinsics.checkNotNullParameter(r4, "notice");
        tt5.a.h("Feed_FeedReportV2", "reportToMessage");
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L5
        r1.put("action", r3);     // Catch: Throwable -> L5
        r1.put("mentionId", r4.getMentionId());     // Catch: Throwable -> L5
        r1.put("commentId", r4.getCommentId());     // Catch: Throwable -> L5
        r1.put("isGlobalComment", Boolean.valueOf(r4.isGlobalComment()));     // Catch: Throwable -> L5
        r1.put("noticeType", r4.getNoticeType());     // Catch: Throwable -> L5
        r1.put("commentType", Integer.valueOf(r4.getCommentType()));     // Catch: Throwable -> L5
        r1.put("isUserClick", Boolean.FALSE);     // Catch: Throwable -> L5
        ((d) org.koin.java.a.c(d.class, null, null, 6)).n("docx_comment_monitor_dev", r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
    }

    public static void j(@DocFeed$Value$Stage String r9, @DocFeed$Value$Result String r10, @DocFeed$Value$ResultCode String r11) {
        if (d.get() == true) goto L32;
        r r2 = b;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L32;
        Long r6 = null;
        d r4 = (d) org.koin.java.a.c(d.class, null, null, 6);     // Catch: Throwable -> L29
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Throwable -> L29
        r5.put("result_key", r10);     // Catch: Throwable -> L29
        r5.put("result_code", r11);     // Catch: Throwable -> L29
        r5.put("stage", r9);     // Catch: Throwable -> L29
        String r12 = r4.e(r9, "key_doc_feed");     // Catch: Throwable -> L29
        if (r12 != null) goto L15;
    L18:
        boolean r13 = true;
    L19:
        if (r13 == true) goto L28;
        long r7 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r12);     // Catch: Throwable -> L29
        r5.put("cost_time", Long.valueOf(r7));     // Catch: Throwable -> L29
        Long r14 = Long.valueOf(a);     // Catch: Throwable -> L29
        r14.longValue();     // Catch: Throwable -> L29
        if ((!Intrinsics.areEqual(r9, DocFeed$Value$Stage.CHECK_PERMISSION)) == false) goto L23;
        r6 = r14;
    L23:
        if (r6 == null) goto L25;
        long r15 = r6.longValue() + r7;     // Catch: Throwable -> L29
    L26:
        a = r15;     // Catch: Throwable -> L29
        r4.c(r9);     // Catch: Throwable -> L29
        d(r5);     // Catch: Throwable -> L29
        r4.v("dev_performance_feed_open_stage", r5);     // Catch: Throwable -> L29
        tt5.a.h("Feed_FeedReportV2", "STAGE: " + r5);     // Catch: Throwable -> L29
        return;
    L25:
        r15 = a;     // Catch: Throwable -> L29
        goto L26
    L28:
        return;
    L15:
        if (StringsKt.isBlank(r12) == true) goto L18;
        r13 = false;
    L29:
        th = move-exception;
        tt5.a.f("Feed_FeedReportV2", th, false);
        return;
    L7:
        if (r2.j != true) goto L9;
        r3 = true;
    L32:
        o();
    }
}
