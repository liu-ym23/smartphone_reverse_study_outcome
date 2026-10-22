package com.ss.android.lark.widget.photo.preview.video.cover;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;

/* JADX INFO: loaded from: classes38.dex */
public final class j extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f447214a;

    public j(i r100) {
        this.f447214a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        i r101 = this.f447214a;
        OperateListener r102 = r101.f447208w;
        if (r102 == null) goto L6;
        r102.onOperate(r101.getContext(), "CHAT_ALBUM", this.f447214a.f447191f, true);
        return;
    }
}
