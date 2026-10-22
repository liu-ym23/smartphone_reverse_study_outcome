package com.larus.bmhome.chat.service.action;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f308769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f308770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f308771c;

    public i0(NestedScrollView r100, Ref.ObjectRef r101, Ref.ObjectRef r102) {
        this.f308769a = r100;
        this.f308770b = r101;
        this.f308771c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f308769a.scrollTo(0, 0);
        if (((com.larus.bmhome.taskskill.service.i) this.f308770b.element).f314450b == true) goto L5;
        return;
    L5:
        if (this.f308769a.canScrollVertically(1) == true) goto L13;
        T r109 = this.f308771c.element;
        if (r109 != 0) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("requestLoadMore");
        Function0 r110 = null;
    L10:
        r110.invoke();
        return;
    L9:
        r110 = (Function0) r109;
        goto L10
    }
}
