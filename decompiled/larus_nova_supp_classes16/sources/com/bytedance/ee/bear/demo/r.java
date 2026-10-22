package com.bytedance.ee.bear.demo;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements com.bytedance.ee.bear.middleground_permission_export.model.j {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public final void a() {
    }

    public r(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void b(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        this.a.C1("updateDocLinkShare failure: ${throwable.localizedMessage}\n");
        Log.e("CCMFolderDemo", "updateDocLinkShare failure", r3);
    }

    public final void c(int r2) {
        this.a.C1("updateDocLinkShare success: permission=$permission\n");
    }
}
