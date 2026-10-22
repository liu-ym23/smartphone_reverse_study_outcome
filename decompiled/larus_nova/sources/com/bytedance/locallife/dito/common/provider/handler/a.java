package com.bytedance.locallife.dito.common.provider.handler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f257628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f257629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f257630c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f257628a.removeOnAttachStateChangeListener(this);
        this.f257629b.removeOnLayoutChangeListener((View.OnLayoutChangeListener) this.f257630c.element);
    }

    public a(RecyclerView r100, RecyclerView r101, Ref.ObjectRef r102) {
        this.f257628a = r100;
        this.f257629b = r101;
        this.f257630c = r102;
    }
}
