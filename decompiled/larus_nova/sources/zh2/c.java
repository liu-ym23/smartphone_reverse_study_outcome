package zh2;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final void a(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setHeaderConstraint");
        if (r101 != null) goto L6;
        r100.setVisibility(8);
        return;
    L6:
        Integer r102 = r101.f572178p;
        if (r102 == null) goto L9;
        r100.setPadding(UtilityKotlinExtentionsKt.d(Integer.valueOf(r102.intValue())), r100.getPaddingTop(), r100.getPaddingRight(), r100.getPaddingBottom());
    L9:
        Integer r103 = r101.f572170h;
        if (r103 == null) goto L12;
        int r104 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r103.intValue()));
        r100.setPadding(r100.getPaddingLeft(), r104, r100.getPaddingRight(), r100.getPaddingBottom());
    L12:
        Integer r105 = r101.f572182t;
        if (r105 == null) goto L15;
        int r106 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r105.intValue()));
        r100.setPadding(r100.getPaddingLeft(), r100.getPaddingTop(), r106, r100.getPaddingBottom());
    L15:
        Integer r107 = r101.f572174l;
        if (r107 == null) goto L18;
        int r108 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r107.intValue()));
        r100.setPadding(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getPaddingRight(), r108);
    L18:
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == true) goto L21;
        r109 = null;
    L21:
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r109;
        if (r110 == null) goto L97;
        Integer r111 = r101.f572163a;
        if (r111 == null) goto L26;
        ((ViewGroup.MarginLayoutParams) r110).width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r111.intValue()));
    L26:
        Integer r112 = r101.f572164b;
        if (r112 == null) goto L29;
        ((ViewGroup.MarginLayoutParams) r110).height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r112.intValue()));
    L29:
        Integer r113 = r101.f572165c;
        boolean r114 = true;
        int r115 = 0;
        if (r113 == null) goto L32;
        int r116 = r113.intValue();
        r110.leftToLeft = r116;
        r110.rightToRight = r116;
        boolean r117 = true;
    L33:
        Integer r118 = r101.f572166d;
        if (r118 == null) goto L36;
        int r119 = r118.intValue();
        r110.topToTop = r119;
        r110.bottomToBottom = r119;
    L37:
        int r120 = -1;
        if (r114 == true) goto L48;
        Integer r121 = r101.f572167e;
        if (r121 == null) goto L42;
        int r122 = r121.intValue();
    L43:
        r110.topToTop = r122;
        Integer r123 = r101.f572168f;
        if (r123 == null) goto L46;
        int r124 = r123.intValue();
    L47:
        r110.topToBottom = r124;
        goto L48
    L46:
        r124 = -1;
        goto L47
    L42:
        r122 = -1;
    L48:
        Integer r125 = r101.f572169g;
        if (r125 == null) goto L51;
        int r126 = r125.intValue();
    L52:
        ((ViewGroup.MarginLayoutParams) r110).topMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r126));
        if (r114 == true) goto L63;
        Integer r127 = r101.f572171i;
        if (r127 == null) goto L57;
        int r128 = r127.intValue();
    L58:
        r110.bottomToTop = r128;
        Integer r129 = r101.f572172j;
        if (r129 == null) goto L61;
        int r130 = r129.intValue();
    L62:
        r110.bottomToBottom = r130;
        goto L63
    L61:
        r130 = -1;
        goto L62
    L57:
        r128 = -1;
    L63:
        Integer r131 = r101.f572173k;
        if (r131 == null) goto L66;
        int r132 = r131.intValue();
    L67:
        ((ViewGroup.MarginLayoutParams) r110).bottomMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r132));
        if (r117 == true) goto L78;
        Integer r133 = r101.f572175m;
        if (r133 == null) goto L72;
        int r134 = r133.intValue();
    L73:
        r110.leftToLeft = r134;
        Integer r135 = r101.f572176n;
        if (r135 == null) goto L76;
        int r136 = r135.intValue();
    L77:
        r110.leftToRight = r136;
        goto L78
    L76:
        r136 = -1;
        goto L77
    L72:
        r134 = -1;
    L78:
        Integer r137 = r101.f572177o;
        if (r137 == null) goto L81;
        int r138 = r137.intValue();
    L82:
        ((ViewGroup.MarginLayoutParams) r110).leftMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r138));
        if (r117 == true) goto L92;
        Integer r139 = r101.f572179q;
        if (r139 == null) goto L87;
        int r140 = r139.intValue();
    L88:
        r110.rightToLeft = r140;
        Integer r141 = r101.f572180r;
        if (r141 == null) goto L91;
        r120 = r141.intValue();
    L91:
        r110.rightToRight = r120;
        goto L92
    L87:
        r140 = -1;
    L92:
        Integer r142 = r101.f572181s;
        if (r142 == null) goto L95;
        r115 = r142.intValue();
    L95:
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = UtilityKotlinExtentionsKt.d(Integer.valueOf(r115));
        r100.setLayoutParams(r110);
        return;
    L81:
        r138 = 0;
        goto L82
    L66:
        r132 = 0;
        goto L67
    L51:
        r126 = 0;
        goto L52
    L36:
        r114 = false;
        goto L37
    L32:
        r117 = false;
        goto L33
    }
}
