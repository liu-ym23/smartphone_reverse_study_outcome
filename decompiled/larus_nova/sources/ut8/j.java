package ut8;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import lw8.l;

/* JADX INFO: loaded from: classes26.dex */
public final class j {
    public static int b(TextView r100) {
        int r101 = 0;
        if (r100.getCompoundDrawables()[0] == null) goto L5;
        int r102 = r100.getCompoundDrawables()[0].getIntrinsicWidth() + r100.getCompoundDrawablePadding();
    L6:
        int r103 = r102 + r100.getPaddingLeft();
        if ((r100 instanceof CustomMarkdownTextView) == false) goto L16;
        l r104 = ((CustomMarkdownTextView) r100).getMarkdownContent();
        if (r104 == null) goto L16;
        SpannableStringBuilder r105 = r104.e();
        lw8.e[] r106 = (lw8.e[]) r105.getSpans(0, r105.length(), lw8.e.class);
        if (r106 == null) goto L16;
        if (r106.length <= 0) goto L16;
        r101 = r106[0].a();
    L16:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public static int c(TextView r100) {
        if (r100.getCompoundDrawables()[1] == null) goto L5;
        int r101 = r100.getCompoundDrawables()[1].getIntrinsicHeight() + r100.getCompoundDrawablePadding();
    L7:
        return r101 + r100.getPaddingTop();
    L5:
        r101 = 0;
        goto L7
    }

    public static int a(TextView r100, int r101, int r102) {
        int r103 = r101 - b(r100);
        int r104 = r102 - c(r100);
        Layout r105 = r100.getLayout();
        if (r105 != null) goto L11;
    L8:
        return -1;
    L11:
        int r106 = r105.getOffsetForHorizontal(r105.getLineForVertical(r104), r103);     // Catch: Exception -> L10
        if (((int) r105.getPrimaryHorizontal(r106)) <= r103) goto L13;
        return r105.getOffsetToLeftOf(r106);
    L13:
        return r106;
    }
}
