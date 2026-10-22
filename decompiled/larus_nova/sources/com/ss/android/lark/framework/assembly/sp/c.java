package com.ss.android.lark.framework.assembly.sp;

import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements LarkKVStorage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InitUniStoreTask f425731a;

    @Override // com.ss.android.lark.storage.LarkKVStorage.a
    public final String getCurrentUserId() {
        return InitUniStoreTask.j(this.f425731a);
    }

    public c(InitUniStoreTask r100) {
        this.f425731a = r100;
    }
}
