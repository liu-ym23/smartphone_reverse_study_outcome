package l19;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes27.dex */
public interface a {
    int getDismissAnimationType();

    Rect getEnterTransitionStartRect();

    float getMaxDragTransitionFactor();

    int getPos();

    j19.e getRestoreTransitionProvider();

    long getTransitionAnimationDuration();

    boolean isDragTransitionEnabled();

    boolean isSingleTagDismissEnabled();

    void setDismissAnimationType(int r100);

    void setDragTransitionEnabled(boolean r100);

    void setEnterTransitionStartRect(Rect r100);

    void setMaxDragTransitionFactor(float r100);

    void setPos(int r100);

    void setRestoreTransitionProvider(j19.e r100);

    void setSingleTagDismissEnabled(boolean r100);

    void setTransitionAnimationDuration(long r100);
}
