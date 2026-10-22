package com.larus.bmhome.social.userchat.model;

import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes26.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f314122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f314123b;

    static {
    }

    public static void a(boolean r100) {
        f314122a = r100;
        if (r100 == false) goto L5;
        CompletableDeferred<Boolean> r101 = wr8.d.f560874a;
        wr8.d.b.c("PreLoadHelper#isColdLandingToChatList");
    L5:
        if (r100 == true) goto L7;
        return;
    L7:
        if (f314123b == false) goto L11;
        b(false);
        return;
    }

    public static void b(boolean r100) {
        f314123b = r100;
        if (r100 == true) goto L5;
        CompletableDeferred<Boolean> r101 = wr8.d.f560874a;
        wr8.d.b.c("PreLoadHelper, not landing to main");
    L5:
        if (r100 == true) goto L7;
        return;
    L7:
        if (f314122a == false) goto L11;
        a(false);
        return;
    }
}
