package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.view.MotionEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/ITransitionParams;", "addTransitionListener", "", "listener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "dismissAnimated", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "removeTransitionListener", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TransitionView extends ITransitionParams {
    void addTransitionListener(TransitionListener r1);

    void dismissAnimated();

    boolean onTouchEvent(MotionEvent r1);

    void removeTransitionListener(TransitionListener r1);
}
