package com.larus.uaigc.applet;

import com.larus.business.multitask_management.api.IMultiTaskInitEvent;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/applet/AICreationMultiTaskInitEventImpl;", "Lcom/larus/business/multitask_management/api/IMultiTaskInitEvent;", "<init>", "()V", "onInit", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AICreationMultiTaskInitEventImpl implements IMultiTaskInitEvent {

    public static final class a {
    }

    static {
    }

    public AICreationMultiTaskInitEventImpl() {
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskInitEvent
    public final void onInit() {
        FLogger.f375446a.i("AICreationMultiTaskInitEvent", "onInit prewarm AI creation applet");
        int r100 = com.larus.uaigc.applet.a.f370285a;
        IAICreationAppletHostService.f370273a.c();
    }
}
