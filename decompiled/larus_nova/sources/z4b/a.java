package z4b;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static int b(Context r100, float r101) {
        if (r101 <= 0.0f) goto L7;
        r101 = UIUtils.dp2px(r100, r101);
    L7:
        return (int) r101;
    }

    public static ConstraintLayout.LayoutParams a(Context r100, float r101, float r102, int r103) {
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(b(r100, r101), b(r100, r102));
        float r105 = 0;
        r104.setMargins(b(r100, r105), b(r100, r105), b(r100, r105), b(r100, r103));
        return r104;
    }
}
