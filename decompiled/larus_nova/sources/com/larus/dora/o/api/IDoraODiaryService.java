package com.larus.dora.o.api;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/o/api/IDoraODiaryService;", "", "initResident", "", "markEnvObserveOpened", "mac", "", "hasDeviceHomeDiaryData", "Lkotlin/Result;", "", "hasDeviceHomeDiaryData-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDeviceHomeFragment", "Landroidx/fragment/app/Fragment;", "hasHistoricalData", "glassesMac", "initialDate", "selectDeviceHomeDiaryDate", WidgetService.PARAM_FRAGMENT, "date", "Companion", "dora_o_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraODiaryService {
    void a(String r100);

    Fragment b(String r100, String r101);

    Object c(Continuation<? super Result<Boolean>> r100);

    void d(Fragment r100, String r101);
}
