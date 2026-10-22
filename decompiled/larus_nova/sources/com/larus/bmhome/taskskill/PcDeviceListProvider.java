package com.larus.bmhome.taskskill;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class PcDeviceListProvider implements com.larus.bmhome.taskskill.service.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<bs8.e> f314194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f314195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f314196c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final bs8.e b() {
        GetAllDevicesRepo r100 = GetAllDevicesRepo.f330842a;
        AllDeviceResponse r101 = GetAllDevicesRepo.d();
        if (r101 != null) goto L7;
        return null;
    L7:
        return g(r101.getDevices());
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void e() {
        if (this.f314195b == true) goto L5;
        return;
    L5:
        GetAllDevicesRepo.f330856o.removeObserver(this.f314196c);
        this.f314195b = false;
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void f() {
        if (this.f314195b == false) goto L5;
        return;
    L5:
        GetAllDevicesRepo r100 = GetAllDevicesRepo.f330842a;
        GetAllDevicesRepo.g();
        GetAllDevicesRepo.f330856o.observeForever(this.f314196c);
        this.f314195b = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.taskskill.g] */
    public PcDeviceListProvider() {
        this.f314194a = new MutableLiveData();
        this.f314196c = new g(this);
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final MutableLiveData<bs8.e> d() {
        return this.f314194a;
    }

    public static bs8.e g(List r100) {
        Pair<List<PcDevice>, List<PcDevice>> r101 = com.larus.dispatcher.api.d.a(r100);
        List<PcDevice> r102 = r101.component1();
        List<PcDevice> r103 = r101.component2();
        return new bs8.e(CollectionsKt.filterNotNull(r102), CollectionsKt.filterNotNull(r103));
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final Object a(Continuation<? super bs8.f> r100) {
        if ((r100 instanceof PcDeviceListProvider$loadDevices$1) == false) goto L7;
        PcDeviceListProvider$loadDevices$1 r101 = (PcDeviceListProvider$loadDevices$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        bs8.e r106 = (bs8.e) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        AllDeviceResponse r107 = (AllDeviceResponse) r103;
        if (r107 == null) goto L24;
        bs8.e r108 = g(r107.getDevices());
        this.f314194a.postValue(r108);
        return new bs8.f(r108, true);
    L24:
        return new bs8.f(r106, false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        bs8.e r109 = b();
        if (r109 == null) goto L17;
        this.f314194a.postValue(r109);
    L17:
        GetAllDevicesRepo r110 = GetAllDevicesRepo.f330842a;
        r101.L$0 = r109;
        r101.label = 1;
        Object r111 = GetAllDevicesRepo.e("PcDeviceListProvider", r101);
        if (r111 != r104) goto L20;
        return r104;
    L20:
        r106 = r109;
        r103 = r111;
    L7:
        r101 = new PcDeviceListProvider$loadDevices$1(this, r100);
        goto L8
    }

    @Override // com.larus.bmhome.taskskill.service.d
    public final void c(PcDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        GetAllDevicesRepo r101 = GetAllDevicesRepo.f330842a;
        Intrinsics.checkNotNullParameter(r100, "targetDevice");
        AllDeviceResponse r102 = GetAllDevicesRepo.f330843b;
        if (r102 == null) goto L27;
        String r103 = r100.getDeviceId();
        if (r103 == null) goto L28;
        List<PcDevice> r104 = r102.getDevices();
        ArrayList r105 = null;
        if (r104 == null) goto L22;
        List<PcDevice> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L21;
        PcDevice r109 = (PcDevice) r108.next();
        if (r109 == null) goto L16;
        String r110 = r109.getDeviceId();
    L18:
        if (Intrinsics.areEqual(r110, r103) == false) goto L20;
        r109 = r100;
    L20:
        r107.add(r109);
        goto L12
    L16:
        r110 = null;
        goto L18
    L21:
        r105 = r107;
    L22:
        GetAllDevicesRepo.j(r102.copy(r105));
        return;
    L28:
        return;
    }
}
