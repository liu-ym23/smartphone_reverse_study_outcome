package com.bytedance.ee.plugin.common.ttpdfreader;

import android.graphics.RectF;
import android.util.SizeF;

/* JADX INFO: loaded from: classes19.dex */
public class TTReaderSelectionInfo {
    public final int pageIndex;
    public SizeF pageResolution;
    public SizeF pageSize;
    public RectF[] selectedRects;
    public String selectedText;

    public TTReaderSelectionInfo(int r100) {
        this.pageIndex = r100;
    }
}
