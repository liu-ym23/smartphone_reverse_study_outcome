package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TopCloudDocumentListPuller$Params implements NonProguard {

    @SerializedName("filter_folder")
    public boolean filterFolder;

    public TopCloudDocumentListPuller$Params(boolean r1) {
        this.filterFolder = r1;
    }
}
