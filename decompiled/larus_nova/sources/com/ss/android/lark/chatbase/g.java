package com.ss.android.lark.chatbase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePageStore f416866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Collection f416867b;

    public /* synthetic */ g(BasePageStore r100, Collection r101) {
        this.f416866a = r100;
        this.f416867b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePageStore r100 = this.f416866a;
        Collection r101 = this.f416867b;
        r100.getClass();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(new s3b.b((f5b.b) r103.next()));
        goto L4
    L6:
        r100.m(r102);
    }
}
