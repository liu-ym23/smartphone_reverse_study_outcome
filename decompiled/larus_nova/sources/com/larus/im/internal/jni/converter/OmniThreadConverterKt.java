package com.larus.im.internal.jni.converter;

import com.larus.im.bean.thread.ThreadData;
import com.larus.im.internal.jni.bean.OmniThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toThreadData", "Lcom/larus/im/bean/thread/ThreadData;", "Lcom/larus/im/internal/jni/bean/OmniThread;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniThreadConverterKt {
    public static final ThreadData toThreadData(OmniThread r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.threadId;
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r110.sourceConversationId;
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        String r104 = r110.threadName;
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        String r106 = r101;
        String r107 = r103;
        String r108 = r105;
        return new ThreadData(r106, r107, r108, r110.earliestMsgIndex, r110.latestMsgIndex);
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
