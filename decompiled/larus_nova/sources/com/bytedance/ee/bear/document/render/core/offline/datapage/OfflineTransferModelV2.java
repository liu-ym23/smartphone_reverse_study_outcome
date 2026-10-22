package com.bytedance.ee.bear.document.render.core.offline.datapage;

import java.io.Serializable;
import k25.m0;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
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
        m0 r100 = new m0();
        r100.f501550k = this.objToken;
        r100.f501541b = this.key;
        r100.f501542c = this.data;
        r100.f501559t = this.category;
        r100.f501546g = this.needSync;
        r100.f501553n = this.uri;
        r100.f501544e = Long.valueOf(System.currentTimeMillis());
        r100.f501561v = this.dataType;
        int r101 = this.type;
        if (r101 != e.f541294e.f541317b) goto L5;
    L7:
        r100.f501555p = this.page;
        r100.f501556q = this.totalPage;
        r100.f501557r = this.batchNumber;
        return r100;
    L5:
        if (r101 == e.f541295f.f541317b) goto L7;
        r100.f501548i = e.f(r101);
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

    public void setBatchNumber(String r100) {
        this.batchNumber = r100;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setDataType(int r100) {
        this.dataType = r100;
    }

    public void setIframeJsbCheck(String r100) {
        this.iframeJsbCheck = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setNeedSync(boolean r100) {
        this.needSync = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setPage(int r100) {
        this.page = r100;
    }

    public void setTotalPage(int r100) {
        this.totalPage = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }
}
