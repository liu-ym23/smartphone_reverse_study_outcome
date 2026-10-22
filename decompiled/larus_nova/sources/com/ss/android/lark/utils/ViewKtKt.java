package com.ss.android.lark.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ViewKtKt {

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f444672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f444673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f444674c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f444672a.invoke();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            ViewTreeObserver r101 = this.f444673b.getViewTreeObserver();
            if (r101.isAlive() == false) goto L6;
            r101.removeOnGlobalLayoutListener(this.f444674c);
            return;
        }

        public a(Function0<Unit> r100, View r101, ViewTreeObserver.OnGlobalLayoutListener r102) {
            this.f444672a = r100;
            this.f444673b = r101;
            this.f444674c = r102;
        }
    }

    public static final void a(final View r100, final ViewTreeObserver.OnGlobalLayoutListener r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Function0<Unit> r102 = new ViewKtKt$addOnGlobalLayoutListenerSafely$addOnGlobalLayoutListener$1(r100, r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r102.invoke();
    L5:
        r100.addOnAttachStateChangeListener(new a(r102, r100, r101));
    }
}
