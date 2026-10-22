package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function5<View, Integer, Integer, Integer, Integer, Unit> f210498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f210499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f210500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewTreeObserver f210501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f210502f;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f210503a;

        public a(t r100) {
            this.f210503a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            int r100 = this.f210503a.f210497a.getScrollX();
            int r101 = this.f210503a.f210497a.getScrollY();
            t r102 = this.f210503a;
            if (r100 == r102.f210499c) goto L5;
        L7:
            r102.f210498b.invoke(r102.f210497a, Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(this.f210503a.f210499c), Integer.valueOf(this.f210503a.f210500d));
            t r103 = this.f210503a;
            r103.f210499c = r100;
            r103.f210500d = r101;
            return;
        L5:
            if (r101 != r102.f210500d) goto L7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(View r100, Function5<? super View, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onScrollChanged");
        this.f210497a = r100;
        this.f210498b = r101;
        this.f210499c = r100.getScrollX();
        this.f210500d = r100.getScrollY();
        this.f210502f = new a(this);
    }
}
