package com.obric.aiagent.ipc.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384738a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        ILogDepend.f384986a.i("IPC-BASE", "--- [" + r100 + "] " + r101);
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r102 != null) goto L5;
        ILogDepend.f384986a.w("IPC-BASE", "*** [" + r100 + "] " + r101);
        return;
    L5:
        ILogDepend.f384986a.w("IPC-BASE", "*** [" + r100 + "] " + r101, r102);
    }
}
