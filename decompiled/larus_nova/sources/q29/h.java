package q29;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {
    public static final int a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "sequence");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= r100.length()) goto L28;
        Character.UnicodeBlock r103 = Character.UnicodeBlock.of(r100.charAt(r101));
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) == false) goto L11;
    L24:
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        r102 = r102 + 1;
    L27:
        r101 = r101 + 1;
        goto L7
    L11:
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) == true) goto L24;
        if (Intrinsics.areEqual(r103, Character.UnicodeBlock.GENERAL_PUNCTUATION) == true) goto L24;
        r104 = false;
        goto L25
    L28:
        return r102;
    }
}
