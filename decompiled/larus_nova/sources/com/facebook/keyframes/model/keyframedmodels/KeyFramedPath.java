package com.facebook.keyframes.model.keyframedmodels;

import com.facebook.keyframes.KFPath;
import com.facebook.keyframes.model.HasKeyFrame;
import com.facebook.keyframes.model.KFFeature;
import com.facebook.keyframes.model.KFFeatureFrame;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFramedPath extends KeyFramedObject<KFFeatureFrame, KFPath> {
    public static KeyFramedPath fromFeature(KFFeature r100) {
        return new KeyFramedPath(r100.getKeyFrames(), r100.getTimingCurves());
    }

    private KeyFramedPath(List<KFFeatureFrame> r100, float[][][] r101) {
        super(r100, r101);
    }

    public void applyImpl(KFFeatureFrame r100, KFFeatureFrame r101, float r102, KFPath r103) {
        if (r101 != null) goto L4;
    L10:
        r100.getShapeData().applyFeature(r103);
        return;
    L4:
        if (r102 == 0.0f) goto L10;
        KFFeatureFrame.ShapeMoveListData r104 = r100.getShapeData();
        KFFeatureFrame.ShapeMoveListData r105 = r101.getShapeData();
        int r106 = r104.getVectorCommands().size();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r104.getVectorCommands().get(r107).interpolate(r105.getVectorCommands().get(r107), r102, r103);
        r107 = r107 + 1;
        goto L7
    }

    @Override // com.facebook.keyframes.model.keyframedmodels.KeyFramedObject
    public /* bridge */ /* synthetic */ void applyImpl(HasKeyFrame r100, HasKeyFrame r101, float r102, KFPath r103) {
        applyImpl((KFFeatureFrame) r100, (KFFeatureFrame) r101, r102, r103);
    }
}
