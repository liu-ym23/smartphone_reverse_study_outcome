package com.ss.android.lark.inline.ai.ui;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class InlineAIDragView {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public Integer F;
    public boolean G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f427353J;
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
    public final com.ss.android.lark.inline.ai.ui.j V;
    public final com.ss.android.lark.inline.ai.ui.k W;
    public final com.ss.android.lark.inline.ai.ui.d X;
    public final com.ss.android.lark.inline.ai.ui.c Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f427354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f427355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f427356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wlb.d f427357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f427358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f427359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f427360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f427361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f427362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f427363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f427364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f427365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f427366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f427367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f427368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f427369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f427370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f427371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f427372s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f427373t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f427374u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f427375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f427376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f427377x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f427378y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f427379z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/InlineAIDragView$AdjustTopSource;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_CHANGE", "DRAG", "KEYBOARD_CHANGE", "CONTAINER_CHANGE", "CONTENT_HEIGHT_CHANGE", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AdjustTopSource extends Enum<AdjustTopSource> {
        public static final AdjustTopSource CONTAINER_CHANGE = null;
        public static final AdjustTopSource CONTENT_HEIGHT_CHANGE = null;
        public static final AdjustTopSource DRAG = null;
        public static final AdjustTopSource KEYBOARD_CHANGE = null;
        public static final AdjustTopSource VIEW_CHANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdjustTopSource[] f427380a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f427381b = null;

        public static EnumEntries<AdjustTopSource> getEntries() {
            return f427381b;
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
            AdjustTopSource[] r105 = {r100, r101, r102, r103, r104};
            f427380a = r105;
            f427381b = EnumEntriesKt.enumEntries(r105);
        }

        public static AdjustTopSource[] values() {
            return (AdjustTopSource[]) f427380a.clone();
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
        public long f427382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f427383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f427384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427385d;

        public a(InlineAIDragView r100) {
            this.f427385d = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r110, "event");
            boolean r101 = false;
            if (this.f427385d.C == false) goto L5;
        L7:
            int r102 = r110.getAction();
            if (r102 == 0) goto L34;
            if (r102 != 1) goto L11;
            long r103 = System.currentTimeMillis();
            float r104 = r110.getRawX();
            float r105 = r110.getRawY();
            float r111 = r110.getY();
            float r106 = this.f427385d.f427356c.getY();
            long r107 = r103 - this.f427382a;
            float r108 = Math.abs(r104 - this.f427383b);
            float r109 = Math.abs(r105 - this.f427384c);
            if (r111 >= r106) goto L17;
            boolean r112 = true;
        L19:
            if (r107 >= 200) goto L21;
            boolean r113 = true;
        L23:
            if (r108 >= f0.a(20)) goto L25;
            boolean r114 = true;
        L27:
            if (r109 >= f0.a(20)) goto L29;
            r101 = true;
        L29:
            if (r112 == false) goto L35;
            if (r113 == false) goto L35;
            if (r114 == false) goto L35;
            if (r101 == false) goto L35;
            this.f427385d.f427358e.d();
        L35:
            return true;
        L25:
            r114 = false;
            goto L27
        L21:
            r113 = false;
            goto L23
        L17:
            r112 = false;
            goto L19
        L11:
            if (r102 != 3) goto L35;
            Log.i("InlineAIDragView", "background touch cancel");
            goto L35
        L34:
            this.f427382a = System.currentTimeMillis();
            this.f427383b = r110.getRawX();
            this.f427384c = r110.getRawY();
            Log.i("InlineAIDragView", "background touch down: " + this.f427382a + ", startRawX = " + this.f427383b + ", startRawY = " + this.f427384c);
            goto L35
        L5:
            if (r110.getY() >= this.f427385d.f427356c.getY()) goto L7;
            return false;
        }
    }

    public static final class b {
    }

    public final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f427386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f427387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427388c;

        public c(InlineAIDragView r100) {
            this.f427388c = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r111, "event");
            int r112 = r111.getAction();
            boolean r100 = false;
            if (r112 == 0) goto L34;
            if (r112 != 1) goto L6;
        L22:
            this.f427388c.D = false;
            Log.i("InlineAIDragView", "touch up/cancel y = " + r111.getRawY() + ", rawY = " + r111.getRawY());
            if (this.f427388c.B == true) goto L25;
        L28:
            InlineAIDragView r113 = this.f427388c;
            if (r113.G == true) goto L31;
        L41:
            return true;
        L31:
            if ((r111.getRawY() - this.f427386a) <= f0.a(60)) goto L33;
            r100 = true;
        L33:
            r113.h(r100, true, AdjustTopSource.DRAG);
            goto L41
        L25:
            if ((r111.getRawY() - this.f427386a) <= f0.a(60)) goto L28;
            this.f427388c.f427358e.onClose();
            return true;
        L6:
            if (r112 != 2) goto L8;
            Log.d("InlineAIDragView", "touch move y = " + r111.getY(0) + ", rawY = " + r111.getRawY());
            InlineAIDragView r114 = this.f427388c;
            if (r114.G == true) goto L14;
            r114.D = false;
            return false;
        L14:
            r114.E = this.f427387b + ((int) (r111.getRawY() - this.f427386a));
            InlineAIDragView r101 = this.f427388c;
            if (r101.f427361h <= 0.0f) goto L18;
            InlineAIDragView.e(r101, r101.E, false, false, AdjustTopSource.DRAG, 12);
            goto L41
        L18:
            if ((r101.f427362i instanceof wlb.g) == false) goto L20;
            int r115 = Math.max(r101.I, r101.E);
        L21:
            InlineAIDragView.e(r101, r115, false, false, AdjustTopSource.DRAG, 12);
            goto L41
        L20:
            r115 = r101.E;
            goto L21
        L8:
            if (r112 == 3) goto L22;
        L34:
            InlineAIDragView r116 = this.f427388c;
            if (r116.H == false) goto L37;
            return false;
        L37:
            r116.D = true;
            r116.G = true;
            ValueAnimator r117 = r116.f427367n;
            if (r117 == null) goto L40;
            r117.cancel();
        L40:
            this.f427386a = r111.getRawY();
            int r118 = this.f427388c.f427356c.getTop() + ((int) this.f427388c.f427356c.getTranslationY());
            this.f427387b = r118;
            this.f427388c.E = r118;
            Log.i("InlineAIDragView", "touch down y = " + r111.getY(0) + ", rawY = " + r111.getRawY() + ", panelInitTop = " + this.f427387b);
            goto L41
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
        public int f427389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f427390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f427391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f427392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f427393e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f427394f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f427395g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f427396h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f427397i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427398j;

        public final void d() {
            boolean r100 = true;
            if (this.f427394f == false) goto L11;
            if (this.f427393e == true) goto L7;
        L9:
            boolean r101 = false;
        L23:
            if (r101 == false) goto L29;
            InlineAIDragView r102 = this.f427398j;
            if (r102.A == true) goto L27;
        L32:
            int r103 = this.f427392d;
            if (r101 == true) goto L35;
        L36:
            InlineAIDragView r104 = this.f427398j;
            if ((r104.f427362i instanceof wlb.g) == true) goto L39;
        L41:
            int r105 = 0;
        L42:
            int r106 = r103 + r105;
            if (r101 == false) goto L55;
            InlineAIDragView r107 = this.f427398j;
            if (r107.A == true) goto L55;
            if ((r107.f427362i instanceof wlb.g) == false) goto L50;
            int r108 = r107.I;
        L52:
            if (r107.i() == false) goto L54;
            int r109 = ((this.f427395g - r108) - this.f427398j.j()) + this.f427398j.P;
        L56:
            InlineAIDragView r110 = this.f427398j;
            float r111 = r109;
            int r112 = r110.f427356c.getHeight();
            float r113 = r110.f427356c.getTranslationY();
            Log.i("InlineAIDragView", "doNestedScrollRebound, currentHeight = " + r112 + ", currentTranslationY = " + r113 + ", targetHeight = " + r106 + ", targetTranslationY = " + r111 + ", currentTop = " + r110.f427356c.getY());
            if (r112 == r106) goto L59;
        L64:
            ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r114.addUpdateListener(new com.ss.android.lark.inline.ai.ui.g(r112, r106, r110, r113, r111));
            r114.setDuration(200);
            Intrinsics.checkNotNull(r114);
            r114.addListener(new com.ss.android.lark.inline.ai.ui.h(r110, r101));
            r114.start();
            return;
        L59:
            if (r113 == r111) goto L62;
            r100 = false;
        L62:
            if (r100 == false) goto L64;
            Log.i("InlineAIDragView", "doNestedScrollRebound, target pos is the same as current, so return");
            return;
        L54:
            r109 = this.f427395g - r108;
            goto L56
        L50:
            r108 = this.f427389a;
        L55:
            r109 = 0;
            goto L56
        L39:
            if (r104.F != null) goto L41;
            r105 = this.f427389a - r104.I;
            goto L42
        L35:
            if (this.f427398j.A == false) goto L41;
        L27:
            if ((r102.f427362i instanceof wlb.g) == false) goto L32;
            int r115 = r102.I;
            goto L32
        L29:
            InlineAIDragView r116 = this.f427398j;
            if ((r116.f427362i instanceof wlb.g) == false) goto L32;
            int r117 = r116.I;
            goto L32
        L7:
            if ((this.f427391c - this.f427389a) <= f0.a(60)) goto L9;
        L8:
            r101 = true;
            goto L23
        L11:
            if (this.f427398j.i() == false) goto L16;
            if (((((this.f427395g - this.f427391c) - this.f427398j.j()) + this.f427398j.P) / this.f427395g) < 0.2f) goto L17;
        L18:
            boolean r118 = false;
        L19:
            if (r118 == false) goto L9;
            if ((this.f427391c - this.f427389a) <= f0.a(60)) goto L9;
        L17:
            r118 = true;
            goto L19
        L16:
            if (this.f427391c <= this.f427398j.f427375v) goto L18;
            goto L17
        }

        public e(InlineAIDragView r100) {
            this.f427398j = r100;
            this.f427397i = f0.a(60);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final boolean a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Log.i("InlineAIDragView", "onNestedPreFling, velocityY = " + r101 + ", currentTop = " + this.f427390b + ", dampedCurrentTop = " + this.f427391c + ", startTop = " + this.f427389a + ", isDown = " + this.f427393e);
            this.f427394f = true;
            if (this.f427391c <= this.f427389a) goto L5;
            this.f427398j.o();
            d();
            return true;
        L5:
            InlineAIDragView.b(this.f427398j);
            return false;
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void onStopNestedScroll(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Log.i("InlineAIDragView", "onStopNestedScroll, type = " + r101 + ", hasFling = " + this.f427394f + ", dampedCurrentTop = " + this.f427391c + ", startTop = " + this.f427389a);
            if (r101 == 0) goto L5;
            return;
        L5:
            if (this.f427394f == false) goto L7;
            return;
        L7:
            if (this.f427391c == this.f427389a) goto L9;
            this.f427398j.o();
            d();
            return;
        L9:
            InlineAIDragView.b(this.f427398j);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void onStartNestedScroll(View r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            if (r102 != 0) goto L7;
            int r103 = (int) this.f427398j.f427356c.getY();
            this.f427389a = r103;
            this.f427390b = r103;
            this.f427391c = r103;
            this.f427392d = this.f427398j.f427356c.getHeight();
            InlineAIDragView r104 = this.f427398j;
            int r105 = r104.f427370q;
            this.f427395g = r105;
            this.f427396h = r105 - this.f427389a;
            this.f427393e = false;
            this.f427394f = false;
            r104.H = true;
            ValueAnimator r106 = r104.f427367n;
            if (r106 == null) goto L7;
            r106.cancel();
        L7:
            Log.i("InlineAIDragView", "onStartNestedScroll, startTop = " + this.f427389a + ", currentTop = " + this.f427390b + ", type = " + r102);
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void b(View r100, int r101, int r102, int[] r103) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "consumed");
            Log.d("InlineAIDragView", "onNestedScroll, dyUnconsumed = " + r101 + ", type = " + r102);
            if (r101 < 0) goto L5;
            return;
        L5:
            if (r102 == 1) goto L14;
            this.f427393e = true;
            r103[1] = r101;
            int r104 = this.f427390b - r101;
            this.f427390b = r104;
            int r105 = this.f427389a;
            if (r104 == r105) goto L11;
            int r106 = this.f427395g;
            int r107 = this.f427396h;
            int r108 = this.f427397i;
            r104 = r106 - ((int) ((((r107 - r108) / r107) * (r106 - r104)) + r108));
        L11:
            this.f427391c = r104;
            this.f427398j.f427356c.setTranslationY(r104 - r105);
            Log.d("InlineAIDragView", "onNestedScroll, currentTop = " + this.f427390b + ", dampedCurrentTop = " + this.f427391c);
            return;
        }

        @Override // com.ss.android.lark.inline.ai.ui.NSPConstraintLayout.a
        public final void c(View r100, int r101, int[] r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r102, "consumed");
            Log.d("InlineAIDragView", "onNestedPreScroll, dy = " + r101 + ", currentTop = " + this.f427390b + ", startTop = " + this.f427389a + ", type = " + r103);
            if (r101 > 0) goto L5;
            return;
        L5:
            if (r103 == 1) goto L21;
            this.f427393e = false;
            int r104 = this.f427390b;
            int r105 = this.f427389a;
            if (r104 <= r105) goto L20;
            int r106 = r104 - r105;
            if ((r106 - r101) >= 0) goto L12;
            r102[1] = r102[1] + r106;
            this.f427390b = r105;
        L13:
            int r107 = this.f427390b;
            if (r107 == r105) goto L17;
            int r108 = this.f427395g;
            int r109 = this.f427396h;
            int r110 = this.f427397i;
            r107 = r108 - ((int) ((((r109 - r110) / r109) * (r108 - r107)) + r110));
        L17:
            this.f427391c = r107;
            this.f427398j.f427356c.setTranslationY(r107 - r105);
            Log.d("InlineAIDragView", "onNestedPreScroll, currentTop = " + this.f427390b + ", dampedCurrentTop = " + this.f427391c);
            return;
        L12:
            r102[1] = r102[1] + r101;
            this.f427390b = r104 - r101;
            goto L13
        L20:
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f427400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f427401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f427402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f427403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f427404f;

        public f(InlineAIDragView r100, int r101, boolean r102, boolean r103, boolean r104, AdjustTopSource r105) {
            this.f427399a = r100;
            this.f427400b = r101;
            this.f427401c = r102;
            this.f427402d = r103;
            this.f427403e = r104;
            this.f427404f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("InlineAIDragView", "execute pending adjustToTop task");     // Catch: Throwable -> L4
            this.f427399a.d(this.f427400b, this.f427401c, this.f427402d, this.f427403e, this.f427404f);     // Catch: Throwable -> L4
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
        public final /* synthetic */ InlineAIDragView f427405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f427406b;

        public g(InlineAIDragView r100, AdjustTopSource r101) {
            this.f427405a = r100;
            this.f427406b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            int r102 = (int) ((Float) r101).floatValue();
            this.f427405a.d(r102, false, false, true, this.f427406b);
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f427407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427408b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f427407a == false) goto L9;
            InlineAIDragView r101 = this.f427408b;
            if (r101.A == false) goto L7;
            r101.f427358e.c();
            return;
        L7:
            r101.f427358e.onClose();
            return;
        }

        public h(boolean r100, InlineAIDragView r101) {
            this.f427407a = r100;
            this.f427408b = r101;
        }
    }

    public static final class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f427410b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            InlineAIDragView r101 = this.f427409a;
            r101.f427355b.setAlpha(0.0f);
            r101.f427356c.setTranslationY(0.0f);
            r101.f427353J = -1;
            Function0<Unit> r102 = this.f427410b;
            if (r102 == null) goto L6;
            r102.invoke();
            return;
        }

        public i(InlineAIDragView r100, Function0<Unit> r101) {
            this.f427409a = r100;
            this.f427410b = r101;
        }
    }

    public static final class j implements wlb.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427411a;

        public j(InlineAIDragView r100) {
            this.f427411a = r100;
        }

        @Override // wlb.g.a
        public final void b(int r100) {
            Log.i("InlineAIDragView", "content height change, contentHeight = " + r100 + ", isNestedScrolling = " + this.f427411a.H);
            InlineAIDragView r101 = this.f427411a;
            if ((r101.f427362i instanceof wlb.g) == true) goto L5;
            return;
        L5:
            if (r101.H == true) goto L17;
            r101.o();
            InlineAIDragView r102 = this.f427411a;
            if (r102.D == false) goto L10;
            int r103 = Math.max(r102.E, r102.I);
        L14:
            InlineAIDragView.e(r102, r103, this.f427411a.U, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
            return;
        L10:
            Integer r104 = r102.F;
            if (r104 == null) goto L13;
            r103 = Math.max(r104.intValue(), r102.I);
            goto L14
        L13:
            r103 = r102.I;
            goto L14
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427412a;

        public k(InlineAIDragView r100) {
            this.f427412a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f427412a.o();     // Catch: Throwable -> L4
            this.f427412a.n(false, false, AdjustTopSource.VIEW_CHANGE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427413a;

        public l(InlineAIDragView r100) {
            this.f427413a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f427413a.n(false, false, AdjustTopSource.VIEW_CHANGE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427414a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Log.i("InlineAIDragView", "onGlobalLayout, keyboardHeightMemory = " + this.f427414a.f427366m);
            this.f427414a.f427355b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            InlineAIDragView r100 = this.f427414a;
            r100.f427355b.addOnLayoutChangeListener(r100.W);
            FrameLayout r101 = (FrameLayout) this.f427414a.f427354a.findViewById(R.id.content);
            if (r101 == null) goto L6;
            r101.addOnLayoutChangeListener(this.f427414a.W);
        L6:
            if (Intrinsics.areEqual(this.f427414a.N, Boolean.TRUE) == false) goto L10;
            InlineAIDragView r102 = this.f427414a;
            if (r102.f427366m != 0) goto L10;
            r102.O = true;
            r102.f427355b.postDelayed(r102.X, 200);
            return;
        L10:
            InlineAIDragView.c(this.f427414a);
        }

        public m(InlineAIDragView r100) {
            this.f427414a = r100;
        }
    }

    public static final class n implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InlineAIDragView f427415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f427416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f427417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AdjustTopSource f427418d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f427415a.f427355b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f427415a.n(this.f427416b, this.f427417c, this.f427418d);
        }

        public n(InlineAIDragView r100, boolean r101, boolean r102, AdjustTopSource r103) {
            this.f427415a = r100;
            this.f427416b = r101;
            this.f427417c = r102;
            this.f427418d = r103;
        }
    }

    static {
    }

    public final void f() {
        this.f427369p = this.f427355b.getWidth();
        int r100 = this.f427355b.getHeight();
        this.f427370q = r100;
        float r101 = this.f427361h;
        if (r101 <= 0.0f) goto L5;
        float r102 = r100;
        this.f427372s = (int) (r102 - (r101 * r102));
    L6:
        float r103 = r100;
        this.f427373t = (int) (r103 - (0.6f * r103));
        this.f427374u = (int) (r103 - (0.3f * r103));
        this.f427375v = (int) (r103 - (0.2f * r103));
        boolean r104 = true;
        if (idb.f.a().isCurrentEnable("ccm.mobile.forseti") == false) goto L9;
    L20:
        WindowInsetsCompat r105 = ViewCompat.getRootWindowInsets(a(this.f427354a.getWindow()));
        if (r105 == null) goto L25;
        Insets r106 = r105.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r106 == null) goto L25;
        int r107 = r106.bottom;
    L26:
        int[] r108 = new int[2];
        this.f427355b.getLocationInWindow(r108);
        int[] r109 = new int[2];
        a(this.f427354a.getWindow()).getLocationInWindow(r109);
        this.f427378y = (r109[1] + r107) - r108[1];
        if (r105 == null) goto L31;
        Insets r110 = r105.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r110 == null) goto L31;
        int r111 = r110.bottom;
    L32:
        int[] r112 = new int[2];
        this.f427355b.getLocationInWindow(r112);
        int[] r113 = new int[2];
        a(this.f427354a.getWindow()).getLocationInWindow(r113);
        this.f427379z = ((r113[1] + a(this.f427354a.getWindow()).getHeight()) - r111) - (r112[1] + this.f427370q);
    L33:
        int r114 = this.f427359f;
        if (r114 != (-1)) goto L37;
        r114 = f0.a(44);
    L37:
        this.f427376w = r114 + Math.max(this.f427378y, 0);
        this.M = true;
        if (this.S == false) goto L47;
        int r115 = this.f427371r;
        if (r115 > 0) goto L42;
    L46:
        this.f427371r = this.f427370q;
        goto L47
    L42:
        if (r115 > this.f427370q) goto L45;
        r104 = false;
    L45:
        this.R = Boolean.valueOf(r104);
    L47:
        Log.i("InlineAIDragView", "calculateHeights, rootViewHeight = " + this.f427370q + ", topInNormalPercent = " + this.f427372s + ", topIn60Percent = " + this.f427373t + ", topIn30Percent = " + this.f427374u + ", topExceptNaviBar = " + this.f427376w + ", disBetweenRootTopAndActivityTop = " + this.f427378y + ", disBetweenRootBottomAndActivityBottom = " + this.f427379z);
        o();
        return;
    L31:
        r111 = 0;
    L25:
        r107 = 0;
        goto L26
    L9:
        if (CarUtils.a() == true) goto L20;
        FrameLayout r116 = (FrameLayout) this.f427354a.findViewById(R.id.content);
        if (r116 == null) goto L14;
        int[] r117 = new int[2];
        this.f427355b.getLocationInWindow(r117);
        int[] r118 = new int[2];
        r116.getLocationInWindow(r118);
        int r119 = r118[1] - r117[1];
    L15:
        this.f427378y = r119;
        if (r116 == null) goto L18;
        int[] r120 = new int[2];
        this.f427355b.getLocationInWindow(r120);
        int[] r121 = new int[2];
        r116.getLocationInWindow(r121);
        int r122 = (r121[1] + r116.getHeight()) - (r120[1] + this.f427370q);
    L19:
        this.f427379z = r122;
        goto L33
    L18:
        r122 = 0;
        goto L19
    L14:
        r119 = 0;
        goto L15
    L5:
        float r123 = r100;
        this.f427372s = (int) (r123 - (0.8f * r123));
        goto L6
    }

    public final boolean i() {
        Boolean r100 = this.N;
        if (r100 != null) goto L10;
        r100 = this.R;
        if (r100 != null) goto L10;
        return this.f427364k;
    L10:
        return r100.booleanValue();
    }

    public final int k() {
        return ((this.f427370q - j()) + this.P) - ((int) (this.f427370q * 0.3f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o() {
        if (this.f427361h <= 0.0f) goto L6;
        this.I = this.f427372s;
        return;
    L6:
        View r100 = this.f427362i;
        if ((r100 instanceof wlb.g) == false) goto L13;
        int r101 = r100.getHeight();
        int r102 = ((wlb.g) r100).getViewHeight();
        int r103 = this.f427356c.getHeight() + (r102 - r101);
        if (i() == false) goto L11;
        int r104 = Math.max(this.f427376w, Math.min((this.f427370q - r103) - j(), k()));
    L12:
        Log.i("InlineAIDragView", "updateSelfAdjustTop, currentContentHeight = " + r101 + ", targetContentHeight = " + r102 + ", targetPanelHeight = " + r103 + ", selfAdjustTop = " + r104);
    L17:
        this.I = r104;
        Log.i("InlineAIDragView", "updateSelfAdjustTop: " + this.I);
        return;
    L11:
        r104 = Math.max(this.f427372s, Math.min((this.f427370q - r103) - j(), this.f427374u));
        goto L12
    L13:
        Log.w("InlineAIDragView", "updateSelfAdjustTop, but is not selfAdjust");
        if (i() == false) goto L16;
        r104 = k();
        goto L17
    L16:
        r104 = this.f427374u;
        goto L17
    }

    public final int j() {
        if (i() == true) goto L5;
        int r100 = this.f427379z;
        if (r100 >= 0) goto L19;
        return this.Q - r100;
    L19:
        return this.Q;
    L5:
        if (this.S == false) goto L8;
        return this.P;
    L8:
        if (Intrinsics.areEqual(this.N, Boolean.TRUE) == false) goto L13;
        int r101 = this.f427365l;
        if (r101 > 0) goto L21;
        r101 = this.f427366m;
    L21:
        return Math.max(r101 + this.P, this.Q) - this.f427379z;
    L13:
        r101 = this.f427365l;
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

    public static final void b(InlineAIDragView r100) {
        r100.getClass();
        Log.i("InlineAIDragView", "onNestedScrollFinished");
        r100.H = false;
        if ((r100.f427362i instanceof wlb.g) == false) goto L10;
        r100.o();
        Integer r101 = r100.F;
        if (r101 == null) goto L7;
        int r102 = Math.max(r101.intValue(), r100.I);
    L8:
        e(r100, r102, true, false, AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L7:
        r102 = r100.I;
        goto L8
    }

    public static final void c(InlineAIDragView r100) {
        r100.getClass();
        Log.i("InlineAIDragView", "showInternal");
        r100.f();
        r100.n(true, false, AdjustTopSource.VIEW_CHANGE);
        r100.f427355b.post(new com.ss.android.lark.inline.ai.ui.l(r100));
    }

    public final void m(Boolean r100) {
        if (this.f427360g == false) goto L11;
        ViewParent r101 = this.f427355b.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
    L9:
        if (Intrinsics.areEqual(r102, a(this.f427354a.getWindow())) == true) goto L11;
        boolean r103 = true;
    L12:
        this.S = r103;
        Log.i("InlineAIDragView", "show, keyboardShowingByForce = " + r100 + ", isRootParentAdjustResize = " + this.S);
        this.O = false;
        this.f427364k = this.f427357d.isKeyboardShowing();
        int r104 = this.f427357d.c();
        if (r104 <= 0) goto L15;
        this.f427366m = r104;
    L15:
        this.f427365l = r104;
        this.f427357d.b(this.V);
        this.f427355b.setAlpha(0.0f);
        this.N = r100;
        this.f427355b.getViewTreeObserver().addOnGlobalLayoutListener(new m(this));
        this.f427355b.requestLayout();
        return;
    L7:
        r102 = null;
    L11:
        r103 = false;
        goto L12
    }

    public final void g(boolean r100, Function0<Unit> r101) {
        Log.i("InlineAIDragView", "dismiss, doAnim = " + r100);
        this.M = false;
        this.f427357d.a(this.V);
        ObjectAnimator r102 = this.K;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        ObjectAnimator r103 = this.L;
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        ValueAnimator r104 = this.f427367n;
        if (r104 == null) goto L11;
        r104.cancel();
    L11:
        ValueAnimator r105 = this.f427368o;
        if (r105 == null) goto L14;
        r105.cancel();
    L14:
        this.f427355b.removeCallbacks(this.Y);
        this.f427355b.removeOnLayoutChangeListener(this.W);
        ((FrameLayout) this.f427354a.findViewById(R.id.content)).removeOnLayoutChangeListener(this.W);
        if (r100 == false) goto L17;
        this.f427355b.setAlpha(1.0f);
        ViewGroup r106 = this.f427356c;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r106, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r106.getTranslationY(), this.f427370q - this.f427356c.getTop()});
        r107.setDuration(200);
        r107.setInterpolator(new DecelerateInterpolator());
        r107.addListener(new i(this, r101));
        this.L = r107;
        r107.start();
        return;
    L17:
        this.f427355b.setAlpha(0.0f);
        this.f427356c.setTranslationY(0.0f);
        this.f427353J = -1;
        r101.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(View r100, int r101) {
        Log.i("InlineAIDragView", "setAdjustableView, view = " + r100 + ", mode = " + r101 + ", isShown = " + this.f427355b.isShown() + ", heightsReady = " + this.M);
        KeyEvent.Callback r102 = this.f427362i;
        boolean r103 = true;
        boolean r104 = Intrinsics.areEqual(r102, r100) ^ true;
        if (r102 == null) goto L5;
    L7:
        r103 = false;
    L8:
        this.f427362i = r100;
        if (r104 == false) goto L17;
        if (r102 == null) goto L15;
        if ((r102 instanceof wlb.g) == false) goto L15;
        ((wlb.g) r102).setOnHeightChangeListener(null);
    L15:
        if ((r100 instanceof wlb.g) == false) goto L17;
        ((wlb.g) r100).setOnHeightChangeListener(new j(this));
    L17:
        this.f427363j = r101;
        if (r100 != 0) goto L21;
        ViewGroup r105 = this.f427356c;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.height = -2;
        r105.setLayoutParams(r106);
    L21:
        if (this.M == false) goto L26;
        this.f427355b.post(new k(this));
        if (r103 == false) goto L27;
        this.f427355b.postDelayed(new l(this), 100);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if ((r100 instanceof PromptsRecyclerView) == false) goto L7;
        goto L7
    }

    public final void h(boolean r100, boolean r101, AdjustTopSource r110) {
        Log.i("InlineAIDragView", "doRebound()... canHide = " + r100 + ", smooth = " + r101 + ", adjustTopSource = " + r110);
        if (i() == true) goto L5;
        float r102 = this.f427356c.getTop() + this.f427356c.getTranslationY();
        int r103 = this.f427373t;
        int r104 = this.f427372s;
        float r105 = (r103 + r104) / 2;
        if (r102 < r105) goto L29;
        if (r100 == true) goto L35;
    L52:
        boolean r106 = this.f427362i instanceof wlb.g;
        if (r106 == false) goto L58;
        int r107 = (int) r102;
        int r108 = this.I;
        if (r107 != r108) goto L58;
        Pair r109 = new Pair(Integer.valueOf(r108), Boolean.FALSE);
    L63:
        int r111 = ((Number) r109.component1()).intValue();
        boolean r112 = ((Boolean) r109.component2()).booleanValue();
        if (r110 == AdjustTopSource.DRAG) goto L66;
    L72:
        e(this, r111, r101, r112, r110, 8);
        int r113 = (this.f427370q - r111) + this.f427379z;
        if (r113 == this.f427353J) goto L76;
        this.f427358e.a(r113);
        this.f427353J = r113;
        return;
    L76:
        return;
    L66:
        if ((this.f427362i instanceof wlb.g) == false) goto L72;
        if (r111 != this.I) goto L70;
        Integer r114 = null;
    L71:
        this.F = r114;
        goto L72
    L70:
        r114 = Integer.valueOf(r111);
    L58:
        if (r106 == false) goto L60;
        int r115 = this.I;
    L61:
        Pair r116 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r103, r115)), Boolean.FALSE);
    L62:
        r109 = r116;
        goto L63
    L60:
        r115 = this.f427377x;
        goto L61
    L35:
        if (r102 >= this.f427374u) goto L40;
        if (r102 > r105) goto L52;
    L40:
        if (this.A == false) goto L51;
        boolean r117 = this.f427362i instanceof wlb.g;
        if (r117 == false) goto L47;
        int r118 = (int) r102;
        int r119 = this.I;
        if (r118 != r119) goto L47;
        r109 = new Pair(Integer.valueOf(r119), Boolean.FALSE);
    L47:
        if (r117 == false) goto L49;
        int r120 = this.I;
    L50:
        r116 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r103, r120)), Boolean.TRUE);
        goto L62
    L49:
        r120 = this.f427377x;
        goto L50
    L51:
        r109 = new Pair(Integer.valueOf(this.f427370q), Boolean.TRUE);
        goto L63
    L29:
        if ((this.f427362i instanceof wlb.g) == false) goto L31;
        int r121 = this.I;
    L32:
        r109 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r104, r121)), Boolean.FALSE);
        goto L63
    L31:
        r121 = this.f427377x;
        goto L32
    L5:
        if (this.f427363j != 0) goto L7;
        int r122 = this.f427376w;
    L8:
        float r123 = ((this.f427370q - j()) + this.P) - (this.f427356c.getTop() + this.f427356c.getTranslationY());
        if (r100 == false) goto L22;
        int r124 = this.f427370q;
        if ((r123 / r124) >= 0.3f) goto L22;
        if (this.A == true) goto L16;
        r116 = new Pair(Integer.valueOf(r124 - this.f427365l), Boolean.TRUE);
        goto L62
    L16:
        if ((this.f427362i instanceof wlb.g) == false) goto L18;
        int r125 = this.I;
    L19:
        r109 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r122, r125)), Boolean.TRUE);
        goto L63
    L18:
        r125 = this.f427377x;
    L22:
        if ((this.f427362i instanceof wlb.g) == false) goto L24;
        int r126 = this.I;
    L25:
        r109 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r122, r126)), Boolean.FALSE);
        goto L63
    L24:
        r126 = this.f427377x;
        goto L25
    L7:
        r122 = this.f427372s;
        goto L8
    }

    public final void n(boolean r110, boolean r111, AdjustTopSource r112) {
        if (this.M == true) goto L6;
        Log.w("InlineAIDragView", "updateHeight when heights are not ready! so return");
        return;
    L6:
        ObjectAnimator r100 = this.K;
        boolean r101 = true;
        if (r100 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
        Log.w("InlineAIDragView", "updateHeight when showAnim is running! so return");
        return;
    L15:
        int r103 = -2;
        if (this.f427356c.getHeight() != 0) goto L28;
        Log.w("InlineAIDragView", "height is 0, add layout observer");
        this.f427355b.getViewTreeObserver().addOnGlobalLayoutListener(new n(this, r110, r111, r112));
        if (this.f427356c.getLayoutParams().height <= 0) goto L20;
        return;
    L20:
        if (this.f427356c.getLayoutParams().height != (-1)) goto L22;
        return;
    L22:
        if (this.f427356c.getLayoutParams().height == (-2)) goto L145;
        ViewGroup r104 = this.f427356c;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (this.f427362i == null) goto L26;
        r103 = f0.a(500);
    L26:
        r105.height = r103;
        r104.setLayoutParams(r105);
        return;
    L145:
        return;
    L28:
        View r106 = this.f427362i;
        if (r106 != null) goto L32;
        ViewGroup r113 = this.f427356c;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        r114.height = -2;
        r113.setLayoutParams(r114);
        this.f427356c.measure(View.MeasureSpec.makeMeasureSpec(this.f427369p, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f427370q, Integer.MIN_VALUE));
        this.f427377x = (this.f427370q - this.f427356c.getMeasuredHeight()) - j();
    L36:
        Log.i("InlineAIDragView", "updateHeight, isInit = " + r110 + ", keyboardChange = " + r111 + ", isKeyboardShowing = " + this.f427364k + ", forceKeyboardWhenShowing = " + this.N + ", topWithMaxHeight = " + this.f427377x + ", adjustableView = " + r106);
        if (r111 == true) goto L39;
    L40:
        ViewGroup r107 = this.f427356c;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r110 == false) goto L43;
        int r115 = 0;
    L44:
        r109.bottomMargin = r115;
        r107.setLayoutParams(r109);
    L46:
        if (this.f427361h <= 0.0f) goto L49;
        e(this, this.f427372s, false, false, r112, 12);
        return;
    L49:
        if (r111 == false) goto L103;
        if (this.S == true) goto L103;
        this.G = false;
        ValueAnimator r116 = this.f427368o;
        if (r116 == null) goto L55;
        r116.cancel();
    L55:
        ObjectAnimator r117 = this.K;
        if (r117 == null) goto L58;
        r117.cancel();
    L58:
        ValueAnimator r118 = this.f427367n;
        if (r118 == null) goto L61;
        r118.cancel();
    L61:
        ViewGroup.LayoutParams r119 = this.f427356c.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r120 = ((ViewGroup.MarginLayoutParams) r119).bottomMargin;
        int r121 = this.f427356c.getHeight();
        float r122 = this.f427356c.getTranslationY();
        int r123 = j();
        if ((this.f427362i instanceof wlb.g) == false) goto L72;
        if (i() == false) goto L66;
        int r124 = Math.max(this.I, this.f427376w);
    L78:
        int r125 = r124;
        int r126 = (this.f427370q - r125) - r123;
        Log.i("InlineAIDragView", "doKeyboardAnimation, currentMarginBottom = " + r120 + ", currentHeight = " + r121 + ", currentTranslationY = " + r122 + ", targetMarginBottom = " + r123 + ", targetHeight = " + r126 + ", targetTranslationY = 0.0, currentTop = " + this.f427356c.getY() + ", targetTop = " + r125);
        if (r120 != r123) goto L87;
        if (r121 != r126) goto L87;
        if (r122 == 0.0f) goto L85;
        r101 = false;
    L85:
        if (r101 == false) goto L87;
        Log.i("InlineAIDragView", "doKeyboardAnimation, target pos is the same as current, so return");
        return;
    L87:
        ValueAnimator r127 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f427368o = r127;
        if (r127 == null) goto L90;
        r127.addUpdateListener(new com.ss.android.lark.inline.ai.ui.f(r121, r126, this, r120, r123, r122));
    L90:
        ValueAnimator r128 = this.f427368o;
        if (r128 == null) goto L93;
        r128.addListener(new com.ss.android.lark.inline.ai.ui.e(this));
    L93:
        ValueAnimator r129 = this.f427368o;
        if (r129 == null) goto L96;
        r129.setDuration(140);
    L96:
        ValueAnimator r130 = this.f427368o;
        if (r130 == null) goto L99;
        r130.start();
    L99:
        int r131 = (this.f427370q - r125) + this.f427379z;
        if (r131 == this.f427353J) goto L147;
        this.f427358e.a(r131);
        this.f427353J = r131;
        return;
    L147:
        return;
    L66:
        Integer r132 = this.F;
        if (r132 == null) goto L69;
        int r133 = Math.max(r132.intValue(), this.I);
    L70:
        r124 = Math.max(r133, this.f427372s);
        goto L78
    L69:
        r133 = this.I;
        goto L70
    L72:
        if (i() == true) goto L74;
        r124 = RangesKt.coerceAtLeast(this.f427373t, this.f427377x);
        goto L78
    L74:
        if (this.f427363j != 0) goto L76;
        r124 = RangesKt.coerceAtLeast(this.f427376w, this.f427377x);
        goto L78
    L76:
        r124 = RangesKt.coerceAtLeast(this.f427372s, this.f427377x);
    L103:
        if (this.D == false) goto L106;
        e(this, ((int) this.f427356c.getTranslationY()) + this.f427356c.getTop(), false, false, r112, 12);
        return;
    L106:
        if (this.H == true) goto L150;
        if (r110 == false) goto L126;
        if (i() == true) goto L111;
        View r134 = this.f427362i;
        if (this.f427363j == 0) goto L121;
    L123:
        int r135 = RangesKt.coerceAtLeast(this.f427373t, this.f427377x);
    L124:
        e(this, r135, false, false, r112, 12);
        return;
    L121:
        if ((r134 instanceof wlb.g) == false) goto L123;
        r135 = Math.max(this.f427372s, Math.min(this.I, this.f427374u));
        goto L124
    L111:
        if (this.f427363j != 0) goto L117;
        int r136 = this.f427376w;
        if ((this.f427362i instanceof wlb.g) == false) goto L115;
        int r137 = Math.min(this.I, this.f427374u);
    L116:
        r135 = Math.max(r136, r137);
        goto L124
    L115:
        r137 = this.f427377x;
        goto L116
    L117:
        r135 = RangesKt.coerceAtLeast(this.f427372s, this.f427377x);
        goto L124
    L126:
        if ((this.f427362i instanceof wlb.g) == false) goto L138;
        if (i() == false) goto L131;
        int r138 = Math.max(this.I, this.f427376w);
    L136:
        e(this, r138, false, false, r112, 12);
        return;
    L131:
        Integer r139 = this.F;
        if (r139 == null) goto L134;
        int r140 = Math.max(r139.intValue(), this.I);
    L135:
        r138 = Math.max(r140, this.f427372s);
        goto L136
    L134:
        r140 = this.I;
        goto L135
    L138:
        if (r112 != AdjustTopSource.CONTAINER_CHANGE) goto L141;
        r101 = false;
    L141:
        h(false, r101, r112);
        return;
    L150:
        return;
    L43:
        r115 = j();
        goto L44
    L39:
        if (this.S == false) goto L46;
    L32:
        if (this.f427363j != 0) goto L34;
        int r141 = 0;
    L35:
        this.f427377x = r141;
        goto L36
    L34:
        int r142 = this.f427356c.getHeight();
        int r143 = r106.getHeight();
        r106.measure(View.MeasureSpec.makeMeasureSpec(r106.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f427370q, Integer.MIN_VALUE));
        Log.i("InlineAIDragView", "initContainerHeight: " + r142 + ", initAdjustableViewHeight: " + r143 + ", measuredHeight: " + r106.getMeasuredHeight());
        r141 = (this.f427370q - (r142 + (r106.getMeasuredHeight() - r143))) - j();
        goto L35
    L9:
        if (r100.isRunning() != true) goto L11;
        r102 = true;
        goto L12
    }

    public final void d(int r110, boolean r111, boolean r112, boolean r113, AdjustTopSource r114) {
        if (this.H == false) goto L6;
        return;
    L6:
        if (r111 == false) goto L8;
        Log.i("InlineAIDragView", "adjustToTop, targetTop = " + r110 + ", currentTop = " + this.f427356c.getY() + ", smooth = true, isHide = " + r112 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r113 + ", adjustTopSource = " + r114);
    L9:
        ValueAnimator r100 = this.f427368o;
        if (r100 != null) goto L12;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L18;
        this.T = new f(this, r110, r111, r112, r113, r114);
        Log.i("InlineAIDragView", "keyboardAnimation is running, add pending adjustToTop task");
        return;
    L18:
        if (r113 == true) goto L23;
        ValueAnimator r102 = this.f427367n;
        if (r102 == null) goto L23;
        r102.cancel();
    L23:
        if (r111 == false) goto L44;
        if (r110 != ((int) this.f427356c.getY())) goto L28;
        Log.i("InlineAIDragView", "adjustToTop smooth return");
        return;
    L28:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{this.f427356c.getY(), r110});
        this.f427367n = r103;
        if (r103 == null) goto L31;
        r103.setDuration(200);
    L31:
        ValueAnimator r104 = this.f427367n;
        if (r104 == null) goto L34;
        r104.setInterpolator(new DecelerateInterpolator());
    L34:
        ValueAnimator r105 = this.f427367n;
        if (r105 == null) goto L37;
        r105.addUpdateListener(new g(this, r114));
    L37:
        ValueAnimator r106 = this.f427367n;
        if (r106 == null) goto L40;
        r106.addListener(new h(r112, this));
    L40:
        ValueAnimator r107 = this.f427367n;
        if (r107 == null) goto L108;
        r107.start();
        return;
    L108:
        return;
    L44:
        if (this.f427362i != null) goto L46;
    L52:
        int r108 = -2;
        if (i() == false) goto L89;
        if (this.f427363j != 0) goto L57;
        int r109 = this.f427376w;
    L59:
        if (r110 > Math.max(r109, this.f427377x)) goto L70;
        this.f427356c.setTranslationY(0.0f);
        ViewGroup r115 = this.f427356c;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L68;
        if (this.f427362i == null) goto L66;
        r108 = (this.f427370q - Math.max(r109, this.f427377x)) - j();
    L66:
        r116.height = r108;
        r115.setLayoutParams(r116);
        return;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L70:
        if (this.f427362i != null) goto L77;
        this.f427356c.setTranslationY(r110 - Math.max(r109, this.f427377x));
        ViewGroup r117 = this.f427356c;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L75;
        r118.height = -2;
        r117.setLayoutParams(r118);
        return;
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L77:
        if (r110 > k()) goto L83;
        this.f427356c.setTranslationY(0.0f);
        ViewGroup r119 = this.f427356c;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L82;
        r120.height = (this.f427370q - r110) - j();
        r119.setLayoutParams(r120);
        return;
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L83:
        this.f427356c.setTranslationY(r110 - k());
        ViewGroup r121 = this.f427356c;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if (r122 == null) goto L87;
        r122.height = (this.f427370q - k()) - j();
        r121.setLayoutParams(r122);
        return;
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L57:
        r109 = this.f427372s;
        goto L59
    L89:
        if (r110 >= RangesKt.coerceAtLeast(this.f427372s, this.f427377x)) goto L96;
        ViewGroup r123 = this.f427356c;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (this.f427362i == null) goto L94;
        r108 = (this.f427370q - RangesKt.coerceAtLeast(this.f427372s, this.f427377x)) - j();
    L94:
        r124.height = r108;
        r123.setLayoutParams(r124);
        this.f427356c.setTranslationY(0.0f);
        return;
    L96:
        if (r110 <= RangesKt.coerceAtLeast(this.f427374u, this.f427377x)) goto L102;
        ViewGroup r125 = this.f427356c;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if (this.f427362i == null) goto L101;
        r108 = (this.f427370q - RangesKt.coerceAtLeast(this.f427374u, this.f427377x)) - j();
    L101:
        r126.height = r108;
        r125.setLayoutParams(r126);
        this.f427356c.setTranslationY(r110 - RangesKt.coerceAtLeast(this.f427374u, this.f427377x));
        return;
    L102:
        ViewGroup r127 = this.f427356c;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (this.f427362i == null) goto L106;
        r108 = (this.f427370q - r110) - j();
    L106:
        r128.height = r108;
        r127.setLayoutParams(r128);
        this.f427356c.setTranslationY(0.0f);
        return;
    L46:
        if (CollectionsKt.listOf(new AdjustTopSource[]{AdjustTopSource.VIEW_CHANGE, AdjustTopSource.CONTENT_HEIGHT_CHANGE}).contains(r114) == false) goto L52;
        if (this.f427363j != 0) goto L50;
        int r129 = this.f427376w;
    L51:
        ViewGroup r130 = this.f427356c;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        r131.height = (this.f427370q - RangesKt.coerceAtLeast(r129, r110)) - j();
        r130.setLayoutParams(r131);
        this.f427356c.setTranslationY(0.0f);
        return;
    L50:
        r129 = this.f427372s;
        goto L51
    L12:
        if (r100.isRunning() != true) goto L14;
        r101 = true;
        goto L15
    L8:
        Log.d("InlineAIDragView", "adjustToTop, targetTop = " + r110 + ", currentTop = " + this.f427356c.getY() + ", smooth = false, isHide = " + r112 + ", forceKeyboardWhenShowing = " + this.N + ", fromAnimation = " + r113 + ", adjustTopSource = " + r114);
        goto L9
    }

    public static /* synthetic */ void e(InlineAIDragView r100, int r101, boolean r102, boolean r103, AdjustTopSource r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        boolean r104 = false;
    L6:
        r100.d(r101, r102, r104, false, r110);
        return;
    L5:
        r104 = r103;
        goto L6
    }

    public InlineAIDragView(FragmentActivity r100, ConstraintLayout r101, ConstraintLayout r102, wlb.d r103, d r104, slb.a r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "panelRootView");
        Intrinsics.checkNotNullParameter(r102, "panelView");
        Intrinsics.checkNotNullParameter(r103, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r104, "callback");
        this.f427354a = r100;
        this.f427355b = r101;
        this.f427356c = r102;
        this.f427357d = r103;
        this.f427358e = r104;
        this.f427359f = r106;
        this.f427360g = r107;
        this.f427364k = r103.isKeyboardShowing();
        this.f427365l = r103.c();
        this.f427366m = r103.c();
        this.C = true;
        this.G = true;
        this.I = Integer.MAX_VALUE;
        this.f427353J = -1;
        if ((r102 instanceof NSPConstraintLayout) == false) goto L5;
        ((NSPConstraintLayout) r102).setNSPHandler(new e(this));
    L5:
        if (r105 == null) goto L7;
        int r108 = r105.f542512b;
    L8:
        this.P = r108;
        if (r105 == null) goto L11;
        int r109 = r105.f542511a;
    L12:
        this.Q = r109;
        this.V = new com.ss.android.lark.inline.ai.ui.j(this);
        this.W = new com.ss.android.lark.inline.ai.ui.k(this);
        r101.setOnTouchListener(new a(this));
        this.X = new com.ss.android.lark.inline.ai.ui.d(this);
        this.Y = new com.ss.android.lark.inline.ai.ui.c(this);
        return;
    L11:
        r109 = f0.a(32);
        goto L12
    L7:
        r108 = f0.a(8);
        goto L8
    }
}
