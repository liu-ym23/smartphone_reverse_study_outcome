package com.ss.android.ugc.aweme.live.alphaplayer.controller;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface IPlayerController {

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setLoopListener(IPlayerController r100, ILoopListener r101) {
        }

        public static void $default$setOnElementClickListener(IPlayerController r100, OnElementClickListener r101) {
        }
    }

    public interface FirstGLFrameListener {
        void a();
    }

    public interface OnElementClickListener {
        void a(List<String> r100);
    }

    int a();

    void attachAlphaView(ViewGroup r100);

    void b(IProgressListener r100, long r101);

    void c(IMonitor r100);

    void cancel();

    void d(DataSource r100);

    void detachAlphaView(ViewGroup r100);

    void e(ILoopListener r100);

    void f(DataSource r100, boolean r101);

    IPlayerController g(AlphaPlayerAction r100);

    int getDuration();

    String getPlayerType();

    View getView();

    void h(MaskSrc r100);

    boolean isPlaying();

    void pause();

    void release();

    void reset();

    void resume();

    void setSurface(Surface r100);

    void startPlay();

    void stop();
}
