package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility;

import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements SceneCoordinateRecyclerView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageVisibleManager f414318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SceneCoordinateRecyclerView f414319b;

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView.a
    public final void onAttachedToWindow() {
        MessageVisibleManager$1$1 r100 = this.f414318a.f414310f;
        if (r100 == null) goto L6;
        this.f414319b.addOnScrollListener(r100);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView.a
    public final void onDetachedFromWindow() {
        MessageVisibleManager$1$1 r100 = this.f414318a.f414310f;
        if (r100 == null) goto L6;
        this.f414319b.removeOnScrollListener(r100);
        return;
    }

    public a(MessageVisibleManager r100, SceneCoordinateRecyclerView r101) {
        this.f414318a = r100;
        this.f414319b = r101;
    }
}
