package com.larus.bmhome.chat.service.action;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f308759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f308760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f308761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f308762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f308763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f308764f;

    public h0(NestedScrollView r100, boolean r101, int r102, Ref.ObjectRef r103, Ref.BooleanRef r104, Ref.ObjectRef r105) {
        this.f308759a = r100;
        this.f308760b = r101;
        this.f308761c = r102;
        this.f308762d = r103;
        this.f308763e = r104;
        this.f308764f = r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        NestedScrollView r109 = this.f308759a;
        if (this.f308760b == false) goto L5;
        int r110 = 0;
    L6:
        r109.scrollTo(0, r110);
        if (((com.larus.bmhome.taskskill.service.i) this.f308762d.element).f314450b == true) goto L9;
        return;
    L9:
        if (this.f308763e.element == false) goto L11;
        return;
    L11:
        if (this.f308759a.canScrollVertically(1) == true) goto L20;
        T r111 = this.f308764f.element;
        if (r111 != 0) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestLoadMore");
        Function0 r112 = null;
    L16:
        r112.invoke();
        return;
    L15:
        r112 = (Function0) r111;
        goto L16
    L20:
        return;
    L5:
        r110 = this.f308761c;
        goto L6
    }
}
