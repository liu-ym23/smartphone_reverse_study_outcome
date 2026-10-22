package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/utils/GsonUtil;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class GsonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GsonUtil f450371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Gson f450372b;

    static {
        f450371a = new GsonUtil();
    }

    private GsonUtil() {
    }

    public static Gson b() {
        if (f450372b != null) goto L5;
        f450372b = new Gson();
    L5:
        Gson r100 = f450372b;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public static Object a(String r100, Type r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(b().fromJson(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        return null;
    L12:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
