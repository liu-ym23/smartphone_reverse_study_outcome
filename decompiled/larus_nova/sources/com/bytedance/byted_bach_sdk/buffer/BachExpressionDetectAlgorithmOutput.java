package com.bytedance.byted_bach_sdk.buffer;

import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: classes8.dex */
public class BachExpressionDetectAlgorithmOutput extends BachAlgorithmOutput {
    public Vector<SingleExpressionDetectResult> expressionDetectResults;

    public BachExpressionDetectAlgorithmOutput(HashMap<String, BachObject>[] r110) {
        this.expressionDetectResults = new Vector();
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L20;
        HashMap<String, BachObject> r102 = r110[r101];
        SingleExpressionDetectResult r103 = new SingleExpressionDetectResult();
        r103.ID = (int) r102.get("id").valueResult.int64Val;
        r103.age = (float) r102.get("age").valueResult.doubleVal;
        r103.boy_prob = (float) r102.get("boy_prob").valueResult.doubleVal;
        if (r102.get("gender").valueResult.int64Val >= 0) goto L8;
        r103.gender = SingleExpressionDetectResult.FaceGender.UNKNOWN;
    L12:
        r103.attractive = (float) r102.get("attractive").valueResult.doubleVal;
        r103.happy_score = (float) r102.get("happy_score").valueResult.doubleVal;
        if (r102.get("exp_type").valueResult.int64Val >= 0) goto L15;
        r103.exp_type = SingleExpressionDetectResult.FaceExpression.UNKNOWN;
    L16:
        Vector<Float> r104 = new Vector();
        double[] r105 = r102.get("exp_probs").valueResult.vecFVal;
        int r106 = r105.length;
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L19;
        r104.add(Float.valueOf((float) r105[r107]));
        r107 = r107 + 1;
        goto L17
    L19:
        r103.exp_probs = r104;
        r103.real_face_prob = (float) r102.get("real_face_prob").valueResult.doubleVal;
        r103.quality = (float) r102.get(GearStrategyConsts.EV_QUALITY).valueResult.doubleVal;
        this.expressionDetectResults.add(r103);
        r101 = r101 + 1;
        goto L3
    L15:
        r103.exp_type = SingleExpressionDetectResult.FaceExpression.values()[(int) r102.get("exp_type").valueResult.int64Val];
        goto L16
    L8:
        if (r102.get("gender").valueResult.int64Val != 1) goto L10;
        SingleExpressionDetectResult.FaceGender r108 = SingleExpressionDetectResult.FaceGender.MALE;
    L11:
        r103.gender = r108;
        goto L12
    L10:
        r108 = SingleExpressionDetectResult.FaceGender.FEMALE;
        goto L11
    }
}
