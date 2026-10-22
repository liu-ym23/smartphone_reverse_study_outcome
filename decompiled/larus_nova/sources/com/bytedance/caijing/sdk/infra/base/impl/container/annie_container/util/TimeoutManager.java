package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.util;

import android.net.Uri;
import android.os.CountDownTimer;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.caijing.sdk.infra.base.api.plugin.event.ICJReporter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class TimeoutManager implements ICJTag {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<Map<Integer, Map<String, TimeoutManager>>> f202430l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f202431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f202432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f202433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f202434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f202435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f202436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f202437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f202438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f202439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f202440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f202441k;

    public static final class a {
        public static Map a() {
            return TimeoutManager.f202430l.getValue();
        }

        public static void b(String r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "eventName");
            Intrinsics.checkNotNullParameter(r111, "sessionId");
            LinkedHashMap r100 = new LinkedHashMap();
            r100.put("id", r111);
            LinkedHashMap r112 = new LinkedHashMap();
            Iterator r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Map.Entry r102 = (Map.Entry) r101.next();
            String r103 = (String) r102.getKey();
            Object r104 = r102.getValue();
            if (r104 == null) goto L4;
            r112.put(r103, r104);
            goto L4
        L8:
            ICJReporter r105 = (ICJReporter) ve4.b.a(ICJReporter.class);
            if (r105 == null) goto L17;
            r105.reportBizEvent(r110, r100, System.currentTimeMillis(), false);
            r105.reportMonitorEvent(r110, r112, System.currentTimeMillis(), true);
            return;
        }
    }

    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f202442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f202443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f202444c;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.f202442a.invoke();
            this.f202444c = this.f202443b;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            this.f202444c = this.f202443b - r100;
        }

        public b(long r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r101, "timeoutCallback");
            super(r100, 10);
            this.f202442a = r101;
            this.f202443b = r100;
        }
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "TimeoutManager";
    }

    static {
        f202430l = LazyKt.lazy(TimeoutManager$Companion$H5InstanceTimeoutManager$2.INSTANCE);
    }

    public final void b() {
        if (this.f202433c == true) goto L5;
        return;
    L5:
        ICJTag.DefaultImpls.i(this, this.f202431a + " timeout timer is interrupted");
        this.f202440j = true;
        b r100 = this.f202432b;
        if (r100 == null) goto L8;
        long r101 = r100.f202444c;
    L9:
        long r102 = r101;
        if (r100 == null) goto L12;
        r100.cancel();
    L12:
        this.f202432b = null;
        this.f202433c = false;
        c(this.f202437g, false, this.f202434d, r102);
        return;
    L8:
        r101 = 0;
        goto L9
    }

    public final void f() {
        if (this.f202435e != 0) goto L6;
        return;
    L6:
        if (this.f202439i == false) goto L11;
        if (this.f202440j == false) goto L11;
        return;
    L11:
        if (this.f202433c == false) goto L14;
        this.f202434d++;
        return;
    L14:
        this.f202434d = 1;
        b r100 = this.f202432b;
        if (r100 == null) goto L17;
        r100.cancel();
    L17:
        ICJTag.DefaultImpls.i(this, this.f202431a + " timeout timer start, timeout in: " + this.f202436f);
        b r101 = new b(this.f202436f, new TimeoutManager$startTimerOrAddClickingCount$1(this));
        this.f202432b = r101;
        r101.start();
        this.f202433c = true;
    }

    public TimeoutManager() {
        this.f202431a = "";
        this.f202436f = 2000;
        this.f202437g = "";
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public final void c(String r210, boolean r211, int r212, long r213) {
        JSONObject r100 = new JSONObject();
        Uri r101 = this.f202441k;
        if (r101 == null) goto L28;
        Set<String> r102 = UriProtector.getQueryParameterNames(r101);
        if (r102 == null) goto L28;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L28;
        String r104 = (String) r103.next();
        Uri r105 = this.f202441k;
        if (r105 == null) goto L12;
        List<String> r106 = UriProtector.getQueryParameters(r105, r104);
    L13:
        boolean r107 = false;
        if (r106 != null) goto L16;
    L21:
        if (r107 == true) goto L22;
        if (r106 == null) goto L26;
        String r108 = (String) CollectionsKt.firstOrNull(r106);
        if (r108 == null) goto L26;
    L27:
        r100.put(r104, r108);
    L26:
        r108 = "";
        goto L27
    L22:
        r100.put(r104, r106);
        goto L8
    L16:
        if (r106.size() <= 1) goto L18;
        boolean r109 = true;
    L19:
        if (r109 != true) goto L21;
        r107 = true;
        goto L21
    L18:
        r109 = false;
        goto L19
    L12:
        r106 = null;
    L28:
        String r110 = r100.optString("cj_session_id");
        String r111 = r100.optString("bank_name");
        String r112 = r100.optString("biz_source");
        String r113 = r100.optString("biz_sub_source");
        String r114 = r100.optString(DyVerifyEventConstants.EventParam.BIZ_SCENE);
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put(LocationMonitorConst.IS_TIMEOUT, Boolean.valueOf(r211));
        r115.put("clicking_count", Integer.valueOf(r212));
        r115.put(LocationMonitorConst.BPEA_CHECK_DURATION, Long.valueOf(r213));
        r115.put("id", r110);
        r115.put("bank_name", r111);
        r115.put("biz_source", r112);
        r115.put("biz_sub_source", r113);
        r115.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r114);
        LinkedHashMap r116 = new LinkedHashMap();
        Iterator r117 = r115.entrySet().iterator();
    L30:
        if (r117.hasNext() == false) goto L34;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r119 = (String) r118.getKey();
        Object r120 = r118.getValue();
        if (r120 == null) goto L30;
        r116.put(r119, r120);
        goto L30
    L34:
        ICJTag.DefaultImpls.i(this, this.f202431a + " report event: " + r210 + ", biz params: " + r115 + ", monitor params: " + r116);
        ICJReporter r121 = (ICJReporter) ve4.b.a(ICJReporter.class);
        if (r121 == null) goto L49;
        r121.reportBizEvent(r210, r115, System.currentTimeMillis(), false);
        r121.reportMonitorEvent(r210, r116, System.currentTimeMillis(), true);
        return;
    }

    public final void a(Uri r100, String r101, int r102, long r103, String r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r104, "eventName");
        this.f202441k = r100;
        this.f202431a = r101;
        this.f202435e = r102;
        this.f202436f = r103;
        this.f202439i = true;
        this.f202437g = r104;
        this.f202438h = r105;
        StringBuilder r106 = new StringBuilder();
        r106.append(this.f202431a);
        r106.append(" timeout mode: ");
        int r107 = this.f202435e;
        if (r107 == 0) goto L10;
        if (r107 != 1) goto L6;
        String r108 = "report only";
    L11:
        r106.append(r108);
        r106.append(", timeout duration: ");
        r106.append(this.f202436f);
        r106.append(", report event name: ");
        r106.append(this.f202437g);
        r106.append(", schema: ");
        if (r100 == null) goto L14;
        String r109 = r100.toString();
    L15:
        r106.append(r109);
        ICJTag.DefaultImpls.i(this, r106.toString());
        b r110 = this.f202432b;
        if (r110 == null) goto L18;
        r110.cancel();
    L18:
        this.f202432b = null;
        this.f202433c = false;
        this.f202434d = 0;
        this.f202440j = false;
        return;
    L14:
        r109 = null;
        goto L15
    L6:
        if (r107 == 2) goto L8;
        r108 = "undefined behavior";
        goto L11
    L8:
        r108 = "report and close";
        goto L11
    L10:
        r108 = "disable";
        goto L11
    }
}
