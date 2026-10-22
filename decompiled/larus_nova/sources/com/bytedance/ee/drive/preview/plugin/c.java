package com.bytedance.ee.drive.preview.plugin;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewCategory;
import g85.f;
import i75.h;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f242720a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f242721a = null;

        static {
            int[] r100 = new int[ErrCode.values().length];
            r100[ErrCode.PERMISSION_DENIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[ErrCode.POLICY_DENIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[ErrCode.PERM_ADMIN_CONTROL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[ErrCode.CAC_PREVIEW_CONTROL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[ErrCode.TNS_BLOCK_VIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[ErrCode.DRIVE_FILE_OVER_SIZE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[ErrCode.PRELOAD_SIZE_TOO_LARGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[ErrCode.DRIVE_FILE_ENCRYPTED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[ErrCode.REQUEST_TRANSFORM_FILE_ENCRYPTION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[ErrCode.ENCRYPTION_KEY_NOT_SUPPORT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[ErrCode.ENCRYPTION_KEY_DELETED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f242721a = r100;
        }
    }

    static {
        f242720a = o75.b.a().getMimeTypeManager();
    }

    public static OfficeDrivePreviewCategory a(String r100) {
        if (r100 == null) goto L7;
        String r101 = r100.toLowerCase(Locale.ROOT);
        if (r101 == null) goto L7;
        String r102 = StringsKt.removePrefix(r101, ".");
    L8:
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        if (r102.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L48;
        g85.b r104 = (g85.b) f242720a;
        if (r104.j(r102, null) == false) goto L20;
        return OfficeDrivePreviewCategory.IMAGE;
    L20:
        if (r104.o(r102, null) == false) goto L23;
        return OfficeDrivePreviewCategory.VIDEO;
    L23:
        if (r104.m(r102) == false) goto L26;
        return OfficeDrivePreviewCategory.PDF;
    L26:
        if (h.g(r102) == false) goto L29;
        return OfficeDrivePreviewCategory.DOC;
    L29:
        if (r104.g(r102) == true) goto L47;
        if (r104.f(r102) == true) goto L47;
        if (h.j(r102) == false) goto L37;
        return OfficeDrivePreviewCategory.SLIDES;
    L37:
        if (r104.n(r102) == true) goto L56;
        if (TextUtils.equals(r104.b(r102, null).f480396b, "text/markdown") == true) goto L56;
        if (r104.d(r102) == false) goto L55;
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
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }
}
