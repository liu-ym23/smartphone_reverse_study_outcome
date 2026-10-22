package com.bytedance.ee.bear.office.common.upload;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends bb5.k {
    public final /* synthetic */ Function0<Unit> a;

    public final void onPermissionDenied() {
        tt5.a.k("OfficeUploadFileSelector", "file picker permission denied");
        this.a.invoke();
    }

    public q(Function0<Unit> r1) {
        this.a = r1;
    }
}
