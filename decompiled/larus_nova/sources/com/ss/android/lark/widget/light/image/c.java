package com.ss.android.lark.widget.light.image;

import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f446089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LKUIRoundedImageView2 f446090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.b f446091c;

    public c(a r100, LKUIRoundedImageView2 r101, a.b r102) {
        this.f446089a = r100;
        this.f446090b = r101;
        this.f446091c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        a.c r101 = this.f446089a.f446081f;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.b(this.f446090b, this.f446091c) != true) goto L7;
        return true;
    }
}
