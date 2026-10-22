package p3b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends v4b.a {
    public static final /* synthetic */ int W = 0;

    public static int b(boolean r100) {
        if (r100 == false) goto L5;
        return v4b.a.f553163a;
    L5:
        return v4b.a.f553188z;
    }

    public static Drawable c(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.drawable.post_show_more_bg_blue;
    L5:
        GradientDrawable r103 = (GradientDrawable) UIUtils.getDrawable(r100, r102);
        int[] r104 = new int[2];
        if (r101 == false) goto L8;
        int r105 = v4b.a.f553165c;
    L9:
        r104[0] = r105;
        if (r101 == false) goto L12;
        int r106 = v4b.a.f553164b;
    L13:
        r104[1] = r106;
        r103.setColors(r104);
        return r103;
    L12:
        r106 = v4b.a.A;
        goto L13
    L8:
        r105 = v4b.a.B;
        goto L9
    L4:
        r102 = R.drawable.post_show_more_bg_gray;
        goto L5
    }
}
