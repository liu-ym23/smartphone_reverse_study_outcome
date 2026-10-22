package com.bytedance.ee.bear.drive.view.preview.excel;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setApiPrefix(String r1) {
        this.apiPrefix = r1;
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    public void setPreviewExtra(String r1) {
        this.previewExtra = r1;
    }
}
