package com.bytedance.awemeopen.domain.mix;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f198422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Function1<? super String, Unit>, Unit> f198423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f198424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super q34.b, Unit> f198425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super String, Unit> f198426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super String, Unit> f198427f;

    public final Context getContext() {
        return this.f198422a;
    }

    public c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f198422a = r100;
    }
}
