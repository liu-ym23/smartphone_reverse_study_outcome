package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements TransitionListener {
    public final /* synthetic */ PhotoViewDialogFragment a;

    public k(PhotoViewDialogFragment r1) {
        this.a = r1;
    }

    public final void onTransitionBegin(int r3) {
        Iterator<T> r0 = this.a.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IIndicatorView) r0.next()).onTransitionBegin(r3);
        goto L4
    }

    public final void onTransitionEnd(int r3) {
        if (r3 != 2) goto L5;
        this.a.Y90();
    L9:
        Iterator<T> r0 = this.a.j.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        ((IIndicatorView) r0.next()).onTransitionEnd(r3);
        goto L11
    L13:
        return;
    L5:
        if (r3 != 3) goto L9;
        PhotoViewDialogFragment r1 = this.a;
        r1.l = r1.k;
        goto L9
    }

    public final void onTransitionChanged(int r4, float r5) {
        PhotoViewDialogFragment r0 = this.a;
        if (r4 != 0) goto L5;
        float r1 = r5;
    L15:
        r0.k = r1;
        this.a.W90().getBackground().setAlpha((int) (this.a.k * 255));
        Iterator<T> r2 = this.a.j.iterator();
    L17:
        if (r2.hasNext() == false) goto L19;
        ((IIndicatorView) r2.next()).onTransitionChanged(r4, r5);
        goto L17
    L19:
        return;
    L5:
        if (r4 != 1) goto L7;
        float r3 = r0.l;
        r1 = ((1 - r3) * r5) + r3;
        goto L15
    L7:
        if (r4 != 2) goto L9;
        r1 = (1 - r5) * r0.l;
        goto L15
    L9:
        if (r4 == 3) goto L11;
        r1 = 1.0f;
        goto L15
    L11:
        r1 = 1 - Math.max(r5, 0.0f);
        goto L15
    }
}
