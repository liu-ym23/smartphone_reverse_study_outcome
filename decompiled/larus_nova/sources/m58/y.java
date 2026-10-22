package m58;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f512149a = null;

    static {
        f512149a = new y();
    }

    public y() {
    }

    public static int c() {
        p r100 = h.f512144o;
        if (r100 == null) goto L7;
        Integer r101 = r100.c();
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 3;
    }

    public static String e(Context r100) {
        JSONObject r101 = new JSONObject();
        r101.put("currentMusicVolume", d(r100, 3, false));
        r101.put("maxMusicVolume", d(r100, 3, true));
        r101.put("currentSystemVolume", d(r100, 1, false));
        r101.put("maxSystemVolume", d(r100, 1, true));
        r101.put("currentVoiceCallVolume", d(r100, 0, false));
        r101.put("maxVoiceCallVolume", d(r100, 0, true));
        return r101.toString();
    }

    public final boolean a(Context r100) {
        Integer r101 = b(r100);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        if (r100 == null) goto L8;
        Object r103 = r100.getSystemService("audio");
    L9:
        AudioManager r104 = (AudioManager) r103;
        if (Build.VERSION.SDK_INT >= 28) goto L30;
        int r105 = 0;
    L27:
        if (r102 != r105) goto L32;
        return true;
    L32:
        return false;
    L30:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        int r107 = r104.getStreamMinVolume(3);     // Catch: Throwable -> L17
    L15:
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r107));     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L23;
        int r110 = c68.b.f22600a;
        c68.b.c("VolumeUtils", "getMinStreamMusicVolume: error " + r109.getMessage(), r109);
    L23:
        if (Result.m9455isFailureimpl(r108) == false) goto L25;
        r108 = 0;
    L25:
        r105 = ((Number) r108).intValue();
        goto L27
    L14:
        r107 = 0;
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = 0;
        goto L6
    }

    public final synchronized Integer b(Context r100) {
        monitor-enter(this);
        Integer r101 = null;
        if (r100 != null) goto L16;
        Object r102 = null;
    L9:
        AudioManager r103 = (AudioManager) r102;     // Catch: Throwable -> L6
        if (r103 == null) goto L12;
        r101 = Integer.valueOf(r103.getStreamVolume(c()));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(this);
        return r101;
    L16:
        r102 = r100.getSystemService("audio");     // Catch: Throwable -> L6
        goto L9
    }

    public final synchronized boolean f(Context r100) {
        monitor-enter(this);
        if (r100 != null) goto L18;
        Object r101 = null;
    L8:
        AudioManager r102 = (AudioManager) r101;     // Catch: Throwable -> L5
        if (r102 == null) goto L13;
        if (r102.getStreamVolume(c()) != 0) goto L13;
        boolean r103 = true;
    L14:
        monitor-exit(this);
        return r103;
    L5:
        th = move-exception;
        throw th;
    L13:
        r103 = false;
        goto L14
    L18:
        r101 = r100.getSystemService("audio");     // Catch: Throwable -> L5
        goto L8
    }

    public static Integer d(Context r100, int r101, boolean r102) {
        if (r100 == null) goto L5;
        Object r103 = r100.getSystemService("audio");
    L6:
        AudioManager r104 = (AudioManager) r103;
        if (r102 == false) goto L11;
        if (r104 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r104.getStreamMaxVolume(r101));
    L11:
        if (r104 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r104.getStreamVolume(r101));
    L5:
        r103 = null;
        goto L6
    }
}
