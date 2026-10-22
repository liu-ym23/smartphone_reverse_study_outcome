package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.minor.api.IMinorService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraMinorManager implements com.larus.minor.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraMinorManager f332157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f332158b = null;

    public DoraMinorManager() {
    }

    static {
        f332157a = new DoraMinorManager();
        f332158b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.larus.minor.api.c
    public final void AT() {
        g49.d.d("DoraMinorManager", "onFailedSwitchMinorMode");
    }

    @Override // com.larus.minor.api.c
    public final void S1() {
        g49.d.d("DoraMinorManager", "onMinorModeOn");
        BuildersKt.launch$default(f332158b, null, null, new DoraMinorManager$onMinorModeOn$1(null), 3, null);
    }

    @Override // com.larus.minor.api.c
    public final void b1() {
        g49.d.d("DoraMinorManager", "onMinorModeOff");
    }

    public final Object a(Continuation<? super Boolean> r100) {
        if ((r100 instanceof DoraMinorManager$checkMinorModeAndClearGDevice$1) == false) goto L7;
        DoraMinorManager$checkMinorModeAndClearGDevice$1 r101 = (DoraMinorManager$checkMinorModeAndClearGDevice$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L25:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IMinorService r106 = (IMinorService) ServiceManager.get().getService(IMinorService.class);
        if (r106 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L27;
        g49.d.d("DoraMinorManager", "checkMinorModeAndClearGDevice: Minor mode is on, executing cleanup...");
        r101.label = 1;
        if (b(r101) != r104) goto L25;
        return r104;
    L27:
        return Boxing.boxBoolean(false);
    L17:
        if (r106.a() != true) goto L19;
        r107 = true;
    L7:
        r101 = new DoraMinorManager$checkMinorModeAndClearGDevice$1(this, r100);
        goto L8
    }

    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof DoraMinorManager$processMinorModeLogic$1) == false) goto L7;
        DoraMinorManager$processMinorModeLogic$1 r100 = (DoraMinorManager$processMinorModeLogic$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r104 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Iterator r105 = (Iterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L42:
        if (r105.hasNext() == false) goto L47;
        DoraDevice r112 = (DoraDevice) r105.next();
        g49.d.d("DoraMinorManager", "processMinorModeLogic: Removing local G device record: sn=" + r112.f204390sn);
        kj4.a r106 = kj4.a.g();
        Integer r107 = Boxing.boxInt(3);
        r100.L$0 = r105;
        r100.label = 2;
        if (DoraAdapterExtKt.d(r106, r112, r107, true) != r102) goto L42;
        return r102;
    L47:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        DoraDevice r108 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L30:
        boolean r113 = ((Boolean) r111).booleanValue();
        StringBuilder r109 = new StringBuilder("processMinorModeLogic: ");
        if (r108 == null) goto L33;
        r104 = r108.f204390sn;
    L33:
        r109.append(r104);
        r109.append(", unbindBudsResult=");
        r109.append(r113);
        g49.d.d("DoraMinorManager", r109.toString());
    L34:
        g49.d.d("DoraMinorManager", "processMinorModeLogic: Cleaning up remaining local G device records...");
        List<DoraDevice> r114 = DoraAdapterExtKt.k(kj4.a.g());
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L36:
        if (r116.hasNext() == false) goto L40;
        Object r117 = r116.next();
        if (o59.a.o(Boxing.boxInt(((DoraDevice) r117).productId)) == false) goto L36;
        r115.add(r117);
        goto L36
    L40:
        r105 = r115.iterator();
        goto L42
    L16:
        ResultKt.throwOnFailure(r111);
        r108 = DoraAdapterExtKt.h(kj4.a.g());
        boolean r118 = DoraAdapterExtKt.t(kj4.a.g());
        if (r108 == null) goto L19;
        Integer r119 = Boxing.boxInt(r108.productId);
    L20:
        boolean r120 = o59.a.o(r119);
        if (r118 == false) goto L34;
        if (r120 == false) goto L34;
        StringBuilder r121 = new StringBuilder("processMinorModeLogic: Connected G device found, unbinding... sn=");
        if (r108 == null) goto L26;
        String r122 = r108.f204390sn;
    L27:
        r121.append(r122);
        g49.d.d("DoraMinorManager", r121.toString());
        kj4.a r123 = kj4.a.g();
        r100.L$0 = r108;
        r100.label = 1;
        r111 = DoraAdapterExtKt.R(r123, false);
        if (r111 != r102) goto L30;
        return r102;
    L26:
        r122 = null;
        goto L27
    L19:
        r119 = null;
    L7:
        r100 = new DoraMinorManager$processMinorModeLogic$1(this, r110);
        goto L8
    }
}
