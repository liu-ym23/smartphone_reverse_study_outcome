package eab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.l;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<l> f471740j;

    @Override // v7b.s
    public final s h() {
        List<l> r100 = this.f471740j;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        s r103 = ((l) r102.next()).h();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.Image");
        r101.add((l) r103);
        goto L4
    L7:
        return new d(r101);
    }

    public d() {
        this(CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends l> r100) {
        Intrinsics.checkNotNullParameter(r100, "images");
        this.f471740j = r100;
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }
}
