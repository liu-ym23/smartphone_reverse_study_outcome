package ku0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import nu0.l;
import org.json.JSONObject;
import zf2.q;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f506176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f506177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f506178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ku0.a f506179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ku0.b f506180e;

    public static final class a {
    }

    public static final class b extends ag2.a {
        public b() {
        }
    }

    /* JADX INFO: renamed from: ku0.c$c, reason: collision with other inner class name */
    public static final class C6612c extends ag2.c {
        public C6612c() {
        }
    }

    static {
    }

    public final void b() {
        ALogger.i("ProfitRTCEngine", "rtc leaveRoom");
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().destroyRTCEngine();
    }

    public final boolean a(lu0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
        d60.b.a(r101, "rtc.device_id", ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).getServerDeviceId());     // Catch: Exception -> L6
        d60.b.a(r101, "rtc.audio_mode_strategy", new JSONObject("{\"Default\":1,\"ChatRoom\":1,\"GameStreaming\":1,\"Chorus\":1}"));     // Catch: Exception -> L6
        ALogger.i("ProfitRTCEngine", "createRTCVideo");     // Catch: Exception -> L6
        q r102 = new q();     // Catch: Exception -> L6
        r102.f571740a = this.f506178c;     // Catch: Exception -> L6
        ILiveWrappedRtcService.Companion.getClass();     // Catch: Exception -> L6
        ILiveWrappedRtcService.a.a().createRTCEngine(r102, this.f506177b);     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        ALogger.i("ProfitRTCEngine", e.getMessage());
        return false;
    }

    public c(Context r100, ku0.a r101, ku0.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f506178c = r100;
        this.f506179d = r101;
        this.f506180e = r102;
        new ArrayList();
        new ArrayList();
        iu0.a r103 = (iu0.a) l.f520587c.getValue(null, l.f520585a[1]);
        this.f506177b = new b();
        new C6612c();
    }
}
