package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;

/* JADX INFO: loaded from: classes6.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public eta.b f408153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j0 f408154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f408155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppLog.f f408156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f408157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f408158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m0 f408159g;

    public final h0 a() {
        l0.a(this.f408157e, PerfLog.PARAM_KEY_CONTEXT_ID);
        l0.a(this.f408159g, "urlConfig");
        l0.a(this.f408153a, "appContext");
        return new h0(this.f408153a, this.f408154b, this.f408155c, this.f408156d, this.f408157e, this.f408158f, this.f408159g, this);
    }

    public i0() {
    }
}
