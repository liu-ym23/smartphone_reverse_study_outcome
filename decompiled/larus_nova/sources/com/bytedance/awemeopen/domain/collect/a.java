package com.bytedance.awemeopen.domain.collect;

import android.content.Context;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f198245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<String> f198246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit>, Unit> f198247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super q34.b, Unit> f198248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function4<? super String, ? super Integer, ? super String, ? super Boolean, ? extends com.bytedance.awemeopen.domain.base.repo.e<d>> f198249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super AoCodeResult<String>, Unit> f198250f;

    public final Context getContext() {
        return this.f198245a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f198245a = r100;
    }
}
