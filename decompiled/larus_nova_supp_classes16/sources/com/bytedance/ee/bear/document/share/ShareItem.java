package com.bytedance.ee.bear.document.share;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShareItem implements BaseJSModel {
    public static final String SHARE_IMAGE = "shareImage";
    private String[] badges;
    private BizInfo bizInfo;
    private String content;
    private String[] disables;
    private boolean enable;
    private String id;
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

        public void setBitableProInfo(MoreModel.Bitable r1) {
            this.bitableProInfo = r1;
        }
    }

    public List<Integer> getBadgeShareTypes() {
        ArrayList r0 = new ArrayList();
        if (isShareImageNew() == false) goto L5;
        r0.add(Integer.valueOf(ShareType.ExportImage.ordinal()));
    L5:
        return r0;
    }

    public List<Integer> getDisabledShareTypes() {
        ArrayList r0 = new ArrayList();
        if (isShareImageDisabled() == false) goto L5;
        r0.add(Integer.valueOf(ShareType.ExportImage.ordinal()));
    L5:
        return r0;
    }

    public boolean isShareImageDisabled() {
        String[] r0 = this.disables;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.length <= 0) goto L13;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (SHARE_IMAGE.equals(r0[r3]) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }

    public boolean isShareImageNew() {
        String[] r0 = this.badges;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.length <= 0) goto L13;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (SHARE_IMAGE.equals(r0[r3]) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }

    public String toString() {
        return "ShareItem{id='" + this.id + "', title='" + this.title + "', url='" + this.url + "', content='" + this.content + "', topic='" + this.topic + "', enable=" + this.enable + ", disables=" + Arrays.deepToString(this.disables) + ", badges=" + Arrays.deepToString(this.badges) + '}';
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
        return this.id;
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

    public void setBadges(String[] r1) {
        this.badges = r1;
    }

    public void setBizInfo(BizInfo r1) {
        this.bizInfo = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setDisables(String[] r1) {
        this.disables = r1;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setTopic(String r1) {
        this.topic = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
