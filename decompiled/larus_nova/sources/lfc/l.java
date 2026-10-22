package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements kfc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509106a;

    public l() {
        this.f509106a = Integer.MIN_VALUE;
    }

    @Override // kfc.a
    public final List<String> b() {
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.opporom")) == false) goto L6;
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.oplusrom")) == true) goto L7;
    L6:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L13;
        return Arrays.asList(new String[]{"com.oppo.launcher", "com.android.launcher"});
    L13:
        return Collections.singletonList("com.oppo.launcher");
    L7:
        r100 = false;
        goto L9
    }

    @Override // kfc.a
    public final void a(Context r110, ComponentName r111, int r112) throws RedBadgerException {
        if (r110 == null) goto L29;
        if (r111 != null) goto L7;
        return;
    L7:
        if (this.f509106a <= 99) goto L10;
        if (r112 <= 99) goto L10;
        return;
    L10:
        this.f509106a = r112;
        Intent r100 = new Intent("com.oppo.unsettledevent");
        r100.putExtra("pakeageName", r111.getPackageName());
        r100.putExtra("number", r112);
        r100.putExtra("upgradeNumber", r112);
        if (nfc.a.a(r110, r100) == true) goto L32;
        Bundle r113 = new Bundle();     // Catch: Throwable -> L27
        r113.putInt("app_badge_count", r112);     // Catch: Throwable -> L27
        r110.getContentResolver().call(UriProtector.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, r113);     // Catch: Throwable -> L27
        if (r112 <= 0) goto L24;
        return;
    L24:
        if (Build.VERSION.SDK_INT >= 23) goto L37;
        Bundle r114 = (Bundle) r113.clone();     // Catch: Throwable -> L27
        r114.putInt("app_badge_count", -1);     // Catch: Throwable -> L27
        r110.getContentResolver().call(UriProtector.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, r114);     // Catch: Throwable -> L27
        return;
    L37:
        return;
    L28:
        throw new RedBadgerException("unable to resolve intent: " + r100.toString());
    L32:
        r110.sendBroadcast(r100);     // Catch: Throwable -> L18
        if (r112 <= 0) goto L15;
        return;
    L15:
        if (Build.VERSION.SDK_INT >= 23) goto L35;
        Intent r115 = (Intent) r100.clone();     // Catch: Throwable -> L18
        r115.putExtra("number", -1);     // Catch: Throwable -> L18
        r115.putExtra("upgradeNumber", -1);     // Catch: Throwable -> L18
        r110.sendBroadcast(r115);     // Catch: Throwable -> L18
        return;
    L35:
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    }
}
