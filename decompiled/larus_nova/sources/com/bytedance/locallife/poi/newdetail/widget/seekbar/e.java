package com.bytedance.locallife.poi.newdetail.widget.seekbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f263489a;

    public e() {
        this.f263489a = new ArrayList();
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.seekbar.c
    public final void a(SeekBarState.State r100, SeekBarState.State r101, SeekBarState.Action r102) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        Iterator<T> r103 = this.f263489a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).a(r100, r101, r102);
        goto L4
    }
}
