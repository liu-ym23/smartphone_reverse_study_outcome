package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class q implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoForwardFragment f461365a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardFragment f461366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f461367b;

        public a(DoubaoForwardFragment r100, View r101) {
            this.f461366a = r100;
            this.f461367b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DoubaoForwardFragment r100 = this.f461366a;     // Catch: Throwable -> L4
            View r101 = this.f461367b;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
            DoubaoForwardFragment.S90(r100, r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public q(DoubaoForwardFragment r100) {
        this.f461365a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r100.getVisibility() != 0) goto L6;
        r100.post(new a(this.f461365a, r100));
        return;
    }
}
