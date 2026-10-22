package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class StorePreviewPerfChecker {
    public static final Lazy g = null;
    public final Handler a;
    public final PreviewPerfMetric b;
    public e c;
    public final String d;
    public final l e;
    public final String f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ jh.a a;
        public final /* synthetic */ StorePreviewPerfChecker b;
        public final /* synthetic */ long c;

        public b(jh.a r1, StorePreviewPerfChecker r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.stop();     // Catch: Throwable -> L4
            this.b.c(this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        g = LazyKt.lazy(StorePreviewPerfChecker$Companion$perfConfig$2.INSTANCE);
    }

    public static double a(List r5) {
        if (r5.isEmpty() == false) goto L6;
        return 0.0d;
    L6:
        List r6 = CollectionsKt.sorted(r5);
        int r0 = r6.size();
        if ((r0 % 2) == 1) goto L11;
        int r1 = r0 / 2;
        return (((Number) ListProtector.get(r6, r1 - 1)).doubleValue() + ((Number) ListProtector.get(r6, r1)).doubleValue()) / ((double) 2);
    L11:
        return ((Number) ListProtector.get(r6, (r0 - 1) / 2)).doubleValue();
    }

    public final void b(ECStoreParam r8) {
        Intrinsics.checkNotNullParameter(r8, "storeParam");
        if (r8.isPreview() == false) goto L34;
        String r0 = this.d;
        Lazy r1 = g;
        f r2 = (f) r1.getValue();
        boolean r3 = true;
        int r4 = 0;
        String r5 = null;
        if (r2 != null) goto L7;
        Boolean r6 = null;
    L18:
        if (k.i(r6) == false) goto L24;
        JSONObject r9 = k.w(r8.getPassthroughHybrid());
        if (r9 == null) goto L24;
        if (r9.has("isv_unique_id") != true) goto L24;
    L25:
        if (r3 == false) goto L35;
        JSB r10 = this.b.getJsb();
        StoreLynxJsbChecker.a r7 = StoreLynxJsbChecker.f;
        String r11 = this.f;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r11, "tabId");
        com.bytedance.android.shopping.store.hybrid.jsbcheck.a r12 = (com.bytedance.android.shopping.store.hybrid.jsbcheck.a) ((Map) StoreLynxJsbChecker.e.getValue()).get(((Map) StoreLynxJsbChecker.d.getValue()).get(r11));
        if (r12 == null) goto L29;
        r5 = r12.a();
    L29:
        r10.setSecurityConfigVersion(r5);
        PreviewPerfMetric r13 = this.b;
        f r14 = (f) r1.getValue();
        if (r14 == null) goto L32;
        r4 = r14.a();
    L32:
        r13.setPerfDuration(Integer.valueOf(r4));
        this.c = new e(new StorePreviewPerfChecker$startCheck$1(this));
        c(System.currentTimeMillis());
        return;
    L35:
        return;
    L24:
        r3 = false;
        goto L25
    L7:
        if (r2.a() <= 0) goto L14;
        Map<String, Integer> r15 = r2.b();
        if (r15 == null) goto L11;
        boolean r16 = r15.containsKey(r0);
    L12:
        if (r16 == false) goto L14;
        boolean r17 = true;
    L15:
        r6 = Boolean.valueOf(r17);
        goto L18
    L11:
        r16 = false;
    L14:
        r17 = false;
        goto L15
    }

    public final void c(long r6) {
        long r0 = System.currentTimeMillis() - r6;
        f r2 = (f) g.getValue();
        if (r2 == null) goto L5;
        int r3 = r2.a();
    L7:
        if (r0 <= (r3 * ECDraweeView.SQUARE)) goto L12;
        this.b.getCpuUsage().setAvg(Double.valueOf(CollectionsKt.averageOfDouble(this.b.getCpuUsage().getDetail())));
        this.b.getCpuUsage().setMedian(Double.valueOf(a(this.b.getCpuUsage().getDetail())));
        this.b.getFps().setAvg(Double.valueOf(CollectionsKt.averageOfDouble(this.b.getFps().getDetail())));
        this.b.getFps().setMedian(Double.valueOf(a(this.b.getFps().getDetail())));
        l r7 = this.e;
        if (r7 == null) goto L16;
        r7.sendJsEvent("ecom.shop.preview_perf_metrics", GsonProtectorUtils.toJson(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create(), this.b));
        return;
    L16:
        return;
    L12:
        e r1 = this.c;
        if (r1 == null) goto L17;
        r1.a();
        this.a.postDelayed(new b(r1, this, r6), 1000);
        return;
    L17:
        return;
    L5:
        r3 = 0;
        goto L7
    }

    public StorePreviewPerfChecker(String r2, l r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "secShopId");
        Intrinsics.checkNotNullParameter(r4, "tabId");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new Handler(Looper.getMainLooper());
        this.b = new PreviewPerfMetric();
    }
}
