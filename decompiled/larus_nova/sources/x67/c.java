package x67;

import android.content.Context;
import com.bytedance.push.utils.f;
import com.ss.android.message.util.ToolUtils;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static void a(Context r100) {
        if (ToolUtils.isMainProcess(r100) == false) goto L13;
        if (r100 == null) goto L16;
        f.b("MessageLogClient", "[start]");
        agc.a r101 = agc.a.f3375f;
        if (r101 != null) goto L10;
        f.b("MessageLogClient", "[start]init sMessageLogClient");
        agc.a.f3375f = new agc.a(r100);
        return;
    L10:
        if (r101.f3376a != null) goto L15;
        f.b("MessageLogClient", "[start]init sMessageLogClient.mService");
        agc.a.f3375f.a();
        return;
    L15:
        return;
    L16:
        return;
    }
}
