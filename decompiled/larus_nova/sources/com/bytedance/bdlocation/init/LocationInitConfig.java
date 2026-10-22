package com.bytedance.bdlocation.init;

import android.app.Application;
import android.content.Context;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.callback.ILiveExperienceProvider;
import com.bytedance.bdlocation.callback.ILocationInfoExtra;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.log.Printer;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LocationInitConfig {
    private boolean isPrivacyConfirmed;
    private long mAppBootTime;
    private String mAppId;
    private String mAppVersion;
    private BackgroundProvider mBackgroundProvider;
    private String mBaseUrl;
    private Map<String, Object> mBpeaCerts;
    private String mChannel;
    private Context mContext;
    private IDYHostInfoProvider mDYHostInfoProvider;
    private boolean mDebug;
    private String mDid;
    private boolean mEnableBackgroundLocation;
    private boolean mEnableHARCollect;
    private boolean mEnableSelfStartService;
    private IEventManager mEventManager;
    private ILocationInfoExtra mILocationInfoExtra;
    private ILiveExperienceProvider mLiveExperienceProvider;
    private Locale mLocale;
    private int mLocateType;
    private ICustomNetworkApi mNetworkApi;
    private String mPackageName;
    private IPermissionChecker mPermissionChecker;
    private boolean mPollingUpload;
    private Printer mPrinter;
    private BDRestrictedMode mRestrictedMode;
    private String mUpdateVersionCode;
    private String mWorldView;

    public static class Builder {
        private long mAppBootTime;
        private String mAppId;
        private String mAppVersion;
        private BackgroundProvider mBackgroundProvider;
        private String mBaseUrl;
        private Map<String, Object> mBpeaCerts;
        private String mChannel;
        private Context mContext;
        private IDYHostInfoProvider mDYHostInfoProvider;
        private boolean mDebug;
        private String mDid;
        private boolean mEnableBackgroundLocation;
        private boolean mEnableHARService;
        private boolean mEnableSelfStartService;
        private IEventManager mEventManager;
        private ILocationInfoExtra mILocationInfoExtra;
        private boolean mIsPrivacyConfirmed;
        private ILiveExperienceProvider mLiveExperienceProvider;
        private Locale mLocale;
        private int mLocateType;
        private ICustomNetworkApi mNetworkApi;
        private String mPackageName;
        private IPermissionChecker mPermissionChecker;
        private boolean mPollingUpload;
        private Printer mPrinter;
        private BDRestrictedMode mRestrictedMode;
        private String mUpdateVersionCode;
        private String mWorldView;

        public LocationInitConfig build() {
            LocationInitConfig r100 = new LocationInitConfig();
            r100.setBaseUrl(this.mBaseUrl);
            r100.setRestrictedMode(this.mRestrictedMode);
            r100.setCustomNetworkApi(this.mNetworkApi);
            r100.setDid(this.mDid);
            r100.setAppId(this.mAppId);
            r100.setChannel(this.mChannel);
            r100.setAppVersion(this.mAppVersion);
            r100.setUpdateVersionCode(this.mUpdateVersionCode);
            r100.setPackageName(this.mPackageName);
            r100.setContext(this.mContext);
            r100.setPrivacyConfirmed(this.mIsPrivacyConfirmed);
            r100.setDebug(this.mDebug);
            r100.setBpeaCerts(this.mBpeaCerts);
            r100.setWorldView(this.mWorldView);
            r100.setLocale(this.mLocale);
            r100.setALogPrinter(this.mPrinter);
            r100.setPollingUpload(this.mPollingUpload);
            r100.setBackgroundProvider(this.mBackgroundProvider);
            r100.setEventManager(this.mEventManager);
            r100.setLocateType(this.mLocateType);
            r100.setEnableHARCollect(this.mEnableHARService);
            r100.setAppBootTime(this.mAppBootTime);
            r100.setILocationInfoExtra(this.mILocationInfoExtra);
            r100.setDYHostInfoProvider(this.mDYHostInfoProvider);
            r100.setLiveExperienceProvider(this.mLiveExperienceProvider);
            r100.setPermissionChecker(this.mPermissionChecker);
            r100.setEnableBackgroundLocation(this.mEnableBackgroundLocation);
            r100.setEnableSelfStartService(this.mEnableSelfStartService);
            return r100;
        }

        public int getLocateType() {
            return this.mLocateType;
        }

        public Builder(Application r100) {
            this.mBaseUrl = "";
            this.mDid = "";
            this.mAppId = "";
            this.mChannel = "";
            this.mAppVersion = "";
            this.mUpdateVersionCode = "";
            this.mPackageName = "";
            this.mIsPrivacyConfirmed = false;
            this.mDebug = false;
            this.mPollingUpload = false;
            this.mLocateType = 3;
            this.mEnableHARService = false;
            this.mEnableBackgroundLocation = false;
            this.mEnableSelfStartService = true;
            if (r100 == null) goto L10;
            Context r101 = r100.getApplicationContext();
            if (r101 == null) goto L7;
            r100 = r101;
        L7:
            this.mContext = r100;
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        public Builder isPrivacyConfirmed(boolean r100) {
            this.mIsPrivacyConfirmed = r100;
            return this;
        }

        public Builder setALogPrinter(Printer r100) {
            this.mPrinter = r100;
            return this;
        }

        public Builder setAppBootTime(long r100) {
            Logger.i("appBootTime:" + r100);
            this.mAppBootTime = r100;
            return this;
        }

        public Builder setAppId(String r100) {
            this.mAppId = r100;
            return this;
        }

        public Builder setAppVersion(String r100) {
            this.mAppVersion = r100;
            return this;
        }

        public Builder setBackgroundProvider(BackgroundProvider r100) {
            this.mBackgroundProvider = r100;
            return this;
        }

        public Builder setBaseUrl(String r100) {
            this.mBaseUrl = r100;
            return this;
        }

        public Builder setBpeaCerts(Map<String, Object> r100) {
            this.mBpeaCerts = r100;
            return this;
        }

        public Builder setChannel(String r100) {
            this.mChannel = r100;
            return this;
        }

        public Builder setCustomNetworkApi(ICustomNetworkApi r100) {
            this.mNetworkApi = r100;
            return this;
        }

        public Builder setDYHostInfoProvider(IDYHostInfoProvider r100) {
            this.mDYHostInfoProvider = r100;
            return this;
        }

        public Builder setDebug(boolean r100) {
            this.mDebug = r100;
            return this;
        }

        public Builder setDid(String r100) {
            this.mDid = r100;
            return this;
        }

        public Builder setEnableBackgroundLocation(boolean r100) {
            this.mEnableBackgroundLocation = r100;
            return this;
        }

        public Builder setEnableHARCollect(boolean r100) {
            this.mEnableHARService = r100;
            return this;
        }

        public Builder setEnableSelfStartService(boolean r100) {
            this.mEnableSelfStartService = r100;
            return this;
        }

        public Builder setEventManager(IEventManager r100) {
            this.mEventManager = r100;
            return this;
        }

        public Builder setILocationInfoExtra(ILocationInfoExtra r100) {
            this.mILocationInfoExtra = r100;
            return this;
        }

        public Builder setLiveExperienceProvider(ILiveExperienceProvider r100) {
            this.mLiveExperienceProvider = r100;
            return this;
        }

        public Builder setLocal(Locale r100) {
            this.mLocale = r100;
            return this;
        }

        public Builder setLocateType(int r100) {
            this.mLocateType = r100;
            return this;
        }

        public Builder setPackageName(String r100) {
            this.mPackageName = r100;
            return this;
        }

        public Builder setPermissionChecker(IPermissionChecker r100) {
            this.mPermissionChecker = r100;
            return this;
        }

        public Builder setPollingUpload(boolean r100) {
            this.mPollingUpload = r100;
            return this;
        }

        public Builder setRestrictedMode(BDRestrictedMode r100) {
            this.mRestrictedMode = r100;
            return this;
        }

        public Builder setUpdateVersionCode(String r100) {
            this.mUpdateVersionCode = r100;
            return this;
        }

        public Builder setWorldView(String r100) {
            this.mWorldView = r100;
            return this;
        }
    }

    public LocationInitConfig() {
        this.mDid = "";
        this.mAppId = "";
        this.mChannel = "";
        this.mAppVersion = "";
        this.mUpdateVersionCode = "";
        this.mPackageName = "";
        this.mBaseUrl = "";
        this.mDebug = false;
        this.mPollingUpload = false;
        this.mLocateType = 3;
        this.isPrivacyConfirmed = false;
        this.mEnableHARCollect = false;
        this.mEnableBackgroundLocation = false;
        this.mEnableSelfStartService = true;
    }

    public boolean enableBackgroundLocation() {
        return this.mEnableBackgroundLocation;
    }

    public boolean enableSelfStartService() {
        return this.mEnableSelfStartService;
    }

    public Printer getALogPrinter() {
        return this.mPrinter;
    }

    public long getAppBootTime() {
        return this.mAppBootTime;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public BackgroundProvider getBackgroundProvider() {
        return this.mBackgroundProvider;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public Map<String, Object> getBpeaCerts() {
        return this.mBpeaCerts;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ICustomNetworkApi getCustomNetworkApi() {
        return this.mNetworkApi;
    }

    public IDYHostInfoProvider getDYHostInfoProvider() {
        return this.mDYHostInfoProvider;
    }

    public boolean getDebug() {
        return this.mDebug;
    }

    public String getDid() {
        return this.mDid;
    }

    public IEventManager getEventManager() {
        return this.mEventManager;
    }

    public ILocationInfoExtra getILocationInfoExtra() {
        return this.mILocationInfoExtra;
    }

    public ILiveExperienceProvider getLiveExperienceProvider() {
        return this.mLiveExperienceProvider;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public IPermissionChecker getPermissionChecker() {
        return this.mPermissionChecker;
    }

    public BDRestrictedMode getRestrictedMode() {
        return this.mRestrictedMode;
    }

    public String getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    public String getWorldView() {
        return this.mWorldView;
    }

    public boolean isEnableHARCollect() {
        return this.mEnableHARCollect;
    }

    public boolean isPollingUpload() {
        return this.mPollingUpload;
    }

    public boolean isPrivacyConfirmed() {
        return this.isPrivacyConfirmed;
    }

    public void setALogPrinter(Printer r100) {
        this.mPrinter = r100;
    }

    public void setAppBootTime(long r100) {
        this.mAppBootTime = r100;
    }

    public void setAppId(String r100) {
        this.mAppId = r100;
    }

    public void setAppVersion(String r100) {
        this.mAppVersion = r100;
    }

    public void setBackgroundProvider(BackgroundProvider r100) {
        this.mBackgroundProvider = r100;
    }

    public void setBaseUrl(String r100) {
        this.mBaseUrl = r100;
    }

    public void setBpeaCerts(Map<String, Object> r100) {
        this.mBpeaCerts = r100;
    }

    public void setChannel(String r100) {
        this.mChannel = r100;
    }

    public void setContext(Context r100) {
        this.mContext = r100;
    }

    public void setCustomNetworkApi(ICustomNetworkApi r100) {
        this.mNetworkApi = r100;
    }

    public void setDYHostInfoProvider(IDYHostInfoProvider r100) {
        this.mDYHostInfoProvider = r100;
    }

    public void setDebug(boolean r100) {
        this.mDebug = r100;
    }

    public void setDid(String r100) {
        this.mDid = r100;
    }

    public void setEnableBackgroundLocation(boolean r100) {
        this.mEnableBackgroundLocation = r100;
    }

    public void setEnableHARCollect(boolean r100) {
        this.mEnableHARCollect = r100;
    }

    public void setEnableSelfStartService(boolean r100) {
        this.mEnableSelfStartService = r100;
    }

    public void setEventManager(IEventManager r100) {
        this.mEventManager = r100;
    }

    public void setILocationInfoExtra(ILocationInfoExtra r100) {
        this.mILocationInfoExtra = r100;
    }

    public void setLiveExperienceProvider(ILiveExperienceProvider r100) {
        this.mLiveExperienceProvider = r100;
    }

    public void setLocale(Locale r100) {
        this.mLocale = r100;
    }

    public void setLocateType(int r100) {
        this.mLocateType = r100;
    }

    public void setPackageName(String r100) {
        this.mPackageName = r100;
    }

    public void setPermissionChecker(IPermissionChecker r100) {
        this.mPermissionChecker = r100;
    }

    public void setPollingUpload(boolean r100) {
        this.mPollingUpload = r100;
    }

    public void setPrivacyConfirmed(boolean r100) {
        this.isPrivacyConfirmed = r100;
    }

    public void setRestrictedMode(BDRestrictedMode r100) {
        this.mRestrictedMode = r100;
    }

    public void setUpdateVersionCode(String r100) {
        this.mUpdateVersionCode = r100;
    }

    public void setWorldView(String r100) {
        this.mWorldView = r100;
    }
}
