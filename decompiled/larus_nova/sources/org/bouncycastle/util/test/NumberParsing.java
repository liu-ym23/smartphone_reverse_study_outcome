package org.bouncycastle.util.test;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes42.dex */
public final class NumberParsing {
    private NumberParsing() {
    }

    public static int decodeIntFromHex(String r100) {
        if (r100.charAt(1) == 'x') goto L10;
        if (r100.charAt(1) == 'X') goto L10;
        return CastIntegerProtector.parseInt(r100, 16);
    L10:
        return CastIntegerProtector.parseInt(r100.substring(2), 16);
    }

    public static long decodeLongFromHex(String r100) {
        if (r100.charAt(1) == 'x') goto L10;
        if (r100.charAt(1) == 'X') goto L10;
        return CastLongProtector.parseLong(r100, 16);
    L10:
        return CastLongProtector.parseLong(r100.substring(2), 16);
    }
}
