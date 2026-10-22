package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.view.MessageMenu;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class i1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageMenu f303634a;

    public /* synthetic */ i1(MessageMenu r100) {
        this.f303634a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageMenu r100 = this.f303634a;
        if (r100 == null) goto L6;
        r100.f315572w = true;
        MessageMenu.c(r100, true, false, true, 2);
        return;
    }
}
