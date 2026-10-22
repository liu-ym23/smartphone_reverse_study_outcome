package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437628a = 0;

    static {
    }

    public static AutoMuteConfig a(com.bytedance.lark.pb.basic.v1.AutoMuteConfig r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new AutoMuteConfig(r100.is_mute.booleanValue(), r100.position.longValue(), r100.badge_count.longValue(), r100.mute_way);
    }
}
