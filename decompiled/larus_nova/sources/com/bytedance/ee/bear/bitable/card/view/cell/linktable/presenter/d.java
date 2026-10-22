package com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter;

import com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTableCellValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements tp4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f207873a;

    @Override // tp4.f
    public final void e(LinkTableCellValue r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public d(a r100) {
        this.f207873a = r100;
    }

    @Override // tp4.f
    public final void c(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f207873a.h(r100);
    }

    @Override // tp4.f
    public final void d(rp4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f207873a.g(r100);
    }
}
