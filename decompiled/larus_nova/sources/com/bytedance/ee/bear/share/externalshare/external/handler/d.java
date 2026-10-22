package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f237082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f237083b;

    public d(b r100, String r101) {
        this.f237082a = r100;
        this.f237083b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f237082a.a(false, this.f237083b);
        String r101 = this.f237082a.f237077b.getToken();
        int r102 = this.f237082a.f237077b.getType();
        String r103 = this.f237082a.f237077b.getSubType();
        boolean r104 = this.f237082a.f237077b.isWiki();
        String r105 = com.bytedance.ee.bear.share.d.f237013a;
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "subType");
        com.bytedance.ee.bear.share.d.d(r101, r102, r103, r104, "copy_link");
    }
}
