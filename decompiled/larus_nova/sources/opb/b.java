package opb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public b() {
    }

    public final void a(final Map<String, String> r100, final Map<String, jpb.a> r101, boolean r110, final boolean r111, final boolean r112) {
        if (r110 == false) goto L5;
        Log.i("AppConfigDataStore", "saveAppConfigs common_settings_opt_close: " + r112);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(this, r100, r101, r111, r112));
        return;
    }
}
