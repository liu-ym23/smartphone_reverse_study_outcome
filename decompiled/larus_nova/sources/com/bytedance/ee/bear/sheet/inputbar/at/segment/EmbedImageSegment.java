package com.bytedance.ee.bear.sheet.inputbar.at.segment;

/* JADX INFO: loaded from: classes18.dex */
public class EmbedImageSegment extends BaseSegment {
    private String fileToken;
    private int height;
    private String link;
    private String text;
    private int width;

    public EmbedImageSegment() {
        super(SegmentType.EMBED_IMAGE, null);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public EmbedImageSegment clone() throws CloneNotSupportedException {
        return (EmbedImageSegment) super.clone();
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public int getHeight() {
        return this.height;
    }

    public String getLink() {
        return this.link;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public String getText() {
        return this.text;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public /* bridge */ /* synthetic */ BaseSegment clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
