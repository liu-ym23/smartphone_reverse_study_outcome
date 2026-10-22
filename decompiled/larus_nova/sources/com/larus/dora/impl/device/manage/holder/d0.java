package com.larus.dora.impl.device.manage.holder;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class d0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordMinutesUIComponent f333836a;

    public /* synthetic */ d0(RecordMinutesUIComponent r100) {
        this.f333836a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        RecordMinutesUIComponent r100 = this.f333836a;
        int r101 = RecordMinutesUIComponent.f333804n;
        r100.k("dora_voice_memos_start");
        return Unit.INSTANCE;
    }
}
