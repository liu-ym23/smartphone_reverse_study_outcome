package com.obric.oui.indicator;

import android.animation.TimeInterpolator;
import android.view.View;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes34.dex */
public final class IndicatorAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f401141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f401142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f401143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f401144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f401145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f401146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f401147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f401148h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "", "", "logValue", "Ljava/lang/String;", "getLogValue", "()Ljava/lang/String;", "SCROLL", "REFRESH_DOTS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum RenderReason extends Enum<RenderReason> {
        public static final RenderReason REFRESH_DOTS = null;
        public static final RenderReason SCROLL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderReason[] f401149a = null;
        private final String logValue;

        public static RenderReason valueOf(String r100) {
            return (RenderReason) r27.a.a(RenderReason.class, r100);
        }

        public static RenderReason[] values() {
            return (RenderReason[]) f401149a.clone();
        }

        static {
            RenderReason r100 = new RenderReason("SCROLL", 0, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
            SCROLL = r100;
            RenderReason r101 = new RenderReason("REFRESH_DOTS", 1, "refreshDots");
            REFRESH_DOTS = r101;
            f401149a = new RenderReason[]{r100, r101};
        }

        public final String getLogValue() {
            return this.logValue;
        }

        public RenderReason(String r100, int r101, String r102) {
            super(r100, r101);
            this.logValue = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ScrollDirection;", "", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f401150a = null;

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f401150a.clone();
        }

        static {
            ScrollDirection r100 = new ScrollDirection("FORWARD", 0);
            FORWARD = r100;
            ScrollDirection r101 = new ScrollDirection("BACKWARD", 1);
            BACKWARD = r101;
            f401150a = new ScrollDirection[]{r100, r101};
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f401151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f401152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f401153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final IndicatorViewportShiftDirection f401154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RenderReason f401155e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f401151a == r101.f401151a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f401152b, r101.f401152b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f401153c, r101.f401153c) == true) goto L18;
            return false;
        L18:
            if (this.f401154d == r101.f401154d) goto L21;
            return false;
        L21:
            if (this.f401155e == r101.f401155e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f401151a * 31) + this.f401152b.hashCode()) * 31) + this.f401153c.hashCode()) * 31) + this.f401154d.hashCode()) * 31) + this.f401155e.hashCode();
        }

        public final String toString() {
            return "ActiveViewportTransition(transitionToken=" + this.f401151a + ", sourceState=" + this.f401152b + ", targetState=" + this.f401153c + ", direction=" + this.f401154d + ", reason=" + this.f401155e + ')';
        }

        public a(int r100, f r101, f r102, IndicatorViewportShiftDirection r103, RenderReason r104) {
            Intrinsics.checkNotNullParameter(r101, "sourceState");
            Intrinsics.checkNotNullParameter(r102, "targetState");
            Intrinsics.checkNotNullParameter(r103, "direction");
            Intrinsics.checkNotNullParameter(r104, "reason");
            this.f401151a = r100;
            this.f401152b = r101;
            this.f401153c = r102;
            this.f401154d = r103;
            this.f401155e = r104;
        }
    }

    public static final class b {
    }

    public interface c {
        int a();

        void b(f r100, f r101, float r102);

        void c(f r100, RenderReason r101);

        boolean d(IntRange r100);

        void e(f r100);

        float f();

        int g();
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401156a = null;

        static {
            int[] r100 = new int[ScrollDirection.values().length];
            r100[ScrollDirection.BACKWARD.ordinal()] = 1;
            r100[ScrollDirection.FORWARD.ordinal()] = 2;
            f401156a = r100;
        }
    }

    static {
    }

    public final void a(RenderReason r110, f r111) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        Intrinsics.checkNotNullParameter(r111, "nextViewportState");
        if (this.f401146f == null) goto L5;
        return;
    L5:
        f r100 = this.f401145e;
        if (r100 != null) goto L8;
        IntRange r101 = null;
    L9:
        boolean r102 = !Intrinsics.areEqual(r101, r111.f401261c);
        boolean r103 = false;
        if (r102 == false) goto L12;
    L15:
        boolean r104 = true;
    L17:
        if (r110 != RenderReason.SCROLL) goto L26;
        if (r102 == false) goto L26;
        if (r100 == null) goto L26;
        if (this.f401143c.a() <= this.f401143c.g()) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L46;
        if (r100 != null) goto L29;
        r100 = r111;
    L29:
        IntRange r105 = r100.f401261c;
        IntRange r106 = r111.f401261c;
        Intrinsics.checkNotNullParameter(r105, "currentRange");
        Intrinsics.checkNotNullParameter(r106, "nextRange");
        int r107 = r106.getFirst() - r105.getFirst();
        if (r107 == (-1)) goto L34;
        if (r107 == 1) goto L33;
        IndicatorViewportShiftDirection r108 = null;
    L35:
        if (r108 != null) goto L37;
        wma.b.h(this.f401144d, "Abort viewport transition because range shift is not adjacent, source=" + r100.f401261c + " target=" + r111.f401261c);
        this.f401143c.c(r111, r110);
        this.f401145e = r111;
        this.f401143c.e(r111);
        return;
    L37:
        float r109 = this.f401143c.f();
        if (r109 > 0.0f) goto L40;
        wma.b.h(this.f401144d, Intrinsics.stringPlus("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r109)));
        this.f401143c.c(r111, r110);
        this.f401145e = r111;
        this.f401143c.e(r111);
        return;
    L40:
        this.f401141a.setTranslationX(0.0f);
        f r112 = this.f401145e;
        if (r112 == null) goto L44;
        this.f401143c.e(r112);
    L44:
        int r113 = this.f401147g + 1;
        this.f401147g = r113;
        final a r114 = new a(r113, r100, r111, r108, r110);
        this.f401146f = r114;
        this.f401143c.b(r100, r111, 0.0f);
        float r115 = r108.resolveExitTranslation(r109);
        Function0<Unit> r116 = new IndicatorAnimator$startViewportTransition$1(this, r114);
        this.f401141a.animate().setUpdateListener(null).setListener(null).cancel();
        final float r117 = Math.abs(r115);
        this.f401141a.animate().translationX(r115).setDuration(300).setInterpolator(this.f401142b).setUpdateListener(new com.obric.oui.indicator.b(this, r114, r117)).setListener(new com.obric.oui.indicator.c(this, r114, r116)).start();
        return;
    L33:
        r108 = IndicatorViewportShiftDirection.FORWARD;
        goto L35
    L34:
        r108 = IndicatorViewportShiftDirection.BACKWARD;
        goto L35
    L46:
        if (r104 == false) goto L48;
        this.f401143c.c(r111, r110);
    L48:
        this.f401145e = r111;
        this.f401143c.e(r111);
        return;
    L12:
        if (this.f401143c.d(r111.f401261c) == true) goto L15;
        r104 = false;
        goto L17
    L8:
        r101 = r100.f401261c;
        goto L9
    }

    public IndicatorAnimator(View r100, TimeInterpolator r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "trackView");
        Intrinsics.checkNotNullParameter(r101, "interpolator");
        Intrinsics.checkNotNullParameter(r102, "host");
        this.f401141a = r100;
        this.f401142b = r101;
        this.f401143c = r102;
        this.f401144d = "OCarouselIndicator";
    }
}
