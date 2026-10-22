package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f241189c;

    public l(e r100) {
        this.f241189c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        tt5.a.h("FolderSelectView", "on search click.");
        m.a r101 = (m.a) this.f241189c.f285682a;
        if (r101 == null) goto L6;
        r101.p();
        return;
    }
}
