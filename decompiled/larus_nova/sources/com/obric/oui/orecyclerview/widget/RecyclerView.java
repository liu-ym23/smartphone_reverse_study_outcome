package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.os.TraceCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.orecyclerview.base.OverScrollerAdapter;
import com.obric.oui.picker.reels.views.WheelLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ttnet.org.chromium.net.NetError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static final boolean E2 = false;
    public static final Class<?>[] F2 = null;
    public static final c G2 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static boolean f401596h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static boolean f401597p2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int[] f401598v2 = null;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final boolean f401599x2 = false;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final boolean f401600y2 = false;
    public boolean A;
    public final AccessibilityManager B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public com.obric.oui.orecyclerview.base.a G;
    public final int[] G1;
    public com.obric.oui.orecyclerview.base.a H;
    public final com.obric.oui.orecyclerview.widget.s.b H0;
    public final int[] H1;
    public ItemAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f401601J;
    public int K;
    public com.obric.oui.orecyclerview.base.f L;
    public final v L0;
    public final List<y> L1;
    public int M;
    public boolean M1;
    public int N;
    public int O;
    public int P;
    public o P0;
    public final boolean P1;
    public int Q;
    public final b Q1;
    public m R;
    public int S;
    public boolean S1;
    public final int T;
    public int T1;
    public final float U;
    public final float V;
    public List<o> V0;
    public int V1;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f401602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f401603b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f401604b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final f0 f401605b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SavedState f401606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.a f401607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.g f401608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f401609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f401610g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f401611g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final d f401612g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f401613h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final i f401614h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f401615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f401616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f401617k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final x f401618k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f401619k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Adapter f401620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f401621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r f401622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<r> f401623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<j> f401624p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public com.obric.oui.orecyclerview.widget.s f401625p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public RecyclerViewAccessibilityDelegate f401626p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<n> f401627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public n f401628r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f401629s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f401630t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f401631u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f401632v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final int[] f401633v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f401634w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f401635x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public NestedScrollingChildHelper f401636x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f401637y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final int[] f401638y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f401639z;

    public static abstract class Adapter<VH extends y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f401640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StateRestorationPolicy f401641b;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ StateRestorationPolicy[] f401642a = null;

            static {
                StateRestorationPolicy r100 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r100;
                StateRestorationPolicy r101 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r101;
                StateRestorationPolicy r102 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r102;
                f401642a = new StateRestorationPolicy[]{r100, r101, r102};
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) f401642a.clone();
            }

            public static StateRestorationPolicy valueOf(String r100) {
                return (StateRestorationPolicy) r27.a.a(StateRestorationPolicy.class, r100);
            }

            public StateRestorationPolicy(String r100, int r101) {
                super(r100, r101);
            }
        }

        public abstract int a();

        public int b(int r100) {
            return 0;
        }

        public abstract void c(VH r100, int r101);

        public abstract y d(RecyclerView r100, int r101);

        public Adapter() {
            this.f401640a = new f();
            this.f401641b = StateRestorationPolicy.ALLOW;
        }
    }

    public static class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }
    }

    public static abstract class ItemAnimator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f401643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<a> f401644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f401645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f401646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f401647e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f401648f;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface a {
            void onAnimationsFinished();
        }

        public interface b {
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f401649a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f401650b;

            public c() {
            }
        }

        public abstract boolean a(y r100, y r101, c r102, c r103);

        public abstract void e(y r100);

        public abstract void f();

        public abstract boolean g();

        public final void d() {
            int r100 = this.f401644b.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            ((a) ListProtector.get(this.f401644b, r101)).onAnimationsFinished();
            r101 = r101 + 1;
            goto L3
        L5:
            this.f401644b.clear();
        }

        public ItemAnimator() {
            this.f401643a = null;
            this.f401644b = new ArrayList();
            this.f401645c = 100;
            this.f401646d = 100;
            this.f401647e = 500;
            this.f401648f = 250;
        }

        public static int b(y r100) {
            int r101 = r100.f401737j & 14;
            if (r100.g() == false) goto L7;
            return 4;
        L7:
            if ((r101 & 4) != 0) goto L17;
            int r102 = r100.f401731d;
            RecyclerView r103 = r100.f401745r;
            if (r103 != null) goto L11;
            int r104 = -1;
        L12:
            if (r102 == (-1)) goto L18;
            if (r104 == (-1)) goto L19;
            if (r102 != r104) goto L16;
            return r101;
        L16:
            return r101 | 2048;
        L19:
            return r101;
        L18:
            return r101;
        L11:
            r104 = r103.B(r100);
            goto L12
        L17:
            return r101;
        }

        public final void c(y r100) {
            b r101 = this.f401643a;
            if (r101 == null) goto L31;
            i r102 = (i) r101;
            boolean r103 = true;
            r100.n(true);
            if (r100.f401735h != null) goto L7;
        L9:
            r100.f401736i = null;
            if ((r100.f401737j & 16) == 0) goto L12;
            boolean r104 = true;
        L13:
            if (r104 == true) goto L32;
            RecyclerView r105 = r102.f401660a;
            View r106 = r100.f401728a;
            r105.Y();
            com.obric.oui.orecyclerview.widget.g r107 = r105.f401608e;
            int r108 = ((d0) r107.f401817a).f401799a.indexOfChild(r106);
            if (r108 != (-1)) goto L18;
            r107.l(r106);
        L21:
            if (r103 == false) goto L25;
            y r109 = RecyclerView.E(r106);
            r105.f401603b.l(r109);
            r105.f401603b.i(r109);
            if (RecyclerView.f401597p2 == false) goto L25;
            Objects.toString(r106);
            r105.toString();
        L25:
            r105.Z(!r103);
            if (r103 == false) goto L28;
            return;
        L28:
            if (r100.k() == false) goto L34;
            r102.f401660a.removeDetachedView(r100.f401728a, false);
            return;
        L34:
            return;
        L18:
            if (r107.f401818b.d(r108) == false) goto L20;
            r107.f401818b.e(r108);
            r107.l(r106);
            ((d0) r107.f401817a).b(r108);
            goto L21
        L20:
            r103 = false;
            goto L21
        L32:
            return;
        L12:
            r104 = false;
            goto L13
        L7:
            if (r100.f401736i != null) goto L9;
            r100.f401735h = null;
            goto L9
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f401651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f401652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f401653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f401654d;

        public final int a() {
            return this.f401651a.d();
        }

        public final boolean b() {
            return this.f401651a.i();
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f401652b = new Rect();
            this.f401653c = true;
            this.f401654d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f401652b = new Rect();
            this.f401653c = true;
            this.f401654d = false;
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.f401652b = new Rect();
            this.f401653c = true;
            this.f401654d = false;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f401652b = new Rect();
            this.f401653c = true;
            this.f401654d = false;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f401652b = new Rect();
            this.f401653c = true;
            this.f401654d = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Parcelable f401655a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L6;
            r101 = k.class.getClassLoader();
        L6:
            this.f401655a = r100.readParcelable(r101);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeParcelable(this.f401655a, 0);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401656a;

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f401656a;     // Catch: Throwable -> L15
            if (r100.f401631u == true) goto L5;
        L20:
            return;
        L5:
            if (r100.isLayoutRequested() == true) goto L20;
            RecyclerView r101 = this.f401656a;     // Catch: Throwable -> L15
            if (r101.f401629s == true) goto L11;
            r101.requestLayout();     // Catch: Throwable -> L15
            goto L20
        L11:
            if (r101.f401635x == false) goto L13;
            r101.f401634w = true;     // Catch: Throwable -> L15
            goto L20
        L13:
            r101.n();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }

        public a(RecyclerView r100) {
            this.f401656a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401657a;

        public final void a() {
            ItemAnimator r100 = this.f401657a.I;
            if (r100 == null) goto L42;
            com.obric.oui.orecyclerview.widget.p r101 = (com.obric.oui.orecyclerview.widget.p) r100;
            boolean r102 = !r101.f401865h.isEmpty();
            boolean r103 = !r101.f401867j.isEmpty();
            boolean r104 = !r101.f401868k.isEmpty();
            boolean r105 = !r101.f401866i.isEmpty();
            if (r102 == true) goto L10;
            if (r103 == true) goto L10;
            if (r105 == true) goto L10;
            if (r104 == false) goto L42;
        L10:
            Iterator<y> r106 = r101.f401865h.iterator();
        L12:
            if (r106.hasNext() == false) goto L14;
            y r107 = r106.next();
            View r108 = r107.f401728a;
            ViewPropertyAnimator r109 = r108.animate();
            r101.f401874q.add(r107);
            r109.setDuration(r101.f401646d).alpha(0.0f).setInterpolator(com.obric.oui.orecyclerview.widget.p.f401864t).setListener(new com.obric.oui.orecyclerview.widget.k(r101, r107, r108, r109)).start();
            goto L12
        L14:
            r101.f401865h.clear();
            if (r103 == false) goto L20;
            ArrayList<com.obric.oui.orecyclerview.widget.p.b> r110 = new ArrayList();
            r110.addAll(r101.f401867j);
            r101.f401870m.add(r110);
            r101.f401867j.clear();
            com.obric.oui.orecyclerview.widget.h r111 = new com.obric.oui.orecyclerview.widget.h(r101, r110);
            if (r102 == false) goto L19;
            ViewCompat.postOnAnimationDelayed(((com.obric.oui.orecyclerview.widget.p.b) ListProtector.get(r110, 0)).f401882a.f401728a, r111, r101.f401646d);
            goto L20
        L19:
            r111.run();
        L20:
            if (r104 == false) goto L25;
            ArrayList<com.obric.oui.orecyclerview.widget.p.a> r112 = new ArrayList();
            r112.addAll(r101.f401868k);
            r101.f401871n.add(r112);
            r101.f401868k.clear();
            com.obric.oui.orecyclerview.widget.i r113 = new com.obric.oui.orecyclerview.widget.i(r101, r112);
            if (r102 == false) goto L24;
            ViewCompat.postOnAnimationDelayed(((com.obric.oui.orecyclerview.widget.p.a) ListProtector.get(r112, 0)).f401876a.f401728a, r113, r101.f401646d);
            goto L25
        L24:
            r113.run();
        L25:
            if (r105 == false) goto L42;
            ArrayList<y> r114 = new ArrayList();
            r114.addAll(r101.f401866i);
            r101.f401869l.add(r114);
            r101.f401866i.clear();
            com.obric.oui.orecyclerview.widget.j r115 = new com.obric.oui.orecyclerview.widget.j(r101, r114);
            if (r102 == true) goto L32;
            if (r103 == true) goto L32;
            if (r104 == true) goto L32;
            r115.run();
        L32:
            long r116 = 0;
            if (r102 == false) goto L35;
            long r117 = r101.f401646d;
        L36:
            if (r103 == false) goto L38;
            long r118 = r101.f401647e;
        L39:
            if (r104 == false) goto L41;
            r116 = r101.f401648f;
        L41:
            ViewCompat.postOnAnimationDelayed(((y) ListProtector.get(r114, 0)).f401728a, r115, r117 + Math.max(r118, r116));
            goto L42
        L38:
            r118 = 0;
            goto L39
        L35:
            r117 = 0;
        L42:
            this.f401657a.f401619k1 = false;
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

        public b(RecyclerView r100) {
            this.f401657a = r100;
        }
    }

    public class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401658a;

        public d(RecyclerView r100) {
            this.f401658a = r100;
        }

        public final void c(y r100) {
            RecyclerView r101 = this.f401658a;
            k r102 = r101.f401621m;
            View r103 = r100.f401728a;
            q r104 = r101.f401603b;
            com.obric.oui.orecyclerview.widget.g r105 = r102.f401661a;
            int r106 = ((d0) r105.f401817a).f401799a.indexOfChild(r103);
            if (r106 >= 0) goto L6;
        L9:
            r104.h(r103);
            return;
        L6:
            if (r105.f401818b.e(r106) == false) goto L8;
            r105.l(r103);
        L8:
            ((d0) r105.f401817a).b(r106);
            goto L9
        }

        public final void a(y r100, ItemAnimator.c r110, ItemAnimator.c r111) {
            RecyclerView r101 = this.f401658a;
            r101.getClass();
            r100.n(false);
            g0 r102 = (g0) r101.I;
            r102.getClass();
            if (r110 == null) goto L9;
            int r103 = r110.f401649a;
            int r104 = r111.f401649a;
            if (r103 == r104) goto L7;
        L8:
            boolean r105 = r102.h(r100, r103, r110.f401650b, r104, r111.f401650b);
        L10:
            if (r105 == false) goto L13;
            r101.N();
            return;
        L13:
            return;
        L7:
            if (r110.f401650b != r111.f401650b) goto L8;
        L9:
            com.obric.oui.orecyclerview.widget.p r106 = (com.obric.oui.orecyclerview.widget.p) r102;
            r106.m(r100);
            r100.f401728a.setAlpha(0.0f);
            r106.f401866i.add(r100);
            r105 = true;
            goto L10
        }

        public final void b(y r100, ItemAnimator.c r110, ItemAnimator.c r111) {
            this.f401658a.f401603b.l(r100);
            RecyclerView r101 = this.f401658a;
            r101.h(r100);
            r100.n(false);
            g0 r102 = (g0) r101.I;
            r102.getClass();
            int r103 = r110.f401649a;
            int r104 = r110.f401650b;
            View r112 = r100.f401728a;
            if (r111 != null) goto L5;
            int r105 = r112.getLeft();
        L6:
            int r106 = r105;
            if (r111 != null) goto L9;
            int r113 = r112.getTop();
        L10:
            int r107 = r113;
            if (r100.i() == true) goto L15;
            if (r103 != r106) goto L14;
            if (r104 == r107) goto L15;
        L14:
            r112.layout(r106, r107, r112.getWidth() + r106, r112.getHeight() + r107);
            boolean r108 = r102.h(r100, r103, r104, r106, r107);
        L16:
            if (r108 == false) goto L19;
            r101.N();
            return;
        L19:
            return;
        L15:
            com.obric.oui.orecyclerview.widget.p r109 = (com.obric.oui.orecyclerview.widget.p) r102;
            r109.m(r100);
            r109.f401865h.add(r100);
            r108 = true;
            goto L16
        L9:
            r113 = r111.f401650b;
            goto L10
        L5:
            r105 = r111.f401649a;
            goto L6
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401659a = null;

        static {
            int[] r100 = new int[Adapter.StateRestorationPolicy.values().length];
            f401659a = r100;
            r100[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f401659a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class f extends Observable<g> {
        public final void a() {
            int r100 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r100 < 0) goto L5;
            ((g) ListProtector.get(((Observable) this).mObservers, r100)).a();
            r100 = r100 - 1;
            goto L3
        }

        public f() {
        }

        public final void b(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((g) ListProtector.get(((Observable) this).mObservers, r102)).d(r100, r101);
            r102 = r102 - 1;
            goto L3
        }

        public final void d(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((g) ListProtector.get(((Observable) this).mObservers, r102)).c(r100, r101);
            r102 = r102 - 1;
            goto L3
        }

        public final void e(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((g) ListProtector.get(((Observable) this).mObservers, r102)).e(r100, r101);
            r102 = r102 - 1;
            goto L3
        }

        public final void c(int r100, int r101, Object r102) {
            int r103 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r103 < 0) goto L5;
            ((g) ListProtector.get(((Observable) this).mObservers, r103)).b(r100, r101, r102);
            r103 = r103 - 1;
            goto L3
        }
    }

    public static abstract class g {
        public g() {
        }

        public void a() {
        }

        public void b(int r100, int r101, Object r102) {
        }

        public void c(int r100, int r101) {
        }

        public void d(int r100, int r101) {
        }

        public void e(int r100, int r101) {
        }
    }

    public interface h {
    }

    public class i implements ItemAnimator.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401660a;

        public i(RecyclerView r100) {
            this.f401660a = r100;
        }
    }

    public static abstract class j {
        public j() {
        }

        public void d(Canvas r100) {
        }

        public void c(Rect r100, View r101, RecyclerView r102, v r103) {
            ((LayoutParams) r101.getLayoutParams()).a();
            r100.set(0, 0, 0, 0);
        }
    }

    public static abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.oui.orecyclerview.widget.g f401661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f401662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewBoundsCheck f401663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewBoundsCheck f401664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public u f401665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f401666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f401667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f401668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f401669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f401670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f401671k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f401672l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f401673m;

        public class a implements ViewBoundsCheck.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f401674a;

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getParentEnd() {
                k r100 = this.f401674a;
                return r100.f401672l - r100.D();
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getParentStart() {
                return this.f401674a.C();
            }

            public a(k r100) {
                this.f401674a = r100;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final View getChildAt(int r100) {
                return this.f401674a.t(r100);
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getChildEnd(View r100) {
                LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
                this.f401674a.getClass();
                return (r100.getRight() + ((LayoutParams) r100.getLayoutParams()).f401652b.right) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getChildStart(View r100) {
                LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
                this.f401674a.getClass();
                return (r100.getLeft() - ((LayoutParams) r100.getLayoutParams()).f401652b.left) - ((ViewGroup.MarginLayoutParams) r101).leftMargin;
            }
        }

        public class b implements ViewBoundsCheck.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f401675a;

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getParentEnd() {
                k r100 = this.f401675a;
                return r100.f401673m - r100.B();
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getParentStart() {
                return this.f401675a.E();
            }

            public b(k r100) {
                this.f401675a = r100;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final View getChildAt(int r100) {
                return this.f401675a.t(r100);
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getChildEnd(View r100) {
                LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
                this.f401675a.getClass();
                return (r100.getBottom() + ((LayoutParams) r100.getLayoutParams()).f401652b.bottom) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
            }

            @Override // com.obric.oui.orecyclerview.widget.ViewBoundsCheck.b
            public final int getChildStart(View r100) {
                LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
                this.f401675a.getClass();
                return (r100.getTop() - ((LayoutParams) r100.getLayoutParams()).f401652b.top) - ((ViewGroup.MarginLayoutParams) r101).topMargin;
            }
        }

        public interface c {
        }

        public int G(q r100, v r101) {
            return -1;
        }

        public boolean I() {
            return false;
        }

        public void M() {
        }

        public View N(View r100, int r101, q r102, v r103) {
            return null;
        }

        public void R(q r100, v r101, View r102, AccessibilityNodeInfoCompat r103) {
        }

        public void S() {
        }

        public void T() {
        }

        public void U() {
        }

        public void V() {
        }

        public void W() {
        }

        public void X(q r100, v r101) {
        }

        public void Y(v r100) {
        }

        public void Z(Parcelable r100) {
        }

        public Parcelable a0() {
            return null;
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return this instanceof WheelLayoutManager;
        }

        public boolean e(LayoutParams r100) {
            if (r100 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public void g(int r100, int r101, v r102, c r103) {
        }

        public void h(int r100, c r101) {
        }

        public int h0(int r100, q r101, v r102) {
            return 0;
        }

        public int i(v r100) {
            return 0;
        }

        public int j(v r100) {
            return 0;
        }

        public int j0(int r100, q r101, v r102) {
            return 0;
        }

        public int k(v r100) {
            return 0;
        }

        public int l(v r100) {
            return 0;
        }

        public int m(v r100) {
            return 0;
        }

        public int n(v r100) {
            return 0;
        }

        public abstract LayoutParams q();

        public boolean q0() {
            return false;
        }

        public void r0(RecyclerView r100, int r101) {
        }

        public boolean t0() {
            return false;
        }

        public int w(q r100, v r101) {
            return -1;
        }

        public final int A() {
            RecyclerView r100 = this.f401662b;
            if (r100 == null) goto L5;
            Adapter r101 = r100.getAdapter();
        L6:
            if (r101 != null) goto L10;
            return 0;
        L10:
            return r101.a();
        L5:
            r101 = null;
            goto L6
        }

        public final int B() {
            RecyclerView r100 = this.f401662b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingBottom();
        }

        public final int C() {
            RecyclerView r100 = this.f401662b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingLeft();
        }

        public final int D() {
            RecyclerView r100 = this.f401662b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingRight();
        }

        public final int E() {
            RecyclerView r100 = this.f401662b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingTop();
        }

        public final void f0() {
            RecyclerView r100 = this.f401662b;
            if (r100 == null) goto L6;
            r100.requestLayout();
            return;
        }

        public final int u() {
            com.obric.oui.orecyclerview.widget.g r100 = this.f401661a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.e();
        }

        public k() {
            a r100 = new a(this);
            b r101 = new b(this);
            this.f401663c = new ViewBoundsCheck(r100);
            this.f401664d = new ViewBoundsCheck(r101);
            this.f401666f = true;
            this.f401667g = true;
        }

        public static int F(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).a();
        }

        public static int y(View r100) {
            Rect r101 = ((LayoutParams) r100.getLayoutParams()).f401652b;
            return (r100.getMeasuredHeight() + r101.top) + r101.bottom;
        }

        public static int z(View r100) {
            Rect r101 = ((LayoutParams) r100.getLayoutParams()).f401652b;
            return (r100.getMeasuredWidth() + r101.left) + r101.right;
        }

        public final void L(View r100) {
            LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
            Rect r102 = this.f401662b.F(r100);
            int r103 = (r102.left + r102.right) + 0;
            int r104 = 0 + (r102.top + r102.bottom);
            int r105 = v(this.f401672l, this.f401670j, (((C() + D()) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin) + r103, ((ViewGroup.MarginLayoutParams) r101).width, c());
            int r106 = v(this.f401673m, this.f401671k, (((E() + B()) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin) + r104, ((ViewGroup.MarginLayoutParams) r101).height, d());
            if (p0(r100, r105, r106, r101) == false) goto L6;
            r100.measure(r105, r106);
            return;
        }

        public void O(AccessibilityEvent r100) {
            RecyclerView r101 = this.f401662b;
            q r102 = r101.f401603b;
            v r103 = r101.L0;
            if (r101 == null) goto L20;
            if (r100 == null) goto L22;
            boolean r104 = true;
            if (r101.canScrollVertically(1) == false) goto L9;
        L16:
            r100.setScrollable(r104);
            Adapter r105 = this.f401662b.f401620l;
            if (r105 == null) goto L21;
            r100.setItemCount(r105.a());
            return;
        L21:
            return;
        L9:
            if (this.f401662b.canScrollVertically(-1) == true) goto L16;
            if (this.f401662b.canScrollHorizontally(-1) == true) goto L16;
            if (this.f401662b.canScrollHorizontally(1) == true) goto L16;
            r104 = false;
            goto L16
        L22:
            return;
        }

        public void b(String r100) {
            RecyclerView r101 = this.f401662b;
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }

        public final void b0(q r100) {
            int r101 = u();
        L3:
            r101 = r101 - 1;
            if (r101 < 0) goto L8;
            if (RecyclerView.E(t(r101)).o() == true) goto L3;
            View r102 = t(r101);
            d0(r101);
            r100.h(r102);
            goto L3
        }

        public final void c0(q r100) {
            int r101 = r100.f401683a.size();
            int r102 = r101 - 1;
        L3:
            if (r102 < 0) goto L15;
            View r103 = ((y) ListProtector.get(r100.f401683a, r102)).f401728a;
            y r104 = RecyclerView.E(r103);
            if (r104.o() == true) goto L14;
            r104.n(false);
            if (r104.k() == false) goto L10;
            this.f401662b.removeDetachedView(r103, false);
        L10:
            ItemAnimator r105 = this.f401662b.I;
            if (r105 == null) goto L13;
            r105.e(r104);
        L13:
            r104.n(true);
            y r106 = RecyclerView.E(r103);
            r106.f401741n = null;
            r106.f401742o = false;
            r106.f401737j &= -33;
            r100.i(r106);
        L14:
            r102 = r102 - 1;
            goto L3
        L15:
            r100.f401683a.clear();
            ArrayList<y> r107 = r100.f401684b;
            if (r107 == null) goto L18;
            r107.clear();
        L18:
            if (r101 <= 0) goto L24;
            this.f401662b.invalidate();
            return;
        }

        public final void d0(int r100) {
            if (t(r100) == null) goto L12;
            com.obric.oui.orecyclerview.widget.g r101 = this.f401661a;
            int r102 = r101.f(r100);
            View r103 = ((d0) r101.f401817a).f401799a.getChildAt(r102);
            if (r103 != null) goto L8;
            return;
        L8:
            if (r101.f401818b.e(r102) == false) goto L10;
            r101.l(r103);
        L10:
            ((d0) r101.f401817a).b(r102);
            return;
        }

        public void i0(int r100) {
            boolean r101 = RecyclerView.f401596h2;
        }

        public final void k0(RecyclerView r100) {
            l0(View.MeasureSpec.makeMeasureSpec(r100.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r100.getHeight(), 1073741824));
        }

        public final void o(q r100) {
            int r101 = u();
        L3:
            r101 = r101 - 1;
            if (r101 < 0) goto L6;
            g0(r100, r101, t(r101));
            goto L3
        }

        public final void o0(RecyclerView r100) {
            if (r100 != null) goto L4;
            this.f401662b = null;
            this.f401661a = null;
            this.f401672l = 0;
            this.f401673m = 0;
        L5:
            this.f401670j = 1073741824;
            this.f401671k = 1073741824;
            return;
        L4:
            this.f401662b = r100;
            this.f401661a = r100.f401608e;
            this.f401672l = r100.getWidth();
            this.f401673m = r100.getHeight();
            goto L5
        }

        public View p(int r100) {
            int r101 = u();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L17;
            View r103 = t(r102);
            y r104 = RecyclerView.E(r103);
            if (r104 == null) goto L16;
            if (r104.d() != r100) goto L16;
            if (r104.o() == true) goto L16;
            if (this.f401662b.L0.f401712g == true) goto L15;
            if (r104.i() == true) goto L16;
        L15:
            return r103;
        L16:
            r102 = r102 + 1;
            goto L3
        L17:
            return null;
        }

        public LayoutParams s(ViewGroup.LayoutParams r100) {
            if ((r100 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r100);
        L7:
            if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
        L11:
            return new LayoutParams(r100);
        }

        public final void s0(com.obric.oui.orecyclerview.widget.u r100) {
            u r101 = this.f401665e;
            if (r101 == null) goto L8;
            if (r100 == r101) goto L8;
            if (r101.f401696e == false) goto L8;
            r101.c();
        L8:
            this.f401665e = r100;
            RecyclerView r102 = this.f401662b;
            r102.f401618k0.d();
            if (r100.f401699h == true) goto L11;
        L11:
            r100.f401693b = r102;
            r100.f401694c = this;
            int r103 = r100.f401692a;
            if (r103 == (-1)) goto L16;
            r102.L0.f401706a = r103;
            r100.f401696e = true;
            r100.f401695d = true;
            r100.f401697f = r102.f401621m.p(r103);
            r100.f401693b.f401618k0.b();
            r100.f401699h = true;
            return;
        L16:
            throw new IllegalArgumentException("Invalid target position");
        }

        public final View t(int r100) {
            com.obric.oui.orecyclerview.widget.g r101 = this.f401661a;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.d(r100);
        }

        public static void x(View r100, Rect r101) {
            boolean r102 = RecyclerView.f401596h2;
            LayoutParams r103 = (LayoutParams) r100.getLayoutParams();
            Rect r104 = r103.f401652b;
            r101.set((r100.getLeft() - r104.left) - ((ViewGroup.MarginLayoutParams) r103).leftMargin, (r100.getTop() - r104.top) - ((ViewGroup.MarginLayoutParams) r103).topMargin, (r100.getRight() + r104.right) + ((ViewGroup.MarginLayoutParams) r103).rightMargin, (r100.getBottom() + r104.bottom) + ((ViewGroup.MarginLayoutParams) r103).bottomMargin);
        }

        public final void H(View r100, Rect r101) {
            Rect r102 = ((LayoutParams) r100.getLayoutParams()).f401652b;
            r101.set(-r102.left, -r102.top, r100.getWidth() + r102.right, r100.getHeight() + r102.bottom);
            if (this.f401662b == null) goto L9;
            Matrix r103 = r100.getMatrix();
            if (r103 == null) goto L9;
            if (r103.isIdentity() == true) goto L9;
            RectF r104 = this.f401662b.f401617k;
            r104.set(r101);
            r103.mapRect(r104);
            r101.set((int) Math.floor(r104.left), (int) Math.floor(r104.top), (int) Math.ceil(r104.right), (int) Math.ceil(r104.bottom));
        L9:
            r101.offset(r100.getLeft(), r100.getTop());
        }

        public final void Q(View r100, AccessibilityNodeInfoCompat r101) {
            y r102 = RecyclerView.E(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.i() == false) goto L7;
            return;
        L7:
            if (this.f401661a.k(r102.f401728a) == true) goto L12;
            RecyclerView r103 = this.f401662b;
            R(r103.f401603b, r103.L0, r100, r101);
            return;
        }

        public final void l0(int r100, int r101) {
            this.f401672l = View.MeasureSpec.getSize(r100);
            int r102 = View.MeasureSpec.getMode(r100);
            this.f401670j = r102;
            if (r102 == 0) goto L5;
        L7:
            this.f401673m = View.MeasureSpec.getSize(r101);
            int r103 = View.MeasureSpec.getMode(r101);
            this.f401671k = r103;
            if (r103 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.f401599x2 == true) goto L14;
            this.f401673m = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.f401599x2 == true) goto L7;
            this.f401672l = 0;
            goto L7
        }

        public final void n0(int r100, int r110) {
            int r101 = u();
            if (r101 != 0) goto L6;
            this.f401662b.o(r100, r110);
            return;
        L6:
            int r102 = Integer.MAX_VALUE;
            int r103 = Integer.MAX_VALUE;
            int r104 = Integer.MIN_VALUE;
            int r105 = Integer.MIN_VALUE;
            int r106 = 0;
        L7:
            if (r106 >= r101) goto L21;
            View r107 = t(r106);
            Rect r108 = this.f401662b.f401615i;
            x(r107, r108);
            int r109 = r108.left;
            if (r109 >= r102) goto L11;
            r102 = r109;
        L11:
            int r111 = r108.right;
            if (r111 <= r104) goto L14;
            r104 = r111;
        L14:
            int r112 = r108.top;
            if (r112 >= r103) goto L17;
            r103 = r112;
        L17:
            int r113 = r108.bottom;
            if (r113 <= r105) goto L20;
            r105 = r113;
        L20:
            r106 = r106 + 1;
            goto L7
        L21:
            this.f401662b.f401615i.set(r102, r103, r104, r105);
            m0(this.f401662b.f401615i, r100, r110);
        }

        public LayoutParams r(Context r100, AttributeSet r101) {
            return new LayoutParams(r100, r101);
        }

        public static boolean J(int r100, int r101, int r102) {
            int r103 = View.MeasureSpec.getMode(r101);
            int r104 = View.MeasureSpec.getSize(r101);
            if (r102 <= 0) goto L7;
            if (r100 == r102) goto L7;
            return false;
        L7:
            if (r103 == Integer.MIN_VALUE) goto L16;
            if (r103 != 0) goto L10;
            return true;
        L10:
            if (r103 == 1073741824) goto L12;
            return false;
        L12:
            if (r104 != r100) goto L19;
            return true;
        L19:
            return false;
        L16:
            if (r104 < r100) goto L20;
            return true;
        L20:
            return false;
        }

        public static int f(int r100, int r101, int r102) {
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = View.MeasureSpec.getSize(r100);
            if (r103 == Integer.MIN_VALUE) goto L9;
            if (r103 != 1073741824) goto L7;
            return r104;
        L7:
            return Math.max(r101, r102);
        L9:
            return Math.min(r104, Math.max(r101, r102));
        }

        public void P(q r100, v r101, AccessibilityNodeInfoCompat r102) {
            if (this.f401662b.canScrollVertically(-1) == false) goto L5;
        L6:
            r102.addAction(8192);
            r102.setScrollable(true);
        L8:
            if (this.f401662b.canScrollVertically(1) == false) goto L10;
        L11:
            r102.addAction(4096);
            r102.setScrollable(true);
        L12:
            r102.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(G(r100, r101), w(r100, r101), false, 0));
            return;
        L10:
            if (this.f401662b.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.f401662b.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public final void a(View r100, int r110, boolean r111) {
            y r101 = RecyclerView.E(r100);
            if (r111 == false) goto L5;
        L8:
            j0 r112 = this.f401662b.f401609f;
            j0.a r102 = r112.f401835a.get(r101);
            if (r102 != null) goto L11;
            r102 = j0.a.a();
            r112.f401835a.put(r101, r102);
        L11:
            r102.f401838a |= 1;
        L12:
            LayoutParams r113 = (LayoutParams) r100.getLayoutParams();
            if ((r101.f401737j & 32) == 0) goto L15;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L52;
            if (r101.j() == true) goto L52;
            int r104 = -1;
            if (r100.getParent() != this.f401662b) goto L41;
            int r105 = this.f401661a.j(r100);
            if (r110 != (-1)) goto L25;
            r110 = this.f401661a.e();
        L25:
            if (r105 == (-1)) goto L40;
            if (r105 == r110) goto L57;
            k r106 = this.f401662b.f401621m;
            View r107 = r106.t(r105);
            if (r107 == null) goto L38;
            r106.t(r105);
            r106.f401661a.c(r105);
            LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
            y r109 = RecyclerView.E(r107);
            if (r109.i() == false) goto L35;
            j0 r114 = r106.f401662b.f401609f;
            j0.a r115 = r114.f401835a.get(r109);
            if (r115 != null) goto L34;
            r115 = j0.a.a();
            r114.f401835a.put(r109, r115);
        L34:
            r115.f401838a = 1 | r115.f401838a;
        L36:
            r106.f401661a.b(r107, r110, r108, r109.i());
            goto L57
        L35:
            r106.f401662b.f401609f.c(r109);
            goto L36
        L38:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r105 + r106.f401662b.toString());
        L57:
            if (r113.f401654d == true) goto L59;
            return;
        L59:
            if (RecyclerView.f401597p2 == false) goto L61;
            Objects.toString(r113.f401651a);
        L61:
            r101.f401728a.invalidate();
            r113.f401654d = false;
            return;
        L40:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f401662b.indexOfChild(r100) + this.f401662b.t());
        L41:
            this.f401661a.a(r100, r110, false);
            r113.f401653c = true;
            u r116 = this.f401665e;
            if (r116 == null) goto L57;
            if (r116.f401696e == false) goto L57;
            r116.f401693b.getClass();
            y r117 = RecyclerView.E(r100);
            if (r117 == null) goto L49;
            r104 = r117.d();
        L49:
            if (r104 != r116.f401692a) goto L57;
            r116.f401697f = r100;
        L52:
            if (r101.j() == false) goto L54;
            r101.f401741n.l(r101);
        L55:
            this.f401661a.b(r100, r110, r100.getLayoutParams(), false);
            goto L57
        L54:
            r101.f401737j &= -33;
            goto L55
        L15:
            r103 = false;
            goto L16
        L5:
            if (r101.i() == true) goto L8;
            this.f401662b.f401609f.c(r101);
            goto L12
        }

        public final void g0(q r100, int r101, View r102) {
            y r103 = RecyclerView.E(r102);
            if (r103.o() == false) goto L9;
            if (RecyclerView.f401597p2 == false) goto L15;
            r103.toString();
            return;
        L15:
            return;
        L9:
            if (r103.g() == true) goto L11;
        L13:
            t(r101);
            this.f401661a.c(r101);
            r100.j(r102);
            this.f401662b.f401609f.c(r103);
            return;
        L11:
            if (r103.i() == true) goto L13;
            this.f401662b.f401620l.getClass();
            d0(r101);
            r100.i(r103);
        }

        public void m0(Rect r100, int r101, int r102) {
            int r103 = (r100.width() + C()) + D();
            int r104 = (r100.height() + E()) + B();
            int r105 = f(r101, r103, ViewCompat.getMinimumWidth(this.f401662b));
            int r106 = f(r102, r104, ViewCompat.getMinimumHeight(this.f401662b));
            RecyclerView.g(this.f401662b, r105, r106);
        }

        public final boolean p0(View r100, int r101, int r102, LayoutParams r103) {
            if (r100.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.f401666f == false) goto L12;
            if (J(r100.getWidth(), r101, ((ViewGroup.MarginLayoutParams) r103).width) == false) goto L12;
            if (J(r100.getHeight(), r102, ((ViewGroup.MarginLayoutParams) r103).height) == false) goto L12;
            return false;
        }

        public static void K(View r100, int r101, int r102, int r103, int r104) {
            LayoutParams r105 = (LayoutParams) r100.getLayoutParams();
            Rect r106 = r105.f401652b;
            r100.layout((r101 + r106.left) + ((ViewGroup.MarginLayoutParams) r105).leftMargin, (r102 + r106.top) + ((ViewGroup.MarginLayoutParams) r105).topMargin, (r103 - r106.right) - ((ViewGroup.MarginLayoutParams) r105).rightMargin, (r104 - r106.bottom) - ((ViewGroup.MarginLayoutParams) r105).bottomMargin);
        }

        public static int v(int r100, int r101, int r102, int r103, boolean r104) {
            int r105 = Math.max(0, r100 - r102);
            if (r104 == false) goto L11;
            if (r103 >= 0) goto L12;
            if (r103 != (-1)) goto L21;
            if (r101 == Integer.MIN_VALUE) goto L14;
            if (r101 == 0) goto L21;
            if (r101 != 1073741824) goto L21;
        L14:
            r103 = r105;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r103, r101);
        L21:
            r101 = 0;
            r103 = 0;
        L12:
            r101 = 1073741824;
            goto L23
        L11:
            if (r103 >= 0) goto L12;
            if (r103 == (-1)) goto L14;
            if (r103 != (-2)) goto L21;
            if (r101 == Integer.MIN_VALUE) goto L20;
            if (r101 == 1073741824) goto L20;
            r101 = 0;
        L20:
            r101 = Integer.MIN_VALUE;
            goto L14
        }

        public final boolean e0(RecyclerView r110, View r111, Rect r210, boolean r211, boolean r212) {
            int r100 = C();
            int r101 = E();
            int r102 = this.f401672l - D();
            int r103 = this.f401673m - B();
            int r104 = (r111.getLeft() + r210.left) - r111.getScrollX();
            int r105 = (r111.getTop() + r210.top) - r111.getScrollY();
            int r106 = r210.width() + r104;
            int r107 = r210.height() + r105;
            int r108 = r104 - r100;
            int r109 = Math.min(0, r108);
            int r112 = r105 - r101;
            int r113 = Math.min(0, r112);
            int r114 = r106 - r102;
            int r115 = Math.max(0, r114);
            int r116 = Math.max(0, r107 - r103);
            if (ViewCompat.getLayoutDirection(this.f401662b) != 1) goto L8;
            if (r115 != 0) goto L7;
            r115 = Math.max(r109, r114);
        L7:
            int r117 = r115;
        L12:
            if (r113 != 0) goto L15;
            r113 = Math.min(r112, r116);
        L15:
            int r118 = r113;
            if (r212 == false) goto L32;
            View r119 = r110.getFocusedChild();
            if (r119 == null) goto L30;
            int r120 = C();
            int r121 = E();
            int r122 = this.f401672l - D();
            int r123 = this.f401673m - B();
            Rect r124 = this.f401662b.f401615i;
            x(r119, r124);
            if ((r124.left - r117) >= r122) goto L30;
            if ((r124.right - r117) <= r120) goto L30;
            if ((r124.top - r118) >= r123) goto L30;
            if ((r124.bottom - r118) <= r121) goto L30;
            boolean r125 = true;
        L31:
            if (r125 == true) goto L32;
        L35:
            return false;
        L30:
            r125 = false;
        L32:
            if (r117 != 0) goto L36;
            if (r118 == 0) goto L35;
        L36:
            if (r211 == false) goto L38;
            r110.scrollBy(r117, r118);
        L39:
            return true;
        L38:
            r110.X(r117, r118, null, Integer.MIN_VALUE, false);
            goto L39
        L8:
            if (r109 != 0) goto L11;
            r109 = Math.min(r108, r115);
        L11:
            r117 = r109;
            goto L12
        }
    }

    public interface l {
    }

    public static abstract class m {
        public m() {
        }
    }

    public interface n {
        boolean a(RecyclerView r100, MotionEvent r101);

        void b();

        void onTouchEvent(MotionEvent r100);
    }

    public static abstract class o {
        public o() {
        }

        public void a(RecyclerView r100, int r101) {
        }

        public void b(RecyclerView r100, int r101, int r102) {
        }
    }

    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f401676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<Adapter<?>> f401678c;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<y> f401679a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f401680b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f401681c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f401682d;

            public a() {
                this.f401679a = new ArrayList();
                this.f401680b = 5;
                this.f401681c = 0;
                this.f401682d = 0;
            }
        }

        public p() {
            this.f401676a = new SparseArray();
            this.f401677b = 0;
            this.f401678c = Collections.newSetFromMap(new IdentityHashMap());
        }

        public final a a(int r100) {
            a r101 = this.f401676a.get(r100);
            if (r101 != null) goto L6;
            a r102 = new a();
            this.f401676a.put(r100, r102);
            return r102;
        L6:
            return r101;
        }
    }

    public final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<y> f401683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<y> f401684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<y> f401685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<y> f401686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f401688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public p f401689g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401690h;

        public final p c() {
            if (this.f401689g != null) goto L6;
            this.f401689g = new p();
            d();
        L6:
            return this.f401689g;
        }

        public final void d() {
            if (this.f401689g == null) goto L10;
            RecyclerView r100 = this.f401690h;
            if (r100.f401620l != null) goto L7;
            return;
        L7:
            if (r100.isAttachedToWindow() == false) goto L12;
            p r101 = this.f401689g;
            Adapter<?> r102 = this.f401690h.f401620l;
            r101.f401678c.add(r102);
            return;
        L12:
            return;
        }

        public final void f() {
            int r100 = this.f401685c.size() - 1;
        L3:
            if (r100 < 0) goto L5;
            g(r100);
            r100 = r100 - 1;
            goto L3
        L5:
            this.f401685c.clear();
            if (RecyclerView.E2 == false) goto L13;
            com.obric.oui.orecyclerview.widget.s.b r101 = this.f401690h.H0;
            int[] r102 = r101.f401949c;
            if (r102 == null) goto L10;
            Arrays.fill(r102, -1);
        L10:
            r101.f401950d = 0;
            return;
        }

        public final void m() {
            k r100 = this.f401690h.f401621m;
            if (r100 == null) goto L5;
            int r101 = r100.f401668h;
        L6:
            this.f401688f = this.f401687e + r101;
            int r102 = this.f401685c.size() - 1;
        L7:
            if (r102 < 0) goto L11;
            if (this.f401685c.size() <= this.f401688f) goto L14;
            g(r102);
            r102 = r102 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r101 = 0;
            goto L6
        }

        public q(RecyclerView r100) {
            this.f401690h = r100;
            ArrayList<y> r101 = new ArrayList();
            this.f401683a = r101;
            this.f401684b = null;
            this.f401685c = new ArrayList();
            this.f401686d = Collections.unmodifiableList(r101);
            this.f401687e = 2;
            this.f401688f = 2;
        }

        public final int b(int r100) {
            if (r100 < 0) goto L11;
            if (r100 >= this.f401690h.L0.b()) goto L11;
            RecyclerView r101 = this.f401690h;
            if (r101.L0.f401712g == true) goto L9;
            return r100;
        L9:
            return r101.f401607d.f(r100, 0);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r100 + ". State item count is " + this.f401690h.L0.b() + this.f401690h.t());
        }

        public final void g(int r100) {
            if (RecyclerView.f401597p2 == true) goto L5;
        L5:
            y r101 = (y) ListProtector.get(this.f401685c, r100);
            if (RecyclerView.f401597p2 == false) goto L8;
            Objects.toString(r101);
        L8:
            a(r101, true);
            ListProtector.remove(this.f401685c, r100);
        }

        public final void h(View r100) {
            y r101 = RecyclerView.E(r100);
            boolean r102 = false;
            if (r101.k() == false) goto L6;
            this.f401690h.removeDetachedView(r100, false);
        L6:
            if (r101.j() == false) goto L8;
            r101.f401741n.l(r101);
        L13:
            i(r101);
            if (this.f401690h.I != null) goto L16;
            return;
        L16:
            if (r101.h() == true) goto L20;
            this.f401690h.I.e(r101);
            return;
        L20:
            return;
        L8:
            int r103 = r101.f401737j;
            if ((r103 & 32) == 0) goto L11;
            r102 = true;
        L11:
            if (r102 == false) goto L13;
            r101.f401737j = r103 & (-33);
            goto L13
        }

        public final void i(y r110) {
            boolean r100 = false;
            if (r110.j() == false) goto L5;
        L81:
            StringBuilder r101 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            r101.append(r110.j());
            r101.append(" isAttached:");
            if (r110.f401728a.getParent() == null) goto L84;
            r100 = true;
        L84:
            r101.append(r100);
            r101.append(this.f401690h.t());
            throw new IllegalArgumentException(r101.toString());
        L5:
            if (r110.f401728a.getParent() != null) goto L81;
            if (r110.k() == true) goto L80;
            if (r110.o() == true) goto L78;
            if ((r110.f401737j & 16) == 0) goto L14;
        L16:
            boolean r102 = false;
        L17:
            Adapter r103 = this.f401690h.f401620l;
            if (RecyclerView.f401596h2 == false) goto L25;
            if (this.f401685c.contains(r110) == false) goto L25;
            throw new IllegalArgumentException("cached view received recycle internal? " + r110 + this.f401690h.t());
        L25:
            if (r110.h() == false) goto L68;
            if (this.f401688f > 0) goto L29;
        L64:
            boolean r104 = false;
        L65:
            if (r104 == true) goto L71;
            a(r110, true);
            r100 = true;
        L71:
            this.f401690h.f401609f.d(r110);
            if (r104 == true) goto L95;
            if (r100 == true) goto L96;
            if (r102 == false) goto L97;
            PoolingContainer.callPoolingContainerOnRelease(r110.f401728a);
            r110.f401746s = null;
            r110.f401745r = null;
            return;
        L97:
            return;
        L96:
            return;
        L95:
            return;
        L29:
            if ((r110.f401737j & 526) == 0) goto L31;
            boolean r105 = true;
        L32:
            if (r105 == true) goto L64;
            int r106 = this.f401685c.size();
            if (r106 < this.f401688f) goto L38;
            if (r106 <= 0) goto L38;
            g(0);
            r106 = r106 - 1;
        L38:
            if (RecyclerView.E2 == false) goto L63;
            if (r106 <= 0) goto L63;
            com.obric.oui.orecyclerview.widget.s.b r107 = this.f401690h.H0;
            int r108 = r110.f401730c;
            if (r107.f401949c == null) goto L48;
            int r109 = r107.f401950d * 2;
            int r111 = 0;
        L43:
            if (r111 >= r109) goto L48;
            if (r107.f401949c[r111] == r108) goto L46;
            r111 = r111 + 2;
            goto L43
        L46:
            boolean r112 = true;
        L49:
            if (r112 == true) goto L63;
        L50:
            r106 = r106 - 1;
            if (r106 < 0) goto L62;
            int r113 = ((y) ListProtector.get(this.f401685c, r106)).f401730c;
            com.obric.oui.orecyclerview.widget.s.b r114 = this.f401690h.H0;
            if (r114.f401949c == null) goto L60;
            int r115 = r114.f401950d * 2;
            int r116 = 0;
        L55:
            if (r116 >= r115) goto L60;
            if (r114.f401949c[r116] == r113) goto L58;
            r116 = r116 + 2;
            goto L55
        L58:
            boolean r117 = true;
        L61:
            if (r117 == true) goto L50;
        L60:
            r117 = false;
        L62:
            r106 = r106 + 1;
        L48:
            r112 = false;
        L63:
            ListProtector.add(this.f401685c, r106, r110);
            r104 = true;
            goto L65
        L31:
            r105 = false;
            goto L32
        L68:
            if (RecyclerView.f401597p2 == false) goto L70;
            this.f401690h.t();
        L70:
            r104 = false;
            goto L71
        L14:
            if (ViewCompat.hasTransientState(r110.f401728a) == false) goto L16;
            r102 = true;
            goto L17
        L78:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f401690h.t());
        L80:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r110 + this.f401690h.t());
        }

        public final void j(View r100) {
            y r101 = RecyclerView.E(r100);
            int r102 = r101.f401737j;
            if ((12 & r102) == 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L38;
            if ((r102 & 2) == 0) goto L10;
            boolean r104 = true;
        L11:
            if (r104 == false) goto L38;
            ItemAnimator r105 = this.f401690h.I;
            if (r105 == null) goto L30;
            com.obric.oui.orecyclerview.widget.p r106 = (com.obric.oui.orecyclerview.widget.p) r105;
            if (r101.e().isEmpty() == true) goto L17;
        L26:
            boolean r107 = true;
        L27:
            if (r107 == true) goto L30;
            boolean r108 = false;
        L31:
            if (r108 == true) goto L38;
            if (this.f401684b != null) goto L36;
            this.f401684b = new ArrayList();
        L36:
            r101.f401741n = this;
            r101.f401742o = true;
            this.f401684b.add(r101);
            return;
        L17:
            if (r106.f401822g == true) goto L19;
        L22:
            boolean r109 = true;
        L23:
            if (r109 == true) goto L26;
            r107 = false;
            goto L27
        L19:
            if (r101.g() == true) goto L22;
            r109 = false;
        L30:
            r108 = true;
            goto L31
        L10:
            r104 = false;
        L38:
            if (r101.g() == true) goto L40;
        L44:
            r101.f401741n = this;
            r101.f401742o = false;
            this.f401683a.add(r101);
            return;
        L40:
            if (r101.i() == true) goto L44;
            this.f401690h.f401620l.getClass();
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f401690h.t());
        L5:
            r103 = false;
            goto L6
        }

        public final void l(y r100) {
            if (r100.f401742o == false) goto L5;
            this.f401684b.remove(r100);
        L6:
            r100.f401741n = null;
            r100.f401742o = false;
            r100.f401737j &= -33;
            return;
        L5:
            this.f401683a.remove(r100);
            goto L6
        }

        public final void a(y r100, boolean r101) {
            RecyclerView.l(r100);
            View r102 = r100.f401728a;
            RecyclerViewAccessibilityDelegate r103 = this.f401690h.f401626p1;
            if (r103 == null) goto L9;
            RecyclerViewAccessibilityDelegate.ItemDelegate r104 = r103.f401748b;
            if ((r104 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r105 = (AccessibilityDelegateCompat) ((WeakHashMap) r104.f401750b).remove(r102);
        L8:
            ViewCompat.setAccessibilityDelegate(r102, r105);
            goto L9
        L7:
            r105 = null;
        L9:
            if (r101 == false) goto L22;
            r r106 = this.f401690h.f401622n;
            if (r106 == null) goto L13;
            r106.onViewRecycled();
        L13:
            int r107 = ((ArrayList) this.f401690h.f401623o).size();
            int r108 = 0;
        L14:
            if (r108 >= r107) goto L16;
            ((r) ListProtector.get(this.f401690h.f401623o, r108)).onViewRecycled();
            r108 = r108 + 1;
            goto L14
        L16:
            RecyclerView r109 = this.f401690h;
            Adapter r110 = r109.f401620l;
            if (r109.L0 == null) goto L20;
            r109.f401609f.d(r100);
        L20:
            if (RecyclerView.f401597p2 == false) goto L22;
            Objects.toString(r100);
        L22:
            r100.f401746s = null;
            r100.f401745r = null;
            p r111 = c();
            r111.getClass();
            int r112 = r100.f401733f;
            ArrayList<y> r113 = r111.a(r112).f401679a;
            if (r111.f401676a.get(r112).f401680b > r113.size()) goto L26;
            PoolingContainer.callPoolingContainerOnRelease(r100.f401728a);
            return;
        L26:
            if (RecyclerView.f401596h2 == true) goto L28;
        L32:
            r100.m();
            r113.add(r100);
            return;
        L28:
            if (r113.contains(r100) == false) goto L32;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        public final void e(Adapter<?> r100, boolean r101) {
            p r102 = this.f401689g;
            if (r102 == null) goto L15;
            r102.f401678c.remove(r100);
            if (r102.f401678c.size() != 0) goto L18;
            if (r101 == true) goto L19;
            int r103 = 0;
        L9:
            if (r103 >= r102.f401676a.size()) goto L20;
            SparseArray<p.a> r104 = r102.f401676a;
            ArrayList<y> r105 = r104.get(r104.keyAt(r103)).f401679a;
            int r106 = 0;
        L12:
            if (r106 >= r105.size()) goto L14;
            PoolingContainer.callPoolingContainerOnRelease(((y) ListProtector.get(r105, r106)).f401728a);
            r106 = r106 + 1;
            goto L12
        L14:
            r103 = r103 + 1;
            goto L9
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }

        public final y k(int r210, long r211) {
            if (r210 < 0) goto L316;
            if (r210 >= this.f401690h.L0.b()) goto L316;
            if (this.f401690h.L0.f401712g == false) goto L28;
            ArrayList<y> r100 = this.f401684b;
            if (r100 == null) goto L25;
            int r101 = r100.size();
            if (r101 == 0) goto L25;
            int r102 = 0;
        L14:
            if (r102 >= r101) goto L24;
            y r103 = (y) ListProtector.get(this.f401684b, r102);
            if ((r103.f401737j & 32) == 0) goto L18;
            boolean r104 = true;
        L19:
            if (r104 == true) goto L23;
            if (r103.d() != r210) goto L23;
            r103.b(32);
        L26:
            if (r103 == null) goto L29;
            boolean r105 = true;
        L31:
            if (r103 != null) goto L129;
            int r106 = this.f401683a.size();
            int r107 = 0;
        L33:
            if (r107 >= r106) goto L49;
            y r110 = (y) ListProtector.get(this.f401683a, r107);
            if ((r110.f401737j & 32) == 0) goto L37;
            boolean r111 = true;
        L38:
            if (r111 == true) goto L48;
            if (r110.d() != r210) goto L48;
            if (r110.g() == true) goto L48;
            if (this.f401690h.L0.f401712g == true) goto L47;
            if (r110.i() == true) goto L48;
        L47:
            r110.b(32);
            r103 = r110;
        L93:
            if (r103 == null) goto L129;
            if (r103.i() == true) goto L97;
            int r108 = r103.f401730c;
            if (r108 < 0) goto L127;
            if (r108 >= this.f401690h.f401620l.a()) goto L127;
            RecyclerView r109 = this.f401690h;
            if (r109.L0.f401712g == false) goto L111;
        L113:
            this.f401690h.f401620l.getClass();
            boolean r112 = true;
        L114:
            if (r112 == true) goto L125;
            r103.b(4);
            if (r103.j() == false) goto L118;
            this.f401690h.removeDetachedView(r103.f401728a, false);
            r103.f401741n.l(r103);
        L124:
            i(r103);
            r103 = null;
            goto L129
        L118:
            int r113 = r103.f401737j;
            if ((r113 & 32) == 0) goto L121;
            boolean r114 = true;
        L122:
            if (r114 == false) goto L124;
            r103.f401737j = r113 & (-33);
            goto L124
        L121:
            r114 = false;
            goto L122
        L125:
            r105 = true;
            goto L129
        L111:
            if (r109.f401620l.b(r103.f401730c) == r103.f401733f) goto L113;
            r112 = false;
        L127:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r103 + this.f401690h.t());
        L97:
            if (RecyclerView.f401596h2 == true) goto L99;
        L103:
            r112 = this.f401690h.L0.f401712g;
            goto L114
        L99:
            if (this.f401690h.L0.f401712g == true) goto L103;
            throw new IllegalStateException("should not receive a removed view unless it is pre layout" + this.f401690h.t());
        L48:
            r107 = r107 + 1;
            goto L33
        L37:
            r111 = false;
            goto L38
        L49:
            com.obric.oui.orecyclerview.widget.g r115 = this.f401690h.f401608e;
            int r116 = ((ArrayList) r115.f401819c).size();
            int r117 = 0;
        L50:
            if (r117 >= r116) goto L59;
            View r118 = (View) ListProtector.get(r115.f401819c, r117);
            ((d0) r115.f401817a).getClass();
            y r119 = RecyclerView.E(r118);
            if (r119.d() != r210) goto L58;
            if (r119.g() == true) goto L58;
            if (r119.i() == true) goto L58;
        L60:
            if (r118 == null) goto L74;
            y r120 = RecyclerView.E(r118);
            com.obric.oui.orecyclerview.widget.g r121 = this.f401690h.f401608e;
            int r122 = ((d0) r121.f401817a).f401799a.indexOfChild(r118);
            if (r122 < 0) goto L73;
            if (r121.f401818b.d(r122) == false) goto L71;
            r121.f401818b.a(r122);
            r121.l(r118);
            int r123 = this.f401690h.f401608e.j(r118);
            if (r123 == (-1)) goto L69;
            this.f401690h.f401608e.c(r123);
            j(r118);
            r120.b(AVMDLDataLoader.KeyIsEnableSpeedEngine);
            r103 = r120;
            goto L93
        L69:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r120 + this.f401690h.t());
        L71:
            throw new RuntimeException("trying to unhide a view that was not hidden" + r118);
        L73:
            throw new IllegalArgumentException("view is not a child, cannot hide " + r118);
        L74:
            int r124 = this.f401685c.size();
            int r125 = 0;
        L75:
            if (r125 >= r124) goto L92;
            y r126 = (y) ListProtector.get(this.f401685c, r125);
            if (r126.g() == true) goto L91;
            if (r126.d() != r210) goto L91;
            if (r126.f401728a.getParent() != null) goto L83;
        L85:
            boolean r127 = false;
        L86:
            if (r127 == true) goto L91;
            ListProtector.remove(this.f401685c, r125);
            if (RecyclerView.f401597p2 == false) goto L90;
            r126.toString();
        L90:
            r103 = r126;
            goto L93
        L83:
            if (r126.f401728a.getParent() == r126.f401745r) goto L85;
            r127 = true;
        L91:
            r125 = r125 + 1;
            goto L75
        L92:
            r103 = null;
        L58:
            r117 = r117 + 1;
            goto L50
        L59:
            r118 = null;
        L129:
            if (r103 != null) goto L191;
            int r128 = this.f401690h.f401607d.f(r210, 0);
            if (r128 < 0) goto L190;
            if (r128 >= this.f401690h.f401620l.a()) goto L190;
            int r129 = this.f401690h.f401620l.b(r128);
            this.f401690h.f401620l.getClass();
            if (r103 == null) goto L137;
        L158:
            if (r103 != null) goto L191;
            long r130 = this.f401690h.getNanoTime();
            if (r211 == Long.MAX_VALUE) goto L170;
            long r131 = this.f401689g.a(r129).f401681c;
            if (r131 != 0) goto L164;
        L167:
            boolean r132 = true;
        L168:
            if (r132 == true) goto L170;
            return null;
        L164:
            if ((r131 + r130) < r211) goto L167;
            r132 = false;
        L170:
            RecyclerView r133 = this.f401690h;
            Adapter r134 = r133.f401620l;
            r134.getClass();
            TraceCompat.beginSection("RV CreateView");     // Catch: Throwable -> L186
            r103 = r134.d(r133, r129);     // Catch: Throwable -> L186
            if (r103.f401728a.getParent() != null) goto L185;
            r103.f401733f = r129;     // Catch: Throwable -> L186
            TraceCompat.endSection();
            if (RecyclerView.E2 == false) goto L179;
            RecyclerView r135 = RecyclerView.y(r103.f401728a);
            if (r135 == null) goto L179;
            r103.f401729b = new WeakReference(r135);
        L179:
            long r136 = this.f401690h.getNanoTime() - r130;
            p.a r137 = this.f401689g.a(r129);
            long r138 = r137.f401681c;
            if (r138 == 0) goto L183;
            r136 = (r136 / 4) + ((r138 / 4) * 3);
        L183:
            r137.f401681c = r136;
            goto L191
        L185:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L186
        L186:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        L137:
            if (RecyclerView.f401597p2 == true) goto L139;
        L139:
            p.a r139 = c().f401676a.get(r129);
            if (r139 != null) goto L142;
        L154:
            y r140 = null;
        L155:
            if (r140 == null) goto L157;
            r140.m();
            boolean r141 = RecyclerView.f401596h2;
        L157:
            r103 = r140;
            goto L158
        L142:
            if (r139.f401679a.isEmpty() == true) goto L154;
            ArrayList<y> r142 = r139.f401679a;
            int r143 = r142.size() - 1;
        L144:
            if (r143 < 0) goto L154;
            y r144 = (y) ListProtector.get(r142, r143);
            if (r144.f401728a.getParent() != null) goto L148;
        L150:
            boolean r145 = false;
        L151:
            if (r145 == false) goto L152;
            r143 = r143 - 1;
            goto L144
        L152:
            r140 = (y) ListProtector.remove(r142, r143);
            goto L155
        L148:
            if (r144.f401728a.getParent() == r144.f401745r) goto L150;
            r145 = true;
        L190:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r210 + "(offset:" + r128 + ").state:" + this.f401690h.L0.b() + this.f401690h.t());
        L191:
            if (r105 == false) goto L203;
            v r146 = this.f401690h.L0;
            if (r146.f401712g == true) goto L203;
            int r147 = r103.f401737j;
            if ((8192 & r147) == 0) goto L197;
            boolean r148 = true;
        L198:
            if (r148 == false) goto L203;
            r103.f401737j = (r147 & (-8193)) | 0;
            if (r146.f401715j == false) goto L203;
            ItemAnimator.b(r103);
            ItemAnimator r149 = this.f401690h.I;
            r103.e();
            r149.getClass();
            ItemAnimator.c r150 = new ItemAnimator.c();
            View r151 = r103.f401728a;
            r150.f401649a = r151.getLeft();
            r150.f401650b = r151.getTop();
            r151.getRight();
            r151.getBottom();
            this.f401690h.Q(r103, r150);
            goto L203
        L197:
            r148 = false;
        L203:
            if (this.f401690h.L0.f401712g == false) goto L209;
            if (r103.f() == false) goto L209;
            r103.f401734g = r210;
        L234:
            boolean r152 = false;
        L301:
            ViewGroup.LayoutParams r153 = r103.f401728a.getLayoutParams();
            if (r153 != null) goto L305;
            LayoutParams r154 = (LayoutParams) this.f401690h.generateDefaultLayoutParams();
            r103.f401728a.setLayoutParams(r154);
        L308:
            r154.f401651a = r103;
            if (r105 == false) goto L312;
            if (r152 == false) goto L312;
            boolean r155 = true;
        L313:
            r154.f401654d = r155;
            return r103;
        L312:
            r155 = false;
            goto L313
        L305:
            if (this.f401690h.checkLayoutParams(r153) == true) goto L307;
            r154 = (LayoutParams) this.f401690h.generateLayoutParams(r153);
            r103.f401728a.setLayoutParams(r154);
            goto L308
        L307:
            r154 = (LayoutParams) r153;
        L209:
            if (r103.f() == false) goto L218;
            if ((r103.f401737j & 2) == 0) goto L213;
            boolean r156 = true;
        L214:
            if (r156 == true) goto L218;
            if (r103.g() == false) goto L234;
        L213:
            r156 = false;
        L218:
            if (RecyclerView.f401596h2 == true) goto L220;
        L224:
            int r157 = this.f401690h.f401607d.f(r210, 0);
            r103.f401746s = null;
            RecyclerView r158 = this.f401690h;
            r103.f401745r = r158;
            int r159 = r103.f401733f;
            long r160 = r158.getNanoTime();
            if (r211 == Long.MAX_VALUE) goto L236;
            long r161 = this.f401689g.a(r159).f401682d;
            if (r161 != 0) goto L229;
        L232:
            boolean r162 = true;
        L233:
            if (r162 == true) goto L236;
        L229:
            if ((r161 + r160) < r211) goto L232;
            r162 = false;
        L236:
            if (r103.k() == false) goto L238;
            RecyclerView r163 = this.f401690h;
            RecyclerView.e(r163, r103.f401728a, r163.getChildCount(), r103.f401728a.getLayoutParams());
            boolean r164 = true;
        L239:
            Adapter<? extends y> r165 = this.f401690h.f401620l;
            r165.getClass();
            if (r103.f401746s != null) goto L242;
            boolean r166 = true;
        L243:
            if (r166 == false) goto L245;
            r103.f401730c = r157;
            r103.f401737j = 1 | (r103.f401737j & NetError.ERR_TTNET_FT_INVALID_STREAM_ID);
            TraceCompat.beginSection("RV OnBindView");
        L245:
            r103.f401746s = r165;
            if (RecyclerView.f401596h2 == true) goto L248;
        L261:
            r103.e();
            r165.c(r103, r157);
            if (r166 == false) goto L270;
            List<Object> r167 = r103.f401738k;
            if (r167 == null) goto L266;
            ((ArrayList) r167).clear();
        L266:
            r103.f401737j &= -1025;
            ViewGroup.LayoutParams r168 = r103.f401728a.getLayoutParams();
            if ((r168 instanceof LayoutParams) == false) goto L269;
            ((LayoutParams) r168).f401653c = true;
        L269:
            TraceCompat.endSection();
        L270:
            if (r164 == false) goto L272;
            RecyclerView.f(this.f401690h, r103.f401728a);
        L272:
            long r169 = this.f401690h.getNanoTime() - r160;
            p.a r170 = this.f401689g.a(r103.f401733f);
            long r171 = r170.f401682d;
            if (r171 == 0) goto L276;
            r169 = (r169 / 4) + ((r171 / 4) * 3);
        L276:
            r170.f401682d = r169;
            AccessibilityManager r172 = this.f401690h.B;
            if (r172 != null) goto L279;
        L281:
            boolean r173 = false;
        L282:
            if (r173 == false) goto L298;
            View r174 = r103.f401728a;
            if (ViewCompat.getImportantForAccessibility(r174) != 0) goto L286;
            ViewCompat.setImportantForAccessibility(r174, 1);
        L286:
            RecyclerViewAccessibilityDelegate r175 = this.f401690h.f401626p1;
            if (r175 == null) goto L298;
            RecyclerViewAccessibilityDelegate.ItemDelegate r176 = r175.f401748b;
            if ((r176 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L295;
            r176.getClass();
            AccessibilityDelegateCompat r177 = ViewCompat.getAccessibilityDelegate(r174);
            if (r177 == null) goto L295;
            if (r177 == r176) goto L295;
            ((WeakHashMap) r176.f401750b).put(r174, r177);
        L295:
            ViewCompat.setAccessibilityDelegate(r174, r176);
        L298:
            if (this.f401690h.L0.f401712g == false) goto L300;
            r103.f401734g = r210;
        L300:
            r152 = true;
            goto L301
        L279:
            if (r172.isEnabled() == false) goto L281;
            r173 = true;
            goto L282
        L248:
            if (r103.f401728a.getParent() != null) goto L255;
            if (ViewCompat.isAttachedToWindow(r103.f401728a) == r103.k()) goto L255;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r103.k() + ", attached to window: " + ViewCompat.isAttachedToWindow(r103.f401728a) + ", holder: " + r103);
        L255:
            if (r103.f401728a.getParent() != null) goto L261;
            if (ViewCompat.isAttachedToWindow(r103.f401728a) == false) goto L261;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r103);
        L242:
            r166 = false;
            goto L243
        L238:
            r164 = false;
            goto L239
        L220:
            if (r103.i() == false) goto L224;
            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + r103 + this.f401690h.t());
        L29:
            r105 = false;
        L23:
            r102 = r102 + 1;
            goto L14
        L18:
            r104 = false;
            goto L19
        L24:
            this.f401690h.f401620l.getClass();
        L25:
            r103 = null;
            goto L26
        L28:
            r103 = null;
        L316:
            throw new IndexOutOfBoundsException("Invalid item position " + r210 + "(" + r210 + "). Item count:" + this.f401690h.L0.b() + this.f401690h.t());
        }
    }

    public interface r {
        void onViewRecycled();
    }

    public class s extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401691a;

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public final void a() {
            this.f401691a.k(null);
            RecyclerView r100 = this.f401691a;
            r100.L0.f401711f = true;
            r100.P(true);
            if (this.f401691a.f401607d.g() == true) goto L6;
            this.f401691a.requestLayout();
            return;
        }

        public final void f() {
            if (RecyclerView.f401600y2 == false) goto L9;
            RecyclerView r100 = this.f401691a;
            if (r100.f401630t == false) goto L9;
            if (r100.f401629s == false) goto L9;
            ViewCompat.postOnAnimation(r100, r100.f401613h);
            return;
        L9:
            RecyclerView r101 = this.f401691a;
            r101.A = true;
            r101.requestLayout();
        }

        public s(RecyclerView r100) {
            this.f401691a = r100;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public final void c(int r100, int r101) {
            this.f401691a.k(null);
            com.obric.oui.orecyclerview.widget.a r102 = this.f401691a.f401607d;
            boolean r103 = true;
            boolean r104 = false;
            if (r101 >= 1) goto L5;
            r102.getClass();
        L10:
            if (r104 == false) goto L13;
            f();
            return;
        L13:
            return;
        L5:
            r102.f401773b.add(r102.h(1, r100, r101, null));
            r102.f401777f |= 1;
            if (r102.f401773b.size() == 1) goto L9;
            r103 = false;
        L9:
            r104 = r103;
            goto L10
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public final void d(int r100, int r101) {
            this.f401691a.k(null);
            com.obric.oui.orecyclerview.widget.a r102 = this.f401691a.f401607d;
            r102.getClass();
            if (r100 == r101) goto L8;
            r102.f401773b.add(r102.h(8, r100, r101, null));
            r102.f401777f |= 8;
            boolean r103 = true;
            if (r102.f401773b.size() != 1) goto L8;
        L9:
            if (r103 == false) goto L12;
            f();
            return;
        L12:
            return;
        L8:
            r103 = false;
            goto L9
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public final void e(int r100, int r101) {
            this.f401691a.k(null);
            com.obric.oui.orecyclerview.widget.a r102 = this.f401691a.f401607d;
            boolean r103 = true;
            boolean r104 = false;
            if (r101 >= 1) goto L5;
            r102.getClass();
        L10:
            if (r104 == false) goto L13;
            f();
            return;
        L13:
            return;
        L5:
            r102.f401773b.add(r102.h(2, r100, r101, null));
            r102.f401777f |= 2;
            if (r102.f401773b.size() == 1) goto L9;
            r103 = false;
        L9:
            r104 = r103;
            goto L10
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public final void b(int r100, int r101, Object r102) {
            this.f401691a.k(null);
            com.obric.oui.orecyclerview.widget.a r103 = this.f401691a.f401607d;
            boolean r104 = true;
            boolean r105 = false;
            if (r101 >= 1) goto L5;
            r103.getClass();
        L10:
            if (r105 == false) goto L13;
            f();
            return;
        L13:
            return;
        L5:
            r103.f401773b.add(r103.h(4, r100, r101, r102));
            r103.f401777f |= 4;
            if (r103.f401773b.size() == 1) goto L9;
            r104 = false;
        L9:
            r105 = r104;
            goto L10
        }
    }

    public static class t implements n {
        public t() {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.n
        public final void b() {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.n
        public final void onTouchEvent(MotionEvent r100) {
        }
    }

    public static abstract class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f401693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k f401694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f401695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401696e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f401697f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f401698g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f401699h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f401700a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f401701b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f401702c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f401703d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f401704e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f401705f;

            public a() {
                this.f401703d = -1;
                this.f401705f = false;
                this.f401700a = 0;
                this.f401701b = 0;
                this.f401702c = Integer.MIN_VALUE;
                this.f401704e = null;
            }

            public final void a(RecyclerView r100) {
                int r101 = this.f401703d;
                if (r101 < 0) goto L7;
                this.f401703d = -1;
                r100.H(r101);
                this.f401705f = false;
                return;
            L7:
                if (this.f401705f == false) goto L20;
                Interpolator r102 = this.f401704e;
                if (r102 != null) goto L11;
            L15:
                int r103 = this.f401702c;
                if (r103 < 1) goto L19;
                r100.f401618k0.c(this.f401700a, this.f401701b, r103, r102);
                this.f401705f = false;
                return;
            L19:
                throw new IllegalStateException("Scroll duration must be a positive number");
            L11:
                if (this.f401702c >= 1) goto L15;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }

            public void update(int r100, int r101, int r102, Interpolator r103) {
                this.f401700a = r100;
                this.f401701b = r101;
                this.f401702c = r102;
                this.f401704e = r103;
                this.f401705f = true;
            }
        }

        public interface b {
            PointF computeScrollVectorForPosition(int r100);
        }

        public abstract void b(View r100, a r101);

        public final void c() {
            if (this.f401696e == true) goto L5;
            return;
        L5:
            this.f401696e = false;
            com.obric.oui.orecyclerview.widget.u r100 = (com.obric.oui.orecyclerview.widget.u) this;
            r100.f401963p = 0;
            r100.f401962o = 0;
            r100.f401958k = null;
            this.f401693b.L0.f401706a = -1;
            this.f401697f = null;
            this.f401692a = -1;
            this.f401695d = false;
            k r101 = this.f401694c;
            if (r101.f401665e != this) goto L8;
            r101.f401665e = null;
        L8:
            this.f401694c = null;
            this.f401693b = null;
        }

        public u() {
            this.f401692a = -1;
            this.f401698g = new a();
        }

        public final void a(int r100, int r101) {
            RecyclerView r102 = this.f401693b;
            int r103 = -1;
            if (this.f401692a == (-1)) goto L5;
            if (r102 == null) goto L5;
        L6:
            PointF r104 = null;
            if (this.f401695d == true) goto L9;
        L22:
            boolean r105 = false;
            this.f401695d = false;
            View r106 = this.f401697f;
            if (r106 == null) goto L32;
            this.f401693b.getClass();
            y r107 = RecyclerView.E(r106);
            if (r107 == null) goto L28;
            r103 = r107.d();
        L28:
            if (r103 != this.f401692a) goto L30;
            View r108 = this.f401697f;
            v r109 = r102.L0;
            b(r108, this.f401698g);
            this.f401698g.a(r102);
            c();
            goto L32
        L30:
            this.f401697f = null;
        L32:
            if (this.f401696e == false) goto L66;
            v r110 = r102.L0;
            a r111 = this.f401698g;
            com.obric.oui.orecyclerview.widget.u r112 = (com.obric.oui.orecyclerview.widget.u) this;
            if (r112.f401693b.f401621m.u() != 0) goto L36;
            r112.c();
        L57:
            a r113 = this.f401698g;
            if (r113.f401703d < 0) goto L60;
            r105 = true;
        L60:
            r113.a(r102);
            if (r105 == true) goto L63;
            return;
        L63:
            if (this.f401696e == false) goto L68;
            this.f401695d = true;
            r102.f401618k0.b();
            return;
        L68:
            return;
        L36:
            int r114 = r112.f401962o;
            int r115 = r114 - r100;
            if ((r114 * r115) > 0) goto L39;
            r115 = 0;
        L39:
            r112.f401962o = r115;
            int r116 = r112.f401963p;
            int r117 = r116 - r101;
            if ((r116 * r117) > 0) goto L42;
            r117 = 0;
        L42:
            r112.f401963p = r117;
            if (r115 != 0) goto L57;
            if (r117 != 0) goto L57;
            int r118 = r112.f401692a;
            Object r119 = r112.f401694c;
            if ((r119 instanceof b) == false) goto L49;
            r104 = ((b) r119).computeScrollVectorForPosition(r118);
        L49:
            if (r104 == null) goto L56;
            float r120 = r104.x;
            if (r120 == 0.0f) goto L53;
        L55:
            float r121 = r104.y;
            float r122 = (float) Math.sqrt((r120 * r120) + (r121 * r121));
            float r123 = r104.x / r122;
            r104.x = r123;
            float r124 = r104.y / r122;
            r104.y = r124;
            r112.f401958k = r104;
            r112.f401962o = (int) (r123 * 10000.0f);
            r112.f401963p = (int) (r124 * 10000.0f);
            r111.update((int) (r112.f401962o * 1.2f), (int) (r112.f401963p * 1.2f), (int) (r112.f(10000) * 1.2f), r112.f401956i);
            goto L57
        L53:
            if (r104.y != 0.0f) goto L55;
        L56:
            r111.f401703d = r112.f401692a;
            r112.c();
            goto L57
        L66:
            return;
        L9:
            if (this.f401697f != null) goto L22;
            Object r125 = this.f401694c;
            if (r125 == null) goto L22;
            int r126 = this.f401692a;
            if ((r125 instanceof b) == false) goto L15;
            PointF r127 = ((b) r125).computeScrollVectorForPosition(r126);
        L16:
            if (r127 == null) goto L22;
            float r128 = r127.x;
            if (r128 == 0.0f) goto L20;
        L21:
            r102.V((int) Math.signum(r128), (int) Math.signum(r127.y), null);
            goto L22
        L20:
            if (r127.y == 0.0f) goto L22;
        L15:
            r127 = null;
        L5:
            c();
            goto L6
        }
    }

    public static class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f401711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f401712g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f401713h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f401714i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f401715j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f401716k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f401717l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f401718m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f401719n;

        public final int b() {
            if (this.f401712g == false) goto L6;
            return this.f401707b - this.f401708c;
        L6:
            return this.f401710e;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f401706a + ", mData=null, mItemCount=" + this.f401710e + ", mIsMeasuring=" + this.f401714i + ", mPreviousLayoutItemCount=" + this.f401707b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f401708c + ", mStructureChanged=" + this.f401711f + ", mInPreLayout=" + this.f401712g + ", mRunSimpleAnimations=" + this.f401715j + ", mRunPredictiveAnimations=" + this.f401716k + '}';
        }

        public v() {
            this.f401706a = -1;
            this.f401707b = 0;
            this.f401708c = 0;
            this.f401709d = 1;
            this.f401710e = 0;
            this.f401711f = false;
            this.f401712g = false;
            this.f401713h = false;
            this.f401714i = false;
            this.f401715j = false;
            this.f401716k = false;
        }

        public final void a(int r100) {
            if ((this.f401709d & r100) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r100) + " but it is " + Integer.toBinaryString(this.f401709d));
        }
    }

    public static abstract class w {
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScrollerAdapter f401722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f401723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f401724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f401725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f401726g;

        public final void a() {
            RecyclerView r100 = this.f401726g;
            if (r100.f401621m != null) goto L6;
            d();
            return;
        L6:
            this.f401725f = false;
            this.f401724e = true;
            r100.n();
            OverScrollerAdapter r101 = this.f401722c;
            if (r101.a() == false) goto L136;
            int r102 = r101.b();
            int r103 = r101.c();
            int r104 = r102 - this.f401720a;
            int r105 = r103 - this.f401721b;
            this.f401720a = r102;
            this.f401721b = r103;
            RecyclerView r106 = this.f401726g;
            com.obric.oui.orecyclerview.base.a r107 = r106.G;
            if (r104 == 0) goto L17;
            if (r107 == null) goto L17;
            if (r107.f401534d == 0.0f) goto L17;
            int r108 = (int) r107.c(r104, true, r106.P1);
            if (r104 <= 0) goto L16;
            r104 = r104 - r108;
            goto L17
        L16:
            r104 = r104 + r108;
        L17:
            RecyclerView r109 = this.f401726g;
            com.obric.oui.orecyclerview.base.a r110 = r109.H;
            if (r105 == 0) goto L26;
            if (r110 == null) goto L26;
            if (r110.f401534d == 0.0f) goto L26;
            int r111 = (int) r110.c(r105, true, r109.P1);
            if (r105 <= 0) goto L25;
            r105 = r105 - r111;
            goto L26
        L25:
            r105 = r105 + r111;
        L26:
            RecyclerView r112 = this.f401726g;
            int[] r113 = r112.H1;
            r113[0] = 0;
            r113[1] = 0;
            if (r112.dispatchNestedPreScroll(r104, r105, r113, null, 1) == false) goto L29;
            int[] r114 = this.f401726g.H1;
            r104 = r104 - r114[0];
            r105 = r105 - r114[1];
        L29:
            RecyclerView r115 = this.f401726g;
            if (r115.f401620l == null) goto L44;
            int[] r116 = r115.H1;
            r116[0] = 0;
            r116[1] = 0;
            r115.V(r104, r105, r116);
            RecyclerView r117 = this.f401726g;
            int[] r118 = r117.H1;
            int r119 = r118[0];
            int r120 = r118[1];
            r104 = r104 - r119;
            r105 = r105 - r120;
            u r121 = r117.f401621m.f401665e;
            if (r121 == null) goto L46;
            if (r121.f401695d == true) goto L46;
            if (r121.f401696e == false) goto L46;
            int r122 = r117.L0.b();
            if (r122 != 0) goto L41;
            r121.c();
            goto L46
        L41:
            if (r121.f401692a < r122) goto L43;
            r121.f401692a = r122 - 1;
            r121.a(r119, r120);
            goto L46
        L43:
            r121.a(r119, r120);
        L46:
            if (this.f401726g.f401624p.isEmpty() == true) goto L48;
            this.f401726g.invalidate();
        L48:
            RecyclerView r123 = this.f401726g;
            int[] r124 = r123.H1;
            r124[0] = 0;
            r124[1] = 0;
            r123.dispatchNestedScroll(r119, r120, r104, r105, null, 1, r124);
            RecyclerView r125 = this.f401726g;
            int[] r126 = r125.H1;
            int r127 = r104 - r126[0];
            int r128 = r105 - r126[1];
            if (r119 != 0) goto L51;
            if (r120 != 0) goto L51;
        L53:
            if (RecyclerView.d(this.f401726g) == true) goto L55;
            this.f401726g.invalidate();
        L55:
            int r129 = r101.b();
            if (r101.f401528f == false) goto L58;
            int r130 = r101.d().getFinalX();
        L59:
            if (r129 != r130) goto L61;
            boolean r131 = true;
        L62:
            int r132 = r101.c();
            if (r101.f401528f == false) goto L65;
            int r133 = r101.d().getFinalY();
        L66:
            if (r132 != r133) goto L68;
            boolean r134 = true;
        L70:
            if (r101.e() == true) goto L77;
            if (r131 == true) goto L73;
            if (r127 != 0) goto L73;
        L76:
            boolean r135 = false;
        L78:
            RecyclerView r136 = this.f401726g;
            u r137 = r136.f401621m.f401665e;
            if (r137 != null) goto L81;
        L83:
            boolean r138 = false;
        L84:
            if (r138 == true) goto L133;
            if (r135 == false) goto L133;
            if (r136.getOverScrollMode() == 2) goto L128;
            if (r101.f401528f == false) goto L91;
            float r139 = r101.d().getCurrVelocity();
        L92:
            int r140 = (int) r139;
            if (r127 >= 0) goto L95;
            int r141 = r140;
        L98:
            if (r128 < 0) goto L103;
            if (r128 <= 0) goto L102;
            r140 = -r140;
            goto L103
        L102:
            r140 = 0;
        L103:
            RecyclerView r142 = this.f401726g;
            r142.getClass();
            if (r141 != 0) goto L106;
        L114:
            if (r140 != 0) goto L116;
        L124:
            if (r141 != 0) goto L126;
            if (r140 == 0) goto L128;
        L126:
            ViewCompat.postInvalidateOnAnimation(r142);
            goto L128
        L116:
            if (r142.H != null) goto L119;
            com.obric.oui.orecyclerview.base.a r143 = new com.obric.oui.orecyclerview.base.a(r142.getContext());
            r142.H = r143;
            r143.f401531a = r142.getHeight() / r143.f401539i.density;
        L119:
            com.obric.oui.orecyclerview.base.a r144 = r142.H;
            if (r144.f401538h == false) goto L122;
        L123:
            r144.b(r140);
            goto L124
        L122:
            if (r142.M1 == false) goto L124;
        L106:
            if (r142.G != null) goto L109;
            com.obric.oui.orecyclerview.base.a r145 = new com.obric.oui.orecyclerview.base.a(r142.getContext());
            r142.G = r145;
            r145.f401531a = r142.getWidth() / r145.f401539i.density;
        L109:
            com.obric.oui.orecyclerview.base.a r146 = r142.G;
            if (r146.f401538h == false) goto L112;
        L113:
            r146.b(r141);
            goto L114
        L112:
            if (r142.M1 == false) goto L114;
        L95:
            if (r127 <= 0) goto L97;
            r141 = -r140;
            goto L98
        L97:
            r141 = 0;
            goto L98
        L91:
            r139 = ((float) Math.hypot(((com.obric.oui.orecyclerview.base.c) r101.f401526d.getValue()).c(r101.f401530h).f401544b, ((com.obric.oui.orecyclerview.base.c) r101.f401527e.getValue()).c(r101.f401530h).f401544b)) * 1000;
        L128:
            if (RecyclerView.E2 == false) goto L136;
            com.obric.oui.orecyclerview.widget.s.b r147 = this.f401726g.H0;
            int[] r148 = r147.f401949c;
            if (r148 == null) goto L132;
            Arrays.fill(r148, -1);
        L132:
            r147.f401950d = 0;
        L133:
            b();
            RecyclerView r149 = this.f401726g;
            com.obric.oui.orecyclerview.widget.s r150 = r149.f401625p0;
            if (r150 == null) goto L136;
            r150.b(r149, r119, r120);
            goto L136
        L81:
            if (r137.f401695d == false) goto L83;
            r138 = true;
        L73:
            if (r134 == true) goto L77;
            if (r128 == 0) goto L76;
        L77:
            r135 = true;
            goto L78
        L68:
            r134 = false;
            goto L70
        L65:
            r133 = (int) ((com.obric.oui.orecyclerview.base.c) r101.f401527e.getValue()).a();
            goto L66
        L61:
            r131 = false;
            goto L62
        L58:
            r130 = (int) ((com.obric.oui.orecyclerview.base.c) r101.f401526d.getValue()).a();
        L51:
            r125.s(r119, r120);
            goto L53
        L44:
            r120 = 0;
            r119 = 0;
        L136:
            u r151 = this.f401726g.f401621m.f401665e;
            if (r151 != null) goto L139;
        L141:
            this.f401724e = false;
            if (this.f401725f == false) goto L144;
            this.f401726g.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.f401726g, this);
            return;
        L144:
            this.f401726g.setScrollState(0);
            this.f401726g.stopNestedScroll(1);
            return;
        L139:
            if (r151.f401695d == false) goto L141;
            r151.a(0, 0);
            goto L141
        }

        public final void b() {
            if (this.f401724e == false) goto L5;
            this.f401725f = true;
            return;
        L5:
            this.f401726g.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.f401726g, this);
        }

        public final void d() {
            this.f401726g.removeCallbacks(this);
            OverScrollerAdapter r100 = this.f401722c;
            if (r100.f401528f == false) goto L5;
            r100.d().abortAnimation();
            return;
        L5:
            r100.f401529g = -1;
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

        public x(RecyclerView r100) {
            this.f401726g = r100;
            c r101 = RecyclerView.G2;
            this.f401723d = r101;
            this.f401724e = false;
            this.f401725f = false;
            this.f401722c = new OverScrollerAdapter(r100.getContext(), r101);
        }

        public final void c(int r110, int r111, int r112, Interpolator r113) {
            if (r112 != Integer.MIN_VALUE) goto L16;
            int r114 = Math.abs(r110);
            int r100 = Math.abs(r111);
            if (r114 <= r100) goto L7;
            boolean r101 = true;
        L8:
            RecyclerView r102 = this.f401726g;
            if (r101 == false) goto L11;
            int r103 = r102.getWidth();
        L12:
            if (r101 == true) goto L15;
            r114 = r100;
        L15:
            r112 = Math.min((int) (((r114 / r103) + 1.0f) * 300.0f), 2000);
            goto L16
        L11:
            r103 = r102.getHeight();
            goto L12
        L7:
            r101 = false;
        L16:
            int r104 = r112;
            if (r113 != null) goto L20;
            r113 = RecyclerView.G2;
        L20:
            if (this.f401723d == r113) goto L22;
            this.f401723d = r113;
            this.f401722c = new OverScrollerAdapter(this.f401726g.getContext(), r113);
        L22:
            this.f401721b = 0;
            this.f401720a = 0;
            this.f401726g.setScrollState(2);
            OverScrollerAdapter r115 = this.f401722c;
            r115.f401528f = true;
            r115.d().startScroll(0, 0, r110, r111, r104);
            if (Build.VERSION.SDK_INT >= 23) goto L25;
            this.f401722c.a();
        L25:
            b();
        }
    }

    public static abstract class y {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final List<Object> f401727t = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f401728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<RecyclerView> f401729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f401732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f401733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f401734g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public y f401735h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public y f401736i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f401737j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<Object> f401738k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<Object> f401739l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f401740m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public q f401741n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f401742o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f401743p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f401744q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f401745r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Adapter<? extends y> f401746s;

        public final int c() {
            if (this.f401746s == null) goto L19;
            RecyclerView r100 = this.f401745r;
            if (r100 == null) goto L20;
            Adapter<? extends y> r101 = r100.getAdapter();
            if (r101 == null) goto L21;
            int r102 = this.f401745r.B(this);
            if (r102 != (-1)) goto L15;
            return -1;
        L15:
            if (this.f401746s == r101) goto L17;
            return -1;
        L17:
            return r102;
        L21:
            return -1;
        L20:
            return -1;
        L19:
            return -1;
        }

        public final int d() {
            int r100 = this.f401734g;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            return this.f401730c;
        }

        public final List<Object> e() {
            if ((this.f401737j & 1024) != 0) goto L14;
            List<Object> r100 = this.f401738k;
            if (r100 == null) goto L12;
            if (((ArrayList) r100).size() == 0) goto L12;
            return this.f401739l;
        L12:
            return f401727t;
        L14:
            return f401727t;
        }

        public final boolean f() {
            if ((this.f401737j & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean g() {
            if ((this.f401737j & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean h() {
            if ((this.f401737j & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.f401728a) == true) goto L7;
            return true;
        }

        public final boolean i() {
            if ((this.f401737j & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean j() {
            if (this.f401741n == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean k() {
            if ((this.f401737j & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void m() {
            if (RecyclerView.f401596h2 == true) goto L5;
        L9:
            this.f401737j = 0;
            this.f401730c = -1;
            this.f401731d = -1;
            this.f401732e = -1;
            this.f401734g = -1;
            this.f401740m = 0;
            this.f401735h = null;
            this.f401736i = null;
            List<Object> r100 = this.f401738k;
            if (r100 == null) goto L12;
            ((ArrayList) r100).clear();
        L12:
            this.f401737j &= -1025;
            this.f401743p = 0;
            this.f401744q = -1;
            RecyclerView.l(this);
            return;
        L5:
            if (k() == false) goto L9;
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public final boolean o() {
            if ((this.f401737j & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        static {
            f401727t = Collections.emptyList();
        }

        public final String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r100 = "ViewHolder";
        L6:
            StringBuilder r101 = new StringBuilder(r100 + "{" + Integer.toHexString(hashCode()) + " position=" + this.f401730c + " id=" + this.f401732e + ", oldPos=" + this.f401731d + ", pLpos:" + this.f401734g);
            if (j() == false) goto L14;
            r101.append(" scrap ");
            if (this.f401742o == false) goto L11;
            String r102 = "[changeScrap]";
        L12:
            r101.append(r102);
            goto L14
        L11:
            r102 = "[attachedScrap]";
        L14:
            if (g() == false) goto L17;
            r101.append(" invalid");
        L17:
            if (f() == true) goto L19;
            r101.append(" unbound");
        L19:
            boolean r103 = true;
            if ((this.f401737j & 2) == 0) goto L22;
            boolean r104 = true;
        L23:
            if (r104 == false) goto L26;
            r101.append(" update");
        L26:
            if (i() == false) goto L29;
            r101.append(" removed");
        L29:
            if (o() == false) goto L32;
            r101.append(" ignored");
        L32:
            if (k() == false) goto L35;
            r101.append(" tmpDetached");
        L35:
            if (h() == true) goto L38;
            r101.append(" not recyclable(" + this.f401740m + ")");
        L38:
            if ((this.f401737j & 512) == 0) goto L40;
        L43:
            if (r103 == false) goto L46;
            r101.append(" undefined adapter position");
        L46:
            if (this.f401728a.getParent() != null) goto L48;
            r101.append(" no parent");
        L48:
            r101.append(com.alipay.sdk.m.u.i.f25855d);
            return r101.toString();
        L40:
            if (g() == true) goto L43;
            r103 = false;
            goto L43
        L22:
            r104 = false;
            goto L23
        L5:
            r100 = getClass().getSimpleName();
            goto L6
        }

        public y(View r100) {
            this.f401730c = -1;
            this.f401731d = -1;
            this.f401732e = -1;
            this.f401733f = -1;
            this.f401734g = -1;
            this.f401735h = null;
            this.f401736i = null;
            this.f401738k = null;
            this.f401739l = null;
            this.f401740m = 0;
            this.f401741n = null;
            this.f401742o = false;
            this.f401743p = 0;
            this.f401744q = -1;
            if (r100 == null) goto L7;
            this.f401728a = r100;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        public final void a(Object r100) {
            if (r100 != null) goto L6;
            b(1024);
            return;
        L6:
            if ((1024 & this.f401737j) == 0) goto L8;
            return;
        L8:
            if (this.f401738k != null) goto L10;
            ArrayList r101 = new ArrayList();
            this.f401738k = r101;
            this.f401739l = Collections.unmodifiableList(r101);
        L10:
            ((ArrayList) this.f401738k).add(r100);
        }

        public final void b(int r100) {
            this.f401737j = r100 | this.f401737j;
        }

        public final void n(boolean r100) {
            int r101 = this.f401740m;
            if (r100 == false) goto L5;
            int r102 = r101 - 1;
        L6:
            this.f401740m = r102;
            if (r102 >= 0) goto L13;
            this.f401740m = 0;
            if (RecyclerView.f401596h2 == true) goto L12;
            toString();
        L20:
            if (RecyclerView.f401597p2 == false) goto L23;
            toString();
            return;
        L23:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r100 == true) goto L16;
            if (r102 != 1) goto L16;
            this.f401737j |= 16;
        L16:
            if (r100 == false) goto L20;
            if (r102 != 0) goto L20;
            this.f401737j &= -17;
            goto L20
        L5:
            r102 = r101 + 1;
            goto L6
        }

        public final void l(int r100, boolean r101) {
            if (this.f401731d != (-1)) goto L6;
            this.f401731d = this.f401730c;
        L6:
            if (this.f401734g != (-1)) goto L8;
            this.f401734g = this.f401730c;
        L8:
            if (r101 == false) goto L10;
            this.f401734g += r100;
        L10:
            this.f401730c += r100;
            if (this.f401728a.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.f401728a.getLayoutParams()).f401653c = true;
            return;
        }
    }

    static {
        f401598v2 = new int[]{R.attr.nestedScrollingEnabled};
        Math.log(0.78d);
        Math.log(0.9d);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r100 = true;
    L6:
        f401599x2 = r100;
        f401600y2 = true;
        E2 = true;
        Class<?> r101 = Integer.TYPE;
        F2 = new Class[]{Context.class, AttributeSet.class, r101, r101};
        G2 = new c();
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void a0() {
        setScrollState(0);
        this.f401618k0.d();
        k r100 = this.f401621m;
        if (r100 == null) goto L8;
        u r101 = r100.f401665e;
        if (r101 == null) goto L9;
        r101.c();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return null;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
    }

    public void setEdgeEffectFactory(EdgeEffectFactory r100) {
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f401636x1 != null) goto L6;
        this.f401636x1 = new NestedScrollingChildHelper(this);
    L6:
        return this.f401636x1;
    }

    public final boolean G() {
        if (this.E <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void I() {
        int r100 = this.f401608e.h();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L6;
        ((LayoutParams) this.f401608e.g(r102).getLayoutParams()).f401653c = true;
        r102 = r102 + 1;
        goto L4
    L6:
        q r103 = this.f401603b;
        int r104 = r103.f401685c.size();
    L7:
        if (r101 >= r104) goto L12;
        LayoutParams r105 = (LayoutParams) ((y) ListProtector.get(r103.f401685c, r101)).f401728a.getLayoutParams();
        if (r105 == null) goto L11;
        r105.f401653c = true;
    L11:
        r101 = r101 + 1;
        goto L7
    }

    public final void K() {
        this.E++;
    }

    public final void N() {
        if (this.f401619k1 == false) goto L5;
        return;
    L5:
        if (this.f401629s == false) goto L9;
        ViewCompat.postOnAnimation(this, this.Q1);
        this.f401619k1 = true;
        return;
    }

    public final void O() {
        boolean r100 = false;
        if (this.C == false) goto L8;
        com.obric.oui.orecyclerview.widget.a r101 = this.f401607d;
        r101.k(r101.f401773b);
        r101.k(r101.f401774c);
        r101.f401777f = 0;
        if (this.D == false) goto L8;
        this.f401621m.T();
    L8:
        if (this.I != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        this.f401607d.j();
    L17:
        if (this.f401604b1 == false) goto L19;
    L22:
        boolean r103 = true;
    L23:
        v r104 = this.L0;
        if (this.f401631u == true) goto L26;
    L34:
        boolean r105 = false;
    L35:
        r104.f401715j = r105;
        v r106 = this.L0;
        if (r106.f401715j == false) goto L48;
        if (r103 == false) goto L48;
        if (this.C == true) goto L48;
        if (this.I != null) goto L43;
    L45:
        boolean r107 = false;
    L46:
        if (r107 == false) goto L48;
        r100 = true;
        goto L48
    L43:
        if (this.f401621m.t0() == false) goto L45;
        r107 = true;
    L48:
        r106.f401716k = r100;
        return;
    L26:
        if (this.I == null) goto L34;
        boolean r108 = this.C;
        if (r108 == true) goto L31;
        if (r103 == true) goto L31;
        this.f401621m.getClass();
    L31:
        if (r108 == false) goto L33;
        this.f401620l.getClass();
        goto L34
    L33:
        r105 = true;
        goto L35
    L19:
        if (this.f401611g1 == true) goto L22;
        r103 = false;
        goto L23
    L15:
        this.f401607d.c();
        goto L17
    L10:
        if (this.f401621m.t0() == false) goto L12;
        r102 = true;
        goto L13
    }

    public final void R() {
        ItemAnimator r100 = this.I;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        k r101 = this.f401621m;
        if (r101 == null) goto L8;
        r101.b0(this.f401603b);
        this.f401621m.c0(this.f401603b);
    L8:
        q r102 = this.f401603b;
        r102.f401683a.clear();
        r102.f();
    }

    public final void T() {
        com.obric.oui.orecyclerview.base.f r100 = this.L;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        boolean r101 = false;
        stopNestedScroll(0);
        com.obric.oui.orecyclerview.base.a r102 = this.G;
        if (r102 == null) goto L8;
        r102.d();
        r101 = this.G.f401538h;
    L8:
        com.obric.oui.orecyclerview.base.a r103 = this.H;
        if (r103 == null) goto L11;
        r103.d();
        r101 = r101 | this.H.f401538h;
    L11:
        if (r101 == false) goto L14;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final void Y() {
        int r100 = this.f401632v + 1;
        this.f401632v = r100;
        if (r100 == 1) goto L5;
        return;
    L5:
        if (this.f401635x == true) goto L9;
        this.f401634w = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.c() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.i(this.L0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.c() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.j(this.L0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.c() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.k(this.L0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.d() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.l(this.L0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.d() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.m(this.L0);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.d() == true) goto L8;
        return 0;
    L8:
        return this.f401621m.n(this.L0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        k r100 = this.f401621m;
        if (r100 == null) goto L7;
        return r100.q();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + t());
    }

    @Override // android.view.View
    public int getBaseline() {
        k r100 = this.f401621m;
        if (r100 == null) goto L7;
        r100.getClass();
        return -1;
    L7:
        return super.getBaseline();
    }

    public float getBounceTranslation() {
        com.obric.oui.orecyclerview.base.a r100 = this.H;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        return r100.f401534d;
    }

    public int getItemDecorationCount() {
        return this.f401624p.size();
    }

    public long getNanoTime() {
        if (E2 == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    public p getRecycledViewPool() {
        return this.f401603b.c();
    }

    public final void m() {
        int r100 = this.f401608e.h();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L9;
        y r103 = E(this.f401608e.g(r102));
        if (r103.o() == true) goto L8;
        r103.f401731d = -1;
        r103.f401734g = -1;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        q r104 = this.f401603b;
        int r105 = r104.f401685c.size();
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L12;
        y r107 = (y) ListProtector.get(r104.f401685c, r106);
        r107.f401731d = -1;
        r107.f401734g = -1;
        r106 = r106 + 1;
        goto L10
    L12:
        int r108 = r104.f401683a.size();
        int r109 = 0;
    L13:
        if (r109 >= r108) goto L15;
        y r110 = (y) ListProtector.get(r104.f401683a, r109);
        r110.f401731d = -1;
        r110.f401734g = -1;
        r109 = r109 + 1;
        goto L13
    L15:
        ArrayList<y> r111 = r104.f401684b;
        if (r111 == null) goto L20;
        int r112 = r111.size();
    L18:
        if (r101 >= r112) goto L27;
        y r113 = (y) ListProtector.get(r104.f401684b, r101);
        r113.f401731d = -1;
        r113.f401734g = -1;
        r101 = r101 + 1;
        goto L18
    L27:
        return;
    }

    public final void n() {
        if (this.f401631u == true) goto L5;
    L44:
        TraceCompat.beginSection("RV FullInvalidate");
        p();
        TraceCompat.endSection();
        return;
    L5:
        if (this.C == true) goto L44;
        if (this.f401607d.g() == true) goto L10;
        return;
    L10:
        com.obric.oui.orecyclerview.widget.a r100 = this.f401607d;
        int r101 = r100.f401777f;
        boolean r102 = false;
        if ((4 & r101) == 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L41;
        if ((r101 & 11) == 0) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L41;
        TraceCompat.beginSection("RV PartialInvalidate");
        Y();
        K();
        this.f401607d.j();
        if (this.f401634w == true) goto L39;
        int r105 = this.f401608e.e();
        int r106 = 0;
    L23:
        if (r106 >= r105) goto L36;
        y r107 = E(this.f401608e.d(r106));
        if (r107 == null) goto L35;
        if (r107.o() == true) goto L35;
        if ((r107.f401737j & 2) == 0) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == false) goto L35;
        r102 = true;
        goto L36
    L32:
        r108 = false;
    L35:
        r106 = r106 + 1;
    L36:
        if (r102 == false) goto L38;
        p();
        goto L39
    L38:
        this.f401607d.b();
    L39:
        Z(true);
        L(true);
        TraceCompat.endSection();
        return;
    L18:
        r104 = false;
    L41:
        if (r100.g() == false) goto L52;
        TraceCompat.beginSection("RV FullInvalidate");
        p();
        TraceCompat.endSection();
        return;
    L52:
        return;
    L13:
        r103 = false;
        goto L14
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        SavedState r101 = this.f401606c;
        if (r101 == null) goto L5;
        r100.f401655a = r101.f401655a;
    L9:
        return r100;
    L5:
        k r102 = this.f401621m;
        if (r102 == null) goto L8;
        r100.f401655a = r102.a0();
        goto L9
    L8:
        r100.f401655a = null;
        goto L9
    }

    public final void p() {
        if (this.f401620l != null) goto L6;
        return;
    L6:
        if (this.f401621m != null) goto L8;
        return;
    L8:
        int r100 = 0;
        this.L0.f401714i = false;
        boolean r101 = true;
        if (this.S1 == true) goto L11;
    L15:
        boolean r102 = false;
    L16:
        this.T1 = 0;
        this.V1 = 0;
        this.S1 = false;
        if (this.L0.f401709d != 1) goto L19;
        q();
        this.f401621m.k0(this);
        r();
    L34:
        this.L0.a(4);
        Y();
        K();
        v r103 = this.L0;
        r103.f401709d = 1;
        View r104 = null;
        if (r103.f401715j == false) goto L122;
        int r105 = this.f401608e.e() - 1;
    L37:
        if (r105 < 0) goto L85;
        y r106 = E(this.f401608e.d(r105));
        if (r106.o() == true) goto L84;
        this.f401620l.getClass();
        long r107 = r106.f401730c;
        this.I.getClass();
        ItemAnimator.c r110 = new ItemAnimator.c();
        View r111 = r106.f401728a;
        r110.f401649a = r111.getLeft();
        r110.f401650b = r111.getTop();
        r111.getRight();
        r111.getBottom();
        y r112 = this.f401609f.f401836b.get(r107);
        if (r112 != null) goto L44;
    L83:
        this.f401609f.a(r106, r110);
        goto L84
    L44:
        if (r112.o() == true) goto L83;
        j0.a r113 = this.f401609f.f401835a.get(r112);
        if (r113 != null) goto L48;
    L50:
        boolean r114 = false;
    L51:
        j0.a r115 = this.f401609f.f401835a.get(r106);
        if (r115 != null) goto L54;
    L56:
        boolean r116 = false;
    L57:
        if (r114 == false) goto L60;
        if (r112 != r106) goto L60;
        this.f401609f.a(r106, r110);
    L60:
        ItemAnimator.c r117 = this.f401609f.b(r112, 4);
        this.f401609f.a(r106, r110);
        ItemAnimator.c r118 = this.f401609f.b(r106, 8);
        if (r117 != null) goto L73;
        int r119 = this.f401608e.e();
        int r120 = 0;
    L63:
        if (r120 >= r119) goto L72;
        y r121 = E(this.f401608e.d(r120));
        if (r121 == r106) goto L69;
        this.f401620l.getClass();
        if (r121.f401730c != r107) goto L69;
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r121 + " \n View Holder 2:" + r106 + t());
    L69:
        r120 = r120 + 1;
        goto L63
    L72:
        Objects.toString(r112);
        Objects.toString(r106);
        t();
        goto L84
    L73:
        r112.n(false);
        if (r114 == false) goto L76;
        h(r112);
    L76:
        if (r112 == r106) goto L81;
        if (r116 == false) goto L79;
        h(r106);
    L79:
        r112.f401735h = r106;
        h(r112);
        this.f401603b.l(r112);
        r106.n(false);
        r106.f401736i = r112;
    L81:
        if (this.I.a(r112, r106, r117, r118) == false) goto L84;
        N();
        goto L84
    L54:
        if ((r115.f401838a & 1) == 0) goto L56;
        r116 = true;
        goto L57
    L48:
        if ((r113.f401838a & 1) == 0) goto L50;
        r114 = true;
    L84:
        r105 = r105 - 1;
        goto L37
    L85:
        j0 r108 = this.f401609f;
        d r109 = this.f401612g2;
        int r122 = r108.f401835a.size() - 1;
    L86:
        if (r122 < 0) goto L122;
        y r123 = r108.f401835a.keyAt(r122);
        j0.a r124 = r108.f401835a.removeAt(r122);
        int r125 = r124.f401838a;
        if ((r125 & 3) != 3) goto L91;
        r109.c(r123);
    L121:
        r124.f401838a = 0;
        r124.f401839b = null;
        r124.f401840c = null;
        j0.a.f401837d.release(r124);
        r122 = r122 - 1;
        goto L86
    L91:
        if ((r125 & 1) == 0) goto L97;
        ItemAnimator.c r126 = r124.f401839b;
        if (r126 != null) goto L95;
        r109.c(r123);
        goto L121
    L95:
        r109.b(r123, r126, r124.f401840c);
        goto L121
    L97:
        if ((r125 & 14) != 14) goto L100;
        r109.a(r123, r124.f401839b, r124.f401840c);
        goto L121
    L100:
        if ((r125 & 12) != 12) goto L116;
        ItemAnimator.c r127 = r124.f401839b;
        ItemAnimator.c r128 = r124.f401840c;
        r109.getClass();
        r123.n(false);
        RecyclerView r129 = r109.f401658a;
        if (r129.C == true) goto L104;
        g0 r130 = (g0) r129.I;
        r130.getClass();
        int r131 = r127.f401649a;
        int r132 = r128.f401649a;
        if (r131 == r132) goto L109;
    L112:
        boolean r133 = r130.h(r123, r131, r127.f401650b, r132, r128.f401650b);
    L113:
        if (r133 == false) goto L121;
        r109.f401658a.N();
        goto L121
    L109:
        if (r127.f401650b != r128.f401650b) goto L112;
        r130.c(r123);
        r133 = false;
        goto L113
    L104:
        if (r129.I.a(r123, r123, r127, r128) == false) goto L121;
        r109.f401658a.N();
        goto L121
    L116:
        if ((r125 & 4) == 0) goto L119;
        r109.b(r123, r124.f401839b, null);
        goto L121
    L119:
        if ((r125 & 8) == 0) goto L121;
        r109.a(r123, r124.f401839b, r124.f401840c);
    L122:
        this.f401621m.c0(this.f401603b);
        v r134 = this.L0;
        r134.f401707b = r134.f401710e;
        this.C = false;
        this.D = false;
        r134.f401715j = false;
        r134.f401716k = false;
        this.f401621m.getClass();
        ArrayList<y> r135 = this.f401603b.f401684b;
        if (r135 == null) goto L125;
        r135.clear();
    L125:
        k r136 = this.f401621m;
        if (r136.f401669i == false) goto L128;
        r136.f401668h = 0;
        r136.f401669i = false;
        this.f401603b.m();
    L128:
        this.f401621m.Y(this.L0);
        L(true);
        Z(false);
        j0 r137 = this.f401609f;
        r137.f401835a.clear();
        r137.f401836b.clear();
        int[] r138 = this.f401633v1;
        int r139 = r138[0];
        int r140 = r138[1];
        x(r138);
        int[] r141 = this.f401633v1;
        if (r141[0] == r139) goto L131;
    L134:
        if (r101 == false) goto L137;
        s(0, 0);
    L137:
        if (this.W == true) goto L139;
    L190:
        v r142 = this.L0;
        r142.f401718m = -1;
        r142.f401717l = -1;
        r142.f401719n = -1;
        return;
    L139:
        if (this.f401620l == null) goto L190;
        if (hasFocus() == false) goto L190;
        if (getDescendantFocusability() == 393216) goto L190;
        if (getDescendantFocusability() != 131072) goto L150;
        if (isFocused() == true) goto L190;
    L150:
        if (isFocused() == true) goto L155;
        if (this.f401608e.k(getFocusedChild()) == false) goto L190;
    L155:
        if (this.L0.f401718m == (-1)) goto L158;
        this.f401620l.getClass();
    L158:
        if (this.f401608e.e() <= 0) goto L181;
        v r143 = this.L0;
        int r144 = r143.f401717l;
        if (r144 == (-1)) goto L162;
        r100 = r144;
    L162:
        int r145 = r143.b();
        int r146 = r100;
    L163:
        if (r146 >= r145) goto L172;
        y r147 = z(r146);
        if (r147 == null) goto L172;
        if (r147.f401728a.hasFocusable() == true) goto L169;
        r146 = r146 + 1;
        goto L163
    L169:
        View r148 = r147.f401728a;
    L170:
        r104 = r148;
    L172:
        int r149 = Math.min(r145, r100) - 1;
    L173:
        if (r149 < 0) goto L181;
        y r150 = z(r149);
        if (r150 == null) goto L181;
        if (r150.f401728a.hasFocusable() == true) goto L179;
        r149 = r149 - 1;
        goto L173
    L179:
        r148 = r150.f401728a;
    L181:
        if (r104 == null) goto L190;
        int r151 = this.L0.f401719n;
        if (r151 == (-1)) goto L189;
        View r152 = r104.findViewById(r151);
        if (r152 == null) goto L189;
        if (r152.isFocusable() == false) goto L189;
        r104 = r152;
    L189:
        r104.requestFocus();
        goto L190
    L131:
        if (r141[1] != r140) goto L134;
        r101 = false;
        goto L134
    L19:
        com.obric.oui.orecyclerview.widget.a r153 = this.f401607d;
        if (r153.f401774c.isEmpty() == false) goto L22;
    L24:
        boolean r154 = false;
    L25:
        if (r154 == true) goto L33;
        if (r102 == true) goto L33;
        if (this.f401621m.f401672l != getWidth()) goto L33;
        if (this.f401621m.f401673m != getHeight()) goto L33;
        this.f401621m.k0(this);
    L33:
        this.f401621m.k0(this);
        r();
        goto L34
    L22:
        if (r153.f401773b.isEmpty() == true) goto L24;
        r154 = true;
        goto L25
    L11:
        if (this.T1 == getWidth()) goto L13;
    L14:
        r102 = true;
        goto L16
    L13:
        if (this.V1 == getHeight()) goto L15;
        goto L14
    }

    public final void q() {
        this.L0.a(1);
        u(this.L0);
        this.L0.f401714i = false;
        Y();
        j0 r100 = this.f401609f;
        r100.f401835a.clear();
        r100.f401836b.clear();
        K();
        O();
        y r101 = null;
        if (this.W == true) goto L5;
    L9:
        View r102 = null;
    L10:
        if (r102 == null) goto L17;
        View r103 = v(r102);
        if (r103 == null) goto L17;
        r101 = D(r103);
    L17:
        if (r101 != null) goto L19;
        v r104 = this.L0;
        r104.f401718m = -1;
        r104.f401717l = -1;
        r104.f401719n = -1;
    L40:
        v r105 = this.L0;
        if (r105.f401715j == true) goto L43;
    L45:
        boolean r106 = false;
    L46:
        r105.f401713h = r106;
        this.f401611g1 = false;
        this.f401604b1 = false;
        r105.f401712g = r105.f401716k;
        r105.f401710e = this.f401620l.a();
        x(this.f401633v1);
        if (this.L0.f401715j == false) goto L74;
        int r107 = this.f401608e.e();
        int r108 = 0;
    L49:
        if (r108 >= r107) goto L74;
        y r109 = E(this.f401608e.d(r108));
        if (r109.o() == true) goto L72;
        if (r109.g() == false) goto L55;
        this.f401620l.getClass();
        goto L72
    L55:
        ItemAnimator r110 = this.I;
        ItemAnimator.b(r109);
        r109.e();
        r110.getClass();
        ItemAnimator.c r111 = new ItemAnimator.c();
        View r112 = r109.f401728a;
        r111.f401649a = r112.getLeft();
        r111.f401650b = r112.getTop();
        r112.getRight();
        r112.getBottom();
        j0 r113 = this.f401609f;
        j0.a r114 = r113.f401835a.get(r109);
        if (r114 != null) goto L58;
        r114 = j0.a.a();
        r113.f401835a.put(r109, r114);
    L58:
        r114.f401839b = r111;
        r114.f401838a |= 4;
        if (this.L0.f401713h == false) goto L72;
        if ((r109.f401737j & 2) == 0) goto L63;
        boolean r115 = true;
    L64:
        if (r115 == false) goto L72;
        if (r109.i() == true) goto L72;
        if (r109.o() == true) goto L72;
        if (r109.g() == true) goto L72;
        this.f401620l.getClass();
        this.f401609f.f401836b.put(r109.f401730c, r109);
        goto L72
    L63:
        r115 = false;
    L72:
        r108 = r108 + 1;
    L74:
        if (this.L0.f401716k == false) goto L118;
        int r116 = this.f401608e.h();
        int r117 = 0;
    L76:
        if (r117 >= r116) goto L92;
        y r118 = E(this.f401608e.g(r117));
        if (f401596h2 == false) goto L87;
        if (r118.f401730c != (-1)) goto L87;
        if (r118.i() == true) goto L87;
        throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + t());
    L87:
        if (r118.o() == true) goto L91;
        if (r118.f401731d != (-1)) goto L91;
        r118.f401731d = r118.f401730c;
    L91:
        r117 = r117 + 1;
        goto L76
    L92:
        v r119 = this.L0;
        boolean r120 = r119.f401711f;
        r119.f401711f = false;
        this.f401621m.X(this.f401603b, r119);
        this.L0.f401711f = r120;
        int r121 = 0;
    L94:
        if (r121 >= this.f401608e.e()) goto L117;
        y r122 = E(this.f401608e.d(r121));
        if (r122.o() == true) goto L116;
        j0.a r123 = this.f401609f.f401835a.get(r122);
        if (r123 != null) goto L101;
    L103:
        boolean r124 = false;
    L104:
        if (r124 == true) goto L116;
        ItemAnimator.b(r122);
        if ((r122.f401737j & 8192) == 0) goto L108;
        boolean r125 = true;
    L109:
        ItemAnimator r126 = this.I;
        r122.e();
        r126.getClass();
        ItemAnimator.c r127 = new ItemAnimator.c();
        View r128 = r122.f401728a;
        r127.f401649a = r128.getLeft();
        r127.f401650b = r128.getTop();
        r128.getRight();
        r128.getBottom();
        if (r125 == false) goto L112;
        Q(r122, r127);
        goto L116
    L112:
        j0 r129 = this.f401609f;
        j0.a r130 = r129.f401835a.get(r122);
        if (r130 != null) goto L115;
        r130 = j0.a.a();
        r129.f401835a.put(r122, r130);
    L115:
        r130.f401838a |= 2;
        r130.f401839b = r127;
        goto L116
    L108:
        r125 = false;
        goto L109
    L101:
        if ((r123.f401838a & 4) == 0) goto L103;
        r124 = true;
    L116:
        r121 = r121 + 1;
        goto L94
    L117:
        m();
    L119:
        L(true);
        Z(false);
        this.L0.f401709d = 2;
        return;
    L118:
        m();
        goto L119
    L43:
        if (this.f401611g1 == false) goto L45;
        r106 = true;
        goto L46
    L19:
        v r131 = this.L0;
        this.f401620l.getClass();
        r131.f401718m = -1;
        v r132 = this.L0;
        if (this.C == false) goto L23;
    L21:
        int r133 = -1;
    L29:
        r132.f401717l = r133;
        v r134 = this.L0;
        View r135 = r101.f401728a;
        int r136 = r135.getId();
    L31:
        if (r135.isFocused() == true) goto L39;
        if ((r135 instanceof ViewGroup) == false) goto L39;
        if (r135.hasFocus() == false) goto L39;
        r135 = ((ViewGroup) r135).getFocusedChild();
        if (r135.getId() == (-1)) goto L31;
        r136 = r135.getId();
    L39:
        r134.f401719n = r136;
        goto L40
    L23:
        if (r101.i() == false) goto L25;
        r133 = r101.f401731d;
        goto L29
    L25:
        RecyclerView r137 = r101.f401745r;
        if (r137 == null) goto L21;
        r133 = r137.B(r101);
        goto L29
    L5:
        if (hasFocus() == false) goto L9;
        if (this.f401620l == null) goto L9;
        r102 = getFocusedChild();
        goto L10
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f401632v == 0) goto L5;
    L7:
        this.f401634w = true;
        return;
    L5:
        if (this.f401635x == true) goto L7;
        super.requestLayout();
    }

    public final String t() {
        return " " + super.toString() + ", adapter:" + this.f401620l + ", layout:" + this.f401621m + ", context:" + getContext();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.E = 0;
        boolean r100 = true;
        this.f401629s = true;
        if (this.f401631u == true) goto L5;
    L7:
        r100 = false;
    L8:
        this.f401631u = r100;
        this.f401603b.d();
        k r101 = this.f401621m;
        if (r101 == null) goto L11;
        r101.getClass();
    L11:
        this.f401619k1 = false;
        if (E2 == false) goto L32;
        ThreadLocal<com.obric.oui.orecyclerview.widget.s> r102 = com.obric.oui.orecyclerview.widget.s.f401941e;
        com.obric.oui.orecyclerview.widget.s r103 = r102.get();
        this.f401625p0 = r103;
        if (r103 != null) goto L23;
        this.f401625p0 = new com.obric.oui.orecyclerview.widget.s();
        Display r104 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r104 == null) goto L21;
        float r105 = r104.getRefreshRate();
        if (r105 < 30.0f) goto L21;
    L22:
        com.obric.oui.orecyclerview.widget.s r106 = this.f401625p0;
        r106.f401945c = (long) (1.0E9f / r105);
        r102.set(r106);
    L21:
        r105 = 60.0f;
    L23:
        com.obric.oui.orecyclerview.widget.s r107 = this.f401625p0;
        r107.getClass();
        if (f401596h2 == true) goto L26;
    L30:
        r107.f401943a.add(this);
        return;
    L26:
        if (r107.f401943a.contains(this) == false) goto L30;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    L32:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r100 = this.I;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        a0();
        this.f401629s = false;
        k r101 = this.f401621m;
        if (r101 == null) goto L8;
        r101.M();
    L8:
        ((ArrayList) this.L1).clear();
        removeCallbacks(this.Q1);
        this.f401609f.getClass();
    L10:
        if (j0.a.f401837d.acquire() != 0) goto L10;
        q r102 = this.f401603b;
        int r103 = 0;
    L14:
        if (r103 >= r102.f401685c.size()) goto L16;
        PoolingContainer.callPoolingContainerOnRelease(((y) ListProtector.get(r102.f401685c, r103)).f401728a);
        r103 = r103 + 1;
        goto L14
    L16:
        r102.e(r102.f401690h.f401620l, false);
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (E2 == false) goto L31;
        com.obric.oui.orecyclerview.widget.s r104 = this.f401625p0;
        if (r104 == null) goto L32;
        boolean r105 = r104.f401943a.remove(this);
        if (f401596h2 == false) goto L26;
        if (r105 == true) goto L26;
        throw new IllegalStateException("RecyclerView removal failed!");
    L26:
        this.f401625p0 = null;
        return;
    L32:
        return;
    }

    public final void r() {
        Y();
        K();
        this.L0.a(6);
        this.f401607d.c();
        v r100 = this.L0;
        r100.f401710e = this.f401620l.a();
        this.L0.f401708c = 0;
        if (this.f401606c == null) goto L18;
        Adapter r101 = this.f401620l;
        r101.getClass();
        int r102 = e.f401659a[r101.f401641b.ordinal()];
        if (r102 != 1) goto L7;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L18;
        Parcelable r104 = this.f401606c.f401655a;
        if (r104 == null) goto L17;
        this.f401621m.Z(r104);
    L17:
        this.f401606c = null;
        goto L18
    L7:
        if (r102 == 2) goto L10;
    L11:
        r103 = true;
        goto L13
    L10:
        if (r101.a() <= 0) goto L12;
    L18:
        v r105 = this.L0;
        r105.f401712g = false;
        this.f401621m.X(this.f401603b, r105);
        v r106 = this.L0;
        r106.f401711f = false;
        if (r106.f401715j == true) goto L21;
    L23:
        boolean r107 = false;
    L24:
        r106.f401715j = r107;
        r106.f401709d = 4;
        L(true);
        Z(false);
        return;
    L21:
        if (this.I == null) goto L23;
        r107 = true;
        goto L24
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public Adapter getAdapter() {
        return this.f401620l;
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f401610g;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f401626p1;
    }

    public ItemAnimator getItemAnimator() {
        return this.I;
    }

    public k getLayoutManager() {
        return this.f401621m;
    }

    public int getMaxFlingVelocity() {
        return this.T;
    }

    public int getMinFlingVelocity() {
        return this.S;
    }

    public m getOnFlingListener() {
        return this.R;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.W;
    }

    public int getScrollState() {
        return this.f401601J;
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f401629s;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f401635x;
    }

    public RecyclerView(Context r100) {
        this(r100, null);
    }

    public static y E(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r100.getLayoutParams()).f401651a;
    }

    public static /* synthetic */ boolean d(RecyclerView r100) {
        return r100.awakenScrollBars();
    }

    public static void l(y r100) {
        WeakReference<RecyclerView> r101 = r100.f401729b;
        if (r101 == null) goto L23;
        RecyclerView r102 = r101.get();
    L6:
        if (r102 == null) goto L14;
        if (r102 == r100.f401728a) goto L9;
        Object r103 = r102.getParent();
        if ((r103 instanceof View) == true) goto L12;
        r102 = null;
        goto L6
    L12:
        r102 = (View) r103;
        goto L6
    L9:
        return;
    L14:
        r100.f401729b = null;
        return;
    }

    public static void setDebugAssertionsEnabled(boolean r100) {
        f401596h2 = r100;
    }

    public static void setVerboseLoggingEnabled(boolean r100) {
        f401597p2 = r100;
    }

    public static RecyclerView y(View r100) {
        if ((r100 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r100 instanceof RecyclerView) == true) goto L8;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        RecyclerView r104 = y(r101.getChildAt(r103));
        if (r104 != null) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r104;
    L15:
        return null;
    L8:
        return (RecyclerView) r100;
    }

    public final int B(y r100) {
        int r101 = 0;
        if ((r100.f401737j & 524) == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L37:
        return -1;
    L8:
        if (r100.f() == false) goto L37;
        com.obric.oui.orecyclerview.widget.a r103 = this.f401607d;
        int r104 = r100.f401730c;
        int r105 = r103.f401773b.size();
    L11:
        if (r101 >= r105) goto L49;
        com.obric.oui.orecyclerview.widget.a.b r106 = (com.obric.oui.orecyclerview.widget.a.b) ListProtector.get(r103.f401773b, r101);
        int r107 = r106.f401778a;
        if (r107 == 1) goto L34;
        if (r107 != 2) goto L17;
        int r108 = r106.f401779b;
        if (r108 > r104) goto L36;
        int r109 = r106.f401781d;
        if ((r108 + r109) > r104) goto L37;
        r104 = r104 - r109;
    L36:
        r101 = r101 + 1;
        goto L11
    L17:
        if (r107 != 8) goto L36;
        int r110 = r106.f401779b;
        if (r110 != r104) goto L22;
        r104 = r106.f401781d;
        goto L36
    L22:
        if (r110 >= r104) goto L25;
        r104 = r104 - 1;
    L25:
        if (r106.f401781d > r104) goto L36;
        r104 = r104 + 1;
        goto L36
    L34:
        if (r106.f401779b > r104) goto L36;
        r104 = r104 + r106.f401781d;
        goto L36
    L49:
        return r104;
    L5:
        r102 = false;
        goto L6
    }

    public final int C(View r100) {
        y r101 = E(r100);
        if (r101 == null) goto L9;
        RecyclerView r102 = r101.f401745r;
        if (r102 != null) goto L8;
        return -1;
    L8:
        return r102.B(r101);
    L9:
        return -1;
    }

    public final y D(View r100) {
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L9;
        if (r101 == this) goto L9;
        throw new IllegalArgumentException("View " + r100 + " is not a direct child of " + this);
    L9:
        return E(r100);
    }

    public final Rect F(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if (r101.f401653c == true) goto L7;
        return r101.f401652b;
    L7:
        if (this.L0.f401712g == false) goto L17;
        y r102 = r101.f401651a;
        if ((r102.f401737j & 2) == 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L16;
        if (r102.g() == false) goto L17;
    L16:
        return r101.f401652b;
    L11:
        r103 = false;
    L17:
        Rect r104 = r101.f401652b;
        r104.set(0, 0, 0, 0);
        int r105 = this.f401624p.size();
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L20;
        this.f401615i.set(0, 0, 0, 0);
        ((j) ListProtector.get(this.f401624p, r106)).c(this.f401615i, r100, this, this.L0);
        int r107 = r104.left;
        Rect r108 = this.f401615i;
        r104.left = r107 + r108.left;
        r104.top += r108.top;
        r104.right += r108.right;
        r104.bottom += r108.bottom;
        r106 = r106 + 1;
        goto L18
    L20:
        r101.f401653c = false;
        return r104;
    }

    public final void H(int r100) {
        if (this.f401621m != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.f401621m.i0(r100);
        awakenScrollBars();
    }

    public final void L(boolean r100) {
        boolean r101 = true;
        int r102 = this.E - 1;
        this.E = r102;
        if (r102 < 1) goto L5;
        return;
    L5:
        if (f401596h2 == false) goto L10;
        if (r102 >= 0) goto L10;
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + t());
    L10:
        this.E = 0;
        if (r100 == false) goto L41;
        int r103 = this.f401639z;
        this.f401639z = 0;
        if (r103 == 0) goto L22;
        AccessibilityManager r104 = this.B;
        if (r104 != null) goto L17;
    L19:
        r101 = false;
    L20:
        if (r101 == false) goto L22;
        AccessibilityEvent r105 = AccessibilityEvent.obtain();
        r105.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r105, r103);
        sendAccessibilityEventUnchecked(r105);
        goto L22
    L17:
        if (r104.isEnabled() == false) goto L19;
    L22:
        int r106 = ((ArrayList) this.L1).size() - 1;
    L23:
        if (r106 < 0) goto L33;
        y r107 = (y) ListProtector.get(this.L1, r106);
        if (r107.f401728a.getParent() != this) goto L32;
        if (r107.o() == true) goto L32;
        int r108 = r107.f401744q;
        if (r108 == (-1)) goto L32;
        ViewCompat.setImportantForAccessibility(r107.f401728a, r108);
        r107.f401744q = -1;
    L32:
        r106 = r106 - 1;
        goto L23
    L33:
        ((ArrayList) this.L1).clear();
        return;
    }

    public final void M(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.K) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.K = r100.getPointerId(r102);
        int r103 = (int) (r100.getX(r102) + 0.5f);
        this.O = r103;
        this.M = r103;
        int r104 = (int) (r100.getY(r102) + 0.5f);
        this.P = r104;
        this.N = r104;
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public final void P(boolean r100) {
        this.D = r100 | this.D;
        this.C = true;
        int r101 = this.f401608e.h();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L11;
        y r104 = E(this.f401608e.g(r103));
        if (r104 == null) goto L10;
        if (r104.o() == true) goto L10;
        r104.b(6);
    L10:
        r103 = r103 + 1;
        goto L4
    L11:
        I();
        q r105 = this.f401603b;
        int r106 = r105.f401685c.size();
    L12:
        if (r102 >= r106) goto L17;
        y r107 = (y) ListProtector.get(r105.f401685c, r102);
        if (r107 == null) goto L16;
        r107.b(6);
        r107.a(null);
    L16:
        r102 = r102 + 1;
        goto L12
    L17:
        Adapter r108 = r105.f401690h.f401620l;
        r105.f();
    }

    public final void W(int r100) {
        if (this.f401635x == false) goto L5;
        return;
    L5:
        a0();
        k r101 = this.f401621m;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.i0(r100);
        awakenScrollBars();
    }

    public final void Z(boolean r100) {
        if (this.f401632v >= 1) goto L10;
        if (f401596h2 == true) goto L8;
        this.f401632v = 1;
        goto L10
    L8:
        throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + t());
    L10:
        if (r100 == true) goto L15;
        if (this.f401635x == true) goto L15;
        this.f401634w = false;
    L15:
        if (this.f401632v != 1) goto L29;
        if (r100 == false) goto L27;
        if (this.f401634w == false) goto L27;
        if (this.f401635x == true) goto L27;
        if (this.f401621m == null) goto L27;
        if (this.f401620l == null) goto L27;
        p();
    L27:
        if (this.f401635x == true) goto L29;
        this.f401634w = false;
    L29:
        this.f401632v--;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f401621m.e((LayoutParams) r100) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        r100.save();
        com.obric.oui.orecyclerview.base.a r101 = this.G;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        com.obric.oui.orecyclerview.base.a r104 = this.H;
        if (r104 != null) goto L11;
    L13:
        r102 = r103;
    L14:
        getBounceTranslation();
        super.dispatchDraw(r100);
        r100.restore();
        if (r102 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L11:
        if (r104.f401538h == true) goto L13;
        r104.a();
        r100.translate(0.0f, this.H.f401534d);
        goto L14
    L5:
        if (r101.f401538h == true) goto L7;
        r101.a();
        r100.translate(this.G.f401534d, 0.0f);
        r103 = true;
        goto L8
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        onPopulateAccessibilityEvent(r100);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> r100) {
        dispatchThawSelfOnly(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> r100) {
        dispatchFreezeSelfOnly(r100);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        int r101 = this.f401624p.size();
        boolean r102 = false;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        ((j) ListProtector.get(this.f401624p, r103)).d(r100);
        r103 = r103 + 1;
        goto L3
    L6:
        if (this.I != null) goto L8;
    L12:
        if (r102 == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L16:
        return;
    L8:
        if (this.f401624p.size() <= 0) goto L12;
        if (this.I.g() == false) goto L12;
        r102 = true;
        goto L12
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        k r101 = this.f401621m;
        if (r101 == null) goto L7;
        return r101.r(getContext(), r100);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + t());
    }

    public final void h(y r100) {
        View r101 = r100.f401728a;
        if (r101.getParent() != this) goto L5;
        boolean r102 = true;
    L6:
        this.f401603b.l(D(r101));
        if (r100.k() == false) goto L9;
        this.f401608e.b(r101, -1, r101.getLayoutParams(), true);
        return;
    L9:
        if (r102 == true) goto L11;
        this.f401608e.a(r101, -1, true);
        return;
    L11:
        com.obric.oui.orecyclerview.widget.g r103 = this.f401608e;
        int r104 = ((d0) r103.f401817a).f401799a.indexOfChild(r101);
        if (r104 < 0) goto L16;
        r103.f401818b.g(r104);
        r103.i(r101);
        return;
    L16:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r101);
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return getScrollingChildHelper().hasNestedScrollingParent(r100);
    }

    public final void i(j r100) {
        k r101 = this.f401621m;
        if (r101 == null) goto L6;
        r101.b("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.f401624p.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        this.f401624p.add(r100);
        I();
        requestLayout();
    }

    public final void j(o r100) {
        if (this.V0 != null) goto L5;
        this.V0 = new ArrayList();
    L5:
        this.V0.add(r100);
    }

    public final void k(String r100) {
        if (G() == false) goto L10;
        if (r100 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + t());
    L8:
        throw new IllegalStateException(r100);
    L10:
        if (this.F <= 0) goto L13;
        new IllegalStateException("" + t());
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = this.f401624p.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((j) ListProtector.get(this.f401624p, r102)).getClass();
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r110) {
        if (this.f401621m != null) goto L6;
        return false;
    L6:
        if (this.f401635x == false) goto L9;
        return false;
    L9:
        if (r110.getAction() == 8) goto L11;
    L77:
        return false;
    L11:
        if ((r110.getSource() & 2) == 0) goto L20;
        if (this.f401621m.d() == false) goto L15;
        float r100 = -r110.getAxisValue(9);
    L17:
        if (this.f401621m.c() == false) goto L28;
        float r101 = r110.getAxisValue(10);
    L30:
        if (r100 == 0.0f) goto L32;
    L33:
        int r102 = (int) (r101 * this.U);
        int r103 = (int) (r100 * this.V);
        k r104 = this.f401621m;
        if (r104 == null) goto L77;
        if (this.f401635x == true) goto L77;
        int[] r105 = this.H1;
        r105[0] = 0;
        r105[1] = 0;
        boolean r106 = r104.c();
        boolean r107 = this.f401621m.d();
        if (r107 == false) goto L42;
        int r108 = (r106 ? 1 : 0) | 2;
    L43:
        r110.getY();
        r110.getX();
        com.obric.oui.orecyclerview.base.a r109 = this.G;
        if (r109 != null) goto L46;
    L48:
        int r111 = 0;
    L49:
        int r112 = r102 - r111;
        com.obric.oui.orecyclerview.base.a r113 = this.H;
        if (r113 != null) goto L52;
    L54:
        int r114 = 0;
    L55:
        int r115 = r103 - r114;
        startNestedScroll(r108, 1);
        if (r106 == false) goto L58;
        int r116 = r112;
    L59:
        if (r107 == false) goto L61;
        int r117 = r115;
    L63:
        if (dispatchNestedPreScroll(r116, r117, this.H1, this.f401638y1, 1) == false) goto L65;
        int[] r118 = this.H1;
        r112 = r112 - r118[0];
        r115 = r115 - r118[1];
    L65:
        if (r106 == false) goto L67;
        int r119 = r112;
    L68:
        if (r107 == false) goto L70;
        int r120 = r115;
    L71:
        U(r119, r120, r110, 1);
        com.obric.oui.orecyclerview.widget.s r121 = this.f401625p0;
        if (r121 == null) goto L76;
        if (r112 != 0) goto L75;
        if (r115 == 0) goto L76;
    L75:
        r121.b(this, r112, r115);
    L76:
        stopNestedScroll(1);
        goto L77
    L70:
        r120 = 0;
        goto L71
    L67:
        r119 = 0;
        goto L68
    L61:
        r117 = 0;
        goto L63
    L58:
        r116 = 0;
        goto L59
    L52:
        if (r113.f401534d == 0.0f) goto L54;
        r114 = (int) r113.c(r103, true, false);
        invalidate();
        goto L55
    L46:
        if (r109.f401534d == 0.0f) goto L48;
        r111 = (int) r109.c(r102, true, false);
        invalidate();
        goto L49
    L42:
        r108 = r106 ? 1 : 0;
        goto L43
    L32:
        if (r101 == 0.0f) goto L77;
    L28:
        r101 = 0.0f;
        goto L30
    L15:
        r100 = 0.0f;
        goto L17
    L20:
        if ((r110.getSource() & 4194304) == 0) goto L27;
        r101 = r110.getAxisValue(26);
        if (this.f401621m.d() == false) goto L25;
        r100 = -r101;
        goto L28
    L25:
        if (this.f401621m.c() == false) goto L27;
        r100 = 0.0f;
    L27:
        r100 = 0.0f;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f401635x == false) goto L5;
        return false;
    L5:
        this.f401628r = null;
        if (w(r110) == false) goto L9;
        T();
        setScrollState(0);
        return true;
    L9:
        k r100 = this.f401621m;
        if (r100 != null) goto L12;
        return false;
    L12:
        boolean r101 = r100.c();
        boolean r102 = this.f401621m.d();
        if (this.L != null) goto L15;
        Context r103 = getContext();
        int r104 = com.obric.oui.orecyclerview.base.g.f401552a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.L = new com.obric.oui.orecyclerview.base.f();
    L15:
        this.L.a(r110);
        int r105 = r110.getActionMasked();
        int r106 = r110.getActionIndex();
        if (r105 == 0) goto L50;
        if (r105 == 1) goto L47;
        if (r105 != 2) goto L20;
        int r107 = r110.findPointerIndex(this.K);
        if (r107 < 0) goto L32;
        int r108 = (int) (r110.getX(r107) + 0.5f);
        int r111 = (int) (r110.getY(r107) + 0.5f);
        if (this.f401601J == 1) goto L48;
        int r109 = r108 - this.M;
        int r112 = r111 - this.N;
        if (r101 == true) goto L38;
    L40:
        boolean r113 = false;
    L41:
        if (r102 == true) goto L43;
    L45:
        if (r113 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r112) <= this.Q) goto L45;
        this.P = r111;
        r113 = true;
        goto L45
    L38:
        if (Math.abs(r109) <= this.Q) goto L40;
        this.O = r108;
        r113 = true;
    L48:
        boolean r114 = false;
    L120:
        if (r114 == false) goto L122;
        return false;
    L122:
        if (this.f401601J != 1) goto L126;
        return true;
    L126:
        return false;
    L32:
        return false;
    L20:
        if (r105 != 3) goto L22;
        T();
        setScrollState(0);
        goto L48
    L22:
        if (r105 != 5) goto L24;
        this.K = r110.getPointerId(r106);
        int r115 = (int) (r110.getX(r106) + 0.5f);
        this.O = r115;
        this.M = r115;
        int r116 = (int) (r110.getY(r106) + 0.5f);
        this.P = r116;
        this.N = r116;
        goto L48
    L24:
        if (r105 != 6) goto L48;
        M(r110);
        goto L48
    L47:
        this.L.b();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.f401637y == false) goto L52;
        this.f401637y = false;
    L52:
        this.K = r110.getPointerId(0);
        int r117 = (int) (r110.getX() + 0.5f);
        this.O = r117;
        this.M = r117;
        int r118 = (int) (r110.getY() + 0.5f);
        this.P = r118;
        this.N = r118;
        f0 r119 = this.f401605b2;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r119.f401816b == true) goto L56;
        r110.getActionMasked();
    L57:
        r114 = false;
    L100:
        if (r114 == true) goto L116;
        com.obric.oui.orecyclerview.base.a r120 = this.G;
        if (r120 != null) goto L104;
    L106:
        boolean r121 = false;
    L107:
        com.obric.oui.orecyclerview.base.a r122 = this.H;
        if (r122 != null) goto L110;
    L112:
        if (r121 == false) goto L114;
    L115:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L116
    L114:
        if (this.f401601J != 2) goto L116;
    L110:
        if (r122.f401534d == 0.0f) goto L112;
        r122.c(0.0f, false, false);
        r121 = true;
        goto L112
    L104:
        if (r120.f401534d == 0.0f) goto L106;
        r121 = true;
    L116:
        int[] r123 = this.G1;
        r123[1] = 0;
        r123[0] = 0;
        int r124 = r101;
        if (r102 == false) goto L119;
        r124 = (r101 ? 1 : 0) | 2;
    L119:
        startNestedScroll(r124, 0);
        goto L120
    L56:
        if (r110.getAction() != 0) goto L57;
        RecyclerView r125 = r119.f401815a;
        com.obric.oui.orecyclerview.base.a r126 = r125.G;
        com.obric.oui.orecyclerview.base.a r127 = r125.H;
        if (r126 != null) goto L61;
        float r128 = 0.0f;
    L62:
        if (r127 != null) goto L64;
        float r129 = 0.0f;
    L66:
        if (r128 != 0.0f) goto L68;
        boolean r130 = true;
    L69:
        if (r130 == false) goto L79;
        if (r126 != null) goto L73;
    L75:
        boolean r131 = false;
    L76:
        if (r131 == true) goto L79;
        boolean r132 = false;
    L81:
        if (r129 != 0.0f) goto L83;
        boolean r133 = true;
    L84:
        if (r133 == false) goto L94;
        if (r127 != null) goto L88;
    L90:
        boolean r134 = false;
    L91:
        if (r134 == true) goto L94;
        boolean r135 = false;
    L95:
        if (r132 == true) goto L98;
        if (r135 == true) goto L98;
        r114 = false;
    L99:
        r110.getActionMasked();
    L98:
        r114 = true;
        goto L99
    L88:
        if (r127.f401538h == true) goto L90;
        r134 = true;
    L94:
        r135 = true;
        goto L95
    L83:
        r133 = false;
        goto L84
    L73:
        if (r126.f401538h == true) goto L75;
        r131 = true;
    L79:
        r132 = true;
        goto L81
    L68:
        r130 = false;
        goto L69
    L64:
        r129 = r127.f401534d;
        goto L66
    L61:
        r128 = r126.f401534d;
        goto L62
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.f401606c = r101;
        super.onRestoreInstanceState(r101.getSuperState());
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (this.f401635x == false) goto L5;
    L128:
        return false;
    L5:
        if (this.f401637y == true) goto L128;
        n r101 = this.f401628r;
        if (r101 == null) goto L10;
        r101.onTouchEvent(r110);
        int r102 = r110.getAction();
        if (r102 == 3) goto L16;
        if (r102 == 1) goto L16;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        T();
        setScrollState(0);
        return true;
    L21:
        k r104 = this.f401621m;
        if (r104 != null) goto L24;
        return false;
    L24:
        boolean r111 = r104.c();
        boolean r112 = this.f401621m.d();
        if (this.L != null) goto L27;
        Context r105 = getContext();
        int r106 = com.obric.oui.orecyclerview.base.g.f401552a;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.L = new com.obric.oui.orecyclerview.base.f();
    L27:
        int r107 = r110.getActionMasked();
        int r108 = r110.getActionIndex();
        if (r107 != 0) goto L30;
        int[] r109 = this.G1;
        r109[1] = 0;
        r109[0] = 0;
    L30:
        MotionEvent r113 = MotionEvent.obtain(r110);
        int[] r114 = this.G1;
        r113.offsetLocation(r114[0], r114[1]);
        if (r107 != 0) goto L33;
        this.K = r110.getPointerId(0);
        int r115 = (int) (r110.getX() + 0.5f);
        this.O = r115;
        this.M = r115;
        int r116 = (int) (r110.getY() + 0.5f);
        this.P = r116;
        this.N = r116;
        int r117 = r111;
        if (r112 == false) goto L123;
        r117 = (r111 ? 1 : 0) | 2;
    L123:
        startNestedScroll(r117, 0);
    L124:
        if (r100 == true) goto L126;
        this.L.a(r113);
    L126:
        r113.recycle();
        return true;
    L33:
        if (r107 != 1) goto L35;
        this.L.a(r113);
        this.L.c(this.T);
        if (r111 == false) goto L108;
        float r118 = -this.L.d(this.K);
    L109:
        if (r112 == false) goto L111;
        float r119 = -this.L.e(this.K);
    L113:
        if (r118 != 0.0f) goto L117;
        if (r119 != 0.0f) goto L117;
    L118:
        setScrollState(0);
    L119:
        T();
        r100 = true;
    L117:
        if (A((int) r118, (int) r119) == true) goto L119;
    L111:
        r119 = 0.0f;
        goto L113
    L108:
        r118 = 0.0f;
        goto L109
    L35:
        if (r107 == 2) goto L45;
        if (r107 != 3) goto L38;
        T();
        setScrollState(0);
        goto L124
    L38:
        if (r107 != 5) goto L40;
        this.K = r110.getPointerId(r108);
        int r120 = (int) (r110.getX(r108) + 0.5f);
        this.O = r120;
        this.M = r120;
        int r121 = (int) (r110.getY(r108) + 0.5f);
        this.P = r121;
        this.N = r121;
        goto L124
    L40:
        if (r107 != 6) goto L124;
        M(r110);
        goto L124
    L45:
        int r122 = r110.findPointerIndex(this.K);
        if (r122 < 0) goto L48;
        int r123 = (int) (r110.getX(r122) + 0.5f);
        int r124 = (int) (r110.getY(r122) + 0.5f);
        int r125 = this.O - r123;
        int r126 = this.P - r124;
        if (this.f401601J == 1) goto L67;
        if (r111 == false) goto L57;
        if (r125 <= 0) goto L54;
        r125 = Math.max(0, r125 - this.Q);
    L55:
        if (r125 == 0) goto L57;
        boolean r127 = true;
    L58:
        if (r112 == false) goto L64;
        if (r126 <= 0) goto L61;
        r126 = Math.max(0, r126 - this.Q);
    L62:
        if (r126 == 0) goto L64;
        r127 = true;
        goto L64
    L61:
        r126 = Math.min(0, r126 + this.Q);
    L64:
        if (r127 == false) goto L67;
        setScrollState(1);
        goto L67
    L54:
        r125 = Math.min(0, r125 + this.Q);
    L57:
        r127 = false;
    L67:
        if (this.f401601J != 1) goto L124;
        int[] r128 = this.H1;
        r128[0] = 0;
        r128[1] = 0;
        r110.getY();
        com.obric.oui.orecyclerview.base.a r129 = this.G;
        if (r129 != null) goto L71;
    L73:
        int r130 = 0;
    L74:
        int r131 = r125 - r130;
        r110.getX();
        com.obric.oui.orecyclerview.base.a r132 = this.H;
        if (r132 != null) goto L77;
    L79:
        int r133 = 0;
    L80:
        int r134 = r126 - r133;
        if (r111 == false) goto L83;
        int r135 = r131;
    L84:
        if (r112 == false) goto L86;
        int r136 = r134;
    L88:
        if (dispatchNestedPreScroll(r135, r136, this.H1, this.f401638y1, 0) == false) goto L90;
        int[] r137 = this.H1;
        r131 = r131 - r137[0];
        r134 = r134 - r137[1];
        int[] r138 = this.G1;
        int r139 = r138[0];
        int[] r140 = this.f401638y1;
        r138[0] = r139 + r140[0];
        r138[1] = r138[1] + r140[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L90:
        int r141 = r134;
        int[] r142 = this.f401638y1;
        this.O = r123 - r142[0];
        this.P = r124 - r142[1];
        if (r111 == false) goto L93;
        int r143 = r131;
    L94:
        if (r112 == false) goto L96;
        int r144 = r141;
    L98:
        if (U(r143, r144, r110, 0) == false) goto L100;
        getParent().requestDisallowInterceptTouchEvent(true);
    L100:
        com.obric.oui.orecyclerview.widget.s r145 = this.f401625p0;
        if (r145 == null) goto L124;
        if (r131 != 0) goto L104;
        if (r141 == 0) goto L124;
    L104:
        r145.b(this, r131, r141);
        goto L124
    L96:
        r144 = 0;
        goto L98
    L93:
        r143 = 0;
        goto L94
    L86:
        r136 = 0;
        goto L88
    L83:
        r135 = 0;
        goto L84
    L77:
        if (r132.f401534d == 0.0f) goto L79;
        r133 = (int) r132.c(r126, true, false);
        invalidate();
        goto L80
    L71:
        if (r129.f401534d == 0.0f) goto L73;
        r130 = (int) r129.c(r125, true, false);
        invalidate();
        goto L74
    L48:
        return false;
    L16:
        this.f401628r = null;
        goto L17
    L10:
        if (r110.getAction() != 0) goto L12;
        r103 = false;
        goto L18
    L12:
        r103 = w(r110);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        int r101 = this.f401627q.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((n) ListProtector.get(this.f401627q, r102)).b();
        r102 = r102 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent r100) {
        int r101 = 0;
        if (G() == false) goto L11;
        if (r100 == null) goto L6;
        int r102 = AccessibilityEventCompat.getContentChangeTypes(r100);
    L7:
        if (r102 == 0) goto L10;
        r101 = r102;
    L10:
        this.f401639z |= r101;
        r101 = 1;
        goto L11
    L6:
        r102 = 0;
    L11:
        if (r101 == 0) goto L13;
        return;
    L13:
        super.sendAccessibilityEventUnchecked(r100);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate r100) {
        this.f401626p1 = r100;
        ViewCompat.setAccessibilityDelegate(this, r100);
    }

    public void setAdapter(Adapter r100) {
        setLayoutFrozen(false);
        Adapter r101 = this.f401620l;
        if (r101 == null) goto L5;
        r101.f401640a.unregisterObserver(this.f401602a);
        this.f401620l.getClass();
    L5:
        R();
        com.obric.oui.orecyclerview.widget.a r102 = this.f401607d;
        r102.k(r102.f401773b);
        r102.k(r102.f401774c);
        r102.f401777f = 0;
        Adapter<?> r103 = this.f401620l;
        this.f401620l = r100;
        if (r100 == null) goto L8;
        r100.f401640a.registerObserver(this.f401602a);
    L8:
        q r104 = this.f401603b;
        Adapter r105 = this.f401620l;
        r104.f401683a.clear();
        r104.f();
        r104.e(r103, true);
        p r106 = r104.c();
        if (r103 == null) goto L12;
        r106.f401677b--;
    L12:
        if (r106.f401677b != 0) goto L21;
        int r107 = 0;
    L15:
        if (r107 >= r106.f401676a.size()) goto L21;
        p.a r108 = r106.f401676a.valueAt(r107);
        Iterator<y> r109 = r108.f401679a.iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        PoolingContainer.callPoolingContainerOnRelease(r109.next().f401728a);
        goto L18
    L20:
        r108.f401679a.clear();
        r107 = r107 + 1;
    L21:
        if (r105 == null) goto L23;
        r106.f401677b++;
    L23:
        r104.d();
        this.L0.f401711f = true;
        P(false);
        requestLayout();
    }

    public void setAllowClickDuringOverScrollDebugLogEnabled(boolean r100) {
        this.f401605b2.getClass();
        Intrinsics.stringPlus("allowClickDuringOverScrollDebugLog enable=", Boolean.valueOf(r100));
    }

    public void setChildDrawingOrderCallback(h r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r100) {
        if (r100 == this.f401610g) goto L5;
        this.H = null;
        this.G = null;
    L5:
        this.f401610g = r100;
        super.setClipToPadding(r100);
        if (this.f401631u == false) goto L9;
        requestLayout();
        return;
    }

    public void setEnableOverFling(boolean r100) {
        this.M1 = r100;
    }

    public void setHasFixedSize(boolean r100) {
        this.f401630t = r100;
    }

    public void setItemAnimator(ItemAnimator r100) {
        ItemAnimator r101 = this.I;
        if (r101 == null) goto L5;
        r101.f();
        this.I.f401643a = null;
    L5:
        this.I = r100;
        if (r100 == null) goto L9;
        r100.f401643a = this.f401614h1;
        return;
    }

    public void setItemViewCacheSize(int r100) {
        q r101 = this.f401603b;
        r101.f401687e = r100;
        r101.m();
    }

    public void setLayoutFrozen(boolean r100) {
        suppressLayout(r100);
    }

    public void setLayoutManager(k r100) {
        if (r100 != this.f401621m) goto L5;
        return;
    L5:
        a0();
        if (this.f401621m == null) goto L14;
        ItemAnimator r101 = this.I;
        if (r101 == null) goto L10;
        r101.f();
    L10:
        this.f401621m.b0(this.f401603b);
        this.f401621m.c0(this.f401603b);
        q r102 = this.f401603b;
        r102.f401683a.clear();
        r102.f();
        if (this.f401629s == false) goto L13;
        this.f401621m.M();
    L13:
        this.f401621m.o0(null);
        this.f401621m = null;
    L15:
        com.obric.oui.orecyclerview.widget.g r103 = this.f401608e;
        r103.f401818b.f();
        int r104 = ((ArrayList) r103.f401819c).size();
    L16:
        r104 = r104 - 1;
        int r105 = 0;
        if (r104 < 0) goto L26;
        com.obric.oui.orecyclerview.widget.g.b r106 = r103.f401817a;
        View r107 = (View) ListProtector.get(r103.f401819c, r104);
        d0 r108 = (d0) r106;
        r108.getClass();
        y r109 = E(r107);
        if (r109 == null) goto L25;
        RecyclerView r110 = r108.f401799a;
        int r111 = r109.f401743p;
        if (r110.G() == false) goto L23;
        r109.f401744q = r111;
        ((ArrayList) r110.L1).add(r109);
    L24:
        r109.f401743p = 0;
        goto L25
    L23:
        ViewCompat.setImportantForAccessibility(r109.f401728a, r111);
    L25:
        ListProtector.remove(r103.f401819c, r104);
        goto L16
    L26:
        d0 r112 = (d0) r103.f401817a;
        int r113 = r112.a();
    L27:
        if (r105 >= r113) goto L29;
        View r114 = r112.f401799a.getChildAt(r105);
        RecyclerView r115 = r112.f401799a;
        r115.getClass();
        E(r114);
        Adapter r116 = r115.f401620l;
        r114.clearAnimation();
        r105 = r105 + 1;
        goto L27
    L29:
        r112.f401799a.removeAllViews();
        this.f401621m = r100;
        if (r100 != null) goto L32;
    L38:
        this.f401603b.m();
        requestLayout();
        return;
    L32:
        if (r100.f401662b != null) goto L37;
        r100.o0(this);
        if (this.f401629s == false) goto L38;
        this.f401621m.getClass();
        goto L38
    L37:
        throw new IllegalArgumentException("LayoutManager " + r100 + " is already attached to a RecyclerView:" + r100.f401662b.t());
    L14:
        q r117 = this.f401603b;
        r117.f401683a.clear();
        r117.f();
        goto L15
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r100) {
        if (r100 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setMinFlingVelocity(int r100) {
        this.S = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        getScrollingChildHelper().setNestedScrollingEnabled(r100);
    }

    public void setOnBounceTranslationListener(l r100) {
        getBounceTranslation();
    }

    public void setOnFlingListener(m r100) {
        this.R = r100;
    }

    public void setOnScrollListener(o r100) {
        this.P0 = r100;
    }

    public void setPreserveFocusAfterLayout(boolean r100) {
        this.W = r100;
    }

    public void setRecycledViewPool(p r100) {
        q r101 = this.f401603b;
        r101.e(r101.f401690h.f401620l, false);
        p r102 = r101.f401689g;
        if (r102 == null) goto L5;
        r102.f401677b--;
    L5:
        r101.f401689g = r100;
        if (r100 != null) goto L8;
    L10:
        r101.d();
        return;
    L8:
        if (r101.f401690h.getAdapter() == null) goto L10;
        r101.f401689g.f401677b++;
        goto L10
    }

    public void setRecyclerListener(r r100) {
        this.f401622n = r100;
    }

    public void setScrollState(int r100) {
        if (r100 != this.f401601J) goto L6;
        return;
    L6:
        if (f401597p2 == false) goto L8;
        new Exception();
    L8:
        this.f401601J = r100;
        if (r100 == 2) goto L15;
        this.f401618k0.d();
        k r101 = this.f401621m;
        if (r101 == null) goto L15;
        u r102 = r101.f401665e;
        if (r102 == null) goto L15;
        r102.c();
    L15:
        o r103 = this.P0;
        if (r103 == null) goto L18;
        r103.a(this, r100);
    L18:
        List<o> r104 = this.V0;
        if (r104 == null) goto L24;
        int r105 = ((ArrayList) r104).size();
    L21:
        r105 = r105 - 1;
        if (r105 < 0) goto L26;
        ((o) ListProtector.get(this.V0, r105)).a(this, r100);
        goto L21
    L26:
        return;
    }

    public void setScrollingTouchSlop(int r100) {
        ViewConfiguration r101 = ViewConfiguration.get(getContext());
        if (r100 != 0) goto L5;
    L8:
        this.Q = r101.getScaledTouchSlop();
        return;
    L5:
        if (r100 != 1) goto L8;
        this.Q = r101.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(w r100) {
        this.f401603b.getClass();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return getScrollingChildHelper().startNestedScroll(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        getScrollingChildHelper().stopNestedScroll(r100);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r110) {
        if (r110 == this.f401635x) goto L16;
        k("Do not suppressLayout in layout or scroll");
        if (r110 == true) goto L14;
        this.f401635x = false;
        if (this.f401634w == true) goto L9;
    L13:
        this.f401634w = false;
        return;
    L9:
        if (this.f401621m == null) goto L13;
        if (this.f401620l == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r100 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0));
        this.f401635x = true;
        this.f401637y = true;
        a0();
        return;
    }

    public final void u(v r100) {
        if (getScrollState() != 2) goto L13;
        OverScrollerAdapter r101 = this.f401618k0.f401722c;
        if (r101.f401528f == false) goto L7;
        r101.d().getFinalX();
    L8:
        r101.b();
        r100.getClass();
        if (r101.f401528f == false) goto L11;
        r101.d().getFinalY();
    L12:
        r101.c();
        return;
    L11:
        ((com.obric.oui.orecyclerview.base.c) r101.f401527e.getValue()).a();
        goto L12
    L7:
        ((com.obric.oui.orecyclerview.base.c) r101.f401526d.getValue()).a();
        goto L8
    L13:
        r100.getClass();
    }

    public final View v(View r100) {
        ViewParent r101 = r100.getParent();
    L3:
        if (r101 == null) goto L8;
        if (r101 == this) goto L8;
        if ((r101 instanceof View) == false) goto L8;
        r100 = r101;
        r101 = r100.getParent();
    L8:
        if (r101 == this) goto L15;
        return null;
    L15:
        return r100;
    }

    public final boolean w(MotionEvent r100) {
        int r101 = r100.getAction();
        int r102 = this.f401627q.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        n r104 = (n) ListProtector.get(this.f401627q, r103);
        if (r104.a(this, r100) == false) goto L10;
        if (r101 == 3) goto L10;
        this.f401628r = r104;
        return true;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return false;
    }

    public final void x(int[] r100) {
        int r101 = this.f401608e.e();
        if (r101 != 0) goto L6;
        r100[0] = -1;
        r100[1] = -1;
        return;
    L6:
        int r102 = Integer.MAX_VALUE;
        int r103 = Integer.MIN_VALUE;
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L17;
        y r105 = E(this.f401608e.d(r104));
        if (r105.o() == true) goto L16;
        int r106 = r105.d();
        if (r106 >= r102) goto L14;
        r102 = r106;
    L14:
        if (r106 <= r103) goto L16;
        r103 = r106;
    L16:
        r104 = r104 + 1;
        goto L7
    L17:
        r100[0] = r102;
        r100[1] = r103;
    }

    public final y z(int r100) {
        y r101 = null;
        if (this.C == false) goto L5;
        return null;
    L5:
        int r102 = this.f401608e.h();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L18;
        y r104 = E(this.f401608e.g(r103));
        if (r104 == null) goto L17;
        if (r104.i() == true) goto L17;
        if (B(r104) != r100) goto L17;
        if (this.f401608e.k(r104.f401728a) == false) goto L16;
        r101 = r104;
        goto L17
    L16:
        return r104;
    L17:
        r103 = r103 + 1;
        goto L6
    L18:
        return r101;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        k r101 = this.f401621m;
        if (r101 == null) goto L7;
        return r101.s(r100);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + t());
    }

    public RecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.recyclerViewStyle);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = Class.forName(r100, false, r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r105 = Class.forName(r100, false, r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ void c(RecyclerView r100, int r101) {
        r100.detachViewFromParent(r101);
    }

    public static /* synthetic */ void f(RecyclerView r100, View r101) {
        r100.detachViewFromParent(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean A(int r110, int r111) {
        k r100 = this.f401621m;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f401635x == false) goto L8;
        return false;
    L8:
        boolean r101 = r100.c();
        boolean r102 = this.f401621m.d();
        if (r101 == true) goto L11;
    L14:
        int r103 = 0;
    L15:
        if (r102 == true) goto L17;
    L20:
        int r104 = 0;
    L21:
        if (r103 != 0) goto L25;
        if (r104 != 0) goto L25;
        return false;
    L25:
        if (r103 == 0) goto L37;
        com.obric.oui.orecyclerview.base.a r105 = this.G;
        if (r105 == null) goto L37;
        if (r105.f401534d == 0.0f) goto L37;
        r105.b(r103);
        if (this.M1 == false) goto L36;
        com.obric.oui.orecyclerview.base.a r106 = this.G;
        if (r106 == null) goto L37;
        if ((r106.f401534d * r103) >= 0.0f) goto L37;
    L36:
        r103 = 0;
    L37:
        if (r104 == 0) goto L49;
        com.obric.oui.orecyclerview.base.a r107 = this.H;
        if (r107 == null) goto L49;
        if (r107.f401534d == 0.0f) goto L49;
        r107.b(-r104);
        if (this.M1 == false) goto L48;
        com.obric.oui.orecyclerview.base.a r108 = this.H;
        if (r108 == null) goto L49;
        if ((r108.f401534d * r104) >= 0.0f) goto L49;
    L48:
        r104 = 0;
    L49:
        if (r103 != 0) goto L52;
        if (r104 != 0) goto L52;
        return false;
    L52:
        float r109 = r103;
        float r112 = r104;
        if (dispatchNestedPreFling(r109, r112) == true) goto L136;
        if (r101 == true) goto L58;
        if (r102 == true) goto L58;
        boolean r113 = false;
    L59:
        dispatchNestedFling(r109, r112, r113);
        m r114 = this.R;
        if (r114 == null) goto L127;
        h0 r115 = (h0) r114;
        k r116 = r115.f401825a.getLayoutManager();
        if (r116 != 0) goto L65;
    L123:
        boolean r117 = false;
    L124:
        if (r117 == false) goto L127;
        return true;
    L65:
        if (r115.f401825a.getAdapter() == null) goto L123;
        int r118 = r115.f401825a.getMinFlingVelocity();
        if (Math.abs(r104) <= r118) goto L70;
    L71:
        boolean r119 = r116 instanceof u.b;
        if (r119 == false) goto L119;
        if (r119 == true) goto L76;
        i0 r120 = null;
    L77:
        if (r120 == null) goto L119;
        com.obric.oui.orecyclerview.widget.v r121 = (com.obric.oui.orecyclerview.widget.v) r115;
        if (r119 == false) goto L110;
        int r122 = r116.A();
        if (r122 == 0) goto L110;
        View r123 = r121.c(r116);
        if (r123 == null) goto L110;
        int r124 = k.F(r123);
        if (r124 == (-1)) goto L110;
        int r125 = r122 - 1;
        PointF r126 = ((u.b) r116).computeScrollVectorForPosition(r125);
        if (r126 == null) goto L110;
        if (r116.c() == false) goto L99;
        int r127 = r121.e(r116, r121.g(r116), r103, 0);
        if (r126.x >= 0.0f) goto L101;
        r127 = -r127;
    L101:
        if (r116.d() == false) goto L105;
        int r128 = r121.e(r116, r121.h(r116), 0, r104);
        if (r126.y >= 0.0f) goto L107;
        r128 = -r128;
    L107:
        if (r116.d() == false) goto L109;
        r127 = r128;
    L109:
        if (r127 == 0) goto L110;
        int r129 = r124 + r127;
        if (r129 >= 0) goto L114;
        r129 = 0;
    L114:
        if (r129 >= r122) goto L117;
        r125 = r129;
    L117:
        int r130 = -1;
    L118:
        if (r125 == r130) goto L119;
        r120.f401692a = r125;
        r116.s0(r120);
        boolean r131 = true;
    L121:
        if (r131 == false) goto L123;
        r117 = true;
        goto L124
    L105:
        r128 = 0;
        goto L107
    L99:
        r127 = 0;
    L110:
        r130 = -1;
        r125 = -1;
        goto L118
    L76:
        r120 = new i0(r115, r115.f401825a.getContext());
    L119:
        r131 = false;
        goto L121
    L70:
        if (Math.abs(r103) <= r118) goto L123;
    L127:
        int r132 = r101;
        if (r113 == false) goto L138;
        if (r102 == false) goto L131;
        r132 = (r101 ? 1 : 0) | 2;
    L131:
        startNestedScroll(r132, 1);
        int r133 = this.T;
        int r134 = Math.max(-r133, Math.min(r103, r133));
        int r135 = this.T;
        int r136 = Math.max(-r135, Math.min(r104, r135));
        x r137 = this.f401618k0;
        r137.f401726g.setScrollState(2);
        r137.f401721b = 0;
        r137.f401720a = 0;
        Interpolator r138 = r137.f401723d;
        c r139 = G2;
        if (r138 == r139) goto L134;
        r137.f401723d = r139;
        r137.f401722c = new OverScrollerAdapter(r137.f401726g.getContext(), r139);
    L134:
        r137.f401722c.d().fling(0, 0, r134, r136, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r137.b();
        return true;
    L138:
        return false;
    L58:
        r113 = true;
        goto L59
    L136:
        return false;
    L17:
        if (Math.abs(r111) < this.S) goto L20;
        r104 = r111;
        goto L21
    L11:
        if (Math.abs(r110) < this.S) goto L14;
        r103 = r110;
        goto L15
    }

    public final void Q(y r100, ItemAnimator.c r101) {
        boolean r102 = false;
        int r103 = (r100.f401737j & (-8193)) | 0;
        r100.f401737j = r103;
        if (this.L0.f401713h == true) goto L5;
    L13:
        j0 r104 = this.f401609f;
        j0.a r105 = r104.f401835a.get(r100);
        if (r105 != null) goto L16;
        r105 = j0.a.a();
        r104.f401835a.put(r100, r105);
    L16:
        r105.f401839b = r101;
        r105.f401838a |= 4;
        return;
    L5:
        if ((r103 & 2) == 0) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L13;
        if (r100.i() == true) goto L13;
        if (r100.o() == true) goto L13;
        this.f401620l.getClass();
        this.f401609f.f401836b.put(r100.f401730c, r100);
        goto L13
    }

    public final void S(View r110, View r111) {
        if (r111 == null) goto L4;
        View r100 = r111;
    L5:
        this.f401615i.set(0, 0, r100.getWidth(), r100.getHeight());
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LayoutParams) == false) goto L10;
        LayoutParams r102 = (LayoutParams) r101;
        if (r102.f401653c == true) goto L10;
        Rect r103 = r102.f401652b;
        Rect r104 = this.f401615i;
        r104.left -= r103.left;
        r104.right += r103.right;
        r104.top -= r103.top;
        r104.bottom += r103.bottom;
    L10:
        if (r111 == null) goto L12;
        offsetDescendantRectToMyCoords(r111, this.f401615i);
        offsetRectIntoDescendantCoords(r110, this.f401615i);
    L12:
        k r105 = this.f401621m;
        Rect r106 = this.f401615i;
        boolean r107 = !this.f401631u;
        if (r111 != null) goto L15;
        boolean r112 = true;
    L16:
        r105.e0(this, r110, r106, r107, r112);
        return;
    L15:
        r112 = false;
        goto L16
    L4:
        r100 = r110;
        goto L5
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return getScrollingChildHelper().dispatchNestedPreFling(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View r110, int r111) {
        this.f401621m.getClass();
        boolean r100 = false;
        if (this.f401620l != null) goto L5;
    L11:
        boolean r101 = false;
    L12:
        FocusFinder r102 = FocusFinder.getInstance();
        if (r101 == false) goto L49;
        if (r111 == 2) goto L17;
        if (r111 != 1) goto L49;
    L17:
        if (this.f401621m.d() == false) goto L24;
        if (r111 != 2) goto L20;
        int r103 = 130;
    L22:
        if (r102.findNextFocus(this, r110, r103) != null) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
    L43:
        if (r104 == false) goto L48;
        n();
        if (v(r110) != null) goto L47;
        return null;
    L47:
        Y();
        this.f401621m.N(r110, r111, this.f401603b, this.L0);
        Z(false);
    L48:
        View r105 = r102.findNextFocus(this, r110, r111);
    L57:
        if (r105 != null) goto L59;
    L66:
        if (r105 == null) goto L136;
        if (r105 == this) goto L136;
        if (r105 == r110) goto L136;
        if (v(r105) == null) goto L137;
        if (r110 != null) goto L76;
    L135:
        r100 = true;
        goto L137
    L76:
        if (v(r110) == null) goto L135;
        this.f401615i.set(0, 0, r110.getWidth(), r110.getHeight());
        this.f401616j.set(0, 0, r105.getWidth(), r105.getHeight());
        offsetDescendantRectToMyCoords(r110, this.f401615i);
        offsetDescendantRectToMyCoords(r105, this.f401616j);
        if (ViewCompat.getLayoutDirection(this.f401621m.f401662b) != 1) goto L81;
        int r106 = -1;
    L82:
        Rect r112 = this.f401615i;
        int r113 = r112.left;
        Rect r114 = this.f401616j;
        int r107 = r114.left;
        if (r113 < r107) goto L87;
        if (r112.right <= r107) goto L87;
    L89:
        int r108 = r112.right;
        int r115 = r114.right;
        if (r108 > r115) goto L92;
        if (r113 >= r115) goto L92;
    L94:
        int r109 = 0;
    L95:
        int r116 = r112.top;
        int r117 = r114.top;
        if (r116 < r117) goto L100;
        if (r112.bottom <= r117) goto L100;
    L102:
        int r118 = r112.bottom;
        int r119 = r114.bottom;
        if (r118 > r119) goto L105;
        if (r116 >= r119) goto L105;
    L107:
        byte r120 = 0;
    L108:
        if (r111 == 1) goto L131;
        if (r111 == 2) goto L126;
        if (r111 == 17) goto L124;
        if (r111 != 33) goto L113;
        if (r120 >= 0) goto L136;
    L113:
        if (r111 != 66) goto L115;
        if (r109 <= 0) goto L136;
    L115:
        if (r111 != 130) goto L119;
        if (r120 <= 0) goto L136;
    L119:
        throw new IllegalArgumentException("Invalid direction: " + r111 + t());
    L124:
        if (r109 >= 0) goto L136;
    L126:
        if (r120 > 0) goto L135;
        if (r120 != 0) goto L136;
        if ((r109 * r106) <= 0) goto L136;
    L131:
        if (r120 < 0) goto L135;
        if (r120 != 0) goto L136;
        if ((r109 * r106) >= 0) goto L136;
    L105:
        if (r116 <= r117) goto L107;
        r120 = -1;
    L100:
        if (r112.bottom >= r114.bottom) goto L102;
        r120 = 1;
    L92:
        if (r113 <= r107) goto L94;
        r109 = -1;
    L87:
        if (r112.right >= r114.right) goto L89;
        r109 = 1;
        goto L95
    L81:
        r106 = 1;
    L137:
        if (r100 == false) goto L140;
        return r105;
    L140:
        return super.focusSearch(r110, r111);
    L136:
        r100 = false;
        goto L137
    L59:
        if (r105.hasFocusable() == true) goto L66;
        if (getFocusedChild() == null) goto L63;
        S(r105, null);
        return r110;
    L63:
        return super.focusSearch(r110, r111);
    L27:
        if (this.f401621m.c() == false) goto L43;
        if (ViewCompat.getLayoutDirection(this.f401621m.f401662b) != 1) goto L31;
        boolean r121 = true;
    L32:
        if (r111 != 2) goto L34;
        boolean r122 = true;
    L36:
        if ((r121 ^ r122) == false) goto L38;
        int r123 = 66;
    L40:
        if (r102.findNextFocus(this, r110, r123) != null) goto L42;
        r104 = true;
        goto L43
    L42:
        r104 = false;
        goto L43
    L38:
        r123 = 17;
        goto L40
    L34:
        r122 = false;
        goto L36
    L31:
        r121 = false;
        goto L32
    L20:
        r103 = 33;
    L24:
        r104 = false;
    L49:
        View r124 = r102.findNextFocus(this, r110, r111);
        if (r124 != null) goto L56;
        if (r101 == false) goto L56;
        n();
        if (v(r110) != null) goto L55;
        return null;
    L55:
        Y();
        r105 = this.f401621m.N(r110, r111, this.f401603b, this.L0);
        Z(false);
    L56:
        r105 = r124;
        goto L57
    L5:
        if (this.f401621m == null) goto L11;
        if (G() == true) goto L11;
        if (this.f401635x == true) goto L11;
        r101 = true;
        goto L12
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return super.getChildDrawingOrder(r100, r101);
    }

    public final void o(int r100, int r101) {
        setMeasuredDimension(k.f(r100, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), k.f(r101, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        k r102 = this.f401621m;
        if (r102 != null) goto L6;
        o(r100, r101);
        return;
    L6:
        boolean r103 = false;
        if (r102.I() == false) goto L26;
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        this.f401621m.f401662b.o(r100, r101);
        if (r104 != 1073741824) goto L12;
        if (r105 != 1073741824) goto L12;
        r103 = true;
    L12:
        this.S1 = r103;
        if (r103 == false) goto L15;
        return;
    L15:
        if (this.f401620l != null) goto L18;
        return;
    L18:
        if (this.L0.f401709d != 1) goto L20;
        q();
    L20:
        this.f401621m.l0(r100, r101);
        this.L0.f401714i = true;
        r();
        this.f401621m.n0(r100, r101);
        if (this.f401621m.q0() == false) goto L23;
        this.f401621m.l0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.L0.f401714i = true;
        r();
        this.f401621m.n0(r100, r101);
    L23:
        this.T1 = getMeasuredWidth();
        this.V1 = getMeasuredHeight();
        return;
    L26:
        if (this.f401630t == false) goto L30;
        this.f401621m.f401662b.o(r100, r101);
        return;
    L30:
        if (this.A == false) goto L37;
        Y();
        K();
        O();
        L(true);
        v r106 = this.L0;
        if (r106.f401716k == false) goto L34;
        r106.f401712g = true;
    L35:
        this.A = false;
        Z(false);
    L40:
        Adapter r107 = this.f401620l;
        if (r107 == null) goto L43;
        v r108 = this.L0;
        r108.f401710e = r107.a();
    L44:
        Y();
        this.f401621m.f401662b.o(r100, r101);
        Z(false);
        this.L0.f401712g = false;
        return;
    L43:
        this.L0.f401710e = 0;
        goto L44
    L34:
        this.f401607d.c();
        this.L0.f401712g = false;
        goto L35
    L37:
        if (this.L0.f401716k == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r100, Rect r101) {
        if (G() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View r100, boolean r101) {
        y r102 = E(r100);
        if (r102 == null) goto L13;
        if (r102.k() == false) goto L8;
        r102.f401737j &= -257;
    L14:
        r100.clearAnimation();
        E(r100);
        Adapter r103 = this.f401620l;
        super.removeDetachedView(r100, r101);
        return;
    L8:
        if (r102.o() == true) goto L14;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r102 + t());
    L13:
        if (f401596h2 == false) goto L14;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r100 + t());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r100, View r101) {
        u r102 = this.f401621m.f401665e;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
    L13:
        if (r103 == true) goto L16;
        if (r101 == null) goto L16;
        S(r100, r101);
    L16:
        super.requestChildFocus(r100, r101);
        return;
    L10:
        if (G() == true) goto L13;
        r103 = false;
        goto L13
    L5:
        if (r102.f401696e == false) goto L7;
        r104 = true;
        goto L8
    }

    public final void s(int r100, int r101) {
        this.F++;
        int r102 = getScrollX();
        int r103 = getScrollY();
        onScrollChanged(r102, r103, r102 - r100, r103 - r101);
        o r104 = this.P0;
        if (r104 == null) goto L5;
        r104.b(this, r100, r101);
    L5:
        List<o> r105 = this.V0;
        if (r105 == null) goto L10;
        int r106 = ((ArrayList) r105).size() - 1;
    L8:
        if (r106 < 0) goto L10;
        ((o) ListProtector.get(this.V0, r106)).b(this, r100, r101);
        r106 = r106 - 1;
    L10:
        this.F--;
    }

    @Override // android.view.View
    public final void scrollBy(int r100, int r101) {
        k r102 = this.f401621m;
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.f401635x == false) goto L8;
        return;
    L8:
        boolean r103 = r102.c();
        boolean r104 = this.f401621m.d();
        if (r103 == true) goto L12;
        if (r104 == true) goto L12;
        return;
    L12:
        if (r103 == true) goto L15;
        r100 = 0;
    L15:
        if (r104 == true) goto L18;
        r101 = 0;
    L18:
        U(r100, r101, null, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r100, int r101) {
        return getScrollingChildHelper().startNestedScroll(r100, r101);
    }

    public RecyclerView(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        this.f401602a = new s(this);
        this.f401603b = new q(this);
        this.f401609f = new j0();
        this.f401613h = new a(this);
        this.f401615i = new Rect();
        this.f401616j = new Rect();
        this.f401617k = new RectF();
        this.f401623o = new ArrayList();
        this.f401624p = new ArrayList();
        this.f401627q = new ArrayList();
        this.f401632v = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.I = new com.obric.oui.orecyclerview.widget.p();
        this.f401601J = 0;
        this.K = -1;
        this.U = Float.MIN_VALUE;
        this.V = Float.MIN_VALUE;
        this.W = true;
        this.f401618k0 = new x(this);
        if (E2 == false) goto L5;
        com.obric.oui.orecyclerview.widget.s.b r100 = new com.obric.oui.orecyclerview.widget.s.b();
    L6:
        this.H0 = r100;
        this.L0 = new v();
        this.f401604b1 = false;
        this.f401611g1 = false;
        i r101 = new i(this);
        this.f401614h1 = r101;
        this.f401619k1 = false;
        this.f401633v1 = new int[2];
        this.f401638y1 = new int[2];
        this.G1 = new int[2];
        this.H1 = new int[2];
        this.L1 = new ArrayList();
        this.M1 = true;
        this.P1 = true;
        this.Q1 = new b(this);
        this.T1 = 0;
        this.V1 = 0;
        this.f401612g2 = new d(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r102 = ViewConfiguration.get(r210);
        this.Q = r102.getScaledTouchSlop();
        this.U = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r102, r210);
        this.V = ViewConfigurationCompat.getScaledVerticalScrollFactor(r102, r210);
        this.S = r102.getScaledMinimumFlingVelocity();
        this.T = r102.getScaledMaximumFlingVelocity();
        Resources r103 = r210.getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        if (getOverScrollMode() != 2) goto L9;
        boolean r105 = true;
    L10:
        setWillNotDraw(r105);
        this.I.f401643a = r101;
        this.f401607d = new com.obric.oui.orecyclerview.widget.a(new e0(this));
        this.f401608e = new com.obric.oui.orecyclerview.widget.g(new d0(this));
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L14;
        ViewCompat.setImportantForAutofill(this, 8);
    L14:
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L16;
        ViewCompat.setImportantForAccessibility(this, 1);
    L16:
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r106 = r210.obtainStyledAttributes(r211, new int[]{R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, com.larus.nova.R.attr.fastScrollEnabled, com.larus.nova.R.attr.fastScrollHorizontalThumbDrawable, com.larus.nova.R.attr.fastScrollHorizontalTrackDrawable, com.larus.nova.R.attr.fastScrollVerticalThumbDrawable, com.larus.nova.R.attr.fastScrollVerticalTrackDrawable, com.larus.nova.R.attr.layoutManager, com.larus.nova.R.attr.reverseLayout, com.larus.nova.R.attr.spanCount, com.larus.nova.R.attr.stackFromEnd}, r212, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r210, new int[]{R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, com.larus.nova.R.attr.fastScrollEnabled, com.larus.nova.R.attr.fastScrollHorizontalThumbDrawable, com.larus.nova.R.attr.fastScrollHorizontalTrackDrawable, com.larus.nova.R.attr.fastScrollVerticalThumbDrawable, com.larus.nova.R.attr.fastScrollVerticalTrackDrawable, com.larus.nova.R.attr.layoutManager, com.larus.nova.R.attr.reverseLayout, com.larus.nova.R.attr.spanCount, com.larus.nova.R.attr.stackFromEnd}, r211, r106, r212, 0);
        String r110 = r106.getString(8);
        if (r106.getInt(2, -1) != (-1)) goto L19;
        setDescendantFocusability(262144);
    L19:
        this.f401610g = r106.getBoolean(1, true);
        if (r106.getBoolean(3, false) == false) goto L29;
        StateListDrawable r107 = (StateListDrawable) r106.getDrawable(6);
        Drawable r108 = r106.getDrawable(7);
        StateListDrawable r109 = (StateListDrawable) r106.getDrawable(4);
        Drawable r111 = r106.getDrawable(5);
        if (r107 == null) goto L28;
        if (r108 == null) goto L28;
        if (r109 == null) goto L28;
        if (r111 == null) goto L28;
        Resources r112 = getContext().getResources();
        int r113 = 4;
        char r114 = 2;
        new com.obric.oui.orecyclerview.widget.r(this, r107, r108, r109, r111, r112.getDimensionPixelSize(com.larus.nova.R.dimen.fastscroll_default_thickness), r112.getDimensionPixelSize(com.larus.nova.R.dimen.fastscroll_minimum_range), r112.getDimensionPixelOffset(com.larus.nova.R.dimen.fastscroll_margin));
    L30:
        r106.recycle();
        if (r110 == null) goto L71;
        String r115 = r110.trim();
        if (r115.isEmpty() == true) goto L71;
        if (r115.charAt(0) != '.') goto L38;
        r115 = r210.getPackageName() + r115;
    L77:
    L56:
        e = move-exception;
        throw new IllegalStateException(r211.getPositionDescription() + ": Class is not a LayoutManager " + r115, e);
    L68:
        e = move-exception;
        throw new IllegalStateException(r211.getPositionDescription() + ": Unable to find LayoutManager " + r115, e);
    L59:
        e = move-exception;
        throw new IllegalStateException(r211.getPositionDescription() + ": Cannot access non-public constructor " + r115, e);
    L62:
        e = move-exception;
        throw new IllegalStateException(r211.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r115, e);
    L65:
        e = move-exception;
        throw new IllegalStateException(r211.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r115, e);
    L42:
        if (isInEditMode() == false) goto L44;
        ClassLoader r116 = getClass().getClassLoader();     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
    L45:
        Class r117 = a(r115, r116).asSubclass(k.class);     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        Constructor r118 = r117.getConstructor(F2);     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        Object[] r119 = new Object[r113];     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        r119[0] = r210;     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        r119[1] = r211;     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        r119[r114] = Integer.valueOf(r212);     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        r119[3] = 0;     // Catch: NoSuchMethodException -> L48 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
    L52:
        r118.setAccessible(true);     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        setLayoutManager((k) r118.newInstance(r119));     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
    L48:
        e = move-exception;
        r118 = r117.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L53 ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        r119 = null;
    L53:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        throw new IllegalStateException(r211.getPositionDescription() + ": Error creating LayoutManager " + r115, e);     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
    L44:
        r116 = r210.getClassLoader();     // Catch: ClassCastException -> L56 IllegalAccessException -> L59 InstantiationException -> L62 InvocationTargetException -> L65 ClassNotFoundException -> L68
        goto L45
    L38:
        if (r115.contains(".") == true) goto L77;
        r115 = RecyclerView.class.getPackage().getName() + '.' + r115;
    L71:
        int[] r120 = f401598v2;
        TypedArray r121 = r210.obtainStyledAttributes(r211, r120, r212, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r210, r120, r211, r121, r212, 0);
        boolean r122 = r121.getBoolean(0, true);
        r121.recycle();
        setNestedScrollingEnabled(r122);
        PoolingContainer.setPoolingContainer(this, true);
        this.f401605b2 = new f0(this);
        return;
    L28:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + t());
    L29:
        r113 = 4;
        r114 = 2;
        goto L30
    L9:
        r105 = false;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    public static /* synthetic */ void g(RecyclerView r100, int r101, int r102) {
        r100.setMeasuredDimension(r101, r102);
    }

    public final void J(int r100, int r110, boolean r111) {
        int r101 = r100 + r110;
        int r102 = this.f401608e.h();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L21;
        y r104 = E(this.f401608e.g(r103));
        if (r104 == null) goto L20;
        if (r104.o() == true) goto L20;
        int r105 = r104.f401730c;
        if (r105 >= r101) goto L12;
        if (r105 < r100) goto L20;
        if (f401597p2 == false) goto L19;
        r104.toString();
    L19:
        r104.b(8);
        r104.l(-r110, r111);
        r104.f401730c = r100 - 1;
        this.L0.f401711f = true;
        goto L20
    L12:
        if (f401597p2 == false) goto L14;
        r104.toString();
    L14:
        r104.l(-r110, r111);
        this.L0.f401711f = true;
    L20:
        r103 = r103 + 1;
        goto L4
    L21:
        q r106 = this.f401603b;
        int r107 = r106.f401685c.size();
    L22:
        r107 = r107 - 1;
        if (r107 < 0) goto L34;
        y r108 = (y) ListProtector.get(r106.f401685c, r107);
        if (r108 == null) goto L22;
        int r109 = r108.f401730c;
        if (r109 >= r101) goto L29;
        if (r109 < r100) goto L22;
        r108.b(8);
        r106.g(r107);
        goto L22
    L29:
        if (f401597p2 == false) goto L31;
        r108.toString();
    L31:
        r108.l(-r110, r111);
        goto L22
    L34:
        requestLayout();
    }

    public final void V(int r100, int r110, int[] r111) {
        Y();
        K();
        TraceCompat.beginSection("RV Scroll");
        u(this.L0);
        if (r100 == 0) goto L5;
        int r101 = this.f401621m.h0(r100, this.f401603b, this.L0);
    L6:
        if (r110 == 0) goto L8;
        int r112 = this.f401621m.j0(r110, this.f401603b, this.L0);
    L9:
        TraceCompat.endSection();
        int r102 = this.f401608e.e();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L21;
        View r104 = this.f401608e.d(r103);
        y r105 = D(r104);
        if (r105 == null) goto L20;
        y r106 = r105.f401736i;
        if (r106 == null) goto L20;
        View r107 = r106.f401728a;
        int r108 = r104.getLeft();
        int r109 = r104.getTop();
        if (r108 == r107.getLeft()) goto L18;
    L19:
        r107.layout(r108, r109, r107.getWidth() + r108, r107.getHeight() + r109);
        goto L20
    L18:
        if (r109 != r107.getTop()) goto L19;
    L20:
        r103 = r103 + 1;
        goto L10
    L21:
        L(true);
        Z(false);
        if (r111 == null) goto L30;
        r111[0] = r101;
        r111[1] = r112;
        return;
    L30:
        return;
    L8:
        r112 = 0;
        goto L9
    L5:
        r101 = 0;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r100, int r101, int r102) {
        k r103 = this.f401621m;
        if (r103 == null) goto L5;
        r103.getClass();
    L5:
        super.addFocusables(r100, r101, r102);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return getScrollingChildHelper().dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        return super.drawChild(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
        return this.f401621m.e0(this, r100, r101, r102, false);
    }

    public static /* synthetic */ void b(RecyclerView r100, View r101, int r102, ViewGroup.LayoutParams r103) {
        r100.attachViewToParent(r101, r102, r103);
    }

    public static /* synthetic */ void e(RecyclerView r100, View r101, int r102, ViewGroup.LayoutParams r103) {
        r100.attachViewToParent(r101, r102, r103);
    }

    public final boolean U(int r110, int r111, MotionEvent r112, int r210) {
        n();
        if (this.f401620l == null) goto L5;
        int[] r100 = this.H1;
        r100[0] = 0;
        r100[1] = 0;
        V(r110, r111, r100);
        int[] r101 = this.H1;
        int r102 = r101[0];
        int r103 = r101[1];
        int r113 = r110 - r102;
        int r114 = r111 - r103;
        int r115 = r103;
        int r116 = r102;
    L7:
        if (this.f401624p.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r104 = this.H1;
        r104[0] = 0;
        r104[1] = 0;
        dispatchNestedScroll(r116, r115, r113, r114, this.f401638y1, r210, r104);
        int[] r105 = this.H1;
        int r106 = r105[0];
        int r117 = r113 - r106;
        int r107 = r105[1];
        int r118 = r114 - r107;
        if (r106 != 0) goto L14;
        if (r107 != 0) goto L14;
        boolean r108 = false;
    L15:
        int r109 = this.O;
        int[] r119 = this.f401638y1;
        int r120 = r119[0];
        this.O = r109 - r120;
        int r121 = this.P;
        int r122 = r119[1];
        this.P = r121 - r122;
        int[] r123 = this.G1;
        r123[0] = r123[0] + r120;
        r123[1] = r123[1] + r122;
        if (getOverScrollMode() == 2) goto L39;
        if (r112 == null) goto L39;
        if (MotionEventCompat.isFromSource(r112, 8194) == true) goto L39;
        r112.getX();
        float r124 = r117;
        r112.getY();
        float r125 = r118;
        if (r124 != 0.0f) goto L23;
        boolean r126 = false;
    L29:
        if (r125 != 0.0f) goto L31;
    L35:
        if (r126 == true) goto L38;
        if (r124 != 0.0f) goto L38;
        if (r125 == 0.0f) goto L39;
    L38:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L39
    L31:
        if (this.H != null) goto L34;
        com.obric.oui.orecyclerview.base.a r127 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.H = r127;
        r127.f401531a = getHeight() / r127.f401539i.density;
    L34:
        this.H.c(r125, false, false);
        r126 = true;
        goto L35
    L23:
        if (this.G != null) goto L26;
        com.obric.oui.orecyclerview.base.a r128 = new com.obric.oui.orecyclerview.base.a(getContext());
        this.G = r128;
        r128.f401531a = getWidth() / r128.f401539i.density;
    L26:
        this.G.c(r124, false, false);
        r126 = true;
    L39:
        if (r116 != 0) goto L41;
        if (r115 != 0) goto L41;
    L43:
        if (awakenScrollBars() == true) goto L45;
        invalidate();
    L45:
        if (r108 == true) goto L51;
        if (r116 != 0) goto L52;
        if (r115 != 0) goto L53;
        return false;
    L53:
        return true;
    L52:
        return true;
    L51:
        return true;
    L41:
        s(r116, r115);
    L14:
        r108 = true;
        goto L15
    L5:
        r113 = 0;
        r114 = 0;
        r115 = 0;
        r116 = 0;
        goto L7
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        if (r101 != r103) goto L5;
        return;
    L5:
        this.H = null;
        this.G = null;
    }

    public final void X(int r100, int r101, Interpolator r102, int r103, boolean r104) {
        k r105 = this.f401621m;
        if (r105 != null) goto L6;
        return;
    L6:
        if (this.f401635x == false) goto L8;
        return;
    L8:
        int r106 = 0;
        if (r105.c() == true) goto L12;
        r100 = 0;
    L12:
        if (this.f401621m.d() == true) goto L14;
        r101 = 0;
    L14:
        if (r100 != 0) goto L17;
        if (r101 != 0) goto L17;
        return;
    L17:
        if (r103 == Integer.MIN_VALUE) goto L21;
        if (r103 > 0) goto L21;
        boolean r107 = false;
    L22:
        if (r107 == false) goto L30;
        if (r104 == false) goto L29;
        if (r100 == 0) goto L26;
        r106 = 1;
    L26:
        if (r101 == 0) goto L28;
        r106 = r106 | 2;
    L28:
        startNestedScroll(r106, 1);
    L29:
        this.f401618k0.c(r100, r101, r103, r102);
        return;
    L30:
        scrollBy(r100, r101);
        return;
    L21:
        r107 = true;
        goto L22
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return getScrollingChildHelper().dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        TraceCompat.beginSection("RV OnLayout");
        p();
        TraceCompat.endSection();
        this.f401631u = true;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return getScrollingChildHelper().dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113, int r114, int[] r115) {
        getScrollingChildHelper().dispatchNestedScroll(r100, r110, r111, r112, r113, r114, r115);
    }
}
