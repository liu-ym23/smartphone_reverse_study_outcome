package com.relax.relaxframework.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f405305a = null;

    static {
        f405305a = new Handler(Looper.getMainLooper());
    }

    public static void a(final String r100, final Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r110, "callback");
        final boolean r101 = false;
        ThreadsKt.thread$default(false, false, null, null, 0, new UrlDownloader$download$1(r100, r101, r110), 31, null);
    }
}
