package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableRangeSet or TreeRangeSet")
@ElementTypesAreNonnullByDefault
public interface g2<C extends Comparable> {
    Set<Range<C>> asRanges();

    g2<C> complement();

    boolean encloses(Range<C> r100);

    boolean isEmpty();

    void removeAll(g2<C> r100);

    g2<C> subRangeSet(Range<C> r100);
}
