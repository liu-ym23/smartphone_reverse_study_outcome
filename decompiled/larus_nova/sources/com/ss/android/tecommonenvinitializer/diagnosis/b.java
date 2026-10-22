package com.ss.android.tecommonenvinitializer.diagnosis;

import com.ss.android.tecommonenvinitializer.MultiMediaEnv;
import com.ss.android.tecommonenvinitializer.MultiMediaEnvContext$HostBuildType;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final synchronized void a(List r100) {
        monitor-enter(b.class);
        Intrinsics.checkNotNullParameter(r100, "libs");     // Catch: Throwable -> L12
        MultiMediaEnv.a r101 = MultiMediaEnv.f449589a;     // Catch: Throwable -> L12
        if (MultiMediaEnv.f449594f == MultiMediaEnvContext$HostBuildType.INTERNAL) goto L7;
    L9:
        a.a(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(b.class);
        return;
    L7:
        if (MultiMediaEnv.f449592d.getValue().f449601a == false) goto L9;
        c.f449597a.b(r100, LibraryLoader$loadLibrary$1.INSTANCE);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
