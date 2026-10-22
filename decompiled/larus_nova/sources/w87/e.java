package w87;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static String a(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }
}
