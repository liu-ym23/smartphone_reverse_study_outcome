package com.bytedance.ee.docsdk.impl.document.plugins;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BridgeReadyModel implements Serializable {

    @SerializedName(WikiFolderPushPlugin.DATA)
    private String data;

    @SerializedName(ResourceData.KEY_TYPE)
    private String type;

    public String toString() {
        return "BridgeReadyModel{type='" + this.type + "', data='" + this.data + "'}";
    }

    public BridgeReadyModel() {
    }

    public String getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }
}
