package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements DynamiteModule.VersionPolicy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274642a;

    public i(int r100) {
        this.f274642a = r100;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.a
    public final int a(Context r100, String r101, boolean r102) {
        return 0;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.a
    public final int b(Context r100, String r101) {
        return this.f274642a;
    }
}
