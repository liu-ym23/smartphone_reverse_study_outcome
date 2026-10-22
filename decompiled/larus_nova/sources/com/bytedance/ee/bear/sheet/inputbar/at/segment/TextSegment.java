package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes18.dex */
public class TextSegment extends BaseSegment {
    private String text;

    @JSONField(deserialize = false, serialize = false)
    private transient TextLikeSegment textLikeSegment;

    public TextSegment() {
        super(SegmentType.TEXT, null);
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public TextSegment clone() throws CloneNotSupportedException {
        return (TextSegment) super.clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public String getText() {
        return this.text;
    }

    public TextLikeSegment getTextLikeSegment() {
        return this.textLikeSegment;
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

    public TextSegment(String r100) {
        this();
        this.text = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }

    public void setTextLikeSegment(TextLikeSegment r100) {
        this.textLikeSegment = r100;
    }
}
