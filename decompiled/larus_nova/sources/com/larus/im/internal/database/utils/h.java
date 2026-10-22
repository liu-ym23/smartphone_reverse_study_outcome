package com.larus.im.internal.database.utils;

import com.larus.im.bean.message.MessageContentType;
import com.larus.im.internal.delegate.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f348163a = 0;

    static {
    }

    public static String a(String r110, String r111, @MessageContentType int r112, String r113, String r114, List r115) {
        Intrinsics.checkNotNullParameter(r110, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r113, "content");
        Intrinsics.checkNotNullParameter(r114, "thinkingContent");
        boolean r100 = false;
        if (r113.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
    L18:
        return d0.f348204b.a(r112, r111, r113, r114, r115);
    L15:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("InternalFtsParseUtils", r110 + '(' + r111 + "): ftsParseMessage err msg=" + th.getMessage());
        return "";
    L9:
        if (r114.length() != 0) goto L11;
        r100 = true;
    L11:
        if (r100 == false) goto L18;
        return "";
    L5:
        r101 = false;
        goto L7
    }
}
