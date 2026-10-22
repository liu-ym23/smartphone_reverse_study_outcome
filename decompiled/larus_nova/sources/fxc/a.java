package fxc;

import android.os.Process;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f479121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f479124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f479125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f479127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f479128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f479129i;

    /* JADX INFO: renamed from: fxc.a$a, reason: collision with other inner class name */
    public static class C5963a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f479130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f479131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f479132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f479133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f479134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f479135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f479136g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f479137h;

        public C5963a(int r100, String r101) {
            this.f479130a = System.currentTimeMillis();
            this.f479131b = Process.myPid();
            this.f479132c = Process.myTid();
            this.f479133d = r100;
            this.f479134e = r101;
            this.f479135f = "";
            this.f479137h = "";
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[");
        r100.append(this.f479121a.format(Long.valueOf(this.f479122b)));
        r100.append(" ");
        int r101 = this.f479125e;
        if (r101 != 3) goto L5;
        char r102 = 'D';
    L18:
        r100.append(r102);
        r100.append(HTTP.URL_DEFAULT);
        r100.append(this.f479126f);
        r100.append(" ");
        r100.append(this.f479123c);
        r100.append(":");
        r100.append(this.f479124d);
        r100.append(" ");
        r100.append(this.f479127g);
        r100.append(":0] ");
        r100.append(this.f479128h);
        if (this.f479129i == null) goto L21;
        r100.append('\n');
        r100.append(this.f479129i);
    L21:
        r100.append("\n");
        return r100.toString();
    L5:
        if (r101 != 4) goto L7;
        r102 = 'I';
        goto L18
    L7:
        if (r101 != 5) goto L9;
        r102 = 'W';
        goto L18
    L9:
        if (r101 != 6) goto L11;
        r102 = 'E';
        goto L18
    L11:
        if (r101 == 7) goto L13;
        r102 = 'V';
        goto L18
    L13:
        r102 = 'A';
        goto L18
    }

    public a(C5963a r100) {
        this.f479121a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f479122b = r100.f479130a;
        this.f479123c = r100.f479131b;
        this.f479124d = r100.f479132c;
        this.f479125e = r100.f479133d;
        this.f479126f = r100.f479134e;
        this.f479127g = r100.f479135f;
        this.f479128h = r100.f479136g;
        this.f479129i = r100.f479137h;
    }
}
