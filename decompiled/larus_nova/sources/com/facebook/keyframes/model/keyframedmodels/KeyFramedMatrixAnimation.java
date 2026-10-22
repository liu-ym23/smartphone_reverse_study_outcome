package com.facebook.keyframes.model.keyframedmodels;

import android.graphics.Matrix;
import com.facebook.keyframes.model.HasKeyFrame;
import com.facebook.keyframes.model.KFAnimation;
import com.facebook.keyframes.model.KFAnimationFrame;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFramedMatrixAnimation extends KeyFramedObject<KFAnimationFrame, Matrix> {
    private final float[] mAnchor;
    private final KFAnimation.PropertyType mPropertyType;

    /* JADX INFO: renamed from: com.facebook.keyframes.model.keyframedmodels.KeyFramedMatrixAnimation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType = null;

        static {
            int[] r100 = new int[KFAnimation.PropertyType.values().length];
            $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType = r100;
            r100[KFAnimation.PropertyType.ROTATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType[KFAnimation.PropertyType.SCALE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType[KFAnimation.PropertyType.POSITION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType[KFAnimation.PropertyType.X_POSITION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType[KFAnimation.PropertyType.Y_POSITION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static KeyFramedMatrixAnimation fromAnimation(KFAnimation r100) {
        if (r100.getPropertyType().isMatrixBased() == false) goto L7;
        return new KeyFramedMatrixAnimation(r100.getAnimationFrames(), r100.getTimingCurves(), r100.getPropertyType(), r100.getAnchor());
    L7:
        throw new IllegalArgumentException("Cannot create a KeyFramedMatrixAnimation from a non matrix based KFAnimation.");
    }

    private KeyFramedMatrixAnimation(List<KFAnimationFrame> r100, float[][][] r101, KFAnimation.PropertyType r102, float[] r103) {
        super(r100, r101);
        this.mPropertyType = r102;
        if (r103 != null) goto L6;
        r103 = new float[2];
    L6:
        this.mAnchor = r103;
        if (r102 != KFAnimation.PropertyType.POSITION) goto L10;
        r103[0] = r100.get(0).getData()[0];
        r103[1] = r100.get(0).getData()[1];
        return;
    }

    private void applyPosition(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        float r104 = r100.getData()[0];
        float r105 = r101.getData()[0];
        float r106 = r100.getData()[1];
        float r107 = r101.getData()[1];
        r103.postTranslate(KeyFramedObject.interpolateValue(r104, r105, r102) - this.mAnchor[0], KeyFramedObject.interpolateValue(r106, r107, r102) - this.mAnchor[1]);
    }

    private void applyRotation(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r103) {
        float r104 = 0.0f;
        if (r101 != null) goto L12;
        float r105 = r100.getData()[0];
        float[] r106 = this.mAnchor;
        if (r106 == null) goto L7;
        float r107 = r106[0];
    L8:
        if (r106 == null) goto L10;
        r104 = r106[1];
    L10:
        r103.postRotate(r105, r107, r104);
        return;
    L7:
        r107 = 0.0f;
        goto L8
    L12:
        float r108 = KeyFramedObject.interpolateValue(r100.getData()[0], r101.getData()[0], r102);
        float[] r109 = this.mAnchor;
        if (r109 == null) goto L15;
        float r110 = r109[0];
    L16:
        if (r109 == null) goto L18;
        r104 = r109[1];
    L18:
        r103.postRotate(r108, r110, r104);
        return;
    L15:
        r110 = 0.0f;
        goto L16
    }

    private void applyScale(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r110) {
        float r103 = 0.0f;
        if (r101 != null) goto L12;
        float r104 = r100.getData()[0] / 100.0f;
        float r105 = r100.getData()[1] / 100.0f;
        float[] r106 = this.mAnchor;
        if (r106 == null) goto L7;
        float r107 = r106[0];
    L8:
        if (r106 == null) goto L10;
        r103 = r106[1];
    L10:
        r110.postScale(r104, r105, r107, r103);
        return;
    L7:
        r107 = 0.0f;
        goto L8
    L12:
        float r108 = r100.getData()[0];
        float r109 = r101.getData()[0];
        float r111 = r100.getData()[1];
        float r112 = r101.getData()[1];
        float r113 = KeyFramedObject.interpolateValue(r108, r109, r102) / 100.0f;
        float r114 = KeyFramedObject.interpolateValue(r111, r112, r102) / 100.0f;
        float[] r115 = this.mAnchor;
        if (r115 == null) goto L15;
        float r116 = r115[0];
    L16:
        if (r115 == null) goto L18;
        r103 = r115[1];
    L18:
        r110.postScale(r113, r114, r116, r103);
        return;
    L15:
        r116 = 0.0f;
        goto L16
    }

    private void applyXPosition(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r103) {
        if (r101 != null) goto L6;
        r103.postTranslate(r100.getData()[0], 0.0f);
        return;
    L6:
        r103.postTranslate(KeyFramedObject.interpolateValue(r100.getData()[0], r101.getData()[0], r102), 0.0f);
    }

    private void applyYPosition(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r103) {
        if (r101 != null) goto L6;
        r103.postTranslate(0.0f, r100.getData()[0]);
        return;
    L6:
        r103.postTranslate(0.0f, KeyFramedObject.interpolateValue(r100.getData()[0], r101.getData()[0], r102));
    }

    public void applyImpl(KFAnimationFrame r100, KFAnimationFrame r101, float r102, Matrix r103) {
        int r104 = AnonymousClass1.$SwitchMap$com$facebook$keyframes$model$KFAnimation$PropertyType[this.mPropertyType.ordinal()];
        if (r104 != 1) goto L5;
        applyRotation(r100, r101, r102, r103);
        return;
    L5:
        if (r104 != 2) goto L7;
        applyScale(r100, r101, r102, r103);
        return;
    L7:
        if (r104 != 3) goto L9;
        applyPosition(r100, r101, r102, r103);
        return;
    L9:
        if (r104 != 4) goto L11;
        applyXPosition(r100, r101, r102, r103);
        return;
    L11:
        if (r104 != 5) goto L14;
        applyYPosition(r100, r101, r102, r103);
        return;
    L14:
        throw new UnsupportedOperationException("Cannot apply matrix transformation to " + this.mPropertyType);
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void applyImpl(HasKeyFrame r100, HasKeyFrame r101, float r102, Matrix r103) {
        applyImpl((KFAnimationFrame) r100, (KFAnimationFrame) r101, r102, r103);
    }
}
