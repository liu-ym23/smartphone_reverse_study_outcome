package com.bytedance.ee.bear.drive.view.preview.excel;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class ExcelMeta implements NonProguard {
    private String apiPrefix;
    private int index;
    private String previewExtra;

    public ExcelMeta() {
    }

    public String getApiPrefix() {
        return this.apiPrefix;
    }

    public int getIndex() {
        return this.index;
    }

    public String getPreviewExtra() {
        return this.previewExtra;
    }

    public void setApiPrefix(String r100) {
        this.apiPrefix = r100;
    }

    public void setIndex(int r100) {
        this.index = r100;
    }

    public void setPreviewExtra(String r100) {
        this.previewExtra = r100;
    }
}
