package com.obric.oui.sheet;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pla.e;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "use com.obric.oui.sheet.v2.OSheet(context: Context, hostWindowHeight: Int) instead")
public class OInsetSheet extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f402833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f402834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadiusLayout f402836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f402837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PanelWidth f402838f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum PanelWidth extends Enum<PanelWidth> {
        public static final PanelWidth BOARD_WIDTH = null;
        public static final PanelWidth NARROW_WIDTH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanelWidth[] f402839a = null;

        public static PanelWidth valueOf(String r100) {
            return (PanelWidth) r27.a.a(PanelWidth.class, r100);
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) f402839a.clone();
        }

        static {
            PanelWidth r100 = new PanelWidth("NARROW_WIDTH", 0);
            NARROW_WIDTH = r100;
            PanelWidth r101 = new PanelWidth("BOARD_WIDTH", 1);
            BOARD_WIDTH = r101;
            f402839a = new PanelWidth[]{r100, r101};
        }

        public PanelWidth(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402840a = null;

        static {
            int[] r100 = new int[PanelWidth.values().length];
            r100[PanelWidth.NARROW_WIDTH.ordinal()] = 1;
            r100[PanelWidth.BOARD_WIDTH.ordinal()] = 2;
            f402840a = r100;
        }
    }

    static {
        new a();
    }

    public final FrameLayout b() {
        FrameLayout r100 = this.f402835c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final RadiusLayout c() {
        RadiusLayout r100 = this.f402836d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        int r100 = DialogAnimStyle.f400636a;
        com.obric.oui.animation.easy.b r101 = DialogAnimStyle.d(c(), getWindow(), !this.f402837e, true);
        com.obric.oui.animation.easy.b.d(r101, new OInsetSheet$performExitAnimation$1$1(this), new OInsetSheet$performExitAnimation$1$2(this), 1);
        r101.e();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        c().post(new c(this));
    }

    @Override // android.app.Dialog
    public void show() {
        Context r100 = getContext();
        boolean r101 = false;
        if (e.a(r100) == false) goto L19;
        c().measure(0, 0);     // Catch: Exception -> L16
        zma.a r102 = zma.a.f572881a;     // Catch: Exception -> L16
        int r103 = pla.d.c(r100, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL) - zma.a.e(r100);     // Catch: Exception -> L16
        FrameLayout r104 = this.f402833a;     // Catch: Exception -> L16
        FrameLayout r105 = null;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");     // Catch: Exception -> L16
        r104 = null;
    L8:
        int r106 = r103 - r104.getMeasuredHeight();     // Catch: Exception -> L16
        FrameLayout r107 = this.f402834b;     // Catch: Exception -> L16
        if (r107 == null) goto L11;
        r105 = r107;
    L12:
        int r108 = r106 - r105.getMeasuredHeight();     // Catch: Exception -> L16
        b().measure(View.MeasureSpec.makeMeasureSpec(pla.d.c(r100, 440), Integer.MIN_VALUE), 0);     // Catch: Exception -> L16
        int r109 = b().getMeasuredHeight();     // Catch: Exception -> L16
        int r110 = RangesKt.coerceIn(r108, 0, pla.d.c(r100, 244));     // Catch: Exception -> L16
        if (r109 <= r110) goto L19;
        wma.b.d("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r109 + ", final contentHeight: " + r110);     // Catch: Exception -> L16
        FrameLayout r111 = b();     // Catch: Exception -> L16
        ViewGroup.LayoutParams r112 = b().getLayoutParams();     // Catch: Exception -> L16
        r112.height = r110;     // Catch: Exception -> L16
        r111.setLayoutParams(r112);     // Catch: Exception -> L16
        goto L19
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        wma.b.c("OInsetSheet", "adjustContentHeight error", e);
    L19:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(this);
    L23:
        Window r113 = getWindow();
        if (r113 == null) goto L49;
        r113.setBackgroundDrawableResource(R.color.transparent);
        if (Build.VERSION.SDK_INT < 29) goto L29;
        r113.setNavigationBarContrastEnforced(false);
    L29:
        r113.setDecorFitsSystemWindows(false);
        r113.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r113.addFlags(Integer.MIN_VALUE);
        r113.setNavigationBarColor(0);
        r113.setNavigationBarDividerColor(0);
        if (this.f402837e == false) goto L32;
        r113.clearFlags(2);
    L34:
        if ((r113.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L36;
        r101 = true;
    L36:
        if (r101 == false) goto L38;
        float r114 = 0.5f;
    L39:
        WindowManager.LayoutParams r115 = r113.getAttributes();
        if ((true ^ this.f402837e) == true) goto L42;
        r115.dimAmount = r114;
    L42:
        r115.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r115.gravity = 80;
        r113.setAttributes(r115);
        return;
    L38:
        r114 = 0.16f;
        goto L39
    L32:
        r113.addFlags(2);
        goto L34
    L49:
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L22:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L23
    }

    public OInsetSheet(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f402838f = PanelWidth.BOARD_WIDTH;
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.requestFeature(1);
    L6:
        setContentView(com.larus.nova.R.layout.o_inset_sheet_container);
        RadiusLayout r102 = (RadiusLayout) findViewById(com.larus.nova.R.id.root_constraint);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f402836d = r102;
        c().setMeasureHeightUnspecified(true);
        FrameLayout r103 = (FrameLayout) findViewById(com.larus.nova.R.id.header_container);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f402833a = r103;
        FrameLayout r104 = (FrameLayout) findViewById(com.larus.nova.R.id.content_container);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f402835c = r104;
        FrameLayout r105 = (FrameLayout) findViewById(com.larus.nova.R.id.foot_container);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f402834b = r105;
        int r106 = DialogAnimStyle.f400636a;
        DialogAnimStyle.a(c());
        c().setOnApplyWindowInsetsListener(new d(this));
    }

    public static void a(OInsetSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void e(PanelWidth r100) {
        Intrinsics.checkNotNullParameter(r100, "width");
        this.f402838f = r100;
        int r101 = b.f402840a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L16;
        Resources r102 = getContext().getResources();
        int r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        Context r104 = getContext();
        if (e.a(r104) == false) goto L9;
        r103 = RangesKt.coerceAtMost(r103, pla.d.c(r104, 440));
    L9:
        com.obric.oui.indicator.d.c(c(), r103);
        float r105 = getContext().getResources().getDimension(com.larus.nova.R.dimen.oui_r_l3);
        c().b(r105, r105, 0.0f, 0.0f);
        return;
    L16:
        return;
    L10:
        Resources r106 = getContext().getResources();
        int r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).widthPixels - (getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.oui_dialog_narrow_layout_margin) * 2);
        Context r108 = getContext();
        if (e.a(r108) == false) goto L13;
        r107 = RangesKt.coerceAtMost(r107, pla.d.c(r108, 440));
    L13:
        com.obric.oui.indicator.d.c(c(), r107);
        c().setRadius(getContext().getResources().getDimension(com.larus.nova.R.dimen.oui_r_l2));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    public static void d(ViewGroup r100, View r101) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L6;
        j.f(r100);
    L6:
        if (r100 == null) goto L9;
        r100.removeAllViews();
    L9:
        if (r100 == null) goto L17;
        r100.addView(r101);
        return;
    L17:
        return;
    L12:
        if (r100 == null) goto L18;
        j.e(r100);
        return;
    }
}
