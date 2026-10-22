package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.Channel;

/* JADX INFO: loaded from: classes37.dex */
public final class g {
    public static Channel a(com.bytedance.lark.pb.basic.v1.Channel r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Channel(r100.type.getValue(), r100.f253443id);
    }

    public static com.bytedance.lark.pb.basic.v1.Channel b(Channel r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new com.bytedance.lark.pb.basic.v1.Channel.Builder().id(r100.getId()).type(com.bytedance.lark.pb.basic.v1.Channel.Type.fromValue(r100.getType().getNumber())).build();
    }
}
