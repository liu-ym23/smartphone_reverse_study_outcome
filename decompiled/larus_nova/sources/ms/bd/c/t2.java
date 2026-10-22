package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public final class t2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t2 f515368b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f515369a;

    static {
        f515368b = new t2();
    }

    public t2() {
        this.f515369a = new ArrayList();
    }

    public final String a(int r110, String r111, String r112) {
        ArrayList r100 = this.f515369a;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L6:
        if (this.f515369a.size() >= 1) goto L8;
    L21:
        String r113 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3124f0", new byte[]{114});     // Catch: Throwable -> L30
        monitor-exit(r100);     // Catch: Throwable -> L27
        return r113;
    L8:
        if (TextUtils.isEmpty(r111) == true) goto L21;
        Iterator r101 = this.f515369a.iterator();     // Catch: Throwable -> L30
    L12:
        if (r101.hasNext() == false) goto L24;
        Map r102 = (Map) r101.next();     // Catch: Throwable -> L30
        if (r102 == null) goto L12;
        if (r102.isEmpty() == true) goto L12;
        if (r102.containsKey(r111) == false) goto L12;
        ((MSManagerUtils.IMsBundleCallback) r102.get(r111)).callBack(r110, r111, r112);     // Catch: Throwable -> L30
        r101.remove();     // Catch: Throwable -> L30
    L24:
        String r114 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4e8a69", new byte[]{117});     // Catch: Throwable -> L27
        monitor-exit(r100);     // Catch: Throwable -> L27
        return r114;
    }
}
