package com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements gv4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f207872a;

    public c(a r100) {
        this.f207872a = r100;
    }

    @Override // gv4.a
    public final void a(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        m r101 = this.f207872a.f207865i;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
