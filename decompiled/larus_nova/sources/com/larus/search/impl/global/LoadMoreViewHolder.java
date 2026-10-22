package com.larus.search.impl.global;

import android.view.animation.RotateAnimation;
import com.larus.business.search.impl.databinding.LarusItemSearchLoadMoreBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/search/impl/global/LoadMoreViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/business/search/impl/databinding/LarusItemSearchLoadMoreBinding;", "<init>", "(Lcom/larus/business/search/impl/databinding/LarusItemSearchLoadMoreBinding;)V", "getBinding", "()Lcom/larus/business/search/impl/databinding/LarusItemSearchLoadMoreBinding;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "updateStatus", "", "status", "Lcom/larus/paging/LoadState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadMoreViewHolder extends ViewBindingHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSearchLoadMoreBinding f367709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RotateAnimation f367710b;

    public LoadMoreViewHolder(LarusItemSearchLoadMoreBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100);
        this.f367709a = r100;
        RotateAnimation r101 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r101.setDuration(2000);
        r101.setRepeatCount(-1);
        this.f367710b = r101;
    }
}
