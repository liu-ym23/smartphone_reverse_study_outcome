package com.ss.android.ugc.aweme.base.api;

import com.ss.android.ugc.aweme.base.common.IBaseService;
import com.ss.android.ugc.aweme.base.common.ServiceImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@ServiceImpl("com.ss.android.ugc.aweme.live.livehostimpl.LiveSDKProxyHostImpl")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/base/api/ILiveSDKHostService;", "Lcom/ss/android/ugc/aweme/base/common/IBaseService;", "livebusiness_base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveSDKHostService extends IBaseService {
    void a();

    boolean b();

    boolean f();

    boolean hasPluginInstalled();
}
