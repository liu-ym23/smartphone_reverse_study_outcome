package gd;

import android.app.Activity;
import android.app.Application;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends Application.ActivityLifecycleCallbacks {
    @Deprecated(message = "use getTopActivities instead.")
    Activity getTopActivity();

    Set<Activity> i();

    boolean isAppBackground();

    ConcurrentHashMap<Long, Long> l(long r100, long r101);

    void q(a r100);
}
