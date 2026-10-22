package com.ss.android.account;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PassportExtraHeaderManager f406249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f406250b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        super.onChange(r100, r101);
        tb7.a.a("PassportExtraHeaderManager", "PassportExtraHeaderManager.onChange: uri=" + r101);
        if (r100 == false) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(String.valueOf(r101), this.f406250b.toString())) == true) goto L10;
        this.f406249a.f406213a.clear();
        this.f406249a.e();
        return;
    }

    public g(PassportExtraHeaderManager r100, Uri r101, Handler r102) {
        this.f406249a = r100;
        this.f406250b = r101;
        super(r102);
    }
}
