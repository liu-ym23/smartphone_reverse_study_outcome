package com.ss.android.lark.widget.richtext.utils;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f448390a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448391a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[RichTextElement.RichTextTag.IMG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[RichTextElement.RichTextTag.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f448391a = r100;
        }
    }

    static {
    }

    public static String c(RichText r100) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        StringBuilder r101 = new StringBuilder();
        List<String> r102 = r100.getElementIds();
        RichText.RichTextElements r103 = r100.getElements();
        if (r103 == null) goto L6;
        Map<String, RichTextElement> r104 = r103.getDictionary();
        if (r104 == null) goto L6;
    L7:
        Iterator<String> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L14;
        String r106 = r105.next();
        RichTextElement r107 = r104.get(r106);
        if (r107 == null) goto L9;
        Intrinsics.checkNotNull(r106);
        a(r106, r107, r104, "", true, r101);
        goto L9
    L14:
        return r101.toString();
    L6:
        r104 = MapsKt.emptyMap();
        goto L7
    }

    public static String d(String r100, RichTextElement r101, boolean r102) {
        RichTextElement.RichTextTag r103 = r101.getTag();
        if (r103 != null) goto L5;
        int r104 = -1;
    L6:
        boolean r105 = true;
        if (r104 != 1) goto L9;
        String r106 = "[Text](" + r100 + ')';
        if (r102 == false) goto L32;
        r106 = r106 + ":{" + ((RichTextElement.TextProperty) r101.getProperty()).getContent() + '}';
    L32:
        StringBuilder r107 = new StringBuilder();
        r107.append(r106);
        Map<String, String> r108 = r101.getStyle();
        if (r108 != null) goto L35;
    L38:
        boolean r109 = true;
    L39:
        if (r109 == true) goto L58;
        StringBuilder r110 = new StringBuilder();
        if (RichTextBISUUtils.a(r108) == false) goto L45;
        r110.append("B");
    L45:
        if (RichTextBISUUtils.b(r108) == false) goto L48;
        r110.append("I");
    L48:
        if (RichTextBISUUtils.d(r108) == false) goto L51;
        r110.append(ExifInterface.LATITUDE_SOUTH);
    L51:
        if (RichTextBISUUtils.c(r108) == false) goto L54;
        r110.append("U");
    L54:
        if (r110.length() == 0) goto L57;
        r105 = false;
    L57:
        if (r105 == true) goto L58;
        String r111 = "(" + r110 + ')';
    L60:
        r107.append(r111);
        return r107.toString();
    L58:
        r111 = "";
        goto L60
    L35:
        if (r108.isEmpty() == true) goto L38;
        r109 = false;
        goto L39
    L9:
        if (r104 != 2) goto L11;
        r106 = "[AT](" + r100 + ')';
        if (r102 == false) goto L32;
        r106 = r106 + ":{" + ((RichTextElement.AtProperty) r101.getProperty()).getUserId() + '}';
        goto L32
    L11:
        if (r104 != 3) goto L13;
        r106 = "[IMG](" + r100 + ')';
        if (r102 == false) goto L32;
        r106 = r106 + ":{" + ((RichTextElement.ImageProperty) r101.getProperty()).getToken() + '}';
        goto L32
    L13:
        if (r104 != 4) goto L15;
        r106 = "[MEDIA](" + r100 + ')';
        if (r102 == false) goto L32;
        r106 = r106 + ":{" + ((RichTextElement.MediaProperty) r101.getProperty()).getKey() + '}';
        goto L32
    L15:
        if (r104 == 5) goto L17;
        r106 = "[" + r101.getTag().name() + "](" + r100 + ')';
        goto L32
    L17:
        r106 = "[Anchor](" + r100 + ')';
        if (r102 == false) goto L32;
        r106 = r106 + ":{" + ((RichTextElement.AnchorProperty) r101.getProperty()).getHref() + '}';
        goto L32
    L5:
        r104 = a.f448391a[r103.ordinal()];
        goto L6
    }

    public static void b(String r100, RichTextElement r101, Map r102, List r103, String r104) {
        boolean r105 = true;
        String r106 = r104 + "->" + d(r100, r101, true);
        List<String> r107 = r101.getChildIds();
        List<String> r108 = r107;
        if (r108 != null) goto L5;
    L8:
        if (r105 == true) goto L15;
        Iterator<T> r109 = r107.iterator();
    L11:
        if (r109.hasNext() == false) goto L22;
        String r110 = (String) r109.next();
        RichTextElement r111 = (RichTextElement) r102.get(r110);
        if (r111 == null) goto L11;
        Intrinsics.checkNotNull(r110);
        b(r110, r111, r102, r103, r106);
        goto L11
    L22:
        return;
    L15:
        ((ArrayList) r103).add(r106);
        return;
    L5:
        if (r108.isEmpty() == true) goto L8;
        r105 = false;
        goto L8
    }

    public static void a(String r100, RichTextElement r101, Map r102, String r110, boolean r111, StringBuilder r112) {
        StringBuilder r103 = new StringBuilder("\n");
        r103.append(r110);
        if (r111 == false) goto L5;
        String r104 = "└── ";
    L6:
        r103.append(r104);
        r103.append(d(r100, r101, false));
        r112.append(r103.toString());
        List<String> r105 = r101.getChildIds();
        if (r105 == null) goto L18;
        Iterator<String> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L24;
        String r107 = r106.next();
        RichTextElement r108 = (RichTextElement) r102.get(r107);
        if (r108 == null) goto L10;
        Intrinsics.checkNotNull(r107);
        StringBuilder r109 = new StringBuilder();
        r109.append(r110);
        if (r111 == false) goto L16;
        String r113 = LineContent.FOUR_SPACE;
    L17:
        r109.append(r113);
        a(r107, r108, r102, r109.toString(), Intrinsics.areEqual(CollectionsKt.last(r105), r107), r112);
        goto L10
    L16:
        r113 = "│   ";
        goto L17
    L24:
        return;
    L18:
        return;
    L5:
        r104 = "├── ";
        goto L6
    }
}
