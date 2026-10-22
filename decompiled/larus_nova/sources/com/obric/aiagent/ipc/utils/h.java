package com.obric.aiagent.ipc.utils;

import com.obric.aiagent.platform.depend.ISecureLogDepend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384747a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        ISecureLogDepend.f384994b.i("IPC-BASE", "--> [" + r100 + "] " + r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        ISecureLogDepend.f384994b.i("IPC-BASE", "<-- [" + r100 + "] " + r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        ISecureLogDepend.f384994b.i("IPC-BASE", "=== [" + r100 + "] " + r101);
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "event");
        ISecureLogDepend.f384994b.w("IPC-BASE", "*** [" + r100 + "] " + r101, r102);
    }
}
