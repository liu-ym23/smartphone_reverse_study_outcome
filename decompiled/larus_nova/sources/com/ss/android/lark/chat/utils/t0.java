package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.entity.Notice;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class t0 {
    static {
    }

    @JvmStatic
    public static final boolean a(Notice r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        if (r100.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r102 = r100.extra;
        if (r102.f433060d != Notice.Extra.ChatMode.THREAD_V2) goto L8;
    L11:
        return true;
    L8:
        if (TextUtils.isEmpty(r102.f433061e) == false) goto L11;
        return !TextUtils.equals(r100.extra.f433057a, r101);
    }

    @JvmStatic
    public static final boolean b(Notice r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "threadId");
        if (r100.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r102 = r100.extra;
        if (r102.f433060d != Notice.Extra.ChatMode.THREAD_V2) goto L16;
        if (TextUtils.isEmpty(r102.f433061e) == false) goto L10;
    L14:
        return true;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        boolean r103 = TextUtils.equals(r100.extra.f433061e, r101);
    L13:
        return !r103;
    L16:
        if (TextUtils.isEmpty(r102.f433061e) == true) goto L18;
        r103 = TextUtils.equals(r100.extra.f433061e, r101);
        goto L13
    L18:
        return true;
    }

    @JvmStatic
    public static final boolean c(Notice r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        if (r100.isFromBackgroundUser == false) goto L5;
        return true;
    L5:
        Notice.Extra r102 = r100.extra;
        if (r102.f433060d == Notice.Extra.ChatMode.THREAD_V2) goto L8;
    L19:
        return true;
    L8:
        if (TextUtils.isEmpty(r102.f433057a) == true) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        boolean r103 = TextUtils.equals(r100.extra.f433057a, r101);
    L13:
        return !r103;
    L15:
        if (r100.type == 2) goto L19;
        Notice.Extra r104 = r100.extra;
        if (r104.f433067k != (-1)) goto L19;
        r103 = TextUtils.equals(r104.f433057a, r101);
        goto L13
    }
}
