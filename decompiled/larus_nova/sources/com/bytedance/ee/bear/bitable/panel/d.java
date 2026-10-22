package com.bytedance.ee.bear.bitable.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements com.bytedance.ee.bear.bitable.common.widgets.item.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitablePanelGroupView f214842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitablePanelItem f214843b;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.b
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        m r101 = this.f214842a.getItemCallback();
        if (r101 == null) goto L9;
        String r102 = this.f214843b.getId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.b(r102, r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.b
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        m r101 = this.f214842a.getItemCallback();
        if (r101 == null) goto L9;
        String r102 = this.f214843b.getId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.a(r102);
        return;
    }

    public d(BitablePanelGroupView r100, BitablePanelItem r101) {
        this.f214842a = r100;
        this.f214843b = r101;
    }
}
