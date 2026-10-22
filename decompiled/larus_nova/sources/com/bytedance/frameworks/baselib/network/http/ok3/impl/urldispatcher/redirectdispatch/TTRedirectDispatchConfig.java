package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch;

import com.bytedance.frameworks.baselib.network.config.hostpathmatch.b;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.c;

/* JADX INFO: loaded from: classes3.dex */
public class TTRedirectDispatchConfig extends b<TTRedirectDispatchValue> {
    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public String getConfigRootKey() {
        return "ttnet_redirect_dp";
    }

    public TTRedirectDispatchConfig() {
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public TTRedirectDispatchValue parseHostPathValue(Object r100) {
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        TTRedirectDispatchValue r102 = new TTRedirectDispatchValue();
        boolean r103 = true;
        if (r101.intValue() == 1) goto L12;
        r103 = false;
    L12:
        r102.enabled = r103;
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.b
    public /* bridge */ /* synthetic */ c parseHostPathValue(Object r100) {
        return parseHostPathValue(r100);
    }
}
