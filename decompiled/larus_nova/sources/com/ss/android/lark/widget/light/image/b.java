package com.ss.android.lark.widget.light.image;

import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f446086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LKUIRoundedImageView2 f446087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.b f446088c;

    public b(a r100, LKUIRoundedImageView2 r101, a.b r102) {
        this.f446086a = r100;
        this.f446087b = r101;
        this.f446088c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a.c r101 = this.f446086a.f446081f;
        if (r101 == null) goto L6;
        r101.a(this.f446087b, this.f446088c);
        return;
    }
}
