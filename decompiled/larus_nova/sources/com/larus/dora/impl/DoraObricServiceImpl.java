package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraObricService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.network.HttpConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0010\u0010\u000eJ\f\u0010\u0011\u001a\u00020\f*\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/DoraObricServiceImpl;", "Lcom/larus/dora/api/IDoraObricService;", "<init>", "()V", "checkBindAndConnectIfNecessary", "", "deviceInfo", "Lcom/larus/dora/api/DoraDeviceInfo;", "(Lcom/larus/dora/api/DoraDeviceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeviceBound", "Lkotlin/Result;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "isDeviceBound-gIAlu-s", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkBindStatus", "checkBindStatus-gIAlu-s", "toDoraDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricServiceImpl implements IDoraObricService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f331887a = 0;

    public static final class a {
    }

    static {
    }

    public DoraObricServiceImpl() {
    }

    @Override // com.larus.dora.api.IDoraObricService
    public final Object a(t39.d r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof DoraObricServiceImpl$checkBindAndConnectIfNecessary$1) == false) goto L7;
        DoraObricServiceImpl$checkBindAndConnectIfNecessary$1 r100 = (DoraObricServiceImpl$checkBindAndConnectIfNecessary$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L48:
        return Boxing.boxBoolean(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L41:
        OnlyConnectResult r113 = (OnlyConnectResult) r112;
        if (r113 != OnlyConnectResult.SUCCESS) goto L46;
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: connect success, binding buds...");
        kj4.a r114 = kj4.a.g();
        r100.label = 3;
        if (DoraAdapterExtKt.c(r114, true, r100) != r102) goto L48;
        return r102;
    L46:
        g49.d.e("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: connect failed result=" + r113);
        Unit r115 = Unit.INSTANCE;
        goto L48
    L17:
        DoraDevice r116 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r112);
        Object r117 = ((Result) r112).m9458unboximpl();
    L31:
        if (Result.m9455isFailureimpl(r117) == false) goto L33;
        r117 = null;
    L33:
        Boolean r118 = (Boolean) r117;
        if (r118 == null) goto L36;
        boolean r119 = r118.booleanValue();
    L37:
        if (r119 == false) goto L49;
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: device is bound, connecting... device=" + r116.getSerialNumber());
        kj4.a.g();
        r100.L$0 = null;
        r100.label = 2;
        r112 = DoraAdapterExtKt.A(r116);
        if (r112 != r102) goto L41;
        return r102;
    L49:
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: device not bound");
        return Boxing.boxBoolean(false);
    L36:
        r119 = false;
        goto L37
    L18:
        ResultKt.throwOnFailure(r112);
        DoraDevice r120 = new DoraDevice();
        r120.name = r110.f544460a;
        r120.f204389mac = r110.f544461b;
        Integer r104 = r110.f544462c;
        if (r104 == null) goto L21;
        int r105 = r104.intValue();
    L22:
        r120.productId = r105;
        r120.f204390sn = r110.f544465f;
        Integer r121 = r110.f544463d;
        if (r121 == null) goto L25;
        int r122 = r121.intValue();
    L26:
        r120.vendorId = r122;
        r100.L$0 = r120;
        r100.label = 1;
        Object r123 = c(r120, r100);
        if (r123 != r102) goto L29;
        return r102;
    L29:
        r117 = r123;
        r116 = r120;
        goto L31
    L25:
        r122 = 1;
        goto L26
    L21:
        r105 = 1;
    L7:
        r100 = new DoraObricServiceImpl$checkBindAndConnectIfNecessary$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(DoraDevice r110, Continuation<? super Result<Boolean>> r111) {
        if ((r111 instanceof DoraObricServiceImpl$checkBindStatus$1) == false) goto L7;
        DoraObricServiceImpl$checkBindStatus$1 r100 = (DoraObricServiceImpl$checkBindStatus$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraObricServiceImpl$checkBindStatus$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L39
    L19:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Throwable -> L39
        if ((r113 instanceof com.larus.network.http.y) == false) goto L33;
        Long r114 = ((com.larus.network.http.y) r113).f360205g;     // Catch: Throwable -> L39
        if (r114 == null) goto L33;
        if (r114.longValue() != 0) goto L33;
        FineDoraDeviceStrategy.a r115 = (FineDoraDeviceStrategy.a) ((com.larus.network.http.y) r113).f360135b;     // Catch: Throwable -> L39
        if (r115 == null) goto L31;
        Boolean r116 = r115.a();     // Catch: Throwable -> L39
        if (r116 == null) goto L31;
        boolean r117 = r116.booleanValue();     // Catch: Throwable -> L39
    L32:
        g49.d.d("DoraObricServiceImpl", "checkBindStatus() success, bindingStatus=" + r117);     // Catch: Throwable -> L39
        Object r118 = Result.m9449constructorimpl(Boxing.boxBoolean(r117));     // Catch: Throwable -> L39
    L41:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L47;
        g49.d.c("DoraObricServiceImpl", "checkBindStatus() error: " + r119.getMessage(), r119);
        return Result.m9449constructorimpl(ResultKt.createFailure(r119));
    L47:
        return Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r118).booleanValue()));
    L31:
        r117 = false;
    L33:
        StringBuilder r105 = new StringBuilder("Check bind status failed, code=");     // Catch: Throwable -> L39
        if ((r113 instanceof com.larus.network.http.y) == false) goto L36;
        Long r120 = ((com.larus.network.http.y) r113).f360205g;     // Catch: Throwable -> L39
    L37:
        r105.append(r120);     // Catch: Throwable -> L39
        throw new IllegalStateException(r105.toString());     // Catch: Throwable -> L39
    L36:
        r120 = Boxing.boxLong(-1);     // Catch: Throwable -> L39
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        g49.d.d("DoraObricServiceImpl", "checkBindStatus() start, w_did=" + r110.getSerialNumber());
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L39
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L39
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L39
        HttpConst.f359979a.getClass();     // Catch: Throwable -> L39
        r107.append(HttpConst.f360003m);     // Catch: Throwable -> L39
        r107.append("/alice/w/device/check_binding_status");     // Catch: Throwable -> L39
        String r108 = r107.toString();     // Catch: Throwable -> L39
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L39
        r109.put("w_did", r110.getSerialNumber());     // Catch: Throwable -> L39
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r102.label = 1;     // Catch: Throwable -> L39
        r112 = com.larus.dora.api.network.a.c(r106, FineDoraDeviceStrategy.a.class, r108, r109, null, r102, 248);     // Catch: Throwable -> L39
        if (r112 != r103) goto L19;
        return r103;
    L39:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new DoraObricServiceImpl$checkBindStatus$1(this, r111);
        goto L8
    }

    public final Object c(DoraDevice r100, Continuation<? super Result<Boolean>> r101) {
        if ((r101 instanceof DoraObricServiceImpl$isDeviceBound$1) == false) goto L7;
        DoraObricServiceImpl$isDeviceBound$1 r102 = (DoraObricServiceImpl$isDeviceBound$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        DoraDevice r107 = (DoraDevice) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L38
        return ((Result) r104).m9458unboximpl();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        List<DoraDevice> r108 = kj4.a.g().getDoraBindList();     // Catch: Exception -> L38
        if ((r108 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r109 = r108.iterator();     // Catch: Exception -> L38
    L24:
        if (r109.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((DoraDevice) r109.next()).f204389mac, r100.f204389mac) == false) goto L24;
        boolean r110 = true;
    L28:
        if (r110 == false) goto L32;
        Result.Companion r111 = Result.Companion;     // Catch: Exception -> L38
        return Result.m9449constructorimpl(Boxing.boxBoolean(true));
    L32:
        if (o59.a.o(Boxing.boxInt(r100.productId)) == false) goto L35;
        Result.Companion r112 = Result.Companion;     // Catch: Exception -> L38
        return Result.m9449constructorimpl(Boxing.boxBoolean(false));
    L35:
        r102.L$0 = r100;     // Catch: Exception -> L38
        r102.label = 1;     // Catch: Exception -> L38
        Object r113 = b(r100, r102);     // Catch: Exception -> L38
        if (r113 != r105) goto L45;
        return r105;
    L45:
        return r113;
    L21:
        r110 = false;
        goto L28
    L20:
        if (r108.isEmpty() == false) goto L22;
    L38:
        e = move-exception;
        g49.d.c("DoraObricServiceImpl", "Failed to check bind state for device: " + r100.f204389mac, e);
        Result.Companion r114 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(e));
    L7:
        r102 = new DoraObricServiceImpl$isDeviceBound$1(this, r101);
        goto L8
    }
}
