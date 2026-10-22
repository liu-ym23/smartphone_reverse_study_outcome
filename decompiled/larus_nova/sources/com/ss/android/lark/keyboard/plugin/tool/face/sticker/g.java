package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FacePageNewFragment2 f429721a;

    public g(FacePageNewFragment2 r100) {
        this.f429721a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        new com.ss.android.lark.widget.photopicker.e(new com.ss.android.lark.widget.photopicker.s(new com.ss.android.lark.widget.photopicker.s.a())).b(this.f429721a.requireContext(), this.f429721a, 1024);
    }
}
