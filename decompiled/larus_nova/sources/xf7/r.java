package xf7;

import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class r {
    public static void a(String r100, JSONObject r101) {
        zf7.b.c("onEventV3: eventName = " + r100 + " " + r101.toString());     // Catch: Throwable -> L5
        AppLogNewUtils.onEventV3(r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
