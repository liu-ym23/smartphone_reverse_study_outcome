package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class DocsPreloadAgentImpl<Boolean> implements IGetDataCallback<Boolean> {
    public DocsPreloadAgentImpl() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Boolean r100) {
        Iterator r101 = ((CopyOnWriteArrayList) SpacekitSdkWrapper.b.f427892a.f427890c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((gmb.a) r101.next()).getClass();
        goto L4
    }
}
