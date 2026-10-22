package com.bytedance.timon_monitor_impl.basicpipline;

import android.os.SystemClock;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.pipeline.TimonBasicModeCenter;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.a.class})
public final class a implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f270744a = 0;

    /* JADX INFO: renamed from: com.bytedance.timon_monitor_impl.basicpipline.a$a, reason: collision with other inner class name */
    public static final class C3787a {
    }

    public a() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "BasicFastPass";
    }

    static {
        Function0<Boolean> r100 = TimonBasicModeCenter.f270816a;
        f270744a = TimonBasicModeCenter.f270819d;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        if ((SystemClock.elapsedRealtime() % f270744a) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        Function0<Boolean> r101 = TimonBasicModeCenter.f270816a;
        return false;
    }
}
