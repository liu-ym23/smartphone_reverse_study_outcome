package com.bytedance.jedi.arch.ext.list.differ;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH$J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\fH$J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/FetcherDelegate;", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "()V", "appendCountRequested", "", "enablePrefetch", "", "isPrefetching", "actualLoad", "", "actualPrefetch", "itemCountSupplier", "Lkotlin/Function1;", "onLoaded", "loadedCount", "error", "", "schedulePrefetch", "tryPrefetch", "indexToPrefetch", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public abstract class FetcherDelegate implements JediListPrefetcher.Fetcher {
    private int appendCountRequested;
    private boolean enablePrefetch;
    private boolean isPrefetching;

    public FetcherDelegate() {
    }

    public abstract void actualLoad();

    public abstract void actualPrefetch(Function1<? super Integer, Unit> r100);

    private final void schedulePrefetch() {
        if (this.isPrefetching == false) goto L5;
        return;
    L5:
        this.isPrefetching = true;
        actualLoad();
    }

    public static final /* synthetic */ int access$getAppendCountRequested$p(FetcherDelegate r100) {
        return r100.appendCountRequested;
    }

    public static final /* synthetic */ void access$schedulePrefetch(FetcherDelegate r100) {
        r100.schedulePrefetch();
    }

    @Override // com.bytedance.jedi.arch.ext.list.differ.JediListPrefetcher.Fetcher
    public void tryPrefetch(final int r100) {
        this.enablePrefetch = true;
        actualPrefetch(new AnonymousClass1(this, r100));
    }

    public static final /* synthetic */ void access$setAppendCountRequested$p(FetcherDelegate r100, int r101) {
        r100.appendCountRequested = r101;
    }

    public final void onLoaded(int r100, Throwable r101) {
        if (this.enablePrefetch == false) goto L12;
        this.isPrefetching = false;
        if (r101 != null) goto L13;
        if (r100 == 0) goto L15;
        int r102 = this.appendCountRequested - r100;
        this.appendCountRequested = r102;
        if (r102 <= 0) goto L14;
        schedulePrefetch();
        return;
    L14:
        return;
    L15:
        return;
    L13:
        return;
    }
}
