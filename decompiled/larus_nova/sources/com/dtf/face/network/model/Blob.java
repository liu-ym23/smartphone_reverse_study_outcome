package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class Blob {

    @JSONField(name = "blobElem")
    public BlobElem[] blobElem;

    @JSONField(name = "blobVersion")
    public String blobVersion;

    public Blob() {
    }
}
