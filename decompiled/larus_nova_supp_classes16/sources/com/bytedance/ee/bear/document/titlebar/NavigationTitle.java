package com.bytedance.ee.bear.document.titlebar;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        NavigationTitle r5 = (NavigationTitle) r4;
        if (TextUtils.equals(this.title, r5.title) == true) goto L8;
        return false;
    L8:
        if (this.type == r5.type) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.subTitle, r5.subTitle) == true) goto L12;
        return false;
    L12:
        if (this.displayTitleType != r5.displayTitleType) goto L18;
        return true;
    L18:
        return false;
    }

    public void setDisplayTitleType(int r1) {
        this.displayTitleType = r1;
    }

    public void setDocName(String r1) {
        this.doc_name = r1;
    }

    public void setIcon_info(IconInfo r1) {
        this.icon_info = r1;
    }

    public void setNeedDisplayTag(Boolean r1) {
        this.needDisplayTag = r1;
    }

    public void setSubTitle(String r1) {
        this.subTitle = r1;
    }

    public void setTagValue(String r1) {
        this.tagValue = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
