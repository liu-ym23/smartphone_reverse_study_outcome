package com.bytedance.live.datacontext;

import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.subjects.CompletableSubject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\rR\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/live/datacontext/DataContext;", "Landroidx/lifecycle/ViewModel;", "()V", "_onCleared", "Lio/reactivex/subjects/CompletableSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/CompletableSubject;", "isCleared", "", "()Z", "onCleared", "Lio/reactivex/Completable;", "getOnCleared", "()Lio/reactivex/Completable;", "", "datacontext_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class DataContext extends ViewModel {
    private final CompletableSubject _onCleared;

    public final boolean isCleared() {
        return this._onCleared.d();
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (this._onCleared.d() == false) goto L5;
        return;
    L5:
        this._onCleared.onComplete();
    }

    public DataContext() {
        int r100 = com.bytedance.revenue.platform.api.core.rx.d.f267510a;
        this._onCleared = new CompletableSubject();
    }

    public final Completable getOnCleared() {
        return this._onCleared;
    }
}
