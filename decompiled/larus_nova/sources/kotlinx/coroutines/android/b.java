package kotlinx.coroutines.android;

import android.os.Build;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public b() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext r100, Throwable r101) {
        int r102 = Build.VERSION.SDK_INT;
        boolean r103 = true;
        if (26 <= r102) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L34;
        Object r105 = this._preHandler;
        Thread.UncaughtExceptionHandler r106 = null;
        if (r105 == this) goto L32;
        Method r107 = (Method) r105;
    L22:
        if (r107 == null) goto L24;
        Object r108 = r107.invoke(null, new Object[0]);
    L26:
        if ((r108 instanceof Thread.UncaughtExceptionHandler) == false) goto L28;
        r106 = (Thread.UncaughtExceptionHandler) r108;
    L28:
        if (r106 == null) goto L35;
        r106.uncaughtException(ThreadMethodProxy.currentThread(), r101);
        return;
    L35:
        return;
    L24:
        r108 = null;
        goto L26
    L32:
        r107 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L31
        if (Modifier.isPublic(r107.getModifiers()) == false) goto L17;
        if (Modifier.isStatic(r107.getModifiers()) == false) goto L17;
    L18:
        if (r103 == false) goto L20;
    L21:
        this._preHandler = r107;
    L17:
        r103 = false;
    L20:
        r107 = null;
        goto L21
    L34:
        return;
    L5:
        if (r102 >= 28) goto L7;
        r104 = true;
        goto L8
    }
}
