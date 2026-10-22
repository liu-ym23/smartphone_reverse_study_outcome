package com.facebook.keyframes.model.keyframedmodels;

import android.graphics.Matrix;
import com.facebook.keyframes.model.HasKeyFrame;
import com.facebook.keyframes.model.KFAnimation;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFramedAnchorPoint extends KeyFramedObject<HasKeyFrame, Matrix> {
    public final float anchorX;
    public final float anchorY;

    public static KeyFramedAnchorPoint fromAnchorPoint(KFAnimation r100) {
        float[] r101 = r100.getAnimationFrames().get(0).getData();
        return new KeyFramedAnchorPoint(r101[0], r101[1]);
    }

    public void apply(Matrix r100) {
        r100.postTranslate(-this.anchorX, -this.anchorY);
    }

    private KeyFramedAnchorPoint(float r100, float r101) {
        this.anchorX = r100;
        this.anchorY = r101;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public void apply2(float r100, Matrix r101) {
        throw new NoSuchMethodError("Anchor point currently has no keyframing ability");
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void apply(float r100, Matrix r101) {
        apply2(r100, r101);
    }

    /* JADX INFO: renamed from: applyImpl, reason: avoid collision after fix types in other method */
    public void applyImpl2(HasKeyFrame r100, HasKeyFrame r101, float r102, Matrix r103) {
        throw new NoSuchMethodError("Anchor point currently has no keyframing ability");
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void applyImpl(HasKeyFrame r100, HasKeyFrame r101, float r102, Matrix r103) {
        applyImpl2(r100, r101, r102, r103);
    }
}
