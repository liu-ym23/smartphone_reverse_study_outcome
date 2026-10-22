package com.bytedance.ies.bullet.kit.web;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends l16.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l16.c f246951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l16.c f246952b;

    public final Map<String, l16.a<?>> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("hardwareAcceleration", this.f246951a), TuplesKt.to("longClickable", this.f246952b)});
    }

    public a(Boolean r100) {
        this.f246951a = new l16.c(r100);
        this.f246952b = new l16.c(null);
    }
}
