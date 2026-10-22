package com.bytedance.ies.bullet.service.monitor;

import a36.c;
import android.net.Uri;
import com.bytedance.android.monitorV2.g;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.j0;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.intercept.BulletTeaReporter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import jz2.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class MonitorReportService extends s26.a implements r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<MonitorReportService> f247964d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f247965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f247966c;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.service.monitor.MonitorReportService$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "serviceName", "", "status", "", "duration", "Lorg/json/JSONObject;", "logExtra", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function4<String, Integer, JSONObject, JSONObject, Unit> {
        final /* synthetic */ j0 $reporter;

        public AnonymousClass1(j0 r100) {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String r100, Integer r101, JSONObject r102, JSONObject r103) {
            invoke(r100, r101.intValue(), r102, r103);
            return Unit.INSTANCE;
        }

        public final void invoke(String r100, int r101, JSONObject r102, JSONObject r103) {
            throw null;
        }
    }

    public static final class a {
        public static MonitorReportService a() {
            return MonitorReportService.f247964d.getValue();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1 f247967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorReportService f247968b;

        public b(c1 r100, MonitorReportService r101) {
            this.f247967a = r100;
            this.f247968b = r101;
        }

        public final void a() {
            KitType r100 = null;
            if (h.h() == true) goto L14;
            ExecutorService r101 = BulletLogger.f247763a;     // Catch: Exception -> L90
            StringBuilder r102 = new StringBuilder("report ");     // Catch: Exception -> L90
            r102.append(this.f247967a.f247791a);     // Catch: Exception -> L90
            r102.append(", url ");     // Catch: Exception -> L90
            c r103 = this.f247967a.f247801k;     // Catch: Exception -> L90
            if (r103 == null) goto L8;
            String r104 = r103.b();     // Catch: Exception -> L90
        L9:
            r102.append(r104);     // Catch: Exception -> L90
            r102.append(", fullUrl ");     // Catch: Exception -> L90
            c r105 = this.f247967a.f247801k;     // Catch: Exception -> L90
            if (r105 == null) goto L12;
            String r106 = r105.a();     // Catch: Exception -> L90
        L13:
            r102.append(r106);     // Catch: Exception -> L90
            r102.append(", category ");     // Catch: Exception -> L90
            r102.append(this.f247967a.f247794d);     // Catch: Exception -> L90
            r102.append(" metrics  ");     // Catch: Exception -> L90
            r102.append(this.f247967a.f247795e);     // Catch: Exception -> L90
            BulletLogger.j(r102.toString(), LogLevel.I, "Monitor-Report");     // Catch: Exception -> L90
            goto L14
        L12:
            r106 = null;
            goto L13
        L8:
            r104 = null;
        L14:
            MonitorReportService r107 = this.f247968b;     // Catch: Exception -> L90
            c1 r108 = this.f247967a;     // Catch: Exception -> L90
            r107.getClass();     // Catch: Exception -> L90
            if (r108.f247794d != null) goto L18;
            r108.f247794d = new JSONObject();     // Catch: Exception -> L90
        L18:
            if (r108.f247795e != null) goto L21;
            r108.f247795e = new JSONObject();     // Catch: Exception -> L90
        L21:
            if (r108.f247797g != null) goto L23;
            r108.f247797g = new JSONObject();     // Catch: Exception -> L90
        L23:
            c1 r109 = this.f247967a;     // Catch: Exception -> L90
            c r110 = r109.f247801k;     // Catch: Exception -> L90
            if (r110 == null) goto L27;
            String r111 = r110.b();     // Catch: Exception -> L90
            if (r111 == null) goto L27;
        L28:
            r109.f247792b = r111;     // Catch: Exception -> L90
            c1 r112 = this.f247967a;     // Catch: Exception -> L90
            String r113 = r112.f247793c;     // Catch: Exception -> L90
            boolean r114 = true;
            int r115 = 2;
            if (r113 != null) goto L40;
            c r116 = r112.f247801k;     // Catch: Exception -> L90
            if (r116 == null) goto L39;
            int r117 = c.b.f1581a[r116.c().ordinal()];     // Catch: Exception -> L90
            if (r117 == 1) goto L37;
            if (r117 == 2) goto L36;
            String r118 = "unknown";
        L38:
            r113 = r118;
            goto L40
        L36:
            r118 = "web";
            goto L38
        L37:
            r118 = "lynx";
            goto L38
        L39:
            String r119 = null;
        L41:
            c1 r120 = this.f247967a;     // Catch: Exception -> L90
            JSONObject r121 = r120.f247794d;     // Catch: Exception -> L90
            if (r121 == null) goto L44;
            MonitorReportService r122 = this.f247968b;     // Catch: Exception -> L90
            MonitorReportService.G0(r122, r121, r122.f247965b, r119, r120.f247792b, r120.f247801k);     // Catch: Exception -> L90
        L44:
            JSONObject r123 = this.f247967a.f247797g;     // Catch: Exception -> L90
            if (r123 == null) goto L54;
            this.f247968b.f247965b.getClass();     // Catch: Exception -> L90
            k36.a.b(r123, null);     // Catch: Exception -> L90
            c r124 = this.f247967a.f247801k;     // Catch: Exception -> L90
            if (r124 == null) goto L50;
            r100 = r124.c();     // Catch: Exception -> L90
        L50:
            if (r100 != KitType.LYNX) goto L52;
            int r125 = 3;
        L53:
            r123.put("platform", r125);     // Catch: Exception -> L90
            goto L54
        L52:
            r125 = 0;
        L54:
            com.bytedance.ies.bullet.service.base.b r126 = this.f247968b.f247965b.f247900f;     // Catch: Exception -> L90
            if (r126 == null) goto L57;
            r126.a(this.f247967a);     // Catch: Exception -> L90
        L57:
            MonitorReportService r127 = this.f247968b;     // Catch: Exception -> L90
            c1 r128 = this.f247967a;     // Catch: Exception -> L90
            r127.getClass();     // Catch: Exception -> L90
            Intrinsics.checkNotNullParameter(r128, "info");     // Catch: Exception -> L90
            String r129 = this.f247967a.f247800j;     // Catch: Exception -> L90
            if (r129 != null) goto L60;
        L63:
            boolean r130 = true;
        L64:
            if (r130 == true) goto L66;
            String r131 = this.f247967a.f247800j;     // Catch: Exception -> L90
        L75:
            c1 r132 = this.f247967a;     // Catch: Exception -> L90
            String r133 = r132.f247799i;     // Catch: Exception -> L90
            if (r133 != null) goto L79;
            r133 = this.f247968b.f247965b.f247898d;     // Catch: Exception -> L90
        L79:
            if (Intrinsics.areEqual(r132.f247796f, Boolean.TRUE) == true) goto L83;
            r115 = 0;
        L83:
            if (Intrinsics.areEqual(this.f247968b.f540302a, "BDUG_BID") == false) goto L85;
            r115 = 6;
        L85:
            Integer r134 = this.f247967a.f247802l;     // Catch: Exception -> L90
            if (r134 == null) goto L88;
            r115 = r134.intValue();     // Catch: Exception -> L90
        L88:
            c1 r135 = this.f247967a;     // Catch: Exception -> L90
            d.a r136 = new d.a(r135.f247791a);     // Catch: Exception -> L90
            r136.f501113a = r135.f247792b;     // Catch: Exception -> L90
            r136.f501116d = r135.f247794d;     // Catch: Exception -> L90
            r136.f501117e = r135.f247795e;     // Catch: Exception -> L90
            r136.f501118f = r135.f247798h;     // Catch: Exception -> L90
            r136.f501120h = r135.f247797g;     // Catch: Exception -> L90
            r136.f501114b = r131;     // Catch: Exception -> L90
            r136.f501122j = r133;     // Catch: Exception -> L90
            r136.b(r115);     // Catch: Exception -> L90
            r136.f501121i = this.f247967a.f247803m;     // Catch: Exception -> L90
            this.f247968b.f247965b.getClass();     // Catch: Exception -> L90
            Lazy r137 = BulletTeaReporter.f247979a;     // Catch: Exception -> L90
            BulletTeaReporter.a(this.f247968b.f247965b, this.f247967a, r131, r133);     // Catch: Exception -> L90
            g r138 = g.e();     // Catch: Exception -> L90
            d r139 = r136.a();     // Catch: Exception -> L90
            r138.getClass();     // Catch: Exception -> L90
            g.c(r139);     // Catch: Exception -> L90
            return;
        L66:
            String r140 = this.f247968b.f247965b.f247897c;     // Catch: Exception -> L90
            if (r140 != null) goto L69;
        L72:
            if (r114 == true) goto L74;
            r131 = this.f247968b.f247965b.f247897c;     // Catch: Exception -> L90
            goto L75
        L74:
            r131 = "bullet_custom_bid";
            goto L75
        L69:
            if (r140.length() == 0) goto L72;
            r114 = false;
            goto L72
        L60:
            if (r129.length() == 0) goto L63;
            r130 = false;
        L40:
            r119 = r113;
        L27:
            r111 = this.f247967a.f247792b;     // Catch: Exception -> L90
        L90:
            e = move-exception;
            ExecutorService r141 = BulletLogger.f247763a;
            BulletLogger.j("report failed, " + e.getMessage(), LogLevel.E, "Monitor-Report");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.r
    /* JADX INFO: renamed from: getMonitorConfig */
    public final void mo8364getMonitorConfig() {
    }

    static {
        f247964d = LazyKt.lazy(MonitorReportService$Companion$FallbackDefault$2.INSTANCE);
    }

    @Override // com.bytedance.ies.bullet.service.base.r
    public final q0 getMonitorConfig() {
        return this.f247965b;
    }

    public MonitorReportService(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f247965b = r100;
        g r101 = g.e();
        com.bytedance.ies.bullet.service.monitor.intercept.a r102 = com.bytedance.ies.bullet.service.monitor.intercept.a.f247980a;
        if (r101.f163047h != null) goto L5;
        r101.f163047h = new CopyOnWriteArrayList();
    L5:
        ((CopyOnWriteArrayList) r101.f163047h).add(r102);
        this.f247966c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MonitorReportService"));
    }

    @Override // com.bytedance.ies.bullet.service.base.r
    public final void S(c1 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        w26.g r102 = (w26.g) x26.a.a(w26.g.class);
        Boolean r103 = null;
        if (r102 == null) goto L5;
        w26.h r104 = (w26.h) r102.n0(w26.h.class);
    L7:
        if (this.f247965b.f247896b == false) goto L17;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == true) goto L17;
        this.f247966c.submit(new b(r100, this));
        return;
    L10:
        if (r104.f() == true) goto L12;
        r105 = true;
    L17:
        ExecutorService r106 = BulletLogger.f247763a;
        StringBuilder r107 = new StringBuilder("report blocked: config ");
        r107.append(this.f247965b.f247896b);
        r107.append(", settings ");
        if (r104 == null) goto L20;
        r103 = Boolean.valueOf(r104.f());
    L20:
        r107.append(r103);
        BulletLogger.j(r107.toString(), LogLevel.I, "Monitor-Report");
        return;
    L5:
        r104 = null;
        goto L7
    }

    public static final void G0(MonitorReportService r100, JSONObject r101, q0 r102, String r103, String r104, c r105) {
        r101.put("_bid", r100.f540302a);
        r101.put("_container", r102.f247895a);
        r101.put("_bullet_sdk_version", "10.4.0");
        r101.put("hybrid_platform", r103);
        r101.put("url", r104);
        if (r105 == null) goto L5;
        String r106 = r105.a();
    L6:
        r101.put("_full_url", r106);
        if (r105 != null) goto L33;
    L31:
        k36.a.b(r101, null);
        return;
    L33:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L28
        if (r105.f1580d == true) goto L16;
        Uri r108 = UriProtector.parse(r105.a());     // Catch: Throwable -> L28
        String r109 = w36.a.a(r108, "bdx_monitor_append_params");     // Catch: Throwable -> L28
        if (r109 == null) goto L14;
        String r110 = URLDecoder.decode(r109, "UTF-8");     // Catch: Throwable -> L28
    L15:
        r105.f1578b = r110;     // Catch: Throwable -> L28
        r105.f1579c = w36.a.a(r108, "enter_from");     // Catch: Throwable -> L28
        r105.f1580d = true;     // Catch: Throwable -> L28
        goto L16
    L14:
        r110 = null;
    L16:
        String r111 = r105.f1578b;     // Catch: Throwable -> L28
        if (r111 == null) goto L21;
        JSONObject r112 = new JSONObject(r111);     // Catch: Throwable -> L28
        String r113 = r105.f1579c;     // Catch: Throwable -> L28
        if (r113 == null) goto L30;
        r112.put("enter_from", r113);     // Catch: Throwable -> L28
    L30:
        k36.a.b(r101, r112);
        goto L31
    L21:
        String r114 = r105.f1579c;     // Catch: Throwable -> L28
        if (r114 == null) goto L24;
        r112 = new JSONObject();     // Catch: Throwable -> L28
        r112.put("enter_from", r114);     // Catch: Throwable -> L28
    L25:
        if (r112 != null) goto L30;
        r112 = new JSONObject();     // Catch: Throwable -> L28
        goto L30
    L24:
        r112 = null;
    L28:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r112 = new JSONObject();
        goto L30
    L5:
        r106 = null;
        goto L6
    }
}
