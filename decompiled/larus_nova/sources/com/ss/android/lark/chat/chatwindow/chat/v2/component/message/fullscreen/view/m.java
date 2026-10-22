package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageFullScreenRichTextSetup f414132a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        MessageFullScreenRichTextSetup r100 = this.f414132a;
        if (r100.f414009b == true) goto L5;
        r100.f414009b = true;
    L5:
        MessageFullScreenRichTextSetup.c r101 = r100.f414011d;
        if (r101 == null) goto L12;
        ViewGroup r102 = r101.f414039e;
        if (r102 == null) goto L12;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 == null) goto L12;
        r103.removeOnPreDrawListener(this);
    L12:
        return true;
    }

    public m(MessageFullScreenRichTextSetup r100) {
        this.f414132a = r100;
    }
}
