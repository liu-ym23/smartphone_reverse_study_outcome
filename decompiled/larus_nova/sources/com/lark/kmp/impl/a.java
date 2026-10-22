package com.lark.kmp.impl;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineDispatcher f278589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineDispatcher f278590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MainCoroutineDispatcher f278591c = null;

    static {
        f278589a = Dispatchers.getDefault().limitedParallelism(1);
        f278590b = Dispatchers.getDefault();
        f278591c = Dispatchers.getMain();
    }
}
