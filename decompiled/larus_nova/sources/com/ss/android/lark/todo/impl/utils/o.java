package com.ss.android.lark.todo.impl.utils;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KVRepo f444295a;

    public o(com.ss.android.lark.storage.kv.repo.a r100) {
        this.f444295a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.utils.n
    public final void putInt(int r100) {
        Intrinsics.checkNotNullParameter("last_badge_count_cache_key", "key");
        this.f444295a.putInt("last_badge_count_cache_key", r100);
    }

    @Override // com.ss.android.lark.todo.impl.utils.n
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f444295a.getString(r100, r101);
    }

    @Override // com.ss.android.lark.todo.impl.utils.n
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f444295a.putString(r100, r101);
    }
}
