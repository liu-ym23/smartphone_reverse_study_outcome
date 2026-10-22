package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes18.dex */
public class ShareListPuller$Params implements NonProguard {

    @SerializedName("request_length")
    public int requestLength;

    public ShareListPuller$Params(int r100) {
        this.requestLength = r100;
    }
}
