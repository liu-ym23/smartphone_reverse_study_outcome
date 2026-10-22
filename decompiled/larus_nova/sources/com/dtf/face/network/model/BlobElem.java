package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class BlobElem {

    @JSONField(name = "content")
    public String content;

    @JSONField(name = "docInfo")
    public DocInfo docInfo;

    @JSONField(name = "faceInfos")
    public List<FaceInfo> faceInfos;

    @JSONField(name = "idx")
    public int idx;

    @JSONField(name = "subType")
    public String subType;

    @JSONField(name = "type")
    public String type;

    @JSONField(name = "version")
    public String version;

    public BlobElem() {
    }

    public BlobElem(String r100, String r101, int r102, String r103, String r104, List<FaceInfo> r105) {
        this.type = r100;
        this.subType = r101;
        this.idx = r102;
        this.version = r103;
        this.content = r104;
        this.faceInfos = r105;
    }
}
