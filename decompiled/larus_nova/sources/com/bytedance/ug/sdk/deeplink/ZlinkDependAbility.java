package com.bytedance.ug.sdk.deeplink;

import android.app.Application;
import ci7.z;
import com.bytedance.ug.sdk.deeplink.fission.CallbackForFission;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ZlinkDependAbility {
    private Application mApplication;
    private boolean mAutoCheck;
    private CallBackForAppLink mCallBackForAppLink;
    private CallbackForFission mCallbackForFission;
    private boolean mEnableClipboardOutside;
    private boolean mEnableHuaWeiReferrer;
    private boolean mEnableLaunchLogForAppLink;
    private String mEntranceOfLaunchLogForAppLink;
    private List<String> mForbiddenActivityList;
    private boolean mForbiddenCheckClipBoard;
    private boolean mIsDebug;
    private String mMarketHost;
    private String mSettingHost;
    private IZlinkDepend mZlinkDepend;

    public static final class Builder {
        private Application mApplication;
        private boolean mAutoCheck;
        private CallBackForAppLink mCallBackForAppLink;
        private CallbackForFission mCallbackForFission;
        private boolean mEnableClipboardOutside;
        private boolean mEnableHuaWeiReferrer;
        private boolean mEnableLaunchLogForAppLink;
        private String mEntranceOfLaunchLogForAppLink;
        private List<String> mForbiddenActivityList;
        private boolean mForbiddenCheckClipBoard;
        private boolean mIsDebug;
        private String mMarketHost;
        private String mSettingHost;
        private IZlinkDepend mZlinkDepend;

        public ZlinkDependAbility build() {
            return new ZlinkDependAbility(this, null);
        }

        public Builder() {
            this.mEnableHuaWeiReferrer = true;
            this.mForbiddenCheckClipBoard = false;
        }

        public static /* synthetic */ boolean access$000(Builder r100) {
            return r100.mIsDebug;
        }

        public static /* synthetic */ boolean access$100(Builder r100) {
            return r100.mAutoCheck;
        }

        public static /* synthetic */ boolean access$1000(Builder r100) {
            return r100.mEnableLaunchLogForAppLink;
        }

        public static /* synthetic */ String access$1100(Builder r100) {
            return r100.mEntranceOfLaunchLogForAppLink;
        }

        public static /* synthetic */ String access$1200(Builder r100) {
            return r100.mSettingHost;
        }

        public static /* synthetic */ String access$1300(Builder r100) {
            return r100.mMarketHost;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.mEnableHuaWeiReferrer;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.mForbiddenCheckClipBoard;
        }

        public static /* synthetic */ boolean access$400(Builder r100) {
            return r100.mEnableClipboardOutside;
        }

        public static /* synthetic */ Application access$500(Builder r100) {
            return r100.mApplication;
        }

        public static /* synthetic */ IZlinkDepend access$600(Builder r100) {
            return r100.mZlinkDepend;
        }

        public static /* synthetic */ CallBackForAppLink access$700(Builder r100) {
            return r100.mCallBackForAppLink;
        }

        public static /* synthetic */ CallbackForFission access$800(Builder r100) {
            return r100.mCallbackForFission;
        }

        public static /* synthetic */ List access$900(Builder r100) {
            return r100.mForbiddenActivityList;
        }

        public Builder withApplication(Application r100) {
            if (r100 == null) goto L4;
            this.mApplication = r100;
        L4:
            return this;
        }

        public Builder withAutoCheck(boolean r100) {
            this.mAutoCheck = r100;
            return this;
        }

        public Builder withCallBackForAppLink(CallBackForAppLink r100) {
            if (r100 == null) goto L4;
            this.mCallBackForAppLink = r100;
        L4:
            return this;
        }

        public Builder withCallbackForFission(CallbackForFission r100) {
            if (r100 == null) goto L4;
            this.mCallbackForFission = r100;
        L4:
            return this;
        }

        public Builder withDebug(boolean r100) {
            this.mIsDebug = r100;
            return this;
        }

        public Builder withEnableClipboardOutside(boolean r100) {
            this.mEnableClipboardOutside = r100;
            return this;
        }

        public Builder withForbiddenActivityList(List<String> r100) {
            if (mi7.a.a(r100) == true) goto L5;
            this.mForbiddenActivityList = r100;
        L5:
            return this;
        }

        public Builder withForbiddenCheckClipBoard(boolean r100) {
            this.mForbiddenCheckClipBoard = r100;
            return this;
        }

        public Builder withHuaWeiReferrer(boolean r100) {
            this.mEnableHuaWeiReferrer = r100;
            return this;
        }

        public Builder withMarketHost(String r100) {
            this.mMarketHost = r100;
            return this;
        }

        public Builder withSettingHost(String r100) {
            this.mSettingHost = r100;
            return this;
        }

        public Builder withZlinkDepend(IZlinkDepend r100) {
            if (r100 == null) goto L4;
            this.mZlinkDepend = r100;
        L4:
            return this;
        }

        public Builder withLaunchLogForAppLink(boolean r100, String r101) {
            this.mEnableLaunchLogForAppLink = r100;
            this.mEntranceOfLaunchLogForAppLink = r101;
            return this;
        }

        public <T, K extends T> Builder withService(Class<T> r100, K r101) {
            z.b(r100, r101);
            return this;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {
    }

    public boolean enableLaunchLogForAppLink() {
        return this.mEnableLaunchLogForAppLink;
    }

    public String entranceOfLaunchLogForAppLink() {
        return this.mEntranceOfLaunchLogForAppLink;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public boolean getAutoCheck() {
        return this.mAutoCheck;
    }

    public CallBackForAppLink getCallBackForAppLink() {
        return this.mCallBackForAppLink;
    }

    public CallbackForFission getCallbackForFission() {
        return this.mCallbackForFission;
    }

    public boolean getEnableClipboardOutside() {
        return this.mEnableClipboardOutside;
    }

    public List<String> getForbiddenActivityList() {
        return this.mForbiddenActivityList;
    }

    public String getMarketHost() {
        return this.mMarketHost;
    }

    public String getSettingHost() {
        return this.mSettingHost;
    }

    public IZlinkDepend getZlinkDepend() {
        return this.mZlinkDepend;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public boolean isEnableHuaWeiReferrer() {
        return this.mEnableHuaWeiReferrer;
    }

    public boolean isForbiddenCheckClipBoard() {
        return this.mForbiddenCheckClipBoard;
    }

    private ZlinkDependAbility(Builder r100) {
        if (r100 == null) goto L6;
        this.mIsDebug = Builder.access$000(r100);
        this.mAutoCheck = Builder.access$100(r100);
        this.mEnableHuaWeiReferrer = Builder.access$200(r100);
        this.mForbiddenCheckClipBoard = Builder.access$300(r100);
        this.mEnableClipboardOutside = Builder.access$400(r100);
        this.mApplication = Builder.access$500(r100);
        this.mZlinkDepend = Builder.access$600(r100);
        this.mCallBackForAppLink = Builder.access$700(r100);
        this.mCallbackForFission = Builder.access$800(r100);
        this.mForbiddenActivityList = Builder.access$900(r100);
        this.mEnableLaunchLogForAppLink = Builder.access$1000(r100);
        this.mEntranceOfLaunchLogForAppLink = Builder.access$1100(r100);
        this.mSettingHost = Builder.access$1200(r100);
        this.mMarketHost = Builder.access$1300(r100);
        return;
    }

    public void setForbiddenClipboardByHost(boolean r100) {
        this.mForbiddenCheckClipBoard = r100;
    }

    public /* synthetic */ ZlinkDependAbility(Builder r100, a r101) {
        this(r100);
    }
}
