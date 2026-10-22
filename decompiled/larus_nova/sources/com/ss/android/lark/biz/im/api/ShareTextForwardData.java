package com.ss.android.lark.biz.im.api;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class ShareTextForwardData implements Serializable {
    private String content;
    private boolean forceStandAlone;
    private boolean localShare;
    private String sourceName;
    private boolean supportAdditionNote;
    private String title;
    private String titleBarText;

    public String getContent() {
        String r100 = this.content;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getSourceName() {
        String r100 = this.sourceName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getTitle() {
        String r100 = this.title;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getTitleBarText() {
        String r100 = this.titleBarText;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.content);
    }

    public boolean isForceStandAlone() {
        return this.forceStandAlone;
    }

    public boolean isLocalShare() {
        return this.localShare;
    }

    public boolean isSupportAdditionNote() {
        return this.supportAdditionNote;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setForceStandAlone(boolean r100) {
        this.forceStandAlone = r100;
    }

    public void setLocalShare(boolean r100) {
        this.localShare = r100;
    }

    public void setSourceName(String r100) {
        this.sourceName = r100;
    }

    public void setSupportAdditionNote(boolean r100) {
        this.supportAdditionNote = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTitleBarText(String r100) {
        this.titleBarText = r100;
    }

    public ShareTextForwardData(String r100, String r101, String r102, boolean r110) {
        this(r100, r101, r102, r110, false);
    }

    public ShareTextForwardData(String r100, String r101, String r110, boolean r111, boolean r112) {
        this(r100, r101, r110, r111, r112, false);
    }

    public ShareTextForwardData(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105) {
        this.title = r100;
        this.content = r101;
        this.sourceName = r102;
        this.localShare = r103;
        this.forceStandAlone = r104;
        this.supportAdditionNote = r105;
    }
}
