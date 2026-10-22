package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class af implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f462543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f462544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f462545c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static af f462546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f462547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f462548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f462549g;

    static {
        f462543a = new HashMap();
        f462544b = new HashMap();
        f462545c = new HashMap();
    }

    public final void a() {
        ae r100 = new ae();
        if (r100.a(this.f462547e) == true) goto L5;
        return;
    L5:
        r100.a();
        t.d("SystemCache", "sp cache is cleared");
    }

    private af(Context r100) {
        this.f462549g = false;
        this.f462547e = r100;
        this.f462549g = a(r100);
        t.d("SystemCache", "init status is " + this.f462549g + ";  curCache is " + this.f462548f);
    }

    public static synchronized af b(Context r100) {
        monitor-enter(af.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f462546d != null) goto L7;
        f462546d = new af(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        af r101 = f462546d;     // Catch: Throwable -> L10
        monitor-exit(af.class);
        return r101;
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context r100) {
        ac r101 = new ac();
        this.f462548f = r101;
        boolean r102 = r101.a(r100);
        if (r102 == true) goto L5;
        ae r103 = new ae();
        this.f462548f = r103;
        r102 = r103.a(r100);
    L5:
        if (r102 == true) goto L7;
        this.f462548f = null;
    L7:
        return r102;
    }

    @Override // com.vivo.push.util.e
    public final String a(String r100, String r101) {
        String r102 = f462545c.get(r100);
        if (r102 != null) goto L9;
        e r103 = this.f462548f;
        if (r103 == null) goto L9;
        return r103.a(r100, r101);
    L9:
        return r102;
    }
}
