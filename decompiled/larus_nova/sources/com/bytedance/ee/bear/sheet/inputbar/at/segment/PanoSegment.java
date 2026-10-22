package com.bytedance.ee.bear.sheet.inputbar.at.segment;

/* JADX INFO: loaded from: classes18.dex */
public class PanoSegment extends BaseSegment {
    private String entityId;
    private String link;
    private String text;

    public PanoSegment() {
        super(SegmentType.PANO, null);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public PanoSegment clone() throws CloneNotSupportedException {
        return (PanoSegment) super.clone();
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getLink() {
        return this.link;
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
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setEntityId(String r100) {
        this.entityId = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }
}
