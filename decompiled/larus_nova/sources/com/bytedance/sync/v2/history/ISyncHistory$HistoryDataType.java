package com.bytedance.sync.v2.history;

import com.bytedance.sync.v2.protocal.TopicType;

/* JADX INFO: loaded from: classes22.dex */
public @interface ISyncHistory$HistoryDataType {
    public static final int CUSTOM = 0;
    public static final int GLOBAL = 0;
    public static final int SPEC = 0;

    static {
        SPEC = TopicType.SpecTopic.getValue();
        GLOBAL = TopicType.GlobalTopic.getValue();
        CUSTOM = TopicType.CustomTopic.getValue();
    }
}
