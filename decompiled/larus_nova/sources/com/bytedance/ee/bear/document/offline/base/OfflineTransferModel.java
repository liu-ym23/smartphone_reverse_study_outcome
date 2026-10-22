package com.bytedance.ee.bear.document.offline.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Serializable;
import k25.m0;
import sbb.e;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class OfflineTransferModel implements Serializable {
    private String category;
    private boolean checkError;
    private Object data;
    private int dataType;
    private String iframeJsbCheck;
    private String key;
    private boolean needSync;
    private String objToken;
    private int type;
    private String uri;

    public String getData() {
        Object r100 = this.data;
        if ((r100 instanceof JSONObject) == false) goto L7;
        String r101 = JSON.toJSONString(r100, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        this.data = r101;
        return r101;
    L7:
        if ((r100 instanceof String) == true) goto L9;
        if (r100 == null) goto L13;
        a.h("OfflineTransferModel", r100.getClass().getSimpleName());
        return this.data.toString();
    L13:
        return null;
    L9:
        return (String) r100;
    }

    public m0 parseResourceData() {
        m0 r100 = new m0();
        r100.f501541b = this.key;
        r100.f501546g = this.needSync;
        r100.f501542c = getData();
        r100.f501550k = this.objToken;
        r100.f501553n = this.uri;
        r100.f501544e = Long.valueOf(System.currentTimeMillis());
        r100.f501561v = this.dataType;
        int r101 = this.type;
        if (r101 != e.f541294e.f541317b) goto L5;
    L7:
        r100.f501559t = this.category;
        return r100;
    L5:
        if (r101 == e.f541295f.f541317b) goto L7;
        r100.f501548i = e.f(r101);
        goto L7
    }

    public String toString() {
        return "OfflineTransferModel{key='" + this.key + "', data='" + this.data + "', needSync=" + this.needSync + ", objToken='" + this.objToken + "', uri='" + this.uri + "', dataType='" + this.dataType + "', type='" + this.type + "', checkError='" + this.checkError + "', category='" + this.category + "', iframeJsbCheck='" + this.iframeJsbCheck + "'}";
    }

    public OfflineTransferModel() {
    }

    public String getCategory() {
        return this.category;
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

    public int getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isCheckError() {
        return this.checkError;
    }

    public boolean isNeedSync() {
        return this.needSync;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setCheckError(boolean r100) {
        this.checkError = r100;
    }

    public void setData(Object r100) {
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

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }
}
