package com.bytedance.ee.bear.middleground.comment.cell;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f231047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231048b;

    public d(Function0<Unit> r100, com.bytedance.ee.bear.middleground.comment.uitls.p r101) {
        this.f231047a = r100;
        this.f231048b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function0<Unit> r101 = this.f231047a;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        this.f231048b.N.a(new ef5.k());
    }
}
