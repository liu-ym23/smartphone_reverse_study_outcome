package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseRowView<View, Object>.RowAdapter f213634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f213635b;

    public b(BaseRowView<View, Object>.RowAdapter r100, int r101) {
        this.f213634a = r100;
        this.f213635b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        Function2<? super Integer, ? super Boolean, Unit> r101 = this.f213634a.f213630c;
        if (r101 == null) goto L7;
        r101.invoke(Integer.valueOf(this.f213635b), Boolean.TRUE);
        return true;
    L7:
        return true;
    }
}
