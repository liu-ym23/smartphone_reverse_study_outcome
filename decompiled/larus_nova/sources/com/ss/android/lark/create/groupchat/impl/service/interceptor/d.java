package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f420227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f420228b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Boolean, Unit> r100, boolean r101) {
        this.f420227a = r100;
        this.f420228b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Function1<Boolean, Unit> r102 = this.f420227a;
        if (r102 == null) goto L5;
        r102.invoke(Boolean.valueOf(this.f420228b));
    L5:
        r100.dismiss();
    }
}
