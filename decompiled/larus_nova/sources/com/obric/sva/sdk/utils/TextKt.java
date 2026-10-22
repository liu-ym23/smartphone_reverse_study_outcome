package com.obric.sva.sdk.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/obric/sva/sdk/utils/TextKt;", "", "<init>", "()V", "levenshtein", "", "lhs", "", "rhs", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextKt {
    public static final TextKt INSTANCE = null;

    static {
        INSTANCE = new TextKt();
    }

    private TextKt() {
    }

    @JvmStatic
    public static final int levenshtein(CharSequence r110, CharSequence r111) {
        Intrinsics.checkNotNullParameter(r110, "lhs");
        Intrinsics.checkNotNullParameter(r111, "rhs");
        int r100 = r110.length() + 1;
        int r101 = r111.length() + 1;
        Integer[] r102 = new Integer[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = Integer.valueOf(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        Integer[] r104 = new Integer[r100];
        int r105 = 0;
    L6:
        if (r105 >= r100) goto L8;
        r104[r105] = 0;
        r105 = r105 + 1;
        goto L6
    L8:
        int r106 = 1;
    L9:
        if (r106 >= r101) goto L19;
        r104[0] = Integer.valueOf(r106);
        int r107 = 1;
    L11:
        if (r107 >= r100) goto L17;
        int r108 = r107 - 1;
        if (r110.charAt(r108) != r111.charAt(r106 - 1)) goto L15;
        int r109 = 0;
    L16:
        r104[r107] = Integer.valueOf(Math.min(Math.min(r102[r107].intValue() + 1, r104[r108].intValue() + 1), r102[r108].intValue() + r109));
        r107 = r107 + 1;
        goto L11
    L15:
        r109 = 1;
        goto L16
    L17:
        r106 = r106 + 1;
        Integer[] r112 = r104;
        r104 = r102;
        r102 = r112;
        goto L9
    L19:
        return r102[r100 - 1].intValue();
    }
}
