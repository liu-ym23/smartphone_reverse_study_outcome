package com.bytedance.ee.bear.sheet.borderline;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f237393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BorderStyleAdapter f237394d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BorderStyleAdapter r101 = this.f237394d;
        String[] r102 = r101.f237378a;
        String r103 = this.f237393c;
        r101.f237378a = r102;
        r101.f237379b = r103;
        r101.notifyDataSetChanged();
        BorderStyleAdapter.a r104 = this.f237394d.f237380c;
        if (r104 == null) goto L6;
        String r105 = this.f237393c;
        BorderLinePanelView r106 = ((e) r104).f237392a;
        r106.c(r105, r106.f237374g, "border");
        return;
    }

    public f(BorderStyleAdapter r100, String r101) {
        this.f237394d = r100;
        this.f237393c = r101;
    }
}
