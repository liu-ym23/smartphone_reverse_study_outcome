package com.larus.home.impl.main.side_bar.view.adapter.arch;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yb9.b;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004H\u0016J:\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/arch/ReorderableItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "shouldAnimateMove", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "animateMove", "holder", "fromX", "", "fromY", "toX", "toY", "animateAdd", "animateRemove", "animateChange", "oldHolder", "newHolder", "fromLeft", "fromTop", "toLeft", "toTop", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReorderableItemAnimator extends DefaultItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<RecyclerView.ViewHolder, Boolean> f344965a;

    public ReorderableItemAnimator(b r100) {
        Intrinsics.checkNotNullParameter(r100, "shouldAnimateMove");
        this.f344965a = r100;
        setSupportsChangeAnimations(false);
        setMoveDuration(120);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        endAnimation(r100);
        dispatchAddFinished(r100);
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        endAnimation(r100);
        dispatchRemoveFinished(r100);
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f344965a.invoke(r100).booleanValue() == true) goto L5;
        endAnimation(r100);
        dispatchMoveFinished(r100);
        return false;
    L5:
        return super.animateMove(r100, r101, r102, r103, r104);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "oldHolder");
        endAnimation(r100);
        dispatchChangeFinished(r100, true);
        if (r101 == null) goto L6;
        if (r101 == r100) goto L6;
        endAnimation(r101);
        dispatchChangeFinished(r101, false);
    L6:
        return false;
    }
}
