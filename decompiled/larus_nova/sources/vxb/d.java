package vxb;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, IBaseService> f557537a;

    public final void a() {
        if (((ConcurrentHashMap) this.f557537a).isEmpty() == false) goto L6;
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{"Services is empty!"});
        return;
    L6:
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{MapMonitorConst.EVENT_DESTROY});
        Iterator r100 = ((ConcurrentHashMap) this.f557537a).values().iterator();
    L8:
        if (r100.hasNext() == false) goto L12;
        IBaseService r101 = (IBaseService) r100.next();
        if (r101 == null) goto L8;
        r101.release();
        goto L8
    L12:
        ((ConcurrentHashMap) this.f557537a).clear();
    }

    public d() {
        this.f557537a = new ConcurrentHashMap();
    }
}
