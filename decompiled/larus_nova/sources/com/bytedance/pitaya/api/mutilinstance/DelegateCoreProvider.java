package com.bytedance.pitaya.api.mutilinstance;

import com.bytedance.pitaya.api.CoreProvider;
import com.bytedance.pitaya.api.IPitayaCore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/mutilinstance/DelegateCoreProvider;", "Lcom/bytedance/pitaya/api/CoreProvider;", "()V", "cores", "", "", "Lcom/bytedance/pitaya/api/IPitayaCore;", "value", "realProvider", "getRealProvider", "()Lcom/bytedance/pitaya/api/CoreProvider;", "setRealProvider", "(Lcom/bytedance/pitaya/api/CoreProvider;)V", "getCore", "aid", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DelegateCoreProvider implements CoreProvider {
    public static final DelegateCoreProvider INSTANCE = null;
    private static final Map<String, IPitayaCore> cores = null;
    private static CoreProvider realProvider;

    private DelegateCoreProvider() {
    }

    static {
        INSTANCE = new DelegateCoreProvider();
        cores = new LinkedHashMap();
    }

    public final CoreProvider getRealProvider() {
        return realProvider;
    }

    @Override // com.bytedance.pitaya.api.CoreProvider
    public IPitayaCore getCore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Map<String, IPitayaCore> r101 = cores;
        monitor-enter(r101);
        IPitayaCore r102 = r101.get(r100);     // Catch: Throwable -> L14
        if (r102 != null) goto L12;
        CoreProvider r103 = realProvider;     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        r102 = r103.getCore(r100);     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
    L11:
        r101.put(r100, r102);     // Catch: Throwable -> L14
    L10:
        r102 = new DelegateCore(r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    public final void setRealProvider(CoreProvider r100) {
        Map<String, IPitayaCore> r101 = cores;
        monitor-enter(r101);
        if (r100 != null) goto L26;
    L24:
        monitor-exit(r101);
        return;
    L26:
    L21:
        th = move-exception;
        throw th;
    L6:
        if (realProvider != null) goto L24;
        realProvider = r100;     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, IPitayaCore>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, IPitayaCore> r103 = r102.next();     // Catch: Throwable -> L21
        if ((r103.getValue() instanceof DelegateCore) == false) goto L10;
        IPitayaCore r104 = r103.getValue();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.pitaya.api.mutilinstance.DelegateCore");     // Catch: Throwable -> L21
        DelegateCore r105 = (DelegateCore) r104;     // Catch: Throwable -> L21
        CoreProvider r106 = realProvider;     // Catch: Throwable -> L21
        if (r106 == null) goto L16;
        IPitayaCore r107 = r106.getCore(r103.getKey());     // Catch: Throwable -> L21
    L17:
        r105.setRealCore$pitayacore_release(r107);     // Catch: Throwable -> L21
        goto L10
    L16:
        r107 = null;
        goto L17
    L18:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r101);
    }
}
