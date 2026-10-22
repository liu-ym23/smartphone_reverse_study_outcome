package com.google.common.util.concurrent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    @CheckForNull
    private List<Present<V>> values;

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        @Override // com.google.common.util.concurrent.CollectionFuture
        public List<V> combine(List<Present<V>> r100) {
            ArrayList r101 = Lists.d(r100.size());
            Iterator<Present<V>> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            Present<V> r103 = r102.next();
            if (r103 == null) goto L8;
            V r104 = r103.value;
        L9:
            r101.add(r104);
            goto L4
        L8:
            r104 = null;
            goto L9
        L11:
            return Collections.unmodifiableList(r101);
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        public /* bridge */ /* synthetic */ Object combine(List r100) {
            return combine(r100);
        }

        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r100, boolean r101) {
            super(r100, r101);
            init();
        }
    }

    public static final class Present<V> {

        @ParametricNullness
        final V value;

        public Present(@ParametricNullness V r100) {
            this.value = r100;
        }
    }

    public abstract C combine(List<Present<V>> r100);

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void handleAllCompleted() {
        List<Present<V>> r100 = this.values;
        if (r100 == null) goto L6;
        set(combine(r100));
        return;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void releaseResources(AggregateFuture.ReleaseResourcesReason r100) {
        super.releaseResources(r100);
        this.values = null;
    }

    public CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r100, boolean r101) {
        super(r100, r101, true);
        if (r100.isEmpty() == false) goto L5;
        List<Present<V>> r102 = Collections.emptyList();
    L6:
        int r103 = 0;
    L8:
        if (r103 >= r100.size()) goto L10;
        r102.add(null);
        r103 = r103 + 1;
        goto L8
    L10:
        this.values = r102;
        return;
    L5:
        r102 = Lists.d(r100.size());
        goto L6
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void collectOneValue(int r100, @ParametricNullness V r101) {
        List<Present<V>> r102 = this.values;
        if (r102 == null) goto L6;
        ListProtector.set(r102, r100, new Present(r101));
        return;
    }
}
