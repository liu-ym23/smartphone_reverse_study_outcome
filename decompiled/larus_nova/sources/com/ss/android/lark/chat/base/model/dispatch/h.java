package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f411778a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.hashCode() + '_' + StringsKt.substringAfterLast$default(r100, ".", null, 2, null);
    }
}
