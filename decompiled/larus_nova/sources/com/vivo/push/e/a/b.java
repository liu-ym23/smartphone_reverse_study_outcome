package com.vivo.push.e.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.vivo.push.restructure.request.a.a.b.a<b> f462304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<com.vivo.push.e.b> f462306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f462307d;

    static {
        f462304a = new c();
    }

    public final List<String> a() {
        ArrayList r100 = new ArrayList();
        Iterator<com.vivo.push.e.b> r101 = this.f462306c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = r101.next().b();
        if (TextUtils.isEmpty(r102) == true) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public b(com.vivo.push.restructure.request.a.a.a r100) throws JSONException {
        this.f462306c = new ArrayList();
        this.f462305b = r100.c();
        this.f462307d = r100.a();
        r100.a(com.vivo.push.e.b.f462308a, this.f462306c);
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a r100) {
        r100.a(this.f462305b);
        r100.a(this.f462307d);
        r100.a(this.f462306c);
    }

    public b(String r100, List<com.vivo.push.e.b> r101, int r102) {
        new ArrayList();
        this.f462305b = r100;
        this.f462307d = r102;
        this.f462306c = r101;
    }
}
