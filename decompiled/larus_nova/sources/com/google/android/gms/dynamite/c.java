package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class c implements DynamiteModule.VersionPolicy {
    public c() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.b selectModule(Context r100, String r101, DynamiteModule.VersionPolicy.a r102) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.b r103 = new DynamiteModule.VersionPolicy.b();
        int r104 = r102.b(r100, r101);
        r103.f274639a = r104;
        if (r104 == 0) goto L5;
        r103.f274641c = -1;
    L8:
        return r103;
    L5:
        int r105 = r102.a(r100, r101, true);
        r103.f274640b = r105;
        if (r105 == 0) goto L8;
        r103.f274641c = 1;
        goto L8
    }
}
