package com.bytedance.upc.bridge;

import com.bytedance.upc.b;
import id7.c;
import id7.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/upc/bridge/UpcBridgeService;", "Lcom/bytedance/upc/b;", "", "init", "<init>", "()V", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public final class UpcBridgeService implements b {
    public UpcBridgeService() {
    }

    @Override // com.bytedance.upc.b
    public void init() {
        boolean r100 = ip7.b.f495310a;
        c r101 = c.f489341a;
        d r102 = new d();
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r102, "config");     // Catch: Throwable -> L9
        if (c.f489342b == true) goto L7;
        c.f489344d = r102;     // Catch: Throwable -> L9
        c.f489342b = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
