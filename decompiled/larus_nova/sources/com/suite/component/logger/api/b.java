package com.suite.component.logger.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.suite.component.logger.b f460099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f460100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f460101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<f> f460102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<d> f460103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<e> f460104f;

    public abstract h a();

    public abstract b b();

    public final com.suite.component.logger.b getContext() {
        return this.f460099a;
    }

    public b(com.suite.component.logger.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f460099a = r100;
        this.f460102d = new ArrayList();
        this.f460103e = new ArrayList();
        this.f460104f = new ArrayList();
    }
}
