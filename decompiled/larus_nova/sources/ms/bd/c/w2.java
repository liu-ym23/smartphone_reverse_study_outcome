package ms.bd.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class w2 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f515415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f515416b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static w2 f515417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f515418d;

    static {
        String r100 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "bb3b3c", new byte[]{125, 111, 84, 31, 10, 125, 98, 66, 118, 59, 124, 110});
        f515415a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "35c40d", new byte[]{33, 56, 29, 14, HTTP.CR, 106, 36, 17, 54, 101, 44, 52, 21, 14, 2, 118, 36, 21, 33, 97, 33, 121, 30, 79, 27, 122, 54, 29, 49, 101, 54, 62, 31, 78, 65, ByteCompanionObject.MAX_VALUE, 57, 2, 55, 42, 45, 57});
        f515416b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c0d883", new byte[]{113, Base64.padSymbol, 26, 2, 5, Base64.padSymbol, 116, 20, 49, 105, 124, 49, 18, 2, 10, 33, 116, 16, 38, 109, 113, 124, 25, 67, 19, 45, 102, 24, 54, 105, 102, 59, 24, 66, 73, 40, 105, 7, 48, 38, 125, 52, 17});
        f515418d = false;
    }

    public w2() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r110, Intent r111) {
        String r100 = r111.getAction();
        String r101 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "e8b305", new byte[]{90, 53, 5, 78, 9, 43, 101, 24, 39, 106, 123, 52, 81, 85, 10, 33, 99, 16, 37, 102, 112, 96, 81, 70, 12, 54, 111, 22, Base64.padSymbol, 35, 41, 122, 84, 84, 65});
        if (r100 != null) goto L5;
        return;
    L5:
        int r102 = r100.hashCode();
        if (r102 == (-1125048048)) goto L14;
        if (r102 == (-516751266)) goto L11;
    L16:
        byte r103 = -1;
    L18:
        if (r103 == 0) goto L31;
        if (r103 == 1) goto L22;
        String r112 = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a1ca11", new byte[]{69, Base64.padSymbol, 27, 27, 1, 49, 108, 80, 60, 62, 100, 58, 22, 28, HTTP.CR, 39, 118, 25, Base64.padSymbol, 63, 48, 33, 21, 22, 11, 47, 116, 21, 54, ByteCompanionObject.MAX_VALUE});
        return;
    L22:
        if (s1.f515360a != null) goto L24;
        return;
    L24:
        if (s1.f515361b == false) goto L50;
        p1 r113 = s1.f515360a;
        if (r113.f515283d == true) goto L28;
    L30:
        s1.f515361b = false;
        return;
    L28:
        if (r113.f515280a.f515331a == false) goto L30;
        Message r114 = new Message();
        r114.what = 4;
        r113.f515284e.sendMessage(r114);
        ThreadMethodProxy.start(new PthreadThreadV2(new o1(r113), "ms/bd/c/w2"));
        goto L30
    L50:
        return;
    L31:
        Context r115 = r110.getApplicationContext();
        monitor-enter(s1.class);
        s1.a(r115, r111);     // Catch: Throwable -> L43
        if (s1.f515361b == true) goto L41;
        p1 r116 = s1.f515360a;     // Catch: Throwable -> L43
        if (r116.f515283d == true) goto L38;
    L40:
        s1.f515361b = true;     // Catch: Throwable -> L43
        goto L41
    L38:
        if (r116.f515280a.f515331a == false) goto L40;
        r116.f515285f = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L43
        PthreadHandlerThreadV2 r117 = new PthreadHandlerThreadV2((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4ff7b4", new byte[]{41, 109, 3, 70, 98, 55, 50, 84}));     // Catch: Throwable -> L43
        r116.f515286g = r117;     // Catch: Throwable -> L43
        ThreadMethodProxy.start(r117);     // Catch: Throwable -> L43
        r116.f515284e = new n1(r116, r116.f515286g.getLooper());     // Catch: Throwable -> L43
        Message r118 = new Message();     // Catch: Throwable -> L43
        r118.what = 1;     // Catch: Throwable -> L43
        r116.f515284e.sendMessage(r118);     // Catch: Throwable -> L43
        Message r119 = new Message();     // Catch: Throwable -> L43
        r119.what = 3;     // Catch: Throwable -> L43
        r116.f515284e.sendMessageDelayed(r119, r116.f515281b.f515399c);     // Catch: Throwable -> L43
    L41:
        monitor-exit(s1.class);
        return;
    L43:
        th = move-exception;
        throw th;
    L11:
        if (r100.equals(f515416b) == false) goto L16;
        r103 = 1;
        goto L18
    L14:
        if (r100.equals(f515415a) == false) goto L16;
        r103 = 0;
        goto L18
    }
}
