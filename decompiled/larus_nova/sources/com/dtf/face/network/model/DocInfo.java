package com.dtf.face.network.model;

import android.graphics.Rect;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.ugc.effectmanager.EffectConfiguration;

/* JADX INFO: loaded from: classes22.dex */
public class DocInfo {

    @JSONField(name = "docFieldInfo")
    public DocFieldInfo docFieldInfo;

    @JSONField(name = "docType")
    public String docType;

    @JSONField(name = "faceRect")
    public Rect faceRect;

    @JSONField(name = "pageNo")
    public int pageNo;

    @JSONField(name = EffectConfiguration.KEY_REGION)
    public Point[] region;

    public DocInfo() {
    }
}
