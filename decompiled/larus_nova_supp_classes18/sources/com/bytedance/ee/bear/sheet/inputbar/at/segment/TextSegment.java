package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TextSegment extends BaseSegment {
    private String text;

    @JSONField(deserialize = BaseKeyboardHeightProducer.VISIBLE_FALSE, serialize = BaseKeyboardHeightProducer.VISIBLE_FALSE)
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
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextSegment(String r1) {
        this();
        this.text = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r1) {
        this.text = r1;
    }

    public void setTextLikeSegment(TextLikeSegment r1) {
        this.textLikeSegment = r1;
    }
}
