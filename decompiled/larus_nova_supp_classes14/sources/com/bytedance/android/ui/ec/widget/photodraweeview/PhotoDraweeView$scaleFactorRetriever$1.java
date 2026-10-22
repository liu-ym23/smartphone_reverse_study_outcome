package com.bytedance.android.ui.ec.widget.photodraweeview;

import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PhotoDraweeView$scaleFactorRetriever$1 extends MutablePropertyReference0Impl {
    public PhotoDraweeView$scaleFactorRetriever$1(PhotoDraweeView r7) {
        super(r7, PhotoDraweeView.class, "defaultGestureHandler", "getDefaultGestureHandler()Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", 0);
    }

    public Object get() {
        return PhotoDraweeView.access$getDefaultGestureHandler$p((PhotoDraweeView) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        PhotoDraweeView.access$setDefaultGestureHandler$p((PhotoDraweeView) ((CallableReference) this).receiver, (DefaultGestureHandler) r2);
    }
}
