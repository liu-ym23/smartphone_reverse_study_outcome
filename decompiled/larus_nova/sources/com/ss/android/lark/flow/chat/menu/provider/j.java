package com.ss.android.lark.flow.chat.menu.provider;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {
    public static final boolean a(yya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        w4b.c.p r101 = ChatCoreModule.a().getProfile();
        if (r101 == null) goto L6;
        r101.getClass();
    L6:
        if (com.ss.android.lark.chat.utils.k.d(r100.getChat()) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
