package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes6.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k1 f515170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f515171c;

    public j1(Context r100) {
        this.f515171c = new i1(this);
        this.f515169a = r100;
    }

    public final void a(y2 r110) {
        Intent r100 = new Intent();
        r100.setClassName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "24610a", new byte[]{32, 57, 72, 11, 21, 99, 56, 91, 99, 100, 53, 63, 70, 64, 6, 114, 34, 16, 117, 119, 42, 53, 64}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "da27f1", new byte[]{118, 108, 76, HTTP.CR, 67, 51, 110, 14, 103, 98, 99, 106, 66, 70, 80, 34, 116, 69, 113, 113, 124, 96, 68, HTTP.CR, 125, 35, 113, 73, 96, 98, 124, 103, 114, 70, 75, 48, 110, 67, 102}));
        if (this.f515169a.bindService(r100, this.f515171c, 1) == false) goto L12;
        k1 r101 = this.f515170b;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r110.f515441a.f515447a = r101.a();     // Catch: Throwable -> L9
    L7:
        this.f515169a.unbindService(this.f515171c);
        return;
    }
}
