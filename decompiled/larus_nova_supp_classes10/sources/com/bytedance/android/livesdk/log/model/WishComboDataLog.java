package com.bytedance.android.livesdk.log.model;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR)\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/log/model/WishComboDataLog;", "", "()V", "groupCountMap", "Ljava/util/HashMap;", "", "", "getGroupCountMap", "()Ljava/util/HashMap;", "groupExtraMap", "", "getGroupExtraMap", "clearMap", "", "removeGroup", "groupId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WishComboDataLog {
    private final HashMap<String, Long> groupCountMap;
    private final HashMap<String, Map<String, String>> groupExtraMap;

    public final void clearMap() {
        this.groupCountMap.clear();
        this.groupExtraMap.clear();
    }

    public WishComboDataLog() {
        this.groupCountMap = new HashMap();
        this.groupExtraMap = new HashMap();
    }

    public final HashMap<String, Long> getGroupCountMap() {
        return this.groupCountMap;
    }

    public final HashMap<String, Map<String, String>> getGroupExtraMap() {
        return this.groupExtraMap;
    }

    public final void removeGroup(String r2) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        this.groupCountMap.remove(r2);
        this.groupExtraMap.remove(r2);
    }
}
