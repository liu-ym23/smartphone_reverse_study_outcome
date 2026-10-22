package com.obric.assistant.common.spi;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/common/spi/ObricContextServiceDelegate;", "Lcom/obric/assistant/common/spi/IObricContextService;", "<init>", "()V", "isAiagentProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isInteractorProcess", "isMemoryDataProcess", "isZeusPluginProcess", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContextServiceDelegate implements IObricContextService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricContextServiceDelegate f387837b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricContextService f387838a;

    static {
        f387837b = new ObricContextServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.IObricContextService
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f387838a.a(r100);
    }

    private ObricContextServiceDelegate() {
        this.f387838a = (IObricContextService) ServiceManager.get().getService(IObricContextService.class);
    }
}
