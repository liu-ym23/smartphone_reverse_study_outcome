package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class FollowModuleStateMap implements NonProguard {
    public Map<String, FollowModuleState> followModuleStateMap;

    public FollowModuleStateMap() {
        this.followModuleStateMap = new HashMap();
    }

    public void addFollowModuleState(String r100, FollowModuleState r101) {
        this.followModuleStateMap.put(r100, r101);
    }
}
