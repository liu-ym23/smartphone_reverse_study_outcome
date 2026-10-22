package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView f407074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xra.b f407075b;

    public f(AINoteGalleryView r100, xra.b r101) {
        this.f407074a = r100;
        this.f407075b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<String, Unit> r101 = this.f407074a.getOnImageDelete();
        if (r101 == null) goto L6;
        r101.invoke(this.f407075b.f564919a);
        return;
    }
}
