package com.enroll.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f273724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f273725b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f273724a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f273725b.invoke();
    }

    public c(View r100, com.enroll.audio.enroll.view.a r101) {
        this.f273724a = r100;
        this.f273725b = r101;
    }
}
