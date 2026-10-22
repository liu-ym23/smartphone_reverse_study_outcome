package com.oplus.ocs.hyperboost;

import android.content.Context;
import android.os.Looper;
import com.oplus.ocs.base.common.api.BaseClient;
import com.oplus.ocs.base.common.constant.CapabilityConstants;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends BaseClient {
    @Override // com.oplus.ocs.base.common.api.BaseClient
    public final String getClientName() {
        return CapabilityConstants.HYPER_BOOST_CLIENT;
    }

    public d(Context r100, Looper r101) {
        super(r100, r101);
    }
}
