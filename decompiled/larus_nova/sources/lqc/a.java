package lqc;

import android.content.Intent;
import android.os.IBinder;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void attach(Plugin r100);

    IBinder onBind(Intent r100);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent r100, int r101, int r102);

    boolean onUnbind(Intent r100);
}
