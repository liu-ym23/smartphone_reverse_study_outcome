package com.facebook.keyframes.model.keyframedmodels;

import android.util.SparseArray;
import android.view.animation.Interpolator;
import com.facebook.keyframes.model.HasKeyFrame;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class KeyFramedObject<T extends HasKeyFrame, M> {
    private final int mFirstDescribedFrame;
    private final List<Interpolator> mInterpolators;
    private final int mLastDescribedFrame;
    private final SparseArray<T> mObjects;

    public static float interpolateValue(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    public abstract void applyImpl(T r100, T r101, float r102, M r103);

    public KeyFramedObject() {
        this.mObjects = null;
        this.mInterpolators = null;
        this.mFirstDescribedFrame = 0;
        this.mLastDescribedFrame = 0;
    }

    public KeyFramedObject(List<T> r100, float[][][] r101) {
        int r102 = r100.size();
        this.mObjects = new SparseArray(r102);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        T r104 = r100.get(r103);
        this.mObjects.put(r104.getKeyFrame(), r104);
        r103 = r103 + 1;
        goto L3
    L5:
        this.mFirstDescribedFrame = this.mObjects.keyAt(0);
        this.mLastDescribedFrame = this.mObjects.keyAt(r102 - 1);
        this.mInterpolators = KeyFrameAnimationHelper.buildInterpolatorList(r101);
    }

    public void apply(float r100, M r101) {
        T r102 = null;
        if (this.mInterpolators.isEmpty() == false) goto L5;
    L25:
        applyImpl(this.mObjects.get(this.mFirstDescribedFrame), null, 0.0f, r101);
        return;
    L5:
        if (r100 <= this.mFirstDescribedFrame) goto L25;
        int r103 = this.mLastDescribedFrame;
        if (r100 < r103) goto L11;
        applyImpl(this.mObjects.get(r103), null, 0.0f, r101);
        return;
    L11:
        int r104 = this.mInterpolators.size();
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L22;
        if (this.mObjects.keyAt(r105) == r100) goto L21;
        if (this.mObjects.keyAt(r105) >= r100) goto L20;
        if (this.mObjects.keyAt(r105 + 1) > r100) goto L21;
    L20:
        r105 = r105 + 1;
    L21:
        r102 = this.mObjects.valueAt(r105);
        T r106 = this.mObjects.valueAt(r105 + 1);
    L23:
        applyImpl(r102, r106, this.mInterpolators.get(r105).getInterpolation((r100 - r102.getKeyFrame()) / (r106.getKeyFrame() - r102.getKeyFrame())), r101);
        return;
    L22:
        r106 = null;
        goto L23
    }
}
