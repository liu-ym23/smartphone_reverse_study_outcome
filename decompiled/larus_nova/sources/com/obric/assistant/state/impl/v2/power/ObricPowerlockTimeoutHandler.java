package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricPowerlockTimeoutHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f393216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f393217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f393218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f393219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutexImpl f393220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f393221f;

    public final void a(String r100) {
        FLogger.f375446a.i(this.f393218c, r100.concat("ObricPowerlockTimeoutHandler"));
        BuildersKt.launch$default(this.f393219d, null, null, new ObricPowerlockTimeoutHandler$scheduleTimeout$1(this, null), 3, null);
    }

    public ObricPowerlockTimeoutHandler(String r100, long r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "onTimerFinish");
        this.f393216a = r101;
        this.f393217b = r102;
        this.f393218c = ObricPowerlockTimeoutHandler.class.getSimpleName() + '-' + r100 + hashCode();
        this.f393219d = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new g())).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f393220e = kotlinx.coroutines.sync.b.a();
    }
}
