package e36;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.kit.bridge.c;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import h16.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import s26.d;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.startRecord", owner = "zhaoxin")
public final class a extends c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f470922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBridgeMethod.Access f470923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470924e;

    /* JADX INFO: renamed from: e36.a$a, reason: collision with other inner class name */
    public static final class C5734a {
    }

    static {
    }

    private final BulletContext getContext() {
        e r100 = (e) this.f470922c.c(e.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f470923d;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f470924e;
    }

    public a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f470922c = r100;
        this.f470923d = IBridgeMethod.Access.PRIVATE;
        this.f470924e = "bullet.startRecord";
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r210, IBridgeMethod.a r211) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        BulletContext r100 = getContext();
        d36.c r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getSessionId();
    L6:
        if (r102 != null) goto L9;
        r211.onError(-1, "no sessionId");
        return;
    L9:
        boolean r103 = r210.optBoolean("once");
        String r104 = r210.optString("key");
        Object r105 = r210.opt("frequency");
        Object r106 = r210.opt("category");
        if ((r106 instanceof Map) == false) goto L12;
        Map r107 = (Map) r106;
    L13:
        BulletContext r108 = getContext();
        if (r108 == null) goto L22;
        AbsBulletMonitorCallback r109 = r108.f246435c;
        if (r109 == null) goto L22;
        if (r107 == null) goto L19;
        JSONObject r110 = new JSONObject(r107);
    L20:
        r109.n("", r110, null);
        goto L22
    L19:
        r110 = null;
    L22:
        if (r104 == null) goto L87;
        ConcurrentHashMap<String, ScheduledExecutorService> r111 = d36.a.f466717b;
        JSONObject r112 = new JSONObject();
        r112.put("user_interactive_key", r104);
        if (r105 == null) goto L26;
        r112.put("frequency", r105);
    L26:
        r112.put("once", r103);
        Unit r113 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r112, "json");
        Lazy<BulletContextManager> r114 = BulletContextManager.f246459b;
        BulletContext r115 = BulletContextManager.a.a().getContext(r102);
        if (r115 == null) goto L31;
        com.bytedance.ies.bullet.core.e r116 = r115.f246455w;
        if (r116 == null) goto L31;
        Object r117 = r116.f246482j;
    L33:
        if ((r117 instanceof d36.c) == false) goto L35;
        d36.c r118 = (d36.c) r117;
    L37:
        if (r118 == null) goto L43;
        AtomicBoolean r119 = r118.f466731c;
        if (r119 == null) goto L43;
        if (r119.get() != true) goto L43;
        boolean r120 = true;
    L44:
        if (r120 == false) goto L86;
        String r121 = JSONObjectProtectorUtils.getString(r112, "user_interactive_key");
        if (JSONObjectProtectorUtils.getBoolean(r112, "once") == false) goto L48;
        d36.a.d(r102, r121);
        goto L86
    L48:
        ScheduledExecutorService r122 = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("CpuMemoryHelper"));
        if (r122 == null) goto L86;
        d36.a.f466717b.put(r121, r122);
        BulletContext r123 = BulletContextManager.a.a().getContext(r102);
        if (r123 == null) goto L55;
        com.bytedance.ies.bullet.core.e r124 = r123.f246455w;
        if (r124 == null) goto L55;
        Object r125 = r124.f246482j;
    L57:
        if ((r125 instanceof d36.c) == false) goto L59;
        r101 = (d36.c) r125;
    L59:
        if (r101 == null) goto L86;
        AtomicBoolean r126 = r101.f466731c;
        if (r126 != null) goto L63;
    L65:
        boolean r127 = false;
    L66:
        if (r127 == true) goto L86;
        long r128 = d36.a.f466716a;
        if (r128 == (-1)) goto L72;
        r101.b(r102, "memory_warning", r128);
    L72:
        if (r112.opt("frequency") == null) goto L74;
        Object r129 = r112.opt("frequency");
        Intrinsics.checkNotNull(r129, "null cannot be cast to non-null type kotlin.Number");
        Number r130 = (Number) r129;
    L83:
        if (Intrinsics.areEqual(r130, 0) == true) goto L86;
        r122.scheduleAtFixedRate(new d36.b(new Ref.IntRef(), r101, r102, r112.optString("user_interactive_key")), r130.longValue(), r130.longValue(), TimeUnit.SECONDS);
        goto L86
    L74:
        d r131 = d.f540305c;
        m0 r132 = (m0) d.f540305c.c(m0.class);
        if (r132 == null) goto L81;
        com.bytedance.ies.bullet.service.base.d r133 = r132.a0();
        if (r133 == null) goto L81;
        r130 = r133.f247816f;
        if (r130 != null) goto L83;
    L81:
        r130 = 0;
        goto L83
    L63:
        if (r126.get() == true) goto L65;
        r127 = true;
    L55:
        r125 = null;
    L86:
        JSONObject r134 = new JSONObject();
        r134.put("code", 1);
        r211.onComplete(r134);
        return;
    L43:
        r120 = false;
        goto L44
    L35:
        r118 = null;
    L31:
        r117 = null;
        goto L33
    L87:
        JSONObject r135 = new JSONObject();
        r135.put("code", 0);
        r211.onComplete(r135);
        return;
    L12:
        r107 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
