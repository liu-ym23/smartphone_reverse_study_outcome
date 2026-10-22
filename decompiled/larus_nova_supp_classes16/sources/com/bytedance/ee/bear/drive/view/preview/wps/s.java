package com.bytedance.ee.bear.drive.view.preview.wps;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements e {
    public final WpsView a;
    public LifecycleOwner b;
    public final boolean c;

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final String g() {
        return "";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void onDetachedFromWindow() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final WpsMainOptions f() {
        WpsMainOptions r0 = new WpsMainOptions();
        b r1 = this.a.t;
        if (r1.b == false) goto L8;
        if (this.c == false) goto L8;
        r0.excelOptions = new r();
    L8:
        if (r1.a == false) goto L10;
        String r2 = "normal";
    L11:
        r0.mode = r2;
        r0.hiddenCommandBarOptions = q.a;
        return r0;
    L10:
        r2 = WpsMainOptions.OPEN_MODE_SIMPLE;
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void d(Throwable r2) {
        this.a.m(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.e
    public final void e(ViewOwner r2) {
        this.b = r2.lifecycleOwner();
        PreviewViewModel r3 = (PreviewViewModel) r2.viewModel(PreviewViewModel.class);
    }

    public s(WpsView r1, boolean r2) {
        this.a = r1;
        this.c = r2;
    }
}
