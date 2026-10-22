package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesApi;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class PcDeviceRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PcDeviceRepository f314355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<PcDevice> f314356b;

    static {
        f314355a = new PcDeviceRepository();
    }

    public PcDeviceRepository() {
    }

    public final Object b(Continuation<? super Result<? extends List<PcDevice>>> r210) {
        if ((r210 instanceof PcDeviceRepository$getAllDevices$1) == false) goto L7;
        PcDeviceRepository$getAllDevices$1 r100 = (PcDeviceRepository$getAllDevices$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L17:
        AllDeviceResponse r105 = (AllDeviceResponse) r102;
        if (r105 != null) goto L21;
        FLogger.f375446a.w("PcDeviceRepository", "[getAllDevices] failed");
        Result.Companion r106 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("request all devices failed")));
    L21:
        List<PcDevice> r107 = r105.getDevices();
        if (r107 != null) goto L24;
        r107 = CollectionsKt.emptyList();
    L24:
        List<PcDevice> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L67;
        PcDevice r111 = (PcDevice) r110.next();
        String r112 = null;
        if (r111 == null) goto L30;
        String r113 = r111.getDeviceId();
    L31:
        if (r111 == null) goto L33;
        String r114 = r111.d();
    L34:
        if (r111 == null) goto L36;
        String r115 = r111.e();
    L37:
        boolean r116 = false;
        if (r111 == null) goto L40;
        boolean r117 = Intrinsics.areEqual(r111.c(), Boolean.TRUE);
    L41:
        if (r111 == null) goto L43;
        boolean r118 = Intrinsics.areEqual(r111.g(), Boolean.TRUE);
    L44:
        if (r111 == null) goto L46;
        r116 = Intrinsics.areEqual(r111.r(), Boolean.TRUE);
    L46:
        if (r111 == null) goto L48;
        List<Integer> r119 = r111.q();
    L49:
        if (r111 == null) goto L51;
        String r120 = r111.j();
    L52:
        if (r111 == null) goto L54;
        String r121 = r111.k();
    L55:
        if (r111 == null) goto L57;
        String r122 = r111.o();
    L58:
        if (r111 == null) goto L60;
        String r123 = r111.b();
    L61:
        if (r111 == null) goto L63;
        String r124 = r111.h();
    L64:
        if (r111 == null) goto L66;
        r112 = r111.i();
    L66:
        r109.add(new PcDevice(r113, r114, r115, Boolean.valueOf(r117), Boolean.valueOf(r116), r123, r120, r121, r122, Boolean.valueOf(r118), r119, r124, r112));
        goto L26
    L63:
        r124 = null;
        goto L64
    L60:
        r123 = null;
        goto L61
    L57:
        r122 = null;
        goto L58
    L54:
        r121 = null;
        goto L55
    L51:
        r120 = null;
        goto L52
    L48:
        r119 = null;
        goto L49
    L43:
        r118 = false;
        goto L44
    L40:
        r117 = false;
        goto L41
    L36:
        r115 = null;
        goto L37
    L33:
        r114 = null;
        goto L34
    L30:
        r113 = null;
        goto L31
    L67:
        f314356b = r109;
        FLogger.f375446a.i("PcDeviceRepository", "[getAllDevices] success, size=" + r109.size());
        return Result.m9449constructorimpl(r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        GetAllDevicesRepo r125 = GetAllDevicesRepo.f330842a;
        r100.label = 1;
        r102 = GetAllDevicesRepo.e("PcDeviceRepository", r100);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new PcDeviceRepository$getAllDevices$1(this, r210);
        goto L8
    }

    public final Object a(String r110, String r111, Continuation<? super Result<Unit>> r112) {
        if ((r112 instanceof PcDeviceRepository$authorizeDevice$1) == false) goto L7;
        PcDeviceRepository$authorizeDevice$1 r100 = (PcDeviceRepository$authorizeDevice$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PcDeviceRepository$authorizeDevice$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        dm9.a r114 = (dm9.a) r113;
        if ((r114 instanceof dm9.a.b) == false) goto L24;
        dm9.a.b r115 = (dm9.a.b) r114;
        if (r115.f469231a.isSuccess() == false) goto L22;
        FLogger.f375446a.i("PcDeviceRepository", "[authorizeDevice] success, targetDeviceId=" + r110);
        Result.Companion r116 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L22:
        FLogger.f375446a.w("PcDeviceRepository", "[authorizeDevice] failed, targetDeviceId=" + r110 + ", code=" + r115.f469231a.getCode() + ", msg=" + r115.f469231a.getMsg());
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("authorize device failed")));
    L24:
        if ((r114 instanceof dm9.a.C5690a) == false) goto L31;
        FLogger r118 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[authorizeDevice] error, targetDeviceId=");
        r105.append(r110);
        r105.append(", code=");
        dm9.a.C5690a r119 = (dm9.a.C5690a) r114;
        r105.append(r119.f469228a);
        r105.append(", msg=");
        r105.append(r119.f469229b);
        r118.e("PcDeviceRepository", r105.toString(), r119.f469230c);
        Result.Companion r120 = Result.Companion;
        Throwable r121 = r119.f469230c;
        if (r121 != null) goto L29;
        r121 = new IllegalStateException("authorize device error");
    L29:
        return Result.m9449constructorimpl(ResultKt.createFailure(r121));
    L31:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        GetAllDevicesApi.a r122 = GetAllDevicesApi.f330840a;
        PcDeviceRepository$authorizeDevice$result$1 r106 = new PcDeviceRepository$authorizeDevice$result$1(r110, r111, null);
        r102.L$0 = r110;
        r102.label = 1;
        r122.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.MAIN_BOT, GetAllDevicesApi.class, r106, true, null, null, null, r102, 240);
        if (r113 != r103) goto L17;
        return r103;
    L7:
        r100 = new PcDeviceRepository$authorizeDevice$1(this, r112);
        goto L8
    }
}
