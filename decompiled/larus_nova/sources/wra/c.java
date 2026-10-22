package wra;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static class a extends StringWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f560909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f560910b;

        public a() {
            this.f560909a = 0;
            this.f560910b = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public final void write(String r100, int r101, int r102) {
            if (this.f560910b == false) goto L5;
            return;
        L5:
            int r103 = this.f560909a;
            if ((r103 + r102) <= 4000) goto L9;
            this.f560910b = true;
            return;
        L9:
            this.f560909a = r103 + r102;
            super.write(r100, r101, r102);
        }
    }

    public static String a(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        Throwable r101 = r100;
    L6:
        if (r101 == null) goto L12;
        if ((r101 instanceof UnknownHostException) == true) goto L9;
        r101 = r101.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r102 = new a();
        PrintWriter r103 = new PrintWriter(r102);
        r100.printStackTrace(r103);     // Catch: Throwable -> L16
    L14:
        r103.flush();
        return r102.toString();
    }
}
