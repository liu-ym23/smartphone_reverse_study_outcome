package com.bytedance.timonbase.report;

import com.bytedance.timonbase.utils.EnumUtils$WorkType;
import com.bytedance.timonbase.utils.TMThreadUtils;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class TMMetric {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270829a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<a> f270830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f270831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f270832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f270833d;

        public a() {
            this(null, 7);
        }

        public a(String r100, int r101) {
            if ((r101 & 1) == 0) goto L6;
            r100 = "main_cost";
        L6:
            if ((r101 & 2) == 0) goto L8;
            long r102 = System.currentTimeMillis();
        L10:
            if ((r101 & 4) == 0) goto L12;
            JSONObject r103 = new JSONObject();
        L13:
            this.f270831b = r100;
            this.f270832c = r102;
            this.f270833d = r103;
            this.f270830a = new Stack();
            return;
        L12:
            r103 = null;
            goto L13
        L8:
            r102 = 0;
            goto L10
        }
    }

    public static void a() {
        TMThreadUtils r100 = TMThreadUtils.f270906d;
        TMMetric$checkReportTimonDyeMark$1 r101 = TMMetric$checkReportTimonDyeMark$1.INSTANCE;
        r100.getClass();
        TMThreadUtils.a(r101);
    }

    static {
    }

    public static void b(a r100, final boolean r101) {
        r100.f270833d.put(r100.f270831b, System.currentTimeMillis() - r100.f270832c);
        final JSONObject r102 = r100.f270833d;
        TMThreadUtils r103 = TMThreadUtils.f270906d;
        Function0<Unit> r104 = new TMMetric$reportInit$1(r102, r101);
        r103.getClass();
        TMThreadUtils.a(r104);
    }

    public static void d(a r100, EnumUtils$WorkType r101) {
        r100.f270833d.put(r100.f270831b, System.currentTimeMillis() - r100.f270832c);
        final JSONObject r102 = r100.f270833d;
        r102.put("service_work_type", r101.name());
        TMThreadUtils r103 = TMThreadUtils.f270906d;
        Function0<Unit> r104 = new TMMetric$reportServiceInit$1(r102);
        r103.getClass();
        TMThreadUtils.a(r104);
    }

    public static void e(int r100, String r101) {
        final JSONObject r102 = new JSONObject();
        r102.put("status", r100);
        r102.put("error_msg", r101);
        TMThreadUtils r103 = TMThreadUtils.f270906d;
        Function0<Unit> r104 = new TMMetric$reportSilentInit$1(r102);
        r103.getClass();
        TMThreadUtils.a(r104);
    }

    public static void c(boolean r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("succeed", r100 ? 1 : 0);
        r103.put("retry_count", r101);
        r103.put("error_message", r102);
        TMDataCollector.e("timon_setting_fetcher", r103, false, 8);
    }
}
