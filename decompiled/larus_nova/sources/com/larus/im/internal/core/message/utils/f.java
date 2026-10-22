package com.larus.im.internal.core.message.utils;

import android.text.TextUtils;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f347865a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.b<String> f347866b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vt7.b<String> f347867c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vt7.b<String> f347868d = null;

    static {
        f347865a = new Object();
        f347866b = new vt7.b();
        f347867c = new vt7.b();
        f347868d = new vt7.b();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isDigitsOnly(r100) == true) goto L11;
        return;
    L11:
        Object r102 = f347865a;
        monitor-enter(r102);
        vt7.b<String> r103 = f347866b;     // Catch: Throwable -> L23
        r103.add(r100);     // Catch: Throwable -> L23
        if (r103.size() <= 10) goto L17;
        Object r104 = CollectionsKt.first(r103);     // Catch: Throwable -> L23
        r103.remove((String) r104);     // Catch: Throwable -> L23
        String r105 = (String) r104;     // Catch: Throwable -> L23
    L18:
        monitor-exit(r102);
        com.larus.im.internal.delegate.a r106 = com.larus.im.internal.delegate.a.f348188b;
        r106.i("MessageInterruptHelper", "cancelSet add ".concat(r100));
        if (r105 == null) goto L28;
        r106.i("MessageInterruptHelper", "cancelSet remove ".concat(r105));
        return;
    L28:
        return;
    L17:
        r105 = null;
    L23:
        th = move-exception;
        throw th;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        if (c(r100, r101) == false) goto L6;
        return true;
    L6:
        return !f347866b.contains(r100);
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        if (f347867c.contains(r100) == false) goto L6;
        return true;
    L6:
        if (CollectionsKt.contains(f347868d, r101) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
