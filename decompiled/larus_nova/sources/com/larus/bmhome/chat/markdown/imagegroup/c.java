package com.larus.bmhome.chat.markdown.imagegroup;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f307050a = null;

    static {
        f307050a = new CopyOnWriteArraySet();
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "forceRefreshId");
        CopyOnWriteArraySet<String> r101 = f307050a;
        if ((!r101.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L7;
        return true;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "forceRefreshId");
        f307050a.add(r100);
    }
}
