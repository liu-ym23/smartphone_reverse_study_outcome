package com.obric.assistant.chat.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f386616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f386617b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, Long> f386618c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap<String, b> f386619d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f386620e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, a> f386621f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, a> f386622g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, a> f386623h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f386624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f386626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f386627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f386628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f386629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f386630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f386631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f386632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f386633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f386634k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f386635l;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386624a, r101.f386624a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386625b, r101.f386625b) == true) goto L15;
            return false;
        L15:
            if (this.f386626c == r101.f386626c) goto L18;
            return false;
        L18:
            if (this.f386627d == r101.f386627d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386628e, r101.f386628e) == true) goto L24;
            return false;
        L24:
            if (this.f386629f == r101.f386629f) goto L27;
            return false;
        L27:
            if (this.f386630g == r101.f386630g) goto L30;
            return false;
        L30:
            if (this.f386631h == r101.f386631h) goto L33;
            return false;
        L33:
            if (this.f386632i == r101.f386632i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f386633j, r101.f386633j) == true) goto L39;
            return false;
        L39:
            if (this.f386634k == r101.f386634k) goto L42;
            return false;
        L42:
            if (this.f386635l == r101.f386635l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f386624a.hashCode() * 31) + this.f386625b.hashCode()) * 31;
            long r101 = this.f386626c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f386627d;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            String r105 = this.f386628e;
            if (r105 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r104 + r106) * 31;
            long r108 = this.f386629f;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f386630g;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f386631h;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f386632i;
            int r115 = (((r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.f386633j.hashCode()) * 31;
            long r116 = this.f386634k;
            int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
            if (this.f386635l == false) goto L9;
            int r118 = 1231;
        L11:
            return r117 + r118;
        L9:
            r118 = 1237;
            goto L11
        L5:
            r106 = r105.hashCode();
            goto L6
        }

        public final String toString() {
            return "TraceSession(traceKey=" + this.f386624a + ", firstQueryId=" + this.f386625b + ", firstQueryStartTime=" + this.f386626c + ", semanticIntentTime=" + this.f386627d + ", uploadIdentifier=" + this.f386628e + ", uploadStartTime=" + this.f386629f + ", uploadFinishTime=" + this.f386630g + ", restoreStartTime=" + this.f386631h + ", restoreFinishTime=" + this.f386632i + ", secondQueryId=" + this.f386633j + ", secondQuerySendSuccessTime=" + this.f386634k + ", reported=" + this.f386635l + ')';
        }

        public a(String r100, String r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "traceKey");
            Intrinsics.checkNotNullParameter(r101, "firstQueryId");
            Intrinsics.checkNotNullParameter("", "secondQueryId");
            this.f386624a = r100;
            this.f386625b = r101;
            this.f386626c = r102;
            this.f386627d = r103;
            this.f386628e = null;
            this.f386629f = -1;
            this.f386630g = -1;
            this.f386631h = -1;
            this.f386632i = -1;
            this.f386633j = "";
            this.f386634k = -1;
            this.f386635l = false;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f386636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f386637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f386638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f386639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f386640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f386641f;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f386636a == r101.f386636a) goto L12;
            return false;
        L12:
            if (this.f386637b == r101.f386637b) goto L15;
            return false;
        L15:
            if (this.f386638c == r101.f386638c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386639d, r101.f386639d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386640e, r101.f386640e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f386641f, r101.f386641f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f386636a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f386637b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f386638c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            Boolean r106 = this.f386639d;
            int r107 = 0;
            if (r106 != null) goto L5;
            int r108 = 0;
        L6:
            int r109 = (r105 + r108) * 31;
            String r110 = this.f386640e;
            if (r110 != null) goto L9;
            int r111 = 0;
        L10:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f386641f;
            if (r113 == null) goto L15;
            r107 = r113.hashCode();
        L15:
            return r112 + r107;
        L9:
            r111 = r110.hashCode();
            goto L10
        L5:
            r108 = r106.hashCode();
            goto L6
        }

        public final String toString() {
            return "UploadRecord(startTime=" + this.f386636a + ", finishTime=" + this.f386637b + ", duration=" + this.f386638c + ", success=" + this.f386639d + ", code=" + this.f386640e + ", msg=" + this.f386641f + ')';
        }

        public b(int r100) {
            this.f386636a = -1;
            this.f386637b = -1;
            this.f386638c = -1;
            this.f386639d = null;
            this.f386640e = null;
            this.f386641f = null;
        }
    }

    public f() {
    }

    static {
        f386616a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f386617b = new Object();
        f386618c = new LinkedHashMap();
        f386619d = new LinkedHashMap();
        f386620e = new d();
        f386621f = new LinkedHashMap();
        f386622g = new LinkedHashMap();
        f386623h = new LinkedHashMap();
    }

    public static void c(long r100) {
        Collection r101 = ((LinkedHashMap) f386621f).values();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        a r105 = (a) r104;
        if ((r100 - r105.f386627d) <= 1800000) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if (r105.f386635l == true) goto L11;
        r106 = false;
        goto L12
    L14:
        Iterator r107 = r102.iterator();
    L16:
        if (r107.hasNext() == false) goto L21;
        a r108 = (a) r107.next();
        if (r108.f386635l == true) goto L19;
        m(r108, r100);
        goto L16
    L19:
        k(r108);
        goto L16
    }

    public static String d(a r100) {
        if (r100.f386634k <= 0) goto L6;
        return "reply_timeout";
    L6:
        if (r100.f386631h <= 0) goto L11;
        if (r100.f386632i > 0) goto L11;
        return "restore_timeout";
    L11:
        if (r100.f386629f > 0) goto L13;
    L15:
        String r101 = r100.f386628e;
        if (r101 != null) goto L18;
    L21:
        boolean r102 = true;
    L22:
        if (r102 == false) goto L24;
        return "semantic_prepare_timeout";
    L24:
        return "second_query_not_sent";
    L18:
        if (StringsKt.isBlank(r101) == true) goto L21;
        r102 = false;
        goto L22
    L13:
        if (r100.f386630g > 0) goto L15;
        return "upload_timeout";
    }

    public static void k(final a r100) {
        f386621f.remove(r100.f386624a);
        String r101 = r100.f386628e;
        if (r101 == null) goto L5;
        a r102 = f386622g.remove(r101);
    L5:
        CollectionsKt.removeAll(((LinkedHashMap) f386623h).entrySet(), new e(r100));
    }

    public static List o(Message r100) {
        String[] r101 = new String[2];
        String r102 = r100.getMessageId();
        String r103 = null;
        if (r102 != null) goto L5;
    L7:
        r102 = null;
    L8:
        r101[0] = r102;
        String r104 = r100.getLocalMessageId();
        if (r104 != null) goto L11;
    L13:
        r101[1] = r103;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r101));
    L11:
        if ((!StringsKt.isBlank(r104)) == false) goto L13;
        r103 = r104;
        goto L13
    L5:
        if ((!StringsKt.isBlank(r102)) == false) goto L7;
        goto L7
    }

    public static String p(Message r100) {
        String r101 = r100.getMessageId();
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.getLocalMessageId();
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static void a(String r100, String r101) {
        long r102 = System.currentTimeMillis();
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L28;
        if (r101 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L31;
        Object r105 = f386617b;
        monitor-enter(r105);
        c(r102);     // Catch: Throwable -> L25
        a r106 = (a) ((LinkedHashMap) f386621f).get(r100);     // Catch: Throwable -> L25
        if (r106 != null) goto L22;
        monitor-exit(r105);
        return;
    L22:
        b(r106, r101, r102);     // Catch: Throwable -> L25
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r105);
        return;
    L25:
        th = move-exception;
        throw th;
    L31:
        return;
    L12:
        if (StringsKt.isBlank(r101) == false) goto L14;
    L28:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static void f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Object r102 = f386617b;
        monitor-enter(r102);
        c(r101);     // Catch: Throwable -> L10
        a r103 = (a) ((LinkedHashMap) f386622g).get(r100);     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r103.f386631h = r101;     // Catch: Throwable -> L10
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void m(a r100, long r101) {
        String r102 = d(r100);
        String r103 = d(r100);
        switch(r103.hashCode()) {
            case -988775156: goto L18;
            case -693282640: goto L14;
            case 324501936: goto L10;
            case 446263587: goto L6;
            default: goto L21;
        };
    L21:
        String r104 = "semantic second query not sent";
    L22:
        l(r100, r101, r102, r104);
        return;
    L6:
        if (r103.equals("upload_timeout") == false) goto L21;
        r104 = "semantic image upload timeout";
        goto L22
    L10:
        if (r103.equals("semantic_prepare_timeout") == false) goto L21;
        r104 = "semantic prepare timeout";
        goto L22
    L14:
        if (r103.equals("restore_timeout") == false) goto L21;
        r104 = "semantic image restore timeout";
        goto L22
    L18:
        if (r103.equals("reply_timeout") == false) goto L21;
        r104 = "semantic reply timeout";
        goto L22
    }

    public static void b(a r100, String r101, long r102) {
        boolean r103 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return;
    L11:
        r100.f386628e = r101;
        f386622g.put(r101, r100);
        b r105 = f386619d.get(r101);
        if (r105 == null) goto L40;
        r100.f386629f = r105.f386636a;
        r100.f386630g = r105.f386637b;
        if (Intrinsics.areEqual(r105.f386639d, Boolean.FALSE) == false) goto L41;
        String r106 = r105.f386640e;
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        String r108 = null;
        if ((!r107) == true) goto L26;
        r106 = null;
    L26:
        if (r106 != null) goto L28;
        r106 = "upload_failed";
    L28:
        String r109 = r105.f386641f;
        if (r109 != null) goto L31;
    L32:
        r103 = true;
    L34:
        if ((!r103) == false) goto L36;
        r108 = r109;
    L36:
        if (r108 != null) goto L38;
        r108 = "upload failed";
    L38:
        l(r100, r102, r106, r108);
        return;
    L31:
        if (StringsKt.isBlank(r109) == false) goto L34;
    L18:
        if (StringsKt.isBlank(r106) == true) goto L21;
        r107 = false;
        goto L22
    L41:
        return;
    L40:
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static String g(Message r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r111 = null;
    L6:
        if ((r112 & 4) == 0) goto L8;
        long r100 = System.currentTimeMillis();
    L9:
        Intrinsics.checkNotNullParameter(r110, "firstQuery");
        String r101 = p(r110);
        String r113 = UUID.randomUUID().toString();
        Object r102 = f386617b;
        monitor-enter(r102);
        c(r100);     // Catch: Throwable -> L37
        Iterator r103 = o(r110).iterator();     // Catch: Throwable -> L37
    L13:
        if (r103.hasNext() == false) goto L17;
        Long r104 = f386618c.get((String) r103.next());     // Catch: Throwable -> L37
        if (r104 == null) goto L13;
    L18:
        if (r104 == null) goto L20;
        long r105 = r104.longValue();     // Catch: Throwable -> L37
    L32:
        long r106 = r105;
    L34:
        a r114 = new a(r113, r101, r106, r100);     // Catch: Throwable -> L37
        f386621f.put(r113, r114);     // Catch: Throwable -> L37
        BuildersKt.launch$default(f386616a, null, null, new SemanticTraceReporter$scheduleSessionExpiry$1(r113, null), 3, null);     // Catch: Throwable -> L37
        b(r114, r111, r100);     // Catch: Throwable -> L37
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r102);
        return r113;
    L20:
        Long r116 = Long.valueOf(r110.getCreateTime());     // Catch: Throwable -> L37
        if (r116.longValue() <= 0) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L27;
        r116 = null;
    L27:
        if (r116 == null) goto L29;
        Long r117 = Long.valueOf(r116.longValue() * 1000);     // Catch: Throwable -> L37
    L30:
        if (r117 == null) goto L33;
        r105 = r117.longValue();     // Catch: Throwable -> L37
        goto L32
    L33:
        r106 = r100;
        goto L34
    L29:
        r117 = null;
        goto L30
    L23:
        r107 = false;
        goto L24
    L17:
        r104 = null;
    L37:
        th = move-exception;
        throw th;
    L8:
        r100 = 0;
        goto L9
    }

    public static void i(String r100, String r101, String r102) {
        long r103 = System.currentTimeMillis();
        Object r104 = f386617b;
        monitor-enter(r104);
        c(r103);     // Catch: Throwable -> L26
        boolean r105 = false;
        if (StringsKt.isBlank(r101) == false) goto L7;
        boolean r106 = true;
    L9:
        if ((!r106) == true) goto L12;
        r101 = null;
    L12:
        if (r101 != null) goto L15;
        r101 = "query_not_found";
    L15:
        if (StringsKt.isBlank(r102) == false) goto L18;
        r105 = true;
    L18:
        if ((!r105) == true) goto L21;
        r102 = null;
    L21:
        if (r102 != null) goto L23;
        r102 = "semantic query not found";
    L23:
        n(r100, r103, r101, r102);     // Catch: Throwable -> L26
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r104);
        return;
    L7:
        r106 = false;
    L26:
        th = move-exception;
        throw th;
    }

    public static void l(a r210, long r211, String r212, String r213) {
        if (r210.f386635l == false) goto L5;
        return;
    L5:
        r210.f386635l = true;
        long r100 = r210.f386634k;
        long r101 = r210.f386629f;
        long r102 = r210.f386630g;
        if (r101 > 0) goto L8;
    L13:
        long r103 = -1;
    L14:
        long r104 = r210.f386631h;
        long r110 = r210.f386632i;
        if (r104 > 0) goto L17;
    L22:
        long r105 = -1;
    L23:
        JSONObject r111 = new JSONObject();
        r111.put("first_query_id", r210.f386625b);
        r111.put("second_query_id", r210.f386633j);
        r111.put("all_duration", RangesKt.coerceAtLeast(r211 - r210.f386626c, 0));
        r111.put("to_semantic_duration", RangesKt.coerceAtLeast(r210.f386627d - r210.f386626c, 0));
        Long r106 = Long.valueOf(r100);
        if (r106.longValue() <= 0) goto L26;
        boolean r112 = true;
    L28:
        if (r112 == true) goto L31;
        r106 = null;
    L31:
        if (r106 == null) goto L33;
        long r113 = r106.longValue();
    L34:
        r111.put("prepare_duration", RangesKt.coerceAtLeast(r113 - r210.f386627d, 0));
        r111.put("upload_duration", r103);
        r111.put("restore_duration", r105);
        if (r212 == null) goto L37;
    L39:
        long r107 = -1;
    L40:
        r111.put("thinking_duration", r107);
        if (r212 != null) goto L43;
    L46:
        boolean r108 = true;
    L47:
        if (r108 == true) goto L50;
        r111.put("err_code", r212);
    L50:
        if (r213 != null) goto L52;
    L55:
        boolean r109 = true;
    L56:
        if (r109 == true) goto L58;
        r111.put(LocationMonitorConst.ERR_MSG, r213);
    L58:
        BuildersKt.launch$default(f386616a, null, null, new SemanticTraceReporter$report$1(r111, null), 3, null);
        k(r210);
        return;
    L52:
        if (StringsKt.isBlank(r213) == true) goto L55;
        r109 = false;
        goto L56
    L43:
        if (StringsKt.isBlank(r212) == true) goto L46;
        r108 = false;
        goto L47
    L37:
        if (r100 <= 0) goto L39;
        r107 = RangesKt.coerceAtLeast(r211 - r100, 0);
        goto L40
    L33:
        r113 = r211;
        goto L34
    L26:
        r112 = false;
        goto L28
    L17:
        if (r110 <= 0) goto L22;
        if (r110 < r104) goto L22;
        r105 = RangesKt.coerceAtLeast(r110 - r104, 0);
        goto L23
    L8:
        if (r102 <= 0) goto L13;
        if (r102 < r101) goto L13;
        r103 = RangesKt.coerceAtLeast(r102 - r101, 0);
        goto L14
    }

    public static void n(String r100, long r101, String r110, String r111) {
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        Long r102 = f386618c.get(r100);
    L12:
        if (r102 == null) goto L14;
        long r103 = RangesKt.coerceAtLeast(r101 - r102.longValue(), 0);
    L15:
        JSONObject r104 = new JSONObject();
        if (r100 != null) goto L18;
        r100 = "";
    L18:
        r104.put("first_query_id", r100);
        r104.put("second_query_id", "");
        r104.put("all_duration", r103);
        r104.put("to_semantic_duration", r103);
        r104.put("prepare_duration", 0);
        r104.put("upload_duration", -1);
        r104.put("restore_duration", -1);
        r104.put("thinking_duration", -1);
        r104.put("err_code", r110);
        r104.put(LocationMonitorConst.ERR_MSG, r111);
        BuildersKt.launch$default(f386616a, null, null, new SemanticTraceReporter$report$1(r104, null), 3, null);
        return;
    L14:
        r103 = -1;
        goto L15
    L10:
        r102 = null;
        goto L12
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    public static void h(String r100, String r101, String r102, String r103, int r110) {
        String r104 = null;
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L14;
        long r105 = System.currentTimeMillis();
    L15:
        Object r111 = f386617b;
        monitor-enter(r111);
        if (r100 != null) goto L58;
    L25:
        a r106 = null;
    L26:
        boolean r107 = false;
        if (r102 != null) goto L29;
    L32:
        boolean r108 = true;
    L34:
        if ((!r108) == true) goto L37;
        r102 = null;
    L37:
        if (r102 != null) goto L39;
        r102 = "semantic_failed";
    L39:
        if (r103 != null) goto L41;
    L42:
        r107 = true;
    L44:
        if ((true ^ r107) == false) goto L46;
        r104 = r103;
    L46:
        if (r104 != null) goto L48;
        r104 = "semantic screen qa failed";
    L48:
        if (r106 == null) goto L52;
        l(r106, r105, r102, r104);     // Catch: Throwable -> L50
        c(r105);     // Catch: Throwable -> L50
    L53:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r111);
        return;
    L50:
        th = move-exception;
        throw th;
    L52:
        c(r105);     // Catch: Throwable -> L50
        n(r101, r105, r102, r104);     // Catch: Throwable -> L50
        goto L53
    L41:
        if (StringsKt.isBlank(r103) == false) goto L44;
    L29:
        if (StringsKt.isBlank(r102) == true) goto L32;
        r108 = false;
        goto L34
    L58:
        if ((!StringsKt.isBlank(r100)) == true) goto L23;
        r100 = null;
    L23:
        if (r100 == null) goto L25;
        r106 = (a) ((LinkedHashMap) f386621f).get(r100);     // Catch: Throwable -> L50
        goto L26
    L14:
        r105 = 0;
        goto L15
    }

    public static void j(String r110, boolean r111, String r112, String r113, int r114) {
        String r100 = null;
        if ((r114 & 4) == 0) goto L6;
        r112 = null;
    L6:
        if ((r114 & 8) == 0) goto L9;
        r113 = null;
    L9:
        if ((r114 & 16) == 0) goto L11;
        long r101 = System.currentTimeMillis();
    L12:
        Intrinsics.checkNotNullParameter(r110, LocationMonitorConst.IDENTIFIER);
        Object r115 = f386617b;
        monitor-enter(r115);
        c(r101);     // Catch: Throwable -> L52
        LinkedHashMap<String, b> r102 = f386619d;     // Catch: Throwable -> L52
        b r103 = r102.get(r110);     // Catch: Throwable -> L52
        boolean r104 = false;
        if (r103 != null) goto L17;
        r103 = new b(0);     // Catch: Throwable -> L52
        r102.put(r110, r103);     // Catch: Throwable -> L52
    L17:
        b r105 = r103;     // Catch: Throwable -> L52
        if (r105.f386636a > 0) goto L20;
        r105.f386636a = r101;     // Catch: Throwable -> L52
    L20:
        r105.f386637b = r101;     // Catch: Throwable -> L52
        r105.f386638c = RangesKt.coerceAtLeast(r101 - r105.f386636a, 0);     // Catch: Throwable -> L52
        r105.f386639d = Boolean.valueOf(r111);     // Catch: Throwable -> L52
        r105.f386640e = r112;     // Catch: Throwable -> L52
        r105.f386641f = r113;     // Catch: Throwable -> L52
        a r116 = (a) ((LinkedHashMap) f386622g).get(r110);     // Catch: Throwable -> L52
        if (r116 != null) goto L24;
        monitor-exit(r115);
        return;
    L24:
        r116.f386629f = r105.f386636a;     // Catch: Throwable -> L52
        r116.f386630g = r105.f386637b;     // Catch: Throwable -> L52
        if (r111 == false) goto L27;
    L49:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L52
        monitor-exit(r115);
        return;
    L27:
        if (r112 != null) goto L29;
    L32:
        boolean r106 = true;
    L34:
        if ((!r106) == true) goto L37;
        r112 = null;
    L37:
        if (r112 != null) goto L39;
        r112 = "upload_failed";
    L39:
        if (r113 != null) goto L41;
    L42:
        r104 = true;
    L44:
        if ((true ^ r104) == false) goto L46;
        r100 = r113;
    L46:
        if (r100 != null) goto L48;
        r100 = "upload failed";
    L48:
        l(r116, r101, r112, r100);     // Catch: Throwable -> L52
        goto L49
    L41:
        if (StringsKt.isBlank(r113) == false) goto L44;
    L29:
        if (StringsKt.isBlank(r112) == true) goto L32;
        r106 = false;
    L52:
        th = move-exception;
        throw th;
    L11:
        r101 = 0;
        goto L12
    }

    public static void e(String r100, boolean r110, String r111, String r112, long r113, int r114) {
        String r101 = null;
        if ((r114 & 4) == 0) goto L6;
        r111 = null;
    L6:
        if ((r114 & 8) == 0) goto L9;
        r112 = null;
    L9:
        if ((r114 & 16) == 0) goto L11;
        r113 = System.currentTimeMillis();
    L11:
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Object r115 = f386617b;
        monitor-enter(r115);
        c(r113);     // Catch: Throwable -> L54
        a r102 = (a) ((LinkedHashMap) f386622g).get(r100);     // Catch: Throwable -> L54
        if (r102 != null) goto L17;
        monitor-exit(r115);
        return;
    L17:
        Long r103 = Long.valueOf(r102.f386631h);     // Catch: Throwable -> L54
        boolean r104 = false;
        if (r103.longValue() <= 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L24;
        r103 = null;
    L24:
        if (r103 == null) goto L26;
        long r106 = r103.longValue();     // Catch: Throwable -> L54
    L27:
        r102.f386631h = r106;     // Catch: Throwable -> L54
        r102.f386632i = r113;     // Catch: Throwable -> L54
        if (r110 == true) goto L51;
        if (r111 != null) goto L31;
    L34:
        boolean r116 = true;
    L36:
        if ((!r116) == true) goto L39;
        r111 = null;
    L39:
        if (r111 != null) goto L41;
        r111 = "restore_failed";
    L41:
        if (r112 != null) goto L43;
    L44:
        r104 = true;
    L46:
        if ((!r104) == false) goto L48;
        r101 = r112;
    L48:
        if (r101 != null) goto L50;
        r101 = "restore image failed";
    L50:
        l(r102, r113, r111, r101);     // Catch: Throwable -> L54
        goto L51
    L43:
        if (StringsKt.isBlank(r112) == false) goto L46;
    L31:
        if (StringsKt.isBlank(r111) == true) goto L34;
        r116 = false;
    L51:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r115);
        return;
    L26:
        r106 = r113;
        goto L27
    L20:
        r105 = false;
    L54:
        th = move-exception;
        throw th;
    }
}
