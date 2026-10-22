package kta;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f506105a = null;

    public static class a extends pta.e<Boolean> {
        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            if (((Context) r100[0]).getPackageManager().getPackageInfo("com.huawei.hwid", 128) == null) goto L7;
            r101 = true;
        L7:
            return Boolean.valueOf(r101);
        }
    }

    static {
        f506105a = new a();
    }

    public g() {
    }

    @Override // kta.o
    public final boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return f506105a.b(new Object[]{r100}).booleanValue();
    }

    @Override // kta.o
    public final o.a getOaid(Context r100) {
        o.a r101 = new o.a();
        if (Build.VERSION.SDK_INT >= 24) goto L23;
    L10:
        Pair r102 = (Pair) new w(r100, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new h()).a();
        if (r102 == null) goto L20;
        r101.f506112a = (String) r102.first;
        r101.f506113b = ((Boolean) r102.second).booleanValue();
        int r103 = 0;
        PackageInfo r104 = r100.getPackageManager().getPackageInfo("com.huawei.hwid", 0);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r104 == null) goto L19;
        r103 = r104.versionCode;     // Catch: PackageManager.NameNotFoundException -> L17
    L19:
        r101.f506114c = r103;
    L17:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r101;
    L23:
        String r105 = Settings.Global.getString(r100.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r106 = Settings.Global.getString(r100.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r105) == true) goto L10;
        r101.f506112a = r105;     // Catch: Throwable -> L8
        r101.f506113b = Boolean.parseBoolean(r106);     // Catch: Throwable -> L8
        r101.f506114c = 202003021704L;     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }
}
