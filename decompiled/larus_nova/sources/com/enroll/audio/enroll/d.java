package com.enroll.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import com.enroll.audio.enroll.view.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f273726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f273727b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f273726a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f273727b.invoke();
        return true;
    }

    public d(View r100, u r101) {
        this.f273726a = r100;
        this.f273727b = r101;
    }
}
