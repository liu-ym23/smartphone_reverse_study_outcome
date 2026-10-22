package com.ss.videoarch.liveplayer;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public final class n {
    public n() {
    }

    public static String replaceOrAppendQueryParam(String r100, String r101, String r102) {
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon();
        Set<String> r105 = UriProtector.getQueryParameterNames(r103);
        if (r105.contains(r101) == false) goto L12;
        r104.clearQuery();
        Iterator<String> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L14;
        String r107 = r106.next();
        if (TextUtils.equals(r107, r101) == false) goto L10;
        String r108 = r102;
    L11:
        r104.appendQueryParameter(r107, r108);
        goto L6
    L10:
        r108 = UriProtector.getQueryParameter(r103, r107);
    L14:
        return r104.build().toString();
    L12:
        r104.appendQueryParameter(r101, r102);
        goto L14
    }
}
