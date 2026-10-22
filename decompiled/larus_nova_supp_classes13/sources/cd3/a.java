package cd3;

import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements SlcScrollingView.b {
    public final /* synthetic */ b a;
    public final /* synthetic */ SlcScrollingView b;

    @Override // com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView.b
    public final void a() {
        if (this.a.W3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        Object r1 = ((BaseSlcViewManager) this.a).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r1 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L10;
        r1 = null;
    L10:
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
        if (r2 == null) goto L15;
        b r3 = this.a;
        r2.O(r3.W3, r3.X3, this.b);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public a(b r1, SlcScrollingView r2) {
        this.a = r1;
        this.b = r2;
    }
}
