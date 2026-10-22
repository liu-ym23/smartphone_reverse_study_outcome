package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseRowView<View, Object>.RowAdapter f213632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f213633b;

    public a(BaseRowView<View, Object>.RowAdapter r100, int r101) {
        this.f213632a = r100;
        this.f213633b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function2<? super Integer, ? super Boolean, Unit> r101 = this.f213632a.f213630c;
        if (r101 == null) goto L6;
        r101.invoke(Integer.valueOf(this.f213633b), Boolean.FALSE);
        return;
    }
}
