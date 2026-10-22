package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.impl.business.asr.FlowAsrCallbackDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f243937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.p f243938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowAsrCallbackDispatcher f243939c;

    public i(f r100, com.bytedance.flow_audio.impl.business.asr.p r101, FlowAsrCallbackDispatcher r102) {
        Intrinsics.checkNotNullParameter(r100, "eventLoop");
        Intrinsics.checkNotNullParameter(r101, "stateMachine");
        Intrinsics.checkNotNullParameter(r102, "callbackDispatcher");
        this.f243937a = r100;
        this.f243938b = r101;
        this.f243939c = r102;
    }
}
