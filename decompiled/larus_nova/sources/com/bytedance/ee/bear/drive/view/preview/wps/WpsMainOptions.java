package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class WpsMainOptions implements NonProguard {
    public static final String OPEN_MODE_NORMAL = "normal";
    public static final String OPEN_MODE_SIMPLE = "simple";
    public WpsCommonOptions commonOptions;
    public List<String> disabledCommandBarOptions;
    public r excelOptions;
    public List<String> hiddenCommandBarOptions;
    public String mode;
    public WpsPDFOptions pdfOptions;
    public WpsPPTOptions pptOptions;
    public WpsWordOptions wordOptions;

    @Retention(RetentionPolicy.SOURCE)
    public @interface WpsOpenMode {
    }

    public WpsMainOptions() {
    }
}
