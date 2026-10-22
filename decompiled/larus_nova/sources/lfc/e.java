package lfc;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements kfc.a {
    public e() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }

    public static void c(ContentResolver r110, Uri r111, ContentValues r210) throws RedBadgerException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
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
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L20;
        Uri r108 = (Uri) r107.f474983b;
        return;
    L20:
        r110.insert(r111, r210);
        return;
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
        if (r100 == null) goto L13;
        if (r101 == null) goto L16;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        ContentValues r103 = new ContentValues();
        r103.put("package_name", r101.getPackageName());
        r103.put("activity_name", r101.getClassName());
        r103.put("count", Integer.valueOf(r102));
        c(r100.getContentResolver(), UriProtector.parse("content://me.everything.badger/apps"), r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        return;
    }
}
