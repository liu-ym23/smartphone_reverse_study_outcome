package com.larus.uaigc.instruction;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import java.util.Iterator;
import kotlin.collections.Grouping;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 implements Grouping<CreationReferenceMediaType, CreationReferenceMediaType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f373345a;

    @Override // kotlin.collections.Grouping
    public final Iterator<CreationReferenceMediaType> sourceIterator() {
        return this.f373345a.iterator();
    }

    public h0(Iterable r100) {
        this.f373345a = r100;
    }

    @Override // kotlin.collections.Grouping
    public final CreationReferenceMediaType keyOf(CreationReferenceMediaType r100) {
        return r100;
    }
}
