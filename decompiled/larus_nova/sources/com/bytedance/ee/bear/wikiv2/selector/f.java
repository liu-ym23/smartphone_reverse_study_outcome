package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ e f241183k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        tt5.a.h("FolderSelectView", "on create click.");
        m.a r101 = (m.a) this.f241183k.f285682a;
        if (r101 == null) goto L6;
        r101.M7();
        return;
    }

    public f(e r100, int r101) {
        this.f241183k = r100;
        super(r101);
    }
}
