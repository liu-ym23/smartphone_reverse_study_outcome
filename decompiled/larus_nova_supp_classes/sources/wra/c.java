package wra;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {

    public static class a extends StringWriter {
        public int a;
        public boolean b;

        public a() {
            this.a = 0;
            this.b = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public final void write(String r4, int r5, int r6) {
            if (this.b == false) goto L5;
            return;
        L5:
            int r0 = this.a;
            if ((r0 + r6) <= 4000) goto L9;
            this.b = true;
            return;
        L9:
            this.a = r0 + r6;
            super.write(r4, r5, r6);
        }
    }

    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        Throwable r0 = r2;
    L6:
        if (r0 == null) goto L12;
        if ((r0 instanceof UnknownHostException) == true) goto L9;
        r0 = r0.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r1 = new a();
        PrintWriter r3 = new PrintWriter(r1);
        r2.printStackTrace(r3);     // Catch: Throwable -> L16
    L14:
        r3.flush();
        return r1.toString();
    }
}
