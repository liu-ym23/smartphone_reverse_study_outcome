package org.greenrobot.eventbus;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final b[] FIND_STATE_POOL = null;
    private static final Map<Class<?>, List<n>> METHOD_CACHE = null;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final EventBus eventBus;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<zvc.b> subscriberInfoIndexes;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f525791a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = this.f525791a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((d) r100.next()).run();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(List r100) {
            this.f525791a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f525792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Class, Object> f525793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Class> f525794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f525795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Class<?> f525796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f525797f;

        public final void b() {
            if (this.f525797f == false) goto L5;
            this.f525796e = null;
            return;
        L5:
            Class<? super Object> r100 = this.f525796e.getSuperclass();
            this.f525796e = r100;
            String r101 = r100.getName();
            if (r101.startsWith("java.") == false) goto L8;
        L13:
            this.f525796e = null;
            return;
        L8:
            if (r101.startsWith("javax.") == true) goto L13;
            if (r101.startsWith("android.") == true) goto L13;
            if (r101.startsWith("androidx.") == true) goto L13;
        }

        public b() {
            this.f525792a = new ArrayList();
            this.f525793b = new HashMap();
            this.f525794c = new HashMap();
            this.f525795d = new StringBuilder(128);
        }

        public final boolean a(Method r100, Class<?> r101) {
            this.f525795d.setLength(0);
            this.f525795d.append(r100.getName());
            StringBuilder r102 = this.f525795d;
            r102.append(Typography.greater);
            r102.append(r101.getName());
            String r103 = this.f525795d.toString();
            Class<?> r104 = r100.getDeclaringClass();
            Class r105 = (Class) ((HashMap) this.f525794c).put(r103, r104);
            if (r105 != null) goto L5;
            return true;
        L5:
            if (r105.isAssignableFrom(r104) == true) goto L11;
            ((HashMap) this.f525794c).put(r103, r105);
            return false;
        L11:
            return true;
        }
    }

    static {
        METHOD_CACHE = new ConcurrentHashMap();
        FIND_STATE_POOL = new b[4];
    }

    public static void clearCaches() {
        METHOD_CACHE.clear();
    }

    private b prepareFindState() {
        b[] r100 = FIND_STATE_POOL;
        monitor-enter(r100);
        int r101 = 0;
    L6:
        if (r101 >= 4) goto L13;
        b[] r102 = FIND_STATE_POOL;     // Catch: Throwable -> L16
        b r103 = r102[r101];     // Catch: Throwable -> L16
        if (r103 != null) goto L9;
        r101 = r101 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        r102[r101] = null;     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return r103;
    L16:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return new b();
    }

    private List<n> findUsingEventBusInfoAndPreload(f r100) {
        List<d> r101 = r100.a();
        ExecutorService r102 = this.eventBus.getPreloadService();
        if (r102 == null) goto L8;
        Iterator r103 = splitList(r101, EventBus.sPreloadGroupSize).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.execute(new a((List) r103.next()));
    L8:
        return r101;
    }

    private List<n> findUsingInfo(Class<?> r100) {
        b r101 = prepareFindState();
        r101.f525796e = r100;
        r101.f525797f = false;
    L4:
        if (r101.f525796e == null) goto L7;
        getSubscriberInfo(r101);
        findUsingReflectionInSingleClass(r101);
        r101.b();
        goto L4
    L7:
        return getMethodsAndRelease(r101);
    }

    private void findUsingReflectionInSingleClass(b r110) {
        Method[] r100 = r110.f525796e.getDeclaredMethods();     // Catch: Throwable -> L5
    L7:
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L45;
        Method r103 = r100[r102];
        int r104 = r103.getModifiers();
        if ((r104 & 1) == 0) goto L38;
        if ((r104 & MODIFIERS_IGNORE) != 0) goto L38;
        Class<?>[] r105 = r103.getParameterTypes();
        if (r105.length != 1) goto L31;
        Subscribe r106 = (Subscribe) r103.getAnnotation(Subscribe.class);
        if (r106 == null) goto L44;
        Class<?> r107 = r105[0];
        Object r108 = ((HashMap) r110.f525793b).put(r107, r103);
        if (r108 != null) goto L21;
        boolean r109 = true;
    L28:
        if (r109 == false) goto L44;
        ThreadMode r111 = r106.threadMode();
        ((ArrayList) r110.f525792a).add(new n(r103, r107, r111, r106.priority(), r106.sticky()));
        goto L44
    L21:
        if ((r108 instanceof Method) == true) goto L23;
    L27:
        r109 = r110.a(r103, r107);
        goto L28
    L23:
        if (r110.a((Method) r108, r107) == false) goto L26;
        ((HashMap) r110.f525793b).put(r107, r110);
        goto L27
    L26:
        throw new IllegalStateException();
    L44:
        r102 = r102 + 1;
        goto L8
    L31:
        if (this.strictMethodVerification == false) goto L44;
        if (r103.isAnnotationPresent(Subscribe.class) == false) goto L44;
        throw new EventBusException("@Subscribe method " + (r103.getDeclaringClass().getName() + "." + r103.getName()) + "must have exactly 1 parameter but has " + r105.length);
    L38:
        if (this.strictMethodVerification == false) goto L44;
        if (r103.isAnnotationPresent(Subscribe.class) == false) goto L44;
        throw new EventBusException((r103.getDeclaringClass().getName() + "." + r103.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
    L45:
        return;
    L5:
        r100 = r110.f525796e.getMethods();     // Catch: LinkageError -> L46
        r110.f525797f = true;
    L46:
        e = move-exception;
        String r112 = "Could not inspect methods of ".concat(r110.f525796e.getName());
        if (this.ignoreGeneratedIndex == false) goto L50;
        String r113 = r112 + ". Please consider using EventBus annotation processor to avoid reflection.";
    L52:
        throw new EventBusException(r113, e);
    L50:
        r113 = r112 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
        goto L52
    }

    private List<n> getMethodsAndRelease(b r100) {
        ArrayList r101 = new ArrayList(r100.f525792a);
        ((ArrayList) r100.f525792a).clear();
        ((HashMap) r100.f525793b).clear();
        ((HashMap) r100.f525794c).clear();
        int r102 = 0;
        r100.f525795d.setLength(0);
        r100.f525796e = null;
        r100.f525797f = false;
        b[] r103 = FIND_STATE_POOL;
        monitor-enter(r103);
    L5:
        if (r102 >= 4) goto L10;
        b[] r104 = FIND_STATE_POOL;     // Catch: Throwable -> L12
        if (r104[r102] == null) goto L8;
        r102 = r102 + 1;     // Catch: Throwable -> L12
        goto L5
    L8:
        r104[r102] = r100;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return r101;
    }

    private zvc.a getSubscriberInfo(b r100) {
        r100.getClass();
        List<zvc.b> r101 = this.subscriberInfoIndexes;
        if (r101 == null) goto L8;
        Iterator<zvc.b> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        r102.next().a();
        goto L6
    L11:
        return null;
    L8:
        return null;
    }

    public static boolean hasCache(Class<?> r100) {
        return METHOD_CACHE.containsKey(r100);
    }

    public List<n> findUsingReflection(Class<?> r100) {
        b r101 = prepareFindState();
        r101.f525796e = r100;
        r101.f525797f = false;
    L4:
        if (r101.f525796e == null) goto L7;
        findUsingReflectionInSingleClass(r101);
        r101.b();
        goto L4
    L7:
        return getMethodsAndRelease(r101);
    }

    public static void addCache(Class<?> r100, List<n> r101) {
        METHOD_CACHE.put(r100, r101);
    }

    private static <T> List<List<T>> splitList(List<T> r100, int r101) {
        int r102 = r100.size() / r101;
        ArrayList r103 = new ArrayList(r102 + 1);
        int r104 = 0;
    L3:
        if (r104 > r102) goto L11;
        int r105 = r104 * r101;
        if (r105 >= r100.size()) goto L6;
        r104 = r104 + 1;
        int r106 = r104 * r101;
        if (r106 < r100.size()) goto L9;
        r103.add(r100.subList(r105, r100.size()));
        goto L3
    L9:
        r103.add(r100.subList(r105, r106));
        goto L3
    L6:
        return r103;
    L11:
        return r103;
    }

    public SubscriberMethodFinder(EventBus r100, List<zvc.b> r101, boolean r102, boolean r103) {
        this.subscriberInfoIndexes = r101;
        this.strictMethodVerification = r102;
        this.ignoreGeneratedIndex = r103;
        this.eventBus = r100;
    }

    public List<n> findSubscriberMethods(boolean r100, boolean r101, Class<?> r102, Object r103) {
        Map<Class<?>, List<n>> r104 = METHOD_CACHE;
        List<n> r105 = r104.get(r102);
        if (r105 == null) goto L5;
        return r105;
    L5:
        if (r100 == false) goto L15;
        if ((r103 instanceof f) == false) goto L15;
        if (r101 == true) goto L10;
    L11:
        List<n> r106 = findUsingEventBusInfoAndPreload((f) r103);
        if (r106 != null) goto L18;
        Objects.toString(r102);
        r106 = findUsingReflection(r102);
    L18:
        if (r106 == null) goto L24;
        if (r106.isEmpty() == true) goto L24;
        r104.put(r102, r106);
        return r106;
    L24:
        throw new EventBusException("Subscriber " + r102 + " and its super classes have no public methods with the @Subscribe annotation");
    L10:
        if (((f) r103).b() == r102) goto L11;
    L15:
        if (this.ignoreGeneratedIndex == false) goto L17;
        r106 = findUsingReflection(r102);
        goto L18
    L17:
        r106 = findUsingInfo(r102);
        goto L18
    }
}
