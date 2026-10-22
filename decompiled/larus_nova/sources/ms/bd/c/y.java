package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f515434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f515436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f515437d;

    public y(Context r100) {
        this.f515435b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "80ea82", new byte[]{42, Base64.padSymbol, 27, 91, 10, 33, 50, 21, 122, 60, 58, 51});
        this.f515436c = new LinkedBlockingQueue(1);
        this.f515437d = new x(this);
        this.f515434a = r100;
    }

    public final void a(y2 r110) {
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r100 = false;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        String r101 = this.f515434a.getPackageName();
        Intent r102 = new Intent();
        r102.setClassName(this.f515435b, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a4d262", new byte[]{115, 57, 26, 8, 4, 33, 107, 17, 123, 111, 99, 55, 89, 85, 12, 55, 116, 28, 54, 103, 62, 27, 4, 71, 34, 41, 81, 16, 39, 116, 121, 53, 18}));
        r102.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "408291", new byte[]{38, Base64.padSymbol, 70, 8, 4, 51, 57, 95, 100, 113, 36, 124, 74, 69, 18, 47, 56, 31, 39, 113, 49, 51, 89, 82, 72, 53, 50, 3, ByteCompanionObject.MAX_VALUE, 107, 38, 55}));
        r102.putExtra((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "657e2e", new byte[]{36, 56, 73, 95, 15, 103, 59, 90, 107, 38, 38, 121, 84, 16, 31, 115, 56, 90, 118, 62, 32, 57, 69, 28, 8}), r101);
        r102.putExtra((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4e702d", new byte[]{38, 104, 73, 10, 15, 102, 57, 10, 107, 115, 36, 41, 84, 69, 31, 114, 58, 10, 116, 117, 43, 110, 74, 87, 8, 103}), true);     // Catch: Exception -> L11
        this.f515434a.startService(r102);     // Catch: Exception -> L11
    L12:
        Intent r103 = new Intent();
        r103.setClassName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "16e73e", new byte[]{35, 59, 27, HTTP.CR, 1, 118, 59, 19, 122, 106, 51, 53}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "7a0bb9", new byte[]{37, 108, 78, 88, 80, 42, Base64.padSymbol, 68, 47, 63, 53, 98, HTTP.CR, 5, 88, 60, 34, 73, 98, 55, 104, 78, 80, 23, 116, 42, 7, 69, 115, 36, 47, 96, 70}));
        r103.setAction((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a8a0f8", new byte[]{115, 53, 31, 10, 91, 58, 108, 87, Base64.padSymbol, 115, 113, 116, 19, 71, 77, 38, 109, 23, 126, 98, 121, 52, 22, 80, 86, 97, 113, 28, 34, 118, 121, 57, 23}));
        r103.putExtra((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a3bfe1", new byte[]{115, 62, 28, 92, 88, 51, 108, 92, 62, 37, 113, ByteCompanionObject.MAX_VALUE, 1, 19, 72, 39, 111, 92, 35, Base64.padSymbol, 119, 63, 16, 31, 95}), r101);
        if (this.f515434a.bindService(r103, this.f515437d, 1) == false) goto L26;
        r110.f515441a.f515447a = new z((IBinder) this.f515436c.take()).a();     // Catch: Throwable -> L16 Exception -> L21
    L16:
        th = move-exception;
        this.f515434a.unbindService(this.f515437d);
        throw th;
    L19:
        this.f515434a.unbindService(this.f515437d);
        return;
    L26:
        return;
    L5:
        r100 = z2.b(this.f515434a, this.f515435b);
        goto L6
    }
}
