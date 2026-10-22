package com.ss.cast.sink;

import com.byted.cast.common.Logger;
import com.byted.cast.common.auth.IPullRemoteConfigListener;

/* JADX INFO: loaded from: classes40.dex */
public final class h implements IPullRemoteConfigListener {
    @Override // com.byted.cast.common.auth.IPullRemoteConfigListener
    public final void onSuccess() {
        Logger.i("ByteCastSinkImpl", "RemoteConfig onSuccess ");
    }

    public h() {
    }

    @Override // com.byted.cast.common.auth.IPullRemoteConfigListener
    public final void onError(String r100) {
        Logger.w("ByteCastSinkImpl", "RemoteConfig onError: " + r100);
    }
}
