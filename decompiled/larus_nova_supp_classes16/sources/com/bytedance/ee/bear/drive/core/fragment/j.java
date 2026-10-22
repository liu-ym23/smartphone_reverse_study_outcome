package com.bytedance.ee.bear.drive.core.fragment;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final j a = null;
    public static final g85.f b = null;

    public j() {
    }

    static {
        a = new j();
        b = o75.b.a().getMimeTypeManager();
    }

    public static String a(String... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        String r3 = r6[r2];
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L12:
        if ((true ^ r5) == true) goto L19;
        r2 = r2 + 1;
        goto L3
    L19:
        return r3;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r5 = false;
        goto L12
    L15:
        return null;
    }

    public static boolean b(MimeTypeCategory r1) {
        if (r1 != MimeTypeCategory.IMAGE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == MimeTypeCategory.VIDEO) goto L8;
        return false;
    }

    public static String c(String r3) {
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        return StringsKt.trimStart(StringsKt.trim(r3).toString(), new char[]{'.'}).toLowerCase(Locale.ROOT);
    }

    public static MimeTypeCategory d(BaseOpenEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        String r0 = r4.getFileExt();
        String r1 = "";
        String r2 = null;
        if (r0 != null) goto L5;
    L9:
        String r3 = r4.getFileName();
        if (r3 == null) goto L12;
        r2 = StringsKt.substringAfterLast(r3, '.', "");
    L12:
        if (r2 != null) goto L14;
        r0 = "";
    L15:
        String r5 = c(r0);
        String r6 = r4.getMimeType();
        if (r6 == null) goto L20;
        r1 = r6;
    L20:
        return e(r5, StringsKt.trim(r1).toString().toLowerCase(Locale.ROOT));
    L14:
        r0 = r2;
        goto L15
    L5:
        if (StringsKt.isBlank(r0) == false) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L15;
        goto L9
    }

    public static MimeTypeCategory e(String r1, String r2) {
        if (StringsKt.isBlank(r1) == true) goto L5;
    L8:
        MimeTypeCategory r3 = ((g85.b) b).b(r1, r2).a;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return MimeTypeCategory.NONE;
    L5:
        if (StringsKt.isBlank(r2) == false) goto L8;
        return null;
    }
}
