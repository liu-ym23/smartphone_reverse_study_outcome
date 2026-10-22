package com.bytedance.awemeopen.infra.plugs.ttnet;

import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkService;
import h64.b;
import h64.c;
import java.util.HashMap;
import q64.a;
import q64.g;

/* JADX INFO: loaded from: classes3.dex */
public class AoNetworkServiceTTNetImpl implements AoNetworkService {
    @Override // com.bytedance.awemeopen.servicesapi.network.AoNetworkService
    public final void getNetworkType() {
    }

    public AoNetworkServiceTTNetImpl() {
        new HashMap();
    }

    @Override // com.bytedance.awemeopen.servicesapi.network.AoNetworkService
    public final g s2(a r100) {
        if (TextUtils.equals(TemplateNodeType.RAW, r100.f531778f.a("bdp_ttnet_request_type")) == false) goto L7;
        return new b(r100);
    L7:
        return new c(r100);
    }
}
