package com.bytedance.awemeopen.domain.follow;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class FollowContinueByOpenId implements q34.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f198393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f198395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f198396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f198397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, Integer, Unit> f198398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f198399g;

    public final Context getContext() {
        return this.f198393a;
    }

    public final int getType() {
        return this.f198395c;
    }

    @Override // q34.b
    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        final d r101 = this.f198397e.f198402a;
        AoPool.a(new FollowContinueByOpenId$processed$1(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FollowContinueByOpenId(Context r100, String r101, int r102, boolean r103, a r104, Function2<? super String, ? super Integer, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, "successThen");
        this.f198393a = r100;
        this.f198394b = r101;
        this.f198395c = r102;
        this.f198396d = r103;
        this.f198397e = r104;
        this.f198398f = r105;
    }
}
