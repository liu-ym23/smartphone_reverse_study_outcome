package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes40.dex */
public interface TTAVPlayerView {

    public static class Factory {
        public Factory() {
        }

        public static TTAVPlayerView create(Context r100, LifeCycleCallback r101, int r102, float r110, int r111) {
            return new TTPlayerView(r100, r101, r102, r110, r111);
        }
    }

    public interface LifeCycleCallback {

        /* JADX INFO: renamed from: com.ss.ttm.player.TTAVPlayerView$LifeCycleCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onNewSurfaceAvailable(LifeCycleCallback r100) {
            }
        }

        void onLoad(TTAVWindowClient r100);

        void onNewSurfaceAvailable();
    }

    void attachToParent(ViewGroup r100);

    void attachToParent(ViewGroup r100, ViewGroup.LayoutParams r101);

    void detachFromParent();

    Rect getSurfacePosition();

    Size getSurfaceSize();

    int getViewHeight();

    int getViewWidth();

    int getVisibility();

    boolean isSurfaceAvailable();

    boolean isSurfaceView();

    void setLayoutParams(ViewGroup.LayoutParams r100);

    void setLifeCycleCallback(LifeCycleCallback r100);

    void setScaleType(int r100, float r101, float r102);

    void setVisibility(int r100);
}
