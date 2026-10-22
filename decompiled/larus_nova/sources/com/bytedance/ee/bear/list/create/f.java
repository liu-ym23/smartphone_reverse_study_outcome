package com.bytedance.ee.bear.list.create;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f227726a;

    public f(Context r100) {
        this.f227726a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = e.f227721a;
        e.a(this.f227726a, (NetService) org.koin.java.a.c(NetService.class, null, null, 6));
    }
}
