package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HyperLinkSegment extends TextLikeSegment {
    private CellPosition cellPosition;
    private String link;
    private String text;
    private boolean visited;

    public static class CellPosition implements NonProguard, Cloneable {
        private String rangeId;
        private String sheetId;

        public CellPosition() {
        }

        public CellPosition clone() throws CloneNotSupportedException {
            return (CellPosition) super.clone();
        }

        public String getRangeId() {
            return this.rangeId;
        }

        public String getSheetId() {
            return this.sheetId;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m523clone() throws CloneNotSupportedException {
            return clone();
        }

        public void setRangeId(String r1) {
            this.rangeId = r1;
        }

        public void setSheetId(String r1) {
            this.sheetId = r1;
        }
    }

    public HyperLinkSegment() {
        super(SegmentType.URL, null, null);
    }

    public String getLink() {
        String r0 = this.link;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.text;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment, com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public HyperLinkSegment clone() throws CloneNotSupportedException {
        HyperLinkSegment r0 = (HyperLinkSegment) super.clone();
        CellPosition r1 = this.cellPosition;
        if (r1 == null) goto L5;
        r0.cellPosition = r1.clone();
    L5:
        return r0;
    }

    public CellPosition getCellPosition() {
        return this.cellPosition;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public String getText() {
        return this.text;
    }

    public boolean isVisited() {
        return this.visited;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment, com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public /* bridge */ /* synthetic */ BaseSegment clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment, com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public /* bridge */ /* synthetic */ TextLikeSegment clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment, com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo522clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setCellPosition(CellPosition r1) {
        this.cellPosition = r1;
    }

    public void setLink(String r1) {
        this.link = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r1) {
        this.text = r1;
    }

    public void setVisited(boolean r1) {
        this.visited = r1;
    }
}
