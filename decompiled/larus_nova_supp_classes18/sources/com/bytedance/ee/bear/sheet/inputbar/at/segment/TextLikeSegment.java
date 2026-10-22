package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setTexts(List<TextSegment> r1) {
        this.texts = r1;
    }

    public TextLikeSegment(SegmentType r1, SegmentStyle r2, List<TextSegment> r3) {
        super(r1, r2);
        this.texts = r3;
    }
}
