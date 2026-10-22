package com.obric.assistant.apm;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricSlardarConfigService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import mt3.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/apm/ObricSlardarConfigServiceImpl;", "Lcom/obric/assistant/common/spi/IObricSlardarConfigService;", "<init>", "()V", "configSlardarHandler", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSlardarConfigServiceImpl implements IObricSlardarConfigService {

    public static final class a {
    }

    static {
    }

    public ObricSlardarConfigServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.IObricSlardarConfigService
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        h r101 = h.f515628f;     // Catch: Throwable -> L7
        nt3.a r102 = h.f515628f.f515631c;     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        r102 = new nt3.a();     // Catch: Throwable -> L7
    L5:
        r102.f520487l = CollectionsKt.listOf(UploadTypeInf.SERVICE_MONITOR);     // Catch: Throwable -> L7
        h.f515628f.d(r102);     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        FLogger.f375446a.e("ObricSlardarConfigServiceImpl", "configSlardarHandler error", r104);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
