package com.larus.account.base.impl;

import android.content.Intent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.account.base.api.IThirdPartyPlatformCallbackService;
import com.larus.account.base.provider.IThirdPartyPlatformCallbackProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/account/base/impl/IThirdPartyPlatformCallbackImpl;", "Lcom/larus/account/base/api/IThirdPartyPlatformCallbackService;", "<init>", "()V", "onReceiveResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IThirdPartyPlatformCallbackImpl implements IThirdPartyPlatformCallbackService {
    public IThirdPartyPlatformCallbackImpl() {
    }

    @Override // com.larus.account.base.api.IThirdPartyPlatformCallbackService
    public final void onDestroy() {
        Iterator r100 = ServiceManager.get().getServices(IThirdPartyPlatformCallbackProvider.class).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IThirdPartyPlatformCallbackProvider) r100.next()).onDestroy();
        goto L4
    }

    @Override // com.larus.account.base.api.IThirdPartyPlatformCallbackService
    public final void a(int r100, int r101, Intent r102) {
        Iterator r103 = ServiceManager.get().getServices(IThirdPartyPlatformCallbackProvider.class).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((IThirdPartyPlatformCallbackProvider) r103.next()).a();
        goto L4
    }
}
