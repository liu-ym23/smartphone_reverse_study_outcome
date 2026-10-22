package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public class bs extends bv.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f463209a;

    public bs(String r100, ContentValues r101, String r102) {
        super(r100, r101);
        this.f463209a = r102;
    }

    public static bs a(Context r100, String r101, gi r102) {
        byte[] r103 = ho.a(r102);
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r103.length <= 0) goto L11;
        ContentValues r104 = new ContentValues();
        r104.put("status", 0);
        r104.put("messageId", "");
        r104.put("messageItemId", r102.d());
        r104.put("messageItem", r103);
        r104.put("appId", bm.a(r100).b());
        r104.put("packageName", bm.a(r100).m8859a());
        r104.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        r104.put("uploadTimestamp", 0);
        return new bs(r101, r104, "a job build to insert message to db");
    L11:
        return null;
    }
}
