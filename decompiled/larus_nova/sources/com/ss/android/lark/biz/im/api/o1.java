package com.ss.android.lark.biz.im.api;

import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f410428a = 0;

    static {
    }

    @JvmStatic
    public static final n1 a(String r100, String r101, Long r102) {
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L18;
        if (r101 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == false) goto L17;
        return null;
    L17:
        return new n1(r101, r100, new String(w28.a.a(x28.a.a(r101))), r102);
    L12:
        if (StringsKt.isBlank(r101) == false) goto L14;
    L18:
        return null;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r104 = false;
        goto L9
    }
}
