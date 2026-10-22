package com.cmic.ida.sdk;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes22.dex */
public class x extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273266a;

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Uri r100 = UriProtector.parse("content://cn.nubia.identity/identity");
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L15
        ContentProviderClient r102 = com_cmic_ida_sdk_x_android_content_ContentResolver_acquireContentProviderClient(this.f273266a.getContentResolver(), r100);     // Catch: Exception -> L15
        Bundle r103 = null;
        if (r102 == null) goto L9;
        r103 = r102.call("getOAID", null, null);     // Catch: Exception -> L15
        if (r101 < 24) goto L8;
        r102.close();     // Catch: Exception -> L15
        goto L9
    L8:
        r102.release();     // Catch: Exception -> L15
    L9:
        int r104 = -1;
        if (r103 == null) goto L12;
        r104 = r103.getInt("code", -1);     // Catch: Exception -> L15
    L12:
        if (r104 != 0) goto L18;
        return r103.getString("id");
    L18:
        return "";
    L19:
        return "";
    }

    public x(Context r100) {
        this.f273266a = r100;
    }

    private static ContentProviderClient com_cmic_ida_sdk_x_android_content_ContentResolver_acquireContentProviderClient(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, null, r112, false);
        return (ContentProviderClient) r113.f474983b;
    L6:
        ContentProviderClient r114 = r110.acquireContentProviderClient(r111);
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, r114, r112, true);
        return r114;
    }
}
