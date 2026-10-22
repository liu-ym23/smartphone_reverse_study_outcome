package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a2 extends c2 implements b2 {
    public c2 build0() {
        if (this.mClientType == (-1)) goto L6;
        return this;
    L6:
        throw new IllegalArgumentException("MSConfig init error");
    }

    public b2 setBDDeviceID0(String r100) {
        this.mBDDeviceID = r100;
        return this;
    }

    public b2 setChannel0(String r100) {
        this.mChannel = r100;
        return this;
    }

    public b2 setClientType0(int r100) {
        this.mClientType = r100;
        return this;
    }

    public b2 setCustomInfo0(Map<String, String> r100) {
        if (r100 != null) goto L4;
        r100 = new HashMap();
    L4:
        this.mCustomInfo = r100;
        return this;
    }

    public b2 setDefaultReportHost0(String r100) {
        this.mDefaultReportHost = r100;
        return this;
    }

    public b2 setDeviceID0(String r100) {
        this.mDeviceID = r100;
        return this;
    }

    public b2 setFetchedDidInterface0(MSConfig.Builder.IFetchedDid r100) {
        this.mFetchedDidIntf = r100;
        return this;
    }

    public b2 setInstallID0(String r100) {
        this.mInstallID = r100;
        return this;
    }

    public b2 setMsComplianceScene0(MSConfig.Builder.IMsComplianceScene r100) {
        u2.f515377b.f515378a = r100;
        return this;
    }

    public b2 setMsSettingConfig0(MSConfig.Builder.IMsSettingConfig r100) {
        v2.f515403b.f515405a = r100;
        return this;
    }

    public b2 setOVRegionType0(int r100) {
        this.mOVRegionType = r100;
        return this;
    }

    public b2 setSecssionID0(String r100) {
        this.mSessionID = r100;
        return this;
    }

    public b2 addAdvanceInfo0(String r100, String r101) {
        this.mAdvanceInfo.put(r100, r101);
        return this;
    }

    public a2(String r100, String r101, int r102) {
        this.mAppID = r100;
        this.mLicensetStr = r101;
        this.mCollectMode = r102;
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if ("0".equals(r100) == true) goto L10;
        if (TextUtils.isEmpty(r101) == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("appID or license must be set.");
    }

    public a2(String r100, String r101, String r102, int r103) {
        this.mSDKID = r100;
        this.mSubAppID = r101;
        this.mLicensetStr = r102;
        this.mCollectMode = r103;
        if (TextUtils.isEmpty(r100) == true) goto L12;
        if ("0".equals(r100) == true) goto L12;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("sdkID or license must be set.");
    }
}
