package com.ss.android.lark.blueprint;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f410650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vza.e f410651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vza.d f410652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vza.c f410653d;

    public final Context getContext() {
        return this.f410650a;
    }

    public g(Context r100, vza.e r101, vza.d r102, vza.a r103, vza.b r104, vza.c r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r102, "envs");
        Intrinsics.checkNotNullParameter(r103, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r104, "additions");
        Intrinsics.checkNotNullParameter(r105, "blockViewCachePool");
        this.f410650a = r100;
        this.f410651b = r101;
        this.f410652c = r102;
        this.f410653d = r105;
    }
}
