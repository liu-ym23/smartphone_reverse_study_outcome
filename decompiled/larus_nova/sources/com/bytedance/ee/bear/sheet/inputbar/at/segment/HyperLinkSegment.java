package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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
        public /* bridge */ /* synthetic */ Object m8329clone() throws CloneNotSupportedException {
            return clone();
        }

        public void setRangeId(String r100) {
            this.rangeId = r100;
        }

        public void setSheetId(String r100) {
            this.sheetId = r100;
        }
    }

    public HyperLinkSegment() {
        super(SegmentType.URL, null, null);
    }

    public String getLink() {
        String r100 = this.link;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.text;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment, com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public HyperLinkSegment clone() throws CloneNotSupportedException {
        HyperLinkSegment r100 = (HyperLinkSegment) super.clone();
        CellPosition r101 = this.cellPosition;
        if (r101 == null) goto L5;
        r100.cellPosition = r101.clone();
    L5:
        return r100;
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
    public /* bridge */ /* synthetic */ Object mo8328clone() throws CloneNotSupportedException {
        return clone();
    }

    public void setCellPosition(CellPosition r100) {
        this.cellPosition = r100;
    }

    public void setLink(String r100) {
        this.link = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment
    public void setText(String r100) {
        this.text = r100;
    }

    public void setVisited(boolean r100) {
        this.visited = r100;
    }
}
