package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes36.dex */
public final class p extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sticker f429731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StickerPageAdapter f429732b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        final Sticker r101 = this.f429731a;
        RxScheduledExecutor.execInIO(new n(this, r101), new o(this));
    }

    public p(StickerPageAdapter r100, Sticker r101) {
        this.f429732b = r100;
        this.f429731a = r101;
    }
}
