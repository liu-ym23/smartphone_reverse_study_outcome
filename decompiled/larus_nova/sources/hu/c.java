package hu;

import android.view.Window;
import bw.k;
import com.lynx.tasm.LynxError;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f487195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Window> f487196b;

    static {
        f487195a = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        k r101 = f487195a;
        if (r101 == null) goto L10;
        WeakReference<Window> r102 = f487196b;
        if (r102 == null) goto L7;
        Window r103 = r102.get();
    L8:
        r101.n2(r103);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public static void a(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "message");
        k r102 = f487195a;
        if (r102 == null) goto L6;
        r102.T1("gamecp_business");
        return;
    }
}
