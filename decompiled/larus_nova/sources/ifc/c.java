package ifc;

import android.content.Intent;
import com.bytedance.push.utils.f;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashSet;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static boolean a(Intent r100) {
        HashSet r101 = new HashSet();
        r101.add("android.intent.action.CHOOSER");
        r101.add("android.intent.action.SEND");
        r101.add("android.intent.action.SEND_MULTIPLE");
        r101.add("android.media.action.IMAGE_CAPTURE");
        r101.add("android.media.action.IMAGE_CAPTURE_SECURE");
        r101.add("android.media.action.VIDEO_CAPTURE");
        if (r101.contains(r100.getAction()) == false) goto L7;
        f.i("IntentSecurityUtils", "[isSafeIntent]return false because intent action is " + r100.getAction());
        return false;
    L7:
        if ((r100.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) goto L10;
        f.i("IntentSecurityUtils", "[isSafeIntent]return false because intent flag is " + r100.getFlags());
        return false;
    L10:
        f.g("IntentSecurityUtils", "[isSafeIntent]return true");
        return true;
    }
}
