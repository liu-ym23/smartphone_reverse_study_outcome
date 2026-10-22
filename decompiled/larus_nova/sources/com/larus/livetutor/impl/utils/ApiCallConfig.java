package com.larus.livetutor.impl.utils;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
public final class ApiCallConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Continuation<? super Unit>, ? extends Object> f356637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> f356638b;

    public ApiCallConfig() {
        this.f356637a = new ApiCallConfig$apiCall$1(null);
        this.f356638b = new ApiCallConfig$failureCallback$1(null);
    }
}
