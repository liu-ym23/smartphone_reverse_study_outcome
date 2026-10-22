package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static final String a(DocViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WikiInfo r101 = r100.getWikiInfo();
        if (r101 != null) goto L5;
    L10:
        String r102 = r100.getToken();
        Intrinsics.checkNotNull(r102);
        if (TextUtils.isEmpty(r102) == false) goto L14;
        return "";
    L14:
        return r102;
    L5:
        if (TextUtils.equals(r101.getObjToken(), r100.getToken()) == true) goto L10;
        if (TextUtils.isEmpty(r101.getObjToken()) == true) goto L10;
        return r101.getObjToken();
    }
}
