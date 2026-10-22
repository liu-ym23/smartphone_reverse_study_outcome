package ms.bd.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a0 {
    public static String b() {
        TimeZone r100 = TimeZone.getDefault();     // Catch: Throwable -> L6
        String r101 = r100.getID();     // Catch: Throwable -> L6
        int r102 = ((r100.getRawOffset() / 60) / 60) / 1000;     // Catch: Throwable -> L10
    L9:
        return r101 + ((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "703361", new byte[]{106})) + r102;
    L7:
        r102 = 0;
    L6:
        r101 = null;
        goto L7
    }

    public static int a(Context r100) {
        PowerManager r101 = (PowerManager) r100.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "226a9b", new byte[]{51, 63, 82, 16, 20}));
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.isInteractive() == true) goto L9;
        return 1;
    L9:
        KeyguardManager r102 = (KeyguardManager) r100.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a5a2be", new byte[]{123, 50, 11, 65, 72, 115, 112, 16}));
        if (r102 != null) goto L13;
        return 0;
    L13:
        if (r102.inKeyguardRestrictedInputMode() == false) goto L16;
        return 2;
    L16:
        return 3;
    }
}
