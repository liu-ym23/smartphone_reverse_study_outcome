package com.bytedance.android.livesdk.ktvimpl.mv;

import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class w implements VideoEngineCallback {
    public w() {
    }

    public final String getEncryptedLocalTime() {
        return null;
    }

    public final void onABRPredictBitrate(int r1, int r2) {
    }

    public final void onAVBadInterlaced(Map<?, ?> r1) {
    }

    public final void onBufferEnd(int r1) {
    }

    public void onBufferStart(int r1, int r2, int r3) {
    }

    public void onBufferingUpdate(TTVideoEngine r1, int r2) {
    }

    public void onCompletion(TTVideoEngine r1) {
    }

    public /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
    }

    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r1);
    }

    public void onFrameAboutToBeRendered(TTVideoEngine r1, int r2, long r3, long r5, Map<Integer, String> r7) {
    }

    public void onFrameDraw(int r1, Map<Object, Object> r2) {
    }

    public final void onInfoIdChanged(int r1) {
    }

    public void onLoadStateChanged(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
        VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
    }

    public final void onReadyForDisplay(TTVideoEngine r1) {
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onRefreshSurface(this, r1);
    }

    public void onRenderStart(TTVideoEngine r1) {
    }

    public final void onSARChanged(int r1, int r2) {
    }

    public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
        return VideoEngineCallback.-CC.$default$onSetSurface(this, r1, r2, r3);
    }

    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onSilenceDetected(this, r1);
    }

    public final void onStreamChanged(TTVideoEngine r1, int r2) {
    }

    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onVideoSecondFrame(this, r1);
    }

    public final void onVideoSizeChanged(TTVideoEngine r1, int r2, int r3) {
    }

    public void onVideoStatusException(int r1) {
    }

    public final void onVideoStreamBitrateChanged(Resolution r1, int r2) {
    }

    public void onVideoURLRouteFailed(Error r1, String r2) {
    }
}
