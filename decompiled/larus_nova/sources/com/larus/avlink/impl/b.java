package com.larus.avlink.impl;

import android.os.SystemClock;
import com.larus.avlink.DoraRealtimeCallTaskNew;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.spi.IAIChatService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w88.r;
import w88.t;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f293095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f293096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<Map<String, String>> f293097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f293098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f293099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BotModel f293100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super byte[], Unit> f293101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super z98.f, Unit> f293102h;

    public static final class a {
    }

    static {
    }

    public void O(int r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "traceExtraString");
    }

    public boolean Q(int r100, int r101, int r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r105, "traceExtraString");
        return false;
    }

    public void S() {
        w88.d.a(1);
    }

    public void U(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "requestMode");
    }

    public void V(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceExtraString");
    }

    public void W(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceExtraString");
    }

    public String X(int r100) {
        return null;
    }

    @Override // w88.r
    public final boolean L() {
        if (this.f293096b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean M() {
        int r100 = c.f293103a;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L9;
        DeviceService r102 = r101.device();
        if (r102 == null) goto L9;
        if (r102.G() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // w88.r
    public final Integer c() {
        t r100 = this.f293096b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.c());
    }

    public b() {
        this.f293095a = new Object();
        this.f293097c = new CopyOnWriteArrayList();
    }

    public long N() {
        return SystemClock.elapsedRealtime();
    }

    @Override // w88.r
    public final t A() {
        return this.f293096b;
    }

    @Override // w88.r
    public final boolean B() {
        return this.f293098d;
    }

    @Override // w88.r
    public final void K(com.larus.dora.impl.onboarding.b r100) {
        this.f293101g = r100;
    }

    public void T(int r100) {
        w88.d.a(2);
    }

    @Override // w88.r
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (Intrinsics.areEqual(r100, "FaceToFace") == false) goto L5;
    L8:
        n1.d("DoraAVLinkServiceImpl", "updateTranslateSceneSwitch scene:".concat(r100));
        t r101 = this.f293096b;
        if (r101 == null) goto L12;
        r101.h(r100);
        return;
    L12:
        return;
    L5:
        if (Intrinsics.areEqual(r100, "ConferenceRoom") == true) goto L8;
        n1.b("DoraAVLinkServiceImpl", "updateTranslateSceneSwitch unsupported scene:".concat(r100));
    }

    @Override // w88.r
    public final void m(Function1<? super z98.f, Unit> r100) {
        this.f293102h = r100;
    }

    @Override // w88.r
    public final void n(Integer r100) {
        n1.d("DoraAVLinkServiceImpl", "stopTask start:" + r100);
        t r101 = this.f293096b;
        if (r101 == null) goto L5;
        r101.l(r100);
    L5:
        this.f293096b = null;
        this.f293098d = false;
        int r102 = c.f293103a;
        IAIChatService r103 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r103 == null) goto L8;
        r103.h8(false);
    L8:
        e98.a.f471533a.d(null);
        n1.d("DoraWakeModeResolver", "clearBusinessIntent");
    }

    @Override // w88.r
    public final void r(BotModel r100) {
        this.f293100f = r100;
    }

    @Override // w88.r
    public final void z(String r100) {
        this.f293099e = r100;
    }

    @Override // w88.r
    public final void J(int r110, int r210, int r211, int r212, int r213, String r214, String r215) {
        n1.d("DoraAVLinkServiceImpl", "onVoiceWakeUp, state:" + r110 + ", mode:" + r210 + ", query:" + r211 + " vuiId:" + r213 + " keyword:" + r214);
        Object r111 = this.f293095a;
        monitor-enter(r111);
        int r100 = c.f293103a;     // Catch: Throwable -> L22
        long r101 = N();     // Catch: Throwable -> L22
        String r112 = "{\"mode\": " + r210 + ",\"query\": " + r211 + '}';     // Catch: Throwable -> L22
        n1.d("DoraTrace", "onVoiceWakeUp, state:" + r110 + ", mode:" + r210 + ", query:" + r211);     // Catch: Throwable -> L22
        this.f293097c.clear();     // Catch: Throwable -> L22
        if (Q(r110, r210, r211, r213, r214, r112) == true) goto L13;
        if (v88.a.g(r210) == false) goto L10;
        Object r113 = r111;
        R(r110, r210, r211, r213, r214, r101, r112, r215);     // Catch: Throwable -> L20
    L14:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r113);
        t r103 = this.f293096b;
        if (r103 == null) goto L30;
        r103.e(r110, r210, r211, r212, r213, r214, r215);
        return;
    L30:
        return;
    L10:
        r113 = r111;
        if (v88.a.f(Integer.valueOf(r210)) == false) goto L14;
        P(r210, r211, r213, r212, r101, r112, r215);     // Catch: Throwable -> L20
        goto L14
    L13:
        r113 = r111;
    L20:
        th = th;
    L24:
        monitor-exit(r113);
        throw th;
    L22:
        th = th;
        r113 = r111;
        goto L24
    }

    public final void P(int r110, int r111, int r112, int r113, long r114, String r115, String r116) {
        int r100 = z98.e.f571059a;
        int r101 = 0;
        if (r111 != 1) goto L5;
        S();
        DoraEvent r102 = DoraEvent.DoraStop;
        r102.setMessage("Radio Stop");
        r102.setExtra(r115);
        ia8.m.b(r102);
        StringBuilder r103 = new StringBuilder("RADIO,STOP ,hash :");
        t r104 = this.f293096b;
        if (r104 == null) goto L44;
        int r105 = r104.hashCode();
    L45:
        r103.append(r105);
        n1.d("DoraAVLinkServiceImpl", r103.toString());
        t r106 = this.f293096b;
        if (r106 == null) goto L48;
        r106.j();
    L48:
        this.f293096b = null;
        this.f293098d = false;
        return;
    L44:
        r105 = 0;
        goto L45
    L5:
        if (r111 != 2) goto L7;
        V(r115);
        int r107 = c.f293103a;
        if (c98.c.a() == true) goto L15;
        Intrinsics.checkNotNullParameter("dora audio wake up", "reason");
        T(r110);
    L15:
        t r108 = this.f293096b;
        if (r108 == null) goto L19;
        r108.l(null);
        this.f293096b = null;
    L19:
        if (c98.c.a() == false) goto L22;
        n1.d("DoraTrace", "onVoiceWakeUp fail in spring degrade");
        c98.c.b(true);
        return;
    L22:
        String r109 = X(r113);
        buc.e<e98.a.C5759a> r117 = e98.a.f471533a;
        if (r109 != null) goto L27;
        n1.d("DoraWakeModeResolver", "getBizModeByAction: no action, use originalMode=" + r110);
        Integer r118 = Integer.valueOf(r110);
    L25:
        Integer r119 = r118;
        this.f293096b = new DoraRealtimeCallTaskNew(this.f293099e, this.f293100f, r110, r119);
        StringBuilder r120 = new StringBuilder("RADIO,START, side=");
        r120.append(r113);
        r120.append(", longPressAction=");
        r120.append(r109);
        r120.append(", bizMode=");
        r120.append(r119);
        r120.append(", hash=");
        t r121 = this.f293096b;
        if (r121 == null) goto L37;
        r101 = r121.hashCode();
    L37:
        r120.append(r101);
        n1.d("DoraAVLinkServiceImpl", r120.toString());
        t r122 = this.f293096b;
        if (r122 == null) goto L40;
        r122.n("dora_half_duplex", r110, r112, "", r119, r114, r116);
    L40:
        this.f293098d = true;
        c.a();
        return;
    L27:
        if (Intrinsics.areEqual(r109, "record_or_query") == false) goto L30;
        int r123 = 10001;
    L33:
        n1.d("DoraWakeModeResolver", "getBizModeByAction: action=" + r109 + ", originalMode=" + r110 + ", resolvedMode=" + r123);
        r118 = Integer.valueOf(r123);
        goto L25
    L30:
        if (Intrinsics.areEqual(r109, "voice_reminder") == false) goto L32;
        r123 = 10002;
        goto L33
    L32:
        r123 = r110;
        goto L33
    L7:
        if (r111 == 3) goto L9;
        return;
    L9:
        DoraEvent r124 = DoraEvent.RadioEnd;
        r124.setExtra(r115);
        ia8.m.b(r124);
        t r125 = this.f293096b;
        if (r125 == null) goto L50;
        r125.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.avlink.impl.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // w88.r
    public final void w(int r110, String r111, int r112, String r113, Integer r114, long r115, String r116) {
        String r100 = r113;
        Intrinsics.checkNotNullParameter(r111, "requestMode");
        t r101 = this.f293096b;
        if (r101 == null) goto L5;
        r101.l(null);
        this.f293096b = null;
    L5:
        int r102 = c.f293103a;
        n1.d("DoraAVLinkServiceImpl", "startSession mode:" + r110 + ", requestMode:" + r111 + ", vuiid:" + r112 + ", kw:" + r113);
        DoraRealtimeCallTaskNew r103 = new DoraRealtimeCallTaskNew(this.f293099e, this.f293100f, r110, r114);
        this.f293096b = r103;
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r103.n(r111, r110, r112, r100, r114, r115, r116);
        t r104 = this.f293096b;
        if (r104 == 0) goto L11;
        Intrinsics.checkNotNullParameter(r104, "task");
        r104.f(new com.larus.avlink.impl.a(this));
        r104.m(this.f293102h);
    L11:
        IAIChatService r105 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r105 == null) goto L14;
        r105.h8(true);
    L14:
        this.f293098d = true;
        c.a();
    }

    public final void R(int r110, int r111, int r112, int r113, String r114, long r115, String r210, String r211) {
        if (v88.a.e(Integer.valueOf(r111)) == false) goto L7;
        int r100 = z98.e.f571059a;
        String r101 = "dora_si";
    L5:
        String r116 = r101;
        if (r112 != 1) goto L13;
        S();
        DoraEvent r102 = DoraEvent.DoraStop;
        r102.setMessage("Voice Stop");
        r102.setExtra(r210);
        ia8.m.b(r102);
        n(Integer.valueOf(r110));
        return;
    L13:
        if (r112 == 2) goto L15;
        O(r110, r111, r112, r210);
        return;
    L15:
        W(r210);
        int r103 = c.f293103a;
        if (c98.c.a() == true) goto L18;
        Intrinsics.checkNotNullParameter("dora wake up", "reason");
        T(r111);
    L18:
        t r104 = this.f293096b;
        Integer r105 = null;
        if (r104 == null) goto L22;
        r104.l(null);
        this.f293096b = null;
    L22:
        if (c98.c.a() == false) goto L26;
        n1.d("DoraTrace", "onVoiceWakeUp fail in spring degrade");
        c98.c.b(true);
        return;
    L26:
        if (v88.a.e(Integer.valueOf(r111)) == true) goto L28;
    L30:
        buc.e<e98.a.C5759a> r106 = e98.a.f471533a;
        e98.a.C5759a r107 = r106.c();
        if (r107 != null) goto L33;
        n1.d("DoraWakeModeResolver", "resolveMode: no intent, use originalMode=" + r111);
    L41:
        if (r105 == null) goto L43;
        int r108 = r105.intValue();
    L44:
        w(r111, r116, r113, r114, Integer.valueOf(r108), r115, r211);
        U(r111, r116);
        return;
    L43:
        r108 = r111;
        goto L44
    L33:
        String r109 = r107.f471534a;
        if (Intrinsics.areEqual(r109, "record_or_query") == false) goto L37;
        Integer r117 = 10001;
    L40:
        n1.d("DoraWakeModeResolver", "resolveMode: action=" + r107.f471534a + ", originalMode=" + r111 + ", resolvedMode=" + r117);
        r106.d(null);
        n1.d("DoraWakeModeResolver", "clearBusinessIntent");
        r105 = r117;
        goto L41
    L37:
        if (Intrinsics.areEqual(r109, "voice_reminder") == false) goto L39;
        r117 = 10002;
        goto L40
    L39:
        r117 = null;
        goto L40
    L28:
        if (M() == true) goto L30;
        n1.d("DoraTrace", "onVoiceWakeUp fail in si, state:" + r110 + ", mode:" + r111 + ", query:" + r112);
        boolean r118 = ha8.d.f484397a;
        ha8.d.e(AppHost.f326268a.getApplication(), null);
        return;
    L7:
        if (v88.a.b(Integer.valueOf(r111)) == false) goto L9;
        int r119 = z98.e.f571059a;
        r101 = "dora_env_observe";
        goto L5
    L9:
        int r120 = z98.e.f571059a;
        r101 = "dora_full_duplex";
        goto L5
    }
}
