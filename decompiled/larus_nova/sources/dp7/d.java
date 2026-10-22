package dp7;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ugc.glue.UGCTools;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends cp7.c.e<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f469610a = null;

    static {
        f469610a = new d();
    }

    public d() {
    }

    @Override // cp7.c.e
    public final View b(View r100) {
        if ((r100 instanceof TextView) == true) goto L6;
        r100 = null;
    L6:
        return (TextView) r100;
    }

    @Override // cp7.c.e
    public final int c(View r100) {
        CharSequence r101 = ((TextView) r100).getText();
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L7:
        return !UGCTools.isEmpty(r102) ? 1 : 0;
    L5:
        r102 = null;
        goto L7
    }
}
