package org.greenrobot.eventbus;

import android.os.Looper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes42.dex */
public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = null;
    public static boolean FAST_DIRECT_MODE = false;
    public static boolean FAST_MODE_ENABLE = false;
    public static org.greenrobot.eventbus.c MONITOR = null;
    public static awc.a PERFORMANCE_CONFIG = null;
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = null;
    public static int sPreloadGroupSize;
    private final org.greenrobot.eventbus.a asyncPoster;
    private final org.greenrobot.eventbus.b backgroundPoster;
    private final ThreadLocal<c> currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final g logger;
    private final l mainThreadPoster;
    private final h mainThreadSupport;
    ExecutorService preloadService;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<o>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final ConcurrentHashMap<Object, List<Class<?>>> typesBySubscriber;

    public class a extends ThreadLocal<c> {
        @Override // java.lang.ThreadLocal
        public final c initialValue() {
            return new c();
        }

        public a() {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f525784a = null;

        static {
            int[] r100 = new int[ThreadMode.values().length];
            f525784a = r100;
            r100[ThreadMode.POSTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f525784a[ThreadMode.MAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f525784a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f525784a[ThreadMode.BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f525784a[ThreadMode.ASYNC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f525785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f525786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f525787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o f525788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f525789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f525790f;

        public c() {
            this.f525785a = new ArrayList();
        }
    }

    static {
        DEFAULT_BUILDER = new EventBusBuilder();
        eventTypesCache = new HashMap();
        FAST_MODE_ENABLE = false;
        FAST_DIRECT_MODE = false;
        sPreloadGroupSize = 5;
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public static EventBus getDefault() {
        EventBus r100 = defaultInstance;
        if (r100 == null) goto L5;
    L14:
        return r100;
    L5:
        monitor-enter(EventBus.class);
        r100 = defaultInstance;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        r100 = new EventBus();     // Catch: Throwable -> L11
        defaultInstance = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventBus.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isMainThread() {
        h r100 = this.mainThreadSupport;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (((h.a) r100).f525806a != Looper.myLooper()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r101 = false;
        goto L8
    }

    public void removeAllStickyEvents() {
        Map<Class<?>, Object> r100 = this.stickyEvents;
        monitor-enter(r100);
        this.stickyEvents.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public g getLogger() {
        return this.logger;
    }

    public ExecutorService getPreloadService() {
        return this.preloadService;
    }

    public EventBus(EventBusBuilder r100) {
        this.currentPostingThreadState = new a();
        this.logger = r100.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new ConcurrentHashMap();
        this.stickyEvents = new ConcurrentHashMap();
        h r101 = r100.getMainThreadSupport();
        this.mainThreadSupport = r101;
        if (r101 == null) goto L5;
        e r102 = new e(this, ((h.a) r101).f525806a);
    L6:
        this.mainThreadPoster = r102;
        this.backgroundPoster = new org.greenrobot.eventbus.b(this);
        this.asyncPoster = new org.greenrobot.eventbus.a(this);
        List<zvc.b> r103 = r100.subscriberInfoIndexes;
        if (r103 == null) goto L9;
        int r104 = r103.size();
    L10:
        this.indexCount = r104;
        this.subscriberMethodFinder = new SubscriberMethodFinder(this, r100.subscriberInfoIndexes, r100.strictMethodVerification, r100.ignoreGeneratedIndex);
        this.logSubscriberExceptions = r100.logSubscriberExceptions;
        this.logNoSubscriberMessages = r100.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = r100.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = r100.sendNoSubscriberEvent;
        this.throwSubscriberException = r100.throwSubscriberException;
        this.eventInheritance = r100.eventInheritance;
        this.executorService = r100.executorService;
        this.preloadService = r100.preloadService;
        return;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static /* synthetic */ ConcurrentHashMap access$000(EventBus r100) {
        return r100.typesBySubscriber;
    }

    public static void initPerformanceConfig(awc.a r100) {
        throw null;
    }

    public static List<Class<?>> lookupAllEventTypes(Class<?> r100) {
        Map<Class<?>, List<Class<?>>> r101 = eventTypesCache;
        monitor-enter(r101);
        List<Class<?>> r102 = r101.get(r100);     // Catch: Throwable -> L12
        List<Class<?>> r103 = r102;
        if (r102 != null) goto L10;
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L12
        Class<?> r105 = r100;
    L7:
        if (r105 == null) goto L9;
        r104.add(r105);     // Catch: Throwable -> L12
        addInterfaces(r104, r105.getInterfaces());     // Catch: Throwable -> L12
        r105 = r105.getSuperclass();     // Catch: Throwable -> L12
        goto L7
    L9:
        eventTypesCache.put(r100, r104);     // Catch: Throwable -> L12
        r103 = r104;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void autoRelease(Object r100) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public void cancelEventDelivery(Object r100) {
        c r101 = this.currentPostingThreadState.get();
        if (r101.f525786b == false) goto L18;
        if (r100 == null) goto L16;
        if (r101.f525789e != r100) goto L14;
        if (r101.f525788d.f525824b.f525818b != ThreadMode.POSTING) goto L12;
        r101.f525790f = true;
        return;
    L12:
        throw new EventBusException(" event handlers may only abort the incoming event");
    L14:
        throw new EventBusException("Only the currently handled event may be aborted");
    L16:
        throw new EventBusException("Event may not be null");
    L18:
        throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
    }

    public <T> T getStickyEvent(Class<T> r100) {
        Map<Class<?>, Object> r101 = this.stickyEvents;
        monitor-enter(r101);
        T r102 = r100.cast(this.stickyEvents.get(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasSubscriberForEvent(Class<?> r100) {
        List<Class<?>> r101 = lookupAllEventTypes(r100);
        if (r101 == null) goto L19;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L19;
        Class r104 = (Class) ListProtector.get(r101, r103);
        monitor-enter(this);
        CopyOnWriteArrayList<o> r105 = this.subscriptionsByEventType.get(r104);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r105 == null) goto L15;
        if (r105.isEmpty() == true) goto L15;
        return true;
    L15:
        r103 = r103 + 1;
    L16:
        th = move-exception;
        throw th;
    L19:
        return false;
    }

    public void invokeSubscriber(j r100) {
        Object r101 = r100.f525809a;
        o r102 = r100.f525810b;
        r100.f525809a = null;
        r100.f525810b = null;
        r100.f525811c = null;
        List<j> r103 = j.f525808d;
        monitor-enter(r103);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) r103).size() >= 10000) goto L7;
        ((ArrayList) r103).add(r100);     // Catch: Throwable -> L12
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L12
        if (r102.f525825c == false) goto L17;
        invokeSubscriber(r102, r101);
        return;
    }

    public synchronized boolean isRegistered(Object r100) {
        monitor-enter(this);
        if (r100 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        boolean r101 = this.typesBySubscriber.containsKey(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public void post(Object r100) {
        c r101 = this.currentPostingThreadState.get();
        ArrayList r102 = (ArrayList) r101.f525785a;
        r102.add(r100);
        if (r101.f525786b == true) goto L17;
        r101.f525787c = isMainThread();
        r101.f525786b = true;
        if (r101.f525790f == true) goto L16;
    L18:
    L12:
        th = move-exception;
        r101.f525786b = false;
        r101.f525787c = false;
        throw th;
    L8:
        if (r102.isEmpty() == true) goto L11;
        postSingleEvent(r102.remove(0), r101);     // Catch: Throwable -> L12
        goto L18
    L11:
        r101.f525786b = false;
        r101.f525787c = false;
        return;
    L16:
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    public void postSticky(Object r100) {
        Map<Class<?>, Object> r101 = this.stickyEvents;
        monitor-enter(r101);
        this.stickyEvents.put(r100.getClass(), r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        post(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Class<?> r101 = r100.getClass();
        List<n> r102 = this.subscriberMethodFinder.findSubscriberMethods(FAST_MODE_ENABLE, FAST_DIRECT_MODE, r101, r100);
        monitor-enter(this);
        Iterator<n> r103 = r102.iterator();     // Catch: Throwable -> L12
    L8:
        if (r103.hasNext() == false) goto L10;
        subscribe(r100, r103.next());     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean removeStickyEvent(Object r100) {
        Map<Class<?>, Object> r101 = this.stickyEvents;
        monitor-enter(r101);
        Class<?> r102 = r100.getClass();     // Catch: Throwable -> L13
        if (r100.equals(this.stickyEvents.get(r102)) == false) goto L10;
        this.stickyEvents.remove(r102);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return true;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void unregister(Object r100) {
        monitor-enter(this);
        if (r100 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        List<Class<?>> r101 = this.typesBySubscriber.get(r100);     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        Iterator<Class<?>> r102 = r101.iterator();     // Catch: Throwable -> L17
    L11:
        if (r102.hasNext() == false) goto L13;
        unsubscribeByEventType(r100, r102.next());     // Catch: Throwable -> L17
        goto L11
    L13:
        this.typesBySubscriber.remove(r100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        this.logger.b(Level.WARNING, "Subscriber to unregister was not registered before: " + r100.getClass());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public <T> T removeStickyEvent(Class<T> r100) {
        Map<Class<?>, Object> r101 = this.stickyEvents;
        monitor-enter(r101);
        T r102 = r100.cast(this.stickyEvents.remove(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static void addInterfaces(List<Class<?>> r100, Class<?>[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Class<?> r104 = r101[r103];
        if (r100.contains(r104) == true) goto L7;
        r100.add(r104);
        addInterfaces(r100, r104.getInterfaces());
    L7:
        r103 = r103 + 1;
        goto L3
    }

    private void checkPostStickyEventToSubscription(o r100, Object r101) {
        if (r101 == null) goto L5;
        postToSubscription(r100, r101, isMainThread());
        return;
    }

    private void postSingleEvent(Object r100, c r101) throws Error {
        Class<?> r102 = r100.getClass();
        r101.getClass();
        if (this.eventInheritance == false) goto L7;
        List<Class<?>> r103 = lookupAllEventTypes(r102);
        int r104 = r103.size();
        int r105 = 0;
        boolean r106 = false;
    L5:
        if (r105 >= r104) goto L8;
        r106 = r106 | postSingleEventForEventType(r100, r101, (Class) ListProtector.get(r103, r105));
        r105 = r105 + 1;
    L8:
        if (r106 == false) goto L10;
        return;
    L10:
        if (this.logNoSubscriberMessages == false) goto L13;
        this.logger.b(Level.FINE, "No subscribers registered for event " + r102);
    L13:
        if (this.sendNoSubscriberEvent == true) goto L15;
        return;
    L15:
        if (r102 != i.class) goto L17;
        return;
    L17:
        if (r102 == m.class) goto L24;
        post(new i(r100));
        return;
    L24:
        return;
    L7:
        r106 = postSingleEventForEventType(r100, r101, r102);
        goto L8
    }

    private void subscribe(Object r100, n r101) {
        Class<?> r102 = r101.f525819c;
        o r103 = new o(r100, r101);
        CopyOnWriteArrayList<o> r104 = this.subscriptionsByEventType.get(r102);
        if (r104 != null) goto L6;
        r104 = new CopyOnWriteArrayList();
        this.subscriptionsByEventType.put(r102, r104);
    L7:
        int r105 = r104.size();
        int r106 = 0;
    L8:
        if (r106 > r105) goto L15;
        if (r106 == r105) goto L14;
        if (r101.f525820d > r104.get(r106).f525824b.f525820d) goto L14;
        r106 = r106 + 1;
    L14:
        r104.add(r106, r103);
    L15:
        List<Class<?>> r107 = this.typesBySubscriber.get(r100);
        if (r107 != null) goto L18;
        r107 = new ArrayList();
        this.typesBySubscriber.put(r100, r107);
    L18:
        r107.add(r102);
        if (r101.f525821e == true) goto L21;
        return;
    L21:
        if (this.eventInheritance == false) goto L28;
        Iterator<Map.Entry<Class<?>, Object>> r108 = this.stickyEvents.entrySet().iterator();
    L24:
        if (r108.hasNext() == false) goto L41;
        Map.Entry<Class<?>, Object> r109 = r108.next();
        if (r102.isAssignableFrom(r109.getKey()) == false) goto L24;
        checkPostStickyEventToSubscription(r103, r109.getValue());
        goto L24
    L41:
        return;
    L28:
        checkPostStickyEventToSubscription(r103, this.stickyEvents.get(r102));
        return;
    L6:
        if (r104.contains(r103) == false) goto L7;
        throw new EventBusException("Subscriber " + r100.getClass() + " already registered to event " + r102);
    }

    private void unsubscribeByEventType(Object r100, Class<?> r101) {
        CopyOnWriteArrayList<o> r102 = this.subscriptionsByEventType.get(r101);
        if (r102 == null) goto L10;
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        o r105 = (o) ListProtector.get(r102, r104);
        if (r105.f525823a != r100) goto L9;
        r105.f525825c = false;
        ListProtector.remove(r102, r104);
        r104 = r104 - 1;
        r103 = r103 - 1;
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    public void invokeSubscriber(o r100, Object r101) {
        Method r102 = r100.f525824b.b();
        r102.invoke(r100.f525823a, new Object[]{r101});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L8
    L13:
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException("Unexpected exception", e);
    L8:
        e = move-exception;
        handleSubscriberException(r100, r101, e.getCause());
    }

    private void handleSubscriberException(o r100, Object r101, Throwable r102) {
        if ((r101 instanceof m) == false) goto L8;
        if (this.logSubscriberExceptions == false) goto L18;
        g r103 = this.logger;
        Level r104 = Level.SEVERE;
        r103.a(r104, "SubscriberExceptionEvent subscriber " + r100.f525823a.getClass() + " threw an exception", r102);
        m r105 = (m) r101;
        this.logger.a(r104, "Initial event " + r105.f525815b + " caused exception in " + r105.f525816c, r105.f525814a);
        return;
    L18:
        return;
    L8:
        if (this.throwSubscriberException == true) goto L17;
        if (this.logSubscriberExceptions == false) goto L13;
        this.logger.a(Level.SEVERE, "Could not dispatch event: " + r101.getClass() + " to subscribing class " + r100.f525823a.getClass(), r102);
    L13:
        if (this.sendSubscriberExceptionEvent == false) goto L20;
        post(new m(r102, r101, r100.f525823a));
        return;
    L20:
        return;
    L17:
        throw new EventBusException("Invoking subscriber failed", r102);
    }

    private boolean needRelease(Object r100, Object r101, int r102) {
        throw null;
    }

    private boolean postSingleEventForEventType(Object r100, c r101, Class<?> r102) {
        monitor-enter(this);
        CopyOnWriteArrayList<o> r103 = this.subscriptionsByEventType.get(r102);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r103 != null) goto L8;
    L22:
        return false;
    L8:
        if (r103.isEmpty() == true) goto L22;
        r101.getClass();
        r103.size();
        Iterator<o> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L20;
        o r105 = r104.next();
        r101.f525789e = r100;
        r101.f525788d = r105;
        postToSubscription(r105, r100, r101.f525787c);     // Catch: Throwable -> L17
        boolean r106 = r101.f525790f;     // Catch: Throwable -> L17
        r101.f525789e = null;
        r101.f525788d = null;
        r101.f525790f = false;
        if (r106 == false) goto L11;
        return true;
    L17:
        th = move-exception;
        r101.f525789e = null;
        r101.f525788d = null;
        r101.f525790f = false;
        throw th;
    L20:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    private void postToSubscription(o r100, Object r101, boolean r102) {
        int r103 = b.f525784a[r100.f525824b.f525818b.ordinal()];
        if (r103 != 1) goto L5;
        invokeSubscriber(r100, r101);
        return;
    L5:
        if (r103 != 2) goto L7;
        if (r102 == false) goto L24;
        invokeSubscriber(r100, r101);
        return;
    L24:
        this.mainThreadPoster.a(r100, r101);
        return;
    L7:
        if (r103 != 3) goto L9;
        l r104 = this.mainThreadPoster;
        if (r104 == null) goto L21;
        r104.a(r100, r101);
        return;
    L21:
        invokeSubscriber(r100, r101);
        return;
    L9:
        if (r103 != 4) goto L11;
        if (r102 == false) goto L17;
        this.backgroundPoster.a(r100, r101);
        return;
    L17:
        invokeSubscriber(r100, r101);
        return;
    L11:
        if (r103 != 5) goto L14;
        this.asyncPoster.a(r100, r101);
        return;
    L14:
        throw new IllegalStateException("Unknown thread mode: " + r100.f525824b.f525818b);
    }

    public static /* synthetic */ boolean access$100(EventBus r100, Object r101, Object r102, int r103) {
        return r100.needRelease(r101, r102, r103);
    }
}
