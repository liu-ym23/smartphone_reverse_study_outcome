package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"findTransitionPhotoView", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;", "Landroid/view/View;", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class TransitionViewHolderKt {
    public static final /* synthetic */ TransitionPhotoDraweeView access$findTransitionPhotoView(View r0) {
        return findTransitionPhotoView(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final TransitionPhotoDraweeView findTransitionPhotoView(View r5) {
        if ((r5 instanceof TransitionPhotoDraweeView) == false) goto L7;
        return (TransitionPhotoDraweeView) r5;
    L7:
        if ((r5 instanceof ViewGroup) == false) goto L14;
        ViewGroup r6 = (ViewGroup) r5;
        int r0 = r6.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        TransitionPhotoDraweeView r3 = findTransitionPhotoView(r6.getChildAt(r2));
        if ((r3 instanceof TransitionPhotoDraweeView) == true) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r3;
    L14:
        return null;
    }
}
