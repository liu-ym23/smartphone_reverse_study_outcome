package com.ss.android.lark.storage;

import com.ss.android.lark.g;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkKVStorage.a f440944a;

    public b(com.ss.android.lark.framework.assembly.sp.c r100) {
        this.f440944a = r100;
    }

    @Override // com.ss.android.lark.g.a
    public final String getUserId() {
        return this.f440944a.getCurrentUserId();
    }
}
