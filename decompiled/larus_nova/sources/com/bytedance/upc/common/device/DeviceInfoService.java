package com.bytedance.upc.common.device;

import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/upc/common/device/DeviceInfoService;", "Lcom/bytedance/upc/common/device/IDeviceInfoService;", "<init>", "()V", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public final class DeviceInfoService implements IDeviceInfoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f272463a;

    public DeviceInfoService() {
        new ArrayList();
        this.f272463a = LazyKt.lazy(DeviceInfoService$mConfiguration$2.INSTANCE);
    }
}
