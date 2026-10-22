package ms.bd.c;

import android.content.Context;
import android.location.LocationManager;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes6.dex */
public abstract class w1 {
    public static x1 a(Context r110, String r111) {
        LocationManager r112 = (LocationManager) r110.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5184cb", new byte[]{40, 60, 72, 65, 72, 124, 57, 30}));     // Catch: Throwable -> L36
        if (r112 != null) goto L7;
        return new x1(-10, "", "", null);
    L7:
        Field[] r100 = r112.getClass().getDeclaredFields();
        if (r100 == null) goto L10;
        int r101 = r100.length;
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L30;
        Field r103 = r100[r102];
        r103.setAccessible(true);
        Object r104 = r103.get(r112);     // Catch: IllegalAccessException -> L28
        if (r104 == null) goto L27;
        if ((r104 instanceof String) == true) goto L27;
        Class<?>[] r105 = r104.getClass().getInterfaces();
        if (r105 == null) goto L27;
        if (r105.length == 0) goto L27;
        if (r111.equals(r105[0].getName()) == false) goto L27;
    L31:
        if (r104 != null) goto L35;
        return new x1(-22, "", "", null);
    L35:
        return new x1(r104 instanceof Proxy ? 1 : 0, r103.getName(), r104.getClass().getName(), null);
    L27:
        r102 = r102 + 1;
    L29:
        return new x1(-21, "", "", null);
    L30:
        r103 = null;
        r104 = null;
        goto L31
    L10:
        return new x1(-20, "", "", null);
    L37:
        return new x1(-11, "", "", null);
    }
}
