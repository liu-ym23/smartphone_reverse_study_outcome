package com.ss.android.lark.keyboard.biz.mention;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f428425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f428426b = null;

    public f() {
    }

    static {
        f428426b = new Object();
    }

    public static void a(hob.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        if (r100.f486316i == false) goto L6;
        r100.f486317j = true;
        return;
    L6:
        boolean r102 = false;
        if (r101.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return;
    L12:
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        String r104 = f428425a;
        if (r104 != null) goto L30;
        Object r105 = f428426b;
        monitor-enter(r105);
        String r106 = f428425a;     // Catch: Throwable -> L40
        if (r106 == null) goto L21;
        monitor-exit(r105);
    L20:
        r104 = r106;
        goto L30
    L21:
        r106 = (String) BuildersKt.runBlocking$default(null, new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(null), 1, null);     // Catch: Throwable -> L40
        if (r106 != null) goto L25;
        r106 = "";
    L25:
        if ((!StringsKt.isBlank(r106)) == false) goto L27;
        f428425a = r106;     // Catch: Throwable -> L40
    L27:
        monitor-exit(r105);
    L40:
        th = move-exception;
        throw th;
    L30:
        if (r104.length() <= 0) goto L32;
        boolean r107 = true;
    L33:
        if (r107 == true) goto L35;
    L37:
        if (r102 == false) goto L45;
        r100.f486316i = true;
        r100.f486317j = true;
        return;
    L45:
        return;
    L35:
        if (Intrinsics.areEqual(r104, r101) == false) goto L37;
        r102 = true;
        goto L37
    L32:
        r107 = false;
        goto L33
    L9:
        r103 = false;
        goto L10
    }
}
