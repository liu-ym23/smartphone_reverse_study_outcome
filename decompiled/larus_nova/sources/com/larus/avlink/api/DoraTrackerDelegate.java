package com.larus.avlink.api;

import com.larus.avlink.api.model.DoraEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/api/DoraTrackerDelegate;", "Lcom/larus/avlink/api/IDoraTrackerService;", "<init>", "()V", "getCurCallId", "", "getCurTaskId", "getTraceInfo", DBDefinition.TASK_ID, "info", "", "doraEvent", "Lcom/larus/avlink/api/model/DoraEvent;", "logForAutoTest", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraTrackerDelegate implements IDoraTrackerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DoraTrackerDelegate f291644b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraTrackerService f291645a;

    static {
        f291644b = new DoraTrackerDelegate();
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final String a() {
        return this.f291645a.a();
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final void b(DoraEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "doraEvent");
        this.f291645a.b(r100);
    }

    @Override // com.larus.avlink.api.IDoraTrackerService
    public final String c() {
        return this.f291645a.c();
    }

    private DoraTrackerDelegate() {
        this.f291645a = (IDoraTrackerService) ServiceManager.get().getService(IDoraTrackerService.class);
    }
}
