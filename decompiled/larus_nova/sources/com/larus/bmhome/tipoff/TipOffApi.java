package com.larus.bmhome.tipoff;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class TipOffApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314671a = 0;

    static {
    }

    public static Object a(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TipOffApi$getReportReasons$2(r100, null), r101);
    }
}
