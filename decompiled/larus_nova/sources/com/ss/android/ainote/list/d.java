package com.ss.android.ainote.list;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f407071a = 0;

    static {
    }

    public static String a(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        if (r100.f564908m != AINoteContentState.USE) goto L17;
        String r101 = r100.f564902g;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (StringsKt.isBlank(r101) == false) goto L24;
        if (f(r100) == true) goto L25;
        String r102 = r100.f564900e;
        if (r102 != null) goto L23;
        return "";
    L23:
        return r102;
    L25:
        return "";
    L24:
        return r101;
    L17:
        if (f(r100) == true) goto L27;
        r102 = r100.f564900e;
        if (r102 != null) goto L23;
        return "";
    L27:
        return "";
    }

    public static RichText b(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        if (r100.f564908m != AINoteContentState.USE) goto L11;
        RichText r101 = r100.f564901f;
        if (r101 == null) goto L7;
        return r101;
    L7:
        if (f(r100) == false) goto L16;
    L12:
        return null;
    L16:
        return r100.f564899d;
    L11:
        if (f(r100) == true) goto L12;
        return r100.f564899d;
    }

    public static boolean c(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        if ((!StringsKt.isBlank(a(r100))) == false) goto L6;
        return true;
    L6:
        return d(b(r100));
    }

    public static boolean d(RichText r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        List<String> r102 = r100.getElementIds();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        return true;
    L14:
        List<String> r104 = r100.getImageIds();
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        return true;
    L23:
        List<String> r106 = r100.getAtIds();
        if (r106 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == true) goto L32;
        return true;
    L32:
        List<String> r108 = r100.getAnchorIds();
        if (r108 != null) goto L35;
    L38:
        boolean r109 = true;
    L39:
        if (r109 == true) goto L41;
        return true;
    L41:
        List<String> r110 = r100.getMediaIds();
        if (r110 != null) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == true) goto L50;
        return true;
    L50:
        List<String> r112 = r100.getDocsIds();
        if (r112 != null) goto L53;
    L56:
        boolean r113 = true;
    L57:
        if (r113 == true) goto L59;
        return true;
    L59:
        RichText.RichTextElements r114 = r100.getElements();
        if (r114 == null) goto L62;
        Map<String, RichTextElement> r115 = r114.getDictionary();
    L63:
        if (r115 != null) goto L65;
    L66:
        r101 = true;
    L68:
        return !r101;
    L65:
        if (r115.isEmpty() == false) goto L68;
    L62:
        r115 = null;
        goto L63
    L53:
        if (r112.isEmpty() == true) goto L56;
        r113 = false;
        goto L57
    L44:
        if (r110.isEmpty() == true) goto L47;
        r111 = false;
        goto L48
    L35:
        if (r108.isEmpty() == true) goto L38;
        r109 = false;
        goto L39
    L26:
        if (r106.isEmpty() == true) goto L29;
        r107 = false;
        goto L30
    L17:
        if (r104.isEmpty() == true) goto L20;
        r105 = false;
        goto L21
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public static boolean e(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        AINoteType r101 = r100.f564904i;
        if (r101 != AINoteType.FISH_BONE_TEXT) goto L5;
    L10:
        return true;
    L5:
        if (r101 == AINoteType.FISH_BONE_CHART) goto L10;
        if (r100.f564898c == AINoteCreateSource.AI_VISION_HIGHLIGHT) goto L10;
        return false;
    }

    public static boolean f(xra.a r100) {
        if (e(r100) == false) goto L5;
        return false;
    L5:
        AINoteType r101 = r100.f564904i;
        if (r101 != AINoteType.SUBTITLE) goto L9;
        return true;
    L9:
        if (r101.isMark() == true) goto L11;
        return false;
    L11:
        if (r100.f564904i.needsPolish() == true) goto L13;
        return false;
    L13:
        if (r100.f564908m == AINoteContentState.USE) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean h(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "note");
        if (e(r100) == false) goto L6;
        return false;
    L6:
        if (r100.f564904i.isMark() == true) goto L8;
        return false;
    L8:
        if (r100.f564904i.needsPolish() == false) goto L18;
        AINoteContentState r101 = r100.f564908m;
        if (r101 != AINoteContentState.NEED) goto L13;
    L14:
        return true;
    L13:
        if (r101 == AINoteContentState.FINISH) goto L14;
        return false;
    L18:
        return false;
    }

    public static boolean g(xra.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "note");
        if (e(r100) == false) goto L5;
        return false;
    L5:
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r100.f564904i.isMark() == true) goto L10;
        return false;
    L10:
        if (r100.f564904i.needsPolish() == false) goto L20;
        AINoteContentState r102 = r100.f564908m;
        if (r102 != AINoteContentState.NEED) goto L15;
    L16:
        return true;
    L15:
        if (r102 == AINoteContentState.FINISH) goto L16;
        return false;
    L20:
        return false;
    }
}
