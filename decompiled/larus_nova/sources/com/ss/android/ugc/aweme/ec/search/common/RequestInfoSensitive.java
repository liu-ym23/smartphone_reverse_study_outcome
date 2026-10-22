package com.ss.android.ugc.aweme.ec.search.common;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes40.dex */
public interface RequestInfoSensitive {
    public static final Gson Y1 = null;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.ec.search.common.RequestInfoSensitive$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static RequestLog $default$getRequestLog(RequestInfoSensitive r100) {
            BaseHttpRequestInfo r101 = r100.getRequestInfo();
            if (r101 != null) goto L5;
            return null;
        L5:
            String r102 = r101.requestLog;
            return (RequestLog) RequestInfoSensitive.Y1.fromJson(r102, RequestLog.class);
        L8:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    BaseHttpRequestInfo getRequestInfo();

    RequestLog getRequestLog();

    static {
        Y1 = new Gson();
    }
}
