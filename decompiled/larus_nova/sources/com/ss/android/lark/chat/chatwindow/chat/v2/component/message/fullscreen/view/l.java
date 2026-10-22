package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<MessageFullScreenRichTextSetup.c> f414131a;

    public l(Function0<MessageFullScreenRichTextSetup.c> r100) {
        this.f414131a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r104 - r102) == (r108 - r106)) goto L6;
        this.f414131a.invoke();
        return;
    }
}
