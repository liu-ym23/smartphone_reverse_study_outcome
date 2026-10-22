package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile p1 f515360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f515361b;

    public static void a(Context r110, Intent r111) {
        if (f515360a == null) goto L5;
        return;
    L5:
        monitor-enter(p1.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f515360a != null) goto L22;
        Bundle r100 = r111.getBundleExtra((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "d59b8b", new byte[]{121, 62, 92, 19, 56, 97, 98, 7}));     // Catch: Throwable -> L12
        Context r101 = BadParcelableCrashOptimizer.getContext();     // Catch: Throwable -> L12
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        r100.setClassLoader(r101.getClassLoader());     // Catch: Throwable -> L12
    L14:
        if (r100 == null) goto L18;
        CharSequence r102 = r100.getCharSequence((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "37b310", new byte[]{35, 37, 1, 110, 42}));     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r102) == true) goto L18;
        String r103 = r102.toString();     // Catch: Throwable -> L12
    L21:
        f515360a = new p1(r110, r103);     // Catch: Throwable -> L12
    L18:
        r103 = null;
    L22:
        monitor-exit(p1.class);     // Catch: Throwable -> L12
    }
}
