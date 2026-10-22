package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f228599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f228600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ListStyleAdapter f228601e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        j r101 = this.f228601e.f228482c;
        if (r101 == null) goto L5;
        r101.Y(r100, this.f228599c, this.f228600d, false);
    L5:
        this.f228601e.D2();
    }

    public h(ListStyleAdapter r100, int r101, Document r102) {
        this.f228601e = r100;
        this.f228599c = r101;
        this.f228600d = r102;
    }
}
