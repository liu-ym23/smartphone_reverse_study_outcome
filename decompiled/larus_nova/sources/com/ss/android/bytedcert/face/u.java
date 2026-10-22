package com.ss.android.bytedcert.face;

import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;

/* JADX INFO: loaded from: classes34.dex */
public final class u implements SDKCallBack.CommonRequestCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder.c f407431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407432b;

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
    public final void onRequestFinish(BDResponse r100) {
        this.f407432b.f407330d.hideLoading();
        this.f407432b.b(this.f407431a, r100);
    }

    public u(FaceDetectionRecorder r100, FaceDetectionRecorder.c r101) {
        this.f407432b = r100;
        this.f407431a = r101;
    }
}
