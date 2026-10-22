package com.obric.oui.dialog.base;

import android.R;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.color.i0;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbstractDialog extends Dialog implements zla.a {
    public static final /* synthetic */ int F = 0;
    public Integer A;
    public Integer B;
    public Integer C;
    public final c D;
    public final h E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f400647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f400648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f400649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f400650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f400651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f400652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f400653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f400654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CloseIconStyle f400655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnClickListener f400656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f400657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f400658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f400659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f400660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f400661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f400662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f400663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f400664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f400665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DialogInterface.OnShowListener f400666t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f400667u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f400668v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f400669w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f400670x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f400671y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f400672z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CloseIconStyle[] f400673a = null;

        public static CloseIconStyle valueOf(String r100) {
            return (CloseIconStyle) r27.a.a(CloseIconStyle.class, r100);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) f400673a.clone();
        }

        static {
            CloseIconStyle r100 = new CloseIconStyle("LIGHT", 0);
            LIGHT = r100;
            CloseIconStyle r101 = new CloseIconStyle("DARK", 1);
            DARK = r101;
            CloseIconStyle r102 = new CloseIconStyle("CUSTOM", 2);
            CUSTOM = r102;
            f400673a = new CloseIconStyle[]{r100, r101, r102};
        }

        public CloseIconStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400674a = null;

        static {
            int[] r100 = new int[CloseIconStyle.values().length];
            r100[CloseIconStyle.DARK.ordinal()] = 1;
            r100[CloseIconStyle.LIGHT.ordinal()] = 2;
            r100[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f400674a = r100;
        }
    }

    static {
    }

    public View e() {
        return null;
    }

    public abstract int f();

    public final View g() {
        View r100 = this.f400653g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        g().setOnApplyWindowInsetsListener(null);
        ValueAnimator r100 = this.f400672z;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        this.f400665s = false;
        a(this);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        wma.b.c(this.f400649c, "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.E.removeCallbacksAndMessages(null);
        View r100 = this.f400664r;
        if (r100 != null) goto L5;
        r100 = e();
    L5:
        if (r100 != null) goto L7;
    L9:
        if (r100 == null) goto L11;
        j(r100, false);
    L11:
        this.f400662p = null;
        View r101 = e();
        if (r101 == null) goto L15;
        r101.getViewTreeObserver();
    L15:
        if (r101 == null) goto L19;
        r101.removeOnLayoutChangeListener(this.D);
        return;
    L19:
        return;
    L7:
        if (this.f400661o == false) goto L9;
        d(r100, true);
        goto L11
    }

    @Override // android.app.Dialog
    public void show() {
        g().setOnApplyWindowInsetsListener(new d(this));
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L95;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.f400648b == true) goto L15;
        View r100 = e();
        if (r100 == null) goto L15;
        r100.removeOnLayoutChangeListener(this.D);
        r100.addOnLayoutChangeListener(this.D);
    L15:
        if (isShowing() == true) goto L18;
    L24:
        Window r101 = getWindow();
        if (r101 == null) goto L87;
        if (this.f400665s == false) goto L30;
        return;
    L30:
        r101.setBackgroundDrawableResource(R.color.transparent);
        Window r102 = getWindow();
        if (r102 == null) goto L35;
        r102.setWindowAnimations(0);
    L35:
        if (this.f400658l == false) goto L40;
        Window r103 = getWindow();
        if (r103 == null) goto L41;
        r103.clearFlags(2);
    L41:
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 29) goto L44;
        r101.setNavigationBarContrastEnforced(false);
    L44:
        r101.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setNavigationBarColor(0);
        if (r104 < 30) goto L47;
        r101.setDecorFitsSystemWindows(false);
        r101.setNavigationBarDividerColor(0);
    L47:
        WindowManager.LayoutParams r105 = r101.getAttributes();
        r105.gravity = this.f400667u;
        r105.x = 0;
        r105.y = this.f400670x + 0;
        r105.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        RadiusLayout r106 = null;
        if (this.f400648b == false) goto L50;
        r105.height = -1;
    L62:
        if (this.f400647a == false) goto L76;
        View r107 = g();
        ViewGroup.LayoutParams r108 = g().getLayoutParams();
        r108.width = -1;
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L66;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
    L67:
        if (r109 == null) goto L70;
        r109.bottomMargin = 0;
    L70:
        r107.setLayoutParams(r108);
        View r110 = g();
        if ((r110 instanceof RadiusLayout) == false) goto L73;
        r106 = (RadiusLayout) r110;
    L73:
        if (r106 == null) goto L82;
        float r111 = r106.getContext().getResources().getDimension(com.larus.nova.R.dimen.oui_r_l3);
        r106.b(r111, r111, 0.0f, 0.0f);
    L82:
        if (this.f400658l == false) goto L84;
        r105.dimAmount = h(r101.getContext());
    L85:
        zma.a.b(zma.a.f572881a.getActivity(r101.getContext()), r105, this.f400669w);
        r101.setAttributes(r105);
        goto L87
    L84:
        r105.dimAmount = 0.0f;
        goto L85
    L66:
        r109 = null;
        goto L67
    L76:
        Size r112 = zma.a.c(r101.getContext());
        int r113 = Math.min(r112.getWidth(), r112.getHeight());
        Intrinsics.checkNotNullParameter(r101, "<this>");
        int r114 = r113 - (r101.getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.oui_dialog_layout_margin) * 2);
        View r115 = g();
        ViewGroup.LayoutParams r116 = g().getLayoutParams();
        r116.width = r114;
        r115.setLayoutParams(r116);
        g().measure(View.MeasureSpec.makeMeasureSpec(r114, Integer.MIN_VALUE), 0);
        if (r112.getWidth() >= r112.getHeight()) goto L82;
        int r117 = r112.getHeight() - pla.d.c(r101.getContext(), VideoRef.VALUE_VIDEO_REF_CATEGORY);
        if (g().getMeasuredHeight() <= r117) goto L82;
        this.f400660n = g().getMeasuredHeight() - r117;
        goto L82
    L50:
        Integer r118 = 0;
        if (r118.intValue() <= 0) goto L53;
        boolean r119 = true;
    L54:
        if (r119 == true) goto L57;
        r118 = null;
    L57:
        if (r118 != null) goto L59;
        int r120 = -2;
    L60:
        r105.height = r120;
        goto L62
    L59:
        r120 = r118.intValue();
        goto L60
    L53:
        r119 = false;
        goto L54
    L40:
        r101.addFlags(2);
    L87:
        if (this.f400671y == false) goto L92;
        final Window r121 = getWindow();
        if (r121 == null) goto L92;
        new AbstractDialog$applyWindowPositionIfNeeded$apply$1(r121, this).invoke();
    L92:
        this.f400665s = true;
        return;
    L18:
        if (this.f400648b == true) goto L24;
        Window r122 = getWindow();
        if (r122 == null) goto L24;
        r122.getAttributes();
        goto L24
    L95:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L94
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    @Override // zla.a
    public final boolean r0() {
        return this.f400659m;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.oui.dialog.base.c] */
    public AbstractDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f400647a = false;
        this.f400648b = false;
        this.f400649c = "AbstractDialog";
        this.f400655i = CloseIconStyle.DARK;
        this.f400659m = true;
        this.f400660n = -1;
        this.f400663q = true;
        this.f400667u = 81;
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.requestFeature(1);
    L6:
        Window r102 = getWindow();
        if (r102 == null) goto L10;
        r102.addFlags(512);
    L10:
        setContentView(com.larus.nova.R.layout.o_base_dialog);
        View r103 = findViewById(R.id.content);
        if (r103 == null) goto L14;
        r103.setOnClickListener(new com.obric.oui.dialog.base.a(this));
    L14:
        View r104 = findViewById(com.larus.nova.R.id.root_view);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f400653g = r104;
        g().setOnClickListener(new com.obric.oui.dialog.base.b());
        if ((g().getBackground() instanceof ColorDrawable) == false) goto L22;
        Drawable r105 = g().getBackground();
        if (r105 == null) goto L20;
        ((ColorDrawable) r105).getColor();
    L33:
        g().setAlpha(0.0f);
        this.f400651e = (ImageView) findViewById(com.larus.nova.R.id.btn_close);
        this.f400650d = findViewById(com.larus.nova.R.id.close_container);
        i(this.f400652f, null);
        ViewStub r106 = (ViewStub) findViewById(com.larus.nova.R.id.contentView);
        r106.setLayoutResource(f());
        View r107 = r106.inflate();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f400654h = r107;
        int r108 = DialogAnimStyle.f400636a;
        DialogAnimStyle.a(g());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OMaterialHelper.j(r100) == true) goto L36;
    L38:
        boolean r109 = false;
    L39:
        if (r109 == false) goto L50;
        g().setBackgroundColor(0);
        com.obric.oui.material.c[] r110 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!vma.i.a(g())));
        com.obric.oui.material.p.e(g(), r110, false, null);
        if (OMaterialHelper.g(r100) != 1) goto L43;
    L44:
        i0 r111 = r110[0].f401456e;
        if (r111 == null) goto L50;
        if ((g() instanceof DialogRootView) == false) goto L50;
        ((DialogRootView) g()).c(r111.f399494b, pla.d.b(r100, r111.f399493a));
        goto L50
    L43:
        if (r110.length == 1) goto L44;
    L50:
        this.D = new c(this);
        this.E = new h(this, Looper.getMainLooper());
        return;
    L36:
        if (OMaterialHelper.l() == false) goto L38;
        r109 = true;
        goto L39
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L22:
        if ((g().getBackground() instanceof GradientDrawable) == false) goto L33;
        if (Build.VERSION.SDK_INT < 24) goto L33;
        Drawable r112 = g().getBackground();
        if (r112 == null) goto L32;
        ColorStateList r113 = ((GradientDrawable) r112).getColor();
        if (r113 == null) goto L33;
        r113.getDefaultColor();
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(AbstractDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static float h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r101 = false;
        goto L6
    }

    public static void j(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        ViewGroup r102 = null;
        if ((r100 instanceof RadiusLayout) == false) goto L7;
        RadiusLayout r103 = (RadiusLayout) r100;
    L8:
        if (r103 != null) goto L10;
        Unit r104 = null;
    L11:
        if (r104 == null) goto L13;
        return;
    L13:
        if ((r100 instanceof ViewGroup) == false) goto L15;
        r102 = (ViewGroup) r100;
    L15:
        if (r102 == null) goto L21;
        r102.suppressLayout(r101);
        return;
    L21:
        return;
    L10:
        r103.setSuppressChildMeasureAndLayout(r101);
        r104 = Unit.INSTANCE;
        goto L11
    L7:
        r103 = null;
        goto L8
    }

    public final void d(View r100, boolean r101) {
        this.f400661o = false;
        this.f400664r = null;
        if (r101 == false) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.height = -2;
        r100.setLayoutParams(r102);
        r100.requestLayout();
    L5:
        j(r100, false);
    }

    public final void i(boolean r100, View.OnClickListener r101) {
        this.f400652f = r100;
        this.f400656j = r101;
        ImageView r102 = this.f400651e;
        if (r102 == null) goto L21;
        pla.j.a(r102, pla.d.c(getContext(), 44));
        if (r100 == false) goto L15;
        View r103 = this.f400650d;
        if (r103 == null) goto L11;
        pla.j.f(r103);
    L11:
        c(this.f400655i, null, null);
        View r104 = this.f400650d;
        if (r104 == null) goto L22;
        r104.setOnClickListener(new e(this));
        return;
    L22:
        return;
    L15:
        View r105 = this.f400650d;
        if (r105 == null) goto L23;
        pla.j.e(r105);
        return;
    L23:
        return;
    }

    public final void c(CloseIconStyle r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (this.f400652f == false) goto L38;
        int r103 = b.f400674a[r100.ordinal()];
        int r104 = com.larus.nova.R.color.ConstTextInverse;
        if (r103 != 1) goto L7;
        r102 = Integer.valueOf(com.larus.nova.R.color.ConstBGContainer7);
    L17:
        ImageView r105 = this.f400651e;
        if (r105 == null) goto L21;
        r105.setImageTintList(ContextCompat.getColorStateList(getContext(), r104));
    L21:
        GradientDrawable r106 = null;
        if (r102 != null) goto L27;
        View r107 = this.f400650d;
        if (r107 == null) goto L40;
        r107.setBackground(null);
        return;
    L40:
        return;
    L27:
        View r108 = this.f400650d;
        if (r108 != null) goto L30;
        Drawable r109 = null;
    L32:
        if ((r109 instanceof GradientDrawable) == false) goto L34;
        r106 = (GradientDrawable) r109;
    L34:
        if (r106 == null) goto L41;
        r106.setColor(ContextCompat.getColorStateList(getContext(), r102.intValue()));
        return;
    L41:
        return;
    L30:
        r109 = r108.getBackground();
        goto L32
    L7:
        if (r103 != 2) goto L9;
        r102 = Integer.valueOf(com.larus.nova.R.color.ConstTextInverse5);
        r104 = com.larus.nova.R.color.TextReverse;
        goto L17
    L9:
        if (r103 != 3) goto L14;
        if (r101 == null) goto L17;
        r104 = r101.intValue();
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
