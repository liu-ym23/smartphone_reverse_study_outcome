package com.bytedance.ee.bear.bitable.homepage;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f0 implements com.bytedance.ee.bear.bitable.homepage.badge.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableTabFragmentV4 f212724a;

    public f0(BitableTabFragmentV4 r100) {
        this.f212724a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.b.a
    public final void a(int r100) {
        a r101 = this.f212724a.f212208j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedTabHolder");
        r101 = null;
    L5:
        int r102 = 0;
        if (r100 <= 0) goto L8;
        boolean r103 = true;
    L9:
        r101.f212265i = r103;
        View r104 = r101.f212263g;
        if (r104 == null) goto L16;
        if (r103 == true) goto L14;
        r102 = 8;
    L14:
        r104.setVisibility(r102);
        return;
    L16:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
