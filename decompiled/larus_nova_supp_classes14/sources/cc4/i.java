package cc4;

import android.view.MotionEvent;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements InvocationHandler {
    public final Window.Callback a;

    public i(Window.Callback r1) {
        this.a = r1;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r2, Method r3, Object[] r4) throws Throwable {
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r3.invoke(this.a, r4);
    L3:
        if ("dispatchTouchEvent".equals(r3.getName()) == false) goto L14;
        if (r4 == null) goto L14;
        if (r4.length <= 0) goto L14;
        Object r5 = r4[0];     // Catch: Exception -> L11
        if ((r5 instanceof MotionEvent) == false) goto L14;
        g r0 = g.d();     // Catch: Exception -> L11
        r0.j((MotionEvent) r5);     // Catch: Exception -> L11
        goto L14
    }
}
