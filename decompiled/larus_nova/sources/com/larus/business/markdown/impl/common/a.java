package com.larus.business.markdown.impl.common;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f320522a = 0;

    static {
    }

    public static int a(String r100, int r101) {
    L3:
        if ((-1) >= r101) goto L16;
        Character r102 = StringsKt.getOrNull(r100, r101);
        if (r102 == null) goto L15;
        if (r102.charValue() != '[') goto L15;
        Character r103 = StringsKt.getOrNull(r100, r101 - 1);
        if (r103 == null) goto L14;
        if (r103.charValue() == '\\') goto L15;
    L14:
        return r101;
    L15:
        r101 = r101 - 1;
        goto L3
    L16:
        return -1;
    }

    public static void b(StringBuilder r100, int r101) {
        Character r102 = StringsKt.getOrNull(r100, r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.charValue() != '!') goto L14;
        Character r103 = StringsKt.getOrNull(r100, r101 - 1);
        if (r103 != null) goto L11;
    L12:
        r100.delete(r101, r100.length());
        return;
    L11:
        if (r103.charValue() != '\\') goto L12;
        return;
    }
}
