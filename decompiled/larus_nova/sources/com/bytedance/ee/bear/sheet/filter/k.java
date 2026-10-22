package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView.SelectColorAdapter.ColorViewHolder f237859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f237860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView.SelectColorAdapter f237861e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (this.f237859c.f237709c == true) goto L10;
        String r101 = this.f237860d;
        if (r101 == null) goto L11;
        FilterPanelColorView.SelectColorAdapter r102 = this.f237861e;
        r102.f237704a = r102.f237704a;
        r102.f237705b = r101;
        r102.notifyDataSetChanged();
        FilterPanelColorView.SelectColorAdapter.a r103 = r102.f237706c;
        if (r103 == null) goto L12;
        r103.a(r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    public k(FilterPanelColorView.SelectColorAdapter.ColorViewHolder r100, String r101, FilterPanelColorView.SelectColorAdapter r102) {
        this.f237859c = r100;
        this.f237860d = r101;
        this.f237861e = r102;
    }
}
