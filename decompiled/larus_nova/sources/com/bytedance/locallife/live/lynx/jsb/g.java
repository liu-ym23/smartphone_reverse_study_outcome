package com.bytedance.locallife.live.lynx.jsb;

import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f260568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f260569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f260570c;

    public g(i r100, String r101, String r102) {
        this.f260568a = r100;
        this.f260569b = r101;
        this.f260570c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f260568a.f260576c.c(this.f260569b, CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("id", this.f260570c), TuplesKt.to("data", (Map) r100)})));
    }
}
