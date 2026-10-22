package com.bytedance.android.window.shop.search.presenter;

import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements WindowHistoryBanner.b {
    public final /* synthetic */ WindowSearchHistoryPresenter a;

    public final void a() {
        ECWindowHistoryView r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final void b() {
        ECWindowHistoryView r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final void c() {
        ECWindowHistoryView r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public c(WindowSearchHistoryPresenter r1) {
        this.a = r1;
    }
}
