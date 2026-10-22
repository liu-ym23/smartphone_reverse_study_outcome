package xl4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Outline;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.dux.popover.DuxPopoverLayout;
import com.bytedance.dux.popover.PopoverTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends PopupWindow {
    public static final /* synthetic */ int I = 0;
    public AnimatorSet A;
    public final Activity B;
    public final View C;
    public final c D;
    public final e E;
    public final d F;
    public final boolean G;
    public final g H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f564441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f564442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f564443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f564444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f564445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f564446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f564447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f564448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f564449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f564450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f564451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f564452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f564453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f564454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f564455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f564456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f564457q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f564458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f564459s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f564460t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f564461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f564462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DuxPopoverLayout f564463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PopoverTextView f564464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f564465y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f564466z;

    /* JADX INFO: renamed from: xl4.a$a, reason: collision with other inner class name */
    public static final class C8252a {
        public boolean A;
        public int B;
        public float C;
        public boolean D;
        public final boolean E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f564467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f564468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f564469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f564470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f564471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f564472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f564473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f564474h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f564475i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f564476j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f564477k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f564478l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f564479m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f564480n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f564481o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f564482p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public c f564483q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public d f564484r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public e f564485s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f564486t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final float f564487u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f564488v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f564489w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f564490x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f564491y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f564492z;

        public final Activity getActivity() {
            return this.f564467a;
        }

        public C8252a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f564467a = r100;
            this.f564475i = 5000;
            this.f564476j = true;
            this.f564480n = "";
            this.f564481o = 14.0f;
            this.f564486t = true;
            this.f564487u = 10.0f;
            this.f564488v = true;
            this.f564490x = -16777216;
            this.f564491y = 2.0f;
            this.C = DuxPopoverLayout.A;
            this.E = true;
        }
    }

    public static final class b {
        public static int a(int r100) {
            if (r100 != 8388611) goto L5;
            return 3;
        L5:
            if (r100 != 8388613) goto L11;
            return 5;
        L11:
            return r100;
        }
    }

    public interface c {
        void clickBubble();
    }

    public interface d {
        void bubbleDismiss();
    }

    public interface e {
        void bubbleShow();
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f564493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DuxPopoverLayout f564494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f564495c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            if (this.f564493a == true) goto L23;
            this.f564494b.setVisibility(8);
            d r101 = this.f564495c.F;
            if (r101 == null) goto L7;
            r101.bubbleDismiss();
        L7:
            a r102 = this.f564495c;
            AnimatorSet r103 = r102.A;
            if (r103 == null) goto L10;
            r103.removeAllListeners();
        L10:
            AnimatorSet r104 = r102.A;
            if (r104 == null) goto L13;
            r104.cancel();
        L13:
            r102.A = null;
            if (r102.B.isFinishing() == false) goto L16;
            return;
        L16:
            if (r102.isShowing() == false) goto L25;
            a.a(r102);     // Catch: Exception -> L20
            return;
        L26:
            return;
        L25:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            if (this.f564493a == false) goto L9;
            e r101 = this.f564495c.E;
            if (r101 == null) goto L7;
            r101.bubbleShow();
        L7:
            this.f564494b.setVisibility(0);
            return;
        }

        public f(boolean r100, DuxPopoverLayout r101, a r102) {
            this.f564493a = r100;
            this.f564494b = r101;
            this.f564495c = r102;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564496a;

        public g(a r100) {
            this.f564496a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f564496a;     // Catch: Throwable -> L6
            if (r100.f564456p == false) goto L9;
            r100.b(false);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564497a;

        public h(a r100) {
            this.f564497a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f564497a.D;
            if (r101 == null) goto L5;
            r101.clickBubble();
        L5:
            this.f564497a.getClass();
            a r102 = this.f564497a;
            PopupWindowLancet.handleDismissBeforeOrigin(r102);
            r102.dismiss();
        }
    }

    public static final class i extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564498a;

        public i(a r100) {
            this.f564498a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            DuxPopoverLayout r102 = this.f564498a.f564463w;
            DuxPopoverLayout r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
            r102 = null;
        L5:
            DuxPopoverLayout r104 = this.f564498a.f564463w;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
            r104 = null;
        L8:
            float r105 = r104.getMWidth();
            DuxPopoverLayout r106 = this.f564498a.f564463w;
            if (r106 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
            r106 = null;
        L11:
            r102.b(r105, r106.getMHeight());
            if (r101 == null) goto L22;
            DuxPopoverLayout r107 = this.f564498a.f564463w;     // Catch: Exception -> L19
            if (r107 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");     // Catch: Exception -> L19
        L17:
            r101.setConvexPath(r103.getFullPath());     // Catch: Exception -> L19
            return;
        L16:
            r103 = r107;
        L23:
            return;
        }
    }

    static {
    }

    public final int d() {
        DuxPopoverLayout r100 = this.f564463w;
        if (r100 == null) goto L7;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L9:
        return r100.getArrowHeight();
    L7:
        return 0;
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.f564465y == true) goto L6;
        b(false);
        getContentView().removeCallbacks(this.H);
        this.f564449i = 0;
        this.f564450j = 0;
        return;
    }

    public final void h() {
        int r100 = this.f564452l;
        if (r100 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.f564453m == 0) goto L7;
        int r101 = View.MeasureSpec.makeMeasureSpec(r100, 1073741824);
        int r102 = View.MeasureSpec.makeMeasureSpec(this.f564453m, 1073741824);
        getContentView().measure(r101, r102);
    }

    public final int e() {
        h();
        return getContentView().getMeasuredHeight();
    }

    public final int f() {
        h();
        return getContentView().getMeasuredWidth();
    }

    public a(C8252a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        this.f564447g = -16777216;
        this.f564451k = 5000;
        this.f564454n = true;
        this.f564456p = true;
        this.f564458r = 2.0f;
        this.f564460t = DuxPopoverLayout.A;
        this.f564462v = true;
        Activity r100 = r110.getActivity();
        this.B = r100;
        this.f564441a = r110.f564468b;
        this.f564443c = r110.f564469c;
        int r101 = r110.f564470d;
        this.f564444d = r101;
        this.f564445e = r110.f564471e;
        this.f564448h = Boolean.valueOf(r110.f564472f);
        this.f564449i = r110.f564473g;
        this.f564450j = r110.f564474h;
        this.f564451k = r110.f564475i;
        boolean r102 = r110.f564476j;
        View r103 = r110.f564477k;
        this.C = r103;
        int r104 = r110.f564479m;
        this.f564453m = r104;
        int r105 = r110.f564478l;
        this.f564452l = r105;
        String r106 = r110.f564480n;
        float r111 = r110.f564481o;
        int r112 = r110.f564482p;
        this.D = r110.f564483q;
        this.F = r110.f564484r;
        this.E = r110.f564485s;
        this.f564454n = r110.f564486t;
        float r113 = r110.f564487u;
        boolean r114 = r110.f564488v;
        this.f564446f = r110.f564489w;
        int r115 = r110.f564490x;
        this.f564447g = r115;
        this.f564457q = false;
        this.f564458r = r110.f564491y;
        this.f564459s = r110.f564492z;
        this.G = r110.A;
        int r107 = r110.B;
        this.f564460t = r110.C;
        this.f564461u = r110.D;
        this.f564462v = r110.E;
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(r114);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (r102 == true) goto L9;
        if (r103 == null) goto L9;
        i(r103);
        DuxPopoverLayout r108 = this.f564463w;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r108 = null;
    L8:
        r108.setUseDefaultView(false);
        boolean r116 = true;
    L56:
        if (r105 == 0) goto L60;
        if (r104 == 0) goto L60;
        setWidth(r105);
        setHeight(r104);
        DuxPopoverLayout.C = getWidth();
        DuxPopoverLayout.D = getHeight();
    L60:
        if (Intrinsics.areEqual(this.f564448h, Boolean.TRUE) == true) goto L62;
    L65:
        if (r101 == 0) goto L70;
        DuxPopoverLayout r109 = this.f564463w;
        if (r109 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r109 = null;
    L69:
        r109.setMBgColor(r101);
    L70:
        DuxPopoverLayout r117 = this.f564463w;
        if (r117 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r117 = null;
    L73:
        r117.setBubbleOrientation(g(b.a(this.f564441a)));
        if (r113 == 0.0f) goto L77;
        r116 = false;
    L77:
        if (r116 == true) goto L82;
        DuxPopoverLayout r118 = this.f564463w;
        if (r118 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r118 = null;
    L81:
        r118.setMPadding(r113);
    L82:
        DuxPopoverLayout r119 = this.f564463w;
        if (r119 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r119 = null;
    L85:
        r119.getShadowConfig().f205460d = r115;
        DuxPopoverLayout r120 = this.f564463w;
        if (r120 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r120 = null;
    L88:
        r120.getShadowConfig().f205457a = this.f564458r;
        DuxPopoverLayout r121 = this.f564463w;
        if (r121 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r121 = null;
    L91:
        r121.setBorderColor(r107);
        DuxPopoverLayout r122 = this.f564463w;
        if (r122 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r122 = null;
    L94:
        r122.setBorderWidth(0);
        DuxPopoverLayout r123 = this.f564463w;
        if (r123 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        DuxPopoverLayout r124 = null;
    L98:
        r124.setTransparentBg(false);
        this.H = new g(this);
        return;
    L97:
        r124 = r123;
        goto L98
    L62:
        if (Intrinsics.areEqual(this.f564448h, Boolean.FALSE) == true) goto L65;
        getContentView().setSystemUiVisibility(4102);
    L9:
        PopoverTextView r125 = new PopoverTextView(this.B, null);
        this.f564464x = r125;
        if (r112 == 0) goto L12;
        r125.setTextColor(r112);
    L13:
        PopoverTextView r126 = this.f564464x;
        if (r126 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r126 = null;
    L16:
        r126.setTextSize(2, 14.0f);
        PopoverTextView r127 = this.f564464x;
        if (r127 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r127 = null;
    L19:
        r127.setTextAlignment(5);
        PopoverTextView r128 = this.f564464x;
        if (r128 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r128 = null;
    L22:
        r128.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopoverTextView r129 = this.f564464x;
        if (r129 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r129 = null;
    L25:
        r129.setGravity(17);
        PopoverTextView r130 = this.f564464x;
        if (r130 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r130 = null;
    L28:
        float r131 = MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE;
        Resources r132 = Resources.getSystem();
        r116 = true;
        r130.setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r131, WindowDisplayMetricsOverride.apply(r132, r132.getDisplayMetrics()))));
        PopoverTextView r133 = this.f564464x;
        if (r133 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r133 = null;
    L31:
        r133.setMaxLines(1);
        PopoverTextView r134 = this.f564464x;
        if (r134 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r134 = null;
    L34:
        r134.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r135 = this.f564464x;
        if (r135 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r135 = null;
    L37:
        i(r135);
        if (this.f564448h != null) goto L41;
        this.f564448h = Boolean.TRUE;
    L41:
        if (TextUtils.isEmpty(r106) == true) goto L47;
        PopoverTextView r136 = this.f564464x;
        if (r136 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r136 = null;
    L45:
        r136.setText(r106);
    L47:
        if (r111 != 0.0f) goto L49;
        boolean r137 = true;
    L50:
        if (r137 == true) goto L55;
        PopoverTextView r138 = this.f564464x;
        if (r138 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r138 = null;
    L54:
        r138.setTextSize(2, r111);
    L55:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        goto L56
    L49:
        r137 = false;
        goto L50
    L12:
        r125.setTextColor(ContextCompat.getColor(r100, R.color.ConstTextInverse));
        goto L13
    }

    public static void a(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        super.dismiss();
    }

    public static int g(int r100) {
        int r101 = b.a(r100);
        if (r101 != 3) goto L5;
        return 2;
    L5:
        if (r101 != 5) goto L7;
    L12:
        return 1;
    L7:
        if (r101 != 48) goto L9;
        return 3;
    L9:
        if (r101 != 80) goto L12;
        return 0;
    }

    public final void b(boolean r110) {
        DuxPopoverLayout r100 = this.f564463w;
        DuxPopoverLayout r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L6:
        if (r110 == true) goto L8;
        this.f564465y = true;
    L8:
        this.A = new AnimatorSet();
        int r102 = b.a(this.f564441a);
        float r103 = 0.0f;
        if (r102 != 3) goto L11;
        float r104 = r100.getX() + r100.getMeasuredWidth();
        float r105 = r100.getY();
        DuxPopoverLayout r106 = this.f564463w;
        if (r106 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L36:
        float r107 = r101.getBubbleOffset();
    L37:
        float r108 = r107 + r105;
    L38:
        r100.setPivotY(r108);
        r100.setPivotX(r104);
        Interpolator r109 = PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        Interpolator r111 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.9f, 0.6f);
        float[] r112 = new float[2];
        if (r110 == false) goto L41;
        float r113 = 0.0f;
    L42:
        r112[0] = r113;
        if (r110 == false) goto L45;
        r103 = 1.0f;
    L45:
        r112[1] = r103;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r100, "alpha", r112);
        if (r110 == true) goto L49;
        r109 = r111;
    L49:
        r114.setInterpolator(r109);
        if (r110 == false) goto L52;
        long r115 = 90;
    L53:
        r114.setDuration(r115);
        float[] r116 = new float[2];
        float r117 = 0.5f;
        if (r110 == false) goto L56;
        float r118 = 0.5f;
    L57:
        r116[0] = r118;
        float r119 = 0.8f;
        if (r110 == false) goto L60;
        float r120 = 1.0f;
    L61:
        r116[1] = r120;
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, r116);
        if (r110 == false) goto L64;
        Interpolator r122 = new vl4.b(0.61f);
    L65:
        r121.setInterpolator(r122);
        if (r110 == false) goto L68;
        long r123 = 420;
    L69:
        r121.setDuration(r123);
        float[] r124 = new float[2];
        if (r110 == true) goto L73;
        r117 = 1.0f;
    L73:
        r124[0] = r117;
        if (r110 == false) goto L76;
        r119 = 1.0f;
    L76:
        r124[1] = r119;
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, r124);
        if (r110 == false) goto L79;
        r111 = new vl4.b(0.61f);
    L79:
        r125.setInterpolator(r111);
        if (r110 == false) goto L82;
        long r126 = 420;
    L83:
        r125.setDuration(r126);
        r100.setVisibility(0);
        AnimatorSet r127 = this.A;
        if (r127 == null) goto L90;
        AnimatorSet.Builder r128 = r127.play(r121);
        if (r128 == null) goto L90;
        AnimatorSet.Builder r129 = r128.with(r125);
        if (r129 == null) goto L90;
        r129.with(r114);
    L90:
        AnimatorSet r130 = this.A;
        if (r130 == null) goto L94;
        r130.addListener(new f(r110, r100, this));
    L94:
        if (this.f564445e == false) goto L100;
        if (r110 == false) goto L100;
        AnimatorSet r131 = this.A;
        if (r131 == null) goto L100;
        r131.setInterpolator(new OvershootInterpolator(1.0f));
    L100:
        AnimatorSet r132 = this.A;
        if (r132 == null) goto L104;
        r132.start();
        return;
    L104:
        return;
    L82:
        r126 = 120;
        goto L83
    L68:
        r123 = 120;
        goto L69
    L64:
        r122 = r111;
        goto L65
    L60:
        r120 = 0.8f;
        goto L61
    L56:
        r118 = 1.0f;
        goto L57
    L52:
        r115 = 120;
        goto L53
    L41:
        r113 = 1.0f;
        goto L42
    L35:
        r101 = r106;
        goto L36
    L11:
        if (r102 != 5) goto L13;
        r104 = r100.getX();
        r105 = r100.getY();
        DuxPopoverLayout r133 = this.f564463w;
        if (r133 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L31:
        r107 = r101.getBubbleOffset();
        goto L37
    L30:
        r101 = r133;
        goto L31
    L13:
        if (r102 != 48) goto L15;
        float r134 = r100.getX();
        DuxPopoverLayout r135 = this.f564463w;
        if (r135 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L26:
        r104 = r134 + r101.getBubbleOffset();
        r108 = r100.getY() + r100.getMeasuredHeight();
        goto L38
    L25:
        r101 = r135;
        goto L26
    L15:
        if (r102 == 80) goto L17;
        r108 = 0.0f;
        r104 = 0.0f;
        goto L38
    L17:
        float r136 = r100.getX();
        DuxPopoverLayout r137 = this.f564463w;
        if (r137 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L21:
        r104 = r136 + r101.getBubbleOffset();
        r108 = r100.getY();
        goto L38
    L20:
        r101 = r137;
        goto L21
    }

    public final void i(View r100) {
        DuxPopoverLayout r101 = new DuxPopoverLayout(this.B);
        this.f564463w = r101;
        r101.setBackgroundColor(0);
        DuxPopoverLayout r102 = this.f564463w;
        DuxPopoverLayout r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r102 = null;
    L5:
        r102.setCornerRadius(this.f564460t);
        DuxPopoverLayout r104 = this.f564463w;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r104 = null;
    L8:
        r104.addView(r100);
        DuxPopoverLayout r105 = this.f564463w;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r105 = null;
    L11:
        r105.setGravity(17);
        ViewGroup.MarginLayoutParams r106 = new ViewGroup.MarginLayoutParams(-2, -2);
        DuxPopoverLayout r107 = this.f564463w;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r107 = null;
    L14:
        r107.setLayoutParams(r106);
        DuxPopoverLayout r108 = this.f564463w;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r108 = null;
    L17:
        r108.setVisibility(8);
        if (this.f564444d == 0) goto L23;
        DuxPopoverLayout r109 = this.f564463w;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r109 = null;
    L22:
        r109.setMBgColor(this.f564444d);
    L23:
        DuxPopoverLayout r110 = this.f564463w;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r110 = null;
    L26:
        r110.setMNeedArrow(this.f564454n);
        DuxPopoverLayout r111 = this.f564463w;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r111 = null;
    L29:
        r111.setMNeedShadow(this.f564446f);
        DuxPopoverLayout r112 = this.f564463w;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r112 = null;
    L32:
        r112.setClearBitmapCacheEnabled(false);
        DuxPopoverLayout r113 = this.f564463w;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r113 = null;
    L35:
        r113.getShadowConfig().f205460d = this.f564447g;
        if (this.f564462v == false) goto L44;
        DuxPopoverLayout r114 = this.f564463w;
        if (r114 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r114 = null;
    L40:
        r114.setClickable(true);
        DuxPopoverLayout r115 = this.f564463w;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r115 = null;
    L43:
        r115.setOnClickListener(new h(this));
    L48:
        DuxPopoverLayout r116 = this.f564463w;
        if (r116 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r116 = null;
    L51:
        setContentView(r116);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r117 = Build.VERSION.SDK_INT;
        if (r117 >= 29) goto L54;
        return;
    L54:
        if (this.G == false) goto L71;
        DuxPopoverLayout r118 = this.f564463w;
        if (r118 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r118 = null;
    L58:
        DuxPopoverLayout r119 = this.f564463w;
        if (r119 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r119 = null;
    L61:
        float r120 = r119.getMWidth();
        DuxPopoverLayout r121 = this.f564463w;
        if (r121 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L65:
        r118.b(r120, r103.getMHeight());
        setElevation(50.0f);
        this.f564446f = false;
        this.f564458r = 0.0f;
        getContentView().setOutlineProvider(new i(this));
        if (r117 < 28) goto L68;
        getContentView().setOutlineSpotShadowColor(ColorProtector.parseColor("#8C000000"));
    L68:
        getContentView().setClipToOutline(true);
        return;
    L64:
        r103 = r121;
        goto L65
    L71:
        return;
    L44:
        DuxPopoverLayout r122 = this.f564463w;
        if (r122 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r122 = null;
    L47:
        r122.setClickable(false);
        goto L48
    }

    public final void j(int r100) {
        DuxPopoverLayout r101 = this.f564463w;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r101 = null;
    L5:
        r101.setBubbleOrientation(g(b.a(r100)));
    }

    public final void k(View r110, int r111, boolean r112) {
        int r113 = b.a(r111);
        if (this.B.isFinishing() == true) goto L54;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.getWindowToken() == null) goto L58;
        r110.getMeasuredHeight();
        r110.getMeasuredWidth();
        getContentView().removeCallbacks(this.H);
        this.f564441a = r113;
        DuxPopoverLayout r100 = this.f564463w;
        DuxPopoverLayout r101 = null;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
        r100 = null;
    L11:
        this.f564466z = r100.getPadding();
        if (isShowing() == true) goto L52;
        int r102 = g(r113);
        h();
        if (r112 == false) goto L23;
        if (r113 != 48) goto L18;
    L20:
        int r103 = f();
    L21:
        this.f564442b = r103 / 2.0f;
    L25:
        DuxPopoverLayout r104 = this.f564463w;
        if (r104 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mDuxBubbleLayout");
    L29:
        r101.f205443l = this.f564442b + this.f564443c;
        r101.f205444m = r102;
        int r114 = b.a(r113);
        int[] r105 = new int[2];
        if (this.f564459s == false) goto L32;
        r110.getLocationInWindow(r105);
    L33:
        int[] r115 = c(this, r112, r114, r110.getMeasuredWidth(), r110.getMeasuredHeight());
        if (this.f564461u == false) goto L39;
        int r116 = r115[0];
        int r117 = r115[1] - r110.getMeasuredHeight();
        OverlaySource r106 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r110, r106) == true) goto L49;
        showAsDropDown(r110, r116, r117, 0);
        PopupWindowLancet.trackAfterShow(this, r106, r110);
    L49:
        this.f564465y = false;
        if (this.f564451k <= 0) goto L56;
        getContentView().postDelayed(this.H, this.f564451k);
        return;
    L56:
        return;
    L39:
        int r118 = r105[0] + r115[0];
        int r107 = r105[1] + r115[1];
        if (PopupWindowLancet.hasSubWindowToken(r110) == true) goto L49;
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L45;
        showAtLocation(r110, 0, r118, r107);
        goto L49
    L45:
        OverlaySource r119 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r110, r119, 0, r118, r107) == true) goto L49;
        showAtLocation(r110, 0, r118, r107);
        PopupWindowLancet.trackAfterShow(this, r119, r110);
        goto L49
    L32:
        r110.getLocationOnScreen(r105);
        goto L33
    L28:
        r101 = r104;
        goto L29
    L18:
        if (r113 == 80) goto L20;
        r103 = e();
        goto L21
    L23:
        if (this.f564455o == true) goto L25;
        this.f564443c += this.f564466z;
        this.f564455o = true;
        goto L25
    L52:
        a(this);
        return;
    L58:
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102, int r103) {
        int r104 = b.a(r103);
        OverlaySource r105 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L9
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r105) == true) goto L7;
        super.showAsDropDown(r100, r101, r102, r104);     // Catch: Exception -> L9
        PopupWindowLancet.trackAfterShow(this, r105, r100);     // Catch: Exception -> L9
    L7:
        this.f564465y = false;     // Catch: Exception -> L9
        b(true);     // Catch: Exception -> L9
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        int r102 = b.a(r101);
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L7;
    L13:
        this.f564465y = false;     // Catch: Exception -> L15
        b(true);     // Catch: Exception -> L15
        return;
    L7:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L9;
        super.showAtLocation(r100, r102, r110, r111);     // Catch: Exception -> L15
        goto L13
    L9:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L15
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r103, r102, r110, r111) == true) goto L13;
        super.showAtLocation(r100, r102, r110, r111);     // Catch: Exception -> L15
        PopupWindowLancet.trackAfterShow(this, r103, r100);     // Catch: Exception -> L15
    }

    public static int[] c(a r100, boolean r101, int r110, int r111, int r112) {
        int[] r102 = new int[2];
        if (r100.f564457q == false) goto L13;
        if (r101 == true) goto L13;
        int r103 = b.a(r100.f564441a);
        if (r103 == 3) goto L12;
        if (r103 == 5) goto L12;
        if (r103 == 48) goto L11;
        if (r103 != 80) goto L13;
    L11:
        r100.f564449i -= r100.d();
    L12:
        r100.f564450j -= r100.d();
    L13:
        int r113 = b.a(r110);
        if (r113 == 3) goto L31;
        if (r113 == 5) goto L27;
        if (r113 == 48) goto L23;
        if (r113 != 80) goto L35;
        if (r101 == false) goto L21;
        int r114 = (r111 - r100.f()) / 2;
    L22:
        r102[0] = r100.f564449i + r114;
        r102[1] = r100.f564450j + r112;
        goto L35
    L21:
        r114 = 0;
    L35:
        return r102;
    L23:
        if (r101 == false) goto L25;
        int r115 = (r111 - r100.f()) / 2;
    L26:
        r102[0] = r100.f564449i + r115;
        r102[1] = (-r100.e()) + r100.f564450j;
        goto L35
    L25:
        r115 = 0;
        goto L26
    L27:
        if (r101 == false) goto L29;
        int r116 = (r112 - r100.e()) / 2;
    L30:
        r102[0] = r100.f564449i + r111;
        r102[1] = r100.f564450j + r116;
        goto L35
    L29:
        r116 = 0;
        goto L30
    L31:
        if (r101 == false) goto L33;
        int r117 = (r112 - r100.e()) / 2;
    L34:
        r102[0] = r100.f564449i - r100.f();
        r102[1] = r100.f564450j + r117;
        goto L35
    L33:
        r117 = 0;
        goto L34
    }

    public final void l(View r100, int r101, boolean r102, float r103, int r104, int r105) {
        int r106 = b.a(r101);
        this.f564449i = r104;
        this.f564450j = r105;
        this.f564443c = r103;
        k(r100, r106, r102);
    }
}
