package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView f407072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xra.b f407073b;

    public e(AINoteGalleryView r100, xra.b r101) {
        this.f407072a = r100;
        this.f407073b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<xra.b, Unit> r101 = this.f407072a.getOnImageClick();
        if (r101 == null) goto L6;
        r101.invoke(this.f407073b);
        return;
    }
}
