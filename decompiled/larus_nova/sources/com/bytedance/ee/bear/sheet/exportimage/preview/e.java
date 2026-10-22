package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237585a;

    public e(SheetImagePreviewFragment r100) {
        this.f237585a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SheetImagePreviewFragment r101 = this.f237585a;
        r101.f237542n = Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
    }
}
