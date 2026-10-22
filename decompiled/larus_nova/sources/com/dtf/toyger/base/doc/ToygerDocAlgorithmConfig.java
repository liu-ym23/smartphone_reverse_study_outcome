package com.dtf.toyger.base.doc;

import android.graphics.Rect;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import faceverify.p;
import faceverify.q;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerDocAlgorithmConfig extends p {

    @JSONField(name = "algoType")
    public int algoType;

    @JSONField(name = "blur")
    public int blur;

    @JSONField(name = "card_detect_score")
    public int card_detect_score;

    @JSONField(name = "exposure")
    public int exposure;

    @JSONField(name = "frameRect")
    public Rect frameRect;

    @JSONField(name = q.KEY_ROTATE_TIMES)
    public int rotateTimes;

    public ToygerDocAlgorithmConfig() {
        this.algoType = 1;
        this.exposure = 20;
        this.blur = 80;
        this.card_detect_score = 100;
    }

    public static String ToygerDocAlgorithmConfigUpdate(String r100) {
        if (r100.equals("true") == false) goto L6;
        FaceDataFrameInfo.getmInstance().dataUpdated = true;
    L6:
        return r100.concat(",ToygerDocAlgorithmConfigUpdate!");
    }

    public static ToygerDocAlgorithmConfig from(String r100) {
        return (ToygerDocAlgorithmConfig) JSON.parseObject(r100, ToygerDocAlgorithmConfig.class);
    }
}
