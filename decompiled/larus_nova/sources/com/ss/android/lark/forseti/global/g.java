package com.ss.android.lark.forseti.global;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements yua.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<yua.b> f424479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yua.b f424480b;

    @Override // yua.c
    public final yua.b a() {
        return this.f424480b;
    }

    @Override // yua.c
    public final List<yua.b> getPieces() {
        return this.f424479a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends yua.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "pieces");
        this.f424479a = r100;
        ArrayList r101 = (ArrayList) r100;
        ListIterator r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        Object r103 = r102.previous();
        if (((yua.b) r103).getFragment().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
    L9:
        this.f424480b = (yua.b) r103;
        return;
    L8:
        r103 = null;
        goto L9
    }
}
