package bl9;

import android.os.Looper;
import cl9.j;
import cl9.k;
import cl9.l;
import com.bytedance.mira.MiraPluginBeforeLoadListener;
import com.bytedance.mira.MiraPluginEventListener;
import com.bytedance.mira.event.PluginEventListener;
import com.bytedance.mira.plugin.PluginManager;
import com.larus.utils.logger.FLogger;
import hl9.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements PluginEventListener, MiraPluginBeforeLoadListener, MiraPluginEventListener {
    public b() {
    }

    @Override // com.bytedance.mira.MiraPluginBeforeLoadListener
    public final void onBeforeLoad(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        boolean r0 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        FLogger.a.i("plugin/init", "start to load plugin: " + r5 + ", isMainThread: " + r0);
        Iterator r1 = a.b(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        if (Intrinsics.areEqual(r2, r5) == true) goto L4;
        PluginManager.getInstance().loadPlugin(r2);
        goto L4
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginLoaded(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        AndroidSchedulers.mainThread().scheduleDirect(new a(r3));
        Map r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, "packageName");
        l.c.execute(new k(r3));
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginInstallResult(String r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 == false) goto L7;
        Map r4 = l.a;
        Intrinsics.checkNotNullParameter(r2, "plugin");
        l.c.execute(new j(r2));
        return;
    }

    @Override // com.bytedance.mira.event.PluginEventListener
    public final void onPluginEvent(int r17, String r18, int r19, long r20, Throwable r22, long r23) {
        Intrinsics.checkNotNullParameter(r18, "packageName");
        if (r17 != 31000) goto L6;
        FLogger.a.i("plugin/init", " load success packageName: " + r18 + ", versionCode: " + r19 + ", duration: " + r20 + ", throwable: " + r22 + ", timestamp: " + r23);
    L6:
        if (r17 >= 12000) goto L8;
        return;
    L8:
        if (r17 != 12013) goto L10;
        return;
    L10:
        if (r17 >= 20000) goto L15;
        FLogger.a.e("plugin/init", " load Fail packageName: " + r18 + ", versionCode: " + r19 + ", duration: " + r20 + ", throwable: " + r22 + ", timestamp: " + r23);
        return;
    }
}
