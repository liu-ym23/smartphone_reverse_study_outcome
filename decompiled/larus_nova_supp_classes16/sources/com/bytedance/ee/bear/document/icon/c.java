package com.bytedance.ee.bear.document.icon;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ IconListFetcher a;
    public final /* synthetic */ Function1<Throwable, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(IconListFetcher r1, Function1<? super Throwable, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r5) {
        DocIconNetResult r6 = (DocIconNetResult) r5;
        if (r6.code != 0) goto L12;
        tt5.a.b("IconListFetcher", "receive icons " + r6.data);
        IconListFetcher r0 = this.a;
        Intrinsics.checkNotNull(r6);
        r0.getClass();
        ArrayList r1 = new ArrayList();
        List<DocIconNetResult.Category> r7 = ((DocIconNetResult.Data) r6.data).data;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.isEmpty() == true) goto L17;
        CollectionsKt.addAll(r1, SequencesKt.filter(SequencesKt.flatMap(SequencesKt.flatMap(CollectionsKt.asSequence(r7), IconListFetcher$consumeResult$icons$1.INSTANCE), IconListFetcher$consumeResult$icons$2.INSTANCE), IconListFetcher$consumeResult$icons$3.INSTANCE));
        Function1<? super List<? extends DocIconNetResult.Icon>, Unit> r8 = r0.b;
        if (r8 == null) goto L15;
        r8.invoke(r1);
        return;
    L15:
        return;
    L17:
        return;
    L12:
        this.b.invoke(new RuntimeException("server error: " + r6.code));
    }
}
