package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static final boolean a(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = PluginUtils.c();
        boolean r102 = r100.getDoubaoSetting().isDoubaoUsingEnabled();
        int r103 = com.ss.android.lark.biz.im.api.h.f410251a;
        if (r101 == true) goto L6;
        if (r102 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
