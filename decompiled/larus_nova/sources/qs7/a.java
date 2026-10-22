package qs7;

import android.text.TextUtils;
import android.util.Pair;
import com.dtf.face.config.OSSConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<os7.a.b> f534673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<os7.a.b> f534674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Pair<String, Integer>> f534675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ns7.a f534676d;

    public a() {
        if (TextUtils.isEmpty("FACE") == true) goto L6;
        this.f534673a = new CopyOnWriteArrayList();
        this.f534674b = new CopyOnWriteArrayList();
        return;
    }

    public final String c(int r100) {
        List<os7.a.b> r101 = this.f534673a;
        if (r101 == null) goto L11;
        Iterator r102 = ((CopyOnWriteArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        os7.a.b r103 = (os7.a.b) r102.next();
        if (r103.f526529a != r100) goto L6;
        return r103.f526531c;
    L11:
        List<os7.a.b> r104 = this.f534674b;
        if (r104 == null) goto L20;
        Iterator r105 = ((CopyOnWriteArrayList) r104).iterator();
    L15:
        if (r105.hasNext() == false) goto L28;
        os7.a.b r106 = (os7.a.b) r105.next();
        if (r106.f526529a != r100) goto L15;
        return r106.f526531c;
    L28:
        return "";
    L20:
        return "";
    }

    public final void a(String r100, int r101) {
        if (this.f534675c != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f534675c != null) goto L8;
        this.f534675c = new CopyOnWriteArrayList();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        List<Pair<String, Integer>> r102 = this.f534675c;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        r103.add(new Pair(r100, Integer.valueOf(r101)));
    }

    public final void b(int r110, String r111, String r112, byte[] r113, OSSConfig r114, boolean r115) {
        List<os7.a.b> r100 = this.f534673a;
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) r100;
        r101.add(new os7.a.b(r110, r111, r112, r113, r114, r115));
    }
}
