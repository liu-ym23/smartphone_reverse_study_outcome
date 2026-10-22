package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        char r103 = r100.charAt(0);
        if ('a' <= r103) goto L11;
    L13:
        if (r101 == false) goto L16;
        StringBuilder r104 = new StringBuilder(r100.length());
        r104.append(Character.toUpperCase(r103));
        r104.append(r100, 1, r100.length());
        return r104.toString();
    L16:
        return r100;
    L11:
        if (r103 >= '{') goto L13;
        r101 = true;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public static final String decapitalizeAsciiOnly(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        char r103 = r100.charAt(0);
        if ('A' <= r103) goto L11;
    L13:
        if (r101 == true) goto L15;
        return r100;
    L15:
        return Character.toLowerCase(r103) + r100.substring(1);
    L11:
        if (r103 >= '[') goto L13;
        r101 = true;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public static final String toLowerCaseAsciiOnly(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder(r100.length());
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        char r104 = r100.charAt(r103);
        if ('A' <= r104) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == false) goto L12;
        r104 = Character.toLowerCase(r104);
    L12:
        r101.append(r104);
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 >= '[') goto L9;
        r105 = true;
        goto L10
    L14:
        return r101.toString();
    }

    public static final String decapitalizeSmartForCompiler(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        if (isUpperCaseCharAt(r100, 0, r101) == true) goto L11;
        return r100;
    L11:
        if (r100.length() != 1) goto L13;
    L28:
        if (r101 == false) goto L31;
        return decapitalizeAsciiOnly(r100);
    L31:
        if (r100.length() <= 0) goto L33;
        boolean r103 = true;
    L34:
        if (r103 == true) goto L36;
        return r100;
    L36:
        return Character.toLowerCase(r100.charAt(0)) + r100.substring(1);
    L33:
        r103 = false;
        goto L34
    L13:
        if (isUpperCaseCharAt(r100, 1, r101) == false) goto L28;
        Iterator<Integer> r104 = StringsKt.getIndices(r100).iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        Integer r105 = r104.next();
        if ((!isUpperCaseCharAt(r100, r105.intValue(), r101)) == false) goto L17;
    L22:
        Integer r106 = r105;
        if (r106 == null) goto L27;
        int r107 = r106.intValue() - 1;
        return toLowerCase(r100.substring(0, r107), r101) + r100.substring(r107);
    L27:
        return toLowerCase(r100, r101);
    L21:
        r105 = null;
        goto L22
    L5:
        r102 = false;
        goto L6
    }

    private static final String toLowerCase(String r100, boolean r101) {
        if (r101 == false) goto L5;
        return toLowerCaseAsciiOnly(r100);
    L5:
        return r100.toLowerCase(Locale.ROOT);
    }

    private static final boolean isUpperCaseCharAt(String r100, int r101, boolean r102) {
        char r103 = r100.charAt(r101);
        if (r102 == false) goto L10;
        if ('A' <= r103) goto L7;
        return false;
    L7:
        if (r103 >= '[') goto L12;
        return true;
    L12:
        return false;
    L10:
        return Character.isUpperCase(r103);
    }
}
