package com.bytedance.badger.z;

import com.bytedance.badger.collect.impl.helper.MiDetectHelper;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class q0 implements MiDetectHelper.DetectCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f199487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f199488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199489c;

    public q0(r0 r100, JSONObject r101, CountDownLatch r102) {
        this.f199487a = r100;
        this.f199488b = r101;
        this.f199489c = r102;
    }

    @Override // com.bytedance.badger.collect.impl.helper.MiDetectHelper.DetectCallback
    public final void onFailure(Throwable r100) {
        r0.c(this.f199487a, this.f199488b, "", -1, "getTrustDeviceStatus# onFailure" + r100.toString());
        this.f199489c.countDown();
    }

    @Override // com.bytedance.badger.collect.impl.helper.MiDetectHelper.DetectCallback
    public final void onResult(String r100, int r101) {
        r0.c(this.f199487a, this.f199488b, r100, r101, "");
        this.f199489c.countDown();
    }
}
