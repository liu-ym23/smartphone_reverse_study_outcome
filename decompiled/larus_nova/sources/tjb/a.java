package tjb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.guide.ui.common.popup.OverlayType;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import com.ss.android.lark.guide.ui.view.BubbleLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import rjb.f;
import rjb.g;
import rjb.i;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements rjb.b, ujb.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Rect f546438h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f546439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaskConfig f546442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnchorConfig f546443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ujb.a f546444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BubbleLayout f546445g;

    /* JADX INFO: renamed from: tjb.a$a, reason: collision with other inner class name */
    public static final class C7736a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaskConfig f546446a;

        public C7736a(MaskConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "maskConfig");
            this.f546446a = r100;
        }

        @Override // rjb.f
        public final Rect a(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "anchorRect");
            MaskConfig r101 = this.f546446a;
            Rect r102 = r101.f425794d;
            if (r102 == null) goto L6;
            r100 = r102;
        L6:
            MaskConfig.ShapeType r103 = r101.f425793c;
            if (r103 != MaskConfig.ShapeType.CIRCLE) goto L9;
        L23:
            int r104 = (int) r101.f425792b;
            int r105 = Math.max(r100.width() + r104, r100.height() + r104);
            Size r106 = this.f546446a.f425795e;
            if (r106 == null) goto L26;
            r105 = Math.max(r105, Math.max(r106.getWidth(), this.f546446a.f425795e.getHeight()));
        L26:
            int r107 = r105 / 2;
            int r108 = r100.centerX();
            int r109 = r100.centerY();
            Rect r110 = new Rect(r100);
            r110.left = r108 - r107;
            r110.right = r108 + r107;
            r110.top = r109 - r107;
            r110.bottom = r109 + r107;
            return r110;
        L9:
            if (r103 == MaskConfig.ShapeType.SQUARE) goto L23;
            int r111 = (int) r101.f425792b;
            Size r112 = r101.f425795e;
            if (r112 == null) goto L21;
            int r113 = r112.getWidth();
            int r114 = this.f546446a.f425795e.getHeight();
            int r115 = r111 * 2;
            if ((r100.width() + r115) >= r113) goto L16;
            int r116 = (r113 - r100.width()) / 2;
        L18:
            if ((r100.height() + r115) >= r114) goto L20;
            r111 = (r114 - r100.height()) / 2;
        L20:
            int r117 = r111;
            r111 = r116;
            int r118 = r117;
        L22:
            Rect r119 = new Rect(r100);
            r119.left -= r111;
            r119.right += r111;
            r119.top -= r118;
            r119.bottom += r118;
            return r119;
        L16:
            r116 = r111;
            goto L18
        L21:
            r118 = r111;
            goto L22
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f546447a = null;

        static {
            int[] r100 = new int[AnchorConfig.AnchorGravity.values().length];
            r100[AnchorConfig.AnchorGravity.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AnchorConfig.AnchorGravity.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AnchorConfig.AnchorGravity.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AnchorConfig.AnchorGravity.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f546447a = r100;
        }
    }

    @Override // rjb.b
    public final void f() {
    }

    public abstract void h();

    public abstract boolean i();

    public abstract ujb.f m(g r100);

    public abstract View n(Context r100, ujb.f r101);

    public View p(Context r100, BubbleLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "layout");
        return r101;
    }

    static {
        f546438h = new Rect();
    }

    @Override // rjb.b
    public final int c() {
        AnchorConfig.AnchorGravity r100 = this.f546443e.f425787b;
        int r101 = c.f546447a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1;
    L5:
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L8;
        return 2;
    L8:
        if (r101 != 4) goto L11;
        return 4;
    L11:
        throw new NoWhenBranchMatchedException();
    L15:
        return 3;
    }

    public final tjb.b o() {
        Activity r100 = this.f546439a.get();
        boolean r101 = false;
        if (r100 != null) goto L5;
        Log.e("BaseBubbleComponent", "activityRef get is null");
    L8:
        rjb.e r102 = null;
    L17:
        if (r102 == null) goto L33;
        rjb.b r103 = r102.f538210a;
        if (r103 == null) goto L30;
        View r104 = r102.f538211b;
        if (r104 == null) goto L30;
        Boolean r110 = r102.f538212c;
        Boolean r111 = r102.f538214e;
        Activity r112 = r102.f538213d;
        Integer r113 = r102.f538215f;
        Integer r114 = r102.f538216g;
        Boolean r105 = r102.f538217h;
        if (r105 == null) goto L26;
        r101 = r105.booleanValue();
    L26:
        rjb.a r106 = new rjb.a(r103, r104, r110, r111, r112, r113, r114, Boolean.valueOf(r101), r102.f538218i, r102.f538219j, r102.f538220k, r102.f538221l, r102.f538222m);
        if (r102.f538223n != OverlayType.POPUP_WINDOW) goto L29;
        g r107 = new rjb.c(r106);
    L31:
        if (r107 == null) goto L33;
        r107.show();
        WeakReference r108 = new WeakReference(r107);
    L35:
        return new tjb.b(r108);
    L29:
        r107 = new i(r106);
    L30:
        r107 = null;
    L33:
        r108 = null;
        goto L35
    L5:
        View r109 = this.f546443e.f425786a.get();
        if (r109 != null) goto L9;
        Log.e("BaseBubbleComponent", "viewRef get is null");
        goto L8
    L9:
        boolean r115 = i();
        h();
        r102 = new rjb.e();
        Intrinsics.checkNotNullParameter(r109, "anchorView");
        r102.f538211b = r109;
        Intrinsics.checkNotNullParameter(this, "component");
        r102.f538210a = this;
        OverlayType r116 = this.f546444f.f550454c;
        Intrinsics.checkNotNullParameter(r116, "overlayType");
        r102.f538223n = r116;
        r102.f538212c = Boolean.valueOf(r115);
        Boolean r117 = Boolean.TRUE;
        r102.f538221l = r117;
        r102.f538222m = this;
        MaskConfig r118 = this.f546442d;
        if (r118 == null) goto L17;
        Intrinsics.checkNotNullParameter(r100, "activity");
        r102.f538214e = r117;
        r102.f538213d = r100;
        r102.f538215f = Integer.valueOf(r118.f425791a);
        r102.f538216g = Integer.valueOf(UIUtils.getColor(r100, R.color.lkui_N1000));
        r102.f538217h = r117;
        if (r118.f425793c != MaskConfig.ShapeType.CIRCLE) goto L15;
        r102.f538219j = 0;
    L16:
        r102.f538218i = Integer.valueOf(UIUtils.dp2px(r100, 4.0f));
        C7736a r119 = new C7736a(r118);
        Intrinsics.checkNotNullParameter(r119, "handler");
        r102.f538220k = r119;
        goto L17
    L15:
        r102.f538219j = 1;
        goto L16
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ujb.b r100 = this.f546444f.f550453b;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    @Override // rjb.b
    public final Rect b() {
        return l();
    }

    public Rect l() {
        return f546438h;
    }

    public int j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.getColor(r100, R.color.primary_fill_hover);
    }

    public int k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.dp2px(r100, 8.0f);
    }

    @Override // rjb.b
    public final void a(Context r110, LinearLayout r111, g r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "containerView");
        Intrinsics.checkNotNullParameter(r112, "guide");
        View r100 = n(r110, m(r112));
        BubbleLayout r101 = new BubbleLayout(r110);
        BubbleLayout.b r102 = r101.getConfigSetter();
        BubbleLayout.h(r102.f425815a, this.f546443e.f425787b.getValue());
        MaskConfig r103 = this.f546442d;
        if (r103 == null) goto L14;
        Integer r104 = Integer.valueOf(r103.f425796f);
        if (r104.intValue() == 0) goto L7;
        boolean r105 = true;
    L9:
        if (Boolean.valueOf(r105).booleanValue() == true) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L14;
        int r106 = r104.intValue();
    L15:
        BubbleLayout.f(r102.f425815a, r106);
        BubbleLayout.c(r102.f425815a, UIUtils.dp2px(r110, 24.0f) * 1.0f);
        BubbleLayout.d(r102.f425815a, UIUtils.dp2px(r110, 9.0f) * 1.0f);
        BubbleLayout.b(r102.f425815a, k(r110) * 1.0f);
        BubbleLayout.a(r102.f425815a, !(this instanceof d));
        BubbleLayout.e(r102.f425815a, r100);
        BubbleLayout r107 = r102.f425815a;
        int r108 = (int) 0.0f;
        r107.f425803b.setPadding(r108, r108, r108, r108);
        r107.f425803b.setFillColor(r107.f425807f);
        r107.f425803b.setCornerRadius(r107.f425808g);
        r107.f425804c.setAnchorGravity(r107.f425806e);
        r107.f425804c.setFillColor(r107.f425809h);
        float r109 = r107.f425803b.getCornerRadius();
        float r113 = r107.f425810i;
        if (r107.f425813l == true) goto L18;
    L20:
        r109 = r113;
    L21:
        int r114 = r107.f425806e;
        if (r114 == 3) goto L27;
        if (r114 == 5) goto L27;
        if (r114 == 8388611) goto L27;
        if (r114 == 8388613) goto L27;
        float r115 = r107.f425811j;
        float r116 = r107.f425812k;
        r107.f425805d.setPadding((int) r109, 0, 0, 0);
    L28:
        ConstraintSet r117 = new ConstraintSet();
        r117.clone(r107.f425805d);
        r117.constrainWidth(R.id.bubble_arrow, (int) r115);
        r117.constrainHeight(R.id.bubble_arrow, (int) r116);
        r117.applyTo(r107.f425805d);
        ConstraintLayout r118 = r107.f425802a;
        int r119 = r107.f425806e;
        ConstraintSet r120 = new ConstraintSet();
        r120.clone(r118);
        if (r119 == 8388611) goto L42;
        if (r119 == 3) goto L42;
        if (r119 == 8388613) goto L41;
        if (r119 == 5) goto L41;
        if (r119 != 48) goto L39;
        r120.connect(R.id.bubble_card, 3, 0, 3);
        r120.connect(R.id.bubble_card, 4, R.id.bubble_arrow_wrapper, 3);
        r120.connect(R.id.bubble_card, 6, 0, 6);
        r120.connect(R.id.bubble_arrow_wrapper, 3, R.id.bubble_card, 4);
        r120.connect(R.id.bubble_arrow_wrapper, 6, R.id.bubble_card, 6);
    L43:
        r120.applyTo(r118);
        this.f546445g = r101;
        r111.addView(p(r110, r101));
        return;
    L39:
        if (r119 != 80) goto L43;
        r120.connect(R.id.bubble_arrow_wrapper, 3, 0, 3);
        r120.connect(R.id.bubble_arrow_wrapper, 4, R.id.bubble_card, 3);
        r120.connect(R.id.bubble_arrow_wrapper, 6, R.id.bubble_card, 6);
        r120.connect(R.id.bubble_card, 3, R.id.bubble_arrow_wrapper, 4);
        r120.connect(R.id.bubble_card, 6, 0, 6);
        r120.connect(R.id.bubble_card, 7, 0, 7);
    L41:
        r120.connect(R.id.bubble_arrow_wrapper, 6, 0, 6);
        r120.connect(R.id.bubble_arrow_wrapper, 7, R.id.bubble_card, 6);
        r120.connect(R.id.bubble_arrow_wrapper, 3, R.id.bubble_card, 3);
        r120.connect(R.id.bubble_card, 6, R.id.bubble_arrow_wrapper, 7);
        r120.connect(R.id.bubble_card, 3, 0, 3);
        r120.connect(R.id.bubble_card, 4, 0, 4);
    L42:
        r120.connect(R.id.bubble_card, 6, 0, 6);
        r120.connect(R.id.bubble_card, 3, 0, 3);
        r120.connect(R.id.bubble_card, 4, 0, 4);
        r120.connect(R.id.bubble_card, 7, R.id.bubble_arrow_wrapper, 6);
        r120.connect(R.id.bubble_arrow_wrapper, 6, R.id.bubble_card, 7);
        r120.connect(R.id.bubble_arrow_wrapper, 3, R.id.bubble_card, 3);
    L27:
        r115 = r107.f425812k;
        r116 = r107.f425811j;
        r107.f425805d.setPadding(0, (int) r109, 0, 0);
        goto L28
    L18:
        if (r113 >= r109) goto L20;
    L7:
        r105 = false;
    L14:
        r106 = j(r110);
        goto L15
    }

    @Override // rjb.b
    public final void d(LinearLayout r100, Size r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "containerWH");
        Rect r103 = l();
        int r104 = c.f546447a[this.f546443e.f425787b.ordinal()];
        if (r104 == 1) goto L12;
        if (r104 == 2) goto L12;
        if (r104 != 3) goto L7;
    L11:
        int r105 = r101.getWidth() - r103.left;
        int r106 = r103.right;
    L13:
        float r107 = (r105 - r106) * 1.0f;
        BubbleLayout r108 = this.f546445g;
        if (r108 == null) goto L16;
        float r109 = r108.getArrowMainLen();
    L17:
        float r110 = r107 - r109;
        float r111 = 2;
        float r112 = (-r110) / r111;
        float r113 = r110 / r111;
        float r114 = r102;
        float r115 = 1.0f * r114;
        if (r114 >= r112) goto L21;
        r113 = r112;
    L24:
        float r116 = Math.abs(r112) + r113;
        BubbleLayout r117 = this.f546445g;
        if (r117 == null) goto L45;
        BubbleLayout.a r118 = r117.getArrowOffsetSetter();
        if (r118 == null) goto L46;
        BubbleLayout.g(r118.f425814a, r116);
        BubbleLayout r119 = r118.f425814a;
        float r120 = r119.f425803b.getCornerRadius();
        float r121 = r119.f425810i;
        if (r119.f425813l == true) goto L31;
    L33:
        r120 = r121;
    L34:
        int r122 = r119.f425806e;
        if (r122 != 3) goto L37;
    L43:
        r119.f425805d.setPadding(0, (int) r120, 0, 0);
        return;
    L37:
        if (r122 == 5) goto L43;
        if (r122 == 8388611) goto L43;
        if (r122 == 8388613) goto L43;
        r119.f425805d.setPadding((int) r120, 0, 0, 0);
        return;
    L31:
        if (r121 >= r120) goto L33;
    L46:
        return;
    L45:
        return;
    L21:
        if (r114 > r113) goto L24;
        r113 = r115;
        goto L24
    L16:
        r109 = 0.0f;
        goto L17
    L7:
        if (r104 == 4) goto L11;
        throw new NoWhenBranchMatchedException();
    L12:
        r105 = r101.getHeight() - r103.top;
        r106 = r103.bottom;
        goto L13
    }

    @Override // rjb.b
    public final int e(LinearLayout r100, Size r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "containerWH");
        Intrinsics.checkNotNullParameter(r102, "anchorRect");
        Rect r103 = l();
        AnchorConfig r104 = this.f546443e;
        AnchorConfig.AnchorGravity r105 = r104.f425787b;
        int r106 = 0;
        if (r105 != AnchorConfig.AnchorGravity.TOP) goto L5;
    L6:
        r106 = (0 + r104.f425788c.x) + ((r103.right - r103.left) / 2);
    L8:
        if (r105 == AnchorConfig.AnchorGravity.START) goto L12;
        if (r105 == AnchorConfig.AnchorGravity.END) goto L12;
        return r106;
    L12:
        return (r106 + r104.f425788c.y) + ((r103.bottom - r103.top) / 2);
    L5:
        if (r105 != AnchorConfig.AnchorGravity.BOTTOM) goto L8;
        goto L6
    }

    @Override // rjb.b
    public final int g(LinearLayout r100, Size r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "containerWH");
        Intrinsics.checkNotNullParameter(r102, "anchorRect");
        int r103 = UIUtils.dp2px(r100.getContext(), 8.0f);
        MaskConfig r104 = this.f546442d;
        if (r104 == null) goto L20;
        Rect r105 = new C7736a(r104).a(r102);
        AnchorConfig.AnchorGravity r106 = this.f546443e.f425787b;
        if (r106 == AnchorConfig.AnchorGravity.TOP) goto L9;
        if (r106 == AnchorConfig.AnchorGravity.BOTTOM) goto L9;
    L12:
        AnchorConfig.AnchorGravity r107 = this.f546443e.f425787b;
        if (r107 == AnchorConfig.AnchorGravity.START) goto L17;
        if (r107 != AnchorConfig.AnchorGravity.END) goto L20;
    L17:
        if (r105.width() <= r102.width()) goto L19;
        r103 = r103 + ((r105.width() - r102.width()) / 2);
    L19:
        r103 = r103 + this.f546443e.f425788c.x;
    L9:
        if (r105.height() <= r102.height()) goto L11;
        r103 = r103 + ((r105.height() - r102.height()) / 2);
    L11:
        r103 = r103 + this.f546443e.f425788c.y;
    L20:
        Rect r108 = l();
        AnchorConfig.AnchorGravity r109 = this.f546443e.f425787b;
        int r110 = c.f546447a[r109.ordinal()];
        if (r110 == 1) goto L32;
        if (r110 != 2) goto L24;
        int r111 = r108.left;
    L34:
        return r103 - r111;
    L24:
        if (r110 != 3) goto L26;
        r111 = r108.bottom;
        goto L34
    L26:
        if (r110 != 4) goto L29;
        r111 = r108.top;
        goto L34
    L29:
        throw new NoWhenBranchMatchedException();
    L32:
        r111 = r108.right;
        goto L34
    }

    public a(WeakReference<Activity> r100, String r101, String r102, MaskConfig r103, AnchorConfig r104, ujb.a r105) {
        Intrinsics.checkNotNullParameter(r100, "activityRef");
        Intrinsics.checkNotNullParameter(r102, "detail");
        Intrinsics.checkNotNullParameter(r104, "anchorConfig");
        Intrinsics.checkNotNullParameter(r105, "bubbleConfig");
        this.f546439a = r100;
        this.f546440b = r101;
        this.f546441c = r102;
        this.f546442d = r103;
        this.f546443e = r104;
        this.f546444f = r105;
    }
}
