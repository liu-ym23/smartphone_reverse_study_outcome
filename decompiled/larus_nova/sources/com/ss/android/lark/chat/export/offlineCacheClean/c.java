package com.ss.android.lark.chat.export.offlineCacheClean;

import com.bytedance.lark.pb.im.v1.OfflineDataCleanPush;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes35.dex */
public interface c {
    @SdkPush(TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_ORIGIN_LC)
    RucketJob<OfflineDataCleanPush> pushOfflineDataClean();
}
