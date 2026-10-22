package com.obric.update.impl;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.alipay.sdk.m.p.e;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import f06.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static ContentProviderClient a(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static final Bundle b(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        ContentProviderClient r102 = null;
        ContentProviderClient r103 = a(AppHost.f326268a.getApplication().getContentResolver(), Uri.parse("content://com.bytedanceos.appstore.auto_update"));     // Catch: Throwable -> L11 Exception -> L13
        if (r103 != null) goto L24;
        return null;
    L24:
        r100.putInt("client_ver", 1);     // Catch: Exception -> L9 Throwable -> L19
        Bundle r104 = r103.call(r101, null, r100);     // Catch: Exception -> L9 Throwable -> L19
        r103.close();
        return r104;
    L9:
        e = e;
    L15:
        FLogger.f375446a.e("ObricUpdateUtils", "contentProviderCall, error", e);     // Catch: Throwable -> L19
        if (r103 == null) goto L18;
        r103.close();
    L18:
        return null;
    L19:
        th = th;
        r102 = r103;
    L21:
        if (r102 == null) goto L23;
        r102.close();
    L23:
        throw th;
    L13:
        e = e;
        r103 = null;
    L11:
        th = th;
        goto L21
    }
}
