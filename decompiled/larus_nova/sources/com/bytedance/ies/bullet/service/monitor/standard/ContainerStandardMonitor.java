package com.bytedance.ies.bullet.service.monitor.standard;

import android.view.View;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.larus.bmhome.share.panel.ShareChannel;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz2.b;
import org.json.JSONObject;
import s26.d;
import sz2.e;
import sz2.f;
import w26.g;
import w26.h;
import x26.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J8\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/standard/ContainerStandardMonitor;", "", "()V", "TYPE_LYNX", "", "TYPE_WEB", TextureRenderKeys.KEY_MODULE_NAME, "schemaLogMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addContext", "", "monitorId", "key", "value", LynxViewpagerItem.BIND_ON_ATTACH, "sessionId", "view", "Landroid/view/View;", "type", "batchCollect", "data", "Lorg/json/JSONObject;", ShareChannel.COLLECT, "field", "enableCollect", "", "invalidateID", "reportError", "errCode", "errorMsg", "virtualAid", "biz", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ContainerStandardMonitor {
    public static final ContainerStandardMonitor INSTANCE = null;
    private static final String TYPE_LYNX = "lynx";
    private static final String TYPE_WEB = "web";
    private static final String moduleName = "Monitor-Standard";
    private static final ConcurrentHashMap<String, Integer> schemaLogMap = null;

    private ContainerStandardMonitor() {
    }

    static {
        INSTANCE = new ContainerStandardMonitor();
        schemaLogMap = new ConcurrentHashMap(16);
    }

    private final boolean enableCollect() {
        d r100 = d.f540305c;
        r r101 = (r) d.f540305c.c(r.class);
        if (r101 != null) goto L5;
        Lazy<MonitorReportService> r102 = MonitorReportService.f247964d;
        r101 = MonitorReportService.a.a();
    L5:
        q0 r103 = r101.getMonitorConfig();
        Map<String, Map<Class<?>, Object>> r104 = a.f562251a;
        g r105 = (g) a.a(g.class);
        if (r105 == null) goto L8;
        h r106 = (h) r105.n0(h.class);
    L10:
        if (r103.f247896b == true) goto L18;
        if (r106 == null) goto L13;
        boolean r107 = r106.f();
    L14:
        if (r107 == true) goto L19;
        return false;
    L19:
        return true;
    L13:
        r107 = true;
        goto L14
    L18:
        return true;
    L8:
        r106 = null;
        goto L10
    }

    public final void invalidateID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        if (enableCollect() == true) goto L5;
        return;
    L5:
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.j("invalidateID_" + r100, LogLevel.I, moduleName);
        e.f543917a.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        e.f543920d.post(new sz2.d(r100));
        schemaLogMap.remove(r100);
    }

    public final void batchCollect(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "data");
        e.f543917a.getClass();
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_PARAMS);
        b.f("ContainerStandardApi", "batchCollect [monitorId:" + r100 + ']');
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        e r104 = e.f543917a;
        Object r105 = r101.get(r103);
        r104.getClass();
        e.i(r100, r103, r105);
        goto L4
    }

    public final void addContext(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        SLMonitorCompat.f41001a.getClass();
        SLMonitorCompat.b(r100, r101, r102);
        e.f543917a.getClass();
        e.a(r100, r101, r102);
    }

    public final void attach(String r100, View r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (enableCollect() == true) goto L5;
        return;
    L5:
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.j("attach_" + r100 + '_' + r102, LogLevel.I, moduleName);
        if (Intrinsics.areEqual(r102, "lynx") == false) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        f r105 = new f(r101, r102);
    L12:
        if (r105 == null) goto L15;
        e.f543917a.getClass();
        e.b(r100, r105);
        return;
    L15:
        return;
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = Intrinsics.areEqual(r102, "web");
        goto L9
    }

    public final void collect(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "data");
        if (enableCollect() == true) goto L6;
        return;
    L6:
        if (com.bytedance.ies.bullet.service.base.h.h() == true) goto L9;
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.j("collect_" + r100 + '_' + r101, LogLevel.I, moduleName);
    L9:
        if (Intrinsics.areEqual(r101, "schema") == false) goto L11;
    L12:
        ConcurrentHashMap<String, Integer> r104 = schemaLogMap;
        if (r104.contains(r100) == true) goto L29;
        r104.put(r100, 1);
    L16:
        if ((r102 instanceof String) == false) goto L19;
        e.f543917a.getClass();
        e.f(r100, r101, (String) r102);
        return;
    L19:
        if ((r102 instanceof Boolean) == false) goto L22;
        e r105 = e.f543917a;
        boolean r106 = ((Boolean) r102).booleanValue();
        r105.getClass();
        e.c(r100, r101, r106);
        return;
    L22:
        if ((r102 instanceof Integer) == false) goto L25;
        e r107 = e.f543917a;
        int r108 = ((Integer) r102).intValue();
        r107.getClass();
        e.d(r100, r101, r108);
        return;
    L25:
        if ((r102 instanceof Long) == false) goto L27;
        e r109 = e.f543917a;
        long r110 = ((Long) r102).longValue();
        r109.getClass();
        e.e(r100, r101, r110);
        return;
    L27:
        e r111 = e.f543917a;
        String r112 = r102.toString();
        r111.getClass();
        e.f(r100, r101, r112);
        return;
    L29:
        return;
    L11:
        if (Intrinsics.areEqual(r101, "open_time") == false) goto L16;
        goto L12
    }

    public final void reportError(View r100, String r101, int r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        Intrinsics.checkNotNullParameter(r104, "virtualAid");
        Intrinsics.checkNotNullParameter(r105, "biz");
        if (enableCollect() == true) goto L5;
        return;
    L5:
        ExecutorService r106 = BulletLogger.f247763a;
        BulletLogger.j("reportError_" + r101 + '_' + r102 + '_' + r103, LogLevel.I, moduleName);
        sz2.b r107 = new sz2.b(r102, r103, r104, r105);
        e.f543917a.getClass();
        e.j(r100, r101, r107);
    }
}
