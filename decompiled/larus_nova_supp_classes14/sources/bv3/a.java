package bv3;

import android.os.Process;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static long a() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), ECDraweeView.SQUARE);     // Catch: Throwable -> L8
        String r0 = r2.readLine();     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L14
        String[] r1 = r0.split(" ");     // Catch: Throwable -> L14
        long r3 = Long.parseLong(r1[13]) + Long.parseLong(r1[14]);
        r2.close();     // Catch: Throwable -> L13
    L7:
        return r3;
    L9:
        if (r2 == null) goto L24;
        r2.close();     // Catch: Throwable -> L15
        return -1;
    L25:
        return -1;
    L24:
        return -1;
    L8:
        r2 = null;
        goto L9
    }
}
