package j17;

import android.content.SharedPreferences;
import com.bytedance.lynx.webview.internal.TTWebContext;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f496866b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f496867a;

    public static b a() {
        if (f496866b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f496866b != null) goto L9;
        f496866b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f496866b;
    }

    public b() {
        this.f496867a = TTWebContext.h().getContext().getSharedPreferences("LibraryPreparerNG_Prefs", 0);
    }
}
