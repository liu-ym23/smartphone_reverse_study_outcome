package com.bytedance.ee.bear.dto;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocShareTextData implements Serializable {
    private boolean canAddExtraInfo;
    private String content;
    private boolean localShare;
    private String sourceName;
    private String title;

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content);
    }

    public String getContent() {
        return this.content;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCanAddExtraInfo() {
        return this.canAddExtraInfo;
    }

    public boolean isLocalShare() {
        return this.localShare;
    }

    public void setCanAddExtraInfo(boolean r1) {
        this.canAddExtraInfo = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setLocalShare(boolean r1) {
        this.localShare = r1;
    }

    public void setSourceName(String r1) {
        this.sourceName = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public DocShareTextData(String r1, String r2, String r3, boolean r4) {
        this.title = r1;
        this.content = r2;
        this.sourceName = r3;
        this.localShare = r4;
    }
}
