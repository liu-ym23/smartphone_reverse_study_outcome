package i83;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.voavhs.headbottom.AnchorV4HeadBottomView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2View;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.utils.d0;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends LinearLayout {
    public s a;

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return (r1 - 1) - r2;
    }

    public final AnchorV4HeadV2View getHeadView() {
        View r1 = null;
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        View r0 = getChildAt(0);
        if ((r0 instanceof AnchorV4HeadV2View) == false) goto L10;
        r1 = r0;
    L10:
        return (AnchorV4HeadV2View) r1;
    }

    public s getHeadAbility() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setOrientation(1);
        setChildrenDrawingOrderEnabled(true);
    }

    public void setHeadAbility(s r8) {
        this.a = r8;
        if (r8 == null) goto L44;
        AnchorV4HeadV2View r0 = new AnchorV4HeadV2View(getContext(), r8);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(r0);
        CommonMeta r1 = r8.rR().r0();
        ViewGroup.LayoutParams r4 = null;
        if (r1 == null) goto L7;
        Boolean r2 = Boolean.valueOf(r1.getEnablePDPOptimize());
    L8:
        int r5 = 0;
        if (k.i(r2) == false) goto L11;
    L14:
        boolean r3 = true;
    L16:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L33;
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r4 = r6;
    L21:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r4;
        if (r7 != null) goto L24;
        r7 = new ViewGroup.MarginLayoutParams(-2, -2);
    L24:
        if (r3 == false) goto L26;
        int r9 = k83.b.b(r8);
    L27:
        r7.bottomMargin = r9;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.c == true) goto L30;
    L32:
        r7.topMargin = r5;
        Unit r10 = Unit.INSTANCE;
        r0.setLayoutParams(r7);
        return;
    L30:
        if (r8.isExpanded() == false) goto L32;
        r5 = d0.a();
        goto L32
    L26:
        r9 = 0;
        goto L27
    L33:
        if (r3 == false) goto L46;
        AnchorV4HeadBottomView r11 = new AnchorV4HeadBottomView(getContext(), null, 6, 0);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r11.setHeadViewAbility(r8);
        ExtensionsKt.visible(r11);
        addView(r11);
        r8.rR().W(r11.getHeadViewStatusListener());
        if (r8.n0() == false) goto L37;
        return;
    L37:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L39;
        return;
    L39:
        if (r8.s() == true) goto L49;
        r8.eh().x(new b(r11));
        if (r8.isExpanded() == true) goto L50;
        r11.setAlpha(0.0f);
        return;
    L50:
        return;
    L49:
        return;
    L46:
        return;
    L11:
        if (PdpAB.b() == true) goto L14;
        r3 = false;
        goto L16
    L7:
        r2 = null;
        goto L8
    }
}
