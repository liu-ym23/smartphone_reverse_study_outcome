package com.bytedance.ee.bear.doc.follow.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Pair<py4.c, r>> f217957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f217958b;

    static {
        f217957a = new HashMap();
    }

    public static String a(Bundle r100) {
        if (r100 != null) goto L6;
        tt5.a.d("CCMFollow_FragHelper", "extractFollowApiHostId no args");
        return "";
    L6:
        String r101 = r100.getString("argFollowApiHostId");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        tt5.a.d("CCMFollow_FragHelper", "extractFollowApiHostId no host id");
        return "";
    L10:
        return r101;
    }

    public static String b(Fragment r100) {
        if (r100 != null) goto L6;
        tt5.a.k("CCMFollow_FragHelper", "extractFollowApiHostId no fragment");
        return "";
    L6:
        return a(r100.getArguments());
    }
}
