package com.bytedance.ee.bear.list.create;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f227727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f227728b;

    public g(FragmentActivity r100, m r101) {
        this.f227727a = r100;
        this.f227728b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = e.f227721a;
        e.a(this.f227727a, (NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        e.b(this.f227728b, "notify_admin");
    }
}
