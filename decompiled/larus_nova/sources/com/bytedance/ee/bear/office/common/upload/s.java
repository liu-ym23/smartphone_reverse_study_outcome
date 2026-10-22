package com.bytedance.ee.bear.office.common.upload;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class s extends bb5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f235418a;

    @Override // bb5.f
    public final void onPermissionDenied() {
        tt5.a.k("OfficeUploadFileSelector", "image picker permission denied");
        this.f235418a.invoke();
    }

    public s(Function0<Unit> r100) {
        this.f235418a = r100;
    }
}
