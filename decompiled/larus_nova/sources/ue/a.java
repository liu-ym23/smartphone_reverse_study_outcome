package ue;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.ec.adapter.impl.converter.c;
import com.bytedance.android.ec.adapter.impl.converter.i;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Class<? super Object> r101 = r100.getClass().getSuperclass();
        Context r102 = null;
        if (r101 == null) goto L7;
        Class<? super Object> r103 = r101.getSuperclass();
        if (r103 == null) goto L7;
        String r104 = r103.getSimpleName();
    L9:
        if (TextUtils.equals(r104, "GenerateProxyAppCompatActivity") == false) goto L11;
    L45:
        Object r105 = com.bytedance.android.ec.adapter.impl.utils.a.a(r100);     // Catch: Exception -> L23
        if (r105 == null) goto L22;
        Activity r106 = (Activity) r105;     // Catch: Exception -> L23
    L26:
        r106.hashCode();
        int r107 = r106.hashCode();
        Integer r108 = b.f549758a;
        if (r108 != null) goto L30;
        return;
    L30:
        if (r107 != r108.intValue()) goto L47;
        b.f549758a = null;
        Iterator<T> r109 = c.f42770a.iterator();
    L33:
        if (r109.hasNext() == false) goto L35;
        ((i) r109.next()).clear();
        goto L33
    L35:
        Context r110 = r100.getApplicationContext();
        if ((r110 instanceof Application) == false) goto L39;
        r102 = r110;
    L39:
        Application r111 = (Application) r102;
        if (r111 == null) goto L48;
        r111.unregisterActivityLifecycleCallbacks(this);
        return;
    L48:
        return;
    L47:
        return;
    L19:
        Exception e100 = e;
    L25:
        e100.printStackTrace();
        goto L26
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e100 = e;
        r106 = r100;
        goto L25
    L11:
        if (TextUtils.equals(r104, "GenerateProxyActivity") == true) goto L45;
        r106 = r100;
    L7:
        r104 = null;
        goto L9
    }
}
