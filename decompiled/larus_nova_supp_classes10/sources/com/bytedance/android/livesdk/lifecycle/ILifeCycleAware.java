package com.bytedance.android.livesdk.lifecycle;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ServiceLookup("com.bytedance.android.livesdk.lifecycle.LifeCycleService")
public interface ILifeCycleAware extends IService {
    void onEndSession(String r1);

    void onEndSession(String r1, HashMap<String, String> r2);

    void onEnterLiveRoomSuccess(String r1, String r2);

    void onInteractionFragmentDestroy(String r1);

    void onShowLiveEnd(String r1);
}
