package d00;

import android.os.Handler;
import com.bytedance.android.live.broadcast.api.monitor.game.GameLiveModule;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.config.ay;
import com.bytedance.android.livesdk.config.hi1;
import com.bytedance.android.livesdk.config.n6;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n6 f466156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f466157b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f466158c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f466159d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, hi1> f466160e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f466161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Handler f466162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C5612a f466163h = null;

    /* JADX INFO: renamed from: d00.a$a, reason: collision with other inner class name */
    public static final class C5612a {
        public C5612a() {
        }
    }

    public a() {
    }

    @GameLiveModule
    public abstract String c();

    static {
        f466163h = new C5612a();
        n6 r100 = ay.f119827a.getValue();
        f466156a = r100;
        f466157b = "webcast_client_game_live";
        f466158c = "anchor_screen_shot";
        f466159d = new d(0);
        f466160e = new HashMap();
        List<hi1> r101 = r100.b();
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        hi1 r103 = (hi1) r102.next();
        HashMap<String, hi1> r104 = f466160e;
        if (r104 == null) goto L6;
        hi1 r105 = r104.put(r103.b(), r103);
        goto L6
    L16:
        return;
    }

    public static c b() {
        d r100 = f466159d;
        r100.getClass();
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, r100.f466173c);
        BaseMonitor.add(r101, "retry_state", r100.f466174d);
        BaseMonitor.add(r101, "reconnect_state", r100.f466175e);
        BaseMonitor.add(r101, "push_duration", d.a(r100.f466176f));
        BaseMonitor.add(r101, "webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        BaseMonitor.add(r101, "saved_state_from_fragment", r100.f466178h);
        BaseMonitor.add(r101, "saved_state_from_activity", r100.f466179i);
        JSONObject r102 = new JSONObject();
        BaseMonitor.add(r102, "enter_fragment_duration", d.a(r100.f466177g));
        return new c(r101, r102, 2);
    }

    public final hi1 a() {
        boolean r100 = f466156a.a();
        HashMap<String, hi1> r101 = f466160e;
        if (r101 == null) goto L5;
        hi1 r102 = r101.get(c());
    L6:
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.a() != true) goto L10;
    L11:
        if (r100 == false) goto L15;
        if (r103 == false) goto L15;
        return r102;
    L15:
        return null;
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
