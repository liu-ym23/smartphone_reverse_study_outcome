package com.bytedance.awemeopen.apps.photo.utils;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198040a = 0;

    static {
    }

    public static TextExtraStruct a(r14.c r100) {
        if (r100 == null) goto L5;
        String r101 = r100.p();
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return null;
    L9:
        if (r100 == null) goto L45;
        List<TextExtraStruct> r102 = r100.N();
        if (r102 != null) goto L14;
        return null;
    L14:
        if (r102.isEmpty() == false) goto L16;
        return null;
    L16:
        Iterator<T> r103 = r102.iterator();
    L18:
        if (r103.hasNext() == false) goto L25;
        Object r104 = r103.next();
        if (7 != ((TextExtraStruct) r104).getType()) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == false) goto L18;
    L26:
        TextExtraStruct r106 = (TextExtraStruct) r104;
        if (r106 != null) goto L29;
        return null;
    L29:
        if (r106.getStart() >= r106.getEnd()) goto L47;
        int r107 = r106.getEnd();
        String r108 = r100.p();
        if (r108 != null) goto L34;
        r108 = "";
    L34:
        if (r107 <= r108.length()) goto L36;
        return null;
    L36:
        if (r106.getStart() >= 0) goto L39;
        return null;
    L39:
        return r106;
    L47:
        return null;
    L22:
        r105 = false;
        goto L23
    L25:
        r104 = null;
        goto L26
    L45:
        return null;
    L5:
        r101 = null;
        goto L7
    }
}
