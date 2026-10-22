package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f228602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f228603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ListStyleAdapter f228604e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        j r101 = this.f228604e.f228482c;
        if (r101 == null) goto L5;
        r101.B0(r100, this.f228602c, this.f228603d, false);
    L5:
        this.f228604e.D2();
    }

    public i(ListStyleAdapter r100, int r101, Document r102) {
        this.f228604e = r100;
        this.f228602c = r101;
        this.f228603d = r102;
    }
}
