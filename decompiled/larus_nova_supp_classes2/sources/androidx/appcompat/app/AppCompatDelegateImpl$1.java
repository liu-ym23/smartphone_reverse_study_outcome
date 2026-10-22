package androidx.appcompat.app;

import android.content.res.Resources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$1 implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

    public AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler r1) {
        this.val$defHandler = r1;
    }

    private boolean shouldWrapException(Throwable r3) {
        if ((r3 instanceof Resources.NotFoundException) == false) goto L12;
        String r4 = r3.getMessage();
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.contains("drawable") == false) goto L9;
    L10:
        return true;
    L9:
        if (r4.contains("Drawable") == true) goto L10;
        return false;
    L12:
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r4, Throwable r5) {
        if (shouldWrapException(r5) == false) goto L5;
        Resources.NotFoundException r0 = new Resources.NotFoundException(r5.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        r0.initCause(r5.getCause());
        r0.setStackTrace(r5.getStackTrace());
        this.val$defHandler.uncaughtException(r4, r0);
        return;
    L5:
        this.val$defHandler.uncaughtException(r4, r5);
    }
}
