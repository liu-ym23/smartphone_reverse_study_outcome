package com.larus.avlink.gallery.power.monitor;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.avlink.gallery.processor.k;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import com.larus.power.state.api.ThermalLevel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;
import wr9.i;
import wr9.j;
import wr9.l;

/* JADX INFO: loaded from: classes25.dex */
public final class AlbumVideoThermalRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<i> f292638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wr9.e f292639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<com.larus.avlink.gallery.power.monitor.a, Unit> f292640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Throwable, Unit> f292641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f292642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f292643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f292644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f292645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f292646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f292647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ThermalLevel f292648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PowerMetricSource f292649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f292650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f292651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f292652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f292653p;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.power.monitor.AlbumVideoThermalRecorder$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.larus.avlink.gallery.power.monitor.a, Unit> {
        public AnonymousClass3(Object r100) {
            super(1, r100, GalleryMobHelper.class, "mobVideoThermalInfo", "mobVideoThermalInfo$dora_avlink_impl_release(Lcom/larus/avlink/gallery/power/monitor/AlbumVideoThermalMetrics;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.larus.avlink.gallery.power.monitor.a r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ((GalleryMobHelper) this.receiver).getClass();
            Intrinsics.checkNotNullParameter(r100, "metrics");
            r100.getClass();
            GalleryMobHelper.i("flow_biz_thermal_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "gallery_video"), TuplesKt.to("duration", Long.valueOf(r100.f292655a)), TuplesKt.to("moderate_duration", Long.valueOf(r100.f292656b)), TuplesKt.to("severe_duration", Long.valueOf(r100.f292657c)), TuplesKt.to("thermal_valid", Integer.valueOf(r100.f292658d ? 1 : 0)), TuplesKt.to("result", r100.f292659e)}));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.larus.avlink.gallery.power.monitor.a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292654a = null;

        static {
            int[] r100 = new int[ThermalLevel.values().length];
            r100[ThermalLevel.MODERATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ThermalLevel.SEVERE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ThermalLevel.CRITICAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ThermalLevel.EMERGENCY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ThermalLevel.SHUTDOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ThermalLevel.NONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ThermalLevel.LIGHT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f292654a = r100;
        }
    }

    public final void e() {
        i r100 = this.f292643f;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f292643f = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        r100.G8(this.f292653p);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L21;
        b(r103);
    L21:
        r100.close();     // Catch: Throwable -> L15
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L25;
        b(r105);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [com.larus.avlink.gallery.power.monitor.e] */
    public AlbumVideoThermalRecorder(Object r100) {
        Function0<i> r101 = new b();
        wr9.e r102 = new c();
        AnonymousClass3 r103 = new AnonymousClass3(GalleryMobHelper.f293006a);
        Function1<Throwable, Unit> r104 = new d();
        Intrinsics.checkNotNullParameter(r101, "openSession");
        Intrinsics.checkNotNullParameter(r102, "clock");
        Intrinsics.checkNotNullParameter(r103, "report");
        Intrinsics.checkNotNullParameter(r104, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f292638a = r101;
        this.f292639b = r102;
        this.f292640c = r103;
        this.f292641d = r104;
        this.f292642e = new Object();
        this.f292647j = Long.MIN_VALUE;
        this.f292648k = ThermalLevel.UNKNOWN;
        this.f292652o = true;
        this.f292653p = new e(this);
    }

    public final void b(Throwable r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        this.f292641d.invoke(r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        Object r111 = this.f292642e;
        monitor-enter(r111);
        Long r100 = this.f292644g;     // Catch: Throwable -> L37
        if (r100 == null) goto L35;
        long r101 = r100.longValue();     // Catch: Throwable -> L37
        if (this.f292645h == false) goto L10;
        monitor-exit(r111);
        return;
    L10:
        long r102 = RangesKt.coerceAtLeast(this.f292639b.a(), this.f292646i);     // Catch: Throwable -> L37
        i r103 = this.f292643f;     // Catch: Throwable -> L21
        if (r103 == null) goto L24;
        j r104 = r103.o();     // Catch: Throwable -> L21
        if (r104 == null) goto L24;
        l r105 = r104.f560895b;     // Catch: Throwable -> L21
        if (r105 == null) goto L24;
        wr9.d<ThermalLevel> r106 = r105.f560904a;     // Catch: Throwable -> L21
        if (r106 == null) goto L24;
        a(r106, r102);     // Catch: Throwable -> L21
    L24:
        f(r102);     // Catch: Throwable -> L37
        this.f292645h = true;     // Catch: Throwable -> L37
        com.larus.avlink.gallery.power.monitor.a r107 = new com.larus.avlink.gallery.power.monitor.a(r102 - r101, this.f292650m, this.f292651n, this.f292652o, r110);     // Catch: Throwable -> L37
        monitor-exit(r111);
        e();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L29
        this.f292640c.invoke(r107);     // Catch: Throwable -> L29
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L46;
        b(r112);
        return;
    L46:
        return;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        this.f292652o = false;     // Catch: Throwable -> L37
        b(th);     // Catch: Throwable -> L37
        goto L24
    L35:
        monitor-exit(r111);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public final void f(long r100) {
        long r101 = r100 - this.f292646i;
        switch(a.f292654a[this.f292648k.ordinal()]) {
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L5;
        };
    L6:
        this.f292651n += r101;
        goto L8
    L7:
        this.f292650m += r101;
    L8:
        this.f292646i = r100;
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(wr9.d<ThermalLevel> r110, long r111) {
        ThermalLevel r100 = r110.f560886a;
        ThermalLevel r101 = r100;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L13:
        r101 = ThermalLevel.UNKNOWN;
    L14:
        long r103 = r110.f560889d;
        long r104 = this.f292647j;
        if (r103 >= r104) goto L23;
        if (r101 == this.f292648k) goto L19;
    L20:
        this.f292652o = false;
        return;
    L19:
        if (r110.f560888c != this.f292649l) goto L20;
        return;
    L23:
        if (r104 == Long.MIN_VALUE) goto L26;
        r102 = false;
    L26:
        if (r102 == true) goto L31;
        if (this.f292649l == r110.f560888c) goto L31;
        this.f292652o = false;
    L31:
        if (r101 != ThermalLevel.UNKNOWN) goto L34;
        this.f292652o = false;
    L34:
        if (r103 <= r111) goto L36;
        this.f292652o = false;
    L36:
        if (r102 == false) goto L38;
    L42:
        this.f292647j = r103;
        this.f292649l = r110.f560888c;
        if (r102 == false) goto L46;
        this.f292648k = r101;
        return;
    L46:
        if (r101 == this.f292648k) goto L51;
        f(RangesKt.coerceIn(r103, this.f292646i, r111));
        this.f292648k = r101;
        return;
    L51:
        return;
    L38:
        if (r103 != r104) goto L42;
        if (r101 == this.f292648k) goto L42;
        this.f292652o = false;
        goto L42
    L5:
        if (r110.f560887b != PowerMetricAvailability.AVAILABLE) goto L8;
        if (r100 == null) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L12;
        r101 = null;
    L12:
        if (r101 != null) goto L14;
    L8:
        r105 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    public final Object d(Function1<? super Continuation<? super k>, ? extends Object> r110, Continuation<? super k> r111) {
        if ((r111 instanceof AlbumVideoThermalRecorder$record$1) == false) goto L7;
        AlbumVideoThermalRecorder$record$1 r100 = (AlbumVideoThermalRecorder$record$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        Ref.ObjectRef r113 = (Ref.ObjectRef) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14 CancellationException -> L16
    L56:
        k r104 = (k) r112;     // Catch: Throwable -> L14 CancellationException -> L16
        if (JobKt.isActive(r100.getContext()) == true) goto L60;
        ?? r105 = "cancelled";
    L66:
        r113.element = r105;     // Catch: Throwable -> L14 CancellationException -> L16
        c(r105);
        return r112;
    L60:
        if (r104.f292690a == true) goto L63;
        r105 = "failed";
        goto L66
    L63:
        if (r104.f292695f == false) goto L65;
        r105 = "fallback";
        goto L66
    L65:
        r105 = "success";
    L16:
        CancellationException e100 = e;
    L73:
        r113.element = "cancelled";     // Catch: Throwable -> L14
        throw e100;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Ref.ObjectRef r114 = r113;
        th = th;
    L76:
        c((String) r114.element);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r112);
        Object r115 = this.f292642e;
        monitor-enter(r115);
    L78:
        th = move-exception;
        throw th;
    L23:
        if (this.f292644g == null) goto L25;
    L50:
        monitor-exit(r115);
    L51:
        r114 = new Ref.ObjectRef();
        r114.element = "failed";
        r100.L$0 = r114;     // Catch: Throwable -> L69 CancellationException -> L71
        r100.label = 1;     // Catch: Throwable -> L69 CancellationException -> L71
        Object r116 = r110.invoke(r100);     // Catch: Throwable -> L69 CancellationException -> L71
        if (r116 != r102) goto L55;
        return r102;
    L55:
        r112 = r116;
        r113 = r114;
        goto L56
    L71:
        e = move-exception;
        e100 = e;
        r113 = r114;
    L69:
        th = th;
        goto L76
    L25:
        if (this.f292645h == true) goto L50;
        Function0<i> r106 = this.f292638a;     // Catch: Throwable -> L78
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L30
        Object r108 = Result.m9449constructorimpl(r106.invoke());     // Catch: Throwable -> L30
    L32:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L78
        if (r109 == null) goto L36;
        b(r109);     // Catch: Throwable -> L78
    L36:
        if (Result.m9455isFailureimpl(r108) == false) goto L38;
        r108 = null;
    L38:
        this.f292643f = (i) r108;     // Catch: Throwable -> L78
        long r117 = this.f292639b.a();     // Catch: Throwable -> L78
        this.f292644g = Long.valueOf(r117);     // Catch: Throwable -> L78
        this.f292646i = r117;     // Catch: Throwable -> L78
        i r118 = this.f292643f;     // Catch: Throwable -> L78
        if (r118 != null) goto L81;
        this.f292652o = false;     // Catch: Throwable -> L78
        monitor-exit(r115);
        goto L51
    L81:
        a(r118.o().f560895b.f560904a, r117);     // Catch: Throwable -> L45
        r118.Gb(this.f292653p);     // Catch: Throwable -> L45
        r118.start();     // Catch: Throwable -> L45
    L47:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L78
        monitor-exit(r115);
        goto L51
    L45:
        th = move-exception;
        this.f292652o = false;     // Catch: Throwable -> L78
        this.f292648k = ThermalLevel.UNKNOWN;     // Catch: Throwable -> L78
        e();     // Catch: Throwable -> L78
        b(th);     // Catch: Throwable -> L78
        goto L47
    L30:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L78
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
    L7:
        r100 = new AlbumVideoThermalRecorder$record$1(this, r111);
        goto L8
    }
}
