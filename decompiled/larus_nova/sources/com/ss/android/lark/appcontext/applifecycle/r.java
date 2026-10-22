package com.ss.android.lark.appcontext.applifecycle;

import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class r implements z {
    @Inject
    public r() {
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.z
    public final boolean canUseRunningProcess() {
        return false;
    }
}
