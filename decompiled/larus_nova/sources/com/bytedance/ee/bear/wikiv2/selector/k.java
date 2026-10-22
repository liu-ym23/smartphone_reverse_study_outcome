package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f241188c;

    public k(e r100) {
        this.f241188c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        tt5.a.h("FolderSelectView", "on back click.");
        m.a r101 = (m.a) this.f241188c.f285682a;
        if (r101 == null) goto L6;
        r101.Z3();
        return;
    }
}
