package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceNewAdapter f429715a;

    public c(FaceNewAdapter r100) {
        this.f429715a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        FaceNewAdapter.c r101 = this.f429715a.f429664g;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
