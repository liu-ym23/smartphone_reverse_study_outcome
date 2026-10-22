package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.ArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes37.dex */
public final class CoreDependencyImpl implements pmb.d {
    @Override // pmb.d
    public final void b() {
    }

    @Override // pmb.d
    public final void c() {
    }

    @Override // pmb.d
    public final void d() {
    }

    @Override // pmb.d
    public final void g() {
    }

    @Override // pmb.d
    public final void getProfile() {
    }

    @Override // pmb.d
    public final void h() {
    }

    @Override // pmb.d
    public final void i() {
    }

    @Override // pmb.d
    public final void j() {
    }

    @Override // pmb.d
    public final void l() {
    }

    @Override // pmb.d
    public final void m() {
    }

    @Override // pmb.d
    public final void p() {
    }

    @Override // pmb.d
    public final void q() {
    }

    @Override // pmb.d
    public final void r() {
    }

    @Override // pmb.d
    public final long a() {
        return cac.b.a.f22984a.a(30000);
    }

    @Override // pmb.d
    public final qpc.e f() {
        return (qpc.e) ApiUtils.getApi(qpc.e.class);
    }

    @Override // pmb.d
    public final ArrayList n() {
        return new ArrayList();
    }

    @Inject
    public CoreDependencyImpl() {
    }

    @Override // pmb.d
    public final void o(com.ss.android.lark.integrator.im.chat.core.dependency.r.a r100) {
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).addPushResourceUploadProgressListener(r100);
    }

    @Override // pmb.d
    public final void removePushResourceUploadProgressListener(qpc.d r100) {
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).removePushResourceUploadProgressListener(r100);
    }

    @Override // pmb.d
    public final void e(final Context r100, final ProfileSource r101) {
        final IGetDataCallback<ProfileSource> r102 = new AnonymousClass1(this, r100);
        RxScheduledExecutor.execInIO(new d(r101), new e(r102));
    }

    @Override // pmb.d
    public final boolean k(Context r100, String r101) {
        return ova.f.m().i(r100, r101, 0);
    }

    @Override // pmb.d
    public final void s(Context r100, String r101) {
        ova.f.m().y(r100, r101, 0);
    }
}
