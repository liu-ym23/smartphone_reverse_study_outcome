package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.awemeopen.infra.base.image.a {
    public final /* synthetic */ b a;

    public final void onSuccess() {
    }

    public final void onFail() {
        final String r0 = this.a.m();
        if (r0 == null) goto L6;
        final b r1 = this.a;
        new Handler().post(new c(r1, r0));
        return;
    }

    public d(b r1) {
        this.a = r1;
    }
}
