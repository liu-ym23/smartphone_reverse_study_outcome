package com.larus.larkfeed.impl.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f355547a = 0;

    static {
    }

    public a() {
    }

    public static Object a(Function1 r100) {
        CoroutineDispatcher r101 = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "block");
        return BuildersKt.runBlocking(r101, new CoroutineUtils$runSync$1(r100, null));
    }
}
