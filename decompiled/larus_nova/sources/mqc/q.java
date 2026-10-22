package mqc;

import android.os.Build;
import android.os.Environment;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f514967a = null;

    static {
        String[] r100 = {Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_DCIM, Environment.DIRECTORY_DOCUMENTS};
        f514967a = r100;
        if (Build.VERSION.SDK_INT < 29) goto L6;
        f514967a = (String[]) ArraysKt.plus(r100, Environment.DIRECTORY_AUDIOBOOKS);
        return;
    }
}
