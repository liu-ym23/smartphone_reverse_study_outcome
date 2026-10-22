package ye;

import com.bytedance.services.apm.api.EnsureManager;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567357a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        EnsureManager.ensureNotReachHere("EC_SDK " + r100);
    }

    public static void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        EnsureManager.ensureNotReachHere(r100, "EC_SDK ");
    }
}
