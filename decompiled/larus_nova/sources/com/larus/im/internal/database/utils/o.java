package com.larus.im.internal.database.utils;

import com.larus.im.internal.database.entity.MessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static final boolean a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Intrinsics.areEqual(r100.getSenderId(), com.larus.im.internal.delegate.b.f348193b.getUserId());
    }
}
