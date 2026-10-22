package com.obric.memorydata.sdk.memory;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.memorydata.sdk.service.BinderCode;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class MemoryServiceProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f397145a = 0;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/sdk/memory/MemoryServiceProxy$ServiceProxy;", "Lcom/obric/memorydata/sdk/memory/IMemoryService;", "service", "<init>", "(Lcom/obric/memorydata/sdk/memory/IMemoryService;)V", "getService", "()Lcom/obric/memorydata/sdk/memory/IMemoryService;", "asBinder", "Landroid/os/IBinder;", "registerMemoryCallback", "", "callback", "Lcom/obric/memorydata/sdk/memory/IMemoryCallback;", "saveAssistantChatMemory", "type", "", "memory", "extras", "Landroid/os/Bundle;", "getDialogueMemoryEnableState", "", "syncAssistantChat", "json", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ServiceProxy implements IMemoryService {
        private final IMemoryService service;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            return null;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public boolean getDialogueMemoryEnableState() {
            return this.service.getDialogueMemoryEnableState();
        L4:
            return false;
        }

        public final IMemoryService getService() {
            return this.service;
        }

        public ServiceProxy(IMemoryService r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            this.service = r100;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void registerMemoryCallback(IMemoryCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.service.registerMemoryCallback(r100);     // Catch: RemoteException -> L5
            return;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void syncAssistantChat(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            this.service.syncAssistantChat(r100);     // Catch: RemoteException -> L5
            return;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void saveAssistantChatMemory(String r100, String r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "memory");
            Intrinsics.checkNotNullParameter(r102, "extras");
            this.service.saveAssistantChatMemory(r100, r101, r102);     // Catch: RemoteException -> L5
            return;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements MemoryDataServiceProxy.a {
        public a() {
        }

        @Override // com.obric.memorydata.sdk.service.MemoryDataServiceProxy.a
        public final void binderDied() {
            int r100 = MemoryServiceProxy.f397145a;
        }
    }

    static {
        MemoryDataServiceProxy r100 = MemoryDataServiceProxy.f397297a;
        int r101 = BinderCode.MEMORY.ordinal();
        a r102 = new a();
        Intrinsics.checkNotNullParameter(r102, "listener");
        Integer r103 = Integer.valueOf(r101);
        MemoryDataServiceProxy.f397304h.put(r103, r102);
    }
}
