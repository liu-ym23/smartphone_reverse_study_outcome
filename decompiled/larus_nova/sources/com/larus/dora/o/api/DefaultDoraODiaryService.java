package com.larus.dora.o.api;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/o/api/DefaultDoraODiaryService;", "Lcom/larus/dora/o/api/IDoraODiaryService;", "<init>", "()V", "initResident", "", "markEnvObserveOpened", "mac", "", "hasDeviceHomeDiaryData", "Lkotlin/Result;", "", "hasDeviceHomeDiaryData-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDeviceHomeFragment", "Landroidx/fragment/app/Fragment;", "hasHistoricalData", "glassesMac", "initialDate", "dora_o_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultDoraODiaryService implements IDoraODiaryService {
    public DefaultDoraODiaryService() {
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final void a(String r100) {
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final Fragment b(String r100, String r101) {
        return null;
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final Object c(Continuation<? super Result<Boolean>> r100) {
        Result.Companion r101 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Dora O diary service is unavailable")));
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final void d(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "date");
    }
}
