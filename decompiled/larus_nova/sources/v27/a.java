package v27;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static String a(Throwable r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r100.printStackTrace(new PrintStream(r101));
        return r101.toString();
    }
}
