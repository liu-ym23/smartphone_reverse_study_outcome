package bm2;

import am2.c0;
import am2.d;
import am2.d0;
import am2.f;
import am2.g;
import am2.h;
import am2.i;
import am2.k;
import am2.m;
import am2.n;
import am2.p;
import am2.q;
import am2.r;
import am2.s;
import am2.u;
import am2.w;
import am2.z;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.log.filter.a0;
import com.bytedance.android.livesdk.log.filter.b0;
import com.bytedance.android.livesdk.log.filter.c;
import com.bytedance.android.livesdk.log.filter.e;
import com.bytedance.android.livesdk.log.filter.e0;
import com.bytedance.android.livesdk.log.filter.f0;
import com.bytedance.android.livesdk.log.filter.g0;
import com.bytedance.android.livesdk.log.filter.h0;
import com.bytedance.android.livesdk.log.filter.i0;
import com.bytedance.android.livesdk.log.filter.j;
import com.bytedance.android.livesdk.log.filter.l;
import com.bytedance.android.livesdk.log.filter.l0;
import com.bytedance.android.livesdk.log.filter.m0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.o0;
import com.bytedance.android.livesdk.log.filter.p0;
import com.bytedance.android.livesdk.log.filter.q0;
import com.bytedance.android.livesdk.log.filter.r0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.filter.v0;
import com.bytedance.android.livesdk.log.filter.w0;
import com.bytedance.android.livesdk.log.filter.x;
import com.bytedance.android.livesdk.log.filter.x0;
import com.bytedance.android.livesdk.log.filter.y;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final HashMap<Class<?>, o<?>> a = null;
    public static final HashMap<Class<?>, o<?>> b = null;
    public static final Map<String, HashMap<Class<?>, o<?>>> c = null;

    static {
        HashMap<Class<?>, o<?>> r0 = new HashMap();
        r0.put(d.class, new e());
        x0 r1 = new x0();
        r0.put(User.class, r1);
        r0.put(IBaseUser.class, r1);
        r0.put(z.class, new p0());
        r0.put(u.class, new i0());
        r0.put(PadLoggerData.class, new m0());
        r0.put(r.class, new e0());
        r0.put(i.class, new l());
        a = r0;
        HashMap<Class<?>, o<?>> r2 = new HashMap();
        com.bytedance.android.livesdk.log.filter.z r3 = new com.bytedance.android.livesdk.log.filter.z();
        r2.put(n.class, r3);
        r2.put(k.class, r3);
        r2.put(y.class, new g0());
        r2.put(s.class, new f0());
        b = r2;
        c = new ConcurrentHashMap();
    }

    public static Map a() {
        HashMap r0 = new HashMap();
        r0.put(w.class, new l0());
        r0.put(c0.class, new q0());
        r0.put(f.class, new com.bytedance.android.livesdk.log.filter.i());
        r0.put(am2.e0.class, new v0());
        r0.put(d0.class, new r0());
        r0.put(am2.a.class, new com.bytedance.android.livesdk.log.filter.b());
        r0.put(g.class, new j());
        r0.put(h.class, new com.bytedance.android.livesdk.log.filter.k());
        r0.put(am2.f0.class, new w0());
        r0.put(FollowLog.class, new com.bytedance.android.livesdk.log.filter.h());
        r0.put(am2.b.class, new c());
        r0.put(m.class, new x());
        return r0;
    }

    public static HashMap b() {
        HashMap r0 = new HashMap();
        s0 r1 = new s0();
        r0.put(Room.class, r1);
        r0.put(IRoom.class, r1);
        r0.put(p.class, new com.bytedance.android.livesdk.log.filter.c0());
        r0.put(am2.l.class, new com.bytedance.android.livesdk.log.filter.w());
        r0.put(com.bytedance.android.livesdk.log.filter.n.class, new a0());
        n0 r2 = new n0();
        r2.c("event_page", "live_take_detail");
        r0.put(am2.x.class, r2);
        r0.put(t.class, r2);
        r0.put(am2.c.class, new com.bytedance.android.livesdk.log.filter.d());
        r0.put(q.class, new com.bytedance.android.livesdk.log.filter.d0());
        r0.put(am2.t.class, new h0());
        r0.put(am2.o.class, new b0());
        r0.put(am2.y.class, new o0());
        return r0;
    }
}
