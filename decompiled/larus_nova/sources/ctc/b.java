package ctc;

import android.text.Layout;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465383a = 0;

    public static final class a {
        public static Object[] a(MotionEvent r100, TextView r101, Class r102) {
            float r103 = r100.getX();
            float r104 = r100.getY();
            float r105 = r103 - r101.getTotalPaddingLeft();
            float r106 = r104 - r101.getTotalPaddingTop();
            float r107 = r105 + r101.getScrollX();
            float r108 = r106 + r101.getScrollY();
            Layout r109 = r101.getLayout();
            CharSequence r110 = r101.getText();
            if (r109 != null) goto L5;
            return null;
        L5:
            if ((r110 instanceof Spanned) == false) goto L10;
            int r111 = r109.getOffsetForHorizontal(r109.getLineForVertical((int) r108), r107);
            return ((Spanned) r110).getSpans(r111, r111, r102);
        L10:
            return null;
        }
    }

    static {
    }
}
