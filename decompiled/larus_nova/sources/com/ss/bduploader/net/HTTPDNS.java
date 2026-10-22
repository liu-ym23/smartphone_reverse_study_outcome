package com.ss.bduploader.net;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.bduploader.BDUploadLog;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGlobalGoogleDNSParseHost = "";
    private static String mGlobalOwnDNSParseHost = "";
    private static String mGoogleDNSServerPath = "/resolve?name=";
    private static String mTTDNSServerPath = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    private String _getURL() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.mHttpDNSType;
        if (r101 != 2) goto L5;
    L10:
        r100.append("https://" + mGlobalOwnDNSParseHost + mTTDNSServerPath);
    L11:
        r100.append(this.mHostname);
        return r100.toString();
    L5:
        if (r101 == 1) goto L10;
        if (r101 != 3) goto L11;
        r100.append("https://" + mGlobalGoogleDNSParseHost + mGoogleDNSServerPath);
        goto L11
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void cancel() {
        if (this.mCancelled == false) goto L5;
        return;
    L5:
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.ss.bduploader.net.BaseDNS
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

    private BDUploadDNSInfo parserResult(JSONObject r110) {
        int r100 = this.mHttpDNSType;
        int r101 = 0;
        String r111 = "";
        int r112 = 60;
        if (r100 == 2) goto L7;
        if (r100 == 1) goto L7;
        long r113 = 0;
        String r102 = null;
    L31:
        if (this.mHttpDNSType != 3) goto L59;
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r110, "Answer");     // Catch: Exception -> L54
    L34:
        if (r101 >= r103.length()) goto L52;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r103, r101);     // Catch: Exception -> L54
        if (r104.has("type") == false) goto L51;
        if (JSONObjectProtectorUtils.getInt(r104, "type") != 1) goto L51;
        if (r104.has("TTL") == false) goto L43;
        r112 = r104.optInt("TTL");     // Catch: Exception -> L54
    L43:
        if (r104.has("data") == false) goto L46;
        r102 = r104.optString("data");     // Catch: Exception -> L54
    L46:
        if (TextUtils.isEmpty(r102) == true) goto L51;
        if (TextUtils.isEmpty(r111) == false) goto L50;
        r111 = r111 + r102;     // Catch: Exception -> L54
        goto L51
    L50:
        r111 = r111 + "," + r102;     // Catch: Exception -> L54
    L51:
        r101 = r101 + 1;     // Catch: Exception -> L54
        goto L34
    L52:
        r113 = System.currentTimeMillis() + ((long) (r112 * 1000));
    L54:
        e = move-exception;
        e.printStackTrace();
        return null;
    L59:
        return new BDUploadDNSInfo(this.mHttpDNSType, this.mHostname, r111, r113, this.mId);
    L7:
        JSONArray r105 = r110.optJSONArray("ips");
        if (r105 != null) goto L10;
    L60:
        BDUploadLog.d(TAG, String.format("no ips in json, type:%d", new Object[]{Integer.valueOf(this.mHttpDNSType)}));
        return null;
    L10:
        if (r105.length() == 0) goto L60;
        if (r110.has(RemoteMessageConst.TTL) == false) goto L15;
        r112 = r110.optInt(RemoteMessageConst.TTL);
    L15:
        int r114 = r112;
        r113 = System.currentTimeMillis() + ((long) (r112 * 1000));
        r102 = null;
        int r115 = 0;
    L17:
        if (r115 >= r105.length()) goto L29;
        r102 = JSONArrayProtectorUtils.getString(r105, r115);     // Catch: Exception -> L20
    L23:
        if (TextUtils.isEmpty(r102) == true) goto L28;
        if (TextUtils.isEmpty(r111) == false) goto L27;
        r111 = r111 + r102;
        goto L28
    L27:
        r111 = r111 + "," + r102;
    L28:
        r115 = r115 + 1;
    L20:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
        goto L23
    L29:
        r112 = r114;
        goto L31
    }

    private void _handleResponse(JSONObject r110, Error r111) {
        BDUploadLog.d(TAG, String.format("****http dns id:%s", new Object[]{this.mId}));
        BDUploadDNSInfo r100 = new BDUploadDNSInfo(this.mHttpDNSType, this.mHostname, null, 0, this.mId);
        if (r111 == null) goto L5;
        r100.mErrorStr = r111.errStr;
    L15:
        notifyError(r100);
        return;
    L5:
        if (r110 != null) goto L7;
    L14:
        BDUploadLog.d(TAG, String.format("http dns json is empty type:%d", new Object[]{Integer.valueOf(this.mHttpDNSType)}));
        goto L15
    L7:
        if (r110.length() == 0) goto L14;
        BDUploadDNSInfo r112 = parserResult(r110);
        if (r112 == null) goto L15;
        IPCache.getInstance().put(this.mHostname, r112);
        notifySuccess(r112);
    }

    public static void setDNSServerHost(String r100, String r101) {
        monitor-enter(HTTPDNS.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        mGlobalOwnDNSParseHost = r100;     // Catch: Throwable -> L12
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        mGlobalGoogleDNSParseHost = r101;     // Catch: Throwable -> L12
    L10:
        monitor-exit(HTTPDNS.class);     // Catch: Throwable -> L12
    }

    public static /* synthetic */ void access$000(HTTPDNS r100, JSONObject r101, Error r102) {
        r100._handleResponse(r101, r102);
    }

    public HTTPDNS(String r100, BDVNetClient r101, int r102, Handler r103) {
        super(r100, r101, r103);
        this.mHttpDNSType = r102;
    }
}
