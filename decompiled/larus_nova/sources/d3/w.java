package d3;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class w implements b0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PthreadHandlerThreadV2 f466637k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<Handler> f466638l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f466639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f3.c f466640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f3.l> f466641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3.c f466642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f466643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m4.c f466644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s4.c<n4.c> f466645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<Consumer<ProtocolMessage>> f466646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e3.a f466647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f466648j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<f3.l> f466649a;

        /* JADX INFO: renamed from: d3.w$a$a, reason: collision with other inner class name */
        public static final class C5621a {
        }

        static {
        }

        public a() {
            throw null;
        }

        public a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "methodSeekers");
            this.f466649a = r100;
        }

        public final AIBridgeMethod a(String r100, e3.a r101) {
            Intrinsics.checkNotNullParameter(r100, "methodName");
            Intrinsics.checkNotNullParameter(r101, "bridgeContext");
            a0 r102 = r101.getContainerContext();
            if (r102 == null) goto L6;
            ContainerType r103 = r102.getContainerType();
            if (r103 == null) goto L6;
        L7:
            AIBridgeMethod r104 = f3.k.f475321b.a(r100, r103);
            if (r104 == null) goto L10;
            return r104;
        L10:
            Iterator<f3.l> r105 = this.f466649a.iterator();
        L12:
            if (r105.hasNext() == false) goto L16;
            AIBridgeMethod r106 = r105.next().a(r100, r103);
            if (r106 == null) goto L12;
            return r106;
        L16:
            return null;
        L6:
            r103 = ContainerType.NONE;
            goto L7
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f466650a = null;

        static {
            int[] r100 = new int[ProtocolMessage.Type.values().length];
            r100[ProtocolMessage.Type.Call.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ProtocolMessage.Type.Callback.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ProtocolMessage.Type.Event.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f466650a = r100;
        }
    }

    public static final class d implements e3.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f466651a;

        public d(w r100) {
            this.f466651a = r100;
        }

        @Override // e3.g
        public final void b(String r100, JsonObject r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f466651a.a(r100, r101);
        }
    }

    public static final class e extends n4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f466652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProtocolMessage f466653b;

        @Override // n4.b
        public final void a() {
            j4.a.f497160a.getClass();
            j4.a r100 = j4.a.C6391a.a();
            if (r100 == null) goto L6;
            r100.b(this.f466652a, this.f466653b);
            return;
        }

        @Override // n4.b
        public final void b() {
            j4.a.f497160a.getClass();
            j4.a r100 = j4.a.C6391a.a();
            if (r100 == null) goto L6;
            r100.c(this.f466652a);
            return;
        }

        public e(String r100, ProtocolMessage r101) {
            this.f466652a = r100;
            this.f466653b = r101;
        }
    }

    public static final class f extends n4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f466654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f466655b;

        @Override // n4.b
        public final void a() {
            String r100 = this.f466654a;
            if (r100 == null) goto L13;
            w r101 = this.f466655b;
            j4.a.f497160a.getClass();
            j4.a r102 = j4.a.C6391a.a();
            if (r102 == null) goto L14;
            a0 r103 = r101.f466647i.getContainerContext();
            if (r103 == null) goto L10;
            ContainerType r104 = r103.getContainerType();
            if (r104 == null) goto L10;
        L11:
            r102.k(r100, r104);
            return;
        L10:
            r104 = ContainerType.NONE;
            goto L11
        L14:
            return;
        }

        @Override // n4.b
        public final void b() {
            String r100 = this.f466654a;
            if (r100 == null) goto L8;
            w r101 = this.f466655b;
            j4.a.f497160a.getClass();
            j4.a r102 = j4.a.C6391a.a();
            if (r102 == null) goto L9;
            r102.l(r100, r101.f466644f);
            return;
        L9:
            return;
        }

        public f(String r100, w r101) {
            this.f466654a = r100;
            this.f466655b = r101;
        }
    }

    public static final class g extends n4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f466656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f466657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f466658c;

        @Override // n4.b
        public final void a() {
            j4.a.f497160a.getClass();
            j4.a r100 = j4.a.C6391a.a();
            if (r100 == null) goto L6;
            r100.f(this.f466656a, this.f466657b.f466647i.getContainerContext(), this.f466658c);
            return;
        }

        @Override // n4.b
        public final void b() {
            j4.a.f497160a.getClass();
            j4.a r100 = j4.a.C6391a.a();
            if (r100 == null) goto L6;
            r100.i(this.f466656a, this.f466657b.f466644f);
            return;
        }

        public g(String r100, w r101, String r102) {
            this.f466656a = r100;
            this.f466657b = r101;
            this.f466658c = r102;
        }
    }

    static {
        new b();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("ai_bridge_thread");
        ThreadMethodProxy.start(r100);
        f466637k = r100;
        f466638l = LazyKt.lazy(new d3.g());
    }

    public final void g() {
        if (this.f466648j == false) goto L5;
        return;
    L5:
        this.f466648j = true;
        this.f466645g.a();
        this.f466646h.clear();
        m4.c r100 = this.f466644f;
        if (r100 == null) goto L8;
        r100.close();
    L8:
        String r101 = null;
        this.f466644f = null;
        e3.a r102 = this.f466647i;
        Iterator r103 = ((ConcurrentHashMap) r102.f470890b).values().iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        ((e3.f) r103.next()).release();
        goto L10
    L12:
        ((ConcurrentHashMap) r102.f470890b).clear();
        a0 r104 = this.f466647i.getContainerContext();
        if (r104 == null) goto L15;
        r101 = r104.getContainerId();
    L15:
        if (r101 == null) goto L21;
        j4.a.f497160a.getClass();
        j4.a r105 = j4.a.C6391a.a();
        if (r105 == null) goto L22;
        r105.a(r101);
        return;
    L22:
        return;
    }

    public w() {
        f3.c r100 = new f3.c();
        this.f466640b = r100;
        this.f466641c = CollectionsKt.mutableListOf(new f3.l[]{r100});
        this.f466642d = new i3.c();
        this.f466643e = LazyKt.lazy(new j(this));
        this.f466645g = new s4.c();
        this.f466646h = new SparseArray();
        this.f466647i = new e3.a(new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [d3.p] */
    @Override // d3.b0
    public final com.bytedance.ai.bridge.core.a<JsonObject> b(JsonObject r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        int r100 = ProtocolMessage.f36070a;
        ProtocolMessage r111 = ProtocolMessage.b.a(r110);
        if (r111 != null) goto L7;
        int r112 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "invalid protocol message");
    L7:
        if (r111.getType() == ProtocolMessage.Type.Call) goto L11;
        int r101 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "sync only supports Call type, got: " + r111.getType());
    L11:
        if (r111.e() != null) goto L14;
        int r113 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "method name is null");
    L14:
        TargetEntity r102 = r111.g();
        if (r102 != null) goto L17;
    L66:
        int r114 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "sync call only supports system.bridge target, got: " + r102);
    L17:
        if (r102.b() != TargetEntity.Scope.System) goto L66;
        if (r102.c() != TargetEntity.Target.Bridge) goto L66;
        final String r103 = r111.e();
        if (r103 != null) goto L24;
        int r115 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "method name is null");
    L24:
        String r104 = e(r111);
        j4.a.f497160a.getClass();
        j4.a r105 = j4.a.C6391a.a();
        if (r105 == null) goto L27;
        r105.g(r104, System.currentTimeMillis(), this.f466647i.getContainerContext(), r103, this.f466644f);
    L27:
        AIBridgeMethod.Error r106 = this.f466642d.a(new i3.a(r103, r111.f(), this.f466647i));
        if (r106 == null) goto L33;
        int r107 = r106.getCode();
        String r108 = r106.getMsg();
        if (r108 != null) goto L69;
        r108 = "";
    L69:
        return new com.bytedance.ai.bridge.core.a.b(r107, r108, r106.getData(), r106.getErrNo(), 16);
    L33:
        j4.a r109 = j4.a.C6391a.a();
        if (r109 == null) goto L36;
        r109.d(r104);
    L36:
        j4.a r116 = j4.a.C6391a.a();
        if (r116 == null) goto L39;
        r116.h(r104);
    L39:
        a r117 = (a) this.f466643e.getValue();
        final e3.a r118 = this.f466647i;
        final JsonObject r119 = r111.f();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "methodName");
        AIBridgeMethod r120 = r117.a(r103, r118);
        if (r120 != null) goto L43;
        int r121 = com.bytedance.ai.bridge.core.a.f35243a;
        com.bytedance.ai.bridge.core.a<JsonObject> r122 = com.bytedance.ai.bridge.core.a.C0684a.a(-2, "method not found: ".concat(r103));
    L60:
        if ((r122 instanceof com.bytedance.ai.bridge.core.a.b) == false) goto L70;
        j4.a r123 = j4.a.C6391a.a();
        if (r123 == null) goto L64;
        r123.markError(r104);
    L64:
        com.bytedance.ai.applet.base.log.b r124 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r125 = new StringBuilder("[AIBridge] sync call method:");
        r125.append(r103);
        r125.append(" error with code:");
        com.bytedance.ai.bridge.core.a.b r126 = (com.bytedance.ai.bridge.core.a.b) r122;
        r125.append(r126.f35244b);
        r125.append(", msg:");
        r125.append(r126.f35245c);
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r125.toString(), null);
        return r122;
    L70:
        return r122;
    L43:
        if (r120.getSupportSyncCall() == true) goto L46;
        int r127 = com.bytedance.ai.bridge.core.a.f35243a;
        r122 = com.bytedance.ai.bridge.core.a.C0684a.a(-2, "method does not support sync: ".concat(r103));
        goto L60
    L46:
        if ((r120 instanceof CoreAIBridgeMethod) == true) goto L48;
        int r128 = com.bytedance.ai.bridge.core.a.f35243a;
        r122 = com.bytedance.ai.bridge.core.a.C0684a.a(0, "method does not extend CoreAIBridgeMethod");
        goto L60
    L48:
        final CoreAIBridgeMethod r129 = (CoreAIBridgeMethod) r120;
        final ?? r130 = new p(r129, r118, r119, r103);
        if (r129.mustRunInMain() == true) goto L51;
    L58:
        r122 = (com.bytedance.ai.bridge.core.a) r130.invoke();
        goto L60
    L51:
        if (p2.c.b() == true) goto L58;
        final Ref.ObjectRef r131 = new Ref.ObjectRef();
        final CountDownLatch r132 = new CountDownLatch(1);
        p2.c.d(new q(r131, r130, r132));
        if (r132.await(3000, TimeUnit.MILLISECONDS) == true) goto L55;
        r122 = new com.bytedance.ai.bridge.core.a.b(0, "sync call timeout", null, null, 28);
        goto L60
    L55:
        r122 = (com.bytedance.ai.bridge.core.a) r131.element;
        if (r122 != null) goto L60;
        r122 = new com.bytedance.ai.bridge.core.a.b(0, "null result", null, null, 28);
        goto L60
    }

    public final void d(i3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        i3.c r101 = this.f466642d;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "interceptor");     // Catch: Throwable -> L20
        Iterator<i3.b> r102 = r101.f488079a.iterator();     // Catch: Throwable -> L20
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L14;
        if (r102.next().getPriority() <= r100.getPriority()) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L15;
        r103 = r103 + 1;     // Catch: Throwable -> L20
    L15:
        if (r103 >= 0) goto L17;
        r101.f488079a.add(r100);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r101);
        return;
    L17:
        r101.f488079a.add(r103, r100);     // Catch: Throwable -> L20
        goto L18
    L10:
        r104 = false;
        goto L11
    L14:
        r103 = -1;
    L20:
        th = move-exception;
        throw th;
    }

    public final String e(ProtocolMessage r100) {
        StringBuilder r101 = new StringBuilder();
        a0 r102 = this.f466647i.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getContainerId();
    L6:
        r101.append(r103);
        r101.append('_');
        r101.append(r100.c());
        return r101.toString();
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [d3.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14, types: [d3.s] */
    /* JADX WARN: Type inference failed for: r3v4, types: [d3.n] */
    /* JADX WARN: Type inference failed for: r3v5, types: [d3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [d3.o] */
    /* JADX WARN: Type inference failed for: r4v6, types: [d3.r] */
    public final void f(n4.d r210) {
        final ProtocolMessage r100 = r210.f517034a;
        Object r101 = null;
        String r102 = null;
        if (r100.getType() != null) goto L6;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "receive msg with no Type", null);
        return;
    L6:
        String r103 = e(r100);
        ProtocolMessage.Type r104 = r100.getType();
        if (r104 != null) goto L9;
        int r105 = -1;
    L11:
        if (r105 == 1) goto L38;
        if (r105 != 2) goto L15;
        Integer r106 = r100.c();
        if (r106 == null) goto L36;
        r106.intValue();
        String r107 = this.f466647i.c(r100.c().intValue());
        if (r107 == null) goto L32;
        j4.a.f497160a.getClass();
        j4.a r108 = j4.a.C6391a.a();
        if (r108 == null) goto L32;
        r108.e(r107, r210.f517036b);
    L32:
        Consumer<ProtocolMessage> r109 = this.f466646h.get(r100.c().intValue());
        if (r109 == null) goto L35;
        this.f466646h.remove(r100.c().intValue());
        r109.accept(r100);
        return;
    L35:
        com.bytedance.ai.applet.base.log.b r110 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] can not find callback with id:" + r100.c(), null);
        return;
    L36:
        return;
    L15:
        if (r105 != 3) goto L24;
        if (r100.e() != null) goto L19;
        return;
    L19:
        Lazy r111 = l3.d.f507201a;
        l3.a r112 = new l3.a(r100.e(), r100.f(), r100.h());
        a0 r113 = this.f466647i.getContainerContext();
        if (r113 == null) goto L22;
        r102 = r113.getAppletId();
    L22:
        r112.f507199d = r102;
        l3.d.c(r112);
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    L38:
        if (r100.e() != null) goto L41;
        return;
    L41:
        if (r100.g() != null) goto L43;
        return;
    L43:
        j4.a.f497160a.getClass();
        j4.a r114 = j4.a.C6391a.a();
        if (r114 == null) goto L46;
        r114.g(r103, r210.f517036b, this.f466647i.getContainerContext(), r100.e(), this.f466644f);
    L46:
        final AtomicBoolean r115 = new AtomicBoolean(false);
        final x r116 = new x(r100.e(), r100);
        if (r100.g().b() == TargetEntity.Scope.System) goto L49;
    L69:
        j4.a r117 = j4.a.C6391a.a();
        if (r117 == null) goto L72;
        r117.j(r103);
    L72:
        List<h3.f> r118 = h3.b.f483647a;
        e3.a r119 = this.f466647i;
        d3.b r120 = new d3.b(this, r116, r115);
        Intrinsics.checkNotNullParameter(r119, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "protocolMessage");
        Intrinsics.checkNotNullParameter(r120, "resultCallback");
        Iterator r121 = ((ArrayList) h3.b.f483647a).iterator();
    L74:
        if (r121.hasNext() == false) goto L83;
        Object r122 = r121.next();
        h3.f r123 = (h3.f) r122;
        if (r123 != null) goto L78;
    L80:
        boolean r124 = false;
    L81:
        if (r124 == false) goto L74;
        r101 = r122;
        goto L83
    L78:
        if (r123.a(r100) != true) goto L80;
        r124 = true;
    L83:
        h3.f r125 = (h3.f) r101;
        if (r125 == null) goto L99;
        r125.b(r119, r100, r120);
        return;
    L99:
        return;
    L49:
        if (r100.g().c() != TargetEntity.Target.Bridge) goto L69;
        final ?? r126 = new n(this, r116, r115);
        final ?? r127 = new o(this, r116, r115);
        String r128 = r100.e();
        if (r128 == null) goto L100;
        final String r129 = e(r100);
        AIBridgeMethod.Error r130 = this.f466642d.a(new i3.a(r128, r100.f(), this.f466647i));
        if (r130 == null) goto L56;
        r127.accept(r130);
        return;
    L56:
        j4.a r131 = j4.a.C6391a.a();
        if (r131 == null) goto L59;
        r131.d(r129);
    L59:
        j4.a r132 = j4.a.C6391a.a();
        if (r132 == null) goto L62;
        r132.h(r129);
    L62:
        final a r133 = (a) this.f466643e.getValue();
        final e3.a r134 = this.f466647i;
        final String r135 = r100.e();
        final JsonObject r136 = r100.f();
        final ?? r137 = new d3.e(r126);
        final ?? r138 = new d3.f(r129, r100, r127);
        r133.getClass();
        Intrinsics.checkNotNullParameter(r134, "bridgeContext");
        Intrinsics.checkNotNullParameter(r135, "methodName");
        Intrinsics.checkNotNullParameter(r137, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r138, "reject");
        final AIBridgeMethod r139 = r133.a(r135, r134);
        if (r139 != null) goto L65;
        r138.accept(new AIBridgeMethod.UnregisteredError(null, 1, null));
        return;
    L65:
        final ?? r140 = new r(r133, r135, r137, r138);
        final ?? r141 = new s(r139, r134, r136, r135, r140);
        if (r139.mustRunInMain() == false) goto L68;
        p2.c.d(new t(r141));
        return;
    L68:
        r141.invoke();
        return;
    L100:
        return;
    L9:
        r105 = c.f466650a[r104.ordinal()];
        goto L11
    }

    public final void j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "engineView");
        e3.a r101 = this.f466647i;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "engineView");
        r101.f470891c = new WeakReference(r100);
    }

    public final void k(final m4.c r100) {
        Intrinsics.checkNotNullParameter(r100, "port");
        this.f466644f = r100;
        r100.setBridge$applet_bridge_release(this);
        this.f466645g.d(new h(r100));
        r100.setOnMessageCallback$applet_bridge_release(new i(this));
    }

    @Override // d3.b0
    public final void a(final String r100, final JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Runnable r102 = new k(this, r100, r101);
        f466638l.getValue().post(r102);
    }

    public final <T> void h(x r100, T r101, AtomicBoolean r102) {
        ProtocolMessage r103 = r100.f466659a.b(r101);
        if (r103 != null) goto L6;
        return;
    L6:
        if (r102.compareAndSet(false, true) == false) goto L8;
        this.f466645g.b(new n4.c(r103, new e(e(r103), r103)));
        return;
    L8:
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] repeat replyCall with callbackId:" + r103.c(), null);
    }

    @Override // d3.b0
    public final void c(final ProtocolMessage r100, final Consumer<JsonObject> r101, final Consumer<AIBridgeMethod.Error> r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "protocolMessage");
        Runnable r102 = new d3.a(r101, r110, this, r111, r100);
        f466638l.getValue().post(r102);
    }

    public final void i(String r100, JsonObject r110, Consumer<JsonObject> r111, Consumer<AIBridgeMethod.Error> r112) {
        Intrinsics.checkNotNullParameter(r100, "name");
        c(new ProtocolMessage(r100, r110, null, null, ProtocolMessage.Type.Call, 44), r111, r112, null);
    }
}
