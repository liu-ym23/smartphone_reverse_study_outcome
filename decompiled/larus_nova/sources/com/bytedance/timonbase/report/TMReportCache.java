package com.bytedance.timonbase.report;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.timonbase.TMEnv;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TMReportCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, a> f270835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f270836c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f270837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f270838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f270839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f270840d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f270841e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f270842f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f270843g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f270844h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f270845i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f270846j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L26;
            a r101 = (a) r100;
            if (this.f270837a == r101.f270837a) goto L8;
            return false;
        L8:
            if (this.f270838b == r101.f270838b) goto L10;
            return false;
        L10:
            if (this.f270839c == r101.f270839c) goto L12;
            return false;
        L12:
            if (this.f270840d == r101.f270840d) goto L14;
            return false;
        L14:
            if (this.f270841e == r101.f270841e) goto L16;
            return false;
        L16:
            if (this.f270842f == r101.f270842f) goto L18;
            return false;
        L18:
            if (this.f270843g == r101.f270843g) goto L20;
            return false;
        L20:
            if (Float.compare(this.f270844h, r101.f270844h) == 0) goto L22;
            return false;
        L22:
            if (this.f270845i == r101.f270845i) goto L24;
            return false;
        L24:
            if (this.f270846j == r101.f270846j) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        public final int hashCode() {
            return (((((((((((((((((this.f270837a * 31) + this.f270838b) * 31) + this.f270839c) * 31) + this.f270840d) * 31) + this.f270841e) * 31) + this.f270842f) * 31) + this.f270843g) * 31) + Float.floatToIntBits(this.f270844h)) * 31) + this.f270845i) * 31) + this.f270846j;
        }

        public final String toString() {
            return "ApiCallBatch(id=" + this.f270837a + ", count=" + this.f270838b + ", rulerSetup=" + this.f270839c + ", heliosSetup=" + this.f270840d + ", rulerReady=" + this.f270841e + ", isMainThread=" + this.f270842f + ", intercept=" + this.f270843g + ", cost=" + this.f270844h + ", interceptCount=" + this.f270845i + ", reportCount=" + this.f270846j + ")";
        }

        public a(int r100) {
            this.f270837a = r100;
            this.f270838b = 0;
            this.f270839c = 0;
            this.f270840d = 0;
            this.f270841e = 0;
            this.f270842f = 0;
            this.f270843g = 0;
            this.f270844h = 0.0f;
            this.f270845i = 0;
            this.f270846j = 0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f270847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f270848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f270849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f270850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f270851e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f270852f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Long f270853g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f270854h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f270855i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f270856j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L26;
            b r101 = (b) r100;
            if (this.f270847a == r101.f270847a) goto L8;
            return false;
        L8:
            if (this.f270848b == r101.f270848b) goto L10;
            return false;
        L10:
            if (this.f270849c == r101.f270849c) goto L12;
            return false;
        L12:
            if (this.f270850d == r101.f270850d) goto L14;
            return false;
        L14:
            if (this.f270851e == r101.f270851e) goto L16;
            return false;
        L16:
            if (this.f270852f == r101.f270852f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f270853g, r101.f270853g) == true) goto L20;
            return false;
        L20:
            if (this.f270854h == r101.f270854h) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f270855i, r101.f270855i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f270856j, r101.f270856j) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r100 = this.f270847a * 31;
            boolean r101 = this.f270848b;
            ?? r102 = 1;
            ?? r103 = r101;
            if (r101 == false) goto L5;
            r103 = 1;
        L5:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f270849c;
            ?? r106 = r105;
            if (r105 == false) goto L8;
            r106 = 1;
        L8:
            int r107 = (r104 + r106) * 31;
            boolean r108 = this.f270850d;
            ?? r109 = r108;
            if (r108 == false) goto L11;
            r109 = 1;
        L11:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f270851e;
            ?? r112 = r111;
            if (r111 == false) goto L14;
            r112 = 1;
        L14:
            int r113 = (r110 + r112) * 31;
            boolean r114 = this.f270852f;
            ?? r115 = r114;
            if (r114 == false) goto L17;
            r115 = 1;
        L17:
            int r116 = (r113 + r115) * 31;
            Long r117 = this.f270853g;
            int r118 = 0;
            if (r117 == null) goto L20;
            int r119 = r117.hashCode();
        L21:
            int r120 = (r116 + r119) * 31;
            boolean r121 = this.f270854h;
            if (r121 == true) goto L25;
            r102 = r121;
        L25:
            int r122 = (r120 + r102) * 31;
            String r123 = this.f270855i;
            if (r123 == null) goto L28;
            int r124 = r123.hashCode();
        L29:
            int r125 = (r122 + r124) * 31;
            String r126 = this.f270856j;
            if (r126 == null) goto L33;
            r118 = r126.hashCode();
        L33:
            return r125 + r118;
        L28:
            r124 = 0;
            goto L29
        L20:
            r119 = 0;
            goto L21
        }

        public final String toString() {
            return "ApiCallEvent(id=" + this.f270847a + ", rulerSetup=" + this.f270848b + ", heliosSetup=" + this.f270849c + ", rulerReady=" + this.f270850d + ", isMainThread=" + this.f270851e + ", intercept=" + this.f270852f + ", cost=" + this.f270853g + ", isTimonInitialized=" + this.f270854h + ", rulerBlockResult=" + this.f270855i + ", rulerReportResult=" + this.f270856j + ")";
        }

        public b(int r100, boolean r101, boolean r102, boolean r103, boolean r104, Long r105, boolean r106) {
            this.f270847a = r100;
            this.f270848b = r101;
            this.f270849c = r102;
            this.f270850d = false;
            this.f270851e = r103;
            this.f270852f = r104;
            this.f270853g = r105;
            this.f270854h = r106;
            this.f270855i = null;
            this.f270856j = null;
        }
    }

    public static final class c extends Handler {
        public c(Looper r100) {
            super(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v5 */
        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            Lazy r102 = TMReportCache.f270834a;
            Object r103 = r100.obj;
            if (r103 == null) goto L68;
            b r104 = (b) r103;
            if (r104.f270849c == true) goto L37;
        L39:
            Map<Integer, a> r105 = TMReportCache.f270835b;
            if (r105.containsKey(Integer.valueOf(r104.f270847a)) == true) goto L42;
            r105.put(Integer.valueOf(r104.f270847a), new a(r104.f270847a));
        L42:
            a r106 = (a) ((LinkedHashMap) r105).get(Integer.valueOf(r104.f270847a));
            if (r106 == null) goto L77;
            Long r107 = r104.f270853g;
            if (r107 == null) goto L51;
            r107.longValue();
            int r108 = r106.f270838b;
            if (r108 <= 0) goto L49;
            r106.f270844h = (r106.f270844h * (r108 / (r108 + 1))) + (r104.f270853g.longValue() * ((long) (1 / (r106.f270838b + 1))));
            goto L51
        L49:
            r106.f270844h = r104.f270853g.longValue();
        L51:
            if (r104.f270849c == false) goto L54;
            r106.f270840d++;
        L54:
            if (r104.f270848b == false) goto L57;
            r106.f270839c++;
        L57:
            if (r104.f270850d == false) goto L60;
            r106.f270841e++;
        L60:
            if (r104.f270851e == false) goto L63;
            r106.f270842f++;
        L63:
            if (r104.f270852f == false) goto L65;
            r106.f270843g++;
        L65:
            r106.f270838b++;
            return;
        L77:
            return;
        L37:
            if (r104.f270848b == false) goto L39;
            TMReportCache.f270836c = false;
            goto L39
        L68:
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timonbase.report.TMReportCache.ApiCallEvent");
        L5:
            if (r101 != 1000) goto L7;
            Map<Integer, a> r109 = TMReportCache.f270835b;
            if (r109.isEmpty() == true) goto L79;
            Iterator r110 = ((LinkedHashMap) r109).values().iterator();
            int r111 = 0;
        L21:
            if (r110.hasNext() == false) goto L23;
            r111 = r111 + ((a) r110.next()).f270838b;
            goto L21
        L23:
            Iterator r112 = ((LinkedHashMap) TMReportCache.f270835b).entrySet().iterator();
        L25:
            if (r112.hasNext() == false) goto L31;
            Map.Entry r113 = (Map.Entry) r112.next();
            a r114 = (a) r113.getValue();
            Application r115 = TMEnv.f270769c;
            if (r115 == null) goto L29;
            int r116 = com.bytedance.timonbase.utils.a.c(r115);
        L30:
            JSONObject r117 = new JSONObject();
            r117.put("api_id", ((Number) r113.getKey()).intValue());
            r117.put("main_process", r116);
            r117.put("count", r114.f270838b);
            r117.put("sum_count", r111);
            r117.put("helios_setup", r114.f270840d);
            r117.put("ruler_setup", r114.f270839c);
            r117.put("ruler_ready", r114.f270841e);
            r117.put("main_thread", r114.f270842f);
            r117.put(ChameleonOpenTracker.ParamKey.COST, Float.valueOf(r114.f270844h));
            r117.put("basicModeEnable", 0);
            r117.put("is_intercept", r114.f270845i);
            r117.put("hit_report", r114.f270846j);
            TMDataCollector.e("timon_api_call", r117, false, 12);
            goto L25
        L29:
            r116 = 0;
            goto L30
        L31:
            ((LinkedHashMap) TMReportCache.f270835b).clear();
            return;
        L79:
            return;
        L7:
            if (r101 != 1001) goto L78;
            CopyOnWriteArrayList<Function0<Unit>> r118 = com.bytedance.timonbase.cache.a.f270801a;
            if (r118.size() <= 0) goto L74;
            Iterator<Function0<Unit>> r119 = r118.iterator();
        L13:
            if (r119.hasNext() == false) goto L15;
            r119.next().invoke();
            goto L13
        L15:
            com.bytedance.timonbase.cache.a.f270801a.clear();
            return;
        L74:
            return;
        }
    }

    static {
        f270834a = LazyKt.lazy(TMReportCache$reportHandler$2.INSTANCE);
        f270835b = new LinkedHashMap();
        f270836c = true;
    }
}
