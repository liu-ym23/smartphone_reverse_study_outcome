package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f228596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f228597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ListStyleAdapter f228598e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        j r101 = this.f228598e.f228482c;
        if (r101 == null) goto L5;
        r101.P(r100, this.f228596c, this.f228597d);
    L5:
        this.f228598e.D2();
    }

    public g(ListStyleAdapter r100, int r101, Document r102) {
        this.f228598e = r100;
        this.f228596c = r101;
        this.f228597d = r102;
    }
}
