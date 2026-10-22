package com.bytedance.locallife.poi.media.photo;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f262789a;

    public final void a() {
        l r100 = this.f262789a;
        l.a r101 = r100.f262777b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.f262785j == true) goto L8;
        return;
    L8:
        if (r100.f262786k == true) goto L32;
        float r102 = r100.f262782g;
        if (r102 >= 100.0f) goto L20;
        r100.f262781f = r102;
        long r103 = r100.f262779d;
        r100.f262783h = r103;
        float r104 = r100.f262780e;
        float r105 = r102 + r104;
        if (r105 < 100.0f) goto L18;
        r100.f262783h = (long) (((100.0f - r102) / r104) * r103);
        long r106 = System.currentTimeMillis();
        l r107 = this.f262789a;
        long r108 = r106 - r107.f262784i;
        long r109 = r107.f262778c;
        if (r108 >= r109) goto L17;
        r107.f262783h = Math.min(r107.f262783h, r109 - r108);
    L17:
        r101.b(r102, 100.0f - 1, this.f262789a.f262783h);
    L19:
        l r110 = this.f262789a;
        r110.f262782g = r102 + r110.f262780e;
        r110.f262776a.postDelayed(this, r110.f262783h);
        return;
    L18:
        r101.b(r102, r105, r103);
        goto L19
    L20:
        r100.a();
        r101.b(100.0f, 100.0f, this.f262789a.f262783h);
        if (r101.a() == false) goto L27;
        l r111 = this.f262789a;
        if (r111.f262787l == false) goto L27;
        if (r111.f262785j == false) goto L27;
        r111.f262776a.postDelayed(this, r111.f262779d);
        return;
    L27:
        this.f262789a.f262785j = false;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(l r100) {
        this.f262789a = r100;
    }
}
