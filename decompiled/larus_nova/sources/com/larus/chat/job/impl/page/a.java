package com.larus.chat.job.impl.page;

import java.util.Iterator;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatJobFragment f325141a;

    public /* synthetic */ a(ChatJobFragment r100) {
        this.f325141a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatJobFragment r100 = this.f325141a;
        Iterator<T> r101 = r100.f325066k.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((cz8.j) r101.next()).b(r100);
        goto L4
    }
}
