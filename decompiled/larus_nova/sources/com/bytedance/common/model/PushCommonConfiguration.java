package com.bytedance.common.model;

import android.app.Application;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonEventSender;
import v67.b;

/* JADX INFO: loaded from: classes3.dex */
public class PushCommonConfiguration {
    public int mAid;
    public String mAppName;
    public Application mApplication;
    public String mChannel;
    public ClientDisplayFeature mClientDisplayFeature;
    public boolean mEnableAlog;
    public boolean mEnableLazy;
    public boolean mEnableRealTimeReportEvent;
    public String mHost;
    public b mI18nCommonParams;
    public IPushCommonConfiguration mIPushCommonConfiguration;
    public IPushCommonEventSender mIPushCommonEventSender;
    public boolean mIsBoe;
    public boolean mIsDebugMode;
    public boolean mIsLaunchFromIcon;
    public boolean mIsThroughMsgEncrypt;
    public String mProcess;
    public String mSelfAid;
    public int mUpdateVersionCode;
    public int mVersionCode;
    public String mVersionName;

    public PushCommonConfiguration() {
        this.mIsDebugMode = false;
        this.mIPushCommonConfiguration = new AnonymousClass1(this);
    }
}
