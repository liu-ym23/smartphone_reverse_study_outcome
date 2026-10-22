package com.ss.android.lark.richtextmd;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class RichTextBISUUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f439556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f439557b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f439558c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f439559d = null;

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f439556a = LazyKt.lazy(r100, RichTextBISUUtils$boldValue$2.INSTANCE);
        f439557b = LazyKt.lazy(r100, RichTextBISUUtils$italicValue$2.INSTANCE);
        f439558c = LazyKt.lazy(r100, RichTextBISUUtils$strikeThroughValue$2.INSTANCE);
        f439559d = LazyKt.lazy(r100, RichTextBISUUtils$underlineValue$2.INSTANCE);
    }

    public static boolean a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
        Object r101 = r100.get("fontWeight");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(StringsKt.trim(r102).toString(), (String) f439556a.getValue()) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static boolean b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
        Object r101 = r100.get("fontStyle");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(StringsKt.trim(r102).toString(), (String) f439557b.getValue()) == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static boolean c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
        Object r101 = r100.get("-lark-textDecoration");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L16:
        return false;
    L14:
        if (StringsKt.contains$default(StringsKt.trim(r102).toString(), (String) f439558c.getValue(), false, 2, null) == false) goto L16;
        return true;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static boolean d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "styles");
        Object r101 = r100.get("-lark-textDecoration");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L16:
        return false;
    L14:
        if (StringsKt.contains$default(StringsKt.trim(r102).toString(), (String) f439559d.getValue(), false, 2, null) == false) goto L16;
        return true;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static void e(Map r110, RichTextElement r111) {
        Intrinsics.checkNotNullParameter(r111, "childElement");
        if (r110 != null) goto L5;
        return;
    L5:
        Map<String, String> r100 = r111.getStyle();
        if (r100 != null) goto L8;
        r100 = new LinkedHashMap();
    L8:
        boolean r101 = a(r110);
        boolean r102 = b(r110);
        boolean r103 = c(r110);
        boolean r112 = d(r110);
        if (r101 == false) goto L11;
        r100.put("fontWeight", (String) f439556a.getValue());
    L11:
        if (r102 == false) goto L13;
        r100.put("fontStyle", (String) f439557b.getValue());
    L13:
        String r104 = r100.get("-lark-textDecoration");
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        Set r105 = CollectionsKt.toMutableSet(StringsKt.split$default(r104, new String[]{" "}, false, 0, 6, null));
        if (r103 == false) goto L19;
        r105.add((String) f439558c.getValue());
    L19:
        if (r112 == false) goto L21;
        r105.add((String) f439559d.getValue());
    L21:
        String r113 = CollectionsKt.joinToString$default(r105, " ", null, null, 0, null, null, 62, null);
        if (r113.length() <= 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L27;
        r100.put("-lark-textDecoration", r113);
    L27:
        r111.setStyle(r100);
        return;
    L24:
        r106 = false;
        goto L25
    }
}
