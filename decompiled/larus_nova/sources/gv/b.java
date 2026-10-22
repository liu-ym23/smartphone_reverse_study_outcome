package gv;

import android.hardware.Camera;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482808a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Camera r100, TokenCert r101) {
        Intrinsics.checkNotNullParameter(r100, "camera");
        int r102 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: BPEAException -> L5
        com.bytedance.bpea.entry.api.camera.a.C2917a.c(r100, r101);     // Catch: BPEAException -> L5
        return;
    L5:
        e = move-exception;
        yr.b.d("CameraUtils", null, e);
    }
}
