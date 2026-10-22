package yb8;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final SimpleDraweeView a(ConstraintLayout r100, GenericDraweeView r101) {
        int r102 = r100.indexOfChild(r101);
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if ((r103 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r103;
    L6:
        int r105 = r101.getVisibility();
        r100.removeView(r101);
        SimpleDraweeView r106 = new SimpleDraweeView(r100.getContext());
        r106.setId(r101.getId());
        if (r104 == null) goto L17;
        int r107 = ((ViewGroup.MarginLayoutParams) r104).width;
        if (r107 <= 0) goto L11;
        if (r107 == (-2)) goto L11;
    L12:
        int r108 = ((ViewGroup.MarginLayoutParams) r104).height;
        if (r108 <= 0) goto L15;
        if (r108 == (-2)) goto L15;
    L16:
        r106.setLayoutParams(r104);
    L15:
        ((ViewGroup.MarginLayoutParams) r104).height = i5.Q();
    L11:
        ((ViewGroup.MarginLayoutParams) r104).width = i5.Q();
    L17:
        r106.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(i5.c()));
        r106.setVisibility(r105);
        r100.addView(r106, r102);
        return r106;
    L5:
        r104 = null;
        goto L6
    }

    public static final String b(String r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L19;
        if (r101 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        return null;
    L13:
        if (r101.length() == 0) goto L16;
        r104 = false;
    L19:
        boolean r105 = h.f552477a;
        if (h.a(null) == false) goto L28;
        if (r101 != null) goto L23;
    L24:
        r102 = true;
    L25:
        if (r102 == true) goto L28;
        r100 = r101;
        goto L28
    L23:
        if (r101.length() != 0) goto L25;
    L28:
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public static final void c(TextView r100, boolean r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        if (r101 == false) goto L5;
        r103.setMarginStart(i5.q());
        r103.setMarginEnd(0);
    L6:
        r100.setLayoutParams(r103);
        return;
    L5:
        r103.setMarginStart(0);
        r103.setMarginEnd(0);
        goto L6
    }
}
