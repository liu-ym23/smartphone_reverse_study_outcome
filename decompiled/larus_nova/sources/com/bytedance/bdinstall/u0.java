package com.bytedance.bdinstall;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class u0 implements a1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0.a f199795a;

    public u0(v0.a r100) {
        this.f199795a = r100;
    }

    @Override // com.bytedance.bdinstall.a1.c
    public final void b(String r100, String r101) {
        t.a("install_info onUpdate " + r100);
        n0 r102 = n0.b(r100);
        if (r102 != null) goto L5;
    L15:
        t.a("install_info onUpdate invalid value " + r102);
        return;
    L5:
        if (TextUtils.isEmpty(r102.f199720a) == true) goto L15;
        if (TextUtils.isEmpty(r102.f199721b) == true) goto L15;
        v0.a r103 = this.f199795a;
        if (r103 == null) goto L17;
        w0 r104 = (w0) r103;
        r104.getClass();
        t.a("install info changed : " + r102);
        ((k) r104.f199809c).p(r102);
        k74.c r105 = r104.f199808b;
        if (r105 == null) goto L18;
        r105.a(new l74.b(r102));
        return;
    L18:
        return;
    }
}
