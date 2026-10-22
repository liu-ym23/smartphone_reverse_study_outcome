package com.bytedance.navigation.kmp.handler.tracker;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e37.j f265924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f265925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f265926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f265927d;

    public final e37.j getContext() {
        return this.f265924a;
    }

    public k(e37.j r100, long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "baseParams");
        this.f265924a = r100;
        this.f265925b = r101;
        this.f265926c = r102;
    }
}
