package com.larus.bmhome.utils;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;

/* JADX INFO: loaded from: classes4.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315107a = 0;

    static {
    }

    public static String a() {
        Object r100 = xp9.o.f564776a;
        if ((r100 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r101 = (OfficeSDKUserApi) r100;
    L6:
        if (r101 == null) goto L9;
        String r102 = r101.getUserId();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return "";
    L5:
        r101 = null;
        goto L6
    }
}
