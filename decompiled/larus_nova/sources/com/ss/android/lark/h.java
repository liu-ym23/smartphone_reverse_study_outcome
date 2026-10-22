package com.ss.android.lark;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f425847a;

    public interface a {
        void addUiModeChangeListener(b r100);

        void sendEvent(String r100, JSONObject r101);
    }

    public interface b {
    }

    public h() {
    }

    public static a a() {
        if (f425847a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f425847a != null) goto L9;
        f425847a = (a) ClaymoreServiceLoader.loadFirst(a.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f425847a;
    }
}
