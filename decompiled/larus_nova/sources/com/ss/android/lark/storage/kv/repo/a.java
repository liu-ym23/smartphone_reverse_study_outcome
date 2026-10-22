package com.ss.android.lark.storage.kv.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KVRepo f441076c;

    @Override // com.ss.android.lark.storage.kv.repo.c
    public final KVRepo c() {
        return this.f441076c;
    }

    public a(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
        this.f441076c = r100;
    }
}
