package com.bytedance.locallife.live.lynx.jsb;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f260571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f260572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f260573c;

    public h(i r100, String r101, String r102) {
        this.f260571a = r100;
        this.f260572b = r101;
        this.f260573c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof CronetIOException) == false) goto L8;
        CronetIOException r102 = (CronetIOException) r101;
        if (r102.getStatusCode() == 0) goto L7;
        int r103 = r102.getStatusCode();
    L9:
        this.f260571a.f260576c.c(this.f260572b, CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("id", this.f260573c), TuplesKt.to("errorCode", Integer.valueOf(r103))})));
        return;
    L7:
        r103 = r102.getCronetInternalErrorCode();
        goto L9
    L8:
        r103 = -1;
        goto L9
    }
}
