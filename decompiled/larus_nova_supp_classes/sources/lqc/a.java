package lqc;

import android.content.Intent;
import android.os.IBinder;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface a {
    void attach(Plugin r1);

    IBinder onBind(Intent r1);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent r1, int r2, int r3);

    boolean onUnbind(Intent r1);
}
