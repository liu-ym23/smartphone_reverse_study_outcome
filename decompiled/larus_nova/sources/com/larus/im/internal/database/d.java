package com.larus.im.internal.database;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f347921a = null;

    static {
        f347921a = LazyKt.lazy(new c());
    }

    public static final Object a(Function1 r100, Continuation r101) {
        return BuildersKt.withContext((CoroutineDispatcher) f347921a.getValue(), new IMDatabaseKt$withTransactionAB$2(r100, null), r101);
    }
}
