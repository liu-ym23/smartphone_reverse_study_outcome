package com.ss.android.lark.audio.voiceinput;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409206a = 0;

    static {
    }

    public static boolean c(RichText r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        List<String> r101 = r100.getElementIds();
        if (r101 == null) goto L17;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L17;
        RichText.RichTextElements r103 = r100.getElements();
        if (r103 == null) goto L17;
        Map<String, RichTextElement> r104 = r103.getDictionary();
        if (r104 == null) goto L17;
        return d(r104, r102);
    L17:
        return false;
    }

    public static final String a(Map<String, RichTextElement> r100, List<String> r101) {
        int r102 = r101.size() - 1;
        if (r102 < 0) goto L34;
    L4:
        int r103 = r102 - 1;
        String r104 = (String) ListProtector.get(r101, r102);
        RichTextElement r105 = r100.get(r104);
        if (r105 == null) goto L31;
        boolean r106 = true;
        if (r105.getTag() != RichTextElement.RichTextTag.AT) goto L21;
        RichTextElement.AtProperty r107 = (RichTextElement.AtProperty) r105.getProperty();
        if (r107 == null) goto L12;
        String r108 = r107.getContent();
    L13:
        if (r108 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == true) goto L21;
        return r104;
    L15:
        if (r108.length() == 0) goto L18;
        r109 = false;
        goto L19
    L12:
        r108 = null;
    L21:
        List<String> r110 = r105.getChildIds();
        List<String> r111 = r110;
        if (r111 != null) goto L24;
    L27:
        if (r106 == true) goto L31;
        String r112 = a(r100, r110);
        if (r112 == null) goto L31;
        return r112;
    L24:
        if (r111.isEmpty() == true) goto L27;
        r106 = false;
    L31:
        if (r103 < 0) goto L34;
        r102 = r103;
    L34:
        return null;
    }

    public static final String b(Map<String, RichTextElement> r100, List<String> r101) {
        int r102 = r101.size() - 1;
        if (r102 < 0) goto L34;
    L4:
        int r103 = r102 - 1;
        String r104 = (String) ListProtector.get(r101, r102);
        RichTextElement r105 = r100.get(r104);
        if (r105 == null) goto L31;
        boolean r106 = true;
        if (r105.getTag() != RichTextElement.RichTextTag.TEXT) goto L21;
        RichTextElement.TextProperty r107 = (RichTextElement.TextProperty) r105.getProperty();
        if (r107 == null) goto L12;
        String r108 = r107.getContent();
    L13:
        if (r108 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == true) goto L21;
        return r104;
    L15:
        if (r108.length() == 0) goto L18;
        r109 = false;
        goto L19
    L12:
        r108 = null;
    L21:
        List<String> r110 = r105.getChildIds();
        List<String> r111 = r110;
        if (r111 != null) goto L24;
    L27:
        if (r106 == true) goto L31;
        String r112 = b(r100, r110);
        if (r112 == null) goto L31;
        return r112;
    L24:
        if (r111.isEmpty() == true) goto L27;
        r106 = false;
    L31:
        if (r103 < 0) goto L34;
        r102 = r103;
    L34:
        return null;
    }

    public static final boolean d(Map<String, RichTextElement> r100, String r101) {
        RichTextElement r102 = r100.get(r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        RichTextElement.RichTextTag r103 = r102.getTag();
        if (r103 != RichTextElement.RichTextTag.UL) goto L8;
        return true;
    L8:
        if (r103 != RichTextElement.RichTextTag.OL) goto L10;
        return true;
    L10:
        if (r103 != RichTextElement.RichTextTag.LI) goto L13;
        return true;
    L13:
        if (r103 != RichTextElement.RichTextTag.PARAGRAPH) goto L15;
    L22:
        List<String> r104 = r102.getChildIds();
        if (r104 == null) goto L29;
        String r105 = (String) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L29;
        return d(r100, r105);
    L29:
        return false;
    L15:
        if (r103 == RichTextElement.RichTextTag.DIV) goto L22;
        if (r103 == RichTextElement.RichTextTag.TEXTABLEAREA) goto L22;
        if (r103 == RichTextElement.RichTextTag.QUOTE) goto L22;
        return false;
    }
}
