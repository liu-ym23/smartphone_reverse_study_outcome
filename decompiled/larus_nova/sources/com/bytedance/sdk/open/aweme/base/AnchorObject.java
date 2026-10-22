package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class AnchorObject {

    @SerializedName("anchor_icon")
    UrlModel anchorIcon;

    @SerializedName("anchor_business_type")
    int mAnchorBusinessType;

    @SerializedName("anchor_content")
    String mAnchorContent;

    @SerializedName("anchor_title")
    String mAnchorTitle;

    public AnchorObject() {
    }

    public static AnchorObject unserialize(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO);
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return (AnchorObject) GsonProtectorUtils.fromJson(new Gson(), r101, AnchorObject.class);
    }

    public int getAnchorBusinessType() {
        return this.mAnchorBusinessType;
    }

    public String getAnchorContent() {
        return this.mAnchorContent;
    }

    public String getAnchorIconUrl() {
        UrlModel r100 = this.anchorIcon;
        if (r100 == null) goto L11;
        List<String> r101 = r100.urlList;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.isEmpty() == false) goto L10;
        return null;
    L10:
        return (String) ListProtector.get(this.anchorIcon.urlList, 0);
    L11:
        return null;
    }

    public String getAnchorTitle() {
        return this.mAnchorTitle;
    }

    public void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO, GsonProtectorUtils.toJson(new Gson(), this));
    }

    public void setAnchorBusinessType(int r100) {
        this.mAnchorBusinessType = r100;
    }

    public void setAnchorContent(String r100) {
        this.mAnchorContent = r100;
    }

    public void setAnchorIconUrl(String r100) {
        UrlModel r101 = new UrlModel();
        ArrayList r102 = new ArrayList();
        r102.add(r100);
        r101.urlList = r102;
        this.anchorIcon = r101;
    }

    public void setAnchorTitle(String r100) {
        this.mAnchorTitle = r100;
    }
}
