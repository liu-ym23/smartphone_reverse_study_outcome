package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyCatLynxActivity f271231a;

    public f(LuckyCatLynxActivity r100) {
        this.f271231a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f271231a.onBackPressed();
    }
}
