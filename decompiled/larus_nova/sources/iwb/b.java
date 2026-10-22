package iwb;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f496277a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        d r100 = this.f496277a.f496267i;
        FrameLayout r101 = r100.f496279a.getFloatView$officesdk_minutes_base_ui_release();
        if (r100.f496279a.isLaidOut() == true) goto L5;
    L53:
        boolean r102 = false;
    L54:
        if (r102 == true) goto L56;
        return true;
    L56:
        a r103 = this.f496277a;
        b r104 = r103.f496271m;
        if (r104 != null) goto L60;
    L63:
        a r105 = this.f496277a;
        if (r105.f496270l == false) goto L67;
        r105.removeCallbacks(r105.f496274p);
        r105.postDelayed(r105.f496274p, 3000);
    L67:
        int r106 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "onFirstPositioned", "notify", null, 8);
        Function0<Unit> r107 = this.f496277a.getOnFirstPositioned$officesdk_minutes_base_ui_release();
        if (r107 == null) goto L70;
        r107.invoke();
    L70:
        return false;
    L60:
        if (r103.getViewTreeObserver().isAlive() == false) goto L62;
        r103.getViewTreeObserver().removeOnPreDrawListener(r104);
    L62:
        r103.f496271m = null;
        goto L63
    L5:
        if (r101.getWidth() <= 0) goto L53;
        if (r101.getHeight() <= 0) goto L53;
        ViewGroup.LayoutParams r108 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
        if (r109.leftMargin == 0) goto L12;
    L51:
        r101.setVisibility(0);
    L52:
        r102 = true;
        goto L54
    L12:
        if (r109.topMargin != 0) goto L51;
        if (r109.gravity == 0) goto L51;
        hwb.d r110 = r100.f496288j;
        if (r110 != null) goto L19;
        r110 = new hwb.d(0);
    L19:
        MmRecordingFloatSide r111 = r110.f487452b;
        MmRecordingFloatSide r112 = MmRecordingFloatSide.RIGHT;
        if (r111 != r112) goto L22;
        boolean r113 = true;
    L23:
        r100.f496284f = r113;
        boolean r114 = r110.f487451a;
        boolean r115 = !r114;
        r100.f496282d = r115;
        r100.f496283e = r115;
        r109.gravity = 0;
        Integer r116 = r110.f487453c;
        if (r116 == null) goto L26;
        int r117 = r116.intValue();
    L33:
        r109.leftMargin = r117;
        Integer r118 = r110.f487454d;
        if (r118 == null) goto L36;
        int r119 = r118.intValue();
    L37:
        r109.topMargin = r119;
        r109.rightMargin = 0;
        r109.bottomMargin = 0;
        r101.setLayoutParams(r109);
        if (r110.f487451a == false) goto L40;
        r100.f(r109.leftMargin, r109.topMargin);
    L50:
        r100.f496279a.c(r100.f496283e, r100.f496284f);
        r100.f496279a.b(r100.c());
        int r120 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "initPosition", "left=" + r109.leftMargin + ", top=" + r109.topMargin + ", expandedX=" + r100.f496285g + ", expandedY=" + r100.f496286h, null, 8);
        goto L52
    L40:
        Integer r121 = r110.f487456f;
        if (r121 == null) goto L46;
        if (r110.f487457g == null) goto L46;
        int r122 = r121.intValue();
        int r123 = r110.f487457g.intValue();
        e r124 = r100.f496280b;
        r124.getClass();
        r100.f496285g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r122, 0), r124.a()));
        r100.f496286h = Integer.valueOf(r100.f496280b.c(r123));
    L46:
        if (r110.f487452b != r112) goto L48;
        int r125 = r100.f496280b.a();
    L49:
        int r126 = r109.topMargin;
        e r127 = r100.f496280b;
        r127.getClass();
        r100.f496285g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r125, 0), r127.a()));
        r100.f496286h = Integer.valueOf(r100.f496280b.c(r126));
        goto L50
    L48:
        r125 = 0;
        goto L49
    L36:
        r119 = r100.f496280b.b();
        goto L37
    L26:
        if (r114 == false) goto L30;
        if (r111 != r112) goto L29;
        r117 = r100.f496280b.a();
        goto L33
    L29:
        r117 = 0;
        goto L33
    L30:
        if (r111 != r112) goto L32;
        r117 = r100.f496280b.e();
        goto L33
    L32:
        r117 = r100.f496280b.d();
        goto L33
    L22:
        r113 = false;
        goto L23
    }

    public b(a r100) {
        this.f496277a = r100;
    }
}
