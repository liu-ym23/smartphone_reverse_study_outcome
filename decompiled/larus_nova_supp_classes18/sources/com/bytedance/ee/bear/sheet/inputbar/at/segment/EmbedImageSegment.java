package com.bytedance.ee.bear.sheet.inputbar.at.segment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setFileToken(String r1) {
        this.fileToken = r1;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setLink(String r1) {
        this.link = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r1) {
        this.text = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
