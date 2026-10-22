package com.ss.android.bytedcert.face;

import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements SDKCallBack.CommonRequestCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f407408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f407409b;

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
    public final void onRequestFinish(BDResponse r100) {
        if (this.f407408a.compareAndSet(true, true) == false) goto L5;
        return;
    L5:
        this.f407409b.onRequestFinish(r100);
    }

    public m(AtomicBoolean r100, v r101) {
        this.f407408a = r100;
        this.f407409b = r101;
    }
}
