package nk6;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import ek6.c;
import kotlin.Pair;
import lk6.d;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements View.OnClickListener {
    public a() {
    }

    public abstract boolean a(View r100, c r101, ClickableSpan r102);

    public abstract void b(View r100);

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = r100 instanceof TextView;
        Pair r102 = null;
        if (r101 == true) goto L7;
        View r103 = null;
    L8:
        TextView r104 = (TextView) r103;
        if (r101 == true) goto L11;
        View r105 = null;
    L12:
        TextView r106 = (TextView) r105;
        if (r106 == null) goto L15;
        Integer r107 = Integer.valueOf(r106.getSelectionStart());
    L16:
        if (r101 == true) goto L18;
        View r108 = null;
    L19:
        TextView r109 = (TextView) r108;
        if (r109 == null) goto L22;
        Integer r110 = Integer.valueOf(r109.getSelectionEnd());
    L23:
        if (r104 == null) goto L48;
        if (r107 == null) goto L48;
        if (r110 == null) goto L48;
        if (r107.intValue() == (-1)) goto L48;
        if (r110.intValue() == (-1)) goto L48;
        CharSequence r111 = r104.getText();
        int r112 = r107.intValue();
        int r113 = r110.intValue();
        if ((r111 instanceof Spanned) == true) goto L34;
        r111 = null;
    L34:
        Spanned r114 = (Spanned) r111;
        boolean r115 = false;
        if (r114 == null) goto L43;
        d[] r116 = (d[]) r114.getSpans(r112, r113, d.class);
        if (r116.length != 0) goto L39;
        boolean r117 = true;
    L40:
        if (r117 == true) goto L43;
        d r118 = r116[0];
        r102 = new Pair(r118, r118.f509594a);
        goto L43
    L39:
        r117 = false;
    L43:
        if (r102 == null) goto L45;
        c r119 = (c) r102.getSecond();
        ClickableSpan r120 = (ClickableSpan) r102.getFirst();
        r107.intValue();
        r110.intValue();
        r115 = a(r100, r119, r120);
    L45:
        if (r115 == true) goto L50;
        b(r100);
        return;
    L50:
        return;
    L48:
        b(r100);
        return;
    L22:
        r110 = null;
        goto L23
    L18:
        r108 = r100;
        goto L19
    L15:
        r107 = null;
        goto L16
    L11:
        r105 = r100;
        goto L12
    L7:
        r103 = r100;
        goto L8
    }
}
