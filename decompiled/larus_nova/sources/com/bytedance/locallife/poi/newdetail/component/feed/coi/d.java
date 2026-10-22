package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f263179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f263180b;

    public d(Function1 r100, PoiCoiDynamicView r101) {
        this.f263179a = r100;
        this.f263180b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        Function1<View, Unit> r101 = this.f263179a;
        if (r101 == null) goto L5;
        r101.invoke(this.f263180b);
        return true;
    L5:
        return false;
    }
}
