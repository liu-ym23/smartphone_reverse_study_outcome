package wb2;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final boolean a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        boolean r100 = r110 instanceof TextView;
        CharSequence r101 = null;
        if (r100 == true) goto L5;
        View r102 = null;
    L6:
        TextView r103 = (TextView) r102;
        if (r103 == null) goto L9;
        CharSequence r104 = r103.getText();
    L11:
        if ((r104 instanceof Spannable) == true) goto L13;
        r104 = null;
    L13:
        Spannable r105 = (Spannable) r104;
        if (r105 == null) goto L24;
        TextView r106 = (TextView) r110;
        d[] r107 = (d[]) r105.getSpans(r106.getSelectionStart(), r106.getSelectionEnd(), d.class);
        int r108 = r107.length;
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L24;
        d r111 = r107[r109];
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "view");
        d.a r112 = r111.f558922a;
        if (r112 == null) goto L20;
        boolean r113 = r112.d(r110, r111);
    L21:
        if (r113 == true) goto L22;
        r109 = r109 + 1;
        goto L16
    L22:
        return true;
    L20:
        r113 = false;
    L24:
        if (r100 == true) goto L26;
        View r114 = null;
    L27:
        TextView r115 = (TextView) r114;
        if (r115 == null) goto L30;
        CharSequence r116 = r115.getText();
    L32:
        if ((r116 instanceof SpannedString) == true) goto L34;
        r116 = null;
    L34:
        SpannedString r117 = (SpannedString) r116;
        if (r117 == null) goto L45;
        TextView r118 = (TextView) r110;
        d[] r119 = (d[]) r117.getSpans(r118.getSelectionStart(), r118.getSelectionEnd(), d.class);
        int r120 = r119.length;
        int r121 = 0;
    L37:
        if (r121 >= r120) goto L45;
        d r122 = r119[r121];
        r122.getClass();
        Intrinsics.checkNotNullParameter(r110, "view");
        d.a r123 = r122.f558922a;
        if (r123 == null) goto L41;
        boolean r124 = r123.d(r110, r122);
    L42:
        if (r124 == true) goto L43;
        r121 = r121 + 1;
        goto L37
    L43:
        return true;
    L41:
        r124 = false;
    L45:
        if (r100 == true) goto L47;
        View r125 = null;
    L48:
        TextView r126 = (TextView) r125;
        if (r126 == null) goto L51;
        CharSequence r127 = r126.getText();
    L53:
        if ((r127 instanceof SpannableString) == false) goto L56;
        r101 = r127;
    L56:
        SpannableString r128 = (SpannableString) r101;
        if (r128 == null) goto L67;
        TextView r129 = (TextView) r110;
        d[] r130 = (d[]) r128.getSpans(r129.getSelectionStart(), r129.getSelectionEnd(), d.class);
        int r131 = r130.length;
        int r132 = 0;
    L59:
        if (r132 >= r131) goto L67;
        d r133 = r130[r132];
        r133.getClass();
        Intrinsics.checkNotNullParameter(r110, "view");
        d.a r134 = r133.f558922a;
        if (r134 == null) goto L63;
        boolean r135 = r134.d(r110, r133);
    L64:
        if (r135 == true) goto L65;
        r132 = r132 + 1;
        goto L59
    L65:
        return true;
    L63:
        r135 = false;
    L67:
        return false;
    L51:
        r127 = null;
        goto L53
    L47:
        r125 = r110;
        goto L48
    L30:
        r116 = null;
        goto L32
    L26:
        r114 = r110;
        goto L27
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = r110;
        goto L6
    }
}
