package com.larus.avlink.gallery.view;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f292974a;

    public /* synthetic */ e(Function0 r100) {
        this.f292974a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f292974a;
        AlbumListAdapter$Companion$DIFF_CALLBACK$1 r101 = AlbumListAdapter.f292840d;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }
}
