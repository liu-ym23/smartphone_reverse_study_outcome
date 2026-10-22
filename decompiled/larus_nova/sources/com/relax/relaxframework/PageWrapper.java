package com.relax.relaxframework;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R&\u0010\f\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/PageWrapper;", "", "Lcom/relax/relaxframework/k3;", "listenerMap", "", "setPagePhaseListener", "", "Lcom/relax/relaxframework/RELAXElement;", "rawRelaxPage", "enterForeground", "enterBackground", MapMonitorConst.EVENT_DESTROY, "rawPtr", "J", "getRawPtr", "()J", "setRawPtr", "(J)V", "Lcom/relax/relaxframework/k3;", "<init>", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public class PageWrapper {
    private k3 listenerMap;
    private long rawPtr;

    public void destroy() {
        k3 r100 = this.listenerMap;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        r100.f405168c.invoke();
        return;
    }

    public void enterBackground() {
        k3 r100 = this.listenerMap;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        r100.f405167b.invoke();
        return;
    }

    public void enterForeground() {
        k3 r100 = this.listenerMap;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        r100.f405166a.invoke();
        return;
    }

    public final long getRawPtr() {
        return this.rawPtr;
    }

    public long rawRelaxPage() {
        return this.rawPtr;
    }

    public PageWrapper(long r100) {
        this.rawPtr = r100;
    }

    public void setPagePhaseListener(k3 r100) {
        Intrinsics.checkNotNullParameter(r100, "listenerMap");
        this.listenerMap = r100;
    }

    public final void setRawPtr(long r100) {
        this.rawPtr = r100;
    }
}
