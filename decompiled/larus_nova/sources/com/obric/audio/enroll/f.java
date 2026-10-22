package com.obric.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395442a = 0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f395443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f395444b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f395443a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f395444b.invoke();
            return true;
        }

        public a(View r100, Function0<Unit> r101) {
            this.f395443a = r100;
            this.f395444b = r101;
        }
    }

    static {
    }

    public static void a(View r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "closure");
        if (r100.getViewTreeObserver().isAlive() == false) goto L6;
        r100.getViewTreeObserver().addOnPreDrawListener(new a(r100, r101));
        return;
    }
}
