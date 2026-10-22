package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.bmhome.social.page.datasource.event.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b<Item, Event extends com.larus.bmhome.social.page.datasource.event.a<Item>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DiffUtil.ItemCallback<Item> f314015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListUpdateCallback f314016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<c<Item>> f314017c;

    public abstract Object b(Event r100, Continuation<? super Unit> r101);

    public abstract List<Item> c();

    public final void d(List<? extends Item> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (this.f314017c.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f314017c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((c) r101.next()).onChanged(r100);
        goto L7
    }

    public b(DiffUtil.ItemCallback r100, com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        Intrinsics.checkNotNullParameter(r101, "updateCallback");
        this.f314015a = r100;
        this.f314016b = r101;
        this.f314017c = new CopyOnWriteArraySet();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.social.page.datasource.diff.IPagingAdapterDiffer$buildCallback$1] */
    public final IPagingAdapterDiffer$buildCallback$1 a(List r100, final List r101) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final List r102 = Collections.unmodifiableList(r100);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        final List r103 = Collections.unmodifiableList(r101);
        return new IPagingAdapterDiffer$buildCallback$1(r102, r101, r103, this);
    }
}
