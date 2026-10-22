package com.ss.android.lark.todo.impl.flutterweb.bridge;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.Callback;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f444202a;

    public p(Callback r100) {
        this.f444202a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f444202a.success(MapsKt.mapOf(TuplesKt.to("isBottomClicked", Boolean.TRUE)));
    }
}
