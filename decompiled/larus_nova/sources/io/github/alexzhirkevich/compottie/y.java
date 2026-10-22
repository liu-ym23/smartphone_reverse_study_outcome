package io.github.alexzhirkevich.compottie;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f491616a = null;

    static {
        f491616a = new y();
    }

    public y() {
    }

    public final void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        System.out.println("⛔ [COMPOTTIE] " + r100);
        r101.printStackTrace();
    }
}
