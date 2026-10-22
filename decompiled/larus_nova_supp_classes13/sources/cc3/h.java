package cc3;

import com.bytedance.android.shopping.commentgallery.view.CommentPhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements TransitionListener {
    public final /* synthetic */ CommentPhotoVH a;

    public final void onTransitionBegin(int r1) {
    }

    public h(CommentPhotoVH r1) {
        this.a = r1;
    }

    public final void onTransitionEnd(int r2) {
        if (r2 != 3) goto L6;
        CommentPhotoVH r3 = this.a;
        r3.f = r3.g;
        return;
    }

    public final void onTransitionChanged(int r6, float r7) {
        CommentPhotoVH r0 = this.a;
        if (r6 != 0) goto L5;
    L14:
        r0.g = r7;
        CommentPhotoVH r8 = this.a;
        if (r8.g <= 1.0f) goto L18;
        r8.g = 1.0f;
    L18:
        if (r8.g >= 0.0f) goto L20;
        r8.g = 0.0f;
    L20:
        r8.e.getBackground().setAlpha((int) (this.a.g * 255));
        return;
    L5:
        if (r6 != 1) goto L7;
        float r9 = r0.f;
        r7 = r9 + ((1 - r9) * r7);
        goto L14
    L7:
        if (r6 != 2) goto L9;
        r7 = r0.f * (1 - r7);
        goto L14
    L9:
        if (r6 == 3) goto L11;
        r7 = 1.0f;
        goto L14
    L11:
        r7 = 1 - RangesKt.coerceAtLeast(r7, 0.0f);
        goto L14
    }
}
