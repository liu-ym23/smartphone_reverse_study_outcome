package lfc;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class q extends kfc.b {
    @Override // kfc.b
    public final int d(Context r100, ComponentName r101) {
        return -1;
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.vivo.launcher", "com.bbk.launcher2"});
    }

    public q() {
    }

    @Override // kfc.b
    public final boolean e(int r100) {
        if (r100 <= 1) goto L6;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "vv brand only support add 1,but count > 1");
        return false;
    L6:
        return true;
    }

    public static ContentProviderClient g(ContentResolver r110, Uri r111) {
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
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
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
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L15;
        if (r101 == null) goto L18;
        if (r102 >= 0) goto L16;
        r102 = 0;
    L16:
        Intent r103 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");     // Catch: Throwable -> L12
        r103.putExtra("packageName", r100.getPackageName());     // Catch: Throwable -> L12
        r103.putExtra(PushClientConstants.TAG_CLASS_NAME, r101.getClassName());     // Catch: Throwable -> L12
        r103.putExtra("notificationNum", r102);     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r103.addFlags(16777216);     // Catch: Throwable -> L12
    L10:
        r100.sendBroadcast(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L18:
        return;
    }

    @Override // kfc.b
    public final boolean c(Context r100, ComponentName r101, int r102) {
        boolean r103 = false;
        if (r100 == null) goto L42;
        if (r101 == null) goto L42;
        if (r102 > 0) goto L10;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "count must bigger than 0");
        return false;
    L10:
        if (r102 == 1) goto L12;
        com.bytedance.push.utils.f.i("VivoHomeBadger", "vv only support add 1");
    L12:
        Uri r104 = UriProtector.parse("content://com.vivo.abe.provider.launcher.notification.num");
        Bundle r105 = new Bundle();
        r105.putString("package", r100.getPackageName());
        r105.putString("class", r101.getClassName());
        int r106 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L34
        ContentProviderClient r107 = g(r100.getContentResolver(), r104);     // Catch: Throwable -> L34
        if (r107 != null) goto L47;
    L28:
        if (r107 != null) goto L30;
    L33:
        return false;
    L30:
        if (Build.VERSION.SDK_INT < 24) goto L32;
        r107.close();
        goto L33
    L32:
        r107.release();
        goto L33
    L47:
        Bundle r108 = r107.call("add_badge", null, r105);     // Catch: Throwable -> L24 RemoteException -> L26
        if (r108 == null) goto L20;
        if (r108.getInt("result") != 0) goto L20;
        r103 = true;
        goto L20
    L20:
        if (r106 < 24) goto L22;
        r107.close();
    L23:
        return r103;
    L22:
        r107.release();
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L24:
        Throwable th10 = th;
    L36:
        if (r107 != null) goto L38;
    L41:
        throw th10;
    L38:
        if (Build.VERSION.SDK_INT < 24) goto L40;
        r107.close();
        goto L41
    L40:
        r107.release();
    L34:
        th = move-exception;
        th10 = th;
        r107 = null;
    L42:
        com.bytedance.push.utils.f.b("VivoHomeBadger", "args is null");
        return false;
    }

    @Override // kfc.b
    public final boolean f(Context r100, ComponentName r101, int r102) {
        boolean r103 = false;
        if (r100 == null) goto L39;
        if (r101 == null) goto L39;
        if (r102 > 0) goto L9;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "count must bigger than 0");
        return false;
    L9:
        Uri r104 = UriProtector.parse("content://com.vivo.abe.provider.launcher.notification.num");
        Bundle r105 = new Bundle();
        r105.putString("package", r100.getPackageName());
        r105.putString("class", r101.getClassName());
        r105.putInt("badgenumber", r102);
        int r106 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        ContentProviderClient r107 = g(r100.getContentResolver(), r104);     // Catch: Throwable -> L31
        if (r107 != null) goto L42;
    L25:
        if (r107 != null) goto L27;
    L30:
        return false;
    L27:
        if (Build.VERSION.SDK_INT < 24) goto L29;
        r107.close();
        goto L30
    L29:
        r107.release();
        goto L30
    L42:
        Bundle r108 = r107.call("reduce_badge", null, r105);     // Catch: Throwable -> L21 RemoteException -> L23
        if (r108 == null) goto L17;
        if (r108.getInt("result") != 0) goto L17;
        r103 = true;
        goto L17
    L17:
        if (r106 < 24) goto L19;
        r107.close();
    L20:
        return r103;
    L19:
        r107.release();
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        Throwable th10 = th;
    L33:
        if (r107 != null) goto L35;
    L38:
        throw th10;
    L35:
        if (Build.VERSION.SDK_INT < 24) goto L37;
        r107.close();
        goto L38
    L37:
        r107.release();
    L31:
        th = move-exception;
        th10 = th;
        r107 = null;
    L39:
        com.bytedance.push.utils.f.b("VivoHomeBadger", "args is null");
        return false;
    }
}
