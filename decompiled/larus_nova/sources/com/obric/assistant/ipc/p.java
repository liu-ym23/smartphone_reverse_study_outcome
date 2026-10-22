package com.obric.assistant.ipc;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f389995a = 0;

    static {
    }

    public static String a(int r100) {
        String r101 = String.valueOf(r100);
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "";
    L9:
        return "***" + StringsKt.takeLast(r101, 4);
    L5:
        r102 = false;
        goto L6
    }
}
