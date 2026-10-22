package com.bytedance.badger.network;

import com.bytedance.badger.e;
import com.bytedance.badger.monitor.TriggerStage;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class T extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f199066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z64.b f199067b;

    public T(b r100, z64.b r101) {
        this.f199066a = r100;
        this.f199067b = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        e.f("BadgerCustomReportHandler", "uploadReport - scene: " + this.f199066a.f199073a + ", stage: " + this.f199066a.f199076d);
        o0 r100 = o0.f199132a;
        o0.g(this.f199067b, new n0(this.f199066a.f199074b, 30000, TriggerStage.custom, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT), true, new S(this));
        return Unit.INSTANCE;
    }
}
