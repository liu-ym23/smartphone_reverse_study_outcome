package com.lark.kmp.storage;

import okio.l;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f282695a = null;

    static {
        f282695a = new b();
    }

    public b() {
    }

    @Override // com.lark.kmp.storage.g
    public final com.lark.kmp.storage.kv.f a() {
        return new com.lark.kmp.storage.kv.f();
    }

    @Override // com.lark.kmp.storage.g
    public final a b() {
        return new a();
    }

    @Override // com.lark.kmp.storage.g
    public final com.lark.kmp.storage.file.a c() {
        return new com.lark.kmp.storage.file.a(l.f524085a);
    }
}
