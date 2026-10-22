package com.bytedance.awemeopen.domain.user;

import com.bytedance.awemeopen.bizmodels.user.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f198494a;

    public h(com.bytedance.awemeopen.apps.framework.framework.viewpager.helper.a r100) {
        this.f198494a = r100;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void a(com.bytedance.awemeopen.bizmodels.user.i r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        j r101 = this.f198494a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void onFail(Exception r100) {
        j r101 = this.f198494a;
        if (r101 == null) goto L6;
        r101.onFail(r100);
        return;
    }
}
