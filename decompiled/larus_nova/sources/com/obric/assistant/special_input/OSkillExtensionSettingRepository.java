package com.obric.assistant.special_input;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerStatusKeys;
import com.obric.assistant.t1;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes33.dex */
public final class OSkillExtensionSettingRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OSkillExtensionSettingRepository f392543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f392544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f392545c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f392546d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f392547e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f392548f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f392549g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f392550h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final StateFlowImpl f392551i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final kotlinx.coroutines.flow.b1 f392552j = null;

    public OSkillExtensionSettingRepository() {
    }

    static {
        f392543a = new OSkillExtensionSettingRepository();
        f392544b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f392545c = new Object();
        f392546d = new ReentrantLock();
        f392547e = new AtomicBoolean(false);
        f392548f = new AtomicBoolean(false);
        f392549g = new AtomicBoolean(false);
        f392550h = new AtomicBoolean(false);
        StateFlowImpl r100 = j1.a(new t0(0));
        f392551i = r100;
        f392552j = kotlinx.coroutines.flow.e.b(r100);
    }

    public static void a() {
        StateFlowImpl r100 = f392551i;
        if (((t0) r100.getValue()).f392776b == true) goto L5;
    L7:
        Object r101 = f392545c;
        monitor-enter(r101);
        t0 r102 = (t0) r100.getValue();     // Catch: Throwable -> L33
        AtomicBoolean r103 = f392550h;     // Catch: Throwable -> L33
        boolean r104 = r103.get();     // Catch: Throwable -> L33
        boolean r105 = r102.f392776b;     // Catch: Throwable -> L33
        if (r105 == false) goto L15;
        if (r104 == false) goto L15;
        monitor-exit(r101);
        return;
    L15:
        if (r105 == false) goto L17;
        boolean r106 = true;
    L19:
        if (r102.f392776b == false) goto L21;
        boolean r107 = r102.f392775a;     // Catch: Throwable -> L33
    L24:
        if (r104 == false) goto L26;
        int r108 = r102.f392779e;     // Catch: Throwable -> L33
    L30:
        r103.set(true);     // Catch: Throwable -> L33
        r100.setValue(t0.a(r102, r107, r106, false, false, r108, false, false, 108));     // Catch: Throwable -> L33
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r101);
        return;
    L26:
        OSkillExtensionSettingRepository r110 = f392543a;     // Catch: Throwable -> L33
        r108 = t1.f393353a.O0();     // Catch: Throwable -> L33
        r110.getClass();     // Catch: Throwable -> L33
        if (r108 == 0) goto L30;
        if (r108 == 1) goto L30;
        r108 = -1;
        goto L30
    L21:
        if (r106 == false) goto L23;
        r107 = t1.f393353a.p1();     // Catch: Throwable -> L33
        goto L24
    L23:
        r107 = false;
        goto L24
    L17:
        r106 = t1.f393353a.Y();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L5:
        if (f392550h.get() == false) goto L7;
    }

    public static boolean c() {
        return ILoginService.f286097a.getAccountInfo().f531528a;
    }

    public static void e() {
        Object r100 = f392545c;
        monitor-enter(r100);
        StateFlowImpl r101 = f392551i;     // Catch: Throwable -> L8
        t0 r102 = (t0) r101.getValue();     // Catch: Throwable -> L8
        r101.setValue(new t0(false, false, false, false, -1, false, false));     // Catch: Throwable -> L8
        monitor-exit(r100);
        f392548f.set(false);
        f392550h.set(false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (c() == true) goto L6;
        e();
        return;
    L6:
        a();
        t0 r101 = (t0) f392551i.getValue();
        if (r101.f392777c == true) goto L9;
    L11:
        d(r100, false);
        return;
    L9:
        if (r101.f392780f == false) goto L11;
    }

    public static void f(String r110) {
        if (c() == true) goto L6;
        e();
        return;
    L6:
        IAgentSkillManagerIDL r100 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));
        Object r101 = null;
        Integer r102 = null;
        if (r100 != null) goto L89;
        FLogger.f375446a.i("SkillExtSettingRepo", "readRemoteEnabled failed, ipc unavailable, reason=" + r110);
        Boolean r103 = null;
    L24:
        IAgentSkillManagerIDL r104 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));
        if (r104 != null) goto L87;
        FLogger.f375446a.i("SkillExtSettingRepo", "readRemoteOmniSkillAvailableState failed, ipc unavailable, reason=" + r110);
    L52:
        if (r103 != null) goto L67;
        if (r102 != null) goto L67;
        StateFlowImpl r105 = f392551i;
        t0 r106 = (t0) r105.getValue();
        FLogger.f375446a.i("SkillExtSettingRepo", "syncRemoteState keep local/default value, reason=" + r110 + ", enabled=" + r106.f392775a + ", hasLocalCache=" + r106.f392776b + ", omniSkillAvailableState=" + r106.f392779e);
        Object r111 = f392545c;
        monitor-enter(r111);
        r105.setValue(i.a(i.b((t0) r105.getValue(), r103), r102));     // Catch: Throwable -> L63
        monitor-exit(r111);
        if (f392549g.compareAndSet(false, true) == false) goto L91;
        com.obric.aiagent.assistant.idl.n.b(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class), true, new h());
        return;
    L91:
        return;
    L63:
        th = move-exception;
        throw th;
    L67:
        if (c() == true) goto L70;
        e();
        return;
    L70:
        if (r103 == null) goto L72;
        t1.f393353a.n1(r103.booleanValue());
    L72:
        if (r102 == null) goto L74;
        t1.f393353a.l0(r102.intValue());
    L74:
        Object r107 = f392545c;
        monitor-enter(r107);
        StateFlowImpl r108 = f392551i;     // Catch: Throwable -> L80
        r108.setValue(i.a(i.b((t0) r108.getValue(), r103), r102));     // Catch: Throwable -> L80
        monitor-exit(r107);
        FLogger.f375446a.i("SkillExtSettingRepo", "syncRemoteState success, reason=" + r110 + ", enabled=" + r103 + ", omniSkillAvailableState=" + r102);
        return;
    L80:
        th = move-exception;
        throw th;
    L87:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L42
        String r112 = r104.getSkillManagerStatus(OSkillManagerStatusKeys.KEY_OMNI_SKILL_AVAILABLE);     // Catch: Throwable -> L42
        if (r112 == null) goto L32;
        String r113 = StringsKt.trim(r112).toString();     // Catch: Throwable -> L42
        if (r113 == null) goto L32;
        String r114 = r113.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L42
    L34:
        if (Intrinsics.areEqual(r114, "true") == false) goto L37;
        Integer r115 = 1;     // Catch: Throwable -> L42
    L40:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L42
    L44:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L48;
        FLogger.f375446a.e("SkillExtSettingRepo", "readRemoteOmniSkillAvailableState failed, reason=" + r110, r117);
    L48:
        if (Result.m9455isFailureimpl(r116) == true) goto L51;
        r101 = r116;
    L51:
        r102 = (Integer) r101;
        goto L52
    L37:
        if (Intrinsics.areEqual(r114, "false") == false) goto L39;
        r115 = 0;     // Catch: Throwable -> L42
        goto L40
    L39:
        r115 = null;
    L32:
        r114 = null;
    L42:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L89:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L15
        OSkillManagerConfig r120 = r100.getSkillManagerConfig();     // Catch: Throwable -> L15
        if (r120 == null) goto L12;
        Boolean r121 = (Boolean) r120.getValue(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, Boolean.FALSE);     // Catch: Throwable -> L15
    L13:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L15
    L17:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L21;
        FLogger.f375446a.e("SkillExtSettingRepo", "readRemoteEnabled failed, reason=" + r110, r123);
    L21:
        if (Result.m9455isFailureimpl(r122) == false) goto L23;
        r122 = null;
    L23:
        r103 = (Boolean) r122;
        goto L24
    L12:
        r121 = null;
    L15:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static void d(String r100, boolean r101) {
        if (r101 == false) goto L6;
        f392548f.set(true);
    L6:
        if (f392547e.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(f392544b, null, null, new OSkillExtensionSettingRepository$requestRemoteRead$1(r100, null), 3, null);
    }
}
