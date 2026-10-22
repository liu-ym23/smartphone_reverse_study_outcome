package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class ListDevicesRemoteSource implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListDevicesRemoteSource f345313a = null;

    static {
        f345313a = new ListDevicesRemoteSource();
    }

    public ListDevicesRemoteSource() {
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.g
    public final Object a(Continuation<? super List<RawDeviceEntry>> r110) {
        if ((r110 instanceof ListDevicesRemoteSource$fetchDevices$1) == false) goto L7;
        ListDevicesRemoteSource$fetchDevices$1 r100 = (ListDevicesRemoteSource$fetchDevices$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ListDevicesRemoteSource$fetchDevices$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r112 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        dm9.a r113 = (dm9.a) r111;
        if ((r113 instanceof dm9.a.b) == false) goto L38;
        BizResponse<T> r114 = ((dm9.a.b) r113).f469231a;
        ListDevicesResponse r105 = (ListDevicesResponse) r114.getData();
        if (r114.isSuccess() == false) goto L31;
        if (r105 == null) goto L31;
        List<ListDevicesEntry> r115 = r105.getDevices();
        if (r115 != null) goto L26;
        r115 = CollectionsKt.emptyList();
    L26:
        List r116 = CollectionsKt.filterNotNull(r115);
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r117 = r116.iterator();
    L28:
        if (r117.hasNext() == false) goto L30;
        ListDevicesEntry r107 = (ListDevicesEntry) r117.next();
        r106.add(new RawDeviceEntry(r107.getDeviceId(), r107.getDeviceName(), r107.getAppId()));
        goto L28
    L30:
        return r106;
    L31:
        int r108 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r109 = new StringBuilder("code=");
        r109.append(r114.getCode());
        r109.append(" msg=");
        r109.append(r114.getMsg());
        r109.append(" hasData=");
        if (r105 != null) goto L35;
        r112 = false;
    L35:
        r109.append(r112);
        com.larus.home.impl.main.side_bar.feed.arch.t.a("device_list_biz_failed", r109.toString());
        return null;
    L38:
        if ((r113 instanceof dm9.a.C5690a) == false) goto L42;
        int r118 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r119 = new StringBuilder("code=");
        dm9.a.C5690a r120 = (dm9.a.C5690a) r113;
        r119.append(r120.f469228a);
        r119.append(" msg=");
        r119.append(r120.f469229b);
        com.larus.home.impl.main.side_bar.feed.arch.t.a("device_list_request_failed", r119.toString());
        return null;
    L42:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        ListDevicesApi.a r121 = ListDevicesApi.f345311a;
        ListDevicesRemoteSource$fetchDevices$response$result$1 r122 = new ListDevicesRemoteSource$fetchDevices$response$result$1(null);
        r102.label = 1;
        r121.getClass();
        FlowHttpConnection r123 = FlowHttpConnection.f359975a;
        r111 = FlowHttpConnection.g(ServiceType.MAIN_BOT, ListDevicesApi.class, r122, true, null, null, null, r102, 240);
        if (r111 != r103) goto L17;
        return r103;
    L7:
        r100 = new ListDevicesRemoteSource$fetchDevices$1(this, r110);
        goto L8
    }
}
