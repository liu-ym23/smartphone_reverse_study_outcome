package com.larus.office.base.utils;

import com.bytedance.ee.bear.contract.export.DocumentExportType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361169a = 0;

    /* JADX INFO: renamed from: com.larus.office.base.utils.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4437a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361170a = null;

        static {
            int[] r100 = new int[DocumentExportType.values().length];
            r100[DocumentExportType.WORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[DocumentExportType.PDF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[DocumentExportType.MARKDOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[DocumentExportType.TXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[DocumentExportType.IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[DocumentExportType.JPG_LONG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[DocumentExportType.AUDIO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[DocumentExportType.EXCEL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[DocumentExportType.PPTX.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[DocumentExportType.UNKNOWN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f361170a = r100;
        }
    }

    static {
    }

    public static String a(rw4.c r100) {
        String r101 = r100.f539685e;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        Integer r103 = Integer.valueOf(r100.f539684d);
        if (r103.intValue() != 0) goto L15;
        r102 = false;
    L15:
        if (r102 == true) goto L18;
        r103 = null;
    L18:
        if (r103 != null) goto L20;
        return null;
    L20:
        return r103.toString();
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101;
    }

    public static Integer b(Integer r100) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if (r100.intValue() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return r100;
    L6:
        r101 = false;
        goto L7
    }

    public static String c(DocumentExportType r100) {
        switch(C4437a.f361170a[r100.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return "unknown";
    L7:
        return ExportFileExtension.PPTX;
    L8:
        return "xlsx";
    L9:
        return "audio";
    L10:
        return "jpg_long";
    L11:
        return "image";
    L12:
        return "txt";
    L13:
        return "markdown";
    L14:
        return ExportFileExtension.PDF;
    L15:
        return EffectConfiguration.KEY_SEARCH_WORD;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
