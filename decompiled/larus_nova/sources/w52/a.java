package w52;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558316a = 0;

    static {
    }

    @JvmStatic
    public static final void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "engineName");
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        Room r104 = r103.getValue();
    L8:
        LiveMonitor.a r105 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInit, r104, null);
        r105.l(0);
        r105.m("init engine success");
        r105.e(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, r100);
        r105.h(r101);
        r105.a().report();
        return;
    L7:
        r104 = null;
        goto L8
    }

    @JvmStatic
    public static final void c(boolean r100, long r101) {
        LiveMonitor.a r102 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInstallPlugin, null, null);
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r102.l(r103);
        if (r100 == false) goto L9;
        String r104 = "success";
    L10:
        r102.m(r104);
        r102.h(r101);
        r102.a().report();
        return;
    L9:
        r104 = "failed";
        goto L10
    L5:
        r103 = -1;
        goto L6
    }

    @JvmStatic
    public static final void a(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "engineName");
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L7;
        m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L7;
        Room r105 = r104.getValue();
    L8:
        LiveMonitor.a r106 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInit, r105, null);
        r106.l(r101);
        r106.m("init engine failed");
        r106.e(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, r100);
        r106.h(r102);
        r106.a().report();
        return;
    L7:
        r105 = null;
        goto L8
    }

    @JvmStatic
    public static final void d(int r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        LiveMonitor.a r103 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineLoadPlugin, null, null);
        r103.l(r100);
        r103.m(r101);
        r103.h(r102);
        r103.a().report();
    }

    public static void e(InteractivityMonitor.Event r100, Throwable r101, long r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r103 = "null";
        if ((r101 instanceof CustomApiServerException) == false) goto L13;
        CustomApiServerException r104 = (CustomApiServerException) r101;
        int r105 = r104.getErrorCode();
        String r106 = r104.getErrorMsg();
        if (r106 != null) goto L9;
        r106 = "known server error";
    L9:
        String r107 = r104.getXTtLogId();
        if (r107 == null) goto L17;
        r103 = r107;
    L17:
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r108 == null) goto L22;
        m<Room> r109 = r108.getRoom();
        if (r109 == null) goto L22;
        Room r110 = r109.getValue();
    L23:
        LiveMonitor.a r111 = InteractivityMonitor.a(r100, r110, null);
        r111.l(r105);
        r111.m(r106);
        r111.h(System.currentTimeMillis() - r102);
        r111.i("logId", r103);
        r111.a().report();
        return;
    L22:
        r110 = null;
        goto L23
    L13:
        String r112 = r101.getMessage();
        if (r112 != null) goto L16;
        r112 = "unknown local error";
    L16:
        r106 = r112;
        r105 = -10086;
        goto L17
    }

    public static void f(InteractivityMonitor.Event r100, String r101, long r102) {
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L7;
        m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L7;
        Room r105 = r104.getValue();
    L8:
        LiveMonitor.a r106 = InteractivityMonitor.a(r100, r105, null);
        r106.l(0);
        r106.m("success");
        r106.h(System.currentTimeMillis() - r102);
        if (r101 != null) goto L11;
        r101 = "null";
    L11:
        r106.i("logId", r101);
        r106.a().report();
        return;
    L7:
        r105 = null;
        goto L8
    }
}
