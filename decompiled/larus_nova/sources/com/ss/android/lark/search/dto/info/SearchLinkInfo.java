package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.export.entity.preview.UDIcon;

/* JADX INFO: loaded from: classes38.dex */
public class SearchLinkInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 1889066940445165094L;
    private String chatId;
    private long createTime;
    private String fromName;
    private ImageSet imageSet;
    private String originalUrl;
    private int position;
    private String previewToken;
    private String threadId;
    private int threadPosition;
    private UDIcon udIcon;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "link";
    }

    public SearchLinkInfo() {
        this.type = 13;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFromName() {
        return this.fromName;
    }

    public ImageSet getImageSet() {
        return this.imageSet;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPreviewToken() {
        return this.previewToken;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    public UDIcon getUDIcon() {
        return this.udIcon;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setFromName(String r100) {
        this.fromName = r100;
    }

    public void setImageSet(ImageSet r100) {
        this.imageSet = r100;
    }

    public void setOriginalUrl(String r100) {
        this.originalUrl = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setPreviewToken(String r100) {
        this.previewToken = r100;
    }

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadPosition(int r100) {
        this.threadPosition = r100;
    }

    public void setUDIcon(UDIcon r100) {
        this.udIcon = r100;
    }
}
