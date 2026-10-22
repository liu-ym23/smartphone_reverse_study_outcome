package com.larus.dora.o.impl.diary;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.o.api.IDoraODiaryService;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/o/impl/diary/DoraODiaryServiceImpl;", "Lcom/larus/dora/o/api/IDoraODiaryService;", "<init>", "()V", "initResident", "", "markEnvObserveOpened", "mac", "", "hasDeviceHomeDiaryData", "Lkotlin/Result;", "", "hasDeviceHomeDiaryData-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDeviceHomeFragment", "Landroidx/fragment/app/Fragment;", "hasHistoricalData", "glassesMac", "initialDate", "selectDeviceHomeDiaryDate", WidgetService.PARAM_FRAGMENT, "date", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraODiaryServiceImpl implements IDoraODiaryService {

    public static final class a {
    }

    static {
    }

    public DoraODiaryServiceImpl() {
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final void a(String r100) {
        int r101 = d0.f338508a;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L16;
        FLogger.f375446a.i("ODiaryEnvMark", "env observe opened by user, mark diary as opened");
        IDoraPageConfig r103 = d0.a();
        if (r103 == null) goto L15;
        r103.c(r100);
        return;
    L15:
        return;
    L16:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final Object c(Continuation<? super Result<Boolean>> r100) {
        if ((r100 instanceof DoraODiaryServiceImpl$hasDeviceHomeDiaryData$1) == false) goto L7;
        DoraODiaryServiceImpl$hasDeviceHomeDiaryData$1 r101 = (DoraODiaryServiceImpl$hasDeviceHomeDiaryData$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L61
    L19:
        j r107 = (j) r103;     // Catch: Throwable -> L61
        if (r107 == null) goto L60;
        Long r108 = r107.d();     // Catch: Throwable -> L61
        if (r108 == null) goto L24;
        long r109 = r108.longValue();     // Catch: Throwable -> L61
    L26:
        if (r109 > 0) goto L49;
        List<i> r110 = r107.b();     // Catch: Throwable -> L61
        if (r110 != null) goto L30;
        r110 = CollectionsKt.emptyList();     // Catch: Throwable -> L61
    L30:
        List<i> r111 = r110;     // Catch: Throwable -> L61
        if ((r111 instanceof Collection) == true) goto L33;
    L35:
        Iterator<T> r112 = r111.iterator();     // Catch: Throwable -> L61
    L37:
        if (r112.hasNext() == false) goto L34;
        i r113 = (i) r112.next();     // Catch: Throwable -> L61
        if (r113 != null) goto L41;
    L43:
        boolean r114 = false;
    L44:
        if (r114 == false) goto L37;
        boolean r115 = true;
    L46:
        if (r115 == true) goto L49;
        boolean r116 = false;
    L50:
        FLogger r117 = FLogger.f375446a;     // Catch: Throwable -> L61
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L61
        r118.append("hasDeviceHomeDiaryData result=");     // Catch: Throwable -> L61
        if (r116 == false) goto L53;
        boolean r119 = true;
    L54:
        r118.append(r119);     // Catch: Throwable -> L61
        r117.i("DoraODiaryService", r118.toString());     // Catch: Throwable -> L61
        if (r116 == true) goto L58;
        r106 = false;
    L58:
        Object r120 = Result.m9449constructorimpl(Boxing.boxBoolean(r106));     // Catch: Throwable -> L61
    L63:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L66;
        FLogger.f375446a.e("DoraODiaryService", "hasDeviceHomeDiaryData failed", r121);
    L66:
        return r120;
    L53:
        r119 = false;
        goto L54
    L41:
        if (r113.e() != true) goto L43;
        r114 = true;
    L34:
        r115 = false;
        goto L46
    L33:
        if (r111.isEmpty() == false) goto L35;
    L49:
        r116 = true;
        goto L50
    L24:
        r109 = 0;
        goto L26
    L60:
        throw new IllegalStateException("query diary entry state failed".toString());     // Catch: Throwable -> L61
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L61
        DoraODiaryRepo r123 = DoraODiaryRepo.f338435a;     // Catch: Throwable -> L61
        Integer r124 = Boxing.boxInt(FlowDoraSubBizType.G1_G2.getValue());     // Catch: Throwable -> L61
        r101.label = 1;     // Catch: Throwable -> L61
        r103 = r123.d(null, r124, r101);     // Catch: Throwable -> L61
        if (r103 != r104) goto L19;
        return r104;
    L61:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new DoraODiaryServiceImpl$hasDeviceHomeDiaryData$1(this, r100);
        goto L8
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final Fragment b(String r100, String r101) {
        ODiaryHostFragment r102 = new ODiaryHostFragment();
        Bundle r103 = new Bundle();
        boolean r104 = false;
        if (r100 != null) goto L5;
    L13:
        r103.putBoolean("dora_o_device_home_diary", true);
        r103.putInt("dora_o_diary_biz_id", FlowDoraSubBizType.G1_G2.getValue());
        if (r101 != null) goto L16;
    L23:
        r102.setArguments(r103);
        return r102;
    L16:
        if (r101.length() <= 0) goto L18;
        r104 = true;
    L18:
        if (r104 == true) goto L21;
        r101 = null;
    L21:
        if (r101 == null) goto L23;
        r103.putString("dora_o_diary_date", r101);
        goto L23
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        r103.putString("mac", r100);
        goto L13
    L7:
        r105 = false;
        goto L8
    }

    @Override // com.larus.dora.o.api.IDoraODiaryService
    public final void d(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "date");
        if ((r100 instanceof ODiaryHostFragment) == false) goto L5;
        ODiaryHostFragment r102 = (ODiaryHostFragment) r100;
    L6:
        if (r102 == null) goto L9;
        r102.T90(r101);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
