package t81;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f545016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f545017b = -1;

    public static int a(Context r100) {
        if (b(r100) == false) goto L7;
        return -1;
    L7:
        if (f545017b >= 0) goto L10;
        f545017b = f545016a.getStreamMaxVolume(3);
    L10:
        return f545017b;
    }

    public static boolean b(Context r100) {
        if (f545016a != null) goto L8;
        f545016a = (AudioManager) r100.getSystemService("audio");     // Catch: Exception -> L6
    L8:
        if (f545016a != null) goto L10;
        return true;
    L10:
        return false;
    }
}
