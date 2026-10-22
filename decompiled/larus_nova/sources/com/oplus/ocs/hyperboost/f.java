package com.oplus.ocs.hyperboost;

import android.content.Context;
import android.os.Looper;
import com.oplus.ocs.base.common.api.Api;
import com.oplus.ocs.base.internal.ClientSettings;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends Api.AbstractClientBuilder {
    public f() {
    }

    @Override // com.oplus.ocs.base.common.api.Api.AbstractClientBuilder
    public final Api.Client buildClient(Context r100, Looper r101, ClientSettings r102, Object r103) {
        return new d(r100, r101);
    }
}
