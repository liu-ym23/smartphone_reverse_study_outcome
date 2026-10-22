package ms.bd.c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes42.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f515280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1 f515281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f515283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n1 f515284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f515285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PthreadHandlerThreadV2 f515286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CountDownLatch f515287h;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "3edd7c", new byte[]{6, 104, 2, 41, 1, 122, 28, 77, 35, 49});
    }

    public p1(Context r110, String r111) {
        r1 r100 = new r1(r110);
        this.f515283d = false;
        if (TextUtils.isEmpty(r111) == false) goto L5;
        String r112 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f0ed85", new byte[]{83, Base64.padSymbol, 3, 41, 14, 44, 73, 24, 34, 49});
        String r113 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "0ec453", new byte[]{8, 105, 25, 84, 74, 34, 50, 77, 62, 97, 37, 43, 80, 65, 26, 52, 26, 96, 114, 109, 50, 39, 2, 69, 27, 49, 58, 86, 55, 96, 111});
        return;
    L5:
        v1 r114 = new v1();
        this.f515281b = r114;
        if (r114.f515401e == false) goto L9;
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1bd4f5", new byte[]{4, 111, 2, 121, 80, 44, 30, 74, 35, 97});
        String r102 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7f2840", new byte[]{15, 106, 87, 77, 7, 46, 48, 7, 112, 109, 50, 112, 72, 66, 12, 52, 122});
    L9:
        if (r114.f515402f == false) goto L13;
        this.f515282c = r111;
        this.f515280a = r100;
        this.f515287h = new CountDownLatch(1);
        this.f515283d = true;
        return;
    }
}
