package com.ss.android.lark.slideback;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f440600a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f440601a;

        public a(b r100) {
            this.f440601a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f440601a.getClass();     // Catch: Throwable -> L4
            this.f440601a.getClass();     // Catch: Throwable -> L4
            this.f440601a.f440600a.finish();     // Catch: Throwable -> L4
            this.f440601a.f440600a.overridePendingTransition(R.anim.none, R.anim.none);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f440600a = r100;
        int r101 = com.ss.android.lark.slideback.a.f440599a;
        new a(this);
    }
}
