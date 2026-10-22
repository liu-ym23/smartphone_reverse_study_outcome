package com.bytedance.ee.bear.list.folder.complaint;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FolderComplaintView f228097c;

    public h(FolderComplaintView r100) {
        this.f228097c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        j.a r101 = (j.a) this.f228097c.f285682a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.Z4();
        return;
    }
}
