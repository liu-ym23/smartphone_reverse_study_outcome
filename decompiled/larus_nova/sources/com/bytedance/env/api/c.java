package com.bytedance.env.api;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, EnvType> f243175a = null;

    static {
        f243175a = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, EnvType.PRODUCT), TuplesKt.to(1, EnvType.CANARY), TuplesKt.to(2, EnvType.PPE), TuplesKt.to(3, EnvType.BOE)});
    }
}
