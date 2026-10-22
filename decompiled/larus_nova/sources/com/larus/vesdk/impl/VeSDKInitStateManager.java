package com.larus.vesdk.impl;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class VeSDKInitStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VeSDKInitStateManager f375500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f375501b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<InitState> f375502c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CountDownLatch f375503d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CoroutineScope f375504e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f375505f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/vesdk/impl/VeSDKInitStateManager$InitState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "INITIALIZING", "INITIALIZED", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InitState extends Enum<InitState> {
        public static final InitState INITIALIZED = null;
        public static final InitState INITIALIZING = null;
        public static final InitState TIMEOUT = null;
        public static final InitState UNINITIALIZED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InitState[] f375506a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f375507b = null;

        public static EnumEntries<InitState> getEntries() {
            return f375507b;
        }

        static {
            InitState r100 = new InitState("UNINITIALIZED", 0);
            UNINITIALIZED = r100;
            InitState r101 = new InitState("INITIALIZING", 1);
            INITIALIZING = r101;
            InitState r102 = new InitState("INITIALIZED", 2);
            INITIALIZED = r102;
            InitState r103 = new InitState("TIMEOUT", 3);
            TIMEOUT = r103;
            InitState[] r104 = {r100, r101, r102, r103};
            f375506a = r104;
            f375507b = EnumEntriesKt.enumEntries(r104);
        }

        public static InitState[] values() {
            return (InitState[]) f375506a.clone();
        }

        public static InitState valueOf(String r100) {
            return (InitState) r27.a.a(InitState.class, r100);
        }

        public InitState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VeSDKInitStateManager() {
    }

    static {
        f375500a = new VeSDKInitStateManager();
        f375501b = new AtomicBoolean(false);
        f375502c = new AtomicReference(InitState.UNINITIALIZED);
        f375503d = new CountDownLatch(1);
        f375504e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f375505f = LazyKt.lazy(new g());
    }

    public static void a() {
        f375502c.set(InitState.INITIALIZED);
        f375503d.countDown();
        FLogger.f375446a.i("VeSDKInitStateManager", "markInitialized: state changed to INITIALIZED");
    }

    public static void b(long r100, boolean r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        r104.put("duration", r100);     // Catch: Exception -> L12
        if (r101 == false) goto L6;
        int r105 = 1;
    L7:
        r104.put("success", r105);     // Catch: Exception -> L12
        r104.put("type", r103);     // Catch: Exception -> L12
        if (r102 == null) goto L10;
        r104.put("error", r102);     // Catch: Exception -> L12
    L10:
        o.f365780a.reportEvent("flow_vesdk_init_result", r104);     // Catch: Exception -> L12
        FLogger.f375446a.i("VeSDKInitStateManager", "reportInitResult: " + r104);     // Catch: Exception -> L12
        return;
    L6:
        r105 = 0;
    L12:
        e = move-exception;
        FLogger.f375446a.e("VeSDKInitStateManager", "reportInitResult failed", e);
    }
}
