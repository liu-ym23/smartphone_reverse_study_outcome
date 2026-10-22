package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395566a = 0;

    static {
    }

    public static boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "logTag");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        FLogger.f375446a.i(r101, "isAsrTextLongEnough false: empty text");
        return false;
    L12:
        StringBuilder r103 = new StringBuilder(r100.length());
        int r104 = 0;
    L14:
        if (r104 >= r100.length()) goto L33;
        int r105 = r100.codePointAt(r104);
        int r106 = Character.getType(r105);
        if (Character.isWhitespace(r105) == false) goto L18;
    L21:
        boolean r107 = true;
    L22:
        byte r108 = (byte) r106;
        if (r108 != 29) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r107 == true) goto L32;
        if (r109 == true) goto L32;
        r103.appendCodePoint(r105);
    L32:
        r104 = r104 + Character.charCount(r105);
        goto L14
    L25:
        if (r108 == 30) goto L28;
        switch(r108) {
            case 20: goto L28;
            case 21: goto L28;
            case 22: goto L28;
            case 23: goto L28;
            case 24: goto L28;
            default: goto L27;
        };
    L27:
        r109 = false;
        goto L29
    L18:
        if (Character.isSpaceChar(r105) == true) goto L21;
        r107 = false;
        goto L22
    L33:
        String r110 = r103.toString();
        SidAuthSessionService.f395530a.getClass();
        Lazy r111 = SidAuthSessionService.f395531b;
        if (StringsKt.startsWith$default(r110, (String) r111.getValue(), false, 2, null) == false) goto L36;
        String r112 = StringsKt.removePrefix(r110, (String) r111.getValue());
    L37:
        int r113 = r112.codePointCount(0, r112.length());
        FLogger.f375446a.i(r101, "isAsrTextLongEnough cleanedLen=" + r110.length() + " trimmedLen=" + r112.length() + " codePoints=" + r113);
        if (r113 >= 3) goto L46;
        return false;
    L46:
        return true;
    L36:
        r112 = r110;
        goto L37
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
