package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableRangeMap or TreeRangeMap")
@ElementTypesAreNonnullByDefault
public interface f2<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();
}
