package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "", "onTransitionBegin", "", "state", "", "onTransitionChanged", "factor", "", "onTransitionEnd", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TransitionListener {
    void onTransitionBegin(int r1);

    void onTransitionChanged(int r1, float r2);

    void onTransitionEnd(int r1);
}
