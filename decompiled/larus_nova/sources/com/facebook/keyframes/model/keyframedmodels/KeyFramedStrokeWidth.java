package com.facebook.keyframes.model.keyframedmodels;

import com.facebook.keyframes.model.HasKeyFrame;
import com.facebook.keyframes.model.KFAnimation;
import com.facebook.keyframes.model.KFAnimationFrame;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFramedStrokeWidth extends KeyFramedObject<KFAnimationFrame, StrokeWidth> {

    public static class StrokeWidth {
        private float mStrokeWidth;

        public StrokeWidth() {
        }

        public float getStrokeWidth() {
            return Math.abs(this.mStrokeWidth);
        }

        public void adjustScale(float r100) {
            this.mStrokeWidth *= r100;
        }

        public void setStrokeWidth(float r100) {
            this.mStrokeWidth = r100;
        }
    }

    private KeyFramedStrokeWidth() {
    }

    public static KeyFramedStrokeWidth fromAnimation(KFAnimation r100) {
        if (r100.getPropertyType() != KFAnimation.PropertyType.STROKE_WIDTH) goto L7;
        return new KeyFramedStrokeWidth(r100.getAnimationFrames(), r100.getTimingCurves());
    L7:
        throw new IllegalArgumentException("Cannot create a KeyFramedStrokeWidth object from a non STROKE_WIDTH animation.");
    }

    public KeyFramedStrokeWidth(List<KFAnimationFrame> r100, float[][][] r101) {
        super(r100, r101);
    }

    public void applyImpl(KFAnimationFrame r100, KFAnimationFrame r101, float r102, StrokeWidth r103) {
        if (r101 != null) goto L6;
        r103.setStrokeWidth(r100.getData()[0]);
        return;
    L6:
        r103.setStrokeWidth(KeyFramedObject.interpolateValue(r100.getData()[0], r101.getData()[0], r102));
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void applyImpl(HasKeyFrame r100, HasKeyFrame r101, float r102, StrokeWidth r103) {
        applyImpl((KFAnimationFrame) r100, (KFAnimationFrame) r101, r102, r103);
    }
}
