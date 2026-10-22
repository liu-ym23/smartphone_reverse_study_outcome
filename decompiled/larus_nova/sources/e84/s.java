package e84;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements m {

    public static class a extends m.a {
        public a() {
        }
    }

    public s() {
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        return true;
    }

    @Override // e84.m
    public final String getName() {
        return "Pico";
    }

    @Override // e84.m
    public final m.a getOaid(Context r100) {
        a r101 = new a();
        ContentProviderClient r102 = null;
        ContentProviderClient r103 = b(r100.getContentResolver(), Uri.parse("content://com.pico.idprovider"));     // Catch: Throwable -> L9 RemoteException -> L11
        Bundle r104 = r103.call("request_oaid", null, null);     // Catch: RemoteException -> L7 Throwable -> L20
        if (r103 == null) goto L17;
        r103.close();
    L17:
        if (r104 == null) goto L19;
        r101.f471323a = r104.getString("oaid", null);
        r101.f471324b = r104.getBoolean("forbidden", false);
    L19:
        return r101;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L20
        if (r103 == null) goto L16;
        r103.close();
    L16:
        r104 = null;
    L20:
        th = th;
        r102 = r103;
    L22:
        if (r102 == null) goto L24;
        r102.close();
    L24:
        throw th;
    L11:
        e = e;
        r103 = null;
    L9:
        th = th;
        goto L22
    }

    public static ContentProviderClient b(ContentResolver r110, Uri r111) {
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
}
