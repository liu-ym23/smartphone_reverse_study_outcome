package tc0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import tf0.i;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends ge1.a<Boolean> implements i {
    public static c R;
    public static final Map<String, c> S = null;
    public com.bytedance.android.livesdk.message.linker.b A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public String H;
    public Boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f545346J;
    public int K;
    public LinkMatchType L;
    public String M;
    public boolean N;
    public l6 O;
    public n0 P;
    public long Q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f545347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f545348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f545349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f545350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f545351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f545352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f545353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f545354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public v f545355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f545356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v1 f545357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<Long, ? extends g2> f545358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map.Entry<Long, ? extends g2> f545359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g2 f545360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public u1 f545361r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e0 f545362s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap<String, Long> f545363t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f545364u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f545365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f545366w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f545367x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f545368y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f545369z;

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Boolean] */
    public final void k() {
        this.f545351h = 0;
        this.f545352i = 0;
        this.f545347d = 0;
        this.f481009b = Boolean.FALSE;
        this.f545349f = null;
        this.f545353j = 0;
        this.f545365v = 0;
        this.f545354k = "";
        this.f545356m = "";
        this.f545357n = null;
        this.f545361r = null;
        this.f545369z = "";
        this.K = LinkApplyType.NORMAL.getValue();
        this.L = LinkMatchType.NONE;
        this.M = "";
        this.N = false;
        this.P = null;
        this.Q = 0;
        this.H = "";
        this.O = null;
        this.D = false;
        ALogger.i("ttlive_link", "LinkInRoomDataHolder reset");
    }

    static {
        S = new ConcurrentHashMap();
    }

    public static c h() {
        if (R != null) goto L6;
        R = new c();
    L6:
        return R;
    }

    public final String f() {
        com.bytedance.android.livesdk.message.linker.b r100 = this.A;
        if (r100 == null) goto L9;
        if (r100.isUseBackup() == false) goto L9;
        return this.A.getLinkmicIdStr();
    L9:
        return this.f545348e;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Boolean] */
    public c() {
        this.f545369z = "";
        this.F = "";
        this.H = "";
        ?? r100 = Boolean.FALSE;
        this.I = r100;
        this.f545346J = 0;
        this.L = LinkMatchType.NONE;
        this.N = false;
        this.P = null;
        this.Q = 0;
        this.f481009b = r100;
        this.f545363t = new HashMap();
    }

    @Override // tf0.i
    public final long getChannelId() {
        Room r100 = m.i().getCurrentRoom();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getId();
    }

    @Override // tf0.i
    public final String getInteractId() {
        return this.f545349f;
    }

    @Override // tf0.i
    public final String getRtcInfo() {
        return this.f545354k;
    }

    @Override // tf0.i
    public final int getScene() {
        return this.B;
    }

    @Override // tf0.i
    public final String u() {
        return this.f545348e;
    }

    public static c i(String r100) {
        if (r100 == null) goto L21;
        if (r100.isEmpty() == true) goto L21;
        Map<String, c> r101 = S;
        c r102 = (c) ((ConcurrentHashMap) r101).get(r100);
        if (r102 == null) goto L9;
    L19:
        return r102;
    L9:
        monitor-enter(c.class);
        r102 = (c) ((ConcurrentHashMap) r101).get(r100);     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
        r102 = new c();     // Catch: Throwable -> L17
        ((ConcurrentHashMap) r101).put(r100, r102);     // Catch: Throwable -> L17
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        return h();
    }

    @Override // tf0.i
    public final void D0(com.bytedance.android.livesdk.message.linker.b r100) {
        this.A = r100;
    }

    @Override // tf0.i
    public final void R0(int r100) {
        this.f545364u = r100;
    }

    @Override // tf0.i
    public final void a(String r100) {
        this.f545354k = r100;
    }

    @Override // tf0.i
    public final void b(int r100) {
        this.f545353j = r100;
    }

    @Override // tf0.i
    public final void c1(String r100) {
        this.f545348e = r100;
    }

    public final Map.Entry<Long, ? extends g2> g(String r100) {
        int r101 = e.f545372a;
        Map<Long, ? extends g2> r102 = this.f545358o;
        if (r102 == null) goto L39;
        Set<Map.Entry<Long, ? extends g2>> r103 = r102.entrySet();
        if (r103 == null) goto L40;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L41;
        Map.Entry<Long, ? extends g2> r105 = (Map.Entry) r104.next();
        g2 r106 = r105.getValue();
        if (r106 == null) goto L8;
        List<k> r107 = r106.getLinkedUsers();
        if (r107 == null) goto L8;
        Iterator<T> r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        IBaseUser r110 = ((k) r109).getUser();
        if (r110 == null) goto L19;
        String r111 = r110.getUserId();
    L21:
        if (Intrinsics.areEqual(r111, r100) == false) goto L15;
    L25:
        if (((k) r109) == null) goto L8;
        return r105;
    L19:
        r111 = null;
        goto L21
    L23:
        r109 = null;
        goto L25
    L41:
        return null;
    L40:
        return null;
    L39:
        return null;
    }

    public final void j(Boolean r100) {
        d(r100);
        if (r100 == null) goto L6;
        r100.booleanValue();
        return;
    }

    public final void l(Map<Long, ? extends g2> r100) {
        this.f545358o = r100;
        if (r100 == null) goto L8;
        Map.Entry<Long, ? extends g2> r101 = z0.a(r100);
        this.f545359p = r101;
        if (r101 == null) goto L9;
        this.f545360q = r101.getValue();
        return;
    L9:
        return;
    }

    @Override // tf0.i
    public final void setInteractId(String r100) {
        this.f545349f = r100;
    }

    @Override // tf0.i
    public final void setScene(int r100) {
        this.B = r100;
    }
}
