package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class j implements Runnable {
    public k a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public final String b() {
        StringBuilder r0 = new StringBuilder("PlayerTask");
        r0.append(hashCode());
        r0.append(" type = ");
        int r1 = this.b;
        if (r1 == 10) goto L15;
        switch(r1) {
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L5:
        String r2 = "";
    L16:
        r0.append(r2);
        return r0.toString();
    L6:
        r2 = "seek_task";
        goto L16
    L7:
        r2 = "error_task";
        goto L16
    L8:
        r2 = "complete_task";
        goto L16
    L9:
        r2 = "set_url_task";
        goto L16
    L10:
        r2 = "release_task";
        goto L16
    L11:
        r2 = "stop_task";
        goto L16
    L12:
        r2 = "pause_task";
        goto L16
    L13:
        r2 = "play_task";
        goto L16
    L14:
        r2 = "init_task";
        goto L16
    L15:
        r2 = "set_surface_task";
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L7
        k r0 = this.a;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");     // Catch: Throwable -> L7
    L5:
        r0.d(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public final int getType() {
        return this.b;
    }

    public j(int r1) {
        this.b = r1;
    }
}
