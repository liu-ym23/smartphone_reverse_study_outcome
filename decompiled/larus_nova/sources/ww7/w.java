package ww7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f561721a;

    public w(Context r100) {
        if (r100 == null) goto L13;
        if (Build.VERSION.SDK_INT < 24) goto L10;
        Context r101 = r100.createDeviceProtectedStorageContext();
        SharedPreferences r102 = r101.getSharedPreferences("move_to_de_records", 0);
        if ((r101.moveSharedPreferencesFrom(r100, "push") & (!r102.getBoolean("push", false))) == false) goto L9;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putBoolean("push", true);
        r103.apply();
    L9:
        this.f561721a = r101.getSharedPreferences("push", 0);
        return;
    L10:
        this.f561721a = r100.getSharedPreferences("push", 0);
        return;
    L13:
        throw new NullPointerException("context is null!");
    }

    public final void a(String r100) {
        SharedPreferences r101 = this.f561721a;
        if (r101 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = r101.edit();
        if (r102 != null) goto L8;
        return;
    L8:
        r102.remove(r100).commit();
    }

    public final boolean b(String r100, String r101) {
        SharedPreferences r102 = this.f561721a;
        if (r102 != null) goto L5;
        return false;
    L5:
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 != null) goto L9;
        return false;
    L9:
        return r103.putString(r100, r101).commit();
    }
}
