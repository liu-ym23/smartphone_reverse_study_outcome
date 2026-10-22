package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f241753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f241754e;

    public a(WikiAction r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "err");
        super(r100);
        this.f241753d = r101;
        this.f241754e = MoveSource.FROM_OTHER.getValue();
    }
}
