package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes24.dex */
public class OpenPlatform$Requests$OnActivityResult extends LKBaseRequestModel {
    public static final String INTENT_DATA = "intentData";

    @JSONField(name = "requestCode")
    public int mRequestCode;

    @JSONField(name = "resultCode")
    public int mResultCode;

    public OpenPlatform$Requests$OnActivityResult() {
    }
}
