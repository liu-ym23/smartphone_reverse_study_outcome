package com.bytedance.ee.bear.office.common.upload;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends bb5.k {
    public final /* synthetic */ Function0<Unit> a;

    public final void onPermissionDenied() {
        tt5.a.k("OfficeUploadFileSelector", "image picker permission denied");
        this.a.invoke();
    }

    public s(Function0<Unit> r1) {
        this.a = r1;
    }
}
