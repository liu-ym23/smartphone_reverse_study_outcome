package bt3;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static volatile Handler a;

    static {
        new HashSet();
        a = new Handler(Looper.getMainLooper());
    }
}
