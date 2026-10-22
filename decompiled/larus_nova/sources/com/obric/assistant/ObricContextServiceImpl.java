package com.obric.assistant;

import android.content.Context;
import com.obric.assistant.common.spi.IObricContextService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ObricContextServiceImpl;", "Lcom/obric/assistant/common/spi/IObricContextService;", "<init>", "()V", "isInteractorProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isAiagentProcess", "isMemoryDataProcess", "isZeusPluginProcess", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContextServiceImpl implements IObricContextService {

    public static final class a {
    }

    static {
    }

    public ObricContextServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.IObricContextService
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return mda.a.a(r100);
    }
}
