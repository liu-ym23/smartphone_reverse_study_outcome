package com.ss.videoarch.strategy.strategy.networkStrategy;

import com.ss.videoarch.strategy.LiveStrategyManager;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class MultiPath {
    String TAG;
    private ReentrantLock mLock;
    private JSONObject mMetrics;
    private JSONObject mMultiPathInfo;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.strategy.networkStrategy.MultiPath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MultiPathInstance {
        private static final MultiPath mInstance = null;

        private MultiPathInstance() {
        }

        static {
            mInstance = new MultiPath(null);
        }

        public static /* synthetic */ MultiPath access$100() {
            return mInstance;
        }
    }

    private MultiPath() {
        this.TAG = "MultiPath";
        this.mMultiPathInfo = new JSONObject();
        this.mMetrics = new JSONObject();
        this.mLock = new ReentrantLock();
    }

    public static MultiPath getInstance() {
        return MultiPathInstance.access$100();
    }

    private void sendMultiPathInfoToLiveIO() {
        if (LiveStrategyManager.inst().isLiveIOStarted() == true) goto L5;
        return;
    L5:
        JSONObject r100 = getMultiPathInfo(null);
        if (r100 == null) goto L9;
        LiveStrategyManager.inst().setConfigToLiveIO(r100.toString());
        return;
    }

    public /* synthetic */ MultiPath(AnonymousClass1 r100) {
        this();
    }

    public JSONObject getMultiPathInfo(JSONObject r100) {
        if (r100 != null) goto L4;
        this.mLock.lock();
        JSONObject r101 = this.mMultiPathInfo;
        this.mLock.unlock();
    L5:
        Objects.toString(r101);
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public void notifyMultiPathChange(JSONObject r100) {
        Objects.toString(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        this.mLock.lock();
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.mLock.unlock();
        if (r100.has("liveio_started") == true) goto L17;
        return;
    L17:
        if (r100.optInt("liveio_started") != 1) goto L23;
        sendMultiPathInfoToLiveIO();
        return;
    L23:
        return;
    L7:
        if (r100.has("needAccess") == false) goto L14;
        if (r100.optInt("needAccess") != 1) goto L14;
        LiveStrategyManager.inst().fireNotifyToPlayer("MultiPathNeedAccess", null, "");     // Catch: Exception -> L12
        this.mMultiPathInfo.put("multipath_need_access", 1);     // Catch: Exception -> L12
        goto L14
    }

    public void setMultiPathInfo(JSONObject r100) {
        Objects.toString(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        this.mLock.lock();
        Iterator<String> r101 = r100.keys();     // Catch: Exception -> L11
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();     // Catch: Exception -> L11
        this.mMultiPathInfo.put(r102, r100.get(r102));     // Catch: Exception -> L11
    L13:
        this.mLock.unlock();
        sendMultiPathInfoToLiveIO();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
