package com.lynx.tasm.fontface;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements e8a.a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f383413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f383414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxContext f383415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f383416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FontFaceManager f383417e;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        byte[] r101 = r100.f383709b;
        if (r101 == null) goto L7;
        this.f383413a.set(r101);
    L8:
        this.f383416d.countDown();
        return;
    L7:
        FontFaceManager r102 = this.f383417e;
        String r103 = "Load font with genericResourceFetcher failed:" + r100.f383710c.getMessage();
        String r104 = this.f383414b;
        LynxContext r105 = this.f383415c;
        r102.getClass();
        FontFaceManager.n(30202, r103, r104, null, r105);
        goto L8
    }

    public b(FontFaceManager r100, AtomicReference r101, String r102, LynxContext r103, CountDownLatch r104) {
        this.f383417e = r100;
        this.f383413a = r101;
        this.f383414b = r102;
        this.f383415c = r103;
        this.f383416d = r104;
    }
}
