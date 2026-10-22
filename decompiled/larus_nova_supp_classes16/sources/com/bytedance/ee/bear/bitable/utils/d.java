package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final String a(DocViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        WikiInfo r0 = r3.getWikiInfo();
        if (r0 != null) goto L5;
    L10:
        String r4 = r3.getToken();
        Intrinsics.checkNotNull(r4);
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return "";
    L14:
        return r4;
    L5:
        if (TextUtils.equals(r0.getObjToken(), r3.getToken()) == true) goto L10;
        if (TextUtils.isEmpty(r0.getObjToken()) == true) goto L10;
        return r0.getObjToken();
    }
}
