package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
class ak implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class<?> f235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f463130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f463131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f463132d;

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public boolean mo8805a() {
        if (this.f235a != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f236a == null) goto L7;
        return true;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public String mo8804a() {
        return a(this.f463129a, this.f463130b);
    }

    public ak(Context r100) {
        this.f237a = null;
        this.f463130b = null;
        this.f463131c = null;
        this.f463132d = null;
        this.f463129a = r100;
        a(r100);
    }

    private void a(Context r100) {
        Class<?> r101 = q.a(r100, "com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L4
        this.f235a = r101;     // Catch: Exception -> L4
        this.f236a = r101.newInstance();     // Catch: Exception -> L4
        this.f463130b = this.f235a.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
    }

    private String a(Context r100, Method r101) {
        Object r102 = this.f236a;
        if (r102 == null) goto L16;
        if (r101 != null) goto L14;
        return null;
    L14:
        Object r103 = r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L10
        if (r103 == null) goto L18;
        return (String) r103;
    L18:
        return null;
    L10:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
        return null;
    L16:
        return null;
    }
}
