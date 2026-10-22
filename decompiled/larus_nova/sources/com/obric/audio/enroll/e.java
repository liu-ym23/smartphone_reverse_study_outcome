package com.obric.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.audio.enroll.view.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f395440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f395441b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f395440a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f395441b.invoke();
    }

    public e(View r100, n r101) {
        this.f395440a = r100;
        this.f395441b = r101;
    }
}
