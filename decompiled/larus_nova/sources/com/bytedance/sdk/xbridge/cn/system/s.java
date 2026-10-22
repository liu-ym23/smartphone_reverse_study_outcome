package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class s implements OnPermissionGrantCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f270235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<e.c> f270236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f270237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f270238d;

    public static final class a implements re7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f270239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f270240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f270241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<e.c> f270242d;

        @Override // re7.e
        public final void a(re7.f r100) {
            Intrinsics.checkNotNullParameter(r100, "locationResult");
            com.bytedance.sdk.xbridge.cn.utils.i.a(this.f270239a.f270184a, "location permission all granted,enable:" + this.f270240b + ",location:" + r100, this.f270241c.getContainerID());
            e.c r101 = (e.c) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class));
            r101.setEnable(Boolean.valueOf(this.f270240b));
            r101.setLongitude(Double.valueOf(r100.f537450b));
            r101.setLatitude(Double.valueOf(r100.f537449a));
            CompletionBlock.DefaultImpls.onSuccess$default(this.f270242d, r101, null, 2, null);
        }

        @Override // re7.e
        public final void onFail(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            com.bytedance.sdk.xbridge.cn.utils.i.a(this.f270239a.f270184a, "get location result is null,enable:" + this.f270240b, this.f270241c.getContainerID());
            e.c r101 = (e.c) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class));
            r101.setEnable(Boolean.valueOf(this.f270240b));
            r101.setLongitude(null);
            r101.setLatitude(null);
            CompletionBlock.DefaultImpls.onSuccess$default(this.f270242d, r101, null, 2, null);
        }

        public a(t r100, boolean r101, IBDXBridgeContext r102, CompletionBlock<e.c> r103) {
            this.f270239a = r100;
            this.f270240b = r101;
            this.f270241c = r102;
            this.f270242d = r103;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
    public final void onAllGranted() {
        int r100 = ae7.h.f3113a;     // Catch: Exception -> L8
        boolean r101 = ae7.h.k(this.f270235a.getApplicationContext());     // Catch: Exception -> L8
        XBaseRuntime.f270095a.getClass();     // Catch: Exception -> L8
        com.bytedance.sdk.xbridge.cn.runtime.depend.g r102 = XBaseRuntime.f270111q;     // Catch: Exception -> L8
        if (r102 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(this.f270236b, 0, "HostSystemActionDepend is null", null, 4, null);     // Catch: Exception -> L8
        return;
    L6:
        com.bytedance.sdk.xbridge.cn.utils.i.a(this.f270237c.f270184a, "location permission all granted", this.f270238d.getContainerID());     // Catch: Exception -> L8
        r102.d(this.f270235a.getApplicationContext(), new a(this.f270237c, r101, this.f270238d, this.f270236b));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.sdk.xbridge.cn.utils.i.a(this.f270237c.f270184a, "get location err:" + e.getMessage(), this.f270238d.getContainerID());
        CompletionBlock.DefaultImpls.onFailure$default(this.f270236b, 0, "get location err:" + e.getMessage(), null, 4, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
    public final void onNotGranted() {
        e.c r100 = (e.c) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class));
        r100.setEnable(Boolean.FALSE);
        r100.setLongitude(null);
        r100.setLatitude(null);
        CompletionBlock.DefaultImpls.onSuccess$default(this.f270236b, r100, null, 2, null);
    }

    public s(Activity r100, CompletionBlock<e.c> r101, t r102, IBDXBridgeContext r103) {
        this.f270235a = r100;
        this.f270236b = r101;
        this.f270237c = r102;
        this.f270238d = r103;
    }
}
