package com.bytedance.forest.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final Map<String, String> a(Uri r100) {
        String[] r101 = {ByteNetEnvHeaderName.PPE, ByteNetEnvHeaderName.BOE, "x-tt-env"};
        ArrayList r102 = new ArrayList(3);
        int r103 = 0;
    L3:
        if (r103 >= 3) goto L5;
        String r104 = r101[r103];
        r102.add(TuplesKt.to(r104, b(r100, r104)));
        r103 = r103 + 1;
        goto L3
    L5:
        Map r105 = MapsKt.toMap(r102);
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = r105.entrySet().iterator();
    L7:
        if (r107.hasNext() == false) goto L11;
        Map.Entry r108 = (Map.Entry) r107.next();
        if ((!TextUtils.isEmpty((CharSequence) r108.getValue())) == false) goto L7;
        r106.put(r108.getKey(), r108.getValue());
        goto L7
    L11:
        return r106;
    }

    public static final String c(String r100) {
        Integer r101 = Integer.valueOf(StringsKt.indexOf$default(r100, "?", 0, false, 6, null));
        if (r101.intValue() == (-1)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L14;
        String r103 = r100.substring(0, r101.intValue());
        if (r103 != null) goto L13;
        return r100;
    L13:
        return r103;
    L14:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public static final String b(Uri r100, String r101) {
        return UriProtector.getQueryParameter(r100, r101);
    L4:
        return null;
    }
}
