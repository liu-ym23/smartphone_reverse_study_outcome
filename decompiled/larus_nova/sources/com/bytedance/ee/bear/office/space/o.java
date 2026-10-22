package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceTabLayout f236124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceTab f236125b;

    public o(OfficeSpaceTabLayout r100, OfficeSpaceTab r101) {
        this.f236124a = r100;
        this.f236125b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super OfficeSpaceTab, Unit> r101 = this.f236124a.f236082c;
        if (r101 == null) goto L6;
        r101.invoke(this.f236125b);
        return;
    }
}
