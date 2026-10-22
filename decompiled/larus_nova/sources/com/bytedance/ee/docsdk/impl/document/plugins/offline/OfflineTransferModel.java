package com.bytedance.ee.docsdk.impl.document.plugins.offline;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class OfflineTransferModel implements Serializable {

    @SerializedName("category")
    private String category;

    @SerializedName("checkError")
    private boolean checkError;

    @SerializedName("data")
    private Object data;

    @SerializedName("dataType")
    private int dataType;

    @SerializedName("key")
    private String key;

    @SerializedName("needSync")
    private boolean needSync;

    @SerializedName("objToken")
    private String objToken;

    @SerializedName("type")
    private int type;

    @SerializedName("uri")
    private String uri;

    public OfflineTransferModel() {
    }

    public String getData() {
        Object r100 = this.data;
        if ((r100 instanceof JsonObject) == false) goto L7;
        String r101 = r100.toString();
        this.data = r101;
        return r101;
    L7:
        if ((r100 instanceof String) == true) goto L9;
        if (r100 == null) goto L13;
        Log r102 = Log.INSTANCE;
        Log.i("OfflineTransferModel", r100.getClass().getSimpleName());
        return JsonUtils.INSTANCE.toJsonString(this.data);
    L13:
        return null;
    L9:
        return (String) r100;
    }

    public ResourceData parseResourceData() {
        ResourceData r100 = new ResourceData();
        r100.setReskey(this.key);
        r100.setNeedSync(this.needSync);
        r100.setResvalue(getData());
        r100.setObj_token(this.objToken);
        r100.setUrl(this.uri);
        r100.setUpdate_time(Long.valueOf(System.currentTimeMillis()));
        r100.setDataType(this.dataType);
        if (this.type != DocumentType.UNKNOWN.getValue()) goto L5;
    L7:
        r100.setCategory(this.category);
        return r100;
    L5:
        if (this.type == DocumentType.FOLDER.getValue()) goto L7;
        r100.setType(DocumentType.Companion.getDocumentTypeString(this.type));
        goto L7
    }

    public String toString() {
        return "OfflineTransferModel{key='" + this.key + "', data='" + this.data + "', needSync=" + this.needSync + ", objToken='" + this.objToken + "', uri='" + this.uri + "', dataType='" + this.dataType + "', type='" + this.type + "', checkError='" + this.checkError + "', category='" + this.category + "'}";
    }

    public String getCategory() {
        return this.category;
    }

    public int getDataType() {
        return this.dataType;
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
