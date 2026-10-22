package com.bytedance.ee.bear.middleground.comment.cell;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f231077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f231079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f231080d;

    public m(Function0 r100, com.bytedance.ee.bear.middleground.comment.uitls.p r101, boolean r102, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.k r103) {
        this.f231077a = r100;
        this.f231078b = r101;
        this.f231079c = r102;
        this.f231080d = r103;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function0<Unit> r101 = this.f231077a;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        this.f231078b.N.a(new ef5.k());
        if (this.f231079c == false) goto L9;
        this.f231078b.getActivity().unregisterComponentCallbacks(this.f231080d);
        return;
    }
}
