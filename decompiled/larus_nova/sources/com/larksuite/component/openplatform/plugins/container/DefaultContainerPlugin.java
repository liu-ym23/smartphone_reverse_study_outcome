package com.larksuite.component.openplatform.plugins.container;

import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.GetApiAccessConfig$GetDomainResponse;
import i18.b;
import j18.f;

/* JADX INFO: loaded from: classes24.dex */
public class DefaultContainerPlugin extends b {
    private jz7.b container;

    @Override // i18.d
    public void onRelease() {
        this.container = null;
    }

    public DefaultContainerPlugin(jz7.b r100) {
        this.container = r100;
    }

    @LKPluginFunction(async = true, eventName = {"getApiAccessConfig"})
    public void getDomains(f<GetApiAccessConfig$GetDomainResponse> r100) {
        GetApiAccessConfig$GetDomainResponse r101 = new GetApiAccessConfig$GetDomainResponse();
        LKOpenApiAccessConfig r102 = this.container.f501208g;
        if (r102 != null) goto L5;
    L10:
        r100.callback(r101);
        return;
    L5:
        if (r102.getDomain() == null) goto L7;
        r101.mDomain = this.container.f501208g.getDomain().name();
    L7:
        r101.mScene = this.container.f501208g.getScene();
        if (this.container.f501208g.getBizType() == null) goto L10;
        r101.mBizType = this.container.f501208g.getBizType().name();
        goto L10
    }
}
