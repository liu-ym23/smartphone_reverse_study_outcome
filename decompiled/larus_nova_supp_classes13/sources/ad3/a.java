package ad3;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        b r0 = this.a;
        Object r1 = r0.g.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r1 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
        if (r2 != null) goto L8;
        return true;
    L8:
        if (r2.L() < 0) goto L10;
        return true;
    L10:
        if (r0.c >= 0) goto L16;
        r0.c(r0.d);
        return true;
    L16:
        return true;
    }
}
