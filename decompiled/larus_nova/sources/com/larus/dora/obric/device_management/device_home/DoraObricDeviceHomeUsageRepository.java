package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.o.api.IDoraODiaryService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraObricDeviceHomeUsageRepository {

    public static final class a {
    }

    static {
    }

    public DoraObricDeviceHomeUsageRepository() {
    }

    public static Boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Object r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L30;
        return null;
    L30:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        String r103 = "dora_obric_device_home_diary_data_" + r100;     // Catch: Throwable -> L19
        com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Throwable -> L19
        long r104 = com.larus.dora.impl.util.b0.j().getLong(r103 + "_time", 0);     // Catch: Throwable -> L19
        long r105 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L19
        if (r104 > 0) goto L8;
    L16:
        Boolean r106 = null;
    L17:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L19
    L21:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L25;
        g49.d.e("DoraObricHomeUsageRepo", "read diary cache failed: " + r108.getMessage());
    L25:
        if (Result.m9455isFailureimpl(r107) == true) goto L29;
        r101 = r107;
    L29:
        return (Boolean) r101;
    L8:
        if (0 <= r105) goto L10;
    L12:
        boolean r109 = false;
    L13:
        if (r109 == false) goto L16;
        r106 = Boolean.valueOf(com.larus.dora.impl.util.b0.j().getBoolean(r103, false));     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r105 >= 300001) goto L12;
        r109 = true;
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static s1 b(String r100, List r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r110, "boundDevices");
        List r111 = r110;
        boolean r101 = r111 instanceof Collection;
        boolean r102 = false;
        if (r101 == true) goto L5;
    L7:
        Iterator r103 = r111.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (t.a((DoraDevice) r103.next()) == false) goto L9;
        boolean r104 = true;
    L14:
        if (r101 == true) goto L16;
    L18:
        Iterator r112 = r111.iterator();
    L20:
        if (r112.hasNext() == false) goto L24;
        if (t.b((DoraDevice) r112.next()) == false) goto L20;
        boolean r113 = true;
    L26:
        if (StringsKt.isBlank(r100) == false) goto L58;
        boolean r105 = false;
    L39:
        if (r104 == true) goto L41;
        if (r105 == true) goto L41;
    L42:
        if (r104 == false) goto L54;
        if (r105 == true) goto L54;
        if (StringsKt.isBlank(r100) == true) goto L54;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L49
        com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Throwable -> L49
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_obric_device_home_glasses_binding_history_" + r100, true);     // Catch: Throwable -> L49
        g49.d.d("DoraObricHomeUsageRepo", "glasses binding history updated");     // Catch: Throwable -> L49
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L54;
        g49.d.e("DoraObricHomeUsageRepo", "write glasses binding history failed: " + r108.getMessage());
    L49:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L54:
        g49.d.d("DoraObricHomeUsageRepo", "loadBoundDeviceEvidence hasBoundGlasses=" + r104 + " hasBoundEarbuds=" + r113 + " hasBoundGlassesHistory=" + r102);
        return new s1(r104, r113, r102, 8);
    L41:
        r102 = true;
        goto L42
    L58:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L30
        com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Throwable -> L30
        Object r115 = Result.m9449constructorimpl(Boolean.valueOf(com.larus.dora.impl.util.b0.j().getBoolean("dora_obric_device_home_glasses_binding_history_" + r100, false)));     // Catch: Throwable -> L30
    L32:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L35;
        g49.d.e("DoraObricHomeUsageRepo", "read glasses binding history failed: " + r116.getMessage());
    L35:
        Boolean r117 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L38;
        r115 = r117;
    L38:
        r105 = ((Boolean) r115).booleanValue();
    L30:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        r113 = false;
        goto L26
    L16:
        if (r111.isEmpty() == false) goto L18;
    L13:
        r104 = false;
        goto L14
    L5:
        if (r111.isEmpty() == false) goto L7;
        goto L7
    }

    public final Object c(String r100, boolean r101, Continuation<? super Result<Boolean>> r102) {
        if ((r102 instanceof DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1) == false) goto L7;
        DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1 r103 = (DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101 == true) goto L20;
        Boolean r108 = a(r100);
        if (r108 == null) goto L20;
        boolean r109 = r108.booleanValue();
        g49.d.d("DoraObricHomeUsageRepo", "diary cache hit hasDiaryData=" + r109);
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(r109));
    L20:
        IDoraODiaryService r111 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);
        if (r111 != null) goto L24;
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Dora O diary service is unavailable")));
    L24:
        r103.label = 1;
        Object r113 = r111.c(r103);
        if (r113 != r106) goto L28;
        return r106;
    L28:
        return r113;
    L7:
        r103 = new DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1(this, r102);
        goto L8
    }
}
