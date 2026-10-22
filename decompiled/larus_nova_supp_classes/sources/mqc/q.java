package mqc;

import android.os.Build;
import android.os.Environment;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class q {
    public static final String[] a = null;

    static {
        String[] r0 = {Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_DCIM, Environment.DIRECTORY_DOCUMENTS};
        a = r0;
        if (Build.VERSION.SDK_INT < 29) goto L6;
        a = (String[]) ArraysKt.plus(r0, Environment.DIRECTORY_AUDIOBOOKS);
        return;
    }
}
