package com.bytedance.sync.v2.presistence;

import com.bytedance.sync.v2.protocal.TopicType;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f270492a = null;

    static {
        int[] r100 = new int[TopicType.values().length];
        f270492a = r100;
        r100[TopicType.SpecTopic.ordinal()] = 1;
        r100[TopicType.CustomTopic.ordinal()] = 2;
        r100[TopicType.GlobalTopic.ordinal()] = 3;
    }
}
