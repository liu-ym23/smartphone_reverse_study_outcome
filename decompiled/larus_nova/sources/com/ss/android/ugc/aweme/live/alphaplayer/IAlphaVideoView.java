package com.ss.android.ugc.aweme.live.alphaplayer;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.render.IRender;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface IAlphaVideoView {

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setOnElementClickListener(IAlphaVideoView r100, IPlayerController.OnElementClickListener r101) {
        }
    }

    boolean a();

    boolean b(ViewGroup r100);

    void bringToFront();

    void c(float r100, float r101);

    boolean d(ViewGroup r100);

    void e(List<MaskSrc> r100);

    Context getContext();

    boolean getLastFrameHold();

    int getMeasuredHeight();

    int getMeasuredWidth();

    Resources getResources();

    DataSource.ScaleType getScaleType();

    View getView();

    void onCompletion();

    void onFirstFrame();

    void onPause();

    void release();

    void requestRender();

    void setConfigParams(DataSource.DataInfo r100);

    void setEnableElementEvent(boolean r100);

    void setFirstGLFrameListener(IPlayerController.FirstGLFrameListener r100);

    void setLastFrameHold(boolean r100);

    void setLayoutParams(ViewGroup.LayoutParams r100);

    void setOnElementClickListener(IPlayerController.OnElementClickListener r100);

    void setPlayerController(IPlayerController r100);

    void setVideoRenderer(IRender r100);

    void setVisibility(int r100);
}
