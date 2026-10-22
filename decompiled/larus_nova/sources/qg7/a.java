package qg7;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.timon.clipboard.cert.check.api.IClipboardSuiteCertChecker;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    static {
    }

    public static b a(Cert r100, String r101, int r102) {
        Map<String, Object> r103 = r100.customInfo();
        if (r103 == null) goto L5;
        Object r104 = r103.get("clipboard_suite_monitor_compat_kit");
    L6:
        String r105 = "";
        if (Intrinsics.areEqual(r104, 1) == false) goto L39;
        String r106 = r100.certToken();
        if (r106 == null) goto L12;
        r105 = r106;
    L12:
        return new b(false, "from bpea don't need check cert", r105, 0);
    L39:
        qc4.d r107 = ((IClipboardSuiteCertChecker) ServiceManager.get().getService(IClipboardSuiteCertChecker.class)).check(r100, r101, r102);     // Catch: BPEAException -> L29
        if (r107 != null) goto L16;
    L23:
        String r108 = r100.certToken();     // Catch: BPEAException -> L29
        if (r108 != null) goto L27;
        r108 = "";
    L27:
        b r109 = new b(false, "cert check success", r108, 0);     // Catch: BPEAException -> L29
    L38:
    L37:
        return r109;
    L16:
        if (r107.f532473b == 0) goto L23;
        String r110 = r100.certToken();     // Catch: BPEAException -> L29
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r109 = new b(true, r107.f532474c, r110, 0);     // Catch: BPEAException -> L29
    L29:
        e = move-exception;
        String r111 = "bpea 证书校验失败";
        com.bytedance.timonbase.b.d("ClipboardSuite", "bpea 证书校验失败", e);
        String r112 = e.getMessage();
        if (r112 == null) goto L33;
        r111 = r112;
    L33:
        String r113 = r100.certToken();
        if (r113 == null) goto L36;
        r105 = r113;
    L36:
        r109 = new b(true, r111, r105, -6008);
        goto L37
    L5:
        r104 = null;
        goto L6
    }
}
