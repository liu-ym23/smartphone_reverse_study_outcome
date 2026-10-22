package com.bytedance.ee.bear.document.icon;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IconListFetcher f219989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f219990b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(IconListFetcher r100, Function1<? super Throwable, Unit> r101) {
        this.f219989a = r100;
        this.f219990b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocIconNetResult r101 = (DocIconNetResult) r100;
        if (r101.code != 0) goto L12;
        tt5.a.b("IconListFetcher", "receive icons " + r101.data);
        IconListFetcher r102 = this.f219989a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        ArrayList r103 = new ArrayList();
        List<DocIconNetResult.Category> r104 = ((DocIconNetResult.Data) r101.data).data;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.isEmpty() == true) goto L17;
        CollectionsKt.addAll(r103, SequencesKt.filter(SequencesKt.flatMap(SequencesKt.flatMap(CollectionsKt.asSequence(r104), IconListFetcher$consumeResult$icons$1.INSTANCE), IconListFetcher$consumeResult$icons$2.INSTANCE), IconListFetcher$consumeResult$icons$3.INSTANCE));
        Function1<? super List<? extends DocIconNetResult.Icon>, Unit> r105 = r102.f219963b;
        if (r105 == null) goto L15;
        r105.invoke(r103);
        return;
    L15:
        return;
    L17:
        return;
    L12:
        this.f219990b.invoke(new RuntimeException("server error: " + r101.code));
    }
}
