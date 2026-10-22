package com.ss.android.lark.inline.ai.creationai;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes36.dex */
public final class CreationAIDragView {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static int f426912h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static boolean f426913i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static int f426914j0;
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public Integer F;
    public boolean G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f426915J;
    public ObjectAnimator K;
    public ObjectAnimator L;
    public boolean M;
    public Boolean N;
    public boolean O;
    public final int P;
    public final int Q;
    public Boolean R;
    public boolean S;
    public Runnable T;
    public boolean U;
    public boolean V;
    public final View W;
    public final View X;
    public boolean Y;
    public final com.ss.android.lark.inline.ai.creationai.i Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f426916a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.creationai.j f426917a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f426918b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Function0<Unit> f426919b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f426920c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.creationai.b f426921c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wlb.d f426922d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final o f426923d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f426924e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final int f426925e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f426926f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final float f426927f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f426928g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.creationai.a f426929g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f426930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vlb.d f426931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f426932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f426933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f426934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f426935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f426936n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f426937o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f426938p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f426939q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f426940r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f426941s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f426942t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f426943u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f426944v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f426945w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f426946x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f426947y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f426948z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/CreationAIDragView$AdjustTopSource;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_CHANGE", "DRAG", "KEYBOARD_CHANGE", "CONTAINER_CHANGE", "CONTENT_HEIGHT_CHANGE", "SET_ADJUST_CHANGE", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AdjustTopSource extends Enum<AdjustTopSource> {
        public static final AdjustTopSource CONTAINER_CHANGE = null;
        public static final AdjustTopSource CONTENT_HEIGHT_CHANGE = null;
        public static final AdjustTopSource DRAG = null;
        public static final AdjustTopSource KEYBOARD_CHANGE = null;
        public static final AdjustTopSource SET_ADJUST_CHANGE = null;
        public static final AdjustTopSource VIEW_CHANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdjustTopSource[] f426949a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426950b = null;

        public static EnumEntries<AdjustTopSource> getEntries() {
            return f426950b;
        }

        static {
            AdjustTopSource r100 = new AdjustTopSource("VIEW_CHANGE", 0);
            VIEW_CHANGE = r100;
            AdjustTopSource r101 = new AdjustTopSource("DRAG", 1);
            DRAG = r101;
            AdjustTopSource r102 = new AdjustTopSource("KEYBOARD_CHANGE", 2);
            KEYBOARD_CHANGE = r102;
            AdjustTopSource r103 = new AdjustTopSource("CONTAINER_CHANGE", 3);
            CONTAINER_CHANGE = r103;
            AdjustTopSource r104 = new AdjustTopSource("CONTENT_HEIGHT_CHANGE", 4);
            CONTENT_HEIGHT_CHANGE = r104;
            AdjustTopSource r105 = new AdjustTopSource("SET_ADJUST_CHANGE", 5);
            SET_ADJUST_CHANGE = r105;
            AdjustTopSource[] r110 = {r100, r101, r102, r103, r104, r105};
            f426949a = r110;
            f426950b = EnumEntriesKt.enumEntries(r110);
        }

        public static AdjustTopSource[] values() {
            return (AdjustTopSource[]) f426949a.clone();
        }

        public static AdjustTopSource valueOf(String r100) {
            return (AdjustTopSource) r27.a.a(AdjustTopSource.class, r100);
        }

        public AdjustTopSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f426951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f426952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f426953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426954d;

        public a(CreationAIDragView r100) {
            this.f426954d = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r110, "event");
            if (this.f426954d.C == false) goto L5;
        L8:
            int r101 = r110.getAction();
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L12;
            long r102 = System.currentTimeMillis();
            float r103 = r110.getRawX();
            float r104 = r110.getRawY();
            float r111 = r110.getY();
            float r105 = this.f426954d.f426920c.getY();
            Log.i("CreationAIDragView", "background touch up: " + r102 + ", endRawX = " + r103 + ", endRawY = " + r104 + ", endY = " + r111 + ", panelViewTop = " + r105);
            if (r111 < r105) goto L18;
        L25:
            return true;
        L18:
            if ((r102 - this.f426951a) >= 200) goto L25;
            if (Math.abs(r103 - this.f426952b) >= n0.a(20)) goto L25;
            if (Math.abs(r104 - this.f426953c) >= n0.a(20)) goto L25;
            Log.i("CreationAIDragView", "click outside");
            this.f426954d.f426924e.d();
            goto L25
        L12:
            if (r101 != 3) goto L25;
            Log.i("CreationAIDragView", "background touch cancel");
            goto L25
        L24:
            this.f426951a = System.currentTimeMillis();
            this.f426952b = r110.getRawX();
            this.f426953c = r110.getRawY();
            Log.i("CreationAIDragView", "background touch down: " + this.f426951a + ", startRawX = " + this.f426952b + ", startRawY = " + this.f426953c);
            goto L25
        L5:
            if (r110.getY() >= this.f426954d.f426920c.getY()) goto L8;
            return false;
        }
    }

    public static final class b {
    }

    public final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f426955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426957c;

        public c(CreationAIDragView r100) {
            this.f426957c = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r111, "event");
            int r112 = r111.getAction();
            boolean r100 = false;
            if (r112 == 0) goto L35;
            if (r112 != 1) goto L6;
        L22:
            this.f426957c.D = false;
            Log.i("CreationAIDragView", "touch up/cancel y = " + r111.getRawY() + ", rawY = " + r111.getRawY());
            if ((r111.getRawY() - this.f426955a) <= n0.a(60)) goto L26;
            this.f426957c.f426924e.onClose();
            return true;
        L26:
            CreationAIDragView r113 = this.f426957c;
            if (r113.V == false) goto L29;
            r113.f426920c.setTranslationY(0.0f);
        L29:
            CreationAIDragView r114 = this.f426957c;
            if (r114.G == true) goto L32;
        L42:
            return true;
        L32:
            if ((r111.getRawY() - this.f426955a) <= n0.a(60)) goto L34;
            r100 = true;
        L34:
            r114.i(r100, true, AdjustTopSource.DRAG);
            goto L42
        L6:
            if (r112 != 2) goto L8;
            Log.d("CreationAIDragView", "touch move y = " + r111.getY(0) + ", rawY = " + r111.getRawY());
            CreationAIDragView r115 = this.f426957c;
            if (r115.G == true) goto L14;
            r115.D = false;
            return false;
        L14:
            int r116 = (int) (r111.getRawY() - this.f426955a);
            if (r116 >= 0) goto L17;
            return false;
        L17:
            CreationAIDragView r101 = this.f426957c;
            int r117 = this.f426956b + r116;
            r101.E = r117;
            if ((r101.f426932j instanceof wlb.g) == false) goto L20;
            int r102 = Math.max(r101.I, r117);
        L21:
            CreationAIDragView.f(r101, r102, false, false, AdjustTopSource.DRAG, 12);
            goto L42
        L20:
            r102 = r117;
            goto L21
        L8:
            if (r112 == 3) goto L22;
        L35:
            CreationAIDragView r118 = this.f426957c;
            if (r118.H == false) goto L38;
            return false;
        L38:
            r118.D = true;
            r118.G = true;
            ValueAnimator r119 = r118.f426937o;
            if (r119 == null) goto L41;
            r119.cancel();
        L41:
            this.f426955a = r111.getRawY();
            int r120 = this.f426957c.f426920c.getTop() + ((int) this.f426957c.f426920c.getTranslationY());
            this.f426956b = r120;
            this.f426957c.E = r120;
            Log.i("CreationAIDragView", "touch down y = " + r111.getY(0) + ", rawY = " + r111.getRawY() + ", panelInitTop = " + this.f426956b);
            goto L42
        }
    }

    public interface d {
        void a(int r100);

        void b(boolean r100);

        void c();

        void d();

        void onClose();
    }

    public final class e implements NSPConstraintLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f426958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f426960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f426962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f426963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f426964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f426965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f426966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426967j;

        public final void d() {
            boolean r100 = true;
            if (this.f426963f == false) goto L11;
            if (this.f426962e == true) goto L7;
        L9:
            boolean r101 = false;
        L23:
            if (r101 == false) goto L29;
            CreationAIDragView r102 = this.f426967j;
            if (r102.B == true) goto L27;
        L32:
            int r103 = this.f426961d;
            if (r101 == true) goto L35;
        L36:
            CreationAIDragView r104 = this.f426967j;
            if ((r104.f426932j instanceof wlb.g) == true) goto L39;
        L41:
            int r105 = 0;
        L42:
            int r106 = r103 + r105;
            if (r101 == false) goto L55;
            CreationAIDragView r107 = this.f426967j;
            if (r107.B == true) goto L55;
            if ((r107.f426932j instanceof wlb.g) == false) goto L50;
            int r108 = r107.I;
        L52:
            if (r107.k() == false) goto L54;
            int r109 = ((this.f426964g - r108) - this.f426967j.l()) + this.f426967j.P;
        L56:
            CreationAIDragView r110 = this.f426967j;
            float r111 = r109;
            int r112 = r110.f426920c.getHeight();
            float r113 = r110.f426920c.getTranslationY();
            Log.i("CreationAIDragView", "doNestedScrollRebound, currentHeight = " + r112 + ", currentTranslationY = " + r113 + ", targetHeight = " + r106 + ", targetTranslationY = " + r111 + ", currentTop = " + r110.f426920c.getY());
            if (r112 == r106) goto L59;
        L64:
            ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r114.addUpdateListener(new com.ss.android.lark.inline.ai.creationai.e(r112, r106, r110, r113, r111));
            r114.setDuration(200);
            Intrinsics.checkNotNull(r114);
            r114.addListener(new com.ss.android.lark.inline.ai.creationai.f(r110, r101));
            r114.start();
            return;
        L59:
            if (r113 == r111) goto L62;
            r100 = false;
        L62:
            if (r100 == false) goto L64;
            Log.i("CreationAIDragView", "doNestedScrollRebound, target pos is the same as current, so return");
            return;
        L54:
            r109 = this.f426964g - r108;
            goto L56
        L50:
            r108 = this.f426958a;
        L55:
            r109 = 0;
            goto L56
        L39:
            if (r104.F != null) goto L41;
            r105 = this.f426958a - r104.I;
            goto L42
        L35:
            if (this.f426967j.B == false) goto L41;
        L27:
            if ((r102.f426932j instanceof wlb.g) == false) goto L32;
            int r115 = r102.I;
            goto L32
        L29:
            CreationAIDragView r116 = this.f426967j;
            if ((r116.f426932j instanceof wlb.g) == false) goto L32;
            int r117 = r116.I;
            goto L32
        L7:
            if ((this.f426960c - this.f426958a) <= n0.a(60)) goto L9;
        L8:
            r101 = true;
            goto L23
        L11:
            if (this.f426967j.k() == false) goto L16;
            if (((((this.f426964g - this.f426960c) - this.f426967j.l()) + this.f426967j.P) / this.f426964g) < 0.2f) goto L17;
        L18:
            boolean r118 = false;
        L19:
            if (r118 == false) goto L9;
            if ((this.f426960c - this.f426958a) <= n0.a(60)) goto L9;
        L17:
            r118 = true;
            goto L19
        L16:
            if (this.f426960c <= this.f426967j.f426945w) goto L18;
            goto L17
        }

        public e(CreationAIDragView r100) {
            this.f426967j = r100;
            this.f426966i = n0.a(60);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final boolean a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Log.i("CreationAIDragView", "onNestedPreFling, velocityY = " + r101 + ", currentTop = " + this.f426959b + ", dampedCurrentTop = " + this.f426960c + ", startTop = " + this.f426958a + ", isDown = " + this.f426962e);
            this.f426963f = true;
            if (this.f426960c <= this.f426958a) goto L5;
            this.f426967j.u();
            d();
            return true;
        L5:
            CreationAIDragView.b(this.f426967j);
            return false;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void onStopNestedScroll(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Log.i("CreationAIDragView", "onStopNestedScroll, type = " + r101 + ", hasFling = " + this.f426963f + ", dampedCurrentTop = " + this.f426960c + ", startTop = " + this.f426958a);
            if (r101 == 0) goto L5;
            return;
        L5:
            if (this.f426963f == false) goto L7;
            return;
        L7:
            if (this.f426960c == this.f426958a) goto L9;
            this.f426967j.u();
            d();
            return;
        L9:
            CreationAIDragView.b(this.f426967j);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void onStartNestedScroll(View r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            if (r102 != 0) goto L7;
            int r103 = (int) this.f426967j.f426920c.getY();
            this.f426958a = r103;
            this.f426959b = r103;
            this.f426960c = r103;
            this.f426961d = this.f426967j.f426920c.getHeight();
            CreationAIDragView r104 = this.f426967j;
            int r105 = r104.f426940r;
            this.f426964g = r105;
            this.f426965h = r105 - this.f426958a;
            this.f426962e = false;
            this.f426963f = false;
            r104.H = true;
            ValueAnimator r106 = r104.f426937o;
            if (r106 == null) goto L7;
            r106.cancel();
        L7:
            Log.i("CreationAIDragView", "onStartNestedScroll, startTop = " + this.f426958a + ", currentTop = " + this.f426959b + ", type = " + r102);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void b(View r100, int r101, int r102, int[] r103) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "consumed");
            Log.d("CreationAIDragView", "onNestedScroll, dyUnconsumed = " + r101 + ", type = " + r102);
            if (r101 < 0) goto L5;
            return;
        L5:
            if (r102 == 1) goto L14;
            this.f426962e = true;
            r103[1] = r101;
            int r104 = this.f426959b - r101;
            this.f426959b = r104;
            int r105 = this.f426958a;
            if (r104 == r105) goto L11;
            int r106 = this.f426964g;
            int r107 = this.f426965h;
            int r108 = this.f426966i;
            r104 = r106 - ((int) ((((r107 - r108) / r107) * (r106 - r104)) + r108));
        L11:
            this.f426960c = r104;
            this.f426967j.f426920c.setTranslationY(r104 - r105);
            Log.d("CreationAIDragView", "onNestedScroll, currentTop = " + this.f426959b + ", dampedCurrentTop = " + this.f426960c);
            return;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.NSPConstraintLayout.a
        public final void c(View r100, int r101, int[] r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r102, "consumed");
            Log.d("CreationAIDragView", "onNestedPreScroll, dy = " + r101 + ", currentTop = " + this.f426959b + ", startTop = " + this.f426958a + ", type = " + r103);
            if (r101 > 0) goto L5;
            return;
        L5:
            if (r103 == 1) goto L21;
            this.f426962e = false;
            int r104 = this.f426959b;
            int r105 = this.f426958a;
            if (r104 <= r105) goto L20;
            int r106 = r104 - r105;
            if ((r106 - r101) >= 0) goto L12;
            r102[1] = r102[1] + r106;
            this.f426959b = r105;
        L13:
            int r107 = this.f426959b;
            if (r107 == r105) goto L17;
            int r108 = this.f426964g;
            int r109 = this.f426965h;
            int r110 = this.f426966i;
            r107 = r108 - ((int) ((((r109 - r110) / r109) * (r108 - r107)) + r110));
        L17:
            this.f426960c = r107;
            this.f426967j.f426920c.setTranslationY(r107 - r105);
            Log.d("CreationAIDragView", "onNestedPreScroll, currentTop = " + this.f426959b + ", dampedCurrentTop = " + this.f426960c);
            return;
        L12:
            r102[1] = r102[1] + r101;
            this.f426959b = r104 - r101;
            goto L13
        L20:
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f426969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f426970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f426971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f426972e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f426973f;

        public f(CreationAIDragView r100, int r101, boolean r102, boolean r103, boolean r104, AdjustTopSource r105) {
            this.f426968a = r100;
            this.f426969b = r101;
            this.f426970c = r102;
            this.f426971d = r103;
            this.f426972e = r104;
            this.f426973f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("CreationAIDragView", "execute pending adjustToTop task");     // Catch: Throwable -> L4
            this.f426968a.e(this.f426969b, this.f426970c, this.f426971d, this.f426972e, this.f426973f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f426975b;

        public g(CreationAIDragView r100, AdjustTopSource r101) {
            this.f426974a = r100;
            this.f426975b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            int r102 = (int) ((Float) r101).floatValue();
            this.f426974a.e(r102, false, false, true, this.f426975b);
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f426976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426977b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f426976a == false) goto L9;
            CreationAIDragView r101 = this.f426977b;
            if (r101.B == false) goto L7;
            r101.f426924e.c();
            return;
        L7:
            r101.f426924e.onClose();
            return;
        }

        public h(boolean r100, CreationAIDragView r101) {
            this.f426976a = r100;
            this.f426977b = r101;
        }
    }

    public static final class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f426979b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f426978a.o();
            Function0<Unit> r101 = this.f426979b;
            if (r101 == null) goto L5;
            r101.invoke();
        L5:
            this.f426978a.n();
        }

        public i(CreationAIDragView r100, Function0<Unit> r101) {
            this.f426978a = r100;
            this.f426979b = r101;
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f426980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f426981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426982c;

        public j(float r100, float r101, CreationAIDragView r102) {
            this.f426980a = r100;
            this.f426981b = r101;
            this.f426982c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            float r103 = this.f426980a - this.f426981b;
            Log.i("CreationAIDragView", "targetY: " + this.f426980a + ", startY: " + this.f426981b);
            StringBuilder r104 = new StringBuilder("translationY: ");
            r104.append(r102);
            r104.append(", total: ");
            r104.append(r103);
            r104.append(", unalpha: ");
            float r105 = r102 / r103;
            r104.append(r105);
            Log.i("CreationAIDragView", r104.toString());
            float r106 = 0.0f;
            if (r103 <= 0.0f) goto L6;
            r106 = 1 - r105;
        L6:
            View r107 = this.f426982c.X;
            if (r107 == null) goto L9;
            r107.setAlpha(r106);
        L9:
            CreationAIDragView r108 = this.f426982c;
            if (r108.Y == false) goto L12;
            r108.q(r106);
        L12:
            float r109 = r102 - this.f426981b;
            CreationAIDragView r110 = this.f426982c;
            if (r109 <= r110.f426936n) goto L16;
            r110.n();
            return;
        }
    }

    public static final class k implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426983a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CreationAIDragView f426984a;

            public a(CreationAIDragView r100) {
                this.f426984a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CreationAIDragView r100 = this.f426984a;     // Catch: Throwable -> L4
                int r101 = CreationAIDragView.f426912h0;     // Catch: Throwable -> L4
                r100.n();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Log.i("CreationAIDragView", "onGlobalLayout, keyboardHeightMemory = " + this.f426983a.f426936n);
            this.f426983a.f426918b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            CreationAIDragView r100 = this.f426983a;
            r100.f426918b.addOnLayoutChangeListener(r100.f426917a0);
            FrameLayout r101 = (FrameLayout) this.f426983a.f426916a.findViewById(R.id.content);
            if (r101 == null) goto L5;
            r101.addOnLayoutChangeListener(this.f426983a.f426917a0);
        L5:
            this.f426983a.getClass();
            boolean r102 = CreationAIDragView.j();
            boolean r103 = rcb.b.a(this.f426983a.f426916a);
            Log.i("CreationAIDragView", "onGlobalLayout: hasHardKeyboard = " + r103 + " enable:" + r102);
            if (r102 == false) goto L10;
            if (r103 == false) goto L10;
            CreationAIDragView.c(this.f426983a);
            CreationAIDragView r104 = this.f426983a;
            r104.f426918b.post(new a(r104));
            return;
        L10:
            if (Intrinsics.areEqual(this.f426983a.N, Boolean.TRUE) == false) goto L14;
            CreationAIDragView r105 = this.f426983a;
            if (r105.f426936n != 0) goto L14;
            r105.O = true;
            r105.f426918b.postDelayed(r105.f426921c0, 200);
            return;
        L14:
            CreationAIDragView.c(this.f426983a);
        }

        public k(CreationAIDragView r100) {
            this.f426983a = r100;
        }
    }

    public static final class l implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f426985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f426986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f426987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f426988d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f426985a.f426918b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f426985a.t(this.f426986b, this.f426987c, this.f426988d);
        }

        public l(CreationAIDragView r100, boolean r101, boolean r102, AdjustTopSource r103) {
            this.f426985a = r100;
            this.f426986b = r101;
            this.f426987c = r102;
            this.f426988d = r103;
        }
    }

    static {
    }

    public final void g() {
        this.f426939q = this.f426918b.getWidth();
        int r100 = this.f426918b.getHeight();
        this.f426940r = r100;
        this.f426943u = (int) (r100 - (r100 * 0.6f));
        this.f426944v = (int) (r100 - (r100 * 0.3f));
        this.f426945w = (int) (r100 - (r100 * 0.2f));
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(a(this.f426916a.getWindow()));
        boolean r102 = false;
        if (r101 == null) goto L7;
        Insets r103 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r103 == null) goto L7;
        int r104 = r103.top;
    L8:
        int[] r105 = new int[2];
        this.f426918b.getLocationInWindow(r105);
        int[] r106 = new int[2];
        a(this.f426916a.getWindow()).getLocationInWindow(r106);
        this.f426948z = (r106[1] + r104) - r105[1];
        if (r101 == null) goto L13;
        Insets r107 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r107 == null) goto L13;
        int r108 = r107.bottom;
    L14:
        int[] r109 = new int[2];
        this.f426918b.getLocationInWindow(r109);
        int[] r110 = new int[2];
        a(this.f426916a.getWindow()).getLocationInWindow(r110);
        this.A = ((r110[1] + a(this.f426916a.getWindow()).getHeight()) - r108) - (r109[1] + this.f426940r);
        boolean r111 = idb.f.a().isCurrentEnable("ccm.mobile.forseti");
        int r112 = this.f426926f;
        if (r112 != (-1)) goto L18;
        r112 = n0.a(44);
    L18:
        this.f426946x = r112 + Math.max(this.f426948z, 0);
        this.M = true;
        if (this.S == false) goto L27;
        int r113 = this.f426941s;
        if (r113 > 0) goto L23;
    L26:
        this.f426941s = this.f426940r;
        goto L27
    L23:
        if (r113 <= this.f426940r) goto L25;
        r102 = true;
    L25:
        this.R = Boolean.valueOf(r102);
    L27:
        this.f426942t = this.f426946x;
        Log.i("CreationAIDragView", "calculateHeights, rootViewHeight = " + this.f426940r + ", panelView.height = " + this.f426920c.getHeight() + ", topInNormalPercent = " + this.f426942t + ", isForsetiEnable = " + r111 + ", topIn60Percent = " + this.f426943u + ", topIn30Percent = " + this.f426944v + ", topExceptNaviBar = " + this.f426946x + ", disBetweenRootTopAndActivityTop = " + this.f426948z + ", disBetweenRootBottomAndActivityBottom = " + this.A);
        u();
        return;
    L13:
        r108 = 0;
    L7:
        r104 = 0;
        goto L8
    }

    public final boolean k() {
        Boolean r100 = this.N;
        if (r100 != null) goto L10;
        r100 = this.R;
        if (r100 != null) goto L10;
        return this.f426934l;
    L10:
        return r100.booleanValue();
    }

    public final int m() {
        return ((this.f426940r - l()) + this.P) - ((int) (this.f426940r * 0.3f));
    }

    public final void n() {
        StringBuilder r100 = new StringBuilder("hideKeyboardBg, height: ");
        View r101 = this.W;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getHeight());
    L6:
        r100.append(r102);
        Log.d("CreationAIDragView", r100.toString());
        View r103 = this.W;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getVisibility() != 0) goto L13;
        r103.setVisibility(8);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void o() {
        this.f426918b.setAlpha(0.0f);
        this.f426920c.setTranslationY(0.0f);
        ViewGroup r100 = this.f426920c;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (this.f426932j == null) goto L8;
        int r102 = this.f426940r;
        if (r102 <= 0) goto L7;
        int r103 = (int) (r102 * 0.95f);
    L9:
        r101.height = r103;
        r100.setLayoutParams(r101);
        this.f426915J = -1;
        this.f426932j = null;
        this.M = false;
        Log.i("CreationAIDragView", "reset, setStatusBarTransparent, syncStatusBarColor = " + this.Y);
        if (this.Y == false) goto L12;
        q(0.0f);
    L12:
        f426912h0--;
        return;
    L7:
        r103 = n0.a(714);
        goto L9
    L8:
        r103 = -2;
        goto L9
    }

    public final void s() {
        View r100 = this.W;
        if (r100 != null) goto L5;
    L9:
        StringBuilder r101 = new StringBuilder("showKeyboardBg, height: ");
        View r102 = this.W;
        if (r102 == null) goto L12;
        Integer r103 = Integer.valueOf(r102.getHeight());
    L13:
        r101.append(r103);
        Log.d("CreationAIDragView", r101.toString());
        return;
    L12:
        r103 = null;
        goto L13
    L5:
        if (r100.getVisibility() != 8) goto L9;
        r100.setVisibility(0);
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L9;
        r104.height = this.f426936n;
        goto L9
    }

    public final void u() {
        this.I = this.f426942t;
        Log.i("CreationAIDragView", "updateSelfAdjustTop: " + this.I + ",  topIn30Percent: " + this.f426944v + ",  topIn30PercentVisibleWithKeyboard: " + m());
    }

    public static boolean j() {
        return idb.f.a().isCurrentEnable("ccm.mobile.fix_pad_show_panel_after_keyboard");
    }

    public final int l() {
        if (k() == true) goto L5;
        int r100 = this.A;
        if (r100 >= 0) goto L19;
        return this.Q - r100;
    L19:
        return this.Q;
    L5:
        if (this.S == false) goto L8;
        return this.P;
    L8:
        if (Intrinsics.areEqual(this.N, Boolean.TRUE) == false) goto L13;
        int r101 = this.f426935m;
        if (r101 > 0) goto L21;
        r101 = this.f426936n;
    L21:
        return Math.max(r101 + this.P, this.Q) - this.A;
    L13:
        r101 = this.f426935m;
        goto L21
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final void b(CreationAIDragView r100) {
        r100.getClass();
        Log.i("CreationAIDragView", "onNestedScrollFinished");
        r100.H = false;
        if ((r100.f426932j instanceof wlb.g) == false) goto L10;
        r100.u();
        Integer r101 = r100.F;
        if (r101 == null) goto L7;
        int r102 = Math.max(r101.intValue(), r100.I);
    L8:
        f(r100, r102, true, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L7:
        r102 = r100.I;
        goto L8
    }

    public static final void c(CreationAIDragView r100) {
        r100.getClass();
        Log.i("CreationAIDragView", "showInternal");
        r100.g();
        r100.t(true, false, AdjustTopSource.VIEW_CHANGE);
        r100.f426918b.post(new n(r100));
    }

    public static final void d(CreationAIDragView r100) {
        r100.getClass();
        boolean r101 = j();
        Log.i("CreationAIDragView", "showKeyboard() called enable:" + r101);
        if (r101 == true) goto L15;
        rcb.c.g(r100.f426916a);
        return;
    L15:
        CreationAIEditText r102 = (CreationAIEditText) r100.f426918b.findViewById(com.larus.nova.R.id.creation_input_text);     // Catch: Exception -> L11
        r102.requestFocus();     // Catch: Exception -> L11
        Object r103 = r102.getContext().getSystemService("input_method");     // Catch: Exception -> L11
        if ((r103 instanceof InputMethodManager) == false) goto L7;
        InputMethodManager r104 = (InputMethodManager) r103;     // Catch: Exception -> L11
    L8:
        if (r104 == null) goto L17;
        r104.showSoftInput(r102, 2);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L7:
        r104 = null;
    L11:
        e = move-exception;
        Log.e("CreationAIDragView", "showKeyboard: Exception:", e);
        rcb.c.g(r100.f426916a);
        Unit r105 = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(View r100) {
        Log.i("CreationAIDragView", "setAdjustableView, view = " + r100 + ", mode = 0, isShown = " + this.f426918b.isShown() + ", heightsReady = " + this.M);
        KeyEvent.Callback r101 = this.f426932j;
        boolean r102 = Intrinsics.areEqual(r101, r100) ^ true;
        if (r101 == null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f426932j = r100;
        if (r102 == false) goto L17;
        if (r101 == null) goto L15;
        if ((r101 instanceof wlb.g) == false) goto L15;
        ((wlb.g) r101).setOnHeightChangeListener(null);
    L15:
        if ((r100 instanceof wlb.g) == false) goto L17;
        ((wlb.g) r100).setOnHeightChangeListener(new com.ss.android.lark.inline.ai.creationai.k(this));
    L17:
        this.f426933k = 0;
        if (this.D == true) goto L20;
    L22:
        if (r100 != 0) goto L24;
        ViewGroup r104 = this.f426920c;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = -2;
        r104.setLayoutParams(r105);
    L24:
        if (r102 == true) goto L26;
        return;
    L26:
        if (this.M == false) goto L36;
        if (r100 != 0) goto L29;
        u();
        t(false, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE);
        Log.i("CreationAIDragView", "setAdjustableView, setStatusBarTransparent ---->");
        q(0.0f);
    L32:
        if (r103 == false) goto L37;
        this.f426918b.postDelayed(new m(this), 100);
        return;
    L37:
        return;
    L29:
        this.f426922d.a(this.Z);
        u();
        t(false, false, AdjustTopSource.SET_ADJUST_CHANGE);
        this.f426918b.postDelayed(new com.ss.android.lark.inline.ai.creationai.l(this), 140);
        this.f426934l = false;
        this.f426935m = 0;
        n();
        Log.i("CreationAIDragView", "setAdjustableView, setStatusBarMask ---->, panelCount = " + f426912h0);
        if (f426912h0 > 1) goto L32;
        q(1.0f);
        goto L32
    L36:
        return;
    L20:
        if (this.V == false) goto L22;
        return;
    L5:
        if ((r100 instanceof QuickPromptRecyclerView) == false) goto L7;
        r103 = true;
        goto L8
    }

    public final void q(float r110) {
        Log.i("CreationAIDragView", "statusbar color, alpha = " + r110 + ", panelCount: " + f426912h0);
        if (r110 >= 0.0f) goto L5;
    L29:
        Log.e("CreationAIDragView", "alpha value over range, alpha: " + r110);
        return;
    L5:
        if (r110 > 1.0f) goto L29;
        Ref.FloatRef r100 = new Ref.FloatRef();
        boolean r101 = true;
        if (f426913i0 == false) goto L10;
        int r102 = f426912h0;
    L12:
        if (r102 >= 2) goto L14;
        r100.element = this.f426927f0 * r110;
    L15:
        Log.i("CreationAIDragView", "set statusBar color alpha: " + r100.element);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f426916a), null, null, new CreationAIDragView$setStatusBarColorAlpha$1(this, r100, null), 3, null);
        if (f426912h0 <= 1) goto L18;
        return;
    L18:
        if (r110 != 1.0f) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
        f426913i0 = true;
    L23:
        if (r110 == 0.0f) goto L26;
        r101 = false;
    L26:
        if (r101 == false) goto L32;
        f426913i0 = false;
        return;
    L32:
        return;
    L20:
        r111 = false;
        goto L21
    L14:
        r100.element = 1 - (((float) Math.pow(0.6d, r102 - 1)) * (1.0f - (this.f426927f0 * r110)));
        goto L15
    L10:
        r102 = f426912h0 - 1;
        goto L12
    }

    public final void h(boolean r100, Function0<Unit> r101) {
        Log.i("CreationAIDragView", "dismiss, doAnim = " + r100);
        this.M = false;
        this.f426922d.a(this.Z);
        ObjectAnimator r102 = this.K;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        ObjectAnimator r103 = this.L;
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        ValueAnimator r104 = this.f426937o;
        if (r104 == null) goto L11;
        r104.cancel();
    L11:
        ValueAnimator r105 = this.f426938p;
        if (r105 == null) goto L14;
        r105.cancel();
    L14:
        this.f426918b.removeCallbacks(this.f426929g0);
        this.f426918b.removeOnLayoutChangeListener(this.f426917a0);
        ((FrameLayout) this.f426916a.findViewById(R.id.content)).removeOnLayoutChangeListener(this.f426917a0);
        if (r100 == false) goto L21;
        this.f426918b.setAlpha(1.0f);
        float r106 = this.f426920c.getTranslationY();
        if (k() == false) goto L19;
        s();
        float r107 = this.f426920c.getHeight() + this.f426936n;
    L20:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this.f426920c, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r106, r107});
        r108.setDuration(250);
        r108.setInterpolator(new DecelerateInterpolator());
        r108.addListener(new i(this, r101));
        r108.addUpdateListener(new j(r107, r106, this));
        this.L = r108;
        r108.start();
    L23:
        if (j() == false) goto L26;
        this.f426916a.getWindow().setSoftInputMode(f426914j0);
        return;
    L26:
        return;
    L19:
        r107 = this.f426920c.getHeight();
        goto L20
    L21:
        o();
        r101.invoke();
        goto L23
    }

    public final void r(Boolean r100, Function0<Unit> r101) {
        this.f426919b0 = r101;
        if (this.f426928g == false) goto L11;
        ViewParent r102 = this.f426918b.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L7;
        ViewGroup r103 = (ViewGroup) r102;
    L9:
        if (Intrinsics.areEqual(r103, a(this.f426916a.getWindow())) == true) goto L11;
        boolean r104 = true;
    L12:
        this.S = r104;
        Log.i("CreationAIDragView", "show, keyboardShowingByForce = " + r100 + ", isRootParentAdjustResize = " + this.S);
        this.O = false;
        this.f426934l = this.f426922d.isKeyboardShowing();
        int r105 = this.f426922d.c();
        if (r105 <= 0) goto L15;
        this.f426936n = r105;
    L15:
        this.f426935m = r105;
        this.f426922d.b(this.Z);
        this.f426918b.setAlpha(0.0f);
        this.N = r100;
        this.f426918b.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
        this.f426918b.requestLayout();
        if (j() == false) goto L19;
        f426914j0 = this.f426916a.getWindow().getAttributes().softInputMode;
        Log.i("CreationAIDragView", "show: originalSoftInputMode:" + f426914j0);
        this.f426916a.getWindow().setSoftInputMode(48);
        return;
    L19:
        return;
    L7:
        r103 = null;
    L11:
        r104 = false;
        goto L12
    }

    public final void i(boolean r100, boolean r110, AdjustTopSource r111) {
        Log.i("CreationAIDragView", "doRebound()... canHide = " + r100 + ", smooth = " + r110 + ", adjustTopSource = " + r111);
        ViewGroup r101 = this.f426920c;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        int r102 = r101.getMinimumHeight();
        if (r102 <= 0) goto L6;
        Pair r103 = new Pair(Integer.valueOf(this.f426940r - r102), Boolean.valueOf(r100));
    L67:
        int r104 = ((Number) r103.component1()).intValue();
        boolean r105 = ((Boolean) r103.component2()).booleanValue();
        if (r111 == AdjustTopSource.DRAG) goto L70;
    L76:
        f(this, r104, r110, r105, r111, 8);
        int r112 = (this.f426940r - r104) + this.A;
        if (r112 == this.f426915J) goto L80;
        this.f426924e.a(r112);
        this.f426915J = r112;
        return;
    L80:
        return;
    L70:
        if ((this.f426932j instanceof wlb.g) == false) goto L76;
        if (r104 != this.I) goto L74;
        Integer r106 = null;
    L75:
        this.F = r106;
        goto L76
    L74:
        r106 = Integer.valueOf(r104);
        goto L75
    L6:
        if (k() == true) goto L8;
        float r107 = this.f426920c.getTop() + this.f426920c.getTranslationY();
        int r108 = this.f426943u;
        int r109 = this.f426942t;
        float r113 = (r108 + r109) / 2;
        if (r107 < r113) goto L32;
        if (r100 == true) goto L39;
    L56:
        boolean r114 = this.f426932j instanceof wlb.g;
        if (r114 == false) goto L62;
        int r115 = (int) r107;
        int r116 = this.I;
        if (r115 != r116) goto L62;
        Pair r117 = new Pair(Integer.valueOf(r116), Boolean.FALSE);
    L36:
        r103 = r117;
    L62:
        if (r114 == false) goto L64;
        int r118 = this.I;
    L65:
        Pair r119 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r108, r118)), Boolean.FALSE);
    L66:
        r103 = r119;
        goto L67
    L64:
        r118 = this.f426947y;
        goto L65
    L39:
        if (r107 >= this.f426944v) goto L44;
        if (r107 > r113) goto L56;
    L44:
        if (this.B == false) goto L55;
        boolean r120 = this.f426932j instanceof wlb.g;
        if (r120 == false) goto L51;
        int r121 = (int) r107;
        int r122 = this.I;
        if (r121 != r122) goto L51;
        r117 = new Pair(Integer.valueOf(r122), Boolean.FALSE);
    L51:
        if (r120 == false) goto L53;
        int r123 = this.I;
    L54:
        r119 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r108, r123)), Boolean.TRUE);
        goto L66
    L53:
        r123 = this.f426947y;
        goto L54
    L55:
        r117 = new Pair(Integer.valueOf(this.f426940r), Boolean.TRUE);
        goto L36
    L32:
        if ((this.f426932j instanceof wlb.g) == false) goto L34;
        int r124 = this.I;
    L35:
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r109, r124)), Boolean.FALSE);
        goto L36
    L34:
        r124 = this.f426947y;
        goto L35
    L8:
        if (this.f426933k != 0) goto L10;
        int r125 = this.f426946x;
    L11:
        float r126 = ((this.f426940r - l()) + this.P) - (this.f426920c.getTop() + this.f426920c.getTranslationY());
        if (r100 == false) goto L25;
        int r127 = this.f426940r;
        if ((r126 / r127) >= 0.3f) goto L25;
        if (this.B == true) goto L19;
        r119 = new Pair(Integer.valueOf(r127 - this.f426935m), Boolean.TRUE);
        goto L66
    L19:
        if ((this.f426932j instanceof wlb.g) == false) goto L21;
        int r128 = this.I;
    L22:
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r125, r128)), Boolean.TRUE);
        goto L36
    L21:
        r128 = this.f426947y;
    L25:
        if ((this.f426932j instanceof wlb.g) == false) goto L27;
        int r129 = this.I;
    L28:
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r125, r129)), Boolean.FALSE);
        goto L36
    L27:
        r129 = this.f426947y;
        goto L28
    L10:
        r125 = this.f426942t;
        goto L11
    }

    public final void t(boolean r110, boolean r111, AdjustTopSource r112) {
        if (this.M == true) goto L6;
        Log.w("CreationAIDragView", "updateHeight when heights are not ready! so return");
        return;
    L6:
        ObjectAnimator r100 = this.K;
        boolean r101 = true;
        if (r100 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
        Log.w("CreationAIDragView", "updateHeight when showAnim is running! so return");
        return;
    L15:
        int r103 = -2;
        if (this.f426920c.getHeight() != 0) goto L31;
        Log.w("CreationAIDragView", "height is 0, add layout observer");
        this.f426918b.getViewTreeObserver().addOnGlobalLayoutListener(new l(this, r110, r111, r112));
        if (this.f426920c.getLayoutParams().height <= 0) goto L20;
        return;
    L20:
        if (this.f426920c.getLayoutParams().height != (-1)) goto L22;
        return;
    L22:
        if (this.f426920c.getLayoutParams().height == (-2)) goto L126;
        ViewGroup r113 = this.f426920c;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (this.f426932j == null) goto L29;
        int r115 = this.f426940r;
        if (r115 <= 0) goto L28;
        r103 = (int) (r115 * 0.95f);
        goto L29
    L28:
        r103 = n0.a(714);
    L29:
        r114.height = r103;
        r113.setLayoutParams(r114);
        return;
    L126:
        return;
    L31:
        View r104 = this.f426932j;
        if (r104 != null) goto L35;
        ViewGroup r105 = this.f426920c;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.height = -2;
        r105.setLayoutParams(r106);
        this.f426920c.measure(View.MeasureSpec.makeMeasureSpec(this.f426939q, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f426940r, Integer.MIN_VALUE));
        this.f426947y = (this.f426940r - this.f426920c.getMeasuredHeight()) - l();
    L39:
        Log.i("CreationAIDragView", "updateHeight, isInit = " + r110 + ", keyboardChange = " + r111 + ", isKeyboardShowing = " + this.f426934l + ",  isRootParentAdjustResize = " + this.S + ", forceKeyboardWhenShowing = " + this.N + ", topWithMaxHeight = " + this.f426947y + ", adjustableView = " + r104);
        if (r111 == true) goto L42;
    L43:
        ViewGroup r107 = this.f426920c;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r109.bottomMargin = l();
        r107.setLayoutParams(r109);
    L44:
        if (r111 == false) goto L81;
        if (this.S == true) goto L81;
        this.G = false;
        ValueAnimator r116 = this.f426938p;
        if (r116 == null) goto L50;
        r116.cancel();
    L50:
        ObjectAnimator r117 = this.K;
        if (r117 == null) goto L53;
        r117.cancel();
    L53:
        ValueAnimator r118 = this.f426937o;
        if (r118 == null) goto L56;
        r118.cancel();
    L56:
        ViewGroup.LayoutParams r119 = this.f426920c.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r120 = ((ViewGroup.MarginLayoutParams) r119).bottomMargin;
        int r121 = this.f426920c.getHeight();
        float r122 = this.f426920c.getTranslationY();
        int r123 = l();
        int r124 = (int) this.f426920c.getY();
        int r125 = (this.f426940r - r124) - r123;
        Log.i("CreationAIDragView", "doKeyboardAnimation, currentMarginBottom = " + r120 + ", currentHeight = " + r121 + ", currentTranslationY = " + r122 + ", targetMarginBottom = " + r123 + ", targetHeight = " + r125 + ", targetTranslationY = 0.0, currentTop = " + this.f426920c.getY() + ", targetTop = " + r124);
        if (r120 != r123) goto L65;
        if (r121 != r125) goto L65;
        if (r122 == 0.0f) goto L63;
        r101 = false;
    L63:
        if (r101 == false) goto L65;
        Log.i("CreationAIDragView", "doKeyboardAnimation, target pos is the same as current, so return");
        return;
    L65:
        ValueAnimator r126 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f426938p = r126;
        if (r126 == null) goto L68;
        r126.addUpdateListener(new com.ss.android.lark.inline.ai.creationai.d(r121, r125, this, r120, r123));
    L68:
        ValueAnimator r127 = this.f426938p;
        if (r127 == null) goto L71;
        r127.addListener(new com.ss.android.lark.inline.ai.creationai.c(this));
    L71:
        ValueAnimator r128 = this.f426938p;
        if (r128 == null) goto L74;
        r128.setDuration(140);
    L74:
        ValueAnimator r129 = this.f426938p;
        if (r129 == null) goto L77;
        r129.start();
    L77:
        int r130 = (this.f426940r - r124) + this.A;
        if (r130 == this.f426915J) goto L128;
        this.f426924e.a(r130);
        this.f426915J = r130;
        return;
    L128:
        return;
    L81:
        if (this.D == false) goto L84;
        f(this, this.f426920c.getTop() + ((int) this.f426920c.getTranslationY()), false, false, r112, 12);
        return;
    L84:
        if (this.H == true) goto L131;
        if (r110 == false) goto L107;
        if (k() == true) goto L89;
        View r131 = this.f426932j;
        if (this.f426933k == 0) goto L99;
    L101:
        int r132 = RangesKt.coerceAtLeast(this.f426943u, this.f426947y);
    L103:
        if (this.f426930h == false) goto L105;
        r132 = this.f426940r - this.f426920c.getHeight();
    L105:
        f(this, r132, false, false, r112, 12);
        return;
    L99:
        if ((r131 instanceof wlb.g) == false) goto L101;
        r132 = Math.max(this.f426942t, Math.min(this.I, this.f426944v));
        goto L103
    L89:
        if (this.f426933k != 0) goto L95;
        int r133 = this.f426946x;
        if ((this.f426932j instanceof wlb.g) == false) goto L93;
        int r134 = Math.min(this.I, this.f426944v);
    L94:
        r132 = Math.max(r133, r134);
        goto L103
    L93:
        r134 = this.f426947y;
        goto L94
    L95:
        r132 = RangesKt.coerceAtLeast(this.f426942t, this.f426947y);
        goto L103
    L107:
        if ((this.f426932j instanceof wlb.g) == false) goto L119;
        if (k() == false) goto L112;
        int r135 = Math.max(this.I, this.f426946x);
    L117:
        f(this, r135, false, false, r112, 12);
        return;
    L112:
        Integer r136 = this.F;
        if (r136 == null) goto L115;
        int r137 = Math.max(r136.intValue(), this.I);
    L116:
        r135 = Math.max(r137, this.f426942t);
        goto L117
    L115:
        r137 = this.I;
        goto L116
    L119:
        if (r112 != AdjustTopSource.CONTAINER_CHANGE) goto L122;
        r101 = false;
    L122:
        i(false, r101, r112);
        return;
    L131:
        return;
    L42:
        if (this.S == false) goto L44;
    L35:
        if (this.f426933k != 0) goto L37;
        int r138 = 0;
    L38:
        this.f426947y = r138;
        goto L39
    L37:
        int r139 = this.f426920c.getHeight();
        int r140 = r104.getHeight();
        r104.measure(View.MeasureSpec.makeMeasureSpec(r104.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f426940r, Integer.MIN_VALUE));
        Log.i("CreationAIDragView", "initContainerHeight: " + r139 + ", initAdjustableViewHeight: " + r140 + ", measuredHeight: " + r104.getMeasuredHeight());
        r138 = (this.f426940r - (r139 + (r104.getMeasuredHeight() - r140))) - l();
        goto L38
    L9:
        if (r100.isRunning() != true) goto L11;
        r102 = true;
        goto L12
    }

    public final void e(int r110, boolean r111, boolean r112, boolean r113, AdjustTopSource r114) {
        if (this.H == false) goto L6;
        return;
    L6:
        if (r111 == false) goto L8;
        Log.i("CreationAIDragView", "adjustToTop, targetTop = " + r110 + ", currentTop = " + this.f426920c.getY() + ", smooth = true, isHide = " + r112 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r113 + ", adjustTopSource = " + r114);
    L9:
        ValueAnimator r100 = this.f426938p;
        int r101 = 0;
        if (r100 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L18;
        this.T = new f(this, r110, r111, r112, r113, r114);
        Log.i("CreationAIDragView", "keyboardAnimation is running, add pending adjustToTop task");
        return;
    L18:
        if (r113 == true) goto L23;
        ValueAnimator r103 = this.f426937o;
        if (r103 == null) goto L23;
        r103.cancel();
    L23:
        if (r114 != AdjustTopSource.SET_ADJUST_CHANGE) goto L31;
        int r104 = this.A;
        if (r104 >= 0) goto L27;
        int r105 = this.Q - r104;
    L28:
        int r106 = this.I;
        ViewGroup r107 = this.f426920c;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r109.height = (this.f426940r - r106) - r105;
        r109.bottomMargin = 0;
        r107.setLayoutParams(r109);
        this.f426920c.setTranslationY(0.0f);
        Log.i("CreationAIDragView", "set adjust change panelView height: " + this.f426920c.getHeight());
        return;
    L27:
        r105 = this.Q;
        goto L28
    L31:
        if (r111 == false) goto L52;
        if (r110 != ((int) this.f426920c.getY())) goto L36;
        Log.i("CreationAIDragView", "adjustToTop smooth return");
        return;
    L36:
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{this.f426920c.getY(), r110});
        this.f426937o = r115;
        if (r115 == null) goto L39;
        r115.setDuration(200);
    L39:
        ValueAnimator r116 = this.f426937o;
        if (r116 == null) goto L42;
        r116.setInterpolator(new DecelerateInterpolator());
    L42:
        ValueAnimator r117 = this.f426937o;
        if (r117 == null) goto L45;
        r117.addUpdateListener(new g(this, r114));
    L45:
        ValueAnimator r118 = this.f426937o;
        if (r118 == null) goto L48;
        r118.addListener(new h(r112, this));
    L48:
        ValueAnimator r119 = this.f426937o;
        if (r119 == null) goto L155;
        r119.start();
        return;
    L155:
        return;
    L52:
        if (this.f426932j != null) goto L54;
    L83:
        int r120 = -2;
        if (k() == false) goto L126;
        if (this.f426933k != 0) goto L88;
        int r121 = this.f426946x;
    L90:
        if (r110 > Math.max(r121, this.f426947y)) goto L101;
        this.f426920c.setTranslationY(0.0f);
        ViewGroup r122 = this.f426920c;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if (r123 == null) goto L99;
        if (this.f426932j == null) goto L97;
        r120 = (this.f426940r - Math.max(r121, this.f426947y)) - l();
    L97:
        r123.height = r120;
        r122.setLayoutParams(r123);
        return;
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L101:
        if (this.V == false) goto L107;
        if (this.D == false) goto L107;
        ViewGroup r124 = this.f426920c;
        r124.setTranslationY(r110 - r124.getTop());
        return;
    L107:
        if (this.f426932j != null) goto L114;
        this.f426920c.setTranslationY(r110 - Math.max(r121, this.f426947y));
        ViewGroup r125 = this.f426920c;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if (r126 == null) goto L112;
        r126.height = -2;
        r125.setLayoutParams(r126);
        return;
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L114:
        if (r110 > m()) goto L120;
        this.f426920c.setTranslationY(0.0f);
        ViewGroup r127 = this.f426920c;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 == null) goto L119;
        r128.height = (this.f426940r - r110) - l();
        r127.setLayoutParams(r128);
        return;
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L120:
        this.f426920c.setTranslationY(r110 - m());
        ViewGroup r129 = this.f426920c;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L124;
        r130.height = (this.f426940r - m()) - l();
        r129.setLayoutParams(r130);
        return;
    L124:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L88:
        r121 = this.f426942t;
        goto L90
    L126:
        if (this.V == false) goto L132;
        if (this.D == false) goto L132;
        ViewGroup r131 = this.f426920c;
        r131.setTranslationY(r110 - r131.getTop());
        return;
    L132:
        if (r110 >= RangesKt.coerceAtLeast(this.f426942t, this.f426947y)) goto L139;
        ViewGroup r132 = this.f426920c;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (this.f426932j == null) goto L137;
        r120 = (this.f426940r - RangesKt.coerceAtLeast(this.f426942t, this.f426947y)) - l();
    L137:
        r133.height = r120;
        r132.setLayoutParams(r133);
        this.f426920c.setTranslationY(0.0f);
        return;
    L139:
        if (r110 <= RangesKt.coerceAtLeast(this.f426944v, this.f426947y)) goto L145;
        ViewGroup r134 = this.f426920c;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (this.f426932j == null) goto L144;
        r120 = (this.f426940r - RangesKt.coerceAtLeast(this.f426944v, this.f426947y)) - l();
    L144:
        r135.height = r120;
        r134.setLayoutParams(r135);
        this.f426920c.setTranslationY(r110 - RangesKt.coerceAtLeast(this.f426944v, this.f426947y));
        return;
    L145:
        ViewGroup r136 = this.f426920c;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (this.f426932j == null) goto L149;
        r120 = (this.f426940r - r110) - l();
    L149:
        r137.height = r120;
        r136.setLayoutParams(r137);
        this.f426920c.setTranslationY(0.0f);
        return;
    L54:
        if (CollectionsKt.listOf(new AdjustTopSource[]{AdjustTopSource.VIEW_CHANGE, AdjustTopSource.CONTENT_HEIGHT_CHANGE}).contains(r114) == false) goto L83;
        if (this.f426933k != 0) goto L58;
        int r138 = this.f426946x;
    L59:
        ViewGroup r139 = this.f426920c;
        ViewGroup.LayoutParams r140 = r139.getLayoutParams();
        r140.height = (this.f426940r - RangesKt.coerceAtLeast(r138, r110)) - l();
        r139.setLayoutParams(r140);
        this.f426920c.setTranslationY(0.0f);
        if (this.U == true) goto L62;
        return;
    L62:
        if ((this.f426932j instanceof QuickPromptRecyclerView) == false) goto L158;
        Iterator<View> r141 = ViewGroupKt.getChildren(this.f426920c).iterator();
        int r142 = 0;
        int r143 = 0;
    L65:
        if (r141.hasNext() == false) goto L73;
        View r144 = r141.next();
        int r145 = r143 + 1;
        if (r143 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        if (Intrinsics.areEqual(r144, this.f426932j) == false) goto L72;
        r142 = r143;
    L72:
        r143 = r145;
        goto L65
    L73:
        if (r142 <= 0) goto L78;
        int r146 = 0;
    L75:
        if (r101 >= r142) goto L77;
        r146 = r146 + this.f426920c.getChildAt(r101).getHeight();
        r101 = r101 + 1;
        goto L75
    L77:
        r101 = r146;
    L78:
        View r147 = this.f426932j;
        if (r147 == null) goto L159;
        ViewGroup.LayoutParams r148 = r147.getLayoutParams();
        if (r148 == null) goto L160;
        r148.height = this.f426920c.getLayoutParams().height - r101;
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L58:
        r138 = this.f426942t;
        goto L59
    L12:
        if (r100.isRunning() != true) goto L14;
        r102 = true;
        goto L15
    L8:
        Log.d("CreationAIDragView", "adjustToTop, targetTop = " + r110 + ", currentTop = " + this.f426920c.getY() + ", smooth = false, isHide = " + r112 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r113 + ", adjustTopSource = " + r114);
        goto L9
    }

    public static /* synthetic */ void f(CreationAIDragView r100, int r101, boolean r102, boolean r103, AdjustTopSource r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        boolean r104 = false;
    L6:
        r100.e(r101, r102, r104, false, r110);
        return;
    L5:
        r104 = r103;
        goto L6
    }

    public CreationAIDragView(FragmentActivity r100, ConstraintLayout r101, ViewGroup r102, wlb.d r103, d r104, slb.a r105, int r106, boolean r107, boolean r110, vlb.d r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "panelRootView");
        Intrinsics.checkNotNullParameter(r102, "panelView");
        Intrinsics.checkNotNullParameter(r103, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r104, "callback");
        this.f426916a = r100;
        this.f426918b = r101;
        this.f426920c = r102;
        this.f426922d = r103;
        this.f426924e = r104;
        this.f426926f = r106;
        this.f426928g = r107;
        this.f426930h = r110;
        this.f426931i = r111;
        this.f426934l = r103.isKeyboardShowing();
        this.f426935m = r103.c();
        this.f426936n = r103.c();
        this.C = true;
        this.G = true;
        this.I = Integer.MAX_VALUE;
        this.f426915J = -1;
        this.Y = true;
        if ((r102 instanceof NSPConstraintLayout) == false) goto L6;
        ((NSPConstraintLayout) r102).setNSPHandler(new e(this));
    L6:
        if (r105 == null) goto L8;
        int r108 = r105.f542512b;
    L9:
        this.P = r108;
        if (r105 == null) goto L12;
        int r109 = r105.f542511a;
    L13:
        this.Q = r109;
        r101.setOnTouchListener(new a(this));
        this.W = r101.findViewById(com.larus.nova.R.id.creation_ai_keyboard_bg);
        this.X = r101.findViewById(com.larus.nova.R.id.creation_mask_full_screen);
        this.Z = new com.ss.android.lark.inline.ai.creationai.i(this);
        this.f426917a0 = new com.ss.android.lark.inline.ai.creationai.j(this);
        this.f426921c0 = new com.ss.android.lark.inline.ai.creationai.b(this);
        this.f426923d0 = new o(this);
        this.f426925e0 = com.larus.nova.R.color.bg_mask;
        this.f426927f0 = 0.4f;
        this.f426929g0 = new com.ss.android.lark.inline.ai.creationai.a(this);
        return;
    L12:
        r109 = n0.a(0);
        goto L13
    L8:
        r108 = n0.a(0);
        goto L9
    }
}
