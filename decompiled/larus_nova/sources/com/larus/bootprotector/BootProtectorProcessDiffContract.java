package com.larus.bootprotector;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/bootprotector/BootProtectorProcessDiffContract;", "Lcom/larus/bootprotector/IBootProtectorProcessDiff;", "<init>", "()V", "isMainProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorProcessDiffContract implements IBootProtectorProcessDiff {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BootProtectorProcessDiffContract f317600b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBootProtectorProcessDiff f317601a;

    static {
        f317600b = new BootProtectorProcessDiffContract();
    }

    @Override // com.larus.bootprotector.IBootProtectorProcessDiff
    public final boolean isMainProcess(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f317601a.isMainProcess(r100);
    }

    private BootProtectorProcessDiffContract() {
        this.f317601a = (IBootProtectorProcessDiff) ServiceManager.get().getService(IBootProtectorProcessDiff.class);
    }
}
