package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface DraweeController {
    void clearHierarchy();

    Animatable getAnimatable();

    String getContentDescription();

    @Nullable
    DraweeHierarchy getHierarchy();

    boolean isSameImageRequest(DraweeController r100);

    void onAttach();

    void onDetach();

    boolean onTouchEvent(MotionEvent r100);

    void onViewportVisibilityHint(boolean r100);

    void setContentDescription(String r100);

    void setHierarchy(@Nullable DraweeHierarchy r100);
}
