package com.larus.home.impl.main.side_bar.feed.arch;

import com.larus.home.api.feed.IFlowFeedProvider;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes29.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f344638a = null;

    public static final class a implements Grouping<IFlowFeedProvider, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f344639a;

        @Override // kotlin.collections.Grouping
        public final Iterator<IFlowFeedProvider> sourceIterator() {
            return this.f344639a.iterator();
        }

        public a(Iterable r100) {
            this.f344639a = r100;
        }

        @Override // kotlin.collections.Grouping
        public final String keyOf(IFlowFeedProvider r100) {
            return r100.d();
        }
    }

    static {
        f344638a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new u());
    }
}
