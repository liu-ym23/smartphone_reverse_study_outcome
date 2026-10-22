package com.obric.miniapp.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Base64;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f398472a = null;

    static {
        f398472a = new e1();
    }

    public e1() {
    }

    public static Drawable a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rawPath");
        List r102 = CollectionsKt.distinct(CollectionsKt.listOf(new String[]{StringsKt.trim(r101).toString(), StringsKt.removePrefix(StringsKt.trim(r101).toString(), "file:///android_asset/"), StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r101).toString(), "@assets/"), "assets/"), StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r101).toString(), "@drawable/"), "drawable/")}));
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L19;
        String r105 = (String) r104.next();
        f398472a.getClass();
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L11;
    L17:
        List r107 = CollectionsKt.listOf(r105);
    L18:
        CollectionsKt.addAll(r103, r107);
        goto L4
    L11:
        if (StringsKt.endsWith(r105, ".svg", true) == false) goto L17;
        String r108 = new Regex("\\.svg$", RegexOption.IGNORE_CASE).replace(r105, "_dark.svg");
        if (Intrinsics.areEqual(r108, r105) == false) goto L16;
        r107 = CollectionsKt.listOf(r105);
        goto L18
    L16:
        r107 = CollectionsKt.listOf(new String[]{r108, r105});
        goto L18
    L8:
        r106 = false;
        goto L9
    L19:
        Iterator r109 = CollectionsKt.distinct(r103).iterator();
    L20:
        BitmapDrawable r110 = null;
        Object r111 = null;
        if (r109.hasNext() == false) goto L40;
        String r112 = (String) r109.next();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        InputStream r114 = r100.getAssets().open(r112);     // Catch: Throwable -> L32
        o0 r115 = f1.a(SVG.d(r114), r100);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r114, null);     // Catch: Throwable -> L32
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r116) == true) goto L38;
        r111 = r116;
    L38:
        r110 = (BitmapDrawable) r111;
        if (r110 == null) goto L20;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        return r110;
    }

    public static Drawable b(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "rawValue");
        boolean r100 = true;
        String r112 = StringsKt.trimStart(StringsKt.trim(r111).toString(), new char[]{65279});
        Object r113 = null;
        if (StringsKt.isBlank(r112) == false) goto L6;
    L56:
        r112 = null;
    L57:
        if (r112 != null) goto L73;
        return null;
    L73:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L61
        Object r114 = Result.m9449constructorimpl(f1.a(new SVGParser().g(new ByteArrayInputStream(r112.getBytes())), r110));     // Catch: Throwable -> L61
    L64:
        if (Result.m9455isFailureimpl(r114) == true) goto L68;
        r113 = r114;
    L68:
        return (Drawable) r113;
    L61:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L6:
        if (StringsKt.startsWith(r112, "<svg", true) == true) goto L57;
        if (StringsKt.startsWith(r112, "<?xml", true) == false) goto L14;
        if (StringsKt.contains(r112, "<svg", true) == true) goto L57;
    L14:
        if (StringsKt.startsWith(r112, fyb.a.KEY_DATA, true) == false) goto L56;
        int r102 = StringsKt.indexOf$default(r112, ',', 0, false, 6, null);
        if (r102 <= 5) goto L56;
        String r103 = r112.substring(5, r102);
        if (StringsKt.contains(r103, "image/svg+xml", true) == false) goto L56;
        String r116 = r112.substring(r102 + 1);
        if (StringsKt.contains(r103, ";base64", true) == true) goto L71;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L34
        Object r117 = Result.m9449constructorimpl(Uri.decode(r116));     // Catch: Throwable -> L34
    L37:
        if (Result.m9455isFailureimpl(r117) == false) goto L39;
        r117 = null;
    L39:
        String r118 = (String) r117;
    L40:
        if (r118 == null) goto L44;
        String r119 = StringsKt.trim(r118).toString();
        if (r119 == null) goto L44;
        r112 = StringsKt.trimStart(r119, new char[]{65279});
    L45:
        if (r112 == null) goto L56;
        if (StringsKt.startsWith(r112, "<svg", true) == false) goto L49;
    L54:
        if (r100 == false) goto L56;
    L49:
        if (StringsKt.startsWith(r112, "<?xml", true) == true) goto L51;
    L53:
        r100 = false;
        goto L54
    L51:
        if (StringsKt.contains(r112, "<svg", true) == false) goto L53;
    L44:
        r112 = null;
    L34:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L71:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L26
        Object r120 = Result.m9449constructorimpl(new String(Base64.decode(r116, 0), Charsets.UTF_8));     // Catch: Throwable -> L26
    L29:
        if (Result.m9455isFailureimpl(r120) == false) goto L31;
        r120 = null;
    L31:
        r118 = (String) r120;
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
