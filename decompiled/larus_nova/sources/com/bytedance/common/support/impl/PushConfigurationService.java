package com.bytedance.common.support.impl;

import android.app.Application;
import android.util.Log;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rgc.b;

/* JADX INFO: loaded from: classes3.dex */
public class PushConfigurationService implements IPushConfigurationService {
    private PushCommonConfiguration mDefaultPushCommonConfiguration;
    private long mProcessStartTimeStamp;
    private volatile PushCommonConfiguration mPushCommonConfiguration;
    private final List<Runnable> mRunAfterInitTask;

    private PushCommonConfiguration getConfiguration() {
        if (this.mPushCommonConfiguration != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.mPushCommonConfiguration != null) goto L10;
        IPushCommonInitConfigProvider r100 = (IPushCommonInitConfigProvider) b.a(IPushCommonInitConfigProvider.class);     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        this.mPushCommonConfiguration = r100.getConfiguration();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.mPushCommonConfiguration;
    }

    public PushConfigurationService() {
        this.mDefaultPushCommonConfiguration = new PushCommonConfiguration();
        this.mRunAfterInitTask = new ArrayList();
        this.mProcessStartTimeStamp = System.currentTimeMillis();
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public PushCommonConfiguration getPushCommonConfiguration() {
        if (getConfiguration() != null) goto L12;
        if (this.mDefaultPushCommonConfiguration.mApplication != null) goto L9;
        Application r100 = AppProvider.getApp();
        if (r100 == null) goto L9;
        f.i("PushConfigurationService", "[getPushCommonConfiguration]use mDefaultPushCommonConfiguration because mPushCommonConfiguration is null and app is not null,stack is " + Log.getStackTraceString(new Throwable()));
        this.mDefaultPushCommonConfiguration.mApplication = r100;
    L9:
        s67.b.a(new Throwable(), "error when getPushCommonConfiguration,mPushCommonConfiguration is null");
        return this.mDefaultPushCommonConfiguration;
    L12:
        return getConfiguration();
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public boolean keepOldInitTimeCost() {
        if (ToolUtils.isMainProcess(getConfiguration().mApplication) == true) goto L6;
        return true;
    L6:
        return !getConfiguration().mIPushCommonConfiguration.optMainProcessInitTimeCost();
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public boolean keepOldInitTimeCostV2() {
        if (ToolUtils.isMainProcess(getConfiguration().mApplication) == true) goto L6;
        return true;
    L6:
        return !getConfiguration().mIPushCommonConfiguration.optMainProcessInitTimeCostV2();
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public long getCurProcessStartTimeStamp() {
        return this.mProcessStartTimeStamp;
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public void injectConfiguration(PushCommonConfiguration r100) {
        this.mPushCommonConfiguration = r100;
        f.a("on init,try execute AfterInitTask");
        List<Runnable> r101 = this.mRunAfterInitTask;
        monitor-enter(r101);
        f.a("sRunAfterSmpInitTask.size is " + this.mRunAfterInitTask.size());     // Catch: Throwable -> L11
        Iterator<Runnable> r102 = this.mRunAfterInitTask.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().run();     // Catch: Throwable -> L11
        goto L6
    L8:
        this.mRunAfterInitTask.clear();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
