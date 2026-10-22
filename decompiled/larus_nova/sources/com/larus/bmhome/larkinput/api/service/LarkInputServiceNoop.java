package com.larus.bmhome.larkinput.api.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.b;
import pq8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/larkinput/api/service/LarkInputServiceNoop;", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputService;", "<init>", "()V", "createController", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputController;", "config", "Lcom/larus/bmhome/larkinput/api/model/InlineTriggerConfig;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputServiceNoop implements ILarkInputService {
    public LarkInputServiceNoop() {
    }

    @Override // com.larus.bmhome.larkinput.api.service.ILarkInputService
    public final a a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new pq8.b();
    }
}
