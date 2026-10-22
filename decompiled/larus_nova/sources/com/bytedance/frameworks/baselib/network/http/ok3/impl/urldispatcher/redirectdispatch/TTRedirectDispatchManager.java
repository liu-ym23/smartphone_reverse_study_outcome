package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.a;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3RequestLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTRedirectDispatchManager {
    private static volatile TTRedirectDispatchManager mInstance;
    private static TTRedirectDispatchConfig mTncConfig;
    private static final ReentrantReadWriteLock mTncConfigLock = null;

    static {
        mTncConfigLock = new ReentrantReadWriteLock();
    }

    public static TTRedirectDispatchManager getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTRedirectDispatchManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTRedirectDispatchManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTRedirectDispatchManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private TTRedirectDispatchManager() {
    }

    public static void onServerConfigChanged(JSONObject r100) {
        ReentrantReadWriteLock r101 = mTncConfigLock;     // Catch: Throwable -> L16
        r101.writeLock().lock();     // Catch: Throwable -> L16
        TTRedirectDispatchConfig r102 = new TTRedirectDispatchConfig();     // Catch: Throwable -> L16
        mTncConfig = r102;     // Catch: Throwable -> L16
        if (r100 != null) goto L7;
        r101.writeLock().unlock();
        return;
    L7:
        if (r102.parseTNCConfig(r100) == true) goto L9;
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<a, TTRedirectDispatchValue>> r103 = mTncConfig.getmRuleList();     // Catch: Throwable -> L16
        if (r103 != null) goto L12;
    L13:
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L14:
        r101.writeLock().unlock();
        return;
    L12:
        if (r103.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        mTncConfigLock.writeLock().unlock();
        throw th;
    }

    public HttpUrl onRedirect(HttpUrl r100, HttpUrl r101, String r102, OkHttp3RequestLog r110) {
        if (r100 != null) goto L5;
    L53:
        return r101;
    L5:
        if (TextUtils.isEmpty(r100.host()) == true) goto L53;
        if (r101 == null) goto L53;
        if (TextUtils.isEmpty(r101.host()) == true) goto L53;
        String r103 = r100.toString();
        ReentrantReadWriteLock r104 = mTncConfigLock;     // Catch: Throwable -> L24
        r104.readLock().lock();     // Catch: Throwable -> L24
        TTRedirectDispatchConfig r105 = mTncConfig;     // Catch: Throwable -> L24
        if (r105 != null) goto L14;
    L22:
        r104.readLock().unlock();
        return r101;
    L14:
        if (r105.isEnabled() == false) goto L22;
        TTRedirectDispatchValue r106 = mTncConfig.getValue(r103);     // Catch: Throwable -> L24
        if (r106 == null) goto L22;
        if (r106.enabled == false) goto L22;
        ReentrantReadWriteLock.ReadLock r107 = r104.readLock();
    L27:
        r107.unlock();
        HttpUrl r108 = null;
        DispatchResult r109 = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(r101.toString(), r102, new ArrayList()));     // Catch: Throwable -> L47
        if (r109 != null) goto L31;
    L33:
        String r111 = null;
    L35:
        if (TextUtils.isEmpty(r111) == false) goto L37;
        return r101;
    L37:
        r108 = HttpUrl.parse(r111);     // Catch: Throwable -> L47
        if (r108 != null) goto L40;
        return r101;
    L40:
        if (r110 == null) goto L49;
        DispatchActionInfo r112 = new DispatchActionInfo();     // Catch: Throwable -> L47
        boolean r113 = true;
        r112.mActionHit = true;     // Catch: Throwable -> L47
        r112.mRuleid = 0;     // Catch: Throwable -> L47
        r112.mPriority = 0;     // Catch: Throwable -> L47
        r112.mStrategyType = 0;     // Catch: Throwable -> L47
        r112.mNeedFeedBack = false;     // Catch: Throwable -> L47
        r112.mDispatchedUrl = r108.toString();     // Catch: Throwable -> L47
        r112.mServiceName = "redirect_dispatch_" + r101.host();     // Catch: Throwable -> L47
        if (r111.equals(r101.toString()) == false) goto L45;
        r113 = false;
    L45:
        r110.recordDispatchActionInfo(r102, r112, r113);     // Catch: Throwable -> L47
    L49:
        return r108;
    L31:
        if (UrlUtils.isValidUrl(r109.mDispatchedURL) == false) goto L33;
        r111 = r109.mDispatchedURL;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L50
        r107 = mTncConfigLock.readLock();
    L50:
        th = move-exception;
        mTncConfigLock.readLock().unlock();
        throw th;
    }
}
