package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.data.l;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.interact.AbstractInteractBehavior;
import com.bytedance.locallife.dito.interact.CustomBottomBehavior;
import com.bytedance.locallife.dito.interact.HeadUnfoldState;
import com.bytedance.locallife.poi.fragment.PoiDetailBizContainerFragment;
import com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.event.PoiChangePageStateEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiTransitionSkeletonPlugin;", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", "Lcom/ss/android/ugc/aweme/poi/event/PoiChangePageStateEvent;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", ce.f26391f, "TransitionType", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiTransitionSkeletonPlugin extends PoiDetailBizContainerPlugin {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f264003i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f264004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f264005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f264006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f264007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f264008h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiTransitionSkeletonPlugin$TransitionType;", "", "HALF_TO_COLLAPSED", "COLLAPSED_TO_HALF", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType COLLAPSED_TO_HALF = null;
        public static final TransitionType HALF_TO_COLLAPSED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f264009a = null;

        public static TransitionType valueOf(String r100) {
            return (TransitionType) r27.a.a(TransitionType.class, r100);
        }

        public static TransitionType[] values() {
            return (TransitionType[]) f264009a.clone();
        }

        static {
            TransitionType r100 = new TransitionType("HALF_TO_COLLAPSED", 0);
            HALF_TO_COLLAPSED = r100;
            TransitionType r101 = new TransitionType("COLLAPSED_TO_HALF", 1);
            COLLAPSED_TO_HALF = r101;
            f264009a = new TransitionType[]{r100, r101};
        }

        public TransitionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f264010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f264011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f264012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TransitionType f264013d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f264014e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f264015f;

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
            if (Intrinsics.areEqual(this.f264010a, r101.f264010a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264011b, r101.f264011b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f264012c, r101.f264012c) == true) goto L18;
            return false;
        L18:
            if (this.f264013d == r101.f264013d) goto L21;
            return false;
        L21:
            if (this.f264014e == r101.f264014e) goto L24;
            return false;
        L24:
            if (this.f264015f == r101.f264015f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f264010a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f264011b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f264012c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            TransitionType r110 = this.f264013d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            int r111 = (r109 + r101) * 31;
            int r112 = 1231;
            if (this.f264014e == false) goto L21;
            int r113 = 1231;
        L22:
            int r114 = (r111 + r113) * 31;
            if (this.f264015f == true) goto L27;
            r112 = 1237;
        L27:
            return r114 + r112;
        L21:
            r113 = 1237;
            goto L22
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ContainerRuntimeState(lastState=" + this.f264010a + ", lastStableState=" + this.f264011b + ", latestContainerTop=" + this.f264012c + ", activeTransition=" + this.f264013d + ", isManualTransitionActive=" + this.f264014e + ", isSettleOnlySuppressed=" + this.f264015f + ')';
        }

        public b(int r100) {
            this.f264010a = null;
            this.f264011b = null;
            this.f264012c = null;
            this.f264013d = null;
            this.f264014e = false;
            this.f264015f = false;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f264016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiTransitionSkeletonPlugin f264017b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f264018a;

            public a(c r100) {
                this.f264018a = r100;
            }

            public final void a() {
                c r100 = this.f264018a;
                d r101 = r100.f264016a;
                r101.f264025g = null;
                if (r101.f264020b > 0.01f) goto L6;
                r100.c();
                return;
            L6:
                if (r101.f264019a == false) goto L26;
                SkeletonItemDecoration r102 = r100.e();
                if (r102 == null) goto L27;
                ValueAnimator r103 = r100.f264016a.f264024f;
                if (r103 != null) goto L14;
            L16:
                boolean r104 = false;
            L17:
                if (r104 == true) goto L28;
                float r105 = RangesKt.coerceIn(r100.f264016a.f264020b, 0.0f, 1.0f);
                if (r105 > 0.01f) goto L22;
                r100.c();
                return;
            L22:
                d r106 = r100.f264016a;
                ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r105, 0.0f});
                r107.setDuration(r100.f264017b.f264008h.f264041k);
                r107.addUpdateListener(new com.bytedance.locallife.poi.poidetail.container.plugin.business.h(r102, r100));
                r107.addListener(new com.bytedance.locallife.poi.poidetail.container.plugin.business.i(r100));
                r107.start();
                r106.f264024f = r107;
                return;
            L28:
                return;
            L14:
                if (r103.isRunning() != true) goto L16;
                r104 = true;
                goto L17
            L27:
                return;
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

        public final void a() {
            ValueAnimator r100 = this.f264016a.f264024f;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            this.f264016a.f264024f = null;
        }

        public final void b() {
            Runnable r100 = this.f264016a.f264025g;
            if (r100 != null) goto L5;
            return;
        L5:
            DitoFragment r101 = this.f264017b.f();
            if (r101 == null) goto L10;
            View r102 = r101.getView();
            if (r102 == null) goto L10;
            r102.removeCallbacks(r100);
        L10:
            this.f264016a.f264025g = null;
        }

        public final SkeletonItemDecoration e() {
            DitoFragment r100 = this.f264017b.f();
            if ((r100 instanceof PoiDetailBizContainerFragment) == false) goto L5;
            PoiDetailBizContainerFragment r101 = (PoiDetailBizContainerFragment) r100;
        L6:
            if (r101 != null) goto L8;
            return null;
        L8:
            return r101.f262605x1;
        L5:
            r101 = null;
            goto L6
        }

        public final void c() {
            a();
            b();
            SkeletonItemDecoration r100 = e();
            if (r100 == null) goto L10;
            r100.b(0.0f);
            r100.f264052d = RangesKt.coerceAtLeast(0, 0);
            RecyclerView r101 = r100.f264054f;
            if (r101 == null) goto L7;
            r101.invalidateItemDecorations();
        L7:
            r100.f264050b = false;
            RecyclerView r102 = r100.f264054f;
            if (r102 == null) goto L10;
            r102.invalidateItemDecorations();
        L10:
            d r103 = this.f264016a;
            r103.f264020b = 0.0f;
            r103.f264022d = 0;
            r103.f264019a = false;
            r103.f264024f = null;
            r103.f264021c = null;
        }

        public final void f() {
            b();
            DitoFragment r100 = this.f264017b.f();
            if (r100 == null) goto L9;
            View r101 = r100.getView();
            if (r101 == null) goto L10;
            d r102 = this.f264016a;
            a r103 = new a(this);
            r102.f264025g = r103;
            r101.postDelayed(r103, this.f264017b.f264008h.f264040j);
            return;
        L10:
            return;
        }

        public c(PoiTransitionSkeletonPlugin r100) {
            this.f264017b = r100;
            this.f264016a = new d(0);
        }

        public final void d(float r100, String r101, int r102) {
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            c();
            return;
        L12:
            a();
            d r104 = this.f264016a;
            if (r104.f264023e != null) goto L15;
        L16:
            DitoFragment r105 = this.f264017b.f();
            if (r105 == null) goto L22;
            Context r106 = r105.getContext();
            if (r106 == null) goto L22;
            d r107 = this.f264016a;
            r107.f264023e = new sp6.d(r106, r101);
            this.f264016a.f264021c = r101;
        L22:
            SkeletonItemDecoration r108 = e();
            if (r108 == null) goto L36;
            float r109 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
            int r110 = RangesKt.coerceAtLeast(r102, 0);
            r108.f264049a = this.f264016a.f264023e;
            RecyclerView r111 = r108.f264054f;
            if (r111 == null) goto L28;
            r111.invalidateItemDecorations();
        L28:
            r108.f264052d = RangesKt.coerceAtLeast(r110, 0);
            RecyclerView r112 = r108.f264054f;
            if (r112 == null) goto L31;
            r112.invalidateItemDecorations();
        L31:
            r108.f264050b = true;
            RecyclerView r113 = r108.f264054f;
            if (r113 == null) goto L34;
            r113.invalidateItemDecorations();
        L34:
            r108.b(r109);
            d r114 = this.f264016a;
            r114.f264020b = r109;
            r114.f264022d = r110;
            r114.f264019a = true;
            return;
        L36:
            return;
        L15:
            if (Intrinsics.areEqual(r104.f264021c, r101) == true) goto L22;
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r103 = false;
            goto L9
        }

        public final void g(float r100, String r101, int r102) {
            if (r101 != null) goto L4;
        L7:
            boolean r103 = true;
        L8:
            if (r103 == false) goto L11;
            c();
            return;
        L11:
            float r104 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
            d r105 = this.f264016a;
            if (r105.f264019a == true) goto L14;
        L21:
            d(r104, r101, r102);
            return;
        L14:
            if (Intrinsics.areEqual(r105.f264021c, r101) == false) goto L21;
            SkeletonItemDecoration r106 = e();
            if (r106 != null) goto L19;
            return;
        L19:
            r106.b(r104);
            this.f264016a.f264020b = r104;
            return;
        L4:
            if (StringsKt.isBlank(r101) == true) goto L7;
            r103 = false;
            goto L8
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f264019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f264020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f264021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f264022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public sp6.d f264023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ValueAnimator f264024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Runnable f264025g;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f264019a == r101.f264019a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f264020b, r101.f264020b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f264021c, r101.f264021c) == true) goto L18;
            return false;
        L18:
            if (this.f264022d == r101.f264022d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f264023e, r101.f264023e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f264024f, r101.f264024f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f264025g, r101.f264025g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.f264019a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + Float.floatToIntBits(this.f264020b)) * 31;
            String r102 = this.f264021c;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (((r101 + r104) * 31) + this.f264022d) * 31;
            sp6.d r106 = this.f264023e;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            ValueAnimator r109 = this.f264024f;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            Runnable r112 = this.f264025g;
            if (r112 == null) goto L23;
            r103 = r112.hashCode();
        L23:
            return r111 + r103;
        L17:
            r110 = r109.hashCode();
            goto L18
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "OverlayRuntimeState(isShowing=" + this.f264019a + ", currentAlpha=" + this.f264020b + ", currentSkeletonDsl=" + this.f264021c + ", currentExcludeTopHeight=" + this.f264022d + ", skeletonDrawer=" + this.f264023e + ", currentAnimator=" + this.f264024f + ", pendingHideRunnable=" + this.f264025g + ')';
        }

        public d(int r100) {
            this.f264019a = false;
            this.f264020b = 0.0f;
            this.f264021c = null;
            this.f264022d = 0;
            this.f264023e = null;
            this.f264024f = null;
            this.f264025g = null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f264026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f264027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f264028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f264029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f264030e;

        public e() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f264026a, r101.f264026a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264027b, r101.f264027b) == true) goto L15;
            return false;
        L15:
            if (this.f264028c == r101.f264028c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f264029d, r101.f264029d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f264030e, r101.f264030e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f264026a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f264027b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f264028c) * 31;
            Integer r107 = this.f264029d;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f264030e;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ProgrammaticTransitionState(targetState=" + this.f264026a + ", skeletonDsl=" + this.f264027b + ", headImageHeight=" + this.f264028c + ", startTop=" + this.f264029d + ", endTop=" + this.f264030e + ')';
        }

        public e(int r100) {
            this.f264026a = null;
            this.f264027b = null;
            this.f264028c = 0;
            this.f264029d = null;
            this.f264030e = null;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f264031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f264032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f264033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f264034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f264035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f264036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f264037g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f264038h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f264039i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f264040j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f264041k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f264042l;

        public f() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f264031a, r101.f264031a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264032b, r101.f264032b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f264033c, r101.f264033c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.f264034d, r101.f264034d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f264035e, r101.f264035e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f264036f, r101.f264036f) == 0) goto L27;
            return false;
        L27:
            if (this.f264037g == r101.f264037g) goto L30;
            return false;
        L30:
            if (this.f264038h == r101.f264038h) goto L33;
            return false;
        L33:
            if (this.f264039i == r101.f264039i) goto L36;
            return false;
        L36:
            if (this.f264040j == r101.f264040j) goto L39;
            return false;
        L39:
            if (this.f264041k == r101.f264041k) goto L42;
            return false;
        L42:
            if (this.f264042l == r101.f264042l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f264031a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f264032b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f264033c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (((((((((r106 + r101) * 31) + Float.floatToIntBits(this.f264034d)) * 31) + Float.floatToIntBits(this.f264035e)) * 31) + Float.floatToIntBits(this.f264036f)) * 31) + this.f264037g) * 31;
            int r109 = 1231;
            if (this.f264038h == false) goto L17;
            int r110 = 1231;
        L18:
            int r111 = (r108 + r110) * 31;
            if (this.f264039i == true) goto L22;
            r109 = 1237;
        L22:
            long r112 = this.f264040j;
            int r113 = (((r111 + r109) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = this.f264041k;
            int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
            long r116 = this.f264042l;
            return r115 + ((int) (r116 ^ (r116 >>> 32)));
        L17:
            r110 = 1237;
            goto L18
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SkeletonConfigState(halfSkeletonDsl=" + this.f264031a + ", fullSkeletonClickDsl=" + this.f264032b + ", fullSkeletonSlideDsl=" + this.f264033c + ", skeletonAlphaAppearSpeed=" + this.f264034d + ", skeletonAlphaDisappearSpeed=" + this.f264035e + ", skeletonAlphaStartThreshold=" + this.f264036f + ", poiDetailUpdateVideo=" + this.f264037g + ", needShowSkeleton=" + this.f264038h + ", needSkeletonOnScrollFullScreen=" + this.f264039i + ", overlayHideDelayMs=" + this.f264040j + ", overlayFadeDurationMs=" + this.f264041k + ", overlayAppearDurationMs=" + this.f264042l + ')';
        }

        public f(int r100) {
            this.f264031a = null;
            this.f264032b = null;
            this.f264033c = null;
            this.f264034d = 1.0f;
            this.f264035e = 1.0f;
            this.f264036f = 0.0f;
            this.f264037g = 0;
            this.f264038h = false;
            this.f264039i = false;
            this.f264040j = 250;
            this.f264041k = 200;
            this.f264042l = 150;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f264043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f264044b;

        public g() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f264043a, r101.f264043a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264044b, r101.f264044b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f264043a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f264044b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StableTopSnapshot(halfExpandedTop=" + this.f264043a + ", collapsedTop=" + this.f264044b + ')';
        }

        public g(int r100) {
            this.f264043a = null;
            this.f264044b = null;
        }
    }

    public /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f264045a = null;

        static {
            int[] r100 = new int[TransitionType.values().length];
            r100[TransitionType.HALF_TO_COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TransitionType.COLLAPSED_TO_HALF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f264045a = r100;
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiTransitionSkeletonPlugin f264046a;

        public i(PoiTransitionSkeletonPlugin r100) {
            this.f264046a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            PoiTransitionSkeletonPlugin r101 = this.f264046a;
            DitoPage r102 = ((l) r100).f258215b;
            Float r103 = null;
            if (r102 == null) goto L6;
            DitoPageInfo r104 = r102.getPageInfo();
            if (r104 == null) goto L6;
        L12:
            if (r104 != null) goto L14;
            int r105 = PoiTransitionSkeletonPlugin.f264003i;
            r101.getClass();
            return;
        L14:
            f r106 = r101.f264008h;
            Map<String, Object> r107 = r104.getData();
            if (r107 == null) goto L17;
            Object r108 = r107.get("need_show_skeleton");
        L19:
            if ((r108 instanceof Boolean) == false) goto L21;
            Boolean r109 = (Boolean) r108;
        L22:
            Boolean r110 = Boolean.TRUE;
            r106.f264038h = Intrinsics.areEqual(r109, r110);
            f r111 = r101.f264008h;
            if (r111.f264038h == false) goto L80;
            Map<String, Object> r112 = r104.getData();
            if (r112 == null) goto L28;
            Object r113 = r112.get("need_skeleton_on_scroll_full_screen");
        L30:
            if ((r113 instanceof Boolean) == false) goto L32;
            Boolean r114 = (Boolean) r113;
        L33:
            r111.f264039i = Intrinsics.areEqual(r114, r110);
            f r115 = r101.f264008h;
            Map<String, Object> r116 = r104.getData();
            if (r116 == null) goto L36;
            Object r117 = r116.get("ab_map");
        L38:
            if ((r117 instanceof Map) == false) goto L40;
            Map r118 = (Map) r117;
        L41:
            boolean r119 = false;
            if (r118 == null) goto L48;
            Object r120 = r118.get("poi_detail_update_video");
            if (r120 == null) goto L48;
            Integer r121 = com.bytedance.locallife.groupon.utils.b.a(r120);
            if (r121 == null) goto L48;
            int r122 = r121.intValue();
        L49:
            r115.f264037g = r122;
            f r123 = r101.f264008h;
            String r124 = PoiTransitionSkeletonPlugin.F(r104, "half_skeleton_dsl");
            if (r124 != null) goto L52;
            r124 = r101.f264008h.f264031a;
        L52:
            r123.f264031a = r124;
            f r125 = r101.f264008h;
            String r126 = PoiTransitionSkeletonPlugin.F(r104, "full_skeleton_click_dsl");
            if (r126 != null) goto L55;
            r126 = r101.f264008h.f264032b;
        L55:
            r125.f264032b = r126;
            f r127 = r101.f264008h;
            String r128 = PoiTransitionSkeletonPlugin.F(r104, "full_skeleton_slide_dsl");
            if (r128 != null) goto L58;
            r128 = r101.f264008h.f264033c;
        L58:
            r127.f264033c = r128;
            r101.f264008h.f264034d = PoiTransitionSkeletonPlugin.E(r104, "skeleton_alpha_appear_speed");
            r101.f264008h.f264035e = PoiTransitionSkeletonPlugin.E(r104, "skeleton_alpha_disappear_speed");
            f r129 = r101.f264008h;
            Map<String, Object> r130 = r104.getData();
            if (r130 == null) goto L61;
            Object r131 = r130.get("skeleton_alpha_start_threshold");
        L63:
            if ((r131 instanceof Number) == false) goto L65;
            Number r132 = (Number) r131;
        L66:
            float r133 = 0.0f;
            if (r132 == null) goto L77;
            Float r134 = Float.valueOf(r132.floatValue());
            float r135 = r134.floatValue();
            if (0.0f <= r135) goto L71;
        L73:
            if (r119 == false) goto L75;
            r103 = r134;
        L75:
            if (r103 == null) goto L77;
            r133 = r103.floatValue();
            goto L77
        L71:
            if (r135 > 0.95f) goto L73;
            r119 = true;
        L77:
            r129.f264036f = r133;
            return;
        L65:
            r132 = null;
            goto L66
        L61:
            r131 = null;
        L48:
            r122 = 0;
            goto L49
        L40:
            r118 = null;
            goto L41
        L36:
            r117 = null;
            goto L38
        L32:
            r114 = null;
            goto L33
        L28:
            r113 = null;
            goto L30
        L80:
            return;
        L21:
            r109 = null;
            goto L22
        L17:
            r108 = null;
        L6:
            r104 = this.f264046a.g().f258040f;
            if (r104 != null) goto L12;
            DitoPage r136 = this.f264046a.g().f258059y;
            if (r136 == null) goto L11;
            r104 = r136.getPageInfo();
            goto L12
        L11:
            r104 = null;
            goto L12
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiTransitionSkeletonPlugin f264047a;

        public j(PoiTransitionSkeletonPlugin r100) {
            this.f264047a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Integer r100 = (Integer) r110;
            if (r100 == null) goto L235;
            PoiTransitionSkeletonPlugin r101 = this.f264047a;
            int r102 = r100.intValue();
            r101.f264004d.f264012c = Integer.valueOf(r102);
            if (r101.G() == true) goto L237;
            r101.J(r101.f264004d.f264010a, Integer.valueOf(r102));
            Integer r103 = r101.f264007g.f264026a;
            if (r103 == null) goto L55;
            int r104 = r103.intValue();
            String r111 = r101.f264007g.f264027b;
            if (r111 == null) goto L55;
            if ((!StringsKt.isBlank(r111)) == true) goto L16;
            r111 = null;
        L16:
            if (r111 == null) goto L55;
            if (r101.f264006f.f264016a.f264019a == false) goto L55;
            Integer r112 = r101.f264007g.f264029d;
            if (r112 != null) goto L35;
            r112 = r101.f264004d.f264012c;
            if (r112 != null) goto L31;
            if (r104 == 4) goto L30;
            if (r104 == 6) goto L29;
            r112 = null;
            goto L31
        L29:
            r112 = r101.B();
            goto L31
        L30:
            r112 = r101.C();
        L31:
            if (r112 == null) goto L33;
            int r113 = r112.intValue();
            r101.f264007g.f264029d = Integer.valueOf(r113);
        L34:
            if (r112 == null) goto L55;
        L33:
            r112 = null;
        L35:
            int r114 = r112.intValue();
            Integer r115 = r101.f264007g.f264030e;
            if (r115 == null) goto L38;
            int r105 = r115.intValue();
        L48:
            if (r114 == r105) goto L55;
            r101.f264006f.a();
            float r106 = PoiTransitionSkeletonPlugin.I(r102, Integer.valueOf(r114), Integer.valueOf(r105));
            if (r106 > 0.5f) goto L53;
            float r107 = 1.0f;
        L54:
            r101.f264006f.g(r107, r111, r101.f264007g.f264028c);
            boolean r108 = true;
        L56:
            if (r108 == true) goto L238;
            b r109 = r101.f264004d;
            if (r109.f264014e == false) goto L239;
            TransitionType r116 = r109.f264013d;
            if (r116 != null) goto L106;
            Integer r117 = r109.f264011b;
            if (r117 == null) goto L105;
            int r118 = r117.intValue();
            if (r118 == 4) goto L81;
            if (r118 == 6) goto L76;
            if (r118 != 7) goto L87;
            Integer r119 = r101.C();
            if (r119 == null) goto L105;
            if (r102 <= r119.intValue()) goto L87;
            TransitionType r120 = TransitionType.HALF_TO_COLLAPSED;
        L86:
            r116 = r120;
        L88:
            if (r116 == null) goto L105;
            if (r101.f264008h.f264038h == false) goto L101;
            int r121 = h.f264045a[r116.ordinal()];
            if (r121 == 1) goto L99;
            if (r121 != 2) goto L97;
            boolean r122 = r101.f264008h.f264039i;
        L102:
            if (r122 == false) goto L105;
            r101.f264004d.f264013d = r116;
            goto L106
        L97:
            throw new NoWhenBranchMatchedException();
        L99:
            if (r101.f264008h.f264037g <= 0) goto L101;
            r122 = true;
        L101:
            r122 = false;
        L87:
            r116 = null;
            goto L88
        L76:
            Integer r123 = r101.C();
            if (r123 == null) goto L105;
            if (r102 <= r123.intValue()) goto L87;
            r120 = TransitionType.HALF_TO_COLLAPSED;
            goto L86
        L81:
            Integer r124 = r101.f264005e.f264044b;
            if (r124 == null) goto L105;
            if (r102 >= r124.intValue()) goto L87;
            r120 = TransitionType.COLLAPSED_TO_HALF;
        L105:
            r116 = null;
        L106:
            if (r116 != null) goto L115;
            c r125 = r101.f264006f;
            Integer r126 = r101.f264004d.f264011b;
            if (r126 != null) goto L111;
        L113:
            String r127 = r101.f264008h.f264031a;
        L114:
            r125.g(0.0f, r127, r125.f264016a.f264022d);
            return;
        L111:
            if (r126.intValue() != 4) goto L113;
            r127 = r101.f264008h.f264033c;
            goto L114
        L115:
            Integer r128 = r101.C();
            if (r128 == null) goto L120;
            int r129 = r128.intValue();
            Integer r130 = r101.f264005e.f264044b;
            if (r130 == null) goto L120;
            Integer r131 = Integer.valueOf((int) ((((long) r129) + ((long) r130.intValue())) / 2));
        L121:
            if (r131 == null) goto L161;
            int r132 = r131.intValue();
            int r133 = em4.g.c(4);
            String r134 = r101.e().L0().getValue();
            String r135 = "full";
            if (r134 != null) goto L144;
            Integer r136 = r101.f264004d.f264011b;
            if (r136 != null) goto L128;
        L130:
            if (r136 != null) goto L133;
        L135:
            if (r136 != null) goto L138;
        L140:
            boolean r137 = false;
        L141:
            if (r137 == false) goto L143;
            r134 = "full";
            goto L144
        L143:
            r134 = null;
            goto L144
        L138:
            if (r136.intValue() != 7) goto L140;
        L139:
            r137 = true;
            goto L141
        L133:
            if (r136.intValue() != 6) goto L135;
        L128:
            if (r136.intValue() != 4) goto L130;
            r134 = "fold";
        L144:
            int r138 = h.f264045a[r116.ordinal()];
            if (r138 == 1) goto L156;
            if (r138 != 2) goto L154;
            if (r102 >= (r132 - r133)) goto L151;
        L160:
            r134 = r135;
        L162:
            if (r134 != null) goto L165;
        L180:
            int r139 = r101.C();
            Integer r140 = r101.e().Q().getValue();
            DitoFragment r141 = r101.f();
            if (r141 == null) goto L183;
            AbstractInteractBehavior<? extends View> r142 = r141.Da0();
        L185:
            if ((r142 instanceof CustomBottomBehavior) == false) goto L187;
            CustomBottomBehavior r143 = (CustomBottomBehavior) r142;
        L188:
            if (r143 == null) goto L190;
            HeadUnfoldState r144 = r143.B;
        L192:
            if (r144 != HeadUnfoldState.STATE_HEAD_TRANSITION) goto L198;
            if (r140 == null) goto L198;
            if (r101.H() == false) goto L198;
            r102 = r102 - r140.intValue();
            r139 = 0;
        L198:
            int[] r145 = h.f264045a;
            int r146 = r145[r116.ordinal()];
            if (r146 == 1) goto L204;
            if (r146 != 2) goto L203;
            float r147 = 1.0f - PoiTransitionSkeletonPlugin.I(r102, r139, r101.f264005e.f264044b);
        L205:
            float r148 = RangesKt.coerceIn(r147, 0.0f, 1.0f);
            if (r148 <= 0.5f) goto L209;
            r148 = 1.0f - r148;
        L209:
            float r149 = RangesKt.coerceIn(RangesKt.coerceIn(r148 * 2.0f, 0.0f, 1.0f), 0.0f, 1.0f);
            float r150 = RangesKt.coerceIn(r101.f264008h.f264036f, 0.0f, 0.95f);
            if (r150 <= 0.0f) goto L214;
            r149 = RangesKt.coerceIn((r149 - r150) / (1.0f - r150), 0.0f, 1.0f);
        L214:
            if (r149 < r101.f264006f.f264016a.f264020b) goto L216;
            boolean r151 = true;
        L217:
            if (r151 == false) goto L219;
            float r152 = r101.f264008h.f264034d;
        L221:
            if (r149 > 0.0f) goto L223;
        L226:
            c r153 = r101.f264006f;
            int r154 = r145[r116.ordinal()];
            if (r154 == 1) goto L232;
            if (r154 != 2) goto L231;
            String r155 = r101.f264008h.f264033c;
        L233:
            r153.g(r149, r155, r153.f264016a.f264022d);
            return;
        L231:
            throw new NoWhenBranchMatchedException();
        L232:
            r155 = r101.f264008h.f264031a;
            goto L233
        L223:
            if (r149 >= 1.0f) goto L226;
            r149 = RangesKt.coerceIn((float) Math.pow(r149, 1.0f / RangesKt.coerceAtLeast(r152, 0.1f)), 0.0f, 1.0f);
            goto L226
        L219:
            r152 = r101.f264008h.f264035e;
            goto L221
        L216:
            r151 = false;
            goto L217
        L203:
            throw new NoWhenBranchMatchedException();
        L204:
            r147 = PoiTransitionSkeletonPlugin.I(r102, r139, r101.f264005e.f264044b);
            goto L205
        L190:
            r144 = null;
            goto L192
        L187:
            r143 = null;
            goto L188
        L183:
            r142 = null;
            goto L185
        L165:
            if (r101.G() == true) goto L180;
            if (StringsKt.isBlank(r134) == false) goto L170;
            boolean r156 = true;
        L171:
            if (r156 == true) goto L180;
            if (Intrinsics.areEqual(r101.e().L0().getValue(), r134) == true) goto L180;
            if (r101.f() == null) goto L180;
            r101.e().L0().setValue(r134);
            goto L180
        L170:
            r156 = false;
            goto L171
        L151:
            if (r102 <= (r132 + r133)) goto L162;
        L157:
            r135 = "fold";
            goto L160
        L154:
            throw new NoWhenBranchMatchedException();
        L156:
            if (r102 > (r132 + r133)) goto L157;
            if (r102 >= (r132 - r133)) goto L162;
        L161:
            r134 = null;
        L120:
            r131 = null;
            goto L121
        L239:
            return;
        L238:
            return;
        L53:
            r107 = RangesKt.coerceIn(1.0f - (RangesKt.coerceIn((r106 - 0.5f) / 0.5f, 0.0f, 1.0f) * 0.98f), 0.02f, 1.0f);
            goto L54
        L38:
            if (r104 == 4) goto L42;
            if (r104 == 6) goto L41;
            Integer r157 = null;
        L43:
            if (r157 == null) goto L45;
            int r158 = r157.intValue();
            r101.f264007g.f264030e = Integer.valueOf(r158);
        L46:
            if (r157 == null) goto L55;
            r105 = r157.intValue();
            goto L48
        L45:
            r157 = null;
            goto L46
        L41:
            r157 = r101.C();
            goto L43
        L42:
            r157 = r101.B();
        L55:
            r108 = false;
            goto L56
        L237:
            return;
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiTransitionSkeletonPlugin f264048a;

        public k(PoiTransitionSkeletonPlugin r100) {
            this.f264048a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Integer r111 = (Integer) r110;
            if (r111 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r111, this.f264048a.f264004d.f264010a) == true) goto L70;
            PoiTransitionSkeletonPlugin r100 = this.f264048a;
            int r101 = r111.intValue();
            r100.getClass();
            HeadUnfoldState r102 = null;
            boolean r103 = false;
            if (r101 == 2) goto L53;
            boolean r104 = true;
            if (r101 == 3) goto L33;
            if (r101 == 4) goto L17;
            if (r101 == 6) goto L17;
            if (r101 == 7) goto L17;
        L67:
            this.f264048a.f264004d.f264010a = r111;
            return;
        L17:
            if (r101 != 4) goto L20;
            r100.f264004d.f264015f = false;
        L20:
            if (r100.G() == false) goto L22;
            r100.f264004d.f264011b = Integer.valueOf(r101);
            b r105 = r100.f264004d;
            r105.f264014e = false;
            r105.f264013d = null;
            e r106 = r100.f264007g;
            r106.f264026a = null;
            r106.f264027b = null;
            r106.f264028c = 0;
            r106.f264029d = null;
            r106.f264030e = null;
            r100.f264006f.c();
            goto L67
        L22:
            r100.J(Integer.valueOf(r101), r100.f264004d.f264012c);
            r100.f264004d.f264011b = Integer.valueOf(r101);
            b r107 = r100.f264004d;
            r107.f264014e = false;
            r107.f264013d = null;
            Integer r108 = r100.f264007g.f264026a;
            if (r108 != null) goto L25;
        L31:
            r100.f264006f.f();
            goto L67
        L25:
            if (r108.intValue() == r101) goto L28;
            r104 = false;
        L28:
            e r109 = r100.f264007g;
            r109.f264026a = null;
            r109.f264027b = null;
            r109.f264028c = 0;
            r109.f264029d = null;
            r109.f264030e = null;
            if (r104 == false) goto L31;
            r100.f264006f.f();
            goto L67
        L33:
            if (r100.f264004d.f264015f == false) goto L35;
        L52:
            r100.D();
            goto L67
        L35:
            if (r100.H() == false) goto L52;
            b r112 = r100.f264004d;
            Integer r113 = r112.f264010a;
            Integer r114 = r112.f264011b;
            if (r113 != null) goto L40;
        L41:
            if (r114 != null) goto L44;
        L45:
            if (r114 != null) goto L48;
        L50:
            if (r103 == false) goto L52;
            r100.f264004d.f264015f = true;
            goto L52
        L48:
            if (r114.intValue() != 7) goto L50;
        L49:
            r103 = true;
            goto L50
        L44:
            if (r114.intValue() == 6) goto L49;
        L40:
            if (r113.intValue() == 2) goto L50;
        L53:
            DitoFragment r115 = r100.f();
            if (r115 == null) goto L56;
            AbstractInteractBehavior<? extends View> r116 = r115.Da0();
        L58:
            if ((r116 instanceof CustomBottomBehavior) == false) goto L60;
            CustomBottomBehavior r117 = (CustomBottomBehavior) r116;
        L61:
            if (r117 == null) goto L64;
            r102 = r117.B;
        L64:
            if (r102 != HeadUnfoldState.STATE_HEAD_TRANSITION) goto L66;
            r100.f264004d.f264015f = false;
        L66:
            r100.D();
            goto L67
        L60:
            r117 = null;
            goto L61
        L56:
            r116 = null;
            goto L58
        }
    }

    static {
    }

    public final Integer B() {
        Integer r100 = this.f264005e.f264044b;
        if (r100 != null) goto L5;
        Integer r101 = e().P().getValue();
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.intValue() <= 0) goto L14;
        this.f264005e.f264044b = r101;
        return r101;
    L14:
        return null;
    L5:
        return Integer.valueOf(r100.intValue());
    }

    public final Integer C() {
        Integer r100 = this.f264005e.f264043a;
        if (r100 != null) goto L5;
        Integer r101 = e().Q().getValue();
        if (r101 != null) goto L9;
    L11:
        DitoFragment r102 = f();
        if (r102 == null) goto L14;
        AbstractInteractBehavior<? extends View> r103 = r102.Da0();
    L16:
        if ((r103 instanceof CustomBottomBehavior) == false) goto L18;
        CustomBottomBehavior r104 = (CustomBottomBehavior) r103;
    L19:
        if (r104 == null) goto L21;
        r101 = Integer.valueOf(r104.f258397o);
    L22:
        if (r101 != null) goto L24;
    L26:
        r101 = null;
    L27:
        if (r101 == null) goto L30;
        int r105 = r101.intValue();
        this.f264005e.f264043a = Integer.valueOf(r105);
        return Integer.valueOf(r105);
    L30:
        return null;
    L24:
        if (r101.intValue() <= 0) goto L26;
    L21:
        r101 = null;
        goto L22
    L18:
        r104 = null;
        goto L19
    L14:
        r103 = null;
        goto L16
    L9:
        if (r101.intValue() <= 0) goto L11;
    L5:
        return Integer.valueOf(r100.intValue());
    }

    public final boolean G() {
        if (this.f264004d.f264015f == true) goto L5;
    L7:
        return false;
    L5:
        if (H() == false) goto L7;
        return true;
    }

    public PoiTransitionSkeletonPlugin() {
        this.f264004d = new b(0);
        this.f264005e = new g(0);
        this.f264006f = new c(this);
        this.f264007g = new e(0);
        this.f264008h = new f(0);
    }

    public final void D() {
        boolean r100 = false;
        if (G() == false) goto L6;
        this.f264006f.b();
        this.f264006f.a();
        e r101 = this.f264007g;
        r101.f264026a = null;
        r101.f264027b = null;
        r101.f264028c = 0;
        r101.f264029d = null;
        r101.f264030e = null;
        this.f264006f.c();
        b r102 = this.f264004d;
        r102.f264014e = false;
        r102.f264013d = null;
        return;
    L6:
        this.f264006f.b();
        float r103 = 0.0f;
        float r104 = RangesKt.coerceIn(this.f264006f.f264016a.f264020b, 0.0f, 1.0f);
        if (r104 <= 0.0f) goto L10;
    L15:
        this.f264006f.a();
        this.f264004d.f264013d = null;
        e r105 = this.f264007g;
        String r106 = r105.f264027b;
        if (r105.f264026a == null) goto L26;
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L26;
        this.f264004d.f264014e = false;
        this.f264006f.d(RangesKt.coerceAtLeast(r104, 1.0f), r106, this.f264007g.f264028c);
        r100 = true;
        goto L26
    L19:
        if (StringsKt.isBlank(r106) == true) goto L22;
        r107 = false;
    L26:
        if (r100 == false) goto L28;
        return;
    L28:
        b r108 = this.f264004d;
        r108.f264014e = true;
        c r109 = this.f264006f;
        Integer r110 = r108.f264011b;
        if (r110 != null) goto L32;
    L34:
        String r111 = this.f264008h.f264031a;
    L35:
        r109.d(r104, r111, this.f264006f.f264016a.f264022d);
        return;
    L32:
        if (r110.intValue() != 4) goto L34;
        r111 = this.f264008h.f264033c;
        goto L35
    L10:
        if (Intrinsics.areEqual(g().A.get("jsb_driven_anchor"), Boolean.TRUE) == true) goto L12;
    L14:
        r104 = r103;
        goto L15
    L12:
        if (this.f264006f.f264016a.f264019a == false) goto L14;
        r103 = 0.2f;
        goto L14
    }

    public final boolean H() {
        DitoDataCenter r100 = g().f258041g;
        int r101 = DitoDataCenter.f258004d;
        if (r100.a0("poi_use_content_player", 1).getValue() != null) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin, com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin, com.bytedance.locallife.dito.core.AbsDitoPlugin
    public final void h() {
        super.h();
        vn6.b.b(this);
        g().f258041g.H().observeForever(new i(this));
        e().R().observeForever(new j(this));
        e().S().observeForever(new k(this));
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void l(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        vn6.b.c(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiChangePageStateEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        throw null;
    }

    public static float E(DitoPageInfo r100, String r101) {
        Map<String, Object> r102 = r100.getData();
        Float r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get(r101);
    L7:
        if ((r104 instanceof Number) == false) goto L9;
        Number r105 = (Number) r104;
    L10:
        if (r105 == null) goto L19;
        Float r106 = Float.valueOf(r105.floatValue());
        if (r106.floatValue() < 0.1f) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r103 = r106;
    L17:
        if (r103 == null) goto L19;
        return r103.floatValue();
    L14:
        r107 = false;
    L19:
        return 1.0f;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static String F(DitoPageInfo r100, String r101) {
        Map<String, Object> r102 = r100.getData();
        if (r102 == null) goto L5;
        Object r103 = r102.get(r101);
    L7:
        if ((r103 instanceof String) == false) goto L9;
        String r104 = (String) r103;
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        if ((!StringsKt.isBlank(r104)) == true) goto L14;
        return null;
    L14:
        return r104;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public final void J(Integer r100, Integer r101) {
        if (r101 == null) goto L19;
        int r102 = r101.intValue();
        if (r100 != null) goto L7;
    L11:
        if (r100 != null) goto L14;
        return;
    L14:
        if (r100.intValue() != 4) goto L22;
        g r103 = this.f264005e;
        if (r103.f264044b != null) goto L23;
        r103.f264044b = Integer.valueOf(r102);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (r100.intValue() != 6) goto L11;
        g r104 = this.f264005e;
        if (r104.f264043a != null) goto L20;
        r104.f264043a = Integer.valueOf(r102);
        return;
    L20:
        return;
    }

    public static float I(int r100, Integer r101, Integer r102) {
        if (r101 == null) goto L11;
        int r103 = r101.intValue();
        if (r102 == null) goto L11;
        int r104 = r102.intValue();
        if (r103 != r104) goto L10;
        return 1.0f;
    L10:
        return RangesKt.coerceIn((r100 - r103) / (r104 - r103), 0.0f, 1.0f);
    L11:
        return 0.0f;
    }
}
