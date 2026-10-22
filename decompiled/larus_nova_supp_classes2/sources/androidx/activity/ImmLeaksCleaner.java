package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED = 0;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;
    private Activity mActivity;

    private static void initializeReflectiveFields() {
        sReflectedFieldsInitialized = 2;     // Catch: NoSuchFieldException -> L5
        Field r0 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        sServedViewField = r0;     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r1 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        sNextServedViewField = r1;     // Catch: NoSuchFieldException -> L5
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r2 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        sHField = r2;     // Catch: NoSuchFieldException -> L5
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        sReflectedFieldsInitialized = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }

    public ImmLeaksCleaner(Activity r1) {
        this.mActivity = r1;
    }

    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        if (r4 == Lifecycle.Event.ON_DESTROY) goto L6;
        return;
    L6:
        if (sReflectedFieldsInitialized != 0) goto L9;
        initializeReflectiveFields();
    L9:
        if (sReflectedFieldsInitialized != 1) goto L36;
        InputMethodManager r5 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        Object r6 = sHField.get(r5);     // Catch: IllegalAccessException -> L37
        if (r6 != null) goto L14;
        return;
    L14:
        monitor-enter(r6);
        View r0 = (View) sServedViewField.get(r5);     // Catch: Throwable -> L28 ClassCastException -> L30 IllegalAccessException -> L32
        if (r0 != null) goto L20;
        monitor-exit(r6);     // Catch: Throwable -> L28
        return;
    L20:
        if (r0.isAttachedToWindow() == false) goto L38;
        monitor-exit(r6);     // Catch: Throwable -> L28
        return;
    L38:
        sNextServedViewField.set(r5, null);     // Catch: IllegalAccessException -> L26 Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
        r5.isActive();
        return;
    L27:
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        return;
    L33:
        return;
    L45:
        return;
    }
}
