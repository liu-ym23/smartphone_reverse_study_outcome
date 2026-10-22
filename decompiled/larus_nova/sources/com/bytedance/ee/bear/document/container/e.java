package com.bytedance.ee.bear.document.container;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bk5.a f219398a;

    @Override // com.bytedance.ee.bear.document.container.a
    public final void hideLoading() {
        this.f219398a.hideLoading();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void onBackPressed() {
        Activity r100 = this.f219398a.getActivity();
        if (r100 == null) goto L6;
        r100.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final Bundle sc() {
        return this.f219398a.h9();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void showLoading() {
        this.f219398a.showLoading();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void w() {
        Log.e("OfficeDocumentImpl", "finishSelf...", new RuntimeException());
        this.f219398a.w();
    }

    public e(bk5.a r100) {
        this.f219398a = r100;
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void o0(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        Log.e("OfficeDocumentImpl", "reload...", new RuntimeException());
        this.f219398a.o0(r100);
    }
}
