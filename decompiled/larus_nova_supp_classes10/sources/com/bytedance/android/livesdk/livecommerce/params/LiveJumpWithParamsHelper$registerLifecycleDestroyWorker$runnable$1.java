package com.bytedance.android.livesdk.livecommerce.params;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.plugin.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1 implements Runnable {
    public final /* synthetic */ Context a;

    public LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1(Context r1) {
        this.a = r1;
    }

    public final void a() {
        WeakHashMap<Context, Unit> r0 = a.a;
        if (r0.containsKey(this.a) == false) goto L5;
        return;
    L5:
        Activity r1 = e.getActivity(this.a);
        if ((r1 instanceof LifecycleOwner) == true) goto L8;
        r1 = null;
    L8:
        ECQuickUtilKt.DEFAULT_LIFECYCLE_OWNER.1 r2 = (LifecycleOwner) r1;
        if (r2 != null) goto L11;
        r2 = ECQuickUtilKt.b;
    L11:
        final Lifecycle r3 = r2.getLifecycle();
        r3.addObserver(new LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1$$special$$inlined$apply$lambda$1(r3, this));
        r0.put(this.a, Unit.INSTANCE);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
