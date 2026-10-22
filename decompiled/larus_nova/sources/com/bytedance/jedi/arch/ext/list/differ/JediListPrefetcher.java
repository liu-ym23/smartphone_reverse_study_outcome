package com.bytedance.jedi.arch.ext.list.differ;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "", "fetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "enablePrefetch", "", "prefetchDistance", "", "(Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;ZI)V", "getFetcher", "()Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "loadAround", "", "index", "loadAround$ext_list_release", "Builder", "Fetcher", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class JediListPrefetcher {
    private final boolean enablePrefetch;
    private final Fetcher fetcher;
    private final int prefetchDistance;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Builder;", "", "fetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "(Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "enablePrefetch", "", "prefetchDistance", "", "build", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "setEnablePrefetch", "setPrefetchDistance", "ext_list_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private boolean enablePrefetch;
        private final Fetcher fetcher;
        private int prefetchDistance;

        public final JediListPrefetcher build() {
            boolean r100 = this.enablePrefetch;
            if (r100 == false) goto L10;
            if (this.prefetchDistance > 0) goto L10;
            throw new IllegalArgumentException("Prefetch distance must be a positive number when prefetch is enabled");
        L10:
            return new JediListPrefetcher(this.fetcher, r100, this.prefetchDistance, null);
        }

        public Builder(Fetcher r100) {
            this.fetcher = r100;
        }

        public final Builder setEnablePrefetch(boolean r100) {
            this.enablePrefetch = r100;
            return this;
        }

        public final Builder setPrefetchDistance(int r100) {
            this.prefetchDistance = r100;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "", "tryPrefetch", "", "indexToPrefetch", "", "ext_list_release"}, k = 1, mv = {1, 1, 16})
    public interface Fetcher {
        void tryPrefetch(int r100);
    }

    public final Fetcher getFetcher() {
        return this.fetcher;
    }

    public final void loadAround$ext_list_release(int r100) {
        if (this.enablePrefetch == true) goto L5;
        return;
    L5:
        this.fetcher.tryPrefetch(r100 + this.prefetchDistance);
    }

    private JediListPrefetcher(Fetcher r100, boolean r101, int r102) {
        this.fetcher = r100;
        this.enablePrefetch = r101;
        this.prefetchDistance = r102;
    }

    public /* synthetic */ JediListPrefetcher(Fetcher r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }
}
