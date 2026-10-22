package com.bytedance.timon.ruler.adapter;

import android.os.SystemClock;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timonbase.TMEnv;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RulerBasicLifecycleServiceImpl$init$1$5 extends Lambda implements Function0<Long> {
    public static final RulerBasicLifecycleServiceImpl$init$1$5 INSTANCE = null;

    static {
        INSTANCE = new RulerBasicLifecycleServiceImpl$init$1$5();
    }

    public RulerBasicLifecycleServiceImpl$init$1$5() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = TMEnv.f270767a;
        return r100 - TMEnv.f270778l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }
}
