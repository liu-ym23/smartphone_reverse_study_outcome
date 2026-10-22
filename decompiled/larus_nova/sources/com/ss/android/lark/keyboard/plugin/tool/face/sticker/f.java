package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sticker f429719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceNewAdapter f429720b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        final Sticker r101 = this.f429719a;
        RxScheduledExecutor.execInIO(new d(this, r101), new e(this));
    }

    public f(FaceNewAdapter r100, Sticker r101) {
        this.f429720b = r100;
        this.f429719a = r101;
    }
}
