package com.obric.assistant.common.spi;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/common/spi/DefaultObricContextService;", "Lcom/obric/assistant/common/spi/IObricContextService;", "<init>", "()V", "isInteractorProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isAiagentProcess", "isMemoryDataProcess", "isZeusPluginProcess", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricContextService implements IObricContextService {
    public DefaultObricContextService() {
    }

    @Override // com.obric.assistant.common.spi.IObricContextService
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return false;
    }
}
