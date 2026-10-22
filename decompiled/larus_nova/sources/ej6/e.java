package ej6;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.cs;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472877a = 0;

    public e() {
    }

    static {
    }

    public static void a(TraceEvent r100, String r101, int r102, String r110, JSONObject r111, int r112) {
        if ((r112 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r112 & 8) == 0) goto L8;
        r110 = "";
    L8:
        String r103 = null;
        if ((r112 & 16) == 0) goto L11;
        r111 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "traceEvent");
        Intrinsics.checkNotNullParameter(r101, "eventStep");
        Intrinsics.checkNotNullParameter(r110, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        if (cs.f119975a.getValue().booleanValue() == false) goto L39;
        j01.e r104 = new j01.e(r100.getEventName(), "live_link_core_process");     // Catch: Exception -> L34
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L34
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L34
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r104, "metaBuilder");     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r105, "category");     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r106, "metric");     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r113, "extra");     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter("webcast_client_live_link", "idString");     // Catch: Exception -> L34
        r104.f496788a.f522477e = "webcast_client_live_link";     // Catch: Exception -> L34
        r104.g(r101);     // Catch: Exception -> L34
        r104.f(0);     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r110, "msg");     // Catch: Exception -> L34
        r104.f496788a.f522483k = r110;     // Catch: Exception -> L34
        IRoomContextService r107 = (IRoomContextService) k.f(IRoomContextService.class);     // Catch: Exception -> L34
        if (r107 == null) goto L21;
        o r108 = r107.getRoomDataContext(null);     // Catch: Exception -> L34
        if (r108 == null) goto L21;
        Room r109 = r108.getCurrentRoom();     // Catch: Exception -> L34
        if (r109 == null) goto L21;
        Long r114 = Long.valueOf(r109.getRoomId());     // Catch: Exception -> L34
    L22:
        r104.e(String.valueOf(r114));     // Catch: Exception -> L34
        IMiddlewareUserService r115 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);     // Catch: Exception -> L34
        if (r115 == null) goto L27;
        com.bytedance.android.livesdk.user.e r116 = r115.user();     // Catch: Exception -> L34
        if (r116 == null) goto L27;
        r103 = r116.n();     // Catch: Exception -> L34
    L27:
        if (r103 == null) goto L29;
        r104.i(r103);     // Catch: Exception -> L34
    L29:
        Intrinsics.checkNotNullParameter(r113, "json");     // Catch: Exception -> L34
        if (r111 == null) goto L32;
        Intrinsics.checkNotNullParameter(r111, "jsonObject");     // Catch: Exception -> L34
        j01.d.a(r113, r111);     // Catch: Exception -> L34
    L32:
        ((j01.b) f.a(j01.b.class)).R4(r104.f496788a, r105, r106, r113);     // Catch: Exception -> L34
        return;
    L21:
        r114 = null;
    L34:
        e = move-exception;
        int r117 = a.f472874a;
        a.b("TraceMonitor", "sendEvent error, traceEvent: " + r100 + ", eventStep: " + r101 + ", statusCode: " + r102 + ", statusMsg: " + r110 + ", extraInfo: " + r111 + ", ex: " + e);
        return;
    }
}
