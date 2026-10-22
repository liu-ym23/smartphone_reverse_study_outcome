package com.bytedance.ee.bear.bitable.card.view.cell.stage;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f208209a = 0;

    static {
    }

    public static void c(RingView r100, BaseTagSize r101) {
        Intrinsics.checkNotNullParameter(r100, "iconRing");
        Intrinsics.checkNotNullParameter(r101, "size");
        int r102 = r101.getStatusDotSizePx();
        if (r100.f209895e == true) goto L5;
    L6:
        r100.f209895e = true;
        r100.f209896f = r102;
        r100.invalidate();
        return;
    L5:
        if (r100.f209896f != r102) goto L6;
    }

    public static void d(View r100, BaseTagSize r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "size");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.height = n.d(r101.getHeightDp());
    L5:
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(r101.getRadiusPx());
        r100.setBackground(r103);
        r100.setPadding(n.d(r101.getLeftIconPaddingDp()), 0, n.d(r101.getTextPaddingHorizontalDp()), 0);
        TextView r104 = (TextView) r100.findViewById(R.id.tv_name);
        if (r104 == null) goto L13;
        r104.setTextSize(r101.getTextSizeSp());
        r104.setIncludeFontPadding(false);
        r104.setGravity(16);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L11:
        if (r106 == null) goto L13;
        r106.setMarginStart(n.d(r101.getLeftIconGapDp()));
        goto L13
    L10:
        r106 = null;
    L13:
        View r107 = r100.findViewById(R.id.icon_ring);
        if (r107 == null) goto L21;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L18;
        r108.width = n.d(r101.getLeftIconSizeDp());
    L18:
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
        if (r109 == null) goto L21;
        r109.height = n.d(r101.getLeftIconSizeDp());
    L21:
        View r110 = r100.findViewById(R.id.icon_done);
        if (r110 == null) goto L30;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L26;
        r111.width = n.d(r101.getLeftIconSizeDp());
    L26:
        ViewGroup.LayoutParams r112 = r110.getLayoutParams();
        if (r112 == null) goto L31;
        r112.height = n.d(r101.getLeftIconSizeDp());
        return;
    L31:
        return;
    }

    public static void a(View r100, BaseTagSize r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "size");
        Drawable r104 = r100.getBackground();
        if ((r104 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r105 = (GradientDrawable) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        r100.setBackgroundTintList(null);
        r105.setColor(r102);
        r101.applyBorderStroke(r105, r103);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void b(View r100, BaseTagSize r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "size");
        BaseTagSize.Companion.getClass();
        a(r100, r101, BaseTagSize.a.a(r102), BaseTagSize.a.a(r103));
    }
}
