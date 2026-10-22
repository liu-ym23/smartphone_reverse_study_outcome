package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/DefaultTransitionParams;", "", "()V", "isDragReturnAnimationEnabled", "", "maxDragTransitionFactor", "", "transitionAnimationDuration", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultTransitionParams {
    public static final DefaultTransitionParams INSTANCE = null;
    public static final boolean isDragReturnAnimationEnabled = false;
    public static final float maxDragTransitionFactor = 0.4f;
    public static final long transitionAnimationDuration = 300;

    private DefaultTransitionParams() {
    }

    static {
        INSTANCE = new DefaultTransitionParams();
    }
}
