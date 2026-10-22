package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f263188b;

    public h(PoiCoiDynamicView r100, Function1 r101) {
        this.f263187a = r100;
        this.f263188b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263187a) == false) goto L5;
        return;
    L5:
        View r101 = this.f263187a;
        this.f263188b.invoke(r101);
    }
}
