package com.larus.avlink.utils;

import com.larus.avlink.api.IDoraTrackerService;
import com.larus.avlink.api.model.DoraEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import ia8.m;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/utils/DoraTracerService;", "Lcom/larus/avlink/api/IDoraTrackerService;", "<init>", "()V", "getTraceInfo", "", DBDefinition.TASK_ID, "getCurTaskId", "getCurCallId", "info", "", "doraEvent", "Lcom/larus/avlink/api/model/DoraEvent;", "logForAutoTest", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraTracerService implements IDoraTrackerService {
    public DoraTracerService() {
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final String a() {
        Lazy r100 = m.f488947a;
        return m.f488951e;
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final String c() {
        Lazy r100 = m.f488947a;
        return m.f488950d;
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final void b(DoraEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "doraEvent");
        m.b(r100);
    }
}
