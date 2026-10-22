package com.larus.office.plugins.inputv2;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AIChatPluginV2$slidesCoordinator$2$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public AIChatPluginV2$slidesCoordinator$2$2(Object r100) {
        super(0, r100, qo9.c.class, MonitorConstants.SCHEDULE, "schedule()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((qo9.c) this.receiver).c();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
