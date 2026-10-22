package com.larus.office.base.net;

import kotlin.Lazy;
import kotlin.LazyKt;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f360587a = null;

    static {
        new OkHttpClient();
        f360587a = LazyKt.lazy(new d());
    }
}
