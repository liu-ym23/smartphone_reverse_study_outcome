package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements DynamiteModule.VersionPolicy {
    public f() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.b selectModule(Context r100, String r101, DynamiteModule.VersionPolicy.a r102) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.b r103 = new DynamiteModule.VersionPolicy.b();
        int r104 = r102.b(r100, r101);
        r103.f274639a = r104;
        int r105 = 1;
        int r106 = 0;
        if (r104 == 0) goto L5;
        int r107 = r102.a(r100, r101, false);
        r103.f274640b = r107;
    L6:
        int r108 = r103.f274639a;
        if (r108 != 0) goto L10;
        if (r107 != 0) goto L11;
        r105 = 0;
    L13:
        r103.f274641c = r105;
        return r103;
    L11:
        if (r106 < r107) goto L13;
        r105 = -1;
        goto L13
    L10:
        r106 = r108;
        goto L11
    L5:
        r107 = r102.a(r100, r101, true);
        r103.f274640b = r107;
        goto L6
    }
}
