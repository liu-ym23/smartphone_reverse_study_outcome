package com.bytedance.ee.bear.sheet.exportimage.exportshare;

import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExportShareModel implements NonProguard {
    public static final String EXPORT_SHARE_TYPE_IMAGE = "image";
    public static final String EXPORT_SHARE_TYPE_TEXT = "text";
    private String[] types;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExportShareType {
    }

    public ExportShareModel() {
    }

    public String[] getTypes() {
        return this.types;
    }

    public void setTypes(String[] r1) {
        this.types = r1;
    }
}
