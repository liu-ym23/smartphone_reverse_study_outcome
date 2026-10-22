package ms.bd.c;

import android.content.Context;
import android.os.Process;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d3 {
    public static boolean a() {
        return b(new String[]{(String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5c1e9e", new byte[]{37, 111, 70, 3, 9, 123, 50, 12, 112, 48, 54, 108, 75, 2, 21, 123, 57, 76, 46, 20, 7, 66, 103, 34, 53, 77, 1, 107, 70, 28, 27, 82, 118, 48, 50, 87})});
    }

    public static boolean b(String... r100) {
        Context r101 = d2.f515131b.f515132a;     // Catch: Throwable -> L11
        int r102 = r100.length;     // Catch: Throwable -> L11
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        if (c(r101, r100[r103], Process.myPid(), Process.myUid()) != 0) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    L11:
        return false;
    }

    public static int c(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_ms_bd_c_d3_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
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
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
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
