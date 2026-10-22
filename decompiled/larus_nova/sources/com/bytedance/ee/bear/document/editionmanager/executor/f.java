package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f219620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BearUrl f219621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sbb.e f219622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219623d;

    public /* synthetic */ f(k r100, BearUrl r101, sbb.e r102) {
        this.f219620a = r100;
        this.f219621b = r101;
        this.f219622c = r102;
        this.f219623d = "";
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f219620a;
        BearUrl r101 = this.f219621b;
        sbb.e r102 = this.f219622c;
        String r103 = this.f219623d;
        r100.getClass();
        r100.a(r101.f222561b, r102.f541317b, r103, new j());
    }
}
