package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowModuleStateMap implements NonProguard {
    public Map<String, FollowModuleState> followModuleStateMap;

    public FollowModuleStateMap() {
        this.followModuleStateMap = new HashMap();
    }

    public void addFollowModuleState(String r2, FollowModuleState r3) {
        this.followModuleStateMap.put(r2, r3);
    }
}
