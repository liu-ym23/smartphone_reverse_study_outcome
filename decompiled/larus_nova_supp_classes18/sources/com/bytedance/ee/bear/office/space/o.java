package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ OfficeSpaceTabLayout a;
    public final /* synthetic */ OfficeSpaceTab b;

    public o(OfficeSpaceTabLayout r1, OfficeSpaceTab r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1<? super OfficeSpaceTab, Unit> r3 = this.a.c;
        if (r3 == null) goto L6;
        r3.invoke(this.b);
        return;
    }
}
