package com.bytedance.ee.docsdk.impl.document.plugins.offline;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfflineTransferModel implements Serializable {

    @SerializedName(ResourceData.KEY_CATEGORY)
    private String category;

    @SerializedName("checkError")
    private boolean checkError;

    @SerializedName(WikiFolderPushPlugin.DATA)
    private Object data;

    @SerializedName("dataType")
    private int dataType;

    @SerializedName("key")
    private String key;

    @SerializedName("needSync")
    private boolean needSync;

    @SerializedName("objToken")
    private String objToken;

    @SerializedName(ResourceData.KEY_TYPE)
    private int type;

    @SerializedName("uri")
    private String uri;

    public OfflineTransferModel() {
    }

    public String getData() {
        Object r0 = this.data;
        if ((r0 instanceof JsonObject) == false) goto L7;
        String r1 = r0.toString();
        this.data = r1;
        return r1;
    L7:
        if ((r0 instanceof String) == true) goto L9;
        if (r0 == null) goto L13;
        Log r2 = Log.INSTANCE;
        Log.i("OfflineTransferModel", r0.getClass().getSimpleName());
        return JsonUtils.INSTANCE.toJsonString(this.data);
    L13:
        return null;
    L9:
        return (String) r0;
    }

    public ResourceData parseResourceData() {
        ResourceData r0 = new ResourceData();
        r0.setReskey(this.key);
        r0.setNeedSync(this.needSync);
        r0.setResvalue(getData());
        r0.setObj_token(this.objToken);
        r0.setUrl(this.uri);
        r0.setUpdate_time(Long.valueOf(System.currentTimeMillis()));
        r0.setDataType(this.dataType);
        if (this.type != DocumentType.UNKNOWN.getValue()) goto L5;
    L7:
        r0.setCategory(this.category);
        return r0;
    L5:
        if (this.type == DocumentType.FOLDER.getValue()) goto L7;
        r0.setType(DocumentType.Companion.getDocumentTypeString(this.type));
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
