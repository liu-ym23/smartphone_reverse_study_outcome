package com.bytedance.ee.bear.office.common.upload;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class q extends bb5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f235414a;

    @Override // bb5.f
    public final void onPermissionDenied() {
        tt5.a.k("OfficeUploadFileSelector", "file picker permission denied");
        this.f235414a.invoke();
    }

    public q(Function0<Unit> r100) {
        this.f235414a = r100;
    }
}
