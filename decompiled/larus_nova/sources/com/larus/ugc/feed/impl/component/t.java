package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationFeedComponent f374714a;

    public /* synthetic */ t(CreationFeedComponent r100) {
        this.f374714a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CreationFeedComponent r100 = this.f374714a;
        RecyclerView r101 = r100.f374648o.a();
        if (r101 == null) goto L7;
        r100.Q3(r101, false, false);
        return;
    }
}
