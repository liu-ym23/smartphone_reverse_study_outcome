package yt;

import com.bytedance.android.gamecp.business.compress.AirCompressReport;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Adler32;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568998a = 0;

    static {
    }

    public static int a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        long r100 = System.currentTimeMillis();
        int r101 = 0;
        Adler32 r102 = new Adler32();     // Catch: Throwable -> L18
        BufferedInputStream r103 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r110));     // Catch: Throwable -> L18
        byte[] r104 = new byte[102400];     // Catch: Throwable -> L13
    L6:
        int r105 = r103.read(r104);     // Catch: Throwable -> L13
        if (r105 == (-1)) goto L9;
        r102.update(r104, 0, r105);     // Catch: Throwable -> L13
        goto L6
    L9:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L18
        r101 = (int) r102.getValue();
    L20:
        long r107 = System.currentTimeMillis() - r100;
        Map<String, Double> r108 = AirCompressReport.f52263a;
        Intrinsics.checkNotNullParameter(r110, "path");
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("duration", String.valueOf(r107));
        r109.put("file_path", r110);
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("check_sum_duration", r109);
        yr.c.a("CheckSumUtils", "getCheckSum checkSumValue = " + r101 + ", duration = " + r107);
        return r101;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        yr.c.b("CheckSumUtils", "getCheckSum exception = " + th.getMessage() + ", stack = " + yr.c.d(th));
        goto L20
    }
}
