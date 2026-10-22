package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public abstract class TextLikeSegment extends BaseSegment {
    private List<TextSegment> texts;

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public TextLikeSegment clone() throws CloneNotSupportedException {
        return (TextLikeSegment) super.clone();
    }

    public TextLikeSegment() {
    }

    public List<TextSegment> getTexts() {
        return this.texts;
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

    public void setTexts(List<TextSegment> r100) {
        this.texts = r100;
    }

    public TextLikeSegment(SegmentType r100, SegmentStyle r101, List<TextSegment> r102) {
        super(r100, r101);
        this.texts = r102;
    }
}
