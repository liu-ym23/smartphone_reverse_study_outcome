package com.ss.android.lark.locationmessage.message;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationMessageCell.LocationMessageViewHolder f431319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v5b.c f431320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LocationMessageCell f431321c;

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        r5b.b<LocationContentVO> r101 = this.f431321c.f431299b;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.d(this.f431319a.f431305a, this.f431320b);
    }

    public e(LocationMessageCell r100, LocationMessageCell.LocationMessageViewHolder r101, v5b.c r102) {
        this.f431321c = r100;
        this.f431319a = r101;
        this.f431320b = r102;
    }
}
