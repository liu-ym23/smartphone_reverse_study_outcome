package com.bytedance.locallife.pdp.container.view;

import android.os.Looper;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultViewVisibilityDirector f261255a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultViewVisibilityDirector f261256a;

        public a(DefaultViewVisibilityDirector r100) {
            this.f261256a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DefaultViewVisibilityDirector r100 = this.f261256a;     // Catch: Throwable -> L4
            int r101 = DefaultViewVisibilityDirector.f261217l;     // Catch: Throwable -> L4
            r100.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(DefaultViewVisibilityDirector r100) {
        this.f261255a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        this.f261255a.h();
        return;
    L5:
        this.f261255a.f().post(new a(this.f261255a));
    }
}
