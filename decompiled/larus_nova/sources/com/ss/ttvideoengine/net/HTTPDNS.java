package com.ss.ttvideoengine.net;

import android.text.TextUtils;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mTTDNSServerHost = "";
    private int mHttpDNSType;

    private String _getURL() {
        StringBuilder r100 = new StringBuilder();
        getTTDNSServerHost();
        r100.append("https://" + mTTDNSServerHost + "/q?host=");
        r100.append(this.mHostname);
        String r101 = r100.toString();
        TTVideoEngineLog.d(TAG, "http dns parse url is" + r101);
        return r101;
    }

    private static String getTTDNSServerHost() {
        monitor-enter(LocalDNS.class);
        String r100 = mTTDNSServerHost;     // Catch: Throwable -> L7
        monitor-exit(LocalDNS.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void cancel() {
        if (this.mCancelled == false) goto L5;
        return;
    L5:
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void start() {
        String r100 = _getURL();
        Method[] r101 = this.mNetClient.getClass().getDeclaredMethods();
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L10;
        Method r105 = r101[r104];
        if (r105.getName().equals("startTask") == false) goto L9;
        if (r105.getParameterTypes().length != 5) goto L9;
        r103 = true;
    L9:
        r104 = r104 + 1;
    L10:
        if (r103 == false) goto L12;
        this.mNetClient.startTask(r100, null, null, 0, new AnonymousClass1(this));
        return;
    L12:
        this.mNetClient.startTask(r100, null, new AnonymousClass2(this));
    }

    public static void setTTDNSServerHost(String r100) {
        monitor-enter(LocalDNS.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        mTTDNSServerHost = r100;     // Catch: Throwable -> L9
    L7:
        monitor-exit(LocalDNS.class);     // Catch: Throwable -> L9
    }

    private void _handleResponse(JSONObject r100, Error r101) {
        if (r101 == null) goto L5;
        r101.domain = Error.HTTPDNS;
    L32:
        notifyError(r101);
        return;
    L5:
        String r102 = "TT_";
        if (r100 == null) goto L27;
        if (r100.length() == 0) goto L27;
        JSONArray r103 = r100.optJSONArray("ips");
        if (r103 == null) goto L22;
        if (r103.length() == 0) goto L22;
        r100.put("time", System.currentTimeMillis());     // Catch: JSONException -> L17
        r100.put("dns_type", IVideoEventLogger.LOGGER_DNS_TYPE_HTTP);     // Catch: JSONException -> L17
    L19:
        notifySuccess(r100);
        return;
    L17:
        e = move-exception;
        TTVideoEngineLog.d(e);
    L22:
        if (this.mHttpDNSType == 2) goto L25;
        r102 = "ALI_";
    L25:
        Error r104 = new Error(Error.HTTPDNS, Error.ResultEmpty, r102.concat("HTTP dns empty"));
    L31:
        r101 = r104;
    L27:
        if (this.mHttpDNSType == 2) goto L30;
        r102 = "ALI_";
    L30:
        r104 = new Error(Error.HTTPDNS, Error.ResultEmpty, r102.concat("HTTP dns empty"));
        goto L31
    }

    public HTTPDNS(String r100, TTVNetClient r101, int r102) {
        super(r100, r101);
        this.mHttpDNSType = r102;
        if (r102 != 2) goto L5;
        String r103 = "_TT";
    L6:
        TTVideoEngineLog.i(TAG, "DNS use HTTPDNS".concat(r103));
        return;
    L5:
        r103 = "_ALI";
        goto L6
    }

    public static /* synthetic */ void access$000(HTTPDNS r100, JSONObject r101, Error r102) {
        r100._handleResponse(r101, r102);
    }
}
