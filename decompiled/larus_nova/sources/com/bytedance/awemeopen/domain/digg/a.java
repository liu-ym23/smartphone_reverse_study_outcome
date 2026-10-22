package com.bytedance.awemeopen.domain.digg;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f198285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<String> f198286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit>, Unit> f198287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f198288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super String, Unit> f198289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f198290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super q34.b, Unit> f198291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super String, Unit> f198292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super String, Unit> f198293i;

    public final Function0<String> a() {
        Function0<String> r100 = this.f198286b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("userHolder");
        return null;
    }

    public final Context getContext() {
        return this.f198285a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f198285a = r100;
    }
}
