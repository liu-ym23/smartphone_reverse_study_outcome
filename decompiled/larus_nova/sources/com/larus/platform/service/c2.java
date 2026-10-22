package com.larus.platform.service;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.model.UserSubInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c2 implements com.larus.platform.api.c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f365725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365726b = null;

    public c2() {
    }

    static {
        f365725a = new c2();
        f365726b = LazyKt.lazy(new b2());
    }

    @Override // com.larus.platform.api.c1
    public final boolean a() {
        com.larus.platform.api.c1 r100 = (com.larus.platform.api.c1) f365726b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.c1
    public final void d() {
        com.larus.platform.api.c1 r100 = (com.larus.platform.api.c1) f365726b.getValue();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.platform.api.c1
    public final LiveData<UserSubInfo> e() {
        com.larus.platform.api.c1 r100 = (com.larus.platform.api.c1) f365726b.getValue();
        if (r100 == null) goto L7;
        LiveData<UserSubInfo> r101 = r100.e();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MutableLiveData();
    }

    @Override // com.larus.platform.api.c1
    public final void b(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.larus.platform.api.c1 r102 = (com.larus.platform.api.c1) f365726b.getValue();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.c1
    public final void c(FragmentActivity r100, String r101, by7.e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("setting", "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "iTrackNode");
        com.larus.platform.api.c1 r103 = (com.larus.platform.api.c1) f365726b.getValue();
        if (r103 == null) goto L6;
        r103.c(r100, "setting", r102);
        return;
    }
}
