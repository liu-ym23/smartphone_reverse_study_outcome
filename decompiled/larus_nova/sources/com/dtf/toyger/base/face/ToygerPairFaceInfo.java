package com.dtf.toyger.base.face;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerPairFaceInfo {

    @JSONField(name = "faceInfos")
    public List<ToygerFaceInfo> faceInfos;

    @JSONField(name = "key")
    public String key;

    public ToygerPairFaceInfo() {
    }

    public ToygerPairFaceInfo(String r100, List<ToygerFaceInfo> r101) {
        this.key = r100;
        this.faceInfos = r101;
    }
}
