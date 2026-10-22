package android.ss.com.vboost.request;

import android.content.Context;
import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomRequest;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.VboostListener;
import android.ss.com.vboost.utils.LogUtil;
import android.util.SparseBooleanArray;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class RequestManager {
    private static final long KEEP_RELEASE_TIMEOUT = 30000;
    private static final long SHORTEST_TIMEOUT = 50;
    private static final String TAG = "RequestManager";
    private static volatile android.ss.com.vboost.utils.c<Boolean> enableVboostLazy;
    private static android.ss.com.vboost.utils.c<Boolean> registeredLazy;
    private static final boolean useScheduleThread = false;
    private android.ss.com.vboost.utils.c<SparseBooleanArray> allowedScenesLazy;
    private final Condition available;
    private Map<CapabilityType, android.ss.com.vboost.request.d> currentRequests;
    private ConcurrentHashMap<android.ss.com.vboost.request.d, CustomRequest> customRequests;
    private ScheduledExecutorService executor;
    private final transient ReentrantLock lock;
    private android.ss.com.vboost.utils.a.b mApplogListener;
    private android.ss.com.vboost.utils.c<WeakReference<VboostListener.VboostApplogListener>> mVboostApplogListenerLazy;
    private Map<CapabilityType, TreeSet<android.ss.com.vboost.request.d>> requests;
    private ConcurrentHashMap<CustomRequest, android.ss.com.vboost.request.d> restoreRequests;
    private h scheduleThread;

    public class a extends android.ss.com.vboost.utils.c<SparseBooleanArray> {
        public a(RequestManager r1) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public SparseBooleanArray initialValue() {
            SparseBooleanArray r0 = new SparseBooleanArray();
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
        L10:
            return r0;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getAllowedScenes() == null) goto L10;
            Iterator<Integer> r1 = CapabilityScheduler.getInitialConfigProvider().getAllowedScenes().iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            r0.append(r1.next().intValue(), true);
            goto L8
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ SparseBooleanArray initialValue() {
            return initialValue();
        }
    }

    public static class b extends android.ss.com.vboost.utils.c<Boolean> {
        public b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Boolean initialValue() {
            if (android.ss.com.vboost.i.c.d() == null) goto L7;
            return Boolean.TRUE;
        L7:
            return Boolean.FALSE;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Boolean initialValue() {
            return initialValue();
        }
    }

    public static class c extends android.ss.com.vboost.utils.c<Boolean> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Boolean initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() == null) goto L9;
            if (CapabilityScheduler.getInitialConfigProvider().getSwitch() == null) goto L9;
            return CapabilityScheduler.getInitialConfigProvider().getSwitch();
        L9:
            return Boolean.TRUE;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Boolean initialValue() {
            return initialValue();
        }
    }

    public class d extends android.ss.com.vboost.utils.c<WeakReference<VboostListener.VboostApplogListener>> {
        public d(RequestManager r1) {
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ WeakReference<VboostListener.VboostApplogListener> initialValue() {
            return initialValue2();
        }

        @Override // android.ss.com.vboost.utils.c
        /* JADX INFO: renamed from: initialValue, reason: avoid collision after fix types in other method */
        public WeakReference<VboostListener.VboostApplogListener> initialValue2() {
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
            return null;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getApplogListener() != null) goto L7;
            return null;
        L7:
            return new WeakReference(CapabilityScheduler.getInitialConfigProvider().getApplogListener());
        }
    }

    public class e implements android.ss.com.vboost.utils.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestManager f148a;

        public e(RequestManager r1) {
            this.f148a = r1;
        }

        @Override // android.ss.com.vboost.utils.a.b
        public void onInternalEventV3(String r8, JSONObject r9, String r10, String r11, String r12) {
            if (RequestManager.access$200(this.f148a).get() != null) goto L5;
            return;
        L5:
            if (((WeakReference) RequestManager.access$200(this.f148a).get()).get() == null) goto L9;
            ((VboostListener.VboostApplogListener) ((WeakReference) RequestManager.access$200(this.f148a).get()).get()).onInternalEventV3(r8, r9, r10, r11, r12);
            return;
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f149a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f150b = null;

        static {
            int[] r0 = new int[i.values().length];
            f150b = r0;
            r0[i.d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L68:
            f150b[i.f177c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L56:
            f150b[i.f175a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L66:
            f150b[i.f176b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L10:
            int[] r4 = new int[CapabilityType.values().length];
            f149a = r4;
            r4[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L50:
            f149a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L74:
            f149a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L82:
            f149a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L48:
            f149a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L72:
            f149a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L86:
            f149a[CapabilityType.UFS_FREQ_MAX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L54:
            f149a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L76:
            f149a[CapabilityType.CPU_AFFINITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L80:
            f149a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L64:
            f149a[CapabilityType.NETWORK_ENHANCE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L70:
            f149a[CapabilityType.TASK_PRIORITY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L58:
            f149a[CapabilityType.CPU_CORE_MAX.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
        L60:
            f149a[CapabilityType.CPU_CORE_MIN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L45
        L84:
            f149a[CapabilityType.PRESET_SCENE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L46
        L52:
            f149a[CapabilityType.THUMB_FETCH.ordinal()] = 16;     // Catch: NoSuchFieldError -> L47
            return;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final RequestManager f151a = null;

        static {
            f151a = new RequestManager(null);
        }

        public static /* synthetic */ RequestManager a() {
            return f151a;
        }
    }

    public class h extends PthreadThreadV2 {
    }

    static {
        registeredLazy = new b();
        enableVboostLazy = new c();
    }

    private RequestManager() {
        this.requests = new HashMap();
        ReentrantLock r0 = new ReentrantLock();
        this.lock = r0;
        this.available = r0.newCondition();
        this.currentRequests = new HashMap();
        this.executor = null;
        this.customRequests = new ConcurrentHashMap();
        this.restoreRequests = new ConcurrentHashMap();
        this.allowedScenesLazy = new a(this);
        this.mVboostApplogListenerLazy = new d(this);
        this.mApplogListener = new e(this);
        this.executor = new PThreadScheduledThreadPoolExecutor(2, new DefaultThreadFactory("equestManager"));
    }

    public /* synthetic */ RequestManager(a r1) {
        this();
    }

    public static /* synthetic */ ScheduledExecutorService access$1000(RequestManager r0) {
        return r0.executor;
    }

    public static /* synthetic */ android.ss.com.vboost.utils.c access$200(RequestManager r0) {
        return r0.mVboostApplogListenerLazy;
    }

    public static /* synthetic */ ReentrantLock access$300(RequestManager r0) {
        return r0.lock;
    }

    public static /* synthetic */ Map access$400(RequestManager r0) {
        return r0.requests;
    }

    public static /* synthetic */ Condition access$500(RequestManager r0) {
        return r0.available;
    }

    public static /* synthetic */ Map access$600(RequestManager r0) {
        return r0.currentRequests;
    }

    public static /* synthetic */ boolean access$700(RequestManager r0, android.ss.com.vboost.request.d r1) {
        return r0.shouldSetTimeoutTask(r1);
    }

    public static /* synthetic */ void access$800(RequestManager r0, android.ss.com.vboost.request.d r1) {
        r0.setTimeoutTask(r1);
    }

    public static /* synthetic */ String access$900() {
        return TAG;
    }

    private void cancelRequest(android.ss.com.vboost.request.d r4) {
        this.lock.lock();
        TreeSet<android.ss.com.vboost.request.d> r0 = this.requests.get(r4.f158a);     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        if (r0.contains(r4) == false) goto L11;
        r0.remove(r4);     // Catch: Throwable -> L18
        android.ss.com.vboost.request.h r1 = r4.c();     // Catch: Throwable -> L18
        if (r1 == null) goto L11;
        r1.a().cancel(true);     // Catch: Throwable -> L18
    L11:
        if (this.currentRequests.get(r4.f158a) == null) goto L16;
        LogUtil.debug(TAG, "cancel current executing request!");     // Catch: Throwable -> L18
        android.ss.com.vboost.request.h r2 = this.currentRequests.get(r4.f158a).c();     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        r2.a().cancel(true);     // Catch: Throwable -> L18
    L15:
        this.executor.submit(new android.ss.com.vboost.request.f(r4));     // Catch: Throwable -> L18
        this.customRequests.remove(this.currentRequests.get(r4.f158a));     // Catch: Throwable -> L18
        this.currentRequests.remove(r4.f158a);     // Catch: Throwable -> L18
    L16:
        this.lock.unlock();
        return;
    L18:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    private android.ss.com.vboost.request.d checkAndTranslate(CustomRequest r11) {
        if (r11.type >= CapabilityType.TYPE_MIN.getIndex()) goto L5;
    L101:
        LogUtil.error(TAG, "capability out of range, must give a boost type for a request!!! request:" + r11.type);
        return null;
    L5:
        if (r11.type > CapabilityType.TYPE_MAX.getIndex()) goto L101;
        if (isSupportCapability(CapabilityType.valueOf(r11.type)) == true) goto L11;
        LogUtil.warn(TAG, "not support this capability!");
        return null;
    L11:
        android.ss.com.vboost.request.d r1 = this.restoreRequests.remove(r11);
        if (r1 != null) goto L14;
        r1 = new android.ss.com.vboost.request.d(CapabilityType.valueOf(r11.type));
        r1.s = r11;
    L14:
        android.ss.com.vboost.request.c r2 = android.ss.com.vboost.request.c.f156b;
        r1.m = r2;
        switch(f.f149a[CapabilityType.valueOf(r11.type).ordinal()]) {
            case 1: goto L81;
            case 2: goto L81;
            case 3: goto L81;
            case 4: goto L81;
            case 5: goto L81;
            case 6: goto L81;
            case 7: goto L81;
            case 8: goto L81;
            case 9: goto L64;
            case 10: goto L61;
            case 11: goto L57;
            case 12: goto L42;
            case 13: goto L98;
            case 14: goto L98;
            case 15: goto L17;
            case 16: goto L80;
            default: goto L98;
        };
    L17:
        android.ss.com.vboost.utils.c<SparseBooleanArray> r4 = this.allowedScenesLazy;
        monitor-enter(r4);
    L38:
        th = move-exception;
        throw th;
    L20:
        if (this.allowedScenesLazy.get().get(r11.scene.getId()) == true) goto L22;
    L35:
        LogUtil.warn(TAG, "scene " + r11.scene.getDesc() + " is forbidden or invalid!!!");     // Catch: Throwable -> L38
        monitor-exit(r4);     // Catch: Throwable -> L38
        return null;
    L22:
        if (CustomScene.isValidId(r11.scene.getId()) == false) goto L35;
        monitor-exit(r4);     // Catch: Throwable -> L38
        String r0 = TAG;
        LogUtil.debug(r0, "request preset_scene " + r11.scene.getDesc());
        r1.f162g = r11.scene;
        r1.m = r2;
        if (r11.restore == false) goto L30;
        LogUtil.debug(r0, "restore scene " + r1.f162g.getDesc());
        r1.f165j = true;
        r1.k = false;
        r1.m = android.ss.com.vboost.request.c.f155a;
        r1.a(android.ss.com.vboost.request.g.d);
        android.ss.com.vboost.request.h r3 = r1.c();
        if (r3 == null) goto L98;
        r3.a().cancel(true);
        goto L98
    L30:
        long r6 = r11.timeout;
        r1.f165j = false;
        if (r6 <= 0) goto L33;
        r1.f160c = r6;
        r1.k = false;
    L34:
        r1.a(android.ss.com.vboost.request.g.f170b);
        goto L98
    L33:
        r1.k = true;
        r1.f160c = KEEP_RELEASE_TIMEOUT;
        goto L34
    L64:
        int r5 = r11.tid;
        if (r5 > 1) goto L68;
        LogUtil.warn(TAG, "your request tid is error");
        return null;
    L68:
        r1.d = r5;
        r1.f165j = r11.restore;
        r1.k = true;
        int r7 = r11.cluster;
        CoreCluster r8 = CoreCluster.SUPER;
        if (r7 <= r8.getIndex()) goto L71;
    L74:
        String r9 = TAG;
        StringBuilder r10 = new StringBuilder("your request cluster is out of range:[");
        CoreCluster r12 = CoreCluster.SILVER;
        r10.append(r12.getIndex());
        r10.append(",");
        r10.append(r8.getIndex());
        r10.append("]");
        LogUtil.warn(r9, r10.toString());
        if (r11.cluster <= r8.getIndex()) goto L78;
        r1.f161f = r8;
    L78:
        if (r11.cluster >= r12.getIndex()) goto L80;
        r1.f161f = r12;
        goto L80
    L71:
        if (r11.cluster < CoreCluster.SILVER.getIndex()) goto L74;
        r1.f161f = CoreCluster.valueOf(r11.cluster);
    L80:
        r1.m = android.ss.com.vboost.request.c.f155a;
        goto L98
    L81:
        int r13 = r11.level;
        FrequencyLevel r14 = FrequencyLevel.LEVEL_9;
        if (r13 <= r14.ordinal()) goto L84;
    L87:
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder("your request level is out of range:[");
        FrequencyLevel r17 = FrequencyLevel.LEVEL_0;
        r16.append(r17.ordinal());
        r16.append(",");
        r16.append(r14.ordinal());
        r16.append("]");
        LogUtil.warn(r15, r16.toString());
        if (r11.level <= r14.ordinal()) goto L91;
        r1.f159b = r14;
    L91:
        if (r11.level >= r17.ordinal()) goto L93;
        r1.f159b = r17;
    L93:
        long r18 = r11.timeout;
        if (r18 >= SHORTEST_TIMEOUT) goto L96;
        LogUtil.warn(TAG, "timeout must more than 50");
        r1.f160c = SHORTEST_TIMEOUT;
        goto L98
    L96:
        r1.f160c = r18;
        goto L98
    L84:
        if (r11.level < FrequencyLevel.LEVEL_0.ordinal()) goto L87;
        r1.f159b = FrequencyLevel.valueOf(r11.level);
        goto L93
    L42:
        if (r11.tid > 1) goto L45;
        LogUtil.warn(TAG, "your request tid is error");
        return null;
    L45:
        int r19 = r11.priority;
        FrequencyLevel r20 = FrequencyLevel.LEVEL_9;
        if (r19 <= r20.ordinal()) goto L48;
    L49:
        String r21 = TAG;
        StringBuilder r22 = new StringBuilder("your request level is out of range:[");
        FrequencyLevel r23 = FrequencyLevel.LEVEL_0;
        r22.append(r23.ordinal());
        r22.append(",");
        r22.append(r20.ordinal());
        r22.append("]");
        LogUtil.warn(r21, r22.toString());
        if (r11.level <= r20.ordinal()) goto L53;
        r1.f159b = r20;
    L53:
        if (r11.level >= r23.ordinal()) goto L55;
        r1.f159b = r23;
    L55:
        r1.d = r11.tid;
        int r24 = r11.priority;
        r1.e = r24;
        r1.f159b = FrequencyLevel.valueOf(r24);
        r1.f165j = r11.restore;
        r1.k = true;
        goto L80
    L48:
        if (r11.priority >= FrequencyLevel.LEVEL_0.ordinal()) goto L55;
    L57:
        if (r11.bundle != null) goto L59;
        return null;
    L59:
        r1.f164i = new android.ss.com.vboost.b();
        r11.bundle.getString("scene_type");
        r1.f164i.f48a = r11.bundle.getString("exception_type");
        r1.f164i.f49b = r11.bundle.getString("exception_reason");
        r1.f164i.f50c = r11.bundle.getString("behavior_type");
        r1.f164i.d = r11.bundle.getString("stallState");
        r1.f164i.e = r11.bundle.getString("reportEnabled");
        goto L98
    L61:
        if (r11.bundle != null) goto L63;
        return null;
    L63:
        android.ss.com.vboost.d r25 = new android.ss.com.vboost.d();
        r1.f163h = r25;
        r25.f51a = r11.bundle.getInt("scene_type");
        r1.f163h.f52b = r11.bundle.getFloat("intensity");
        r1.f163h.f53c = r11.bundle.getFloat("sharpness");
        r1.f163h.d = r11.bundle.getFloat("duration");
        r1.f163h.e = r11.bundle.getString("jsonFilePath");
    L98:
        if (r11.bundle == null) goto L100;
        r1.p = new android.ss.com.vboost.request.e();
    L100:
        return r1;
    }

    private Object commitRequestLock(android.ss.com.vboost.request.d r5) {
        String r0 = TAG;
        LogUtil.debug(r0, "commit request lock");
        this.lock.lock();
    L17:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (r5.m != android.ss.com.vboost.request.c.f156b) goto L15;
        TreeSet<android.ss.com.vboost.request.d> r1 = this.requests.get(r5.f158a);     // Catch: Throwable -> L17
        if (r1 != null) goto L8;
        r1 = new TreeSet();     // Catch: Throwable -> L17
        this.requests.put(r5.f158a, r1);     // Catch: Throwable -> L17
    L8:
        boolean r2 = r1.add(r5);     // Catch: Throwable -> L17
        LogUtil.debug(r0, r1.toString());     // Catch: Throwable -> L17
        Object r6 = r5;
        if (r2 == false) goto L13;
        boolean r3 = shouldNotifyProvider(r5);     // Catch: Throwable -> L17
        r6 = r5;
        if (r3 == false) goto L13;
        doRequest(r5.f158a);     // Catch: Throwable -> L17
        r6 = r5;
    L13:
        this.lock.unlock();
        return r6;
    L15:
        this.currentRequests.put(r5.f158a, r5);     // Catch: Throwable -> L17
        r6 = android.ss.com.vboost.request.a.a(r5);     // Catch: Throwable -> L17
        goto L13
    }

    private void doRequest(CapabilityType r7) {
        String r0 = TAG;
        LogUtil.debug(r0, "do request");
        TreeSet<android.ss.com.vboost.request.d> r8 = this.requests.get(r7);
        StringBuilder r1 = new StringBuilder("doRequest:");
        if (r8 != null) goto L5;
        String r2 = "null";
    L6:
        r1.append(r2);
        LogUtil.debug(r0, r1.toString());
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.isEmpty() == true) goto L24;
        android.ss.com.vboost.request.d r9 = r8.pollFirst();
        r9.a(System.currentTimeMillis());
        if (shouldSetTimeoutTask(r9) == false) goto L14;
        setTimeoutTask(r9);
        r9.f160c = r9.a();
    L14:
        if (shouldNotifyProvider(r9) == true) goto L16;
        return;
    L16:
        if (r9.b() == android.ss.com.vboost.request.g.f170b) goto L18;
    L21:
        LogUtil.debug(r0, "Async notify provider");
        this.executor.submit(new android.ss.com.vboost.request.b(r9));
        this.currentRequests.put(r9.f158a, r9);
        return;
    L18:
        if (r9.a() > SHORTEST_TIMEOUT) goto L21;
        doRequest(r9.f158a);
        return;
    L24:
        return;
    L5:
        r2 = r8.toString();
        goto L6
    }

    public static RequestManager getInstance() {
        return g.a();
    }

    public static void setEnableVboost(boolean r1) {
        enableVboostLazy.set(Boolean.valueOf(r1));
    }

    private void setTimeoutTask(android.ss.com.vboost.request.d r6) {
        LogUtil.debug(TAG, "set timeout task");
        android.ss.com.vboost.request.h r0 = new android.ss.com.vboost.request.h(r6);
        r0.a(this.executor.schedule(r0, r6.a(), TimeUnit.MILLISECONDS));
        r6.a(r0);
    }

    private boolean shouldNotifyProvider(android.ss.com.vboost.request.d r7) {
        android.ss.com.vboost.request.d r0 = this.currentRequests.get(r7.f158a);
        boolean r2 = true;
        if (this.currentRequests == null) goto L34;
        if (r0 == null) goto L34;
        int r1 = f.f150b[r7.d().ordinal()];
        if (r1 != 1) goto L9;
        FrequencyLevel r3 = r7.f159b;
        if (r3 != null) goto L21;
    L25:
        r2 = false;
    L27:
        if (r7.b() == android.ss.com.vboost.request.g.f170b) goto L31;
        if (r7.b() == android.ss.com.vboost.request.g.f169a) goto L31;
    L33:
        LogUtil.debug(TAG, "Should notify provider:" + r2);
    L31:
        if (r7.a() > SHORTEST_TIMEOUT) goto L33;
        return false;
    L21:
        if (r0.f159b == null) goto L25;
        if (r3.ordinal() <= r0.f159b.ordinal()) goto L25;
    L9:
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L25;
        if (r1 == 4) goto L27;
    L16:
        if (r7.f159b.ordinal() >= r0.f159b.ordinal()) goto L25;
    L34:
        return r2;
    }

    private boolean shouldSetTimeoutTask(android.ss.com.vboost.request.d r5) {
        if (r5.b() == android.ss.com.vboost.request.g.f170b) goto L5;
    L7:
        boolean r6 = false;
    L8:
        LogUtil.debug(TAG, "Should set timeout task:" + r6);
        return r6;
    L5:
        if (r5.a() <= SHORTEST_TIMEOUT) goto L7;
        r6 = true;
        goto L8
    }

    public void cancelRequest(CapabilityType r5) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.debug(TAG, "cancelRequest registerApplication must be called before!!!");
        return;
    L8:
        LogUtil.debug(TAG, "cancel request by type");
        this.lock.lock();
        TreeSet<android.ss.com.vboost.request.d> r0 = this.requests.get(r5);     // Catch: Throwable -> L25
        if (r0 == null) goto L18;
        Iterator<android.ss.com.vboost.request.d> r1 = r0.iterator();     // Catch: Throwable -> L25
    L13:
        if (r1.hasNext() == false) goto L18;
        android.ss.com.vboost.request.d r2 = r1.next();     // Catch: Throwable -> L25
        android.ss.com.vboost.request.h r3 = r2.c();     // Catch: Throwable -> L25
        if (r3 == null) goto L17;
        r3.a().cancel(true);     // Catch: Throwable -> L25
    L17:
        r1.remove();     // Catch: Throwable -> L25
        this.customRequests.remove(r2);     // Catch: Throwable -> L25
    L18:
        android.ss.com.vboost.request.d r4 = this.currentRequests.get(r5);     // Catch: Throwable -> L25
        if (r4 == null) goto L24;
        android.ss.com.vboost.request.h r6 = r4.c();     // Catch: Throwable -> L25
        if (r6 == null) goto L23;
        r6.a().cancel(true);     // Catch: Throwable -> L25
    L23:
        this.executor.submit(new android.ss.com.vboost.request.f(this.currentRequests.get(r5)));     // Catch: Throwable -> L25
        this.customRequests.remove(r4);     // Catch: Throwable -> L25
        this.currentRequests.remove(r5);     // Catch: Throwable -> L25
    L24:
        this.lock.unlock();
        return;
    L25:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void cancelRequest(CustomRequest r4) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.debug(TAG, "cancelRequest registerApplication must be called before!!!");
        return;
    L8:
        LogUtil.debug(TAG, "cancel custom request " + this.customRequests.size());
        Iterator<Map.Entry<android.ss.com.vboost.request.d, CustomRequest>> r0 = this.customRequests.entrySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L27;
        Map.Entry<android.ss.com.vboost.request.d, CustomRequest> r1 = r0.next();
        if (r1.getValue() != r4) goto L10;
        android.ss.com.vboost.request.d r5 = r1.getKey();
        r5.f165j = true;
        cancelRequest(r5);
        android.ss.com.vboost.request.g r2 = r5.b();
        if (r2 == android.ss.com.vboost.request.g.f169a) goto L18;
        if (r2 == android.ss.com.vboost.request.g.f171c) goto L18;
    L21:
        this.customRequests.remove(r1.getKey());
        return;
    L18:
        if (r5.m != android.ss.com.vboost.request.c.f155a) goto L20;
        android.ss.com.vboost.request.a.a(r5);
        goto L21
    L20:
        this.executor.submit(new android.ss.com.vboost.request.f(r5));
        goto L21
    }

    public Object commitRequest(CustomRequest r4) {
        Object r1 = null;
        if (enableVboostLazy.get().booleanValue() == true) goto L8;
        String r5 = TAG;
        String r0 = "vboost not enable!";
    L5:
        LogUtil.debug(r5, r0);
        return null;
    L8:
        if (registeredLazy.get().booleanValue() == true) goto L10;
        r5 = TAG;
        r0 = "commitRequest registerApplication must be called before!!!";
        goto L5
    L10:
        android.ss.com.vboost.request.d r2 = checkAndTranslate(r4);
        if (r2 == null) goto L15;
        r1 = commitRequestLock(r2);
        this.customRequests.put(r2, r4);
        if (r2.k == false) goto L15;
        this.restoreRequests.put(r4, r2);
    L15:
        return r1;
    }

    public void completeDirectRequest(android.ss.com.vboost.request.d r3) {
        LogUtil.debug(TAG, "completeDirectRequest to schedule next request.");
        this.lock.lock();
        this.customRequests.remove(r3);     // Catch: Throwable -> L6
        this.currentRequests.remove(r3.f158a);     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void completeRequest(android.ss.com.vboost.request.d r3, boolean r4) {
        LogUtil.debug(TAG, "completeTimeoutRequest to schedule next request.");
        this.lock.lock();
        if (r4 == false) goto L6;
        this.restoreRequests.remove(r3.s);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L6:
        if (r3.c() == null) goto L8;
        if (r4 == true) goto L8;
    L13:
        this.lock.unlock();
        return;
    L8:
        this.customRequests.remove(r3);     // Catch: Throwable -> L15
        this.currentRequests.remove(r3.f158a);     // Catch: Throwable -> L15
        TreeSet<android.ss.com.vboost.request.d> r5 = this.requests.get(r3.f158a);     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        doRequest(r3.f158a);     // Catch: Throwable -> L15
        goto L13
    }

    public android.ss.com.vboost.utils.a.b getApplogListener() {
        return this.mApplogListener;
    }

    public Set<CapabilityType> getSupportCapabilities() {
        if (registeredLazy.get().booleanValue() == true) goto L7;
        LogUtil.debug(TAG, "getSupportCapabilities registerApplication must be called before!!!");
        return null;
    L7:
        return android.ss.com.vboost.i.c.e().a();
    }

    public boolean isSupportCapability(CapabilityType r2) {
        if (registeredLazy.get().booleanValue() == true) goto L7;
        LogUtil.debug(TAG, "isSupportCapability registerApplication must be called before!!!");
        return false;
    L7:
        return android.ss.com.vboost.i.c.e().a(r2);
    }

    public void register(Context r3) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        LogUtil.info(TAG, "vboost not enable, do not register");
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.info(TAG, "register context.");
        android.ss.com.vboost.i.c.a(r3);
        registeredLazy.set(Boolean.TRUE);
    L8:
        if (android.ss.com.vboost.i.c.e() == null) goto L12;
        android.ss.com.vboost.i.c.e().b();
        return;
    }

    public void registerApplog(VboostListener.VboostApplogListener r3) {
        this.mVboostApplogListenerLazy.set(new WeakReference(r3));
        android.ss.com.vboost.utils.a.a(this.mApplogListener);
    }

    public void registerSystemListener(VboostListener.SystemListener r2) {
        android.ss.com.vboost.i.c.e().a(r2);
    }

    public void setAllowedScenes(HashSet<Integer> r5) {
        Iterator<Integer> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Integer r0 = r6.next();
        android.ss.com.vboost.utils.c<SparseBooleanArray> r1 = this.allowedScenesLazy;
        monitor-enter(r1);
        this.allowedScenesLazy.get().append(r0.intValue(), true);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void unregisterSystemListener(VboostListener.SystemListener r2) {
        android.ss.com.vboost.i.c.e().b(r2);
    }
}
