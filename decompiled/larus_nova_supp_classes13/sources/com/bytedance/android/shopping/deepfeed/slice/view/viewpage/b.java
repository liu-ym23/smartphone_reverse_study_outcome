package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.deepfeed.slice.service.a {
    public final /* synthetic */ c a;

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
    public final void onDestroy() {
        c r0 = this.a;
        b r1 = r0.O3;
        if (r1 == null) goto L11;
        Object r3 = ((BaseSlcViewManager) r0).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r3 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L7;
        r3 = null;
    L7:
        com.bytedance.android.shopping.deepfeed.slice.service.b r4 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r3;
        if (r4 == null) goto L10;
        r4.P(r1);
    L10:
        r0.O3 = null;
    L11:
        a r2 = r0.J3;
        if (r2 == null) goto L14;
        r2.b();
        r2.c = true;
        r2.h.removeOnAttachStateChangeListener(r2.g);
        r2.a.removeCallbacksAndMessages(null);
    L14:
        r0.J3 = null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
    public final void onResume() {
        this.a.r1();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
    public final void onStop() {
        a r0 = this.a.J3;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public b(c r1) {
        this.a = r1;
    }
}
