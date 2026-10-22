package com.bytedance.locallife.photo.photopage.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiDuxPopoverEntranceMenuView.b f262342a;

    public n(PoiDuxPopoverEntranceMenuView.b r100) {
        this.f262342a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super View, Unit> r101 = this.f262342a.f262321d;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }
}
