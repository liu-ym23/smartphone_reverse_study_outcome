package com.ss.android.photoeditor.util;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f449546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f449547b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f449546a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f449547b.run();
            return false;
        }

        public a(View r100, Runnable r101) {
            this.f449546a = r100;
            this.f449547b = r101;
        }
    }

    public static void a(View r100, Runnable r101) {
        r100.getViewTreeObserver().addOnPreDrawListener(new a(r100, r101));
    }
}
