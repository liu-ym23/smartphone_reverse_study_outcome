package com.bytedance.ee.bear.sheet.inputbar.at.segment;

/* JADX INFO: loaded from: classes18.dex */
public class AttachmentSegment extends BaseSegment {
    private String fileToken;
    private String mimeType;
    private int size;
    private String text;

    public AttachmentSegment() {
        super(SegmentType.ATTACHMENT, null);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public AttachmentSegment clone() throws CloneNotSupportedException {
        return (AttachmentSegment) super.clone();
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getSize() {
        return this.size;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public String getText() {
        return this.text;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public /* bridge */ /* synthetic */ BaseSegment clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setSize(int r100) {
        this.size = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }
}
