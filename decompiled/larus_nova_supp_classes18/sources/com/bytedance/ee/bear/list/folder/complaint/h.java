package com.bytedance.ee.bear.list.folder.complaint;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends t {
    public final /* synthetic */ FolderComplaintView c;

    public h(FolderComplaintView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        j.a r3 = (j.a) ((com.larksuite.framework.mvp.a) this.c).a;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r3.Z4();
        return;
    }
}
