package com.bytedance.common.wschannel.channel.impl.ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: loaded from: classes15.dex */
class WsPolicy {
    private int mIndex;
    private RetryPolicy mRetryPolicy;
    private String mTargetUrl;
    private final List<String> mUrls;

    public synchronized String getNextUrl() {
        monitor-enter(this);
        int r100 = this.mIndex + 1;     // Catch: Throwable -> L11
        this.mIndex = r100;     // Catch: Throwable -> L11
        if (this.mUrls.size() <= r100) goto L9;
        String r101 = (String) ListProtector.get(this.mUrls, r100);     // Catch: Throwable -> L11
        this.mTargetUrl = r101;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized String getUrl() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (StringUtils.isEmpty(this.mTargetUrl) == false) goto L8;
        int r100 = this.mUrls.size();     // Catch: Throwable -> L11
        int r101 = this.mIndex;     // Catch: Throwable -> L11
        if (r100 <= r101) goto L8;
        this.mTargetUrl = (String) ListProtector.get(this.mUrls, r101);     // Catch: Throwable -> L11
    L8:
        String r102 = this.mTargetUrl;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.mRetryPolicy.reset();     // Catch: Throwable -> L6
        this.mTargetUrl = null;     // Catch: Throwable -> L6
        this.mIndex = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Pair<String, Long> getRetryUrlAndInterval(Response r100) {
        monitor-enter(this);
        String r101 = getUrl();     // Catch: Throwable -> L11
        long r102 = this.mRetryPolicy.getRetryIntervalWithResponse(r100);     // Catch: Throwable -> L11
        if (r102 != (-1)) goto L8;
        this.mRetryPolicy.reset();     // Catch: Throwable -> L11
        r101 = getNextUrl();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r102 = this.mRetryPolicy.getRandomInterval();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r103 = new Pair(r101, Long.valueOf(r102));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public WsPolicy(List<String> r100, RetryPolicy r101) {
        this.mIndex = 0;
        ArrayList r102 = new ArrayList();
        this.mUrls = r102;
        if (r100 == null) goto L5;
        r102.addAll(r100);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r102);
        this.mRetryPolicy = r101;
        reset();
    }
}
