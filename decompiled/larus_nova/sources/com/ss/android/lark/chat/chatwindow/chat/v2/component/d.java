package com.ss.android.lark.chat.chatwindow.chat.v2.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f413557a = 0;

    static {
    }

    public static String a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        String r101 = r100.getCanonicalName();
        if (r101 == null) goto L7;
        return "androidx.lifecycle.ViewModelProvider.DefaultKey0".concat(r101);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
