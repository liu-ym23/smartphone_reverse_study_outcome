package com.ss.android.lark.passport.signinsdk_api.base.log;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes37.dex */
public final class UniContext implements Serializable, Parcelable {
    public static final UniContext CONTEXT_DEVICES = null;
    public static final UniContext CONTEXT_EMPTY = null;
    public static final UniContext CONTEXT_GLOBAL = null;
    public static final UniContext CONTEXT_QR_CODE = null;
    public static final UniContext CONTEXT_START_UP = null;
    public static final UniContext CONTEXT_SWITCH = null;
    public static final Parcelable.Creator<UniContext> CREATOR = null;
    public static final String KEY_OF_BIZ_CODE = "biz_code";
    public static final String KEY_OF_CP = "cp";
    public static final String KEY_OF_ERROR_CODE = "error_code";
    public static final String KEY_OF_ERROR_MSG = "error_msg";
    public static final String KEY_OF_UNI_CONTEXT = "key_of_uni_context";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Bundle f438052a;
    private String curCountryCode;
    private String curUserName;
    private String mCp;
    private String mMonitorScene;
    private OPTrace mOPTraceScene;
    private final Map<String, String> mOneSceneMonitorParams;
    private final Map<String, String> mOneTimeParams;
    private String mSubDomain;
    private String mTraceId;
    private String mUseId;
    private String requestHost;

    public class a implements Parcelable.Creator<UniContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UniContext createFromParcel(Parcel r100) {
            return new UniContext(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UniContext[] newArray(int r100) {
            return new UniContext[r100];
        }
    }

    public synchronized void clearOneSceneMonitorParams() {
        monitor-enter(this);
        this.mOneSceneMonitorParams.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void clearOneTimeParams() {
        monitor-enter(this);
        this.mOneTimeParams.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public synchronized Map<String, Object> getOneSceneMonitorParams() {
        monitor-enter(this);
        ArrayMap r100 = new ArrayMap();     // Catch: Throwable -> L6
        r100.putAll(this.mOneSceneMonitorParams);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Map<String, String> getOneTimeParams() {
        monitor-enter(this);
        ArrayMap r100 = new ArrayMap();     // Catch: Throwable -> L6
        r100.putAll(this.mOneTimeParams);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        CONTEXT_GLOBAL = newInstance("global", true);
        CONTEXT_START_UP = newInstance("startUp", true);
        CONTEXT_EMPTY = newInstance("unknown", true);
        CONTEXT_DEVICES = newInstance("devices", true);
        CONTEXT_QR_CODE = newInstance(CommonConstant.KEY_QR_CODE, true);
        CONTEXT_SWITCH = newInstance("switch", true);
        CREATOR = new a();
    }

    public Bundle getBundle() {
        return this.f438052a;
    }

    public String getCp() {
        return this.mCp;
    }

    public String getCurCountryCode() {
        return this.curCountryCode;
    }

    public String getCurUserName() {
        return this.curUserName;
    }

    public String getMonitorScene() {
        return this.mMonitorScene;
    }

    public OPTrace getOPTraceScene() {
        return this.mOPTraceScene;
    }

    public String getRequestHost() {
        return this.requestHost;
    }

    public String getSubDomain() {
        return this.mSubDomain;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String getUseId() {
        return this.mUseId;
    }

    public UniContext(Parcel r100) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        this.mTraceId = r100.readString();
        this.mUseId = r100.readString();
        this.mCp = r100.readString();
        this.mSubDomain = r100.readString();
        this.curUserName = r100.readString();
        this.curCountryCode = r100.readString();
        this.requestHost = r100.readString();
        this.mMonitorScene = r100.readString();
        this.f438052a = r100.readBundle(UniContext.class.getClassLoader());
    }

    public void setBundle(Bundle r100) {
        this.f438052a = r100;
    }

    public synchronized UniContext setCp(String r100) {
        monitor-enter(this);
        this.mCp = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setCurCountryCode(String r100) {
        monitor-enter(this);
        this.curCountryCode = r100;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r100.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L8;
        this.curCountryCode = Marker.ANY_NON_NULL_MARKER.concat(this.curCountryCode);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized UniContext setCurUserName(String r100) {
        monitor-enter(this);
        this.curUserName = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public void setRequestHost(String r100) {
        this.requestHost = r100;
    }

    public void setTraceId(String r100) {
        this.mTraceId = r100;
    }

    public synchronized UniContext setUseId(String r100) {
        monitor-enter(this);
        this.mUseId = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public UniContext(String r100, OPTrace r101) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        this.mTraceId = gyb.a.a().getTracingID();
        this.mMonitorScene = r100;
        this.mOPTraceScene = r101;
    }

    public static UniContext newInstance(String r100, boolean r101) {
        return new UniContext(r100, r101);
    }

    public static UniContext newMonitorContext(String r100, OPTrace r101) {
        return new UniContext(r100, r101);
    }

    public synchronized UniContext appendOneSceneMonitorParam(String r100, String r101) {
        monitor-enter(this);
        this.mOneSceneMonitorParams.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized UniContext appendOneTimeParam(String r100, String r101) {
        monitor-enter(this);
        this.mOneTimeParams.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mTraceId);
        r100.writeString(this.mUseId);
        r100.writeString(this.mCp);
        r100.writeString(this.mSubDomain);
        r100.writeString(this.curUserName);
        r100.writeString(this.curCountryCode);
        r100.writeString(this.requestHost);
        r100.writeString(this.mMonitorScene);
        r100.writeBundle(this.f438052a);
    }

    public UniContext(String r100, boolean r101) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        if (r101 == false) goto L5;
        this.mTraceId = gyb.a.a().getTracingID();
    L5:
        this.mSubDomain = r100;
    }
}
