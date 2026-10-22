package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.obric.oui.color.i0;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.view.ViewCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbstractDialogModal extends FrameLayout implements zla.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f400675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f400676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f400677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CloseIconStyle f400679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f400680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f400681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f400682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DialogInterface.OnDismissListener f400683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DialogInterface.OnCancelListener f400684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DialogInterface.OnShowListener f400685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f400686l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f400687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f400688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f400689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f400690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f400691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f400692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f400693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f400694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f400695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f400696v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f400697w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f400698x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f400699y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f400700z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CloseIconStyle[] f400701a = null;

        public static CloseIconStyle valueOf(String r100) {
            return (CloseIconStyle) r27.a.a(CloseIconStyle.class, r100);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) f400701a.clone();
        }

        static {
            CloseIconStyle r100 = new CloseIconStyle("LIGHT", 0);
            LIGHT = r100;
            CloseIconStyle r101 = new CloseIconStyle("DARK", 1);
            DARK = r101;
            CloseIconStyle r102 = new CloseIconStyle("CUSTOM", 2);
            CUSTOM = r102;
            f400701a = new CloseIconStyle[]{r100, r101, r102};
        }

        public CloseIconStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400702a = null;

        static {
            int[] r100 = new int[CloseIconStyle.values().length];
            r100[CloseIconStyle.DARK.ordinal()] = 1;
            r100[CloseIconStyle.LIGHT.ordinal()] = 2;
            r100[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f400702a = r100;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialogModal f400703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f400704b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AbstractDialogModal r101 = this.f400703a;
            r101.f400698x = null;
            r101.f400697w = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AbstractDialogModal r101 = this.f400703a;
            r101.f400700z = Integer.valueOf(this.f400704b);
            AbstractDialogModal r102 = this.f400703a;
            r102.f400699y = Integer.valueOf(this.f400704b);
            AbstractDialogModal r103 = this.f400703a;
            r103.f400698x = null;
            r103.f400697w = null;
        }

        public c(AbstractDialogModal r100, int r101) {
            this.f400703a = r100;
            this.f400704b = r101;
        }
    }

    static {
    }

    public final void b() {
        this.f400690p = false;
        DialogInterface.OnShowListener r100 = this.f400685k;
        if (r100 == null) goto L7;
        r100.onShow(this);
        return;
    }

    public abstract int getLayout();

    public final void setIncludeCutoutInLandscape(Boolean r100) {
    }

    public final void setOnShowListener(DialogInterface.OnShowListener r100) {
    }

    public void c() {
        if (this.f400692r == true) goto L5;
        return;
    L5:
        this.f400692r = false;
        this.f400690p = false;
        d();
        DialogInterface.OnDismissListener r100 = this.f400683i;
        if (r100 == null) goto L9;
        r100.onDismiss(this);
    L9:
        ViewParent r101 = getParent();
        if ((r101 instanceof ViewGroup) == false) goto L12;
        ViewGroup r102 = (ViewGroup) r101;
    L13:
        if (r102 == null) goto L16;
        r102.removeView(this);
    L16:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L12:
        r102 = null;
        goto L13
    }

    @Override // android.content.DialogInterface
    public final void cancel() {
        if (this.f400682h == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r100 = this.f400684j;
        if (r100 == null) goto L9;
        r100.onCancel(this);
    L9:
        dismiss();
    }

    public final void d() {
        zma.a.f572881a.getActivity(getContext());
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.f400692r == true) goto L5;
        return;
    L5:
        d();
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new k(this)).start();
        int r100 = DialogAnimStyle.f400636a;
        com.obric.oui.animation.easy.b r101 = DialogAnimStyle.d(getDialogRootView(), null, false, getUseNewDialogAnim());
        com.obric.oui.animation.easy.b.d(r101, new AbstractDialogModal$performExitAnimation$2$1(this), new AbstractDialogModal$performExitAnimation$2$2(this), 1);
        r101.e();
    }

    public int getBaseLayoutRes() {
        if (this.f400676b == false) goto L5;
        return R.layout.o_base_dialog_with_match_parent_height;
    L5:
        return R.layout.o_base_dialog;
    }

    public final View getContentRootView() {
        View r100 = this.f400695u;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentRootView");
        return null;
    }

    public final View getDialogRootView() {
        View r100 = this.f400694t;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dialogRootView");
        return null;
    }

    public final View getDimView() {
        View r100 = this.f400696v;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    public int getLayoutMarginHorizontal() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public final int getBgColor() {
        return this.f400688n;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.f400685k;
    }

    public final boolean getEnableMaterial() {
        return this.f400687m;
    }

    public final boolean getHideFirstFrame() {
        return this.f400686l;
    }

    public final boolean getMCancelable() {
        return this.f400682h;
    }

    public final boolean getMatchParentHeight() {
        return this.f400676b;
    }

    public final int getMaxRootViewHeightGap() {
        return this.f400689o;
    }

    public final boolean getShowAnimRunning() {
        return this.f400690p;
    }

    public boolean getUseNewDialogAnim() {
        return this.f400691q;
    }

    public final boolean getWidthMatch() {
        return this.f400675a;
    }

    @Override // zla.a
    public final boolean r0() {
        return this.f400681g;
    }

    public AbstractDialogModal(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        this.f400675a = false;
        this.f400676b = false;
        this.f400679e = CloseIconStyle.DARK;
        this.f400681g = true;
        this.f400682h = true;
        this.f400689o = -1;
        this.f400691q = true;
        final r r100 = (r) this;
        new o(r100);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r101 = new View(r110);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setBackgroundColor(-16777216);
        r101.setAlpha(0.0f);
        r101.setVisibility(8);
        setDimView(r101);
        addView(getDimView());
        setDialogRootView(LayoutInflater.from(r110).inflate(getBaseLayoutRes(), this, false));
        addView(getDialogRootView());
        if ((getDialogRootView().getBackground() instanceof ColorDrawable) == false) goto L10;
        Drawable r102 = getDialogRootView().getBackground();
        if (r102 == null) goto L8;
        this.f400688n = ((ColorDrawable) r102).getColor();
    L22:
        getDialogRootView().setAlpha(0.0f);
        ImageView r103 = (ImageView) findViewById(R.id.btn_close);
        View r104 = findViewById(R.id.close_container);
        this.f400677c = r104;
        boolean r105 = this.f400678d;
        this.f400678d = r105;
        GradientDrawable r106 = null;
        this.f400680f = null;
        if (r103 == null) goto L64;
        pla.j.a(r103, pla.d.c(getContext(), 44));
        if (r105 == false) goto L61;
        if (r104 == null) goto L30;
        pla.j.f(r104);
    L30:
        CloseIconStyle r107 = this.f400679e;
        Intrinsics.checkNotNullParameter(r107, "style");
        this.f400679e = r107;
        if (this.f400678d == false) goto L58;
        int r108 = b.f400702a[r107.ordinal()];
        int r109 = R.color.ConstTextInverse;
        if (r108 != 1) goto L36;
        Integer r111 = Integer.valueOf(R.color.ConstBGContainer7);
    L44:
        r103.setImageTintList(ContextCompat.getColorStateList(getContext(), r109));
        if (r111 != null) goto L49;
        if (r104 == null) goto L58;
        r104.setBackground(null);
        goto L58
    L49:
        if (r104 != null) goto L51;
        Drawable r112 = null;
    L53:
        if ((r112 instanceof GradientDrawable) == false) goto L55;
        r106 = (GradientDrawable) r112;
    L55:
        if (r106 == null) goto L58;
        r106.setColor(ContextCompat.getColorStateList(getContext(), r111.intValue()));
        goto L58
    L51:
        r112 = r104.getBackground();
        goto L53
    L36:
        if (r108 != 2) goto L38;
        r111 = Integer.valueOf(R.color.ConstTextInverse5);
        r109 = R.color.TextReverse;
        goto L44
    L38:
        if (r108 != 3) goto L41;
        r111 = null;
        goto L44
    L41:
        throw new NoWhenBranchMatchedException();
    L58:
        if (r104 == null) goto L64;
        r104.setOnClickListener(new m(r100));
        goto L64
    L61:
        if (r104 == null) goto L64;
        pla.j.e(r104);
    L64:
        ViewStub r113 = (ViewStub) findViewById(R.id.contentView);
        r113.setLayoutResource(getLayout());
        setContentRootView(r113.inflate());
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (OMaterialHelper.j(r110) == true) goto L67;
    L69:
        boolean r114 = false;
    L70:
        this.f400687m = r114;
        if (r114 == false) goto L82;
        getDialogRootView().setBackgroundColor(0);
        com.obric.oui.material.c[] r115 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!vma.i.a(getDialogRootView())));
        com.obric.oui.material.p.d(getDialogRootView(), r115, false, 0, 14);
        if (OMaterialHelper.g(r110) != 1) goto L75;
    L76:
        i0 r116 = r115[0].f401456e;
        if (r116 == null) goto L82;
        if ((getDialogRootView() instanceof DialogRootView) == false) goto L82;
        ((DialogRootView) getDialogRootView()).c(r116.f399494b, pla.d.b(r110, r116.f399493a));
        goto L82
    L75:
        if (r115.length == 1) goto L76;
    L82:
        j r117 = new j(r100);
        int r118 = ViewCompat.f403725a;
        if (Build.VERSION.SDK_INT >= 30) goto L85;
        setTag(R.id.o_tag_on_apply_window_listener, r117);
    L85:
        setOnApplyWindowInsetsListener(new xma.d(r100, r117));
        return;
    L67:
        if (OMaterialHelper.l() == false) goto L69;
        r114 = true;
        goto L70
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L10:
        if ((getDialogRootView().getBackground() instanceof GradientDrawable) == false) goto L22;
        if (Build.VERSION.SDK_INT < 24) goto L22;
        Drawable r119 = getDialogRootView().getBackground();
        if (r119 == null) goto L21;
        ColorStateList r120 = ((GradientDrawable) r119).getColor();
        if (r120 != null) goto L18;
        int r121 = 0;
    L19:
        this.f400688n = r121;
        goto L22
    L18:
        r121 = r120.getDefaultColor();
        goto L19
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public final void a(int r100) {
        final View r101 = getDialogRootView();
        if (this.f400692r == true) goto L5;
        return;
    L5:
        Integer r102 = this.f400699y;
        if (r102 != null) goto L10;
        r102 = this.f400700z;
        if (r102 != null) goto L10;
        int r103 = (int) r101.getTranslationY();
    L11:
        if (r103 != r100) goto L18;
        ValueAnimator r104 = this.f400697w;
        if (r104 == null) goto L16;
        r104.cancel();
    L16:
        this.f400697w = null;
        this.f400698x = null;
        this.f400699y = Integer.valueOf(r100);
        this.f400700z = Integer.valueOf(r100);
        r101.setTranslationY(r100);
        return;
    L18:
        ValueAnimator r105 = this.f400697w;
        if (r105 != null) goto L22;
    L20:
        boolean r106 = false;
    L24:
        if (r106 == false) goto L31;
        Integer r107 = this.f400698x;
        if (r107 == null) goto L31;
        if (r107.intValue() != r100) goto L31;
        return;
    L31:
        ValueAnimator r108 = this.f400697w;
        if (r108 == null) goto L35;
        r108.cancel();
    L35:
        this.f400698x = Integer.valueOf(r100);
        final ValueAnimator r109 = ValueAnimator.ofInt(new int[]{r103, r100});
        r109.setDuration(200);
        r109.setInterpolator(new DecelerateInterpolator(1.5f));
        r109.addUpdateListener(new n(r101, this, r109));
        r109.addListener(new c(this, r100));
        this.f400697w = r109;
        r109.start();
        return;
    L22:
        if (r105.isRunning() != true) goto L20;
        r106 = true;
    L10:
        r103 = r102.intValue();
        goto L11
    }

    public final void setAutoDismiss(boolean r100) {
        this.f400681g = r100;
    }

    public final void setBgColor(int r100) {
        this.f400688n = r100;
    }

    public void setCancelable(boolean r100) {
        this.f400682h = r100;
    }

    public final void setCanceledOnTouchOutside(boolean r100) {
        setCancelable(r100);
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r100) {
        this.f400685k = r100;
    }

    public final void setContentRootView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400695u = r100;
    }

    public final void setDialogRootView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400694t = r100;
    }

    public final void setDimView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400696v = r100;
    }

    public final void setEnableMaterial(boolean r100) {
        this.f400687m = r100;
    }

    public final void setHideFirstFrame(boolean r100) {
        this.f400686l = r100;
    }

    public final void setMCancelable(boolean r100) {
        this.f400682h = r100;
    }

    public final void setMaxRootViewHeightGap(int r100) {
        this.f400689o = r100;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r100) {
        this.f400684j = r100;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.f400683i = r100;
    }

    public final void setRootFixedHeight(Integer r100) {
        if (r100 != null) goto L6;
    L4:
        r100 = null;
    L10:
        this.f400693s = r100;
        return;
    L6:
        if (r100.intValue() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L4;
    L8:
        r101 = false;
        goto L9
    }

    public final void setShowAnimRunning(boolean r100) {
        this.f400690p = r100;
    }

    public final void setShowingModal(boolean r100) {
        this.f400692r = r100;
    }

    public void setUseNewDialogAnim(boolean r100) {
        this.f400691q = r100;
    }
}
