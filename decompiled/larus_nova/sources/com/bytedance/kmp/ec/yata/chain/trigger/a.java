package com.bytedance.kmp.ec.yata.chain.trigger;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f251305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f251306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f251307c;

    public abstract a a();

    public abstract Map<String, Object> b();

    public a(Map<String, Object> r100, Map<String, ? extends Object> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bizParams");
        Intrinsics.checkNotNullParameter(r101, "requestParams");
        Intrinsics.checkNotNullParameter(r102, "customParams");
        this.f251305a = r100;
        this.f251306b = r101;
        this.f251307c = r102;
    }
}
