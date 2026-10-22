package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c2 {
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    private static final int COLLECT_MODE_603 = 603;
    private static final int COLLECT_MODE_APPLIST = 810;
    public static final int COLLECT_MODE_DEFAULT = 99999;
    public static final int COLLECT_MODE_FINANCE = 300;
    public static final int COLLECT_MODE_FLOW = 603;
    public static final int COLLECT_MODE_MINIMIZE = 5;
    private static final int COLLECT_MODE_MINIMIZE503 = 5;
    public static final int COLLECT_MODE_ML_AL = 810;
    private static final int COLLECT_MODE_ML_BASE = 280;
    public static final int COLLECT_MODE_ML_MINIMIZE = 290;
    public static final int COLLECT_MODE_ML_TEEN = 280;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;
    protected Map<String, String> mAdvanceInfo;
    protected String mAppID;
    protected String mBDDeviceID;
    protected String mChannel;
    protected int mClientType;
    protected int mCollectMode;
    protected Map<String, String> mCustomInfo;
    protected String mDefaultReportHost;
    protected String mDeviceID;
    protected String mFetchedDid;
    protected MSConfig.Builder.IFetchedDid mFetchedDidIntf;
    protected String mInstallID;
    protected String mLicensetStr;
    protected int mOVRegionType;
    protected int mOrigin;
    protected String mSDKID;
    protected String mSDKVersion;
    protected String mSessionID;
    protected String mSubAppID;

    public synchronized String toNativeValue() {
        monitor-enter(this);
        JSONArray r100 = new JSONArray();     // Catch: Throwable -> L18
        r100.put(wrap(this.mAppID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mSubAppID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mSDKID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mLicensetStr));     // Catch: Throwable -> L18
        r100.put(wrap(w3.f515419a));     // Catch: Throwable -> L18
        r100.put(wrap(this.mChannel));     // Catch: Throwable -> L18
        r100.put(wrap(this.mDeviceID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mBDDeviceID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mInstallID));     // Catch: Throwable -> L18
        r100.put(wrap(this.mSessionID));     // Catch: Throwable -> L18
        r100.put(String.valueOf(this.mClientType));     // Catch: Throwable -> L18
        r100.put(String.valueOf(this.mOVRegionType));     // Catch: Throwable -> L18
        r100.put(String.valueOf(this.mCollectMode));     // Catch: Throwable -> L18
        r100.put(wrap(this.mFetchedDid));     // Catch: Throwable -> L18
        r100.put(String.valueOf(this.mOrigin));     // Catch: Throwable -> L18
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, String>> r102 = this.mCustomInfo.entrySet().iterator();     // Catch: Throwable -> L18
    L5:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L5;
        r101.put(wrap(r103.getKey()));     // Catch: Throwable -> L18
        r101.put(wrap(r103.getValue()));     // Catch: Throwable -> L18
        goto L5
    L9:
        r100.put(r101);     // Catch: Throwable -> L18
        JSONArray r104 = new JSONArray();     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, String>> r105 = this.mAdvanceInfo.entrySet().iterator();     // Catch: Throwable -> L18
    L11:
        if (r105.hasNext() == false) goto L15;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r106.getKey()) == true) goto L11;
        r104.put(wrap(r106.getKey()));     // Catch: Throwable -> L18
        r104.put(wrap(r106.getValue()));     // Catch: Throwable -> L18
        goto L11
    L15:
        r100.put(r104);     // Catch: Throwable -> L18
        String r107 = r100.toString();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r107;
    L18:
        th = move-exception;
        throw th;
    }

    public c2() {
        this.mAppID = "";
        this.mChannel = "";
        this.mDeviceID = "";
        this.mBDDeviceID = "";
        this.mInstallID = "";
        this.mSessionID = "";
        this.mSDKID = "";
        this.mSubAppID = "";
        this.mLicensetStr = "";
        this.mDefaultReportHost = "";
        this.mSDKVersion = "";
        this.mClientType = -1;
        this.mOVRegionType = -1;
        this.mCollectMode = 99999;
        this.mCustomInfo = new HashMap();
        this.mAdvanceInfo = new HashMap();
    }

    public synchronized void setFetchedDid(String r100) {
        monitor-enter(this);
        this.mFetchedDid = r100;     // Catch: Throwable -> L6
        this.mOrigin = 1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String wrap(Object r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if ((r100 instanceof String) == true) goto L6;
        return "";
    L6:
        return ((String) r100).trim();
    }
}
