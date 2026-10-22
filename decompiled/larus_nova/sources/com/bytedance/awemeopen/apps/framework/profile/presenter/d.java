package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.os.Handler;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements com.bytedance.awemeopen.infra.base.image.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f197417a;

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onSuccess() {
    }

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onFail() {
        final String r100 = this.f197417a.m();
        if (r100 == null) goto L6;
        final b r101 = this.f197417a;
        new Handler().post(new c(r101, r100));
        return;
    }

    public d(b r100) {
        this.f197417a = r100;
    }
}
