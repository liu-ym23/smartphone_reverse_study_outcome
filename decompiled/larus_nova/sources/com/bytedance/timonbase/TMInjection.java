package com.bytedance.timonbase;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TMInjection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270784a = null;

    public static Gson a() {
        return (Gson) f270784a.getValue();
    }

    static {
        f270784a = LazyKt.lazy(TMInjection$gson$2.INSTANCE);
    }
}
