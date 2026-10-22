package com.larus.account.saas.core.ttaccount;

import b48.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends ua7.a<ua7.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f286286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x38.b f286287b;

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        if (r100 == null) goto L6;
        boolean r101 = true;
        if (r100.f549249c != true) goto L6;
    L7:
        String r102 = null;
        if (r101 == false) goto L14;
        CopyOnWriteArraySet<x38.f> r103 = com.larus.account.saas.core.internal.b.f286237a;
        String r104 = this.f286286a;
        Intrinsics.checkNotNullParameter(r104, "platform");
        Iterator<x38.f> r105 = com.larus.account.saas.core.internal.b.f286237a.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r105.next().b(r104);
        goto L11
    L13:
        this.f286287b.b(new g(null));
        return;
    L14:
        x38.b r106 = this.f286287b;
        if (r100 == null) goto L17;
        int r107 = r100.f549253g;
    L18:
        if (r100 == null) goto L20;
        r102 = r100.f549255i;
    L20:
        r106.a(new b48.c(r107, r102));
        return;
    L17:
        r107 = -1;
    L6:
        r101 = false;
        goto L7
    }

    public a(String r100, com.larus.account.saas.jsb.core.g r101) {
        this.f286286a = r100;
        this.f286287b = r101;
    }
}
