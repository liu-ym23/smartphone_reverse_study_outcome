package com.bytedance.map.api.service;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.cache.BDMapServicePool;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.instance.DefaultMapInstanceService;
import java.util.HashSet;

/* JADX INFO: loaded from: classes21.dex */
public class MapInstanceManager implements LifecycleObserver {
    private static final String TAG = "MapInstanceManager";
    private Context mContext;
    private final boolean mDestroyServiceOnLifecycleDestroy;
    private final MapHostServiceLoader mHostServiceLoader;
    private LifecycleOwner mLifecycleOwner;
    private IMapService mMapService;
    private LifecycleOwner mResolvedOwner;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onLifecycleCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifecycleStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifecycleStop() {
    }

    private void addLifecycleObserver() {
        LifecycleOwner r100 = this.mResolvedOwner;
        if (r100 != null) goto L6;
        MapLogger.i(TAG, "addLifecycleObserver skipped: lifecycleOwner is null, context=" + describeContext(this.mContext));
        return;
    L6:
        Lifecycle r101 = r100.getLifecycle();
        if (r101 != null) goto L10;
        MapLogger.i(TAG, "addLifecycleObserver skipped: lifecycle is null, owner=" + describeOwner(r100) + ", context=" + describeContext(this.mContext));
        return;
    L10:
        this.mLifecycleOwner = r100;
        r101.addObserver(this);
        MapLogger.i(TAG, "addLifecycleObserver success: owner=" + describeOwner(this.mLifecycleOwner) + ", directLifecycleOwner=" + (this.mContext instanceof LifecycleOwner) + ", context=" + describeContext(this.mContext) + ", lifecycleState=" + r101.getCurrentState());
    }

    private DefaultMapInstanceService getDefaultInstanceService() {
        return new DefaultMapInstanceService();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifecycleDestroy() {
        LifecycleOwner r100 = this.mLifecycleOwner;
        MapLogger.i(TAG, "onLifecycleDestroy: lifecycleOwner=" + describeOwner(this.mLifecycleOwner) + ", context=" + describeContext(this.mContext) + ", resolvedLifecycleOwner=" + describeOwner(this.mResolvedOwner));
        if (r100 == null) goto L7;
        BDMapServicePool.destroyAll(r100);
        Lifecycle r101 = r100.getLifecycle();
        if (r101 == null) goto L9;
        r101.removeObserver(this);
    L9:
        if (this.mDestroyServiceOnLifecycleDestroy == false) goto L13;
        IMapService r102 = this.mMapService;
        if (r102 == null) goto L13;
        r102.onDestroy();
    L13:
        this.mMapService = null;
        this.mLifecycleOwner = null;
        this.mResolvedOwner = null;
        return;
    L7:
        BDMapServicePool.destroyAll(this.mContext);
        goto L9
    }

    public MapInstanceManager(Context r100) {
        this(r100, true);
    }

    private static String describeContext(Context r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(r100));
    }

    private String describeMapService(IMapService r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        return r100.getClass().getName();
    }

    private static String describeOwner(LifecycleOwner r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(r100));
    }

    private static LifecycleOwner resolveLifecycleOwner(Context r100) {
        HashSet r101 = new HashSet();
        Object r102 = r100;
    L4:
        if ((r102 instanceof ContextWrapper) == false) goto L19;
        if ((r102 instanceof LifecycleOwner) == true) goto L8;
        if (r101.add(r102) == false) goto L11;
        Context r103 = ((ContextWrapper) r102).getBaseContext();
        if (r103 == r102) goto L15;
        r102 = r103;
        goto L4
    L15:
        MapLogger.i(TAG, "resolveLifecycleOwner detected self-referencing ContextWrapper: " + r102);
        return null;
    L11:
        MapLogger.i(TAG, "resolveLifecycleOwner detected ContextWrapper cycle: " + r102);
        return null;
    L8:
        return (LifecycleOwner) r102;
    L19:
        if ((r102 instanceof LifecycleOwner) == true) goto L21;
        return null;
    L21:
        return (LifecycleOwner) r102;
    }

    public IMapService getMapService(int r110) {
        long r100 = SystemClock.elapsedRealtime();
        MapLogger.i(TAG, "getMapService start: mapType=" + r110 + ", context=" + describeContext(this.mContext));
        boolean r101 = false;
        if (r110 != 1) goto L17;
        long r102 = SystemClock.elapsedRealtime();
        IMapInstanceService r103 = this.mHostServiceLoader.getMapInstanceService();
        StringBuilder r104 = new StringBuilder("getMapService host service result: hasService=");
        if (r103 == null) goto L7;
        boolean r111 = true;
    L8:
        r104.append(r111);
        r104.append(", cost=");
        r104.append(SystemClock.elapsedRealtime() - r102);
        MapLogger.i(TAG, r104.toString());
        if (r103 == null) goto L17;
        this.mMapService = r103.createAMap3DService();     // Catch: Exception -> L12
    L14:
        MapLogger.i(TAG, "getMapService host 3d result: service=" + describeMapService(this.mMapService) + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        IMapService r105 = this.mMapService;
        if (r105 == null) goto L17;
        return r105;
    L12:
        e = move-exception;
        MapLogger.e(TAG, "getMapService host 3d failed, fallback to default service", e);
        this.mMapService = null;
        goto L14
    L7:
        r111 = false;
    L17:
        long r106 = SystemClock.elapsedRealtime();
        DefaultMapInstanceService r107 = getDefaultInstanceService();
        StringBuilder r108 = new StringBuilder("getMapService default service result: hasService=");
        if (r107 == null) goto L20;
        r101 = true;
    L20:
        r108.append(r101);
        r108.append(", cost=");
        r108.append(SystemClock.elapsedRealtime() - r106);
        MapLogger.i(TAG, r108.toString());
        if (r107 == null) goto L23;
        this.mMapService = r107.createMapService(r110);
    L23:
        MapLogger.i(TAG, "getMapService finish: service=" + describeMapService(this.mMapService) + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        return this.mMapService;
    }

    public MapInstanceManager(Context r100, boolean r101) {
        this.mHostServiceLoader = new MapHostServiceLoader();
        this.mContext = r100;
        this.mDestroyServiceOnLifecycleDestroy = r101;
        this.mResolvedOwner = resolveLifecycleOwner(r100);
        MapLogger.i(TAG, "create manager: context=" + describeContext(r100) + ", directLifecycleOwner=" + (r100 instanceof LifecycleOwner) + ", resolvedLifecycleOwner=" + describeOwner(this.mResolvedOwner) + ", destroyServiceOnLifecycleDestroy=" + r101);
        addLifecycleObserver();
    }
}
