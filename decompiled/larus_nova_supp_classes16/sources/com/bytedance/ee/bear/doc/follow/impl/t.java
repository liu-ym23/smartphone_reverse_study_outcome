package com.bytedance.ee.bear.doc.follow.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t {
    public static final Map<String, Pair<py4.c, r>> a = null;
    public static long b;

    static {
        a = new HashMap();
    }

    public static String a(Bundle r3) {
        if (r3 != null) goto L6;
        tt5.a.d("CCMFollow_FragHelper", "extractFollowApiHostId no args");
        return "";
    L6:
        String r4 = r3.getString("argFollowApiHostId");
        if (TextUtils.isEmpty(r4) == false) goto L10;
        tt5.a.d("CCMFollow_FragHelper", "extractFollowApiHostId no host id");
        return "";
    L10:
        return r4;
    }

    public static String b(Fragment r1) {
        if (r1 != null) goto L6;
        tt5.a.k("CCMFollow_FragHelper", "extractFollowApiHostId no fragment");
        return "";
    L6:
        return a(r1.getArguments());
    }
}
