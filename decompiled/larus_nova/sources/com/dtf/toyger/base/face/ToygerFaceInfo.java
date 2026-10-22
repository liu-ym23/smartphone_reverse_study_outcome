package com.dtf.toyger.base.face;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.algorithm.TGFrame;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerFaceInfo extends ToygerBiometricInfo<ToygerFaceAttr> {

    @JSONField(name = NoticeInfo.KEY_PICTURES)
    public List<ToygerPairFaceInfo> pictures;

    @JSONField(name = "videoFrames")
    public List<ToygerPairFaceInfo> videoFrames;

    public ToygerFaceInfo() {
    }

    public ToygerFaceInfo(TGFrame r100, ToygerFaceAttr r101) {
        this.frame = r100;
        this.attr = r101;
    }
}
