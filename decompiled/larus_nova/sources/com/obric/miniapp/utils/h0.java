package com.obric.miniapp.utils;

import android.content.DialogInterface;
import com.obric.oui.sheet.v2.OSheet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes33.dex */
public final class h0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSheet f398485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f398486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f398487c;

    public h0(OSheet r100, AtomicBoolean r101, g r102) {
        this.f398485a = r100;
        this.f398486b = r101;
        this.f398487c = r102;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        a0.t(this.f398486b, this.f398487c, null);
        a0 r101 = a0.f398434a;
        OSheet r102 = this.f398485a;
        r101.getClass();
        a0.i(r102);
    }
}
