package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class s {
    public static final boolean a(ThreadTopic r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 != null) goto L5;
    L25:
        return false;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        String r104 = null;
        if (r103 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L25;
        String r105 = r100.getRootMsgId();
        if (r105 != null) goto L17;
    L21:
        if (r104 == null) goto L24;
        return Intrinsics.areEqual(r104, r101);
    L24:
        return Intrinsics.areEqual(r100.getId(), r101);
    L17:
        if (r105.length() <= 0) goto L19;
        r102 = true;
    L19:
        if (r102 == false) goto L21;
        r104 = r105;
        goto L21
    L7:
        r103 = false;
        goto L8
    }
}
