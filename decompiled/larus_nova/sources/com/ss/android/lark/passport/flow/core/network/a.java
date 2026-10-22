package com.ss.android.lark.passport.flow.core.network;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437751a = 0;

    static {
    }

    public static String a(gpb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        String r101 = (String) CollectionsKt.firstOrNull(jcb.b.c().p0("passport_accounts", r100.envType(), r100.getUserUnit(), "feishu"));
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (StringsKt.isBlank(r101) == false) goto L15;
        int r102 = r100.envType();
        if (r102 != 2) goto L10;
        String r103 = "accounts.feishu-boe.cn";
    L14:
        r101 = r103;
        goto L15
    L10:
        if (r102 == 3) goto L12;
        r103 = "accounts.feishu.cn";
        goto L14
    L12:
        r103 = "accounts.feishu-pre.cn";
    L15:
        String r104 = StringsKt.trimEnd(StringsKt.trim(r101).toString(), new char[]{'/'});
        if (StringsKt.startsWith(r104, "http://", true) == false) goto L18;
        return r104;
    L18:
        if (StringsKt.startsWith(r104, "https://", true) == false) goto L21;
        return r104;
    L21:
        return "https://" + r104;
    }
}
