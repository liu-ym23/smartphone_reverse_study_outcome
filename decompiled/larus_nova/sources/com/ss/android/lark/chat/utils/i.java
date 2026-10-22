package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.team.TeamUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i {
    static {
    }

    @JvmStatic
    public static final boolean a(y6b.c<?> r100, jdb.g r101, Chat r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        if (r102 != null) goto L6;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L27;
        if (r100.f566512v2 != null) goto L24;
        return false;
    L24:
        if (r100.j() == true) goto L31;
    L28:
        return true;
    L31:
        return false;
    L27:
        if (r100.f566510v != null) goto L28;
        return false;
    L17:
        if (r101.isEnable("im.chat.pinned.msg") == false) goto L19;
        r104 = true;
        goto L20
    L6:
        if (r102.isSecret() == true) goto L14;
        TeamUtils.b(r102);
        if (r101.isEnable("im.chat.pinned.url") == false) goto L14;
        if (r102.isThread() == true) goto L14;
        if (r102.isOnCall() == true) goto L14;
        r103 = true;
        goto L15
    }
}
