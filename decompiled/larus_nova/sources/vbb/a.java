package vbb;

import com.ss.android.lark.download.service.impl.j;
import wbb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f554074a;

    public a() {
    }

    public static d a() {
        if (f554074a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f554074a != null) goto L9;
        f554074a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f554074a;
    }
}
