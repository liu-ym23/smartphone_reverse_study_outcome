package com.bytedance.sdk.open.douyin.model;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.tt.b;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class ContactHtmlObject {

    @SerializedName("discription")
    private String mDiscription;

    @SerializedName("html")
    private String mHtml;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("thumburl")
    private String thumbUrl;

    public ContactHtmlObject() {
    }

    public static ContactHtmlObject unserialize(Bundle r100) {
        String r101 = r100.getString(b.a.f269778b, "");
        if (r101 != null) goto L9;
        return null;
    L9:
        return (ContactHtmlObject) new Gson().fromJson(r101, ContactHtmlObject.class);
    L8:
        return null;
    }

    public String getDiscription() {
        return this.mDiscription;
    }

    public String getHtml() {
        return this.mHtml;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putSerializable(b.a.f269778b, GsonProtectorUtils.toJson(new Gson(), this));
    }

    public void setDiscription(String r100) {
        this.mDiscription = r100;
    }

    public void setHtml(String r100) {
        this.mHtml = r100;
    }

    public void setThumbUrl(String r100) {
        this.thumbUrl = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }
}
