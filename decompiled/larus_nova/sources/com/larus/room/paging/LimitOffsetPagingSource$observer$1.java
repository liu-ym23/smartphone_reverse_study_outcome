package com.larus.room.paging;

import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/larus/room/paging/LimitOffsetPagingSource$observer$1", "Landroidx/room/InvalidationTracker$Observer;", "room-paging_release"}, k = 1, mv = {1, 7, 1})
public final class LimitOffsetPagingSource$observer$1 extends InvalidationTracker.Observer {
    @Override // androidx.room.InvalidationTracker.Observer
    public final void onInvalidated(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "tables");
        throw null;
    }
}
