package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f417465o == true) goto L13;
        Chat.Type r101 = r100.f417451a;
        if (r101 != Chat.Type.P2P) goto L7;
    L12:
        return true;
    L7:
        if (r101 != Chat.Type.GROUP) goto L13;
        if (r100.f417456f == true) goto L12;
        if (r100.f417457g == true) goto L12;
    L13:
        return false;
    }
}
