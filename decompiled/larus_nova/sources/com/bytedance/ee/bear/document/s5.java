package com.bytedance.ee.bear.document;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s5 implements com.bytedance.ee.bear.document.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jdb.g f221504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t45.c f221505b;

    @Override // com.bytedance.ee.bear.document.template.a
    public final String y0() {
        if (this.f221504a.isCurrentEnable("ccm.mobile.ark_domain") == false) goto L7;
        String r100 = this.f221505b.f9();
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L7:
        String r101 = s45.p.f540583t;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public s5(jdb.g r100, t45.c r101) {
        this.f221504a = r100;
        this.f221505b = r101;
    }
}
