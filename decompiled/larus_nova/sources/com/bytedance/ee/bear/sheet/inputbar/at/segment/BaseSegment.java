package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseSegment implements NonProguard, Cloneable {
    private SegmentStyle style;
    private SegmentType type;

    public abstract String getText();

    public abstract void setText(String r100);

    public BaseSegment clone() throws CloneNotSupportedException {
        BaseSegment r100 = (BaseSegment) super.clone();
        SegmentStyle r101 = this.style;
        if (r101 == null) goto L5;
        r100.style = r101.clone();
    L5:
        return r100;
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
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setStyle(SegmentStyle r100) {
        this.style = r100;
    }

    public void setType(SegmentType r100) {
        this.type = r100;
    }

    public BaseSegment(SegmentType r100, SegmentStyle r101) {
        this.type = r100;
        this.style = r101;
    }
}
