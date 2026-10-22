package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements DynamiteModule.VersionPolicy {
    public d() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.b selectModule(Context r100, String r101, DynamiteModule.VersionPolicy.a r102) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.b r103 = new DynamiteModule.VersionPolicy.b();
        int r104 = 0;
        int r105 = r102.a(r100, r101, false);
        r103.f274640b = r105;
        if (r105 == 0) goto L6;
        r104 = 1;
    L6:
        r103.f274641c = r104;
        return r103;
    }
}
