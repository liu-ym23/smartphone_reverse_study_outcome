package com.larus.home.impl.main.side_bar.feed.arch;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements eb9.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f344599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<fb9.a> f344600b;

    @Override // eb9.u
    public final RecyclerView getRecyclerView() {
        return this.f344599a;
    }

    @Override // eb9.u
    public final <ABILITY extends fb9.a> ABILITY a(Class<ABILITY> r100) {
        Intrinsics.checkNotNullParameter(r100, "abilityClass");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        Iterator<T> r102 = this.f344600b.iterator();     // Catch: Throwable -> L12
    L5:
        if (r102.hasNext() == false) goto L10;
        fb9.a r103 = (fb9.a) r102.next();     // Catch: Throwable -> L12
        if (r100.isInstance(r103) == false) goto L5;
        return r100.cast(r103);
    L10:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Fragment r100, RecyclerView r101, List<? extends fb9.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "abilities");
        this.f344599a = r101;
        this.f344600b = r102;
    }
}
