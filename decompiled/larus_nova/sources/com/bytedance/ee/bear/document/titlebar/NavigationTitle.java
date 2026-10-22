package com.bytedance.ee.bear.document.titlebar;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class NavigationTitle implements NonProguard {
    private int displayTitleType;
    private String doc_name;
    private IconInfo icon_info;

    @JSONField(name = "need_display_tag")
    private Boolean needDisplayTag;
    private String subTitle;

    @JSONField(name = "tagValue")
    private String tagValue;
    private String title;
    private int type;

    public boolean isDefaultTitle() {
        if (this.type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "NavigationTitle{title='" + this.title + "', needDisplayTag=" + this.needDisplayTag + ", tagValue='" + this.tagValue + "', icon_info=" + this.icon_info + ", displayTitleType=" + this.displayTitleType + ", subTitle='" + this.subTitle + "'}";
    }

    public NavigationTitle() {
    }

    public int getDisplayTitleType() {
        return this.displayTitleType;
    }

    public String getDocName() {
        return this.doc_name;
    }

    public IconInfo getIcon_info() {
        return this.icon_info;
    }

    public Boolean getNeedDisplayTag() {
        return this.needDisplayTag;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTagValue() {
        return this.tagValue;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        NavigationTitle r101 = (NavigationTitle) r100;
        if (TextUtils.equals(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.subTitle, r101.subTitle) == true) goto L12;
        return false;
    L12:
        if (this.displayTitleType != r101.displayTitleType) goto L18;
        return true;
    L18:
        return false;
    }

    public void setDisplayTitleType(int r100) {
        this.displayTitleType = r100;
    }

    public void setDocName(String r100) {
        this.doc_name = r100;
    }

    public void setIcon_info(IconInfo r100) {
        this.icon_info = r100;
    }

    public void setNeedDisplayTag(Boolean r100) {
        this.needDisplayTag = r100;
    }

    public void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public void setTagValue(String r100) {
        this.tagValue = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
