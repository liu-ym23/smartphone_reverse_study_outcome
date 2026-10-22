package qs2;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.room.LiveScope;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import ls2.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f534642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, C7386a> f534643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f534644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, C7386a>> f534645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f534646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f534647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final T f534648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveScope f534649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ks2.c f534650i;

    /* JADX INFO: renamed from: qs2.a$a, reason: collision with other inner class name */
    public static final class C7386a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f534651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f534652b;

        public C7386a() {
            this(0, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7386a) == false) goto L10;
            C7386a r101 = (C7386a) r100;
            if (this.f534651a == r101.f534651a) goto L8;
            return false;
        L8:
            if (this.f534652b == r101.f534652b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f534651a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f534652b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "BaseDuration(startDuration=" + this.f534651a + ", stopDuration=" + this.f534652b + ")";
        }

        public C7386a(long r100, int r101) {
            long r102 = -1;
            if ((r101 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r101 & 2) != 0) goto L9;
            r102 = 0;
        L9:
            this.f534651a = r100;
            this.f534652b = r102;
        }
    }

    public abstract boolean a(String r100, Map<String, String> r101);

    public abstract boolean c(String r100);

    public final boolean b() {
        ks2.c r100 = this.f534650i;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f505903a != true) goto L7;
        return true;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        if (b() == true) goto L6;
        return;
    L6:
        if (this.f534643b.containsKey(r100) == false) goto L8;
        C7386a r101 = (C7386a) ((LinkedHashMap) this.f534643b).get(r100);
    L9:
        if (r101 == null) goto L12;
        r101.f534651a = System.currentTimeMillis();
        this.f534643b.put(r100, r101);
        return;
    L12:
        return;
    L8:
        r101 = new C7386a(0, 3);
        goto L9
    }

    public final void g(String r110) {
        Intrinsics.checkNotNullParameter(r110, "nodeName");
        if (b() == true) goto L5;
        return;
    L5:
        C7386a r100 = (C7386a) ((LinkedHashMap) this.f534643b).get(r110);
        if (r100 == null) goto L8;
        r100.f534652b = System.currentTimeMillis();
    L8:
        long r101 = 0L;
        T r102 = this.f534648g;
        if ((r102 instanceof ls2.b) == false) goto L14;
        ls2.b r103 = (ls2.b) r102;
        r101 = r103.f510496c;
        Fragment r104 = r103.f510501h;
        if (r104 == null) goto L16;
        r104.hashCode();
    L16:
        Intrinsics.checkNotNullParameter(r110, "nodeName");
        if (b() == true) goto L20;
        return;
    L20:
        if (c(r110) == false) goto L62;
        int r105 = b.f534653a[this.f534649h.ordinal()];
        if (r105 == 1) goto L30;
        if (r105 == 2) goto L25;
        Long r106 = null;
    L33:
        if (r106 == null) goto L62;
        long r111 = r106.longValue();
        LinkedHashMap r107 = new LinkedHashMap();
        int r112 = b.f534654b[this.f534649h.ordinal()];
        if (r112 == 1) goto L46;
        if (r112 == 2) goto L38;
        r107.put("live_scope", this.f534649h.name());
    L52:
        Iterator r108 = ((LinkedHashMap) this.f534643b).entrySet().iterator();
    L54:
        if (r108.hasNext() == false) goto L56;
        Map.Entry r113 = (Map.Entry) r108.next();
        String r114 = ((String) r113.getKey()) + "_duration";
        C7386a r115 = (C7386a) r113.getValue();
        r107.put(r114, String.valueOf(r115.f534652b - r115.f534651a));
        r107.put(((String) r113.getKey()) + "_total_duration", String.valueOf(((C7386a) r113.getValue()).f534652b - r111));
        goto L54
    L56:
        this.f534644c.putAll(r107);
        ((LinkedHashMap) this.f534643b).clear();
        goto L62
    L38:
        T r116 = this.f534648g;
        if (r116 == null) goto L45;
        if (((d) r116).f510514c == false) goto L43;
        r107.put("live_scope", "OUT_SESSION");
        goto L52
    L43:
        r107.put("live_scope", LiveScope.SESSION.name());
        goto L52
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.data.LiveSessionContext");
    L46:
        r107.put("live_scope", this.f534649h.name());
        T r109 = this.f534648g;
        if (r109 == null) goto L58;
        ls2.b r117 = (ls2.b) r109;
        Long r118 = r117.f510496c;
        if (r118 == null) goto L51;
        r107.put("room_id", String.valueOf(r118.longValue()));
    L51:
        r107.put("is_first_room", String.valueOf(r117.f510506m));
        goto L52
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.data.LiveBaseRoomContext");
    L25:
        T r119 = this.f534648g;
        if (r119 == null) goto L29;
        r106 = ((d) r119).f510522k;
        goto L33
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.data.LiveSessionContext");
    L30:
        T r120 = this.f534648g;
        if (r120 == null) goto L60;
        r106 = ((ls2.b) r120).f510507n;
        goto L33
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.data.LiveBaseRoomContext");
    L62:
        if (a(r110, this.f534644c) == false) goto L109;
        int r121 = ps2.c.f530435a;
        ps2.c.c(this.f534649h.name(), this.f534644c.toString());
        qm0.b r122 = om0.c.g();
        boolean r123 = false;
        if (r122 == null) goto L66;
        r122.sendLog(this.f534646e, this.f534644c, new Object[0]);
    L66:
        JSONObject r124 = new JSONObject();
        r124.put("scope", this.f534649h.name());
        if (this.f534649h != LiveScope.ROOM) goto L73;
        T r125 = this.f534648g;
        if (r125 == null) goto L72;
        r123 = ((ls2.b) r125).f510506m;
        goto L73
    L72:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.room.data.LiveBaseRoomContext");
    L73:
        r124.put("is_first_room", r123);
        JSONObject r126 = new JSONObject();
        Iterator r127 = ((LinkedHashMap) this.f534645d).entrySet().iterator();
    L75:
        if (r127.hasNext() == false) goto L90;
        Map.Entry r128 = (Map.Entry) r127.next();
        Iterator r129 = ((Map) r128.getValue()).entrySet().iterator();
    L78:
        if (r129.hasNext() == false) goto L75;
        Map.Entry r130 = (Map.Entry) r129.next();
        if (((C7386a) r130.getValue()).f534651a <= 0) goto L78;
        if (((C7386a) r130.getValue()).f534652b <= 0) goto L78;
        long r131 = (((C7386a) r130.getValue()).f534652b - ((C7386a) r130.getValue()).f534651a) / ((long) 1000000);
        if (r131 <= 0) goto L78;
        if (r131 < this.f534642a) goto L78;
        r126.put(((String) r130.getKey()) + '_' + ((String) r128.getKey()), r131);
        int r132 = ps2.c.f530435a;
        String r133 = ((String) r130.getKey()) + '_' + ((String) r128.getKey()) + " is slow, time = " + r131;
        Intrinsics.checkNotNullParameter(r133, "msg");
        pm0.b r134 = om0.c.f();
        if (r134 == null) goto L78;
        r134.w("liveLifecyclePer_w", r133);
        goto L78
    L90:
        JSONObject r135 = new JSONObject();
        r135.put("room_id", r101);
        int r136 = ps2.c.f530435a;
        ps2.c.c(this.f534649h.name(), " category = " + r124 + ", metric = " + r126 + ", extra = " + r135);
        wm0.a r137 = om0.c.h();
        if (r137 == null) goto L110;
        r137.d(this.f534647f, r124, r126, r135);
        return;
    L110:
        return;
    L109:
        return;
    L14:
        if ((r102 instanceof d) == false) goto L16;
        r101 = 0L;
        this.f534648g.hashCode();
        goto L16
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "businessName");
        if (b() == true) goto L6;
        return;
    L6:
        if (((LinkedHashMap) this.f534645d).get(r100) != null) goto L8;
        this.f534645d.put(r100, new LinkedHashMap());
    L8:
        Map r102 = (Map) ((LinkedHashMap) this.f534645d).get(r100);
        if (r102 == null) goto L11;
        r102.put(r101, new C7386a(System.nanoTime(), 2));
    L11:
        int r103 = ps2.c.f530435a;
        ps2.c.c("startExecutionBusiness", r100 + ", " + r101);
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "businessName");
        if (b() == true) goto L5;
        return;
    L5:
        Map r102 = (Map) ((LinkedHashMap) this.f534645d).get(r100);
        if (r102 == null) goto L10;
        C7386a r103 = (C7386a) r102.get(r101);
        if (r103 == null) goto L10;
        r103.f534652b = System.nanoTime();
    L10:
        int r104 = ps2.c.f530435a;
        ps2.c.c("stopExecutionBusiness", r100 + ", " + r101);
    }

    public a(T r100, LiveScope r101, ks2.c r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f534648g = r100;
        this.f534649h = r101;
        this.f534650i = r102;
        this.f534642a = 2;
        this.f534643b = new LinkedHashMap();
        this.f534644c = new LinkedHashMap();
        this.f534645d = new LinkedHashMap();
        this.f534646e = "livesdk_enter_room_node_monitor";
        this.f534647f = "livesdk_enter_room_business_monitor";
    }
}
