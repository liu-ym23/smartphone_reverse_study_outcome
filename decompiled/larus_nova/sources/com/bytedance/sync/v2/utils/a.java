package com.bytedance.sync.v2.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.bytedance.sync.v2.protocal.BsyncTopic;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270548a = 0;

    static {
    }

    public static Integer a(BsyncProtocol r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        return Integer.valueOf(((BsyncTopic) ListProtector.get(r100.topics, 0)).flag.getValue());
    L7:
        return 0;
    }
}
