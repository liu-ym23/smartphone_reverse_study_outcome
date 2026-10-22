package com.bytedance.map.api.cache;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import com.alipay.sdk.m.u.i;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.settings.MapSettingsUtil;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class BDMapServicePool {
    private static final Handler MAIN_HANDLER = null;
    private static final int MAX_TOTAL_IDLE_SIZE = 4;
    private static final ServiceFactory NON_POOLED_FACTORY = null;
    private static final ServiceFactory POOLED_FACTORY = null;
    private static final String TAG = "BDMapServicePool";
    private static final Set<Object> sDestroyedOwners = null;
    private static final Map<IMapService, PoolKey> sIdleKeys = null;
    private static final ArrayDeque<IMapService> sIdleServiceOrder = null;
    private static final Map<PoolKey, ArrayDeque<IMapService>> sIdleServices = null;
    private static final Map<IMapService, PoolKey> sInUseKeys = null;

    public static final class AcquireResult {
        private final boolean mReused;
        private final IMapService mService;

        public IMapService getService() {
            return this.mService;
        }

        public boolean isReused() {
            return this.mReused;
        }

        private AcquireResult(IMapService r100, boolean r101) {
            this.mService = r100;
            this.mReused = r101;
        }

        public /* synthetic */ AcquireResult(IMapService r100, boolean r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final class PoolKey {
        private final int mapContainer;
        private final int mapType;
        private final Object owner;

        public int hashCode() {
            return (((System.identityHashCode(this.owner) * 31) + this.mapType) * 31) + this.mapContainer;
        }

        public String toString() {
            return "PoolKey{owner=" + this.owner + ", mapType=" + this.mapType + ", mapContainer=" + this.mapContainer + i.f25855d;
        }

        public static /* synthetic */ Object access$200(PoolKey r100) {
            return r100.owner;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PoolKey) == true) goto L8;
            return false;
        L8:
            PoolKey r101 = (PoolKey) r100;
            if (this.owner == r101.owner) goto L11;
        L15:
            return false;
        L11:
            if (this.mapType != r101.mapType) goto L15;
            if (this.mapContainer != r101.mapContainer) goto L15;
            return true;
        }

        private PoolKey(Object r100, int r101, int r102) {
            this.owner = r100;
            this.mapType = r101;
            this.mapContainer = r102;
        }

        public /* synthetic */ PoolKey(Object r100, int r101, int r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public interface ServiceFactory {
        IMapService create(Context r100, int r101);
    }

    private static boolean isPoolSupportedMapType(int r100) {
        if (r100 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        MAIN_HANDLER = new Handler(Looper.getMainLooper());
        sIdleServices = new HashMap();
        sIdleServiceOrder = new ArrayDeque();
        sIdleKeys = new IdentityHashMap();
        sInUseKeys = new IdentityHashMap();
        sDestroyedOwners = Collections.newSetFromMap(new WeakHashMap());
        POOLED_FACTORY = new AnonymousClass1();
        NON_POOLED_FACTORY = new AnonymousClass2();
    }

    private static String describePoolSizeLocked() {
        return "totalIdleSize=" + getTotalIdleSizeLocked() + ", totalInUseSize=" + sInUseKeys.size();
    }

    private static int getTotalIdleSizeLocked() {
        return sIdleKeys.size();
    }

    private BDMapServicePool() {
    }

    public static IMapService acquire(MapInitConfig r100) {
        return acquireWithResult(r100).getService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AcquireResult acquireWithResult(MapInitConfig r100) {
        boolean r101 = false;
        AnonymousClass1 r102 = null;
        Object[] r103 = 0;
        Object[] r104 = 0;
        Object[] r105 = 0;
        Object[] r106 = 0;
        Object[] r107 = 0;
        Object[] r108 = 0;
        Object[] r109 = 0;
        Object[] r110 = 0;
        Object[] r111 = 0;
        Object[] r112 = 0;
        if (r100 == null) goto L34;
        if (r100.getContext() == null) goto L34;
        if (isPoolSupportedMapType(r100.getMapType()) == true) goto L12;
        MapLogger.i(TAG, "acquire pool unsupported mapType, create non-pooled service: mapType=" + r100.getMapType() + ", mapContainer=" + r100.getMapContainer());
        return new AcquireResult(createFresh(r100, NON_POOLED_FACTORY), r101, r102);
    L12:
        if (MapSettingsUtil.isEnableMapServicePool() == true) goto L16;
        MapLogger.i(TAG, "acquire pool disabled by settings, create non-pooled service: mapType=" + r100.getMapType() + ", mapContainer=" + r100.getMapContainer());
        return new AcquireResult(createFresh(r100, NON_POOLED_FACTORY), r101, r112 == true ? 1 : 0);
    L16:
        if (ensureMainThread("acquire") == true) goto L19;
        MapLogger.i(TAG, "acquire off main thread, create non-pooled service: mapType=" + r100.getMapType() + ", mapContainer=" + r100.getMapContainer());
        return new AcquireResult(createFresh(r100, NON_POOLED_FACTORY), r101, r111 == true ? 1 : 0);
    L19:
        Object r113 = resolveOwner(r100.getContext());
        if (r113 != null) goto L24;
        MapLogger.i(TAG, "acquire without owner, create non-pooled service: mapType=" + r100.getMapType() + ", mapContainer=" + r100.getMapContainer());
        return new AcquireResult(createFresh(r100, NON_POOLED_FACTORY), r101, r110 == true ? 1 : 0);
    L24:
        if (isOwnerDestroyed(r113) == false) goto L27;
        MapLogger.i(TAG, "acquire skipped, owner destroyed: owner=" + r113);
        return new AcquireResult(r109 == true ? 1 : 0, r101, r108 == true ? 1 : 0);
    L27:
        PoolKey r114 = new PoolKey(r113, r100.getMapType(), r100.getMapContainer(), r107 == true ? 1 : 0);
        IMapService r115 = acquireIdleService(r114, r100);
        if (r115 == null) goto L32;
        return new AcquireResult(r115, true, r106 == true ? 1 : 0);
    L32:
        return new AcquireResult(createAndMarkInUse(r113, r114, r100), r101, r105 == true ? 1 : 0);
    L34:
        return new AcquireResult(r104 == true ? 1 : 0, r101, r103 == true ? 1 : 0);
    }

    private static String describeContext(Context r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(r100));
    }

    private static String describeService(IMapService r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r100)) + "{mapType=" + r100.getMapType() + i.f25855d;
    }

    public static void destroyAll(final Object r100) {
        if (ensureMainThread("destroyAll(owner)") == true) goto L6;
        MAIN_HANDLER.post(new AnonymousClass5(r100));
        return;
    L6:
        if (r100 != null) goto L9;
        MapLogger.i(TAG, "destroyAll skipped, owner is null");
        return;
    L9:
        ArrayDeque r101 = new ArrayDeque();
        monitor-enter(BDMapServicePool.class);
        sDestroyedOwners.add(r100);     // Catch: Throwable -> L27
        int r102 = removeInUseServicesForOwnerLocked(r100);     // Catch: Throwable -> L27
        Iterator<Map.Entry<PoolKey, ArrayDeque<IMapService>>> r103 = sIdleServices.entrySet().iterator();     // Catch: Throwable -> L27
    L13:
        if (r103.hasNext() == false) goto L21;
        Map.Entry<PoolKey, ArrayDeque<IMapService>> r104 = r103.next();     // Catch: Throwable -> L27
        if (PoolKey.access$200(r104.getKey()) != r100) goto L13;
        Iterator<IMapService> r105 = r104.getValue().iterator();     // Catch: Throwable -> L27
    L18:
        if (r105.hasNext() == false) goto L20;
        IMapService r106 = r105.next();     // Catch: Throwable -> L27
        sIdleKeys.remove(r106);     // Catch: Throwable -> L27
        removeIdleServiceOrderLocked(r106);     // Catch: Throwable -> L27
        r101.offerLast(r106);     // Catch: Throwable -> L27
        goto L18
    L20:
        r103.remove();     // Catch: Throwable -> L27
        goto L13
    L21:
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L27
        MapLogger.i(TAG, "destroyAll owner=" + r100 + ", idleDestroyCount=" + r101.size() + ", removedInUseCount=" + r102 + ", " + describePoolSizeLocked());
    L24:
        if (r101.isEmpty() == true) goto L26;
        destroyService((IMapService) r101.pollFirst());
        goto L24
    L26:
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private static void destroyService(IMapService r100) {
        if (r100 != null) goto L14;
        return;
    L14:
        MapLogger.i(TAG, "destroyService service=" + describeService(r100));     // Catch: Throwable -> L10
        if ((r100 instanceof ReusableMapService) == false) goto L8;
        ((ReusableMapService) r100).destroyForReal();     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        r100.onDestroy();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        MapLogger.i(TAG, "destroyService failed", th);
    }

    private static boolean ensureMainThread(String r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return true;
    L6:
        MapLogger.i(TAG, "BDMapServicePool." + r100 + " should be accessed on main thread");
        return false;
    }

    private static synchronized boolean isOwnerDestroyed(Object r100) {
        monitor-enter(BDMapServicePool.class);
        boolean r101 = sDestroyedOwners.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(BDMapServicePool.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean isReusableReady(IMapService r100) {
        if ((r100 instanceof ReusableMapService) == true) goto L11;
    L10:
        return false;
    L11:
        boolean r101 = ((ReusableMapService) r100).isReusableReady();     // Catch: Throwable -> L8
        if (r101 == true) goto L7;
        MapLogger.i(TAG, "reusable service not ready: service=" + describeService(r100));     // Catch: Throwable -> L8
    L7:
        return r101;
    L8:
        th = move-exception;
        MapLogger.i(TAG, "isReusableReady failed", th);
        goto L10
    }

    private static synchronized IMapService pollIdleService(PoolKey r100) {
        monitor-enter(BDMapServicePool.class);
    L27:
        th = move-exception;
        throw th;
    L6:
        if (sDestroyedOwners.contains(PoolKey.access$200(r100)) == false) goto L9;
        monitor-exit(BDMapServicePool.class);
        return null;
    L9:
        Map<PoolKey, ArrayDeque<IMapService>> r101 = sIdleServices;     // Catch: Throwable -> L27
        ArrayDeque<IMapService> r102 = r101.get(r100);     // Catch: Throwable -> L27
        if (r102 != null) goto L14;
        MapLogger.i(TAG, "pool take miss: key=" + r100 + ", idleSize=0, " + describePoolSizeLocked());     // Catch: Throwable -> L27
        monitor-exit(BDMapServicePool.class);
        return null;
    L14:
        IMapService r103 = r102.pollFirst();     // Catch: Throwable -> L27
        if (r103 == null) goto L18;
        sIdleKeys.remove(r103);     // Catch: Throwable -> L27
        removeIdleServiceOrderLocked(r103);     // Catch: Throwable -> L27
    L18:
        if (r102.isEmpty() == false) goto L20;
        r101.remove(r100);     // Catch: Throwable -> L27
    L20:
        StringBuilder r104 = new StringBuilder("pool take ");     // Catch: Throwable -> L27
        if (r103 != null) goto L23;
        String r105 = "miss";
    L24:
        r104.append(r105);     // Catch: Throwable -> L27
        r104.append(": key=");     // Catch: Throwable -> L27
        r104.append(r100);     // Catch: Throwable -> L27
        r104.append(", service=");     // Catch: Throwable -> L27
        r104.append(describeService(r103));     // Catch: Throwable -> L27
        r104.append(", idleSizeAfterTake=");     // Catch: Throwable -> L27
        r104.append(r102.size());     // Catch: Throwable -> L27
        r104.append(", ");     // Catch: Throwable -> L27
        r104.append(describePoolSizeLocked());     // Catch: Throwable -> L27
        MapLogger.i(TAG, r104.toString());     // Catch: Throwable -> L27
        monitor-exit(BDMapServicePool.class);
        return r103;
    L23:
        r105 = BaseHttpRequestInfo.KEY_HIT;
        goto L24
    }

    private static boolean releaseForReuse(IMapService r100) {
        if ((r100 instanceof ReusableMapService) == true) goto L9;
    L8:
        return false;
    L9:
        ((ReusableMapService) r100).releaseForReuse();     // Catch: Throwable -> L6
        return isReusableReady(r100);
    L6:
        th = move-exception;
        MapLogger.i(TAG, "releaseForReuse failed", th);
        goto L8
    }

    private static void removeIdleServiceOrderLocked(IMapService r100) {
        removeServiceFromDequeLocked(sIdleServiceOrder, r100);
    }

    private static int removeInUseServicesForOwnerLocked(Object r100) {
        Iterator<Map.Entry<IMapService, PoolKey>> r101 = sInUseKeys.entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        if (PoolKey.access$200(r101.next().getValue()) != r100) goto L4;
        r101.remove();
        r102 = r102 + 1;
        goto L4
    L8:
        return r102;
    }

    private static Object resolveOwner(Context r100) {
        HashSet r101 = new HashSet();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L18;
        if ((r100 instanceof LifecycleOwner) == true) goto L7;
        if (r101.add(r100) == false) goto L10;
        Context r102 = ((ContextWrapper) r100).getBaseContext();
        if (r102 == r100) goto L14;
        r100 = r102;
        goto L4
    L14:
        MapLogger.i(TAG, "resolveOwner detected self-referencing ContextWrapper: " + r100);
        return null;
    L10:
        MapLogger.i(TAG, "resolveOwner detected ContextWrapper cycle: " + r100);
        return null;
    L7:
        return r100;
    L18:
        if ((r100 instanceof LifecycleOwner) == false) goto L20;
        return r100;
    L20:
        return null;
    }

    public static void destroyAll(final Context r100) {
        if (ensureMainThread("destroyAll(context)") == true) goto L6;
        MAIN_HANDLER.post(new AnonymousClass4(r100));
        return;
    L6:
        Object r101 = resolveOwner(r100);
        MapLogger.i(TAG, "destroyAll(context): context=" + describeContext(r100) + ", resolvedOwner=" + r101);
        destroyAll(r101);
    }

    private static IMapService acquireIdleService(PoolKey r100, MapInitConfig r101) {
        IMapService r102 = pollIdleService(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (prepareForReuse(r102, r101) == true) goto L10;
        MapLogger.i(TAG, "acquire idle service prepare failed, destroy it: service=" + describeService(r102));
        destroyService(r102);
        return null;
    L10:
        if (markInUseIfOwnerAlive(PoolKey.access$200(r100), r102, r100) == false) goto L13;
        MapLogger.i(TAG, "acquire reused service: mapType=" + r101.getMapType() + ", mapContainer=" + r101.getMapContainer());
        return r102;
    L13:
        MapLogger.i(TAG, "acquire idle service owner destroyed during prepare, destroy it: service=" + describeService(r102));
        destroyService(r102);
        return null;
    }

    private static IMapService createFresh(MapInitConfig r100, ServiceFactory r101) {
        if (r100 != null) goto L4;
        int r102 = 0;
    L6:
        return createFresh(r100, r101, r102);
    L4:
        r102 = r100.getMapType();
        goto L6
    }

    private static boolean markIdleService(PoolKey r100, IMapService r101) {
        ArrayDeque r102 = new ArrayDeque();
        monitor-enter(BDMapServicePool.class);
        boolean r103 = markIdleServiceLocked(r100, r101, r102);     // Catch: Throwable -> L10
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L10
    L7:
        if (r102.isEmpty() == true) goto L9;
        destroyService((IMapService) r102.pollFirst());
        goto L7
    L9:
        return r103;
    L10:
        th = move-exception;
        throw th;
    }

    private static boolean prepareForReuse(IMapService r100, MapInitConfig r101) {
        if ((r100 instanceof ReusableMapService) == true) goto L11;
        return true;
    L11:
        ((ReusableMapService) r100).prepareForReuse(r101);     // Catch: Throwable -> L6
        return isReusableReady(r100);
    L6:
        th = move-exception;
        MapLogger.i(TAG, "prepareForReuse failed", th);
        return false;
    }

    public static void release(Context r100, IMapService r101) {
        release(r100, r101, true);
    }

    private static void removeServiceFromDequeLocked(ArrayDeque<IMapService> r100, IMapService r101) {
        Iterator<IMapService> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        if (r102.next() != r101) goto L4;
        r102.remove();
        return;
    }

    private static void trimIdleServicesLocked(int r100, ArrayDeque<IMapService> r101) {
        int r102 = getTotalIdleSizeLocked();
        if (r102 > r100) goto L5;
        return;
    L5:
        if (r102 <= r100) goto L20;
        ArrayDeque<IMapService> r103 = sIdleServiceOrder;
        if (r103.isEmpty() == true) goto L29;
        IMapService r104 = r103.pollFirst();
        if (r104 == null) goto L5;
        PoolKey r105 = sIdleKeys.remove(r104);
        if (r105 == null) goto L5;
        Map<PoolKey, ArrayDeque<IMapService>> r106 = sIdleServices;
        ArrayDeque<IMapService> r107 = r106.get(r105);
        if (r107 == null) goto L19;
        removeServiceFromDequeLocked(r107, r104);
        if (r107.isEmpty() == false) goto L19;
        r106.remove(r105);
    L19:
        r101.offerLast(r104);
        r102 = r102 - 1;
        MapLogger.i(TAG, "pool trim idle service: key=" + r105 + ", service=" + describeService(r104) + ", maxTotalIdleSize=4, remainingTotalIdleSize=" + r102);
        goto L5
    L29:
        return;
    }

    public static /* synthetic */ void access$300(Context r100, IMapService r101, boolean r102) {
        releaseOnMainThread(r100, r101, r102);
    }

    private static IMapService createAndMarkInUse(Object r100, PoolKey r101, MapInitConfig r102) {
        IMapService r103 = createFresh(r102, POOLED_FACTORY);
        if (r103 != null) goto L7;
        MapLogger.i(TAG, "acquire created null service: mapType=" + r102.getMapType() + ", mapContainer=" + r102.getMapContainer());
        return null;
    L7:
        if (isReusableReady(r103) == true) goto L11;
        MapLogger.i(TAG, "acquire created service not reusable ready, destroy it: service=" + describeService(r103));
        destroyService(r103);
        return null;
    L11:
        if (markInUseIfOwnerAlive(r100, r103, r101) == false) goto L14;
        MapLogger.i(TAG, "acquire created service: mapType=" + r102.getMapType() + ", mapContainer=" + r102.getMapContainer());
        return r103;
    L14:
        MapLogger.i(TAG, "acquire fresh service owner destroyed during init, destroy it: service=" + describeService(r103));
        destroyService(r103);
        return null;
    }

    private static IMapService createFresh(MapInitConfig r100, ServiceFactory r101, int r102) {
        if (r100 != null) goto L4;
        Context r103 = null;
    L5:
        IMapService r104 = r101.create(r103, r102);
        if (r104 == null) goto L9;
        if (r100 == null) goto L9;
        r104.initMap(r100);
    L9:
        MapLogger.i(TAG, "createFresh mapType=" + r102 + ", service=" + describeService(r104));
        return r104;
    L4:
        r103 = r100.getContext();
        goto L5
    }

    private static boolean markIdleServiceLocked(PoolKey r100, IMapService r101, ArrayDeque<IMapService> r102) {
        if (sDestroyedOwners.contains(PoolKey.access$200(r100)) == false) goto L6;
        MapLogger.i(TAG, "pool put skipped, owner destroyed: key=" + r100 + ", service=" + describeService(r101));
        return false;
    L6:
        trimIdleServicesLocked(3, r102);
        if (getTotalIdleSizeLocked() < 4) goto L10;
        MapLogger.i(TAG, "pool put skipped, total pool full: key=" + r100 + ", service=" + describeService(r101) + ", maxTotalIdleSize=4, " + describePoolSizeLocked());
        return false;
    L10:
        Map<PoolKey, ArrayDeque<IMapService>> r103 = sIdleServices;
        ArrayDeque<IMapService> r104 = r103.get(r100);
        if (r104 != null) goto L13;
        r104 = new ArrayDeque();
        r103.put(r100, r104);
    L13:
        r104.offerFirst(r101);
        sIdleKeys.put(r101, r100);
        sIdleServiceOrder.offerLast(r101);
        MapLogger.i(TAG, "pool put success: key=" + r100 + ", service=" + describeService(r101) + ", idleSizeAfterPut=" + r104.size() + ", maxTotalIdleSize=4, " + describePoolSizeLocked());
        return true;
    }

    private static synchronized boolean markInUseIfOwnerAlive(Object r100, IMapService r101, PoolKey r102) {
        monitor-enter(BDMapServicePool.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sDestroyedOwners.contains(r100) == false) goto L9;
        monitor-exit(BDMapServicePool.class);
        return false;
    L9:
        sInUseKeys.put(r101, r102);     // Catch: Throwable -> L13
        MapLogger.i(TAG, "pool mark in-use success: key=" + r102 + ", service=" + describeService(r101) + ", " + describePoolSizeLocked());     // Catch: Throwable -> L13
        monitor-exit(BDMapServicePool.class);
        return true;
    }

    public static void release(final Context r100, final IMapService r101, final boolean r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (ensureMainThread("release") == true) goto L8;
        MapLogger.i(TAG, "release off main thread, post release to main thread: service=" + describeService(r101));
        MAIN_HANDLER.post(new AnonymousClass3(r100, r101, r102));
        return;
    L8:
        releaseOnMainThread(r100, r101, r102);
    }

    private static void releaseOnMainThread(Context r100, IMapService r101, boolean r102) {
        if (isPoolSupportedMapType(r101.getMapType()) == false) goto L5;
        if (r102 == true) goto L24;
        monitor-enter(BDMapServicePool.class);
        sInUseKeys.remove(r101);     // Catch: Throwable -> L20
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L20
        MapLogger.i(TAG, "release recycle disabled by caller, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        if (MapSettingsUtil.isEnableMapServicePool() == false) goto L26;
        Object r103 = resolveOwner(r100);
        if (r103 != null) goto L46;
        monitor-enter(BDMapServicePool.class);
        sInUseKeys.remove(r101);     // Catch: Throwable -> L42
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L42
        MapLogger.i(TAG, "release without owner, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L42:
        th = move-exception;
        throw th;
    L46:
        monitor-enter(BDMapServicePool.class);
        PoolKey r104 = sInUseKeys.remove(r101);     // Catch: Throwable -> L76
        MapLogger.i(TAG, "pool remove in-use on release: service=" + describeService(r101) + ", key=" + r104 + ", " + describePoolSizeLocked());     // Catch: Throwable -> L76
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L76
        if (r104 != null) goto L53;
        MapLogger.i(TAG, "release service not tracked, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L53:
        monitor-enter(BDMapServicePool.class);
        Set<Object> r105 = sDestroyedOwners;     // Catch: Throwable -> L73
        if (r105.contains(r103) == false) goto L57;
    L58:
        MapLogger.i(TAG, "release cannot recycle, ownerDestroyed=" + r105.contains(r103) + ", reusable=" + (r101 instanceof ReusableMapService) + ", service=" + describeService(r101));     // Catch: Throwable -> L73
        r104 = null;
    L59:
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L73
        if (r104 != null) goto L64;
        destroyService(r101);
        return;
    L64:
        if (releaseForReuse(r101) == true) goto L68;
        MapLogger.i(TAG, "releaseForReuse failed, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L68:
        if (markIdleService(r104, r101) == true) goto L71;
        MapLogger.i(TAG, "release pool full or owner destroyed, destroy service: service=" + describeService(r101) + ", key=" + r104);
        destroyService(r101);
        return;
    L71:
        MapLogger.i(TAG, "release service recycled: service=" + describeService(r101) + ", key=" + r104);
        return;
    L57:
        if ((r101 instanceof ReusableMapService) == true) goto L59;
    L73:
        th = move-exception;
        throw th;
    L76:
        th = move-exception;
        throw th;
    L26:
        monitor-enter(BDMapServicePool.class);
        sInUseKeys.remove(r101);     // Catch: Throwable -> L31
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L31
        MapLogger.i(TAG, "release pool disabled by settings, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L31:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(BDMapServicePool.class);
        sInUseKeys.remove(r101);     // Catch: Throwable -> L10
        monitor-exit(BDMapServicePool.class);     // Catch: Throwable -> L10
        MapLogger.i(TAG, "release pool unsupported mapType, destroy service: service=" + describeService(r101));
        destroyService(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
