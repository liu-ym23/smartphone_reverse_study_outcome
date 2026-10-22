package com.bytedance.ee.bear.document.container;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements a {
    public final /* synthetic */ bk5.a a;

    @Override // com.bytedance.ee.bear.document.container.a
    public final void hideLoading() {
        this.a.hideLoading();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void onBackPressed() {
        Activity r0 = this.a.getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final Bundle sc() {
        return this.a.h9();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void showLoading() {
        this.a.showLoading();
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void w() {
        Log.e("OfficeDocumentImpl", "finishSelf...", new RuntimeException());
        this.a.w();
    }

    public e(bk5.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.document.container.a
    public final void o0(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "argument");
        Log.e("OfficeDocumentImpl", "reload...", new RuntimeException());
        this.a.o0(r4);
    }
}
