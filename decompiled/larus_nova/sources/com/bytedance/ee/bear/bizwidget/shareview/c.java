package com.bytedance.ee.bear.bizwidget.shareview;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f216542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ShareItemAdapter f216543d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        ShareItemAdapter r101 = this.f216543d;
        ShareItemAdapter.a r102 = r101.f216523b;
        if (r102 == null) goto L6;
        ShareItemModel r103 = (ShareItemModel) ListProtector.get(r101.f216522a, this.f216542c);
        ExternalShareView.a(((a) r102).f216541a, r103);
        return;
    }

    public c(ShareItemAdapter r100, int r101) {
        this.f216543d = r100;
        this.f216542c = r101;
    }
}
