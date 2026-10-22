package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BodyContainerController f251956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f251957b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r100 = this.f251956a.a().getViewTreeObserver();
        if (r100.isAlive() == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.removeOnPreDrawListener(this);
    L8:
        RecyclerView r101 = this.f251956a.a();
        final Function0<Unit> r102 = this.f251957b;
        r101.postOnAnimation(new f(r102));
        return true;
    }

    public g(BodyContainerController r100, Function0<Unit> r101) {
        this.f251956a = r100;
        this.f251957b = r101;
    }
}
