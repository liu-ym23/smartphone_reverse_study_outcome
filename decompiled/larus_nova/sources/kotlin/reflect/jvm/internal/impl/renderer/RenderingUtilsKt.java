package kotlin.reflect.jvm.internal.impl.renderer;

import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class RenderingUtilsKt {
    public static final String render(Name r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (shouldBeEscaped(r100) == false) goto L6;
        StringBuilder r101 = new StringBuilder();
        r101.append(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER + r100.asString());
        r101.append('`');
        return r101.toString();
    L6:
        return r100.asString();
    }

    public static final String renderFqName(List<Name> r100) {
        Intrinsics.checkNotNullParameter(r100, "pathSegments");
        StringBuilder r101 = new StringBuilder();
        Iterator<Name> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Name r103 = r102.next();
        if (r101.length() <= 0) goto L8;
        r101.append(".");
    L8:
        r101.append(render(r103));
        goto L4
    L10:
        return r101.toString();
    }

    private static final boolean shouldBeEscaped(Name r100) {
        String r101 = r100.asString();
        if (KeywordStringsGenerated.KEYWORDS.contains(r101) == true) goto L30;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L16;
        char r103 = r101.charAt(r102);
        if (Character.isLetterOrDigit(r103) == false) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L14;
        r102 = r102 + 1;
        goto L6
    L14:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        return true;
    L19:
        if (r101.length() != 0) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
        return true;
    L24:
        if (Character.isJavaIdentifierStart(r101.codePointAt(0)) == false) goto L33;
        return false;
    L33:
        return true;
    L21:
        r106 = false;
        goto L22
    L10:
        if (r103 == '_') goto L12;
        r104 = true;
        goto L13
    L16:
        r105 = false;
        goto L17
    L30:
        return true;
    }

    public static final String render(FqNameUnsafe r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return renderFqName(r100.pathSegments());
    }

    public static final boolean typeStringsDifferOnlyInNullability(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lower");
        Intrinsics.checkNotNullParameter(r101, "upper");
        if (Intrinsics.areEqual(r100, StringsKt.replace$default(r101, "?", "", false, 4, null)) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r101, "?", false, 2, null) == false) goto L9;
        if (Intrinsics.areEqual(r100 + '?', r101) == true) goto L10;
    L9:
        if (Intrinsics.areEqual("(" + r100 + ")?", r101) == true) goto L10;
        return false;
    }

    public static final String replacePrefixesInTypeRepresentations(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "lowerRendered");
        Intrinsics.checkNotNullParameter(r101, "lowerPrefix");
        Intrinsics.checkNotNullParameter(r102, "upperRendered");
        Intrinsics.checkNotNullParameter(r103, "upperPrefix");
        Intrinsics.checkNotNullParameter(r104, "foldedPrefix");
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == true) goto L5;
    L13:
        return null;
    L5:
        if (StringsKt.startsWith$default(r102, r103, false, 2, null) == false) goto L13;
        String r105 = r100.substring(r101.length());
        String r106 = r102.substring(r103.length());
        String r107 = r104 + r105;
        if (Intrinsics.areEqual(r105, r106) == false) goto L10;
        return r107;
    L10:
        if (typeStringsDifferOnlyInNullability(r105, r106) == false) goto L13;
        return r107 + '!';
    }
}
