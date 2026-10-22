package ms.bd.c;

import android.os.Build;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class t {
    public static HashMap a() {
        HashMap r100 = new HashMap();
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b294e9", new byte[]{34}), Build.MODEL);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f282d0", new byte[]{37}), Build.BRAND);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "06438f", new byte[]{114}), Build.BOARD);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "fa4473", new byte[]{35}), Build.VERSION.RELEASE);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8afa6b", new byte[]{124}), Build.DISPLAY);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "73c2bc", new byte[]{112}), Build.HARDWARE);
        r100.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "69e59a", new byte[]{112}), Build.FINGERPRINT);
        return r100;
    }
}
