package com.obric.memorydata.sdk.realtime;

import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J,\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContextServiceProxy$ServiceProxy;", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextService;", "service", "<init>", "(Lcom/obric/memorydata/sdk/realtime/IRealTimeContextService;)V", "getService", "()Lcom/obric/memorydata/sdk/realtime/IRealTimeContextService;", "asBinder", "Landroid/os/IBinder;", "onHandleAssist", "", "assistStructure", "Landroid/app/assist/AssistStructure;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onHandleScreenshot", IHostShare.ShareType.SCREENSHOT, "Landroid/graphics/Bitmap;", "queryRealTimeContext", "Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", "query", "", "rewriteQeury", "queryId", "onHandleAssistWithCallback", "callback", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextCallback;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RealTimeContextServiceProxy$ServiceProxy implements IRealTimeContextService {
    private final IRealTimeContextService service;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.service.asBinder();
    L4:
        return null;
    }

    public final IRealTimeContextService getService() {
        return this.service;
    }

    public RealTimeContextServiceProxy$ServiceProxy(IRealTimeContextService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.service = r100;
    }

    @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
    public void onHandleScreenshot(Bitmap r100) {
        this.service.onHandleScreenshot(r100);     // Catch: RemoteException -> L4
        return;
    }

    @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
    public void onHandleAssist(AssistStructure r100, List<AppEntity> r101) {
        this.service.onHandleAssist(r100, r101);     // Catch: RemoteException -> L4
        return;
    }

    @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
    public void onHandleAssistWithCallback(AssistStructure r100, List<AppEntity> r101, IRealTimeContextCallback r102) {
        this.service.onHandleAssistWithCallback(r100, r101, r102);     // Catch: RemoteException -> L4
        return;
    }

    @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextService
    public RealTimeContextResult queryRealTimeContext(String r100, String r101, String r102) {
        return this.service.queryRealTimeContext(r100, r101, r102);
    L4:
        return null;
    }
}
