package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

/* JADX INFO: loaded from: classes19.dex */
public class DispatchActionInfo {
    public boolean mActionHit;
    public String mDispatchedUrl;
    public boolean mNeedFeedBack;
    public int mPriority;
    public long mRuleid;
    public String mServiceName;
    public int mStrategyType;

    public DispatchActionInfo() {
    }

    public DispatchActionInfo(String r100, long r101, int r102, boolean r103, int r104, boolean r105, String r106) {
        this.mServiceName = r100;
        this.mRuleid = r101;
        this.mPriority = r102;
        this.mActionHit = r103;
        this.mStrategyType = r104;
        this.mNeedFeedBack = r105;
        this.mDispatchedUrl = r106;
    }
}
