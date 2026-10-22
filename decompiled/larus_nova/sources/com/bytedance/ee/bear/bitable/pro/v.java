package com.bytedance.ee.bear.bitable.pro;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f215249a;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Function1<? super Boolean, Unit> r100) {
        this.f215249a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f215249a.invoke(Boolean.FALSE);
    }
}
