package com.obric.assistant.state.impl.v2.core;

import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import com.obric.assistant.state.impl.v2.utils.j;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
public final class ObricStateDispatcher implements cha.c, cha.b, cha.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricStateDispatcher f393177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Set<cha.c>> f393178b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<cha.c> f393179c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArraySet<cha.b> f393180d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArraySet<cha.a> f393181e = null;

    public ObricStateDispatcher() {
    }

    static {
        f393177a = new ObricStateDispatcher();
        f393178b = new ConcurrentHashMap();
        f393179c = new CopyOnWriteArraySet();
        f393180d = new CopyOnWriteArraySet();
        f393181e = new CopyOnWriteArraySet();
    }

    @Override // cha.b
    public final void a(ObricAssistantAliveLockState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ObricStateDispatcher$onAssistantAliveStateChanged$1 r101 = new ObricStateDispatcher$onAssistantAliveStateChanged$1(r100, null);
        Lazy r102 = j.f393225a;
        Intrinsics.checkNotNullParameter(r101, "block");
        BuildersKt.launch$default((CoroutineScope) j.f393225a.getValue(), null, null, r101, 3, null);
    }

    @Override // cha.c
    public final void c(ObricState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ObricStateDispatcher$onObricStateChanged$1 r101 = new ObricStateDispatcher$onObricStateChanged$1(r100, null);
        Lazy r102 = j.f393225a;
        Intrinsics.checkNotNullParameter(r101, "block");
        BuildersKt.launch$default((CoroutineScope) j.f393228d.getValue(), null, null, r101, 3, null);
    }

    @Override // cha.b
    public final void d(ObricNetworkKeepAliveLockState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1 r101 = new ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1(r100, null);
        Lazy r102 = j.f393225a;
        Intrinsics.checkNotNullParameter(r101, "block");
        BuildersKt.launch$default((CoroutineScope) j.f393228d.getValue(), null, null, r101, 3, null);
    }

    @Override // cha.a
    public final void b(ObricTtsInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "ttsInfo");
        ObricStateDispatcher$onObricTTSStateChanged$1 r102 = new ObricStateDispatcher$onObricTTSStateChanged$1(r100, r101, null);
        Lazy r103 = j.f393225a;
        Intrinsics.checkNotNullParameter(r102, "block");
        BuildersKt.launch$default((CoroutineScope) j.f393225a.getValue(), null, null, r102, 3, null);
    }
}
