package xk4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f564207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f564208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f564209c;

    public final String b() {
        Object r100 = this.f564209c;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.f564208b);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r102.append((String) r103.next());
        r102.append("\n");
        goto L8
    L11:
        return r102.toString();
    L12:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f564208b = new ArrayList();
        this.f564209c = new Object();
    }

    public final void a(String r100) {
        String r101 = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss", Locale.CHINA).format(new Date());
        Object r102 = this.f564209c;
        monitor-enter(r102);
        this.f564208b.add(r101 + " " + r100);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
