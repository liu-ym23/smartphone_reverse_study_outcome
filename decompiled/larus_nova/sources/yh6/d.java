package yh6;

import com.bytedance.android.live.base.model.message.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final Long a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$messageId");
        m0 r101 = r100.getCommonData();
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "$this$messageIdKt");
        return Long.valueOf(r101.getMessageId());
    L5:
        return null;
    }
}
