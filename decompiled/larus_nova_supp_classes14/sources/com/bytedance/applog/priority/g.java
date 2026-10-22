package com.bytedance.applog.priority;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final List<String> a = null;
    public static final List<String> b = null;

    static {
        a = CollectionsKt.listOf(new String[]{"backoff_priority", "group_priority", "event_priority_config"});
        b = CollectionsKt.listOf(new String[]{"backoff_priority_list", "event_priority_config", "group_priority_list"});
    }
}
