package mc9;

import com.bytedance.ttnet.priority.ModePriorityManagement;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.home.impl.AppInitReporter;
import com.larus.home.impl.utils.b;
import com.larus.im.bean.message.Message;
import com.larus.jato.api.IJato;
import com.larus.network.nqe.NQEUtils;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.l;
import com.larus.platform.api.m0;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.vivo.push.PushClientConstants;
import hu7.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qt9.b4;
import qt9.j1;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f513246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f513247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f513248c;

    static {
        f513246a = new a();
    }

    public a() {
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.larus.platform.api.m0
    public final void a() {
        Lazy r100 = c.f487258a;
        TTHttpCallPriorityControl.getInstance().resetToDefaultState();
    }

    @Override // com.larus.platform.api.m0
    public final void b() {
        Lazy r100 = c.f487258a;
        FLogger.f375446a.d("WeakNetworkUtils", "WeakNetworkUtils init");
        if (((Number) km9.c.f504111c.getValue()).intValue() <= 0) goto L6;
        NQEUtils.a(true);
        return;
    }

    @Override // com.larus.platform.api.m0
    public final void d() {
        Intrinsics.checkNotNullParameter("im_chat", "scene");
        Lazy r100 = c.f487258a;
        Intrinsics.checkNotNullParameter("im_chat", "key");
        Lazy r101 = c.f487258a;
        if (Intrinsics.areEqual(((j1) r101.getValue()).a(), Boolean.TRUE) == false) goto L13;
        HashMap<String, b4> r102 = ((j1) r101.getValue()).b();
        if (r102 == null) goto L12;
        b4 r103 = r102.get("im_chat");
        if (r103 == null) goto L14;
        ConcurrentHashMap<String, ModePriorityManagement> r104 = km9.c.f504109a;
        km9.c.a("im_chat", r103.a(), r103.b());
        return;
    L14:
        return;
    L12:
        return;
    }

    public final l f() {
        AppInitReporter r100 = AppInitReporter.f344102a;
        return new l(AppInitReporter.f344103b, AppInitReporter.f344104c, AppInitReporter.f344105d, AppInitReporter.f344106e, AppInitReporter.f344107f, AppInitReporter.f344108g, AppInitReporter.f344109h, AppInitReporter.f344110i);
    }

    public final long g() {
        AppInitReporter r100 = AppInitReporter.f344102a;
        Long r101 = AppInitReporter.f344111j;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public final boolean h() {
        AppInitReporter r100 = AppInitReporter.f344102a;
        if (AppInitReporter.f344114m == false) goto L5;
    L8:
        return true;
    L5:
        if (AppInitReporter.f344118q == true) goto L8;
        return false;
    }

    public final boolean i() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.r();
    L5:
        ChatFragment r101 = b.b(null);
        if (r101 != null) goto L37;
        return false;
    L37:
    L31:
        th = move-exception;
        FLogger.f375446a.e("ChatFragment", "isMessageGenerating err. msg=" + th);
    L33:
        boolean r102 = false;
    L34:
        if (r102 != true) goto L43;
        return true;
    L43:
        return false;
    L9:
        if (r101.isAdded() == false) goto L33;
        if (r101.getActivity() == null) goto L33;
        u7 r103 = r101.u3();     // Catch: Throwable -> L31
        if (r103 == null) goto L33;
        List<Message> r104 = r103.zj();     // Catch: Throwable -> L31
        if (r104 == null) goto L33;
        List<Message> r105 = r104;     // Catch: Throwable -> L31
        if ((r105 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L31
    L23:
        if (r106.hasNext() == false) goto L28;
        if (d.Q0((Message) r106.next()) == false) goto L23;
        boolean r107 = true;
    L29:
        if (r107 != true) goto L33;
        r102 = true;
    L28:
        r107 = false;
        goto L29
    L20:
        if (r105.isEmpty() == false) goto L22;
        goto L22
    }

    @Override // com.larus.platform.api.m0
    public final boolean c(long r100) {
        if (r100 > 0) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis();
        if ((r101 - f513247b) > f513248c) goto L8;
        return false;
    L8:
        f513247b = r101;
        f513248c = r100;
        IJato r102 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r102 == null) goto L13;
        r102.n(r100);
        return true;
    L13:
        return true;
    }

    public final e e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        return IAIChatControlTraceService.a.h(ChatControlTrace.f309996b, r100);
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        AppInitReporter r101 = AppInitReporter.f344102a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "activityName");     // Catch: Throwable -> L20
        if (AppInitReporter.f344113l == false) goto L9;
        monitor-exit(r101);
        return;
    L9:
        AppInitReporter.f344113l = true;     // Catch: Throwable -> L20
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L20
        r102.put("launcher_activity", r100);     // Catch: Throwable -> L20
        r102.put("is_cold_launch", !AppInitReporter.a(r100) ? 1 : 0);     // Catch: Throwable -> L20
        Long r103 = AppInitReporter.f344111j;     // Catch: Throwable -> L20
        if (r103 == null) goto L12;
        long r104 = r103.longValue();     // Catch: Throwable -> L20
    L14:
        if (r104 > 0) goto L16;
    L18:
        monitor-exit(r101);
        return;
    L16:
        if ((System.currentTimeMillis() - r104) > 30000) goto L18;
        AppInitReporter.c(AppInitReporter.ReportType.FIRST_FRAME_CHAT, r102);     // Catch: Throwable -> L20
        goto L18
    L12:
        r104 = 0;
    L20:
        th = move-exception;
        throw th;
    }
}
