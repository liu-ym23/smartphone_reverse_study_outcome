package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n extends com.ss.android.lark.appcontext.applifecycle.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f413981a;

    public static final class a {
    }

    static {
    }

    public n(WeakReference<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "curActivity");
        this.f413981a = r100;
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Activity r102 = this.f413981a.get();
        if (r102 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.f413981a.get()) == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r100.getClass().getName(), r102.getClass().getName()) == false) goto L12;
        Log.i("MsgFullScreenLifeCycle", "new instance start, finish current Activity!");
        r102.finish();
        return;
    }
}
