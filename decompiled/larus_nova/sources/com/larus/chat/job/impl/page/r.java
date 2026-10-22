package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes26.dex */
public final class r implements Grouping<AIJob, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f325396a;

    @Override // kotlin.collections.Grouping
    public final Iterator<AIJob> sourceIterator() {
        return this.f325396a.iterator();
    }

    public r(Iterable r100) {
        this.f325396a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final Integer keyOf(AIJob r100) {
        return Integer.valueOf(r100.getStatus());
    }
}
