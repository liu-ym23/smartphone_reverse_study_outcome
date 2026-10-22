package com.ss.android.ugc.aweme.search.common.monitor.fps;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import et3.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/RealECFpsMonitor;", "Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsMonitor;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class RealECFpsMonitor implements ECFpsMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f451812h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECFpsReporter f451813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECGcTracker f451814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f451815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f451816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f451817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f451818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RealECFpsMonitor$scrollListener$1 f451819g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/RealECFpsMonitor$Companion;", "", "()V", "KEY_FPS_STOP_REASON", "", "KEY_UI_TYPE", "STOP_REASON_NORMAL", "UI_TYPE_RECYCLER_VIEW", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final void e() {
        if (this.f451816d == false) goto L5;
        return;
    L5:
        this.f451817e = SystemClock.uptimeMillis();
        ECGcTracker r100 = this.f451814b;
        r100.getClass();
        r100.f451806a = ECGcTracker.a("art.gc.gc-count");
        r100.f451807b = ECGcTracker.a("art.gc.gc-time");
        r100.f451808c = ECGcTracker.a("art.gc.bytes-allocated");
        r100.f451809d = ECGcTracker.a("art.gc.bytes-freed");
        this.f451815c.c();
        this.f451816d = true;
    }

    @Override // com.ss.android.ugc.aweme.search.common.monitor.fps.ECFpsMonitor
    public final void stop() {
        if (this.f451816d == true) goto L5;
        return;
    L5:
        long r100 = SystemClock.uptimeMillis() - this.f451817e;
        ECFpsReporter r101 = this.f451813a;
        r101.f451793f = r100;
        ECAppInfoUtils.f451786a.getClass();
        r101.f451794g = ECAppInfoUtils.a();
        this.f451813a.f451795h = ECAppInfoUtils.a();
        ECFpsReporter r102 = this.f451813a;
        ECGcTracker r103 = this.f451814b;
        r103.getClass();
        Map r104 = MapsKt.mapOf(new Pair[]{TuplesKt.to("gc_count", Long.valueOf(RangesKt.coerceAtLeast(ECGcTracker.a("art.gc.gc-count") - r103.f451806a, 0))), TuplesKt.to("gc_time", Long.valueOf(RangesKt.coerceAtLeast(ECGcTracker.a("art.gc.gc-time") - r103.f451807b, 0))), TuplesKt.to("gc_bytes_allocated", Long.valueOf(RangesKt.coerceAtLeast(ECGcTracker.a("art.gc.bytes-allocated") - r103.f451808c, 0))), TuplesKt.to("gc_bytes_freed", Long.valueOf(RangesKt.coerceAtLeast(ECGcTracker.a("art.gc.bytes-freed") - r103.f451809d, 0)))});
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "map");
        Iterator r105 = r104.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.a((String) r106.getKey(), r106.getValue());
        goto L7
    L9:
        this.f451813a.a("fps_stop_reason", "normal");
        this.f451815c.d();
        this.f451816d = false;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.ss.android.ugc.aweme.search.common.monitor.fps.RealECFpsMonitor$scrollListener$1] */
    public RealECFpsMonitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f451813a = new ECFpsReporter(r100);
        this.f451814b = new ECGcTracker();
        ECSearchFpsConfig.f451811b.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        h r101 = new h(r100, ECSearchFpsConfig.f451810a.contains(r100), null);
        r101.f473916d = new RealECFpsMonitor$$special$$inlined$apply$lambda$1(this);
        r101.f473917e = new RealECFpsMonitor$$special$$inlined$apply$lambda$2(this);
        Unit r102 = Unit.INSTANCE;
        this.f451815c = r101;
        this.f451819g = new RealECFpsMonitor$scrollListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.search.common.monitor.fps.ECFpsMonitor
    public final ECFpsMonitor a(Object r100) {
        Intrinsics.checkNotNullParameter("ec_scene", "key");
        ECFpsReporter r101 = this.f451813a;
        r101.getClass();
        Intrinsics.checkNotNullParameter("ec_scene", "key");
        if (StringsKt.isBlank("ec_scene") == false) goto L5;
    L11:
        return this;
    L5:
        if (r101.f451790c.size() >= 10) goto L11;
        LinkedHashMap<String, Object> r102 = r101.f451790c;
        if (r100 != null) goto L10;
        r100 = "null";
    L10:
        r102.put("ec_scene", r100);
        goto L11
    }

    @Override // com.ss.android.ugc.aweme.search.common.monitor.fps.ECFpsMonitor
    public final ECFpsMonitor b(RecyclerView r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        RecyclerView r101 = this.f451818f;
        if (r101 == r100) goto L9;
        if (r101 == null) goto L8;
        r101.removeOnScrollListener(this.f451819g);
    L8:
        this.f451818f = r100;
    L9:
        r100.removeOnScrollListener(this.f451819g);
        r100.addOnScrollListener(this.f451819g);
        return this;
    }

    @Override // com.ss.android.ugc.aweme.search.common.monitor.fps.ECFpsMonitor
    public final ECFpsMonitor c(Function0<? extends Map<String, String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f451813a.f451788a = r100;
        return this;
    }

    @Override // com.ss.android.ugc.aweme.search.common.monitor.fps.ECFpsMonitor
    public final ECFpsMonitor d(RecyclerView r100) {
        if (r100 != null) goto L4;
        r100 = this.f451818f;
    L4:
        if (r100 == null) goto L7;
        r100.removeOnScrollListener(this.f451819g);
    L7:
        if (r100 != this.f451818f) goto L9;
        this.f451818f = null;
    L9:
        return this;
    }
}
