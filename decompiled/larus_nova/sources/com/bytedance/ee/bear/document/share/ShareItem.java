package com.bytedance.ee.bear.document.share;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ShareItem implements BaseJSModel {
    public static final String SHARE_IMAGE = "shareImage";
    private String[] badges;
    private BizInfo bizInfo;
    private String content;
    private String[] disables;
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f221761id;
    private String title;
    private String topic;
    private String url;

    public static class BizInfo implements NonProguard {
        private MoreModel.Bitable bitableProInfo;

        public BizInfo() {
        }

        public MoreModel.Bitable getBitableProInfo() {
            return this.bitableProInfo;
        }

        public void setBitableProInfo(MoreModel.Bitable r100) {
            this.bitableProInfo = r100;
        }
    }

    public List<Integer> getBadgeShareTypes() {
        ArrayList r100 = new ArrayList();
        if (isShareImageNew() == false) goto L5;
        r100.add(Integer.valueOf(ShareType.ExportImage.ordinal()));
    L5:
        return r100;
    }

    public List<Integer> getDisabledShareTypes() {
        ArrayList r100 = new ArrayList();
        if (isShareImageDisabled() == false) goto L5;
        r100.add(Integer.valueOf(ShareType.ExportImage.ordinal()));
    L5:
        return r100;
    }

    public boolean isShareImageDisabled() {
        String[] r100 = this.disables;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.length <= 0) goto L13;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        if (SHARE_IMAGE.equals(r100[r102]) == true) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return true;
    }

    public boolean isShareImageNew() {
        String[] r100 = this.badges;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.length <= 0) goto L13;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        if (SHARE_IMAGE.equals(r100[r102]) == true) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return true;
    }

    public String toString() {
        return "ShareItem{id='" + this.f221761id + "', title='" + this.title + "', url='" + this.url + "', content='" + this.content + "', topic='" + this.topic + "', enable=" + this.enable + ", disables=" + Arrays.deepToString(this.disables) + ", badges=" + Arrays.deepToString(this.badges) + '}';
    }

    public ShareItem() {
        this.enable = true;
    }

    public String[] getBadges() {
        return this.badges;
    }

    public BizInfo getBizInfo() {
        return this.bizInfo;
    }

    public String getContent() {
        return this.content;
    }

    public String[] getDisables() {
        return this.disables;
    }

    public String getId() {
        return this.f221761id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setBadges(String[] r100) {
        this.badges = r100;
    }

    public void setBizInfo(BizInfo r100) {
        this.bizInfo = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setDisables(String[] r100) {
        this.disables = r100;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setId(String r100) {
        this.f221761id = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTopic(String r100) {
        this.topic = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
