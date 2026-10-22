package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f309503a = null;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f309504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f309505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f309506c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309504a, r101.f309504a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309505b, r101.f309505b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f309506c, r101.f309506c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f309504a.hashCode() * 31) + this.f309505b.hashCode()) * 31) + this.f309506c.hashCode();
        }

        public final String toString() {
            return "ResolvedLocalFile(uri=" + this.f309504a + ", fileName=" + this.f309505b + ", mimeTypes=" + this.f309506c + ')';
        }

        public b(Uri r100, String r101, List<String> r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r102, "mimeTypes");
            this.f309504a = r100;
            this.f309505b = r101;
            this.f309506c = r102;
        }
    }

    public i() {
    }

    static {
        f309503a = SetsKt.setOf(new String[]{"json", "md", "xml"});
    }

    public static b b(Context r100, Uri r101, String r102) {
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r103 = null;
        if (StringsKt.isBlank(r102) == false) goto L38;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L29
        Cursor r105 = a(r100.getContentResolver(), r101, new String[]{"_display_name"}, null, null);     // Catch: Throwable -> L29
        if (r105 == null) goto L26;
        Cursor r106 = r105;     // Catch: Throwable -> L29
        Cursor r107 = r106;     // Catch: Throwable -> L21
        if (r107.moveToFirst() == false) goto L18;
        int r108 = r107.getColumnIndex("_display_name");     // Catch: Throwable -> L21
        if (r108 < 0) goto L18;
        String r109 = r107.getString(r108);     // Catch: Throwable -> L21
    L19:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L29
    L27:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r110) == false) goto L34;
        r110 = null;
    L34:
        r102 = (String) r110;
        if (r102 != null) goto L38;
        r102 = "";
        goto L38
    L18:
        r109 = null;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        r109 = null;
    L29:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L38:
        if (StringsKt.isBlank(r102) == false) goto L42;
        r102 = r101.getLastPathSegment();
        if (r102 != null) goto L42;
        r102 = "";
    L42:
        String r112 = StringsKt.substringAfterLast(r102, '.', "").toLowerCase(Locale.ROOT);
        ArrayList r113 = new ArrayList();
        if (Intrinsics.areEqual(r112, "json") == false) goto L45;
        String r114 = "application/json";
    L46:
        if (r114 == null) goto L49;
        r113.add(r114);
    L49:
        if (Intrinsics.areEqual(r101.getScheme(), "content") == false) goto L70;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L52
        Object r116 = Result.m9449constructorimpl(r100.getContentResolver().getType(r101));     // Catch: Throwable -> L52
    L55:
        if (Result.m9455isFailureimpl(r116) == false) goto L57;
        r116 = null;
    L57:
        String r117 = (String) r116;
        if (r117 == null) goto L70;
        boolean r118 = true;
        if ((!StringsKt.isBlank(r117)) == true) goto L62;
    L64:
        r118 = false;
    L65:
        if (r118 == false) goto L67;
        r103 = r117;
    L67:
        if (r103 == null) goto L70;
        r113.add(r103);
        goto L70
    L62:
        if (Intrinsics.areEqual(r117, "*/*") == true) goto L64;
    L52:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L70:
        if (f309503a.contains(r112) == false) goto L73;
        r113.add("text/plain");
    L73:
        return new b(r101, r102, CollectionsKt.distinct(r113));
    L45:
        r114 = FileMimeTypeUtils.c(r112);
        goto L46
    }

    public static Uri c(Context r100, File r101, String r102) {
        Object r103 = null;
        if (r101.isFile() == true) goto L15;
        return null;
    L15:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(FileProvider.getUriForFile(r100, r100.getPackageName() + r102, r101));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r105) == true) goto L14;
        r103 = r105;
    L14:
        return (Uri) r103;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
