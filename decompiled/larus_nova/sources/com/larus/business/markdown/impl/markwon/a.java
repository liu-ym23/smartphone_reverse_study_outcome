package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.business.markdown.api.model.MarkdownNodeModifyType;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f320591c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f320592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f320593b;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.a$a, reason: collision with other inner class name */
    public static final class C4142a {
    }

    static {
    }

    public a() {
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v14, types: [T, java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.util.Set] */
    public final Set<MarkdownNodeModifyType> c(uvc.b r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        Set<MarkdownNodeModifyType> r100 = null;
        if (this.f320592a == true) goto L5;
        return null;
    L5:
        uvc.b r101 = r110.f551902c;
        if (r101 == null) goto L9;
        r110 = r101;
        goto L5
    L9:
        if ((r110 instanceof Text) == false) goto L81;
        if ((r110.f551900a instanceof Paragraph) == false) goto L81;
        Text r102 = (Text) r110;
        String r103 = r102.f525783h;
        boolean r104 = false;
        boolean r105 = true;
        if (r103 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L81;
        StringBuilder r107 = new StringBuilder(r103);
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        Function1<Character, Unit> r109 = new ASTModifier$modifyLastTextNode$changed$1(r108, this);
        Function1<Character, Boolean> r111 = new ASTModifier$modifyLastTextNode$changed$2(this);
        int r112 = 0;
        boolean r113 = false;
    L23:
        if (r107.length() <= 0) goto L25;
        boolean r114 = true;
    L26:
        if (r114 == false) goto L33;
        if (r112 >= Integer.MAX_VALUE) goto L33;
        char r115 = r107.charAt(r107.length() - 1);
        if (r111.invoke(Character.valueOf(r115)).booleanValue() == false) goto L33;
        r107.delete(r107.length() - 1, r107.length());
        r109.invoke(Character.valueOf(r115));
        r112 = r112 + 1;
        r113 = true;
    L33:
        if (r107.length() != 0) goto L35;
        boolean r116 = true;
    L37:
        if (r116 == true) goto L62;
        char r117 = r107.charAt(r107.length() - 1);
        if (r107.length() != 1) goto L50;
        if (r117 == '-') goto L48;
        if (r117 == '*') goto L48;
        if (r117 == '+') goto L48;
        if (Character.isDigit(r117) == false) goto L62;
    L48:
        StringsKt.clear(r107);
    L61:
        r104 = true;
        goto L62
    L50:
        if (r107.length() > 3) goto L55;
        if (b(r107, r107.length() - 1) == false) goto L55;
        StringsKt.clear(r107);
    L55:
        if (r117 == '.') goto L59;
        if (r117 != ')') goto L62;
    L59:
        if (b(r107, r107.length() - 2) == false) goto L62;
        StringsKt.clear(r107);
    L62:
        if (r104 == false) goto L65;
        r108.element = a((Set) r108.element, MarkdownNodeModifyType.LIST_TOKEN_REMOVED);
        r113 = true;
    L65:
        if (d(r107, '*') == false) goto L68;
        r108.element = a((Set) r108.element, MarkdownNodeModifyType.ASTERISK_TOKEN_REMOVED);
        r113 = true;
    L68:
        if (d(r107, '_') == false) goto L70;
        r108.element = a((Set) r108.element, MarkdownNodeModifyType.UNDERSCORE_TOKEN_REMOVED);
    L71:
        r102.f525783h = r107.toString();
        if (r105 == false) goto L79;
        com.larus.business.markdown.api.depend.d r118 = IMarkdownLoggerKt.a();
        if (r118 == null) goto L76;
        r118.d("ASTModifier", "==>literal_1=" + r103);
    L76:
        com.larus.business.markdown.api.depend.d r119 = IMarkdownLoggerKt.a();
        if (r119 == null) goto L79;
        r119.d("ASTModifier", "==>literal_2=" + r102.f525783h);
    L79:
        r100 = (Set) r108.element;
        goto L81
    L70:
        r105 = r113;
        goto L71
    L35:
        r116 = false;
        goto L37
    L25:
        r114 = false;
        goto L26
    L15:
        if (r103.length() == 0) goto L18;
        r106 = false;
    L81:
        if (this.f320593b == false) goto L91;
        com.larus.business.markdown.api.extplugin.latex.a r120 = ILatexPluginKt.b();
        if (r120 == null) goto L86;
        r120.modifyLatexMathBlockContent(r110, "");
    L86:
        return a(r100, MarkdownNodeModifyType.LATEX_PROCESSING_APPLIED);
    L91:
        return r100;
    }

    public static Set a(Set r100, MarkdownNodeModifyType r101) {
        if (r100 != null) goto L4;
        r100 = new LinkedHashSet();
    L4:
        r100.add(r101);
        return r100;
    }

    public static boolean b(StringBuilder r100, int r101) {
        if (r101 >= r100.length()) goto L15;
        if (r101 < 0) goto L15;
        if (r101 < 0) goto L13;
        int r102 = 0;
    L9:
        if (Character.isDigit(r100.charAt(r102)) == false) goto L10;
        if (r102 == r101) goto L18;
        r102 = r102 + 1;
        goto L9
    L18:
        return true;
    L10:
        return false;
    L13:
        return true;
    L15:
        return false;
    }

    public static boolean d(StringBuilder r100, char r110) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return false;
    L8:
        int r102 = StringsKt.indexOf$default(r100, r110, 0, false, 6, null);
        if (r102 >= 0) goto L11;
        return false;
    L11:
        int r103 = r102 + 1;
    L13:
        if (r103 >= r100.length()) goto L19;
        if (r103 >= (r102 + 3)) goto L19;
        if (r100.charAt(r103) != r110) goto L19;
        r103 = r103 + 1;
    L19:
        r100.delete(r102, r103);
        return true;
    L5:
        r101 = false;
        goto L6
    }
}
