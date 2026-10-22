package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiHomePageV2 implements NonProguard, Cloneable {

    @SerializedName(ResourceData.KEY_OBJ_TOKEN)
    @JSONField(name = ResourceData.KEY_OBJ_TOKEN)
    public String objToken;

    @SerializedName("obj_type")
    @JSONField(name = "obj_type")
    public int objType;

    @SerializedName("title")
    @JSONField(name = "title")
    public String title;

    @SerializedName(ResourceData.KEY_URL)
    @JSONField(name = ResourceData.KEY_URL)
    public String url;

    @SerializedName("wiki_token")
    @JSONField(name = "wiki_token")
    public String wikiToken;

    public WikiHomePageV2() {
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.wikiToken) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.objToken) == true) goto L9;
        if (this.objType <= 0) goto L9;
        return true;
    }

    public WikiHomePageV2 clone() {
        return (WikiHomePageV2) super.clone();
    L4:
        th = move-exception;
        tt5.a.e("SpaceInfo", "clone WikiHomePageV2 fail. ", th, false);
        return new WikiHomePageV2();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m713clone() throws CloneNotSupportedException {
        return clone();
    }
}
