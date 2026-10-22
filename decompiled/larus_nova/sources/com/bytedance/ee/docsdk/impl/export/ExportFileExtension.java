package com.bytedance.ee.docsdk.impl.export;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportFileExtension;", "", "()V", "PDF", "", "PPTX", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExportFileExtension {
    public static final ExportFileExtension INSTANCE = null;
    public static final String PDF = "pdf";
    public static final String PPTX = "pptx";

    static {
        INSTANCE = new ExportFileExtension();
    }

    private ExportFileExtension() {
    }
}
