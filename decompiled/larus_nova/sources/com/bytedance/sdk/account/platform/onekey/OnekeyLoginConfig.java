package com.bytedance.sdk.account.platform.onekey;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class OnekeyLoginConfig {
    public static final long OVER_TIME = 4000;
    private CMSettingConfig mCMSettingConfig;
    private CTSettingConfig mCTSettingConfig;
    private CUSettingConfig mCUSettingConfig;
    private final IOnekeyMonitor mMonitor;

    public static class CMSettingConfig {
        public String mCMAppId;
        public String mCMAppKey;
        public long mOverTime;

        public CMSettingConfig(String r100, String r101) {
            this.mCMAppId = r100;
            this.mCMAppKey = r101;
        }
    }

    public static class CTSettingConfig {
        public String mCTAppKey;
        public String mCTAppSecret;
        private boolean mIsShowLog;
        private String mLogTag;

        public String getLogTag() {
            return this.mLogTag;
        }

        public boolean isShowLog() {
            return this.mIsShowLog;
        }

        public void setLogTag(String r100) {
            this.mLogTag = r100;
        }

        public void setShowLog(boolean r100) {
            this.mIsShowLog = r100;
        }

        public CTSettingConfig(String r100, String r101) {
            this.mCTAppKey = r100;
            this.mCTAppSecret = r101;
        }
    }

    public static class CUSettingConfig {
        public String mCUAppId;
        public String mCUAppSecret;

        public CUSettingConfig(String r100, String r101) {
            this.mCUAppId = r100;
            this.mCUAppSecret = r101;
        }
    }

    public CMSettingConfig getCMSettingConfig() {
        return this.mCMSettingConfig;
    }

    public CTSettingConfig getCTSettingConfig() {
        return this.mCTSettingConfig;
    }

    public CUSettingConfig getCUSettingConfig() {
        return this.mCUSettingConfig;
    }

    public IOnekeyMonitor getMonitor() {
        return this.mMonitor;
    }

    public OnekeyLoginConfig(IOnekeyMonitor r100) {
        this.mMonitor = r100;
    }

    public OnekeyLoginConfig getDefault(boolean r100) {
        if (r100 == false) goto L14;
        if (this.mCMSettingConfig != null) goto L8;
        this.mCMSettingConfig = new CMSettingConfig("300012508715", "0ABC36EBE17445692CC54999BBB6B4EC");     // Catch: Throwable -> L23
    L8:
        if (this.mCTSettingConfig != null) goto L11;
        this.mCTSettingConfig = new CTSettingConfig("9390258199", "zX8xjEmXRsGDsxWMtZ3yKmLLfBMsaEMW");     // Catch: Throwable -> L23
    L11:
        if (this.mCUSettingConfig != null) goto L24;
        this.mCUSettingConfig = new CUSettingConfig("83730c0973c0a1762473789108637727", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVyG9svi4AdaXlTxWCVCccZAA2DDS9wUmLi10XOe/aecivUSeoyMSHDNhVpf3ALOzqnJN24Sh1jpnN6j/GRjDs4AjFLOzNixg8V8YnAoa7JE7EL4+f6BbnJ308Apn45LxGpTatfrfSQGQBb1iCSBxVAyeWYtwLWmDTFFM5OAyYGwIDAQAB");     // Catch: Throwable -> L23
    L24:
        return this;
    L14:
        if (this.mCMSettingConfig != null) goto L17;
        this.mCMSettingConfig = new CMSettingConfig("300012508715", "0ABC36EBE17445692CC54999BBB6B4EC");     // Catch: Throwable -> L23
    L17:
        if (this.mCTSettingConfig != null) goto L20;
        this.mCTSettingConfig = new CTSettingConfig("9390258199", "zX8xjEmXRsGDsxWMtZ3yKmLLfBMsaEMW");     // Catch: Throwable -> L23
    L20:
        if (this.mCUSettingConfig != null) goto L24;
        this.mCUSettingConfig = new CUSettingConfig("83730c0973c0a1762473789108637727", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVyG9svi4AdaXlTxWCVCccZAA2DDS9wUmLi10XOe/aecivUSeoyMSHDNhVpf3ALOzqnJN24Sh1jpnN6j/GRjDs4AjFLOzNixg8V8YnAoa7JE7EL4+f6BbnJ308Apn45LxGpTatfrfSQGQBb1iCSBxVAyeWYtwLWmDTFFM5OAyYGwIDAQAB");     // Catch: Throwable -> L23
    L23:
        Logger.e("OnekeyLoginConfig", " auto set config fail");
        goto L24
    }

    public OnekeyLoginConfig setCMSetting(String r100, String r101) {
        this.mCMSettingConfig = new CMSettingConfig(r100, r101);
        return this;
    }

    public OnekeyLoginConfig setCTSetting(String r100, String r101) {
        this.mCTSettingConfig = new CTSettingConfig(r100, r101);
        return this;
    }

    public OnekeyLoginConfig setCUSetting(String r100, String r101) {
        this.mCUSettingConfig = new CUSettingConfig(r100, r101);
        return this;
    }
}
