package ftc;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.core.spans.u;
import io.noties.markwon.core.spans.v;

/* JADX INFO: loaded from: classes41.dex */
public abstract class d {
    public static int a(Canvas r100, CharSequence r101) {
        if ((r101 instanceof Spanned) == false) goto L18;
        Spanned r102 = (Spanned) r101;
        u[] r103 = (u[]) r102.getSpans(0, r102.length(), u.class);
        if (r103 != null) goto L7;
    L9:
        Layout r104 = null;
    L10:
        if (r104 != null) goto L12;
        TextView r105 = v.a(r102);
        if (r105 == null) goto L18;
        return (r105.getWidth() - r105.getPaddingLeft()) - r105.getPaddingRight();
    L12:
        return r104.getWidth();
    L7:
        if (r103.length <= 0) goto L9;
        r104 = r103[0].f492371a.get();
    L18:
        return r100.getWidth();
    }
}
