package com.bytedance.ee.bear.document.render.core.offline.datapage;

import java.io.Serializable;
import k25.m0;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfflineTransferModelV2 implements Serializable {
    private String batchNumber;
    private String category;
    private String data;
    private int dataType;
    private String iframeJsbCheck;
    private String key;
    private boolean needSync;
    private String objToken;
    private int page;
    private int totalPage;
    private int type;
    private String uri;

    public m0 parseResourceData() {
        m0 r0 = new m0();
        r0.k = this.objToken;
        r0.b = this.key;
        r0.c = this.data;
        r0.t = this.category;
        r0.g = this.needSync;
        r0.n = this.uri;
        r0.e = Long.valueOf(System.currentTimeMillis());
        r0.v = this.dataType;
        int r1 = this.type;
        if (r1 != e.e.b) goto L5;
    L7:
        r0.p = this.page;
        r0.q = this.totalPage;
        r0.r = this.batchNumber;
        return r0;
    L5:
        if (r1 == e.f.b) goto L7;
        r0.i = e.f(r1);
        goto L7
    }

    public String toString() {
        return "OfflineTransferModelV2{key='" + this.key + "', data='" + this.data + "', needSync=" + this.needSync + ", objToken='" + this.objToken + "', uri='" + this.uri + "', dataType='" + this.dataType + "', type='" + this.type + "', page='" + this.page + "', totalPage='" + this.totalPage + "', batchNumber='" + this.batchNumber + "', iframeJsbCheck='" + this.iframeJsbCheck + "'}";
    }

    public OfflineTransferModelV2() {
        this.page = 0;
        this.totalPage = 1;
    }

    public String getBatchNumber() {
        return this.batchNumber;
    }

    public String getCategory() {
        return this.category;
    }

    public String getData() {
        return this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getIframeJsbCheck() {
        return this.iframeJsbCheck;
    }

    public String getKey() {
        return this.key;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isNeedSync() {
        return this.needSync;
    }

    public void setBatchNumber(String r1) {
        this.batchNumber = r1;
    }

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setDataType(int r1) {
        this.dataType = r1;
    }

    public void setIframeJsbCheck(String r1) {
        this.iframeJsbCheck = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setNeedSync(boolean r1) {
        this.needSync = r1;
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setPage(int r1) {
        this.page = r1;
    }

    public void setTotalPage(int r1) {
        this.totalPage = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }
}
