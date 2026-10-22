package com.bytedance.ee.bear.dto;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setCanAddExtraInfo(boolean r100) {
        this.canAddExtraInfo = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setLocalShare(boolean r100) {
        this.localShare = r100;
    }

    public void setSourceName(String r100) {
        this.sourceName = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public DocShareTextData(String r100, String r101, String r102, boolean r103) {
        this.title = r100;
        this.content = r101;
        this.sourceName = r102;
        this.localShare = r103;
    }
}
