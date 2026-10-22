package com.bytedance.ee.bear.office.common.upload;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<u, Unit> f235439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f235440b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function1<? super u, Unit> r100, u r101) {
        this.f235439a = r100;
        this.f235440b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f235439a.invoke(this.f235440b);
    }
}
