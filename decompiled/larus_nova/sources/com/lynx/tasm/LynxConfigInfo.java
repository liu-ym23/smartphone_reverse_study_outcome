package com.lynx.tasm;

import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxConfigInfo {
    private final String mCliVersion;
    private final boolean mCssAlignWithLegacyW3c;
    private final String mCustomData;
    private final boolean mEnableCSSParser;
    private final boolean mEnableLepusNG;
    private final String mLepusVersion;
    private final String mPageType;
    private final String mPageVersion;
    private final String mRadonMode;
    private final String mReactVersion;
    private final Set<String> mRegisteredComponent;
    private final String mTargetSdkVersion;
    private final String mTemplateUrl;
    private final ThreadStrategyForRendering mThreadStrategyForRendering;

    public static /* synthetic */ class a {
    }

    public static class b {
        public b() {
        }
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("pageVersion", this.mPageVersion);     // Catch: Throwable -> L9
        r100.put("pageType", this.mPageType);     // Catch: Throwable -> L9
        r100.put("cliVersion", this.mCliVersion);     // Catch: Throwable -> L9
        r100.put("customData", this.mCustomData);     // Catch: Throwable -> L9
        r100.put("templateUrl", this.mTemplateUrl);     // Catch: Throwable -> L9
        r100.put("targetSdkVersion", this.mTargetSdkVersion);     // Catch: Throwable -> L9
        r100.put("lepusVersion", this.mLepusVersion);     // Catch: Throwable -> L9
        r100.put("isEnableLepusNG", this.mEnableLepusNG);     // Catch: Throwable -> L9
        r100.put("radonMode", this.mRadonMode);     // Catch: Throwable -> L9
        r100.put("reactVersion", this.mReactVersion);     // Catch: Throwable -> L9
        ThreadStrategyForRendering r101 = this.mThreadStrategyForRendering;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        int r102 = r101.id();     // Catch: Throwable -> L9
    L7:
        r100.put("threadStrategyForRendering", r102);     // Catch: Throwable -> L9
        r100.put("registeredComponent", this.mRegisteredComponent);     // Catch: Throwable -> L9
        r100.put("cssAlignWithLegacyW3c", this.mCssAlignWithLegacyW3c);     // Catch: Throwable -> L9
        r100.put("cssParser", this.mEnableCSSParser);     // Catch: Throwable -> L9
    L11:
        return r100;
    L6:
        r102 = 0;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public String getCliVersion() {
        return this.mCliVersion;
    }

    public boolean getCssAlignWithLegacyW3c() {
        return this.mCssAlignWithLegacyW3c;
    }

    public String getCustomData() {
        return this.mCustomData;
    }

    public String getLepusVersion() {
        return this.mLepusVersion;
    }

    public String getPageType() {
        return this.mPageType;
    }

    public String getPageVersion() {
        return this.mPageVersion;
    }

    public String getRadonMode() {
        return this.mRadonMode;
    }

    public String getReactVersion() {
        return this.mReactVersion;
    }

    public Set<String> getRegisteredComponent() {
        return this.mRegisteredComponent;
    }

    public String getTargetSdkVersion() {
        return this.mTargetSdkVersion;
    }

    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        return this.mThreadStrategyForRendering;
    }

    public boolean isEnableLepusNG() {
        return this.mEnableLepusNG;
    }

    private LynxConfigInfo(b r100) {
        r100.getClass();
        this.mPageVersion = "error";
        this.mPageType = "error";
        this.mCliVersion = "error";
        this.mCustomData = "error";
        this.mTemplateUrl = "error";
        this.mTargetSdkVersion = "error";
        this.mLepusVersion = "error";
        this.mThreadStrategyForRendering = null;
        this.mEnableLepusNG = false;
        this.mRadonMode = "error";
        this.mReactVersion = "error";
        this.mRegisteredComponent = null;
        this.mCssAlignWithLegacyW3c = false;
        this.mEnableCSSParser = false;
    }

    public /* synthetic */ LynxConfigInfo(b r100, a r101) {
        this(r100);
    }
}
