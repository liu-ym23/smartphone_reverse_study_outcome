package com.bytedance.ee.drive.preview.plugin;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewCategory;
import g85.f;
import i75.h;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final f a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            r0[ErrCode.PERMISSION_DENIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[ErrCode.POLICY_DENIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[ErrCode.PERM_ADMIN_CONTROL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[ErrCode.CAC_PREVIEW_CONTROL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[ErrCode.TNS_BLOCK_VIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[ErrCode.DRIVE_FILE_OVER_SIZE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[ErrCode.PRELOAD_SIZE_TOO_LARGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[ErrCode.DRIVE_FILE_ENCRYPTED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[ErrCode.ENCRYPTION_KEY_NOT_SUPPORT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[ErrCode.ENCRYPTION_KEY_DELETED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    static {
        a = o75.b.a().getMimeTypeManager();
    }

    public static OfficeDrivePreviewCategory a(String r3) {
        if (r3 == null) goto L7;
        String r4 = r3.toLowerCase(Locale.ROOT);
        if (r4 == null) goto L7;
        String r5 = StringsKt.removePrefix(r4, ".");
    L8:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        if (r5.length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L48;
        g85.b r2 = (g85.b) a;
        if (r2.j(r5, null) == false) goto L20;
        return OfficeDrivePreviewCategory.IMAGE;
    L20:
        if (r2.o(r5, null) == false) goto L23;
        return OfficeDrivePreviewCategory.VIDEO;
    L23:
        if (r2.m(r5) == false) goto L26;
        return OfficeDrivePreviewCategory.PDF;
    L26:
        if (h.g(r5) == false) goto L29;
        return OfficeDrivePreviewCategory.DOC;
    L29:
        if (r2.g(r5) == true) goto L47;
        if (r2.f(r5) == true) goto L47;
        if (h.j(r5) == false) goto L37;
        return OfficeDrivePreviewCategory.SLIDES;
    L37:
        if (r2.n(r5) == true) goto L56;
        if (TextUtils.equals(r2.b(r5, null).b, "text/markdown") == true) goto L56;
        if (r2.d(r5) == false) goto L55;
        return OfficeDrivePreviewCategory.ARCHIVE;
    L55:
        return OfficeDrivePreviewCategory.UNKNOWN;
    L56:
        return OfficeDrivePreviewCategory.TEXT;
    L47:
        return OfficeDrivePreviewCategory.SHEET;
    L48:
        return OfficeDrivePreviewCategory.UNKNOWN;
    L13:
        r1 = false;
    L7:
        r5 = null;
        goto L8
    }
}
