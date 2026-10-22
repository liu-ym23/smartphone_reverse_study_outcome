package e84;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements m {
    public j() {
    }

    @Override // e84.m
    public final String getName() {
        return "Nubia";
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // e84.m
    public final m.a getOaid(Context r100) {
        Uri r101 = UriProtector.parse("content://cn.nubia.identity/identity");
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L20
        ContentProviderClient r103 = b(r100.getContentResolver(), r101);     // Catch: Exception -> L20
        if (r103 != null) goto L6;
        return null;
    L6:
        Bundle r104 = r103.call("getOAID", null, null);     // Catch: Exception -> L20
        if (r102 < 24) goto L9;
        r103.close();     // Catch: Exception -> L20
    L10:
        if (r104 != null) goto L13;
        return null;
    L13:
        if (r104.getInt("code", -1) != 0) goto L16;
        m.a r105 = new m.a();     // Catch: Exception -> L20
        r105.f471323a = r104.getString("id");     // Catch: Exception -> L20
        return r105;
    L16:
        String r106 = r104.getString("message");     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r106) == true) goto L19;
        com.bytedance.bdinstall.t.b(r106);     // Catch: Exception -> L20
    L19:
        return null;
    L9:
        r103.release();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ContentProviderClient b(ContentResolver r110, Uri r111) {
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
