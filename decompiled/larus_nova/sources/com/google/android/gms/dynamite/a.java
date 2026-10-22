package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements DynamiteModule.VersionPolicy.a {
    public a() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.a
    public final int b(Context r100, String r101) {
        return DynamiteModule.getLocalVersion(r100, r101);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.a
    public final int a(Context r100, String r101, boolean r102) throws DynamiteModule.LoadingException {
        return DynamiteModule.zza(r100, r101, r102);
    }
}
