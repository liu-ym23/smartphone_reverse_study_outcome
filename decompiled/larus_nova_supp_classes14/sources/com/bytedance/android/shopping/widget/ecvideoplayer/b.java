package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface b {
    void E();

    void g();

    void h(int r1, int r2);

    void onError(Error r1);

    void onIdle();

    void onPaused();

    void onPlaying();

    void onRelease();

    void onRenderStart();

    void onVideoSizeChanged(int r1, int r2);

    void w();
}
