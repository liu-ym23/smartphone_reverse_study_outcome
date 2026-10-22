package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.VirtualBackgroundSource;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IVideoEffect {
    public IVideoEffect() {
    }

    public abstract int appendEffectNodes(List<String> r100);

    public abstract int applyStickerEffect(String r100);

    public abstract int disableFaceDetection();

    public abstract int disableVideoEffect();

    public abstract int disableVirtualBackground();

    public abstract int enableFaceDetection(IFaceDetectionObserver r100, int r101, String r102);

    public abstract int enableVideoEffect();

    public abstract int enableVirtualBackground(String r100, VirtualBackgroundSource r101);

    public abstract int getGestureRegistered(EffectTouchGesture r100);

    public abstract int getSuspendGestureRecognizer(EffectTouchGesture r100, boolean r101);

    public abstract long getVideoEffectHandle();

    public abstract int initCVResource(String r100, String r101);

    public abstract int removeEffectNodes(List<String> r100);

    public abstract int setAlgoModelResourceFinder(long r100, long r101);

    public abstract int setColorFilter(String r100);

    public abstract int setColorFilterIntensity(float r100);

    public abstract int setEffectNodes(List<String> r100);

    public abstract int setVideoEffectExpressionDetect(VideoEffectExpressionConfig r100);

    public abstract int setVideoEffectTouchEvent(int r100, float r101, float r102, float r103, float r104, EffectTouchType r105, int r106);

    public abstract int updateEffectNode(String r100, String r101, float r102);
}
