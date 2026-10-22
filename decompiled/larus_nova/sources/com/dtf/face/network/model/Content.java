package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class Content {

    @JSONField(name = "blob")
    public Blob blob;

    @JSONField(name = "meta")
    public Meta meta;

    public Content() {
    }

    public Content(Meta r100, Blob r101) {
        this.meta = r100;
        this.blob = r101;
    }
}
