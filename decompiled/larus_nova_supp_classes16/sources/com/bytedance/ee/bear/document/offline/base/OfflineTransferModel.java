package com.bytedance.ee.bear.document.offline.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Serializable;
import k25.m0;
import sbb.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        Object r0 = this.data;
        if ((r0 instanceof JSONObject) == false) goto L7;
        String r1 = JSON.toJSONString(r0, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        this.data = r1;
        return r1;
    L7:
        if ((r0 instanceof String) == true) goto L9;
        if (r0 == null) goto L13;
        a.h("OfflineTransferModel", r0.getClass().getSimpleName());
        return this.data.toString();
    L13:
        return null;
    L9:
        return (String) r0;
    }

    public m0 parseResourceData() {
        m0 r0 = new m0();
        r0.b = this.key;
        r0.g = this.needSync;
        r0.c = getData();
        r0.k = this.objToken;
        r0.n = this.uri;
        r0.e = Long.valueOf(System.currentTimeMillis());
        r0.v = this.dataType;
        int r1 = this.type;
        if (r1 != e.e.b) goto L5;
    L7:
        r0.t = this.category;
        return r0;
    L5:
        if (r1 == e.f.b) goto L7;
        r0.i = e.f(r1);
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

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setCheckError(boolean r1) {
        this.checkError = r1;
    }

    public void setData(Object r1) {
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

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }
}
