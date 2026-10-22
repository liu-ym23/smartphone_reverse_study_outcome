package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f418368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomDisplayHandler f418369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InternalSecurityAction f418370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f418371d;

    public b0(a r100, CustomDisplayHandler r101, InternalSecurityAction r102, Context r103) {
        this.f418368a = r100;
        this.f418369b = r101;
        this.f418370c = r102;
        this.f418371d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f418368a.dL(this.f418369b, this.f418370c, this.f418371d);
    }
}
