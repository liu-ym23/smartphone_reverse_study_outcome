package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricIntentStatusServiceDelegate;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockStateType;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcher;
import com.obric.assistant.t1;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricPowerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f393203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f393204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<AssistantAliveReason, Integer> f393205c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ObricPowerlockTimeoutHandler f393206d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f393207e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<AssistantAliveReason, Integer> f393208f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ObricPowerlockTimeoutHandler f393209g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ObricAssistantAliveLockState f393210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Job f393211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Job f393212j;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/assistant/state/impl/v2/power/ObricPowerManager$ForceReleasePowerLockReason;", "", "<init>", "(Ljava/lang/String;I)V", "ON_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ForceReleasePowerLockReason extends Enum<ForceReleasePowerLockReason> {
        public static final ForceReleasePowerLockReason ON_TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ForceReleasePowerLockReason[] f393213a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f393214b = null;

        public static EnumEntries<ForceReleasePowerLockReason> getEntries() {
            return f393214b;
        }

        static {
            ForceReleasePowerLockReason r100 = new ForceReleasePowerLockReason();
            ON_TIMEOUT = r100;
            ForceReleasePowerLockReason[] r101 = {r100};
            f393213a = r101;
            f393214b = EnumEntriesKt.enumEntries(r101);
        }

        public ForceReleasePowerLockReason() {
            super("ON_TIMEOUT", 0);
        }

        public static ForceReleasePowerLockReason[] values() {
            return (ForceReleasePowerLockReason[]) f393213a.clone();
        }

        public static ForceReleasePowerLockReason valueOf(String r100) {
            return (ForceReleasePowerLockReason) r27.a.a(ForceReleasePowerLockReason.class, r100);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a implements pba.b {
        public a() {
        }

        @Override // pba.b
        public final void a(boolean r100) {
            FLogger r101 = FLogger.f375446a;
            CoroutineScope r102 = ObricPowerManager.f393203a;
            r101.i("[ObricPowerManager]", "onObricIntentStatusChanged, " + r100);
            if (r100 == false) goto L5;
            CoroutineScope r103 = ObricPowerManager.f393203a;
            AssistantAliveReason r104 = AssistantAliveReason.INTENT_IN_PROGRESS;
            ObricPowerManager.d(r104);
            ObricPowerManager.c(r104);
            return;
        L5:
            CoroutineScope r105 = ObricPowerManager.f393203a;
            AssistantAliveReason r106 = AssistantAliveReason.INTENT_IN_PROGRESS;
            ObricPowerManager.g(r106);
            ObricPowerManager.f(r106);
        }
    }

    public ObricPowerManager() {
    }

    static {
        f393203a = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new d())));
        f393205c = new ConcurrentHashMap();
        f393207e = new AtomicInteger(0);
        f393208f = new ConcurrentHashMap();
        a r100 = new a();
        cha.b r101 = new ObricPowerManager$powerLockStatusChangedCallback$1();
        int r102 = t1.f393353a.getObricPowerLockTimeoutInSeconds();
        FLogger.f375446a.d("[ObricPowerManager]", "getObricPowerLockTimeoutInSeconds, " + r102);
        long r103 = ((long) r102) * 1000;
        f393206d = new ObricPowerlockTimeoutHandler("NetworkAlive", r103, new e());
        f393209g = new ObricPowerlockTimeoutHandler("AssistantAlive", r103, new f());
        ObricIntentStatusServiceDelegate.f385674b.c(r100);
        ObricStateDispatcher r104 = ObricStateDispatcher.f393177a;
        Intrinsics.checkNotNullParameter(r101, "observer");
        ObricStateDispatcher.f393180d.add(r101);
    }

    public static final void b() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("lock=network action=publish state=");
        ObricNetworkKeepAliveLockStateType r102 = ObricNetworkKeepAliveLockStateType.RELEASED;
        r101.append(r102);
        r100.i("[ObricPowerManager]", r101.toString());
        ObricPowerlockTimeoutHandler r103 = f393206d;     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r100.i(r103.f393218c, "cancelObricPowerlockTimeoutHandler");     // Catch: Exception -> L8
        BuildersKt.launch$default(r103.f393219d, null, null, new ObricPowerlockTimeoutHandler$cancel$1(r103, null), 3, null);     // Catch: Exception -> L8
    L6:
        ObricStateDispatcher.f393177a.d(new ObricNetworkKeepAliveLockState(r102, "", null, 4, null));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("[ObricPowerManager]", "lock=network action=publish state=" + ObricNetworkKeepAliveLockStateType.RELEASED + " result=failed", e);
    }

    public static long e() {
        Integer r100 = t1.f393353a.getObricPowerLockConfig().getObricNetworkKeepAliveLockReleaseDelay();
        if (r100 == null) goto L5;
        long r101 = r100.intValue();
    L7:
        return RangesKt.coerceAtLeast(r101, 0) * 1000;
    L5:
        r101 = 15;
        goto L7
    }

    public static final void a(AssistantAliveReason r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("lock=assistant action=publish state=");
        ObricAssistantAliveLockStateType r102 = ObricAssistantAliveLockStateType.RELEASED;
        r101.append(r102);
        r101.append(" reason=");
        r101.append(r110);
        r100.i("[ObricPowerManager]", r101.toString());
        ObricPowerlockTimeoutHandler r103 = f393209g;     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r100.i(r103.f393218c, "cancelObricPowerlockTimeoutHandler");     // Catch: Exception -> L8
        BuildersKt.launch$default(r103.f393219d, null, null, new ObricPowerlockTimeoutHandler$cancel$1(r103, null), 3, null);     // Catch: Exception -> L8
    L6:
        ObricAssistantAliveLockState r104 = new ObricAssistantAliveLockState(r102, "", MapsKt.mapOf(TuplesKt.to("state_change_reason", r110)));     // Catch: Exception -> L8
        f393210h = r104;     // Catch: Exception -> L8
        ObricStateDispatcher.f393177a.a(r104);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("[ObricPowerManager]", "lock=assistant action=publish state=" + ObricAssistantAliveLockStateType.RELEASED + " reason=" + r110 + " result=failed", e);
    }

    public static void c(AssistantAliveReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        BuildersKt.launch$default(f393203a, null, null, new ObricPowerManager$acquireAssistantAliveLock$1(r100, null), 3, null);
    }

    public static void d(AssistantAliveReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        BuildersKt.launch$default(f393203a, null, null, new ObricPowerManager$acquireNetworkKeepAliveLock$1(r100, null), 3, null);
    }

    public static void f(AssistantAliveReason r100) {
        long r101 = e();
        Intrinsics.checkNotNullParameter(r100, "reason");
        BuildersKt.launch$default(f393203a, null, null, new ObricPowerManager$releaseAssistantAliveLock$1(r100, r101, null), 3, null);
    }

    public static void g(AssistantAliveReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        long r101 = e();
        BuildersKt.launch$default(f393203a, null, null, new ObricPowerManager$releaseNetworkKeepAliveLock$1(r100, r101, null), 3, null);
    }
}
