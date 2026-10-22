package com.bytedance.ee.bear.drive.core.fragment;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f224217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g85.f f224218b = null;

    public j() {
    }

    static {
        f224217a = new j();
        f224218b = o75.b.a().getMimeTypeManager();
    }

    public static String a(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L12:
        if ((true ^ r104) == true) goto L19;
        r102 = r102 + 1;
        goto L3
    L19:
        return r103;
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
        goto L12
    L15:
        return null;
    }

    public static boolean b(MimeTypeCategory r100) {
        if (r100 != MimeTypeCategory.IMAGE) goto L5;
    L8:
        return true;
    L5:
        if (r100 == MimeTypeCategory.VIDEO) goto L8;
        return false;
    }

    public static String c(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return StringsKt.trimStart(StringsKt.trim(r100).toString(), new char[]{'.'}).toLowerCase(Locale.ROOT);
    }

    public static MimeTypeCategory d(BaseOpenEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        String r101 = r100.getFileExt();
        String r102 = "";
        String r103 = null;
        if (r101 != null) goto L5;
    L9:
        String r104 = r100.getFileName();
        if (r104 == null) goto L12;
        r103 = StringsKt.substringAfterLast(r104, '.', "");
    L12:
        if (r103 != null) goto L14;
        r101 = "";
    L15:
        String r105 = c(r101);
        String r106 = r100.getMimeType();
        if (r106 == null) goto L20;
        r102 = r106;
    L20:
        return e(r105, StringsKt.trim(r102).toString().toLowerCase(Locale.ROOT));
    L14:
        r101 = r103;
        goto L15
    L5:
        if (StringsKt.isBlank(r101) == false) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L15;
        goto L9
    }

    public static MimeTypeCategory e(String r100, String r101) {
        if (StringsKt.isBlank(r100) == true) goto L5;
    L8:
        MimeTypeCategory r102 = ((g85.b) f224218b).b(r100, r101).f480395a;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return MimeTypeCategory.NONE;
    L5:
        if (StringsKt.isBlank(r101) == false) goto L8;
        return null;
    }
}
