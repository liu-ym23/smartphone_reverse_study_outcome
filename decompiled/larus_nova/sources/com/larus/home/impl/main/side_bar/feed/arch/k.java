package com.larus.home.impl.main.side_bar.feed.arch;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k extends DiffUtil.ItemCallback<eb9.o<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f344619a;

    public k(w r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f344619a = r100;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(eb9.o<?> r100, eb9.o<?> r101) {
        eb9.o<?> r102 = r100;
        eb9.o<?> r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (Intrinsics.areEqual(r102.getType(), r103.getType()) == true) goto L5;
        return false;
    L5:
        w r104 = this.f344619a;
        Enum<?> r105 = r102.getType();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "cardType");
        eb9.w r106 = r104.f344640a.get(r105);
        if (r106 == null) goto L8;
        eb9.v r107 = r106.a();
    L9:
        if (r107 != null) goto L12;
        r107 = eb9.a.f471852a;
    L12:
        return r107.a(r102, r103);
    L8:
        r107 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(eb9.o<?> r100, eb9.o<?> r101) {
        eb9.o<?> r102 = r100;
        eb9.o<?> r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (Intrinsics.areEqual(r102.getType(), r103.getType()) == true) goto L5;
        return false;
    L5:
        w r104 = this.f344619a;
        Enum<?> r105 = r102.getType();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "cardType");
        eb9.w r106 = r104.f344640a.get(r105);
        if (r106 == null) goto L8;
        eb9.v r107 = r106.a();
    L9:
        if (r107 != null) goto L12;
        r107 = eb9.a.f471852a;
    L12:
        return r107.b(r102, r103);
    L8:
        r107 = null;
        goto L9
    }
}
