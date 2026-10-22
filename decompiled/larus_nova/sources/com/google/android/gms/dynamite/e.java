package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements DynamiteModule.VersionPolicy {
    public e() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.b selectModule(Context r100, String r101, DynamiteModule.VersionPolicy.a r102) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.b r103 = new DynamiteModule.VersionPolicy.b();
        r103.f274639a = r102.b(r100, r101);
        int r104 = 1;
        int r105 = r102.a(r100, r101, true);
        r103.f274640b = r105;
        int r106 = r103.f274639a;
        if (r106 != 0) goto L7;
        r106 = 0;
        if (r105 != 0) goto L7;
        r104 = 0;
    L9:
        r103.f274641c = r104;
        return r103;
    L7:
        if (r106 < r105) goto L9;
        r104 = -1;
        goto L9
    }
}
