package com.ss.cast.sink;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.api.IBindSdkInfoListener;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements IBindSdkInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBindSdkInfoListener f456440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f456441b;

    @Override // com.byted.cast.common.api.IBindSdkInfoListener
    public final void onByteCastSuccess() {
        this.f456440a.onByteCastSuccess();
        ContextManager.getMonitor(this.f456441b.H).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_INFO_SUCCESS, "");
    }

    @Override // com.byted.cast.common.api.IBindSdkInfoListener
    public final void onLelinkSuccess() {
        this.f456440a.onLelinkSuccess();
        ContextManager.getMonitor(this.f456441b.H).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_LELINK_SUCCESS, "");
    }

    public f(j r100, IBindSdkInfoListener r101) {
        this.f456441b = r100;
        this.f456440a = r101;
    }

    @Override // com.byted.cast.common.api.IBindSdkInfoListener
    public final void onByteCastFail(int r100, String r101, Exception r102) {
        this.f456440a.onByteCastFail(r100, r101, r102);
        ContextManager.getMonitor(this.f456441b.H).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_INFO_FAILURE, "errCode:" + r100 + ", errMsg:" + r101 + ", e:" + r102);
    }

    @Override // com.byted.cast.common.api.IBindSdkInfoListener
    public final void onLelinkFail(int r100, String r101, Exception r102) {
        this.f456440a.onLelinkFail(r100, r101, r102);
        ContextManager.getMonitor(this.f456441b.H).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_LELINK_FAILURE, "errCode:" + r100 + ", errMsg:" + r101 + ", e:" + r102);
    }
}
