package z67;

import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {
    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (PushSupporter.get().getConfiguration().f266782v == false) goto L7;
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(com.ss.android.pushmanager.setting.a.b().a()) == false) goto L7;
        return;
    L7:
        d.b(201, ToolUtils.currentTimeMillis() - d.f570510d);     // Catch: Throwable -> L9
    }
}
