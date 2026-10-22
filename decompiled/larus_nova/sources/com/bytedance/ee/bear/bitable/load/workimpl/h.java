package com.bytedance.ee.bear.bitable.load.workimpl;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends com.bytedance.ee.bear.bitable.plugin.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f214576a;

    public h(f r100) {
        this.f214576a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.d
    public final void a(DocumentPluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        zt4.f r102 = (zt4.f) this.f214576a.f214440a.e(zt4.f.class);
        f r103 = this.f214576a;
        if (r102 == null) goto L5;
        BitableResourceData r104 = r102.f573591f;
    L6:
        f.n(r103, r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
