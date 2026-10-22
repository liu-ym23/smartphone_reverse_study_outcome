package com.bytedance.ee.android.file.picker.lib.v2.util;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        String r102 = r100.toLowerCase(Locale.ROOT);
        switch(r102.hashCode()) {
            case 99640: goto L27;
            case 110834: goto L23;
            case 111220: goto L19;
            case 118783: goto L15;
            case 3088960: goto L12;
            case 3447940: goto L9;
            case 3682393: goto L6;
            default: goto L35;
        };
    L35:
        return r101;
    L6:
        if (r102.equals("xlsx") == false) goto L36;
    L17:
        return "excel";
    L36:
        return r101;
    L9:
        if (r102.equals(ExportFileExtension.PPTX) == true) goto L33;
        return r101;
    L33:
        return "ppt";
    L12:
        if (r102.equals(DocumentType.DOCX_NAME) == false) goto L31;
    L29:
        return EffectConfiguration.KEY_SEARCH_WORD;
    L31:
        return r101;
    L15:
        if (r102.equals("xls") == true) goto L17;
        return r101;
    L19:
        if (r102.equals("ppt") == true) goto L33;
        return r101;
    L23:
        if (r102.equals(ExportFileExtension.PDF) == true) goto L34;
        return r101;
    L34:
        return ExportFileExtension.PDF;
    L27:
        if (r102.equals("doc") == true) goto L29;
        return r101;
    }
}
