package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f271279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Integer, Unit> f271281c;

    /* JADX WARN: Multi-variable type inference failed */
    public l(int r100, Function1<? super Integer, Unit> r101) {
        this.f271280b = r100;
        this.f271281c = r101;
        this.f271279a = new LinkedHashMap();
    }
}
