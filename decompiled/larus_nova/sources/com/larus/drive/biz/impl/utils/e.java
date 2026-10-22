package com.larus.drive.biz.impl.utils;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f341259a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341260a = null;

        static {
            int[] r100 = new int[DriveFileType.values().length];
            r100[DriveFileType.AI_SHEET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[DriveFileType.AI_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[DriveFileType.PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[DriveFileType.DOC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[DriveFileType.XLS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[DriveFileType.IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[DriveFileType.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[DriveFileType.VIDEO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[DriveFileType.CODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[DriveFileType.ZIP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[DriveFileType.FOLDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f341260a = r100;
        }
    }

    static {
        f341259a = "other";
    }

    public static String a(com.larus.drive.biz.api.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        int r101 = a.f341260a[r100.f341031d.ordinal()];
        if (r101 != 1) goto L5;
        return "aisheet";
    L5:
        if (r101 != 2) goto L7;
        return "aippt_new";
    L7:
        if (r101 != 3) goto L9;
        return "aidoc";
    L9:
        if (r101 == 12) goto L17;
        int r102 = StringsKt.lastIndexOf$default(r100.f341030c, '.', 0, false, 6, null);
        if (r102 > 0) goto L13;
    L15:
        String r103 = "";
    L22:
        return r103.toLowerCase(Locale.ROOT);
    L13:
        if (r102 >= (r100.f341030c.length() - 1)) goto L15;
        r103 = r100.f341030c.substring(r102 + 1);
        goto L22
    L17:
        return DocumentType.FOLDER_NAME;
    }

    public static String b(DriveFileItem r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        DriveFileType r101 = r100.f341573j;
        int r102 = a.f341260a[r101.ordinal()];
        if (r102 != 1) goto L5;
        return "aisheet";
    L5:
        if (r102 != 2) goto L7;
        return "aippt_new";
    L7:
        if (r102 != 3) goto L9;
        return "aidoc";
    L9:
        if (r102 != 12) goto L16;
        return DocumentType.FOLDER_NAME;
    L16:
        return r100.d(false).toLowerCase(Locale.ROOT);
    }

    public static String c(DriveFileType r100) {
        Intrinsics.checkNotNullParameter(r100, "fileType");
        switch(a.f341260a[r100.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return "other_file";
    L5:
        return DocumentType.FOLDER_NAME;
    L6:
        return "zip";
    L7:
        return "code";
    L8:
        return "media";
    L9:
        return "image";
    L10:
        return DocumentType.SHEET_NAME;
    L11:
        return "writing_doc";
    L12:
        return "ppt";
    L13:
        return "aidoc";
    L14:
        return "aippt_new";
    L15:
        return "aisheet";
    }
}
