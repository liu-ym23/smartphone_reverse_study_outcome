package com.bytedance.ee.plugin.common.pdftron.wrapper;

/* JADX INFO: loaded from: classes19.dex */
public class PendingHighlightInfo {
    Annot mHighlight;
    String mSelectedText;

    public PendingHighlightInfo() {
    }

    public Annot getHighlight() {
        return this.mHighlight;
    }

    public String getSelectedText() {
        return this.mSelectedText;
    }

    public void setHighlight(Annot r100) {
        this.mHighlight = r100;
    }

    public void setSelectedText(String r100) {
        this.mSelectedText = r100;
    }

    public PendingHighlightInfo(Annot r100, String r101) {
        this.mHighlight = r100;
        this.mSelectedText = r101;
    }
}
