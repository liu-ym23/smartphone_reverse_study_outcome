package com.oplus.ocs.hyperboost;

import android.content.Context;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.Feature;
import com.oplus.ocs.base.common.api.Api;
import com.oplus.ocs.base.common.api.OplusApi;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends OplusApi<Api.ApiOptions.NoOptions, b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Feature> f404314g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f404315h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f404316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static g f404317j;

    @Override // com.oplus.ocs.base.common.api.OplusApi
    public final int getVersion() {
        return 100001;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApi
    public final boolean hasFeature(String r100) {
        return true;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApi
    public final void init() {
    }

    static {
        f404314g = new ArrayList();
        Api.ClientKey r100 = new Api.ClientKey();
        f404315h = new Api("HyperBoostClient.API", new f(), r100);
        f404316i = null;
        f404317j = null;
    }

    @Override // com.oplus.ocs.base.common.api.OplusApi
    public final void checkAuthResult(CapabilityInfo r100) {
        f404317j.a(r100.getAuthResult());
    }

    public b(Context r100, g r101) {
        super(r100, f404315h, null, new ClientSettings(r100.getPackageName(), 100001, f404314g));
        f404317j = r101;
        r101.a(r100);
        checkCapability();
    }
}
