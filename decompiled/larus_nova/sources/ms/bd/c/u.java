package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class u implements FileFilter {
    public u() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return Pattern.matches((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ab1ba8", new byte[]{115, 112, 87, 45, 14, 98, 59, 126}), r100.getName());
    }
}
