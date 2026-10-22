package com.larus.media;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f359143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f359144b;

    public /* synthetic */ t(Function1 r100, String r101) {
        this.f359143a = r100;
        this.f359144b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1 r100 = this.f359143a;
        String r101 = this.f359144b;
        if (r100 == null) goto L6;
        r100.invoke(r101);
        return;
    }
}
