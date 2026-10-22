package com.larus.office.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f363626a = null;

    static {
        f363626a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new c());
    }

    public static ContentResolver b() {
        return (ContentResolver) f363626a.getValue();
    }

    public static String c(String r110) {
        if (r110 != null) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        return null;
    L7:
        int r100 = (int) Math.max(StringsKt.lastIndexOf$default(r110, '/', 0, false, 6, null), StringsKt.lastIndexOf$default(r110, '\\', 0, false, 6, null));
        if (r100 < 0) goto L11;
        return r110.substring(r100 + 1);
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
