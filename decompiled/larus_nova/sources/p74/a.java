package p74;

import java.util.concurrent.Callable;
import m74.c;
import org.json.JSONObject;
import v74.d;
import v74.e;
import w74.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Callable<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f528016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f528017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f528018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f528019d;

    public abstract String b();

    public abstract String c();

    public final f a() {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L8
        String r101 = c();     // Catch: Exception -> L8
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L8
        f r103 = this.f528016a;     // Catch: Exception -> L8
        r103.f558528c = r101;     // Catch: Exception -> L8
        r103.f558526a = b();     // Catch: Exception -> L8
        f r104 = this.f528016a;     // Catch: Exception -> L8
        r104.f558527b = r102 - r100;     // Catch: Exception -> L8
        r104.f558529d = this.f528017b;     // Catch: Exception -> L8
        r104.a();     // Catch: Exception -> L8
        if (this.f528018c.has("index") == false) goto L6;
        this.f528016a.f558531f = this.f528018c.optInt("index");     // Catch: Exception -> L8
    L6:
        return this.f528016a;
    L8:
        e = move-exception;
        m74.a.b("[dt] " + b() + " doLoad# error " + e.getMessage());
        return this.f528016a;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ f call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public f call2() throws Exception {
        return a();
    }

    public a(JSONObject r100) {
        this.f528017b = "";
        this.f528018c = r100;
        this.f528016a = new f();
        c r101 = (c) e.a(c.class);
        if (r101 == null) goto L6;
        this.f528019d = r101.f512346b;
        return;
    }
}
