package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f263190b;

    public i(PoiCoiDynamicView r100, Function1 r101) {
        this.f263189a = r100;
        this.f263190b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263189a) == false) goto L5;
        return;
    L5:
        View r101 = this.f263189a;
        this.f263190b.invoke(r101);
    }
}
