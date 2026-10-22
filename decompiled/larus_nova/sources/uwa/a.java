package uwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f551951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile InterfaceC7940a f551952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f551953c;

    /* JADX INFO: renamed from: uwa.a$a, reason: collision with other inner class name */
    public interface InterfaceC7940a {
        void afterOnCreate(Activity r100, boolean r101);

        void afterOnPause(Activity r100);

        void afterOnResume(Activity r100);

        Context injectBaseContext(Context r100);

        Intent injectGetIntent(Intent r100);

        boolean onDetectKeyEvent(Activity r100, KeyEvent r101);
    }

    public a() {
    }

    public static InterfaceC7940a a() {
        if (f551952b != null) goto L17;
        if (f551953c == true) goto L17;
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f551952b != null) goto L11;
        f551952b = (InterfaceC7940a) ClaymoreServiceLoader.loadFirstOrNull(InterfaceC7940a.class);     // Catch: Throwable -> L13
        f551953c = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L13
    L17:
        return f551952b;
    }
}
