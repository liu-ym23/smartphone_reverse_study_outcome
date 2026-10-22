package com.bytedance.ee.bear.office.common.upload;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ Function1<u, Unit> a;
    public final /* synthetic */ u b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function1<? super u, Unit> r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.invoke(this.b);
    }
}
