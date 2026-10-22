package com.larus.platform.service;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t1 implements com.larus.platform.api.y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t1 f365807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365808b = null;

    public t1() {
    }

    static {
        f365807a = new t1();
        f365808b = LazyKt.lazy(new s1());
    }

    @Override // com.larus.platform.api.y2
    public final String c() {
        com.larus.platform.api.y2 r100 = (com.larus.platform.api.y2) f365808b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.y2
    public final boolean d() {
        com.larus.platform.api.y2 r100 = (com.larus.platform.api.y2) f365808b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.y2
    public final wq9.e a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.y2 r101 = (com.larus.platform.api.y2) f365808b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.platform.api.y2
    public final void b(Context r100, com.larus.bmhome.chat.map.p r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.y2 r102 = (com.larus.platform.api.y2) f365808b.getValue();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
