package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseSegment implements NonProguard, Cloneable {
    private SegmentStyle style;
    private SegmentType type;

    public abstract String getText();

    public abstract void setText(String r1);

    public BaseSegment clone() throws CloneNotSupportedException {
        BaseSegment r0 = (BaseSegment) super.clone();
        SegmentStyle r1 = this.style;
        if (r1 == null) goto L5;
        r0.style = r1.clone();
    L5:
        return r0;
    }

    public String toString() {
        return getText();
    }

    public BaseSegment() {
    }

    public SegmentStyle getStyle() {
        return this.style;
    }

    public SegmentType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setStyle(SegmentStyle r1) {
        this.style = r1;
    }

    public void setType(SegmentType r1) {
        this.type = r1;
    }

    public BaseSegment(SegmentType r1, SegmentStyle r2) {
        this.type = r1;
        this.style = r2;
    }
}
