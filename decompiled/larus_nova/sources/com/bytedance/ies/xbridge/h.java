package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class<? extends IDLXBridgeMethod> f249499a;

    public h(Class<? extends IDLXBridgeMethod> r100) {
        this.f249499a = r100;
    }

    public final void a() {
        Map<Class<? extends IDLXBridgeMethod>, String> r100 = i.f249500a;
        Class<? extends IDLXBridgeMethod> r101 = this.f249499a;
        Class r102 = i.a(r101, XBridgeParamModel.class);
        if (r102 == null) goto L7;
        Class r103 = i.a(r101, XBridgeResultModel.class);
        if (r103 == null) goto L7;
        HashMap r104 = new HashMap();
        c r105 = new c(r102, r103, i.b(r102, r104), i.b(r103, r104), r104);
    L9:
        if (r105 == null) goto L12;
        i.f249501b.put(r101, r105);
        i.f249502c.put(r105.f249459b, r101);
        return;
    L12:
        return;
    L7:
        r105 = null;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
