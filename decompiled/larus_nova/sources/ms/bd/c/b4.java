package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515115a = 0;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3f539c", new byte[]{25, 56, 7, 25, 59});
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        return r100.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
