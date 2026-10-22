package com.bytedance.awemeopen.apps.photo.utils;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static TextExtraStruct a(r14.c r5) {
        if (r5 == null) goto L5;
        String r1 = r5.p();
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return null;
    L9:
        if (r5 == null) goto L45;
        List r2 = r5.N();
        if (r2 != null) goto L14;
        return null;
    L14:
        if (r2.isEmpty() == false) goto L16;
        return null;
    L16:
        Iterator r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L25;
        Object r4 = r3.next();
        if (7 != ((TextExtraStruct) r4).getType()) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L18;
    L26:
        TextExtraStruct r7 = (TextExtraStruct) r4;
        if (r7 != null) goto L29;
        return null;
    L29:
        if (r7.getStart() >= r7.getEnd()) goto L47;
        int r8 = r7.getEnd();
        String r9 = r5.p();
        if (r9 != null) goto L34;
        r9 = "";
    L34:
        if (r8 <= r9.length()) goto L36;
        return null;
    L36:
        if (r7.getStart() >= 0) goto L39;
        return null;
    L39:
        return r7;
    L47:
        return null;
    L22:
        r6 = false;
        goto L23
    L25:
        r4 = null;
        goto L26
    L45:
        return null;
    L5:
        r1 = null;
        goto L7
    }
}
