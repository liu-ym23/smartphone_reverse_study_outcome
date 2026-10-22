package com.larus.platform.service;

import com.google.gson.JsonObject;
import com.larus.platform.api.IAppletJsbEventService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k implements IAppletJsbEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f365753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365754b = null;

    public k() {
    }

    static {
        f365753a = new k();
        f365754b = LazyKt.lazy(new j());
    }

    @Override // com.larus.platform.api.IAppletJsbEventService
    public final void a(IAppletJsbEventService.TriggeredEvent r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IAppletJsbEventService r102 = (IAppletJsbEventService) f365754b.getValue();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
