package com.ss.ttvideoengine.abr;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vcloud.abrmodule.DefaultABRModule;
import com.bytedance.vcloud.abrmodule.IABRModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes34.dex */
public class ABRPool {
    private static final int MAX_COUNT = 8;
    private static boolean mEnabled;
    private static ABRPool singleton;
    private int mCreated;
    private final List<IABRModule> mListCache;
    private final Lock mLock;
    private final Map<String, IABRModule> mMapCache;
    private final List<String> mMapOrder;

    private void clearPool() {
        ArrayList r100 = new ArrayList();
        this.mLock.lock();
        r100.addAll(this.mListCache);
        r100.addAll(this.mMapCache.values());
        this.mListCache.clear();
        this.mMapCache.clear();
        this.mMapOrder.clear();
        this.mLock.unlock();
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IABRModule) r101.next()).release();
        goto L4
    L6:
        r100.clear();
    }

    public static ABRPool getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(ABRPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new ABRPool();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ABRPool.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public IABRModule getFromCache() {
        IABRModule r100 = null;
        if (mEnabled == true) goto L5;
        return null;
    L5:
        this.mLock.lock();
        if (this.mListCache.size() <= 0) goto L9;
        r100 = (IABRModule) ListProtector.remove(this.mListCache, 0);
    L14:
        this.mLock.unlock();
        return r100;
    L9:
        if (this.mCreated >= 8) goto L12;
        r100 = new DefaultABRModule();
        this.mCreated++;
        goto L14
    L12:
        if (this.mMapOrder.size() < 6) goto L14;
        r100 = this.mMapCache.remove((String) ListProtector.remove(this.mMapOrder, 0));
        goto L14
    }

    private ABRPool() {
        this.mCreated = 0;
        this.mLock = new ReentrantLock();
        this.mListCache = new ArrayList();
        this.mMapCache = new HashMap();
        this.mMapOrder = new ArrayList();
    }

    public static void clear() {
        getInstance().clearPool();
    }

    public static void setEnabled(boolean r100) {
        mEnabled = r100;
    }

    public IABRModule getFromPreloaded(String r100) {
        if (mEnabled == true) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        this.mLock.lock();
        IABRModule r101 = this.mMapCache.remove(r100);
        this.mMapOrder.remove(r100);
        this.mLock.unlock();
        return r101;
    }

    public void giveBack(IABRModule r100) {
        this.mLock.lock();
        r100.stop();
        this.mListCache.add(r100);
        this.mLock.unlock();
    }

    public void preloadDone(String r100, IABRModule r101) {
        this.mLock.lock();
        r101.stop();
        this.mMapCache.put(r100, r101);
        this.mMapOrder.remove(r100);
        this.mMapOrder.add(r100);
        this.mLock.unlock();
    }
}
